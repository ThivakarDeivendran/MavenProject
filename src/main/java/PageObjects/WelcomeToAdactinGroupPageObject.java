package PageObjects;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WelcomeToAdactinGroupPageObject {
	public WebDriver welcomeToAdactinGroupDriver;
	
	
	public  WelcomeToAdactinGroupPageObject(WebDriver localWelcomeToAdactinGroup) {
		this.welcomeToAdactinGroupDriver = localWelcomeToAdactinGroup;
		PageFactory.initElements(localWelcomeToAdactinGroup, this);
	}
	
	@FindBy(xpath="//select[contains(@id,'location')]/option")
	private List<WebElement> locationDropdownlist;
	
	@FindBy(xpath="//select[@id='hotels']/option")
	private List<WebElement> hotelsDropdownlist;
	
	@FindBy(xpath="(//select[@class='search_combobox'])[3]/option")
	private List<WebElement> roomTypeDropdownlist;
	
	@FindBy(xpath="//select[@name='room_nos']/option")
	private List<WebElement> numberOfRoomsDropdownlist;
	
	@FindBy(xpath="//input[contains(@id,'datepick_in')]")
	private WebElement checkInDate;
	
	@FindBy(xpath ="//input[contains(@id,'datepick_out')]")
	private WebElement checkOutDate;
	
	@FindBy(xpath="//select[@id='adult_room']/option")
	private List<WebElement> adultsPerRoom;
	
	@FindBy(xpath ="//select[@id='child_room']/option")
	private List<WebElement> childrenPerRoom;
	
	@FindBy(xpath="//input[@id='Submit']")
	private WebElement welcomePageSearchButton;
	
	
	
	/////////////////////////////////////////////////////////////////////////
	
	public List<WebElement> getLocationDropdownList() {
		return locationDropdownlist;
	}
	public List<WebElement> getHotelsDropdownList(){
		return hotelsDropdownlist;
	}
	public List<WebElement> getRoomTypeDropdownList() {
		return roomTypeDropdownlist;
	}
	public List<WebElement> getNumberOfRoomsDropdownList() {
		return numberOfRoomsDropdownlist;
	}
	public WebElement getCheckInDate() {
		return checkInDate;
	}
	public WebElement getCheckOutDate() {
		return checkOutDate;
	}
	public List<WebElement> getAdultsPerRoom() {
		return adultsPerRoom;
	}
	public List<WebElement> getChildrenPerRoom() {
		return childrenPerRoom;
	}
	public WebElement getWelcomePageSearchButton() {
		return welcomePageSearchButton;
	}


}
