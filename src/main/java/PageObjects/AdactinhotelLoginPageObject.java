package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdactinhotelLoginPageObject {
	
	public  WebDriver adactinhotelLoginDriver;
	
	public AdactinhotelLoginPageObject(WebDriver localWebdriver){ 
		this.adactinhotelLoginDriver= localWebdriver;
		PageFactory.initElements(localWebdriver, this);
	}
	
	@FindBy(xpath="//input[@id='username']")
	private WebElement adactinhotelLoginUserName;
	
	@FindBy(xpath="//input[@id='password']")
	private WebElement adactinhotelLoginPassWord;

	@FindBy(xpath="//input[@id='login']")
	private WebElement adactinhotelLoginButton;
	

	public WebElement getAdactinhotelLoginUserName() {
	 return  adactinhotelLoginUserName;
	}
	public WebElement getAdactinhotelLoginPassWord() {
		return adactinhotelLoginPassWord;
	}
	public WebElement getAdactinhotelLoginButton() {
		return adactinhotelLoginButton;
	}
}
