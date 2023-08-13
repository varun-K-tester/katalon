package handsOn
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import cucumber.api.java.en.And
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When
import internal.GlobalVariable


class Rewardpoints {
	String pointsHistory_num, transactionPage_num

	@Given("User has placed the order")
	def User_has_placed_the_order(){
		WebUI.waitForPageLoad(10)
		WebUI.verifyElementPresent(findTestObject('Object Repository/HandsOn/placeOrder/Order summary text page'), 5)
		WebUI.verifyElementPresent(findTestObject('Object Repository/HandsOn/placeOrder/img'), 5)
	}

	@When("User earned rewards points")
	def User_earned_rewards_points(){
		GlobalVariable.rewardPoints = WebUI.getText(findTestObject('Object Repository/HandsOn/placeOrder/orderPage_rewardpoints'))
		println(GlobalVariable.rewardPoints)
		if (GlobalVariable.rewardPoints == "0")
			println("user earned zero points")
		else
			println("user earned"+GlobalVariable.rewardPoints+"points")
	}

	@Then("Navigate to rewards page points history")
	def Navigate_to_rewards_page_points_history(){
		WebUI.click(findTestObject("Object Repository/HandsOn/Rewardpoints/rewardPage_link"))
		WebUI.waitForElementClickable(findTestObject('Object Repository/HandsOn/Rewardpoints/pointsHistory_link'),10)
		WebUI.click(findTestObject("Object Repository/HandsOn/Rewardpoints/pointsHistory_link"))
		WebUI.waitForPageLoad(10)
		WebUI.waitForElementPresent(findTestObject('Object Repository/HandsOn/Rewardpoints/firstPoints_pointHistory'),10)
	}

	@And ("Get reward points")
	def Get_reward_points(){
		WebUI.waitForPageLoad(10)
		pointsHistory_num = WebUI.getText(findTestObject('Object Repository/HandsOn/Rewardpoints/firstPoints_pointHistory'))
		println(pointsHistory_num)

		if(pointsHistory_num == GlobalVariable.rewardPoints)
			println("Equal")
	}

	@Then("Navigate to transaction page")
	def Navigate_to_transaction_page() {
		WebUI.waitForPageLoad(10)
		WebUI.click(findTestObject('Object Repository/HandsOn/Rewardpoints/transactionPage_link'))
		WebUI.waitForPageLoad(10)
		WebUI.verifyElementPresent(findTestObject('Object Repository/HandsOn/Rewardpoints/transactionPage_Title'), 0)
	}

	@And("Get order number and reward points")
	def Get_order_number_and_reward_points() {
		WebUI.waitForPageLoad(10)
		String transactionPage_num_temp = WebUI.getText(findTestObject('Object Repository/HandsOn/Rewardpoints/firstPoints_transaction'))
		String transactionPage_num = transactionPage_num.substring(0, transactionPage_num.lastIndexOf(" "))
		if(transactionPage_num == GlobalVariable.rewardPoints)
			println("Equal")
	}
}