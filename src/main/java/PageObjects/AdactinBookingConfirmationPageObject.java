package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AdactinBookingConfirmationPageObject {
	
	public WebDriver adactinBookingConfirmationdriver;
	
	public AdactinBookingConfirmationPageObject(WebDriver localadactinBookingConfirmation) {
		this.adactinBookingConfirmationdriver=localadactinBookingConfirmation;
		PageFactory.initElements(localadactinBookingConfirmation, this);
	}
	@FindBy(how=How.XPATH,xpath="//input[@id='order_no']")
	private WebElement bookingConfirmationOrderNo;

	@FindBy(css="#my_itinerary")
	private WebElement myItineraryButton;
	
	@FindBy(css="input[id='search_hotel']")
	private WebElement searchHotelButton;
	
	
	public String getBookingConfirmationOrderNo() {
		return bookingConfirmationOrderNo.getAttribute("value");
	}

	public WebElement getMyItineraryButton() {
		return myItineraryButton;
	}

	public WebElement getSearchHotelButton() {
		return searchHotelButton;
	}
	
	
}
