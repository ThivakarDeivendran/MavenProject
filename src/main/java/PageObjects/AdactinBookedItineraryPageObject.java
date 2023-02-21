package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdactinBookedItineraryPageObject {
	
	public WebDriver AdactinBookedItinerarydriver;
	
	public AdactinBookedItineraryPageObject(WebDriver localadactinBookedItinerary) {
		this.AdactinBookedItinerarydriver =localadactinBookedItinerary;
		PageFactory.initElements(localadactinBookedItinerary, this);
	}
	
	@FindBy(xpath="//input[@id='order_id_text']")
	private WebElement searchOrderIdTextBox;
	
	@FindBy(css="input[id='search_hotel_id']")
	private WebElement goButton;
	
	@FindBy(xpath="//form/table/tbody/tr[2]/td/table/tbody/tr[2]/td[1]/input")
	private WebElement bookedItineraryCheckBox;
	
	@FindBy(css="input[name='cancelall']")
	private WebElement cancelSelectedButton;
	
	@FindBy (xpath="//input[@id='search_hotel']")
	private WebElement searchHotelButton;
	
	@FindBy(css="#logout")
	private WebElement logoutButton;

	public WebElement getSearchOrderIdTextBox() {
		return searchOrderIdTextBox;
	}

	public WebElement getGoButton() {
		return goButton;
	}

	public WebElement getBookedItineraryCheckBox() {
		return bookedItineraryCheckBox;
	}

	public WebElement getCancelSelectedButton() {
		return cancelSelectedButton;
	}

	public WebElement getSearchHotelButton() {
		return searchHotelButton;
	}

	public WebElement getLogoutButton() {
		return logoutButton;
	}
	
	

}
