package com.MavenProjectClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Base64;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;


public class BaseClass {
	
	public static  WebDriver driverBaseClassReference;
	
	public static WebDriver launchBrowserMethod(String browser) {
		try {
		switch (browser) {
		case "Chrome":
			WebDriverManager.chromedriver().setup();
			driverBaseClassReference = new ChromeDriver();
			break;
		case "Edge":
			WebDriverManager.edgedriver().setup();
			driverBaseClassReference = new EdgeDriver();
			break;
		case "Firefox":
			WebDriverManager.firefoxdriver().setup();
			driverBaseClassReference = new FirefoxDriver();
			break;
		default:
			System.out.println("browser not installed in your system");
		}
		}catch(Exception e) {
			
		}
		return driverBaseClassReference;
	}
	
//	public static WebDriver launchBrowserMethod(String browser) {
//		try {
//			if (browser.equalsIgnoreCase("chrome")) {
//				WebDriverManager.chromedriver().setup();
//				driverBaseClassReference = new ChromeDriver();
//				return driverBaseClassReference;
//			} else if (browser.equalsIgnoreCase("firefox")) {
//				WebDriverManager.firefoxdriver().setup();
//				driverBaseClassReference = new FirefoxDriver();
//				return driverBaseClassReference;
//			} else if (browser.equalsIgnoreCase("edge")) {
//				WebDriverManager.edgedriver().setup();
//				driverBaseClassReference = new EdgeDriver();
//				return driverBaseClassReference;
//			}
//		} catch (Exception e) {
//
//		}
//		return driverBaseClassReference;
//	}

	public static void maximizeWindowMethod() {
		try {
		driverBaseClassReference.manage().window().maximize();
		}catch(Exception e) {}
	}

	public static void deleteAllCookiesMethod() {
		try {
		driverBaseClassReference.manage().deleteAllCookies();
		}catch(Exception e) {}
	}

	@SuppressWarnings("deprecation")
	public static void implicitlyWaitMethod(int timeOuts){
		try {
			driverBaseClassReference.manage().timeouts().implicitlyWait(timeOuts, TimeUnit.SECONDS);
			}catch(Exception e) {}
	}
	
	public static void staticWaitMethod(int milliSeconds) {
		try {
			Thread.sleep(milliSeconds);
		} catch (InterruptedException e) {
		}
	}
	public static String getTitleMethod() {
		try {
		return driverBaseClassReference.getTitle();
		}catch(Exception e) {}
		
		return null;
	}
	
	public static String passwordDecodeMethod(String decodePassword) {
		try {
			return (new String(Base64.getDecoder().decode(decodePassword.getBytes())));
		} catch (Exception e) {

		}
		return null;
	}
	public static void sendKeysMethod(WebElement sendKeysElement,String values) {
		try {
		 sendKeysElement.sendKeys(values);
		 }catch(Exception e) 
		{}
	}
	
	public static String readPropertyFile(String getPropertyKey) {
		try {
			FileInputStream readFileInput = new FileInputStream(System.getProperty("user.dir")+ "\\Properties\\Adactinhotel.properties");
			Properties propertyfile = new Properties();
			try {
				propertyfile.load(readFileInput);
			} catch (IOException e) {	
			}
			 return propertyfile.getProperty(getPropertyKey);
			
		} catch (FileNotFoundException e) {
			
		}
		return null;
	}
	public static String excelFileValue(String sheetName,int rowType, int cellType) throws IOException {
		File filename = new File(System.getProperty("user.dir")+ "\\ExcelFiles\\Adactinhotel.xlsx");
		FileInputStream fis = new FileInputStream(filename);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		DataFormatter dataformat = new DataFormatter();
		XSSFSheet worksheetAt = workbook.getSheet(sheetName);
		Cell cellValue = worksheetAt.getRow(rowType).getCell(cellType);
		return dataformat.formatCellValue(cellValue);
	}
	
	public static void clickMethod(WebElement clickElement ) {
		try {
			clickElement.click();
		}catch(Exception e) {
			
		}
	}
	public static void forEachMethod(List<WebElement> listDropDown, String userValue) {
		for (WebElement selectDropDown :listDropDown ) {
			if(selectDropDown.getText().equals(userValue)) {
				selectDropDown.click();
			}
		}
	}
	public static void forEachAttributeMethod(List<WebElement> listDropDown, String userValue) {
		for (WebElement selectDropDown :listDropDown ) {
			if(selectDropDown.getAttribute("value").equals(userValue)) {
				selectDropDown.click();
			}
		}
	}
	
	public static void forMethod(List<WebElement> dropDownlist,int lastRowNumValue,String userValue) {
		for(int i=0;i<lastRowNumValue;i++) {
			if(dropDownlist.get(i).getText().equalsIgnoreCase(userValue)) {
				dropDownlist.get(i).click();
			}
		}
	}
	
	public static void clearMethod(WebElement clearElement) {
		try {
			clearElement.clear();
		}catch(Exception e) {}
		
	}
	public static void browserCloseMethod() {
		try {
		driverBaseClassReference.close();
		}catch(Exception e) {
			
		}
	}

	public static void browserQuitMethod() {
		try {
		driverBaseClassReference.quit();
		}catch(Exception e) {}
	}

	public static void navigationMethod(String browserUrl) {
		try {
		driverBaseClassReference.navigate().to(browserUrl);
		}catch(Exception e) {
			
		}
	}

	public static void navigationMethod(char navigate) {
		try {
		switch (navigate) {
		case 'F':
			driverBaseClassReference.navigate().forward();
			break;
		case 'B':
			driverBaseClassReference.navigate().back();
			break;
		default:
			driverBaseClassReference.navigate().refresh();
		}
		}catch(Exception e) {}
	}

	public static void getBrowserMethod(String browserUrl) {
		try {
		driverBaseClassReference.get(browserUrl);
		}catch(Exception e) {
		}
	}

	public static void alertHandlingMethod(boolean confirmation) {
		try {
		Alert alertMessage = driverBaseClassReference.switchTo().alert();
		if (confirmation) {
			alertMessage.accept();
		} else {
			alertMessage.dismiss();
		}
		}catch(Exception e) {}
	}

	public static void alertHandlingMethod(String alertSendKeys) {
		try {
		driverBaseClassReference.switchTo().alert().sendKeys(alertSendKeys);
		}catch(Exception e) {}
	}

	public static String alertHandlingMethod() {
		try {
		return driverBaseClassReference.switchTo().alert().getText();
		}catch(Exception e) {}
		return null;
	}
	public static void isEnabledMethod(WebElement isEnableWebElement) {
		try {
		isEnableWebElement.isEnabled();
		}catch (Exception e) {}
	}
	public static void isdisplayedMethod(WebElement isDisplayWebElement) {
		try {
		isDisplayWebElement.isDisplayed();
		}catch (Exception e) {}
	}
	public static void isSelectedMethod(WebElement isSelectWebElement) {
		try {
		isSelectWebElement.isSelected();
		}catch(Exception e) {}
	}
	public static void takesScreenShotMethod() throws IOException {
		try {
	File originScreenShotFile =((TakesScreenshot)driverBaseClassReference).getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(originScreenShotFile, new File(System.getProperty("user.dir") +"//ScreenShots//images"+ System.currentTimeMillis()+".png"));
	}catch(Exception e) {}
	}

	public static WebDriverWait explicitWaitMethod(int timeUnits){
		try {
		WebDriverWait wait = new WebDriverWait(driverBaseClassReference,Duration.ofSeconds(timeUnits));
		return wait;
		}catch(Exception e) {}
		return null;
	}
	public static void fluentWaitMethod(Duration timeouts,Duration pollingTimeOuts) {
		try {
		Wait wait = new FluentWait(driverBaseClassReference).withTimeout(timeouts).pollingEvery(pollingTimeOuts).ignoring(Exception.class);
		}catch(Exception e) {}
	}
	public static void excuteScriptWindowSrollDownMethod(int horizontal,int vertical) {
		JavascriptExecutor scriptScrollDown=(JavascriptExecutor) driverBaseClassReference;
		scriptScrollDown.executeScript("window.scrollBy("+horizontal +","+vertical+")", "");
	}
	
	@DataProvider(name = "saucedemo")
	@Test
	public Object[][] testData() {
		return new Object[][] { { "standard_user", "secret_sauce" }, { "problem_user", "secret_sauce" } };
	}
	
	
}
