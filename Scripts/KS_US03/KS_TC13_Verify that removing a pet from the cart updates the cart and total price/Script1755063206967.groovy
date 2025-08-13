import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

WebUI.openBrowser('')

WebUI.navigateToUrl('https://petstore.octoperf.com/')

WebUI.click(findTestObject('Object Repository/Page_JPetStore Demo/a_Enter the Store'))

// Add the two cats to the cart
WebUI.click(findTestObject('Object Repository/Page_JPetStore Demo/img'))
WebUI.click(findTestObject('Object Repository/Page_JPetStore Demo/a_FL-DSH-01'))
WebUI.click(findTestObject('Object Repository/Page_JPetStore Demo/a_Add to Cart'))
WebUI.click(findTestObject('Object Repository/Page_JPetStore Demo/img_1'))
WebUI.click(findTestObject('Object Repository/Page_JPetStore Demo/a_FL-DSH-01'))
WebUI.click(findTestObject('Object Repository/Page_JPetStore Demo/a_Add to Cart_1'))

// Verify the current total price
String before_price = WebUI.getText(findTestObject('Object Repository/Page_JPetStore Demo/td_beforePrice'))
println("Before price: " + before_price)

// Get the price of the pet that is removed
String removed_pet_price = WebUI.getText(findTestObject('Object Repository/Page_JPetStore Demo/td_remove_pet_price'))
println("Remove pet price: " + removed_pet_price)

// Remove the pet from the cart and save the new price
WebUI.click(findTestObject('Object Repository/Page_JPetStore Demo/a_Remove'))

String after_price = WebUI.getText(findTestObject('Object Repository/Page_JPetStore Demo/td_afterPrice'))
println("After price: " + after_price)

// Remove the "$" and convert to double
double beforePriceValue = Double.parseDouble(before_price.replaceAll(/[^0-9.]/, ''))

double afterPriceValue = Double.parseDouble(after_price.replaceAll(/[^0-9.]/, ''))

double removedPetPriceValue = Double.parseDouble(removed_pet_price.replaceAll(/[^0-9.]/, ''))

// Calculate the difference and error handle
assert Math.abs((beforePriceValue - afterPriceValue) - removedPetPriceValue) < 0.001 : 
       "Price difference does not match removed pet price!"

WebUI.closeBrowser()

