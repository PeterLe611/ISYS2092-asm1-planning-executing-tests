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

// Search for the pet
WebUI.setText(findTestObject('Object Repository/Page_JPetStore Demo/input__keyword'), 'Golden Retriever')

// Logs/Saves the start time
long startTime = System.currentTimeMillis()

WebUI.click(findTestObject('Object Repository/Page_JPetStore Demo/input__searchProducts'))

// Wait to the element to be visible - testing response time
WebUI.waitForElementVisible(findTestObject('Object Repository/Page_JPetStore Demo/td_Golden Retriever'), 3)
long endTime = System.currentTimeMillis()
long elapsedTime = endTime - startTime
	
// Print out UI response time and assert that the elapsed time MUST BE less than 3 seconds
println("UI response time: " + elapsedTime)
assert elapsedTime <= 3000 : "Response took longer than 3 seconds!"

//WebUI.click(findTestObject('Object Repository/Page_JPetStore Demo/td_Golden Retriever_1'))

//WebUI.click(findTestObject('Object Repository/Page_JPetStore Demo/td_Labrador Retriever'))

WebUI.closeBrowser()

