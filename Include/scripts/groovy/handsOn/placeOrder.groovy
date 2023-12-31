package handsOn
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import cucumber.api.java.en.And
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When
import internal.GlobalVariable


class placeOrder {

	@Given("User has selected the products")
	def verifyUserSelectedProducts() {
		WebUI.waitForPageLoad(10)
		WebUI.verifyElementPresent(findTestObject('Object Repository/HandsOn/placeOrder/Review Checkout BTN'), 5)
	}

	@When("User navigates to cart page")
	def CartPage() {
		WebUI.waitForElementClickable(findTestObject('Object Repository/HandsOn/placeOrder/Review Checkout BTN'), 5)
		WebUI.click(findTestObject('Object Repository/HandsOn/placeOrder/Review Checkout BTN'))
		WebUI.waitForPageLoad(10)
		WebUI.verifyElementPresent(findTestObject('Object Repository/HandsOn/placeOrder/Checkout BTN'), 5)
		WebUI.verifyElementPresent(findTestObject('Object Repository/HandsOn/placeOrder/Your Order text cart page'), 5)
	}

	@And("User clicks on checkout")
	def checkoutpage() {
		
			WebUI.scrollToElement(findTestObject('Object Repository/HandsOn/placeOrder/checkoutBTN_2'),10)
			WebUI.click(findTestObject('Object Repository/HandsOn/placeOrder/checkoutBTN_2'))
			
//		if (WebUI.verifyElementPresent(findTestObject('Object Repository/HandsOn/placeOrder/checkoutBTN_2'),10)==true)
//			WebUI.click(findTestObject('Object Repository/HandsOn/placeOrder/checkoutBTN_2'))
//		else
//			WebUI.click(findTestObject('Object Repository/HandsOn/placeOrder/Checkout BTN'))

		WebUI.waitForPageLoad(10)
		WebUI.verifyElementPresent(findTestObject('Object Repository/HandsOn/placeOrder/Select Payment text checkout page'), 5)
	}

	@Then("Users places order(.*)")
	def placeorder(String paymentType) {
		WebUI.waitForPageLoad(10)

		switch(paymentType) {
			case ('giftCard'):
				String giftCardNum = findTestData('Data Files/giftCards').getValue(1,1)
				String giftCardPin = findTestData('Data Files/giftCards').getValue(2,1)
				WebUI.click(findTestObject('Object Repository/HandsOn/placeOrder/use_giftCard'))
				WebUI.sendKeys(findTestObject('Object Repository/HandsOn/placeOrder/giftCard_cardNumber'), giftCardNum)
				WebUI.sendKeys(findTestObject('Object Repository/HandsOn/placeOrder/giftCard_CardPin'), giftCardPin)
				WebUI.click(findTestObject('Object Repository/HandsOn/placeOrder/giftCard_apply'))
				break;

			case ('creditCard'):
				String creditCard_charge_temp = WebUI.getText(findTestObject('Object Repository/HandsOn/placeOrder/creditCard_charge'))
				println creditCard_charge_temp
				String creditCard_charge = creditCard_charge_temp.substring(0, creditCard_charge_temp.lastIndexOf("."))
				String subTotal_temp = WebUI.getText(findTestObject('Object Repository/HandsOn/placeOrder/subTotal_ordersummary'))
				String subTotal= subTotal_temp.substring(0,subTotal_temp.lastIndexOf("."))

			//		for(int i = 1;i < subTotal1.size() ;i++) {
			//			if (subTotal1[i].equals('.')) {
			//				break;
			//			}
			//			else {
			//				int n=0
			//				subTotal2[n] = subTotal1[i]
			//				n++
			//			}
			//		}
				println (creditCard_charge + " " + subTotal)
				int creditCard_charge_int = creditCard_charge.toInteger()
				int subTotal_int= subTotal.toInteger()
				if(subTotal_int>=15 && creditCard_charge_int >=15 ) {
					WebUI.sendKeys(findTestObject('Object Repository/HandsOn/placeOrder/cvv'), '123')
					WebUI.click(findTestObject('Object Repository/HandsOn/placeOrder/Place pickup order BTN'))
				}
				else {
					WebUI.click(findTestObject('Object Repository/HandsOn/placeOrder/Place pickup order BTN'))
				}
				break;
		}
	}

	@Then("Get order details")
	def getDetails() {
		WebUI.waitForPageLoad(10)
		WebUI.verifyElementPresent(findTestObject('Object Repository/HandsOn/placeOrder/Your Order Has been submitted Text'), 5)
		WebUI.verifyElementPresent(findTestObject('Object Repository/HandsOn/placeOrder/Order summary text page'), 5)
		WebUI.verifyElementPresent(findTestObject('Object Repository/HandsOn/placeOrder/img'), 5)
		GlobalVariable.order_Number = WebUI.getText(findTestObject('Object Repository/HandsOn/placeOrder/orderNumber'))
		println(GlobalVariable.order_Number)


	}
}