package handsOn
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import cucumber.api.java.en.And
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When

class login {
	@Given("User is on login page")
	def loginPage() {
		WebUI.verifyElementClickable(findTestObject('Object Repository/HandsOn/Login/Sign in'))
		WebUI.click(findTestObject('Object Repository/HandsOn/Login/Sign in'))
		WebUI.waitForPageLoad(10)
		WebUI.verifyElementPresent(findTestObject('Object Repository/HandsOn/Login/Sign in Header'),5)
	}
	
	@When("User enters username (\\d+)")
	def username(int rowNum) {
		WebUI.verifyElementPresent(findTestObject('Object Repository/HandsOn/Login/Email'), 5)
		WebUI.click(findTestObject('Object Repository/HandsOn/Login/Email'))
		String username = findTestData('Data Files/Login_cred').getValue(1,rowNum)
		WebUI.sendKeys(findTestObject('Object Repository/HandsOn/Login/Email'),username)
	}
	
	@And("User enters password (\\d+)")
	def password(int rowNum) {
		WebUI.verifyElementPresent(findTestObject('Object Repository/HandsOn/Login/password'),5)
		WebUI.click(findTestObject('Object Repository/HandsOn/Login/password'))
		String password = findTestData('Data Files/Login_cred').getValue(2,rowNum)
		WebUI.setEncryptedText(findTestObject('Object Repository/HandsOn/Login/password'), password)
	}
	
	@Then("User is succesfully logged in")
	def loggedIn(){
		WebUI.verifyElementClickable(findTestObject('Object Repository/HandsOn/Login/sign_in_btn'))
		WebUI.click(findTestObject('Object Repository/HandsOn/Login/sign_in_btn'))
	}
}