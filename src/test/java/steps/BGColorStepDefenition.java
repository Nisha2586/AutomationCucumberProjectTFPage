package steps;

import org.junit.Assert;
import org.openqa.selenium.support.PageFactory;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.SkyBlueBackgroundPage;
import pages.SkyWhiteBackgroundPage;
import pages.TestBase;

public class BGColorStepDefenition extends TestBase {
	SkyBlueBackgroundPage skyBlueBackgroundPage;
	SkyWhiteBackgroundPage skyWhiteBackgroundPage;
	boolean val;

	@Before
	public void beforeRun() {
		initDriver();
		skyBlueBackgroundPage = PageFactory.initElements(driver, SkyBlueBackgroundPage.class);
		skyWhiteBackgroundPage = PageFactory.initElements(driver, SkyWhiteBackgroundPage.class);
	}

	@Given("^User should be on TechFios Page$")
	public void user_should_be_on_TechFios_Page() throws Throwable {
		driver.get("https://techfios.com/test/101/index.php");
	}

	@Given("^Verify \"([^\"]*)\" Button exists$")
	public void verify_Button_exists(String Button) throws Throwable {
		switch (Button) {
		case "setskybluebg":
			val = skyBlueBackgroundPage.verifybuttonExist();
			break;
		case "setWhitebg":
			val = skyWhiteBackgroundPage.verifybuttonExist();
			break;
		default:
			System.out.println(Button + " Button Does not exist.");
		}
	}

	@When("^User clicks \"([^\"]*)\" Button$")
	public void user_clicks_Button(String Button) throws Throwable {
		switch (Button) {
		case "setskybluebackground":
			if (val == true) {
				skyBlueBackgroundPage.clickSkyBlueButton();
			}
			break;
		case "setwhitebackground":
			if (val == true) {
				skyWhiteBackgroundPage.clickWhiteButton();
			}
			break;
		default: {
			System.out.println(Button + " :Button Does not exist.");
		}
		}

	}

	@Then("^Background color will change to skyblue$")
	public void background_color_will_change_to_skyblue() throws Throwable {
		String actualBGBolor = skyBlueBackgroundPage.verifyBGcolorChange();
		String expectedAttribute = "background-color: skyblue;";
		Assert.assertEquals(expectedAttribute, actualBGBolor);
	}

	@Then("^Background color will change to skywhite$")
	public void background_color_will_change_to_skywhite() throws Throwable {
		String actualBGBolor = skyWhiteBackgroundPage.verifyBGcolorChange();
		String expectedAttribute = "background-color: white;";
		Assert.assertEquals(expectedAttribute, actualBGBolor);
	}

	@After
	public static void tearDown() {
		driver.close();
		driver.quit();
	}

}
