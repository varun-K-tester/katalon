import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory as CheckpointFactory
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as MobileBuiltInKeywords
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testcase.TestCaseFactory as TestCaseFactory
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testdata.TestDataFactory as TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository as ObjectRepository
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WSBuiltInKeywords
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUiBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

WebUI.openBrowser('')

WebUI.navigateToUrl('https://stage.caseys.com/c/menu')

WebUI.click(findTestObject('Object Repository/Practice/test/Page_Caseys Pizza Near You  Caseys General Store/h5_Single Topping'))

WebUI.click(findTestObject('Object Repository/Practice/test/Page_Caseys Single Topping Near You  Caseys_6ceb0e/span_Start Order'))

WebUI.click(findTestObject('Object Repository/Practice/test/Page_Caseys Single Topping Near You  Caseys_6ceb0e/button_Pickup Pickup'))

WebUI.setText(findTestObject('Object Repository/Practice/test/Page_Caseys Single Topping Near You  Caseys_6ceb0e/input_Enter your delivery address_address'), 
    'linton')

WebUI.click(findTestObject('Object Repository/Practice/test/Page_Caseys Single Topping Near You  Caseys_6ceb0e/span_Start Order_1'))

WebUI.click(findTestObject('Object Repository/Practice/test/Page_Caseys Single Topping Near You Order C_01d059/h3_Sausage Pizza'))

WebUI.selectOptionByValue(findTestObject('Object Repository/Practice/test/Page_Casey Sausage Pizza - Carryout  Caseys_974d95/select_Sausage Pizza_FoodItemTypeSelector33'), 
    'notApplicable', true)

WebUI.click(findTestObject('Object Repository/Practice/test/Page_Casey Sausage Pizza - Carryout  Caseys_974d95/span_'))

WebUI.closeBrowser()

