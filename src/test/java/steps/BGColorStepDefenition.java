package steps;

import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.support.PageFactory;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import pages.SkyBlueBackgroundPage;
import pages.SkyWhiteBackgroundPage;
import pages.TestBase;

public class BGColorStepDefenition extends TestBase{
	SkyBlueBackgroundPage skyBlueBackgroundPage;
	SkyWhiteBackgroundPage skyWhiteBackgroundPage;
	boolean val;
		
		@Before
		public void beforeRun() {
			initDriver();
			skyBlueBackgroundPage=PageFactory.initElements(driver, SkyBlueBackgroundPage.class);
			skyWhiteBackgroundPage=PageFactory.initElements(driver, SkyWhiteBackgroundPage.class);
		}
		
		@Given("^User should be on TechFios Page$")
		public void user_should_be_on_TechFios_Page() throws Throwable {
			driver.get("https://techfios.com/test/101/index.php");
		}

		@Given("^Verify setskybluebg Button exist$")
		public void verify_setskybluebg_Button_exist() throws Throwable {
		 val=skyBlueBackgroundPage.verifybuttonExist();
			Assert.assertEquals(true, val);
			System.out.println("Button Exist.");
		}

		@Given("^Verify setWhitebg Button exist$")
		public void verify_setWhitebg_Button_exist() throws Throwable {
			 val=skyWhiteBackgroundPage.verifybuttonExist();
				Assert.assertEquals(true, val);
				System.out.println("Button Exist.");
		}

		@When("^User clicks setskybluebackground Button$")
		public void user_clicks_setskybluebackground_Button() throws Throwable {
			skyBlueBackgroundPage.clickSkyBlueButton();
		}

		@Then("^Background color will change to skyblue$")
		public void background_color_will_change_to_skyblue() throws Throwable {
			String actualBGBolor =skyBlueBackgroundPage.verifyBGcolorChange();
			String expectedAttribute = "background-color: skyblue;";
			Assert.assertEquals(expectedAttribute, actualBGBolor);
		}

		@When("^User clicks setwhitebackground Button$")
		public void user_clicks_setwhitebackground_Button() throws Throwable {
			skyWhiteBackgroundPage.clickWhiteButton();
		}

		@Then("^Background color will change to skywhite$")
		public void background_color_will_change_to_skywhite() throws Throwable {
			String actualBGBolor =skyWhiteBackgroundPage.verifyBGcolorChange();
			String expectedAttribute = "background-color: skyblue;";
			Assert.assertEquals(expectedAttribute, actualBGBolor);
		}

}
