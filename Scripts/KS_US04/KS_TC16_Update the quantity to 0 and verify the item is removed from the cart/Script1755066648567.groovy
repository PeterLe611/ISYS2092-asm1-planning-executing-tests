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

// Navigate and add a pet to cart
WebUI.click(findTestObject('Object Repository/Page_JPetStore Demo/img'))
WebUI.click(findTestObject('Object Repository/Page_JPetStore Demo/a_K9-RT-02'))
WebUI.click(findTestObject('Object Repository/Page_JPetStore Demo/a_Add to Cart'))

// Set the cart's item quantity to 0 and save
String empty_quantity = '0'
WebUI.setText(findTestObject('Object Repository/Page_JPetStore Demo/input_true_EST-23'), empty_quantity)
WebUI.sendKeys(findTestObject('Object Repository/Page_JPetStore Demo/input_true_EST-23'), Keys.chord(Keys.ENTER))

// Get the table WebElement from the existing TestObject
WebElement tableElement = WebUI.findWebElement(findTestObject('Object Repository/Page_JPetStore Demo/table_Item_cartItems'))

// Get all table rows except the header
List<WebElement> rows = tableElement.findElements(By.tagName('tr'))

// Assuming the table always has:
//  - 1 header row
//  - 1 subtotal row
// If only these 2 exist → cart is empty
if (rows.size() <= 2) {
	println('Cart is empty.')
} else {
	println('Cart is not empty.')
}

WebUI.closeBrowser()

