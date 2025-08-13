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

// Sign in
WebUI.click(findTestObject('Object Repository/Page_JPetStore Demo/a_Sign In'))
WebUI.waitForElementVisible(findTestObject('Object Repository/Page_JPetStore Demo/input_Need a user name and password_username'), 5)
WebUI.setText(findTestObject('Object Repository/Page_JPetStore Demo/input_Need a user name and password_username'), 'test_user')
WebUI.setEncryptedText(findTestObject('Object Repository/Page_JPetStore Demo/input_Need a user name and password_password'), 
    '4nvbrPglk7k=')
WebUI.click(findTestObject('Object Repository/Page_JPetStore Demo/input_Need a user name and password_signon'))

// Add product to cart
WebUI.click(findTestObject('Object Repository/Page_JPetStore Demo/img'))
WebUI.click(findTestObject('Object Repository/Page_JPetStore Demo/a_AV-CB-01'))
WebUI.click(findTestObject('Object Repository/Page_JPetStore Demo/a_Add to Cart'))

// Set excessive quantity
WebUI.setText(findTestObject('Object Repository/Page_JPetStore Demo/input_false_EST-18'), '1000000')
WebUI.sendKeys(findTestObject('Object Repository/Page_JPetStore Demo/input_false_EST-18'), Keys.chord(Keys.ENTER))

// Proceed to checkout
WebUI.click(findTestObject('Object Repository/Page_JPetStore Demo/a_Proceed to Checkout'))
WebUI.click(findTestObject('Object Repository/Page_JPetStore Demo/input_Ship to different address_newOrder'))
WebUI.click(findTestObject('Object Repository/Page_JPetStore Demo/a_Confirm'))

// Verify error message/page
boolean errorPresent = WebUI.verifyTextPresent('HTTP Status 500', false, FailureHandling.OPTIONAL)

if (errorPresent) {
    println("PASS: Error page displayed as expected for excessive quantity.")
} else {
    println("FAIL: Error page NOT displayed. System did not handle excessive quantity as expected.")
    WebUI.takeScreenshot()
}

WebUI.closeBrowser()


