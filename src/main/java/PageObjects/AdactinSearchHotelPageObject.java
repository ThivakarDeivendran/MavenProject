package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdactinSearchHotelPageObject {
	
	public WebDriver adactinSearchHotelDriver;
	
	public AdactinSearchHotelPageObject(WebDriver localWebDriver) {
		this.adactinSearchHotelDriver=localWebDriver;
		PageFactory.initElements(localWebDriver, this);
	}
	
	
	@FindBy(xpath="//input[@id='radiobutton_0']")
	private WebElement adactinSearchHotelRadioButton;
	
	
	@FindBy(xpath="//input[@id='continue']")
	private WebElement  adactinSearchHotelContinueButton;

	public WebElement getAdactinSearchHotelRadioButton() {
		return adactinSearchHotelRadioButton;
	}

	public WebElement getAdactinSearchHotelContinueButton() {
		return adactinSearchHotelContinueButton;
	}

}
