package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class SkyWhiteBackgroundPage {
	WebDriver driver;
	
	public SkyWhiteBackgroundPage(WebDriver driver) {
		this.driver = driver;
	}

	// Element Library
	@FindBy(how = How.XPATH, using = "//button[contains(text(),'Set White Background')]")
	WebElement WHITE_BUTTON_ELEMENT;//"//*[@id='extra']/button[2]"
	@FindBy(how = How.XPATH, using = "//body")
	WebElement BACKGROUND_ELEMENT;
	
	public boolean verifybuttonExist() {
		return WHITE_BUTTON_ELEMENT.isDisplayed();
	}

	public void clickWhiteButton() {
		WHITE_BUTTON_ELEMENT.click();
	}

	public String verifyBGcolorChange() {
		String allCssProperties = BACKGROUND_ELEMENT.getAttribute("style");// getAttribute() will give all css
																			// properties(name=value) of that attribute.
		String oneCssValue = BACKGROUND_ELEMENT.getCssValue("background-color");// getcssvalue() will give particular
																				// value assosiated with that css name.
		System.out.println(allCssProperties);
		System.out.println(oneCssValue);
		return allCssProperties;

	}

}
