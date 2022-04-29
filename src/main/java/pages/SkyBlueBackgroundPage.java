package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class SkyBlueBackgroundPage {
	WebDriver driver;

	public SkyBlueBackgroundPage(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(how = How.XPATH, using = "//button[contains(text(),'Set SkyBlue Background')]")
	WebElement SKYBLUE_BUTTON_ELEMENT;// *[@id="extra"]/button[1]
	@FindBy(how = How.XPATH, using = " //body")
	WebElement BACKGROUND_ELEMENT;

	public boolean verifybuttonExist() {
		return SKYBLUE_BUTTON_ELEMENT.isDisplayed() && SKYBLUE_BUTTON_ELEMENT.isEnabled();
	}

	public void clickSkyBlueButton() {
		SKYBLUE_BUTTON_ELEMENT.click();
	}

	public String verifyBGcolorChange() {
		String allCssProperties = BACKGROUND_ELEMENT.getAttribute("style");// getAttribute() will give all css
																			// properties(name=value) of that attribute.
		String oneCssValue = BACKGROUND_ELEMENT.getCssValue("background-color");// getcssvalue() will give particula
																				// value assosiated with that css name.

		// String hex = Color.fromString(oneCssValue).asHex();
		// return hex;(return this "#87ceeb" for blue,"#ffffff" for white)
		System.out.println(allCssProperties);
		System.out.println(oneCssValue);
		return allCssProperties;

	}

}
