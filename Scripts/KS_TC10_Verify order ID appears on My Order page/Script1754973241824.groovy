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
import com.kms.katalon.core.util.KeywordUtil

WebUI.openBrowser('')

WebUI.navigateToUrl('https://petstore.octoperf.com/')

WebUI.click(findTestObject('Object Repository/Page_JPetStore Demo/a_Enter the Store'))

// Sign in
WebUI.click(findTestObject('Object Repository/Page_JPetStore Demo/a_Sign In'))
WebUI.setText(findTestObject('Object Repository/Page_JPetStore Demo/input_Need a user name and password_username'), 'test_user')
WebUI.setEncryptedText(findTestObject('Object Repository/Page_JPetStore Demo/input_Need a user name and password_password'), 
    '4nvbrPglk7k=')
WebUI.click(findTestObject('Object Repository/Page_JPetStore Demo/input_Need a user name and password_signon'))

// Create a full order and checkout process
WebUI.click(findTestObject('Object Repository/Page_JPetStore Demo/img'))
WebUI.click(findTestObject('Object Repository/Page_JPetStore Demo/a_AV-CB-01'))
WebUI.click(findTestObject('Object Repository/Page_JPetStore Demo/a_Add to Cart'))
WebUI.click(findTestObject('Object Repository/Page_JPetStore Demo/a_Proceed to Checkout'))
WebUI.click(findTestObject('Object Repository/Page_JPetStore Demo/input_Ship to different address_newOrder'))
WebUI.click(findTestObject('Object Repository/Page_JPetStore Demo/a_Confirm'))

// Verify the order ID appears in the My Orders page
String fullOrderID = WebUI.getText(findTestObject('Object Repository/Page_JPetStore Demo/th_fullOrderID'))

WebUI.click(findTestObject('Object Repository/Page_JPetStore Demo/a_My Account'))
WebUI.click(findTestObject('Object Repository/Page_JPetStore Demo/a_My Orders'))
WebUI.click(findTestObject('Object Repository/Page_JPetStore Demo/html_JPetStore Demokatalonfont-familymonosp_d5f3d0'))

String orderID = WebUI.getText(findTestObject('Object Repository/Page_JPetStore Demo/td_newestOrderID'))

// Assert that the substring exists
if (fullOrderID.contains(orderID)) {
	println("Test Passed: '${orderID}' is found in '${fullOrderID}'")
} else {
	KeywordUtil.markFailed("❌ Test Failed: '${orderID}' was NOT found in '${fullOrderID}'")
}

WebUI.closeBrowser()

