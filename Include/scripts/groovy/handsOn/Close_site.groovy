package handsOn
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When
import internal.GlobalVariable


class Close_site {
	@Given ("Order is placed by user")
	def successful() {
		WebUI.verifyElementPresent(findTestObject('Object Repository/HandsOn/placeOrder/Your Order Has been submitted Text'), 5)
	}

	@When ("All scenarios are passed")
	def condition() {
		if (GlobalVariable.numOfFails == 0){
			println("/Code executed successfully")
			println ("Passes: " + GlobalVariable.numOfPasses)
			//WebUI.navigateToUrl('https://www.mediawiki.org/wiki/Special:Contributions/')
			//WebUI.closeWindowIndex(1)
			WebUI.closeBrowser()
		}
		else {
			println( GlobalVariable.numOfFails + " test cases failed. Look into code")
		}
	}

	@Then("close the caseys site")
	def closeSite(){
		println ("Passes: " + GlobalVariable.numOfPasses)
		println( GlobalVariable.numOfFails + " test cases failed. Look into code")
	}
}