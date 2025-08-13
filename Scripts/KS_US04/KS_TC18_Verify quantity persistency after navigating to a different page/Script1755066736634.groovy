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

// Add the pet to the cart
WebUI.click(findTestObject('Object Repository/Page_JPetStore Demo/img'))
WebUI.click(findTestObject('Object Repository/Page_JPetStore Demo/a_AV-SB-02'))
WebUI.click(findTestObject('Object Repository/Page_JPetStore Demo/a_Add to Cart'))

// Change the quantity amount and save it
WebUI.setText(findTestObject('Object Repository/Page_JPetStore Demo/input_false_EST-19'), '1000')
WebUI.sendKeys(findTestObject('Object Repository/Page_JPetStore Demo/input_false_EST-19'), Keys.chord(Keys.ENTER))

// Store the quantity before navigation
String beforeQuantity = WebUI.getAttribute(findTestObject('Object Repository/Page_JPetStore Demo/input_false_EST-19'), 'value')

// Navigate to the home page
WebUI.click(findTestObject('Object Repository/Page_JPetStore Demo/img_1'))

// Re-navigate to the cart
WebUI.click(findTestObject('Object Repository/Page_JPetStore Demo/img_Sign In_img_cart'))

// Get the quantity after navigation
String afterQuantity = WebUI.getAttribute(findTestObject('Object Repository/Page_JPetStore Demo/input_false_EST-19'), 'value')

// Verify the quantity remains the same
WebUI.verifyEqual(beforeQuantity, afterQuantity, FailureHandling.STOP_ON_FAILURE)

WebUI.closeBrowser()

