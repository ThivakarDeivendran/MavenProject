package PageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AdactinBookAHotelPageObject {

	public WebDriver adactinBookAHotelDriver;

	public AdactinBookAHotelPageObject(WebDriver localAdactinBookAHotel) {
		this.adactinBookAHotelDriver = localAdactinBookAHotel;
		PageFactory.initElements(localAdactinBookAHotel, this);
	}

	@FindBy(how = How.XPATH, xpath = "//*[@id='first_name']")
	private WebElement firstNameTextbox;

	@FindBy(how = How.CSS, css = "#last_name")
	private WebElement lastNameTextbox;

	@FindBy(how = How.CSS, css = ".txtarea")
	private WebElement billingAddressTextBox;

	@FindBy(css = "input[id='cc_num']")
	private WebElement creditCardNoTextBox;

	@FindBy(xpath = "//select[@name='cc_type']/option")
	private List<WebElement> creditCardTypeDropdown;

	@FindBy(xpath = "//select[@id='cc_exp_month']/option")
	private List<WebElement> expiryDateMonthDropDown;

	@FindBy(xpath = "//select[@id='cc_exp_year']/option")
	private List<WebElement> expiryDateYearDropDown;

	@FindBy(css = "input[name='cc_cvv']")
	private WebElement cvvNumberTextBox;

	@FindBy(css = "*[id='book_now']")
	private WebElement bookNowButton;

	@FindBy(id = "cancel")
	private WebElement bookCancelButton;

	@FindBy(xpath = "//label[@id='process_span']")
	private WebElement processMessageText;

	public WebElement getFirstNameTextbox() {
		return firstNameTextbox;
	}

	public WebElement getLastNameTextbox() {
		return lastNameTextbox;
	}

	public WebElement getBillingAddressTextBox() {
		return billingAddressTextBox;
	}

	public WebElement getCreditCardNoTextBox() {
		return creditCardNoTextBox;
	}

	public List<WebElement> getCreditCardTypeDropdown() {
		return creditCardTypeDropdown;
	}

	public List<WebElement> getExpiryDateMonthDropDown() {
		return expiryDateMonthDropDown;
	}

	public List<WebElement> getExpiryDateYearDropDown() {
		return expiryDateYearDropDown;
	}

	public WebElement getCvvNumberTextBox() {
		return cvvNumberTextBox;
	}

	public WebElement getBookNowButton() {
		return bookNowButton;
	}

	public WebElement getBookCancelButton() {
		return bookCancelButton;
	}

	public WebElement getProcessMessageText() {
		return processMessageText;
	}

}
