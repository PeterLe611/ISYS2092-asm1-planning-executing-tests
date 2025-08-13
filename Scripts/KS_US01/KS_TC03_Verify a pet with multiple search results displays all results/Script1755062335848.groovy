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

// Search for 'o'
String searchTerm = 'o'
WebUI.setText(findTestObject('Object Repository/Page_JPetStore Demo/input__keyword'), searchTerm)
WebUI.click(findTestObject('Object Repository/Page_JPetStore Demo/input__searchProducts'))

// Find all product name cells in the search results table
// Create a TestObject in Katalon with XPath:
List<WebElement> productCells = WebUI.findWebElements(findTestObject('Object Repository/Page_JPetStore Demo/td_ProductNames'), 5)

// Verify each product name contains 'o'
boolean allMatch = true
for (WebElement cell : productCells) {
    String productName = cell.getText()
    if (!productName.toLowerCase().contains(searchTerm)) {
        println("FAIL: Product name does not contain '${searchTerm}': " + productName)
        allMatch = false
    } else {
        println("PASS: " + productName)
    }
}

// Final assertion
assert allMatch : "Some product names did not contain '${searchTerm}'"

WebUI.closeBrowser()

