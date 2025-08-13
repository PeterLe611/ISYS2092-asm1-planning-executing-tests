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

// Open browser and navigate
WebUI.openBrowser('')
WebUI.navigateToUrl('https://petstore.octoperf.com/')
WebUI.click(findTestObject('Object Repository/Page_JPetStore Demo/a_Enter the Store'))

// Set search keyword dynamically
String petName = 'poodle'
WebUI.setText(findTestObject('Object Repository/Page_JPetStore Demo/input__keyword'), petName)
WebUI.sendKeys(findTestObject('Object Repository/Page_JPetStore Demo/input__keyword'), Keys.chord(Keys.ENTER))

// Verify dynamic element
WebUI.verifyElementPresent(findTestObject('Object Repository/Page_JPetStore Demo/td_petName', [('petName') : petName]), 10)

// Close browser
WebUI.closeBrowser()



