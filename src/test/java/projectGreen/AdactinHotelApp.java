package projectGreen;

import java.io.IOException;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.MavenProjectClass.BaseClass;
import PageObjects.AdactinObjectManager;
import PageObjects.AdactinhotelLoginPageObject;

@Listeners(com.MavenProjectClass.ListenersClass.class)
public class AdactinHotelApp extends BaseClass{
	public static AdactinhotelLoginPageObject adactinhotalloginpageobject;
	public static WebDriver hotelbooking;
	public static AdactinObjectManager adactinObjectHome; 
	public static String bookingId;
	public static Logger logger;
	
	@BeforeClass
	public static Logger logger() {
		logger = Logger.getLogger("AdactinHotelApp");
		PropertyConfigurator.configure("log4j.properties");
		logger.setLevel(Level.DEBUG);
		return logger;
	}
	@Test(priority =1)
	public static void launchBrowserMethod() {
		hotelbooking = launchBrowserMethod(readPropertyFile("Browser"));
		staticWaitMethod(2000);
		maximizeWindowMethod();
		logger.info("************ Launch Chrome Browser*********");
		//("AdactinHotelApp")
		}
	@Test (priority=2,dependsOnMethods= "launchBrowserMethod")
	public static void launchApplicationMethod() {
		
		getBrowserMethod(readPropertyFile("AdactinhotelURL"));
		staticWaitMethod(2000);
		System.out.println("Title of the hotelbookingApplication : " +getTitleMethod());
		Assert.assertEquals(getTitleMethod(),"Adactin.com - Hotel Reservation System");
		logger.info("************ Launch Adactin Application*********");
	}
	@Test(priority=3)
	public static void credentialPageApplicationMethod() throws IOException {
		 adactinObjectHome = new AdactinObjectManager(hotelbooking);
		sendKeysMethod(adactinObjectHome.getLoginPage().getAdactinhotelLoginUserName(), excelFileValue("LoginPage",1,0));
		staticWaitMethod(1000);
		sendKeysMethod(adactinObjectHome.getLoginPage().getAdactinhotelLoginPassWord(),passwordDecodeMethod(excelFileValue("LoginPage",1,1)));
		staticWaitMethod(1000);
		//takesScreenShotMethod();
		clickMethod(adactinObjectHome.getLoginPage().getAdactinhotelLoginButton());
		logger.info("************Adactin LoginPage*********");
	}
	@Test(priority =4,dependsOnMethods="credentialPageApplicationMethod")
	public void searchHotelPageMethod() throws IOException {
		System.out.println("Title of the welcome To Adactin Groups : " +getTitleMethod());
		Assert.assertEquals(getTitleMethod(),"Adactin.com - Search Hotel");
		forEachMethod(adactinObjectHome.getWelcomePage().getLocationDropdownList(),excelFileValue("SearchHotel",1,0));
		forEachMethod(adactinObjectHome.getWelcomePage().getHotelsDropdownList(),excelFileValue("SearchHotel",1,1));
		forEachMethod(adactinObjectHome.getWelcomePage().getRoomTypeDropdownList(),excelFileValue("SearchHotel",1,2));
		forEachAttributeMethod(adactinObjectHome.getWelcomePage().getNumberOfRoomsDropdownList(),excelFileValue("SearchHotel",1,3));
		clearMethod(adactinObjectHome.getWelcomePage().getCheckInDate());
		sendKeysMethod(adactinObjectHome.getWelcomePage().getCheckInDate(),excelFileValue("SearchHotel",1,4));
		clearMethod(adactinObjectHome.getWelcomePage().getCheckOutDate());
		sendKeysMethod(adactinObjectHome.getWelcomePage().getCheckOutDate(),excelFileValue("SearchHotel",1,5));
		forEachAttributeMethod(adactinObjectHome.getWelcomePage().getAdultsPerRoom(),excelFileValue("SearchHotel",1,6));
		forEachAttributeMethod(adactinObjectHome.getWelcomePage().getChildrenPerRoom(),excelFileValue("SearchHotel",1,7));
		clickMethod(adactinObjectHome.getWelcomePage().getWelcomePageSearchButton());
		staticWaitMethod(2000);
		logger.info("************Adactin Search Hotel Page*********");
	}
	@Test(priority =5,dependsOnMethods = "searchHotelPageMethod")
	public static void searchHotelSummaryPageMethod() {
		clickMethod(adactinObjectHome.getsearchHotelPage().getAdactinSearchHotelRadioButton());
		staticWaitMethod(3000);
		clickMethod(adactinObjectHome.getsearchHotelPage().getAdactinSearchHotelContinueButton());
		logger.info("************Adactin Hotel Summary Page*********");
	}
	
	@Test(priority=6,dependsOnMethods ="searchHotelSummaryPageMethod")
	public static void bookAHotelPageMethod() throws IOException {
		System.out.println("Title of Book A HotelAdactin : "+ getTitleMethod());
		Assert.assertEquals(getTitleMethod(), "Adactin.com - Book A Hotel");
		excuteScriptWindowSrollDownMethod(0, 600);
		sendKeysMethod(adactinObjectHome.getBookAHotelPage().getFirstNameTextbox(),excelFileValue("BookAHotel",1,0));
		sendKeysMethod(adactinObjectHome.getBookAHotelPage().getLastNameTextbox(),excelFileValue("BookAHotel",1,1));
		sendKeysMethod(adactinObjectHome.getBookAHotelPage().getBillingAddressTextBox(),excelFileValue("BookAHotel",1,2));
		sendKeysMethod(adactinObjectHome.getBookAHotelPage().getCreditCardNoTextBox(),excelFileValue("BookAHotel",1,3));
		forEachMethod(adactinObjectHome.getBookAHotelPage().getCreditCardTypeDropdown(),excelFileValue("BookAHotel",1,4));
		forEachMethod(adactinObjectHome.getBookAHotelPage().getExpiryDateMonthDropDown(),excelFileValue("BookAHotel",1,5));
		forEachMethod(adactinObjectHome.getBookAHotelPage().getExpiryDateYearDropDown(),excelFileValue("BookAHotel",1,6));
		sendKeysMethod(adactinObjectHome.getBookAHotelPage().getCvvNumberTextBox(),excelFileValue("BookAHotel",1,7));
		clickMethod(adactinObjectHome.getBookAHotelPage().getBookNowButton());
		System.out.println("Expected Prompt message is  : " + adactinObjectHome.getBookAHotelPage().getProcessMessageText().getText());
		Assert.assertEquals(adactinObjectHome.getBookAHotelPage().getProcessMessageText().getText(), "Please wait! We are processing your Hotel Booking...");
		explicitWaitMethod(10).until(ExpectedConditions.invisibilityOf(adactinObjectHome.getBookAHotelPage().getProcessMessageText()));
		logger.info("************Adactin Customer Information*********");
	}
	@Test(priority=7)
	public static void bookingConfirmationMethod() {
		System.out.println("Title of BookingConfrimation   : "+ getTitleMethod());
		Assert.assertEquals(getTitleMethod(),"Adactin.com - Hotel Booking Confirmation");
		excuteScriptWindowSrollDownMethod(0, 500);
		bookingId=adactinObjectHome.getBookingConfirmationPage().getBookingConfirmationOrderNo();
		System.out.println("Booking Order No:   "+bookingId);
		clickMethod(adactinObjectHome.getBookingConfirmationPage().getMyItineraryButton());
		logger.info("************Adactin Booking Confirmation*********");
	}
	@Test(priority=8)
	public static void bookedItineraryMethod() {
		staticWaitMethod(5000);
		sendKeysMethod(adactinObjectHome.getBookedItineraeyPage().getSearchOrderIdTextBox(),bookingId);
		clickMethod(adactinObjectHome.getBookedItineraeyPage().getGoButton());
		clickMethod(adactinObjectHome.getBookedItineraeyPage().getBookedItineraryCheckBox());
		clickMethod(adactinObjectHome.getBookedItineraeyPage().getCancelSelectedButton());
		staticWaitMethod(3000);
		System.out.println("Alert Message : " + alertHandlingMethod());
		alertHandlingMethod(true);
		staticWaitMethod(3000);
		clickMethod(adactinObjectHome.getBookedItineraeyPage().getLogoutButton());
		logger.info("************Adactin Cancel Booking*********");
	}
	
	@AfterClass
	public static void closeAdactinApplication() {
		hotelbooking.close();;
		logger.info("************Close Browser*********");
	}
}
