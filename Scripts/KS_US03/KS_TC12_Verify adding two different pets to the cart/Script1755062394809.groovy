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
// Custom import to verify pets in the cart
import org.openqa.selenium.By
import org.openqa.selenium.WebElement
import com.kms.katalon.core.webui.driver.DriverFactory

WebUI.openBrowser('')

WebUI.navigateToUrl('https://petstore.octoperf.com/')

WebUI.click(findTestObject('Object Repository/Page_JPetStore Demo/a_Enter the Store'))

// Add the necessary animals to cart
WebUI.click(findTestObject('Object Repository/Page_JPetStore Demo/img'))
WebUI.click(findTestObject('Object Repository/Page_JPetStore Demo/a_FL-DSH-01'))
WebUI.click(findTestObject('Object Repository/Page_JPetStore Demo/a_Add to Cart'))
WebUI.click(findTestObject('Object Repository/Page_JPetStore Demo/img_1'))
WebUI.click(findTestObject('Object Repository/Page_JPetStore Demo/a_FL-DSH-01'))
WebUI.click(findTestObject('Object Repository/Page_JPetStore Demo/a_Add to Cart_1'))

// Expected test data
List<String> itemIds = ["EST-14", "EST-15"]
List<String> expectedNames = ["Tailless Manx", "With tail Manx"]
List<String> expectedPrices = ['$58.50', '$23.50']

// Get the table WebElement from the existing TestObject
WebElement tableElement = WebUI.findWebElement(findTestObject('Object Repository/Page_JPetStore Demo/table_Item_cartItems'))

// Get all table rows except the header
List<WebElement> rows = tableElement.findElements(By.tagName("tr"))
rows = rows.subList(1, rows.size()) // remove header row

// Loop through and verify each row's data, if any data doesn't match the expected/test data, then it fails
for (int i = 0; i < itemIds.size(); i++) {
	List<WebElement> cells = rows[i].findElements(By.tagName("td"))
	
	String actualId = cells[0].getText().trim()
	String actualName = cells[2].getText().trim()
	String actualPrice = cells[5].getText().trim()
	
	WebUI.verifyMatch(actualId, itemIds[i], false)
	WebUI.verifyMatch(actualName, expectedNames[i], false)
	WebUI.verifyMatch(actualPrice, expectedPrices[i], false)
}

WebUI.closeBrowser()

