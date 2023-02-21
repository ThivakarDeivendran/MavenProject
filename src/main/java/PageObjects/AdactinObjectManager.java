package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class AdactinObjectManager {

	public  WebDriver driver;
	private AdactinhotelLoginPageObject loginPage;
	private WelcomeToAdactinGroupPageObject welcomePage;
	private AdactinSearchHotelPageObject searchHotelPage;
	private AdactinBookAHotelPageObject bookAHotelPage;
	private AdactinBookingConfirmationPageObject bookingConfirmationPage;
	private AdactinBookedItineraryPageObject bookedItineraryPage;
	
	public AdactinObjectManager(WebDriver localdriver) {
		this.driver = localdriver;
		PageFactory.initElements(localdriver, this);
	}
	
	public AdactinhotelLoginPageObject getLoginPage() {
		loginPage = new AdactinhotelLoginPageObject(driver);
		return loginPage;
	}
	
	public WelcomeToAdactinGroupPageObject getWelcomePage() {
		welcomePage = new WelcomeToAdactinGroupPageObject(driver);
		return welcomePage;
	}
	
	public AdactinSearchHotelPageObject getsearchHotelPage() {
		searchHotelPage = new AdactinSearchHotelPageObject(driver);
		return searchHotelPage;
	}
	
	public AdactinBookAHotelPageObject getBookAHotelPage() {
     bookAHotelPage = new AdactinBookAHotelPageObject(driver);
     return bookAHotelPage;
	
	}
	
	public AdactinBookingConfirmationPageObject getBookingConfirmationPage() {
		bookingConfirmationPage = new AdactinBookingConfirmationPageObject(driver);
		return bookingConfirmationPage;
	}
	
	public AdactinBookedItineraryPageObject getBookedItineraeyPage() {
		bookedItineraryPage = new AdactinBookedItineraryPageObject(driver);
		return bookedItineraryPage;
	}
	
	
	
	
}
