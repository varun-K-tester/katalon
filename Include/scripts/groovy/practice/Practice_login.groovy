package practice
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable

import org.openqa.selenium.WebElement
import org.openqa.selenium.WebDriver
import org.openqa.selenium.By

import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.webui.driver.DriverFactory

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObjectProperty

import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper
import com.kms.katalon.core.util.KeywordUtil

import com.kms.katalon.core.webui.exception.WebElementNotFoundException

import cucumber.api.java.en.And
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When

class Practice_login {
	@Given("User is navigated to login page")
	def naviagtedToLoginPage(){
		println("/nUser is navigated to login page")
		WebUI.openBrowser('')
		WebUI.navigateToUrl('https://www.saucedemo.com/')
	}
	@When ("User enters (.*) and (.*)")
	def enterCredentials(String username, String password){
		println("/nUser enters valid credentials")
		println("/n username: "+username)
		WebUI.setText(findTestObject('Object Repository/Practice/UserName'), username)
		println("/n password: "+password)
		WebUI.setEncryptedText(findTestObject('Object Repository/Practice/password'), password)
	}
	@And ("Clicks on login button")
	def loginButtonClicked(){
		println("/nUser clicks on login button")
		WebUI.click(findTestObject('Object Repository/Practice/Login_button'))
	}
	@Then ("User is navigated to homepage")
	def verifyHomepage(){
		println("/nUser is navigated to Homepage")
		WebUI.verifyElementPresent(findTestObject('Object Repository/Practice/Verification_Object'), 5)
	}
	@Then ("Close Browser")
	def closeBrowser(){
		println("/nBrowser is closed")
		WebUI.closeBrowser()
	}
}