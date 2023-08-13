package handsOn
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import org.openqa.selenium.Keys
import cucumber.api.java.en.And
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then



class occasion_Selection {
	@Given("User is on homepage")
	def verifyUserIsOnHomepage(){
		WebUI.waitForPageLoad(10)
		WebUI.verifyElementPresent(findTestObject('Object Repository/HandsOn/ChooseProducts/verifyHomepage'), 20)
	}
	@And("User has logged into site")
	def verifyUserisloggedin(){
		WebUI.verifyElementPresent(findTestObject('Object Repository/HandsOn/Occasion_selected/logged_in_validation'),10)
		WebUI.verifyElementNotPresent(findTestObject('Object Repository/HandsOn/Login/Sign in'), 10)
	}
	@Then("User selects (.*) (.*)")
	def locationSelection(String date, occasion){
		if(WebUI.verifyElementNotPresent(findTestObject('Object Repository/HandsOn/Occasion_selected/already_selected'),10, FailureHandling.OPTIONAL) == false && WebUI.verifyElementNotPresent(findTestObject('Object Repository/HandsOn/addtocart/selectedOccasion'),10, FailureHandling.OPTIONAL) == false || WebUI.verifyElementPresent(findTestObject('Object Repository/HandsOn/addtocart/Pickup_occasion'),10, FailureHandling.OPTIONAL) == false || WebUI.verifyElementPresent(findTestObject('Object Repository/HandsOn/addtocart/delivery_occasion'),10, FailureHandling.OPTIONAL) == false){
			WebUI.verifyElementPresent(findTestObject('Object Repository/HandsOn/Occasion_selected/already_selected'),10)
		}
		else {
			switch(occasion) {
				case('pickup'):
					WebUI.click(findTestObject('Object Repository/HandsOn/addtocart/Pickup_occasion'))
				//WebUI.sendKeys(findTestObject('Object Repository/HandsOn/addtocart/Address_TextBar'),location)
					String location1 = findTestData('Data Files/StoreAddress').getValue(2,3)
					WebUI.sendKeys(findTestObject('Object Repository/HandsOn/addtocart/Address_TextBar'),location1)
					WebUI.sendKeys(findTestObject('Object Repository/HandsOn/addtocart/Address_TextBar'), Keys.chord(Keys.ARROW_DOWN, Keys.ENTER))
					break;
				case('delivery'):
					WebUI.click(findTestObject('Object Repository/HandsOn/addtocart/delivery_occasion'))
				//WebUI.sendKeys(findTestObject('Object Repository/HandsOn/addtocart/Address_TextBar'),location)
					String location1 = findTestData('Data Files/StoreAddress').getValue(2,1)
					WebUI.sendKeys(findTestObject('Object Repository/HandsOn/addtocart/Address_TextBar'),location1)

					WebUI.sendKeys(findTestObject('Object Repository/HandsOn/addtocart/Address_TextBar'), Keys.chord(Keys.ARROW_DOWN, Keys.ENTER))
			}

			switch(date){
				case('asap'):
					WebUI.selectOptionByIndex(findTestObject('Object Repository/HandsOn/addtocart/date'), '0')

					break;
				case('later_today'):
					WebUI.selectOptionByIndex(findTestObject('Object Repository/HandsOn/addtocart/date'), '1')
					WebUI.selectOptionByIndex(findTestObject('Object Repository/HandsOn/addtocart/Time'), '2')

					break;
				case('tomorrow'):
					WebUI.selectOptionByIndex(findTestObject('Object Repository/HandsOn/addtocart/date'), '2')
					WebUI.selectOptionByIndex(findTestObject('Object Repository/HandsOn/addtocart/Time'), '8')
					break;
			}
			WebUI.click(findTestObject('Object Repository/HandsOn/addtocart/button_Start Order'))
		}
	}
}