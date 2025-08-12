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

// Sign in to account
WebUI.click(findTestObject('Object Repository/Page_JPetStore Demo/a_Sign In'))
WebUI.setText(findTestObject('Object Repository/Page_JPetStore Demo/input_Need a user name and password_username_1'), 'test_user')
WebUI.setEncryptedText(findTestObject('Object Repository/Page_JPetStore Demo/input_Need a user name and password_password'), 
    '4nvbrPglk7k=')
WebUI.click(findTestObject('Object Repository/Page_JPetStore Demo/input_Need a user name and password_signon'))

// Add the first animal
WebUI.click(findTestObject('Object Repository/Page_JPetStore Demo/img'))
WebUI.click(findTestObject('Object Repository/Page_JPetStore Demo/a_K9-PO-02'))
WebUI.click(findTestObject('Object Repository/Page_JPetStore Demo/a_Add to Cart'))
// Add the second animal
WebUI.click(findTestObject('Object Repository/Page_JPetStore Demo/img_1'))
WebUI.click(findTestObject('Object Repository/Page_JPetStore Demo/a_FI-SW-01'))
WebUI.click(findTestObject('Object Repository/Page_JPetStore Demo/a_Add to Cart_1'))

// Proceed to checkout the multiple pets
WebUI.click(findTestObject('Object Repository/Page_JPetStore Demo/a_Proceed to Checkout'))
WebUI.click(findTestObject('Object Repository/Page_JPetStore Demo/input_Ship to different address_newOrder'))
WebUI.click(findTestObject('Object Repository/Page_JPetStore Demo/a_Confirm'))

// Verify the pets identity
WebUI.doubleClick(findTestObject('Object Repository/Page_JPetStore Demo/td_Male PuppyPoodle'))
WebUI.doubleClick(findTestObject('Object Repository/Page_JPetStore Demo/td_LargeAngelfish'))
WebUI.doubleClick(findTestObject('Object Repository/Page_JPetStore Demo/th_totalAfterMultipleOrders'))
WebUI.doubleClick(findTestObject('Object Repository/Page_JPetStore Demo/li_Thank you, your order has been submitted'))

WebUI.closeBrowser()

