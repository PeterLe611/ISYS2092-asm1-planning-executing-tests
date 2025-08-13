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

// Add a pet to the cart
WebUI.click(findTestObject('Object Repository/Page_JPetStore Demo/img'))
WebUI.click(findTestObject('Object Repository/Page_JPetStore Demo/a_K9-RT-02'))
WebUI.click(findTestObject('Object Repository/Page_JPetStore Demo/a_Add to Cart_1'))

// Update the quantity to 9999
WebUI.setText(findTestObject('Object Repository/Page_JPetStore Demo/input_true_EST-23'), '9999')
WebUI.sendKeys(findTestObject('Object Repository/Page_JPetStore Demo/input_true_EST-23'), Keys.chord(Keys.ENTER))
// Save the current price
double quantity = 9999
String before_price = WebUI.getText(findTestObject('Object Repository/Page_JPetStore Demo/td_singleQuantityPrice'))

// Save the new price and calculate the difference
String after_price = WebUI.getText(findTestObject('Object Repository/Page_JPetStore Demo/td_largeQuantityPrice'))

// Remove the "$" and convert to double
double beforePriceValue = Double.parseDouble(before_price.replaceAll(/[^0-9.]/, ''))

double afterPriceValue = Double.parseDouble(after_price.replaceAll(/[^0-9.]/, ''))

double quotient_check = afterPriceValue/beforePriceValue

assert quotient_check == quantity : "The total price doesn't match the quantity added to the cart"

WebUI.closeBrowser()

