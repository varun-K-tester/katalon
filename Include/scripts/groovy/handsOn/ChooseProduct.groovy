package handsOn
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement

import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import cucumber.api.java.en.And
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When
import internal.GlobalVariable

class ChooseProduct {

	@Given("User has selected occasion")
	def verifyUserIsOnHomepage() {
		WebUI.waitForPageLoad(10)
		WebUI.verifyElementPresent(findTestObject('Object Repository/HandsOn/ChooseProducts/verifyHomepage'), 20)
	}

	@When("User navigate to menupage")
	def MenupageNav() {
		WebUI.waitForPageLoad(10)
		WebUI.click(findTestObject('Object Repository/HandsOn/ChooseProducts/Menu'))
	}

	@And("User chooses (.*) category L1")
	def categoryL1Nav(String categoryL1) {
		WebUI.waitForPageLoad(10)
		String str = "//*/img[@alt='" + categoryL1 + "']"
		println(str)
		//WebUI.waitForElementClickable(//*/img[@alt="Pizza"], 5)
		WebDriver driver = DriverFactory.getWebDriver()
		WebElement element = driver.findElement(By.xpath("//*/img[@alt='" + categoryL1 + "']"))
		element.click()
	}

	@And("User chooses (.*) category L2")
	def categoryL2Nav(String categoryL2) {
		WebUI.waitForPageLoad(10)
		GlobalVariable.L2 = categoryL2
		println(findTestObject('Object Repository/HandsOn/ChooseProducts/categoryL2'))
		WebUI.click(findTestObject('Object Repository/HandsOn/ChooseProducts/categoryL2'))
	}
	@Then("verify if product is available")
	def product_availability(){
		WebUI.waitForPageLoad(10)
		WebUI.verifyElementPresent(findTestObject('Object Repository/HandsOn/ChooseProducts/PLP_add_BTN'), 10)
	}

	@And("User chooses (.*) product")
	def productNav(String product) {
		WebUI.waitForPageLoad(10)
		WebDriver driver = DriverFactory.getWebDriver()
		WebElement element2 = driver.findElement(By.xpath('//*[contains(text(),"' + product + '")]'))
		element2.click()
	}
}