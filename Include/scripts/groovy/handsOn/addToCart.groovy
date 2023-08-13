	package handsOn
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import cucumber.api.java.en.And
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then

class addToCart {

	@Given("User is on PDP")
	def verifyUserIsOnPDP() {
		//		WebUI.verifyElementPresent(findTestObject('Object Repository/HandsOn/addtocart/startOrder'), 5)
		//		WebUI.verifyElementPresent(findTestObject('Object Repository/HandsOn/addtocart/order_quantity'), 5)
		WebUI.verifyElementClickable(findTestObject('Object Repository/HandsOn/addtocart/order_quantity'))
	}

	@And("User enters quantity:(.*)")
	def Addtocartbuttonisenabled(String quantity) {
		println("Add to cart button is enabled")
		WebUI.selectOptionByValue(findTestObject('Object Repository/HandsOn/addtocart/order_quantity'), quantity, true)
	}

	@Then("User clicks on add to cart button")
	def Userclicksonaddtocartbutton() {
		println("User clicks on add to cart button")
		WebUI.waitForElementPresent(findTestObject('Object Repository/HandsOn/addtocart/Add to Order'), 20)
		WebUI.click(findTestObject('Object Repository/HandsOn/addtocart/Add to Order'))
	}
}