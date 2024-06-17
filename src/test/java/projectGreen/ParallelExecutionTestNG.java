package projectGreen;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ParallelExecutionTestNG {
	
	public static ThreadLocal<WebDriver> dr =new ThreadLocal<WebDriver>();
	@BeforeMethod
	public void login() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver =new ChromeDriver();
		dr.set(driver);
		dr.get().manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}
	@Test
	public void intialProcessMethod1() throws InterruptedException {

		dr.get().get("https://www.google.com/");
		dr.get().findElement(By.xpath("//div[@class='KxwPGc iTjxkf']/a[1]")).click();
		Thread.sleep(1000);
		dr.get().findElement(By.xpath("(//a[contains(text(),'Overview')])[1]")).click();
		Thread.sleep(1000);
	}
	@Test
	public void intialProcessMethod2() throws InterruptedException {
		dr.get().get("https://www.google.com/");
		dr.get().findElement(By.xpath("//div[@class='KxwPGc iTjxkf']/a[1]")).click();
		Thread.sleep(2000);
		dr.get().findElement(By.xpath("(//a[contains(text(),'Overview')])[1]")).click();
		Thread.sleep(2000);
	}
	@Test
	public void intialProcessMethod3() throws InterruptedException {
		dr.get().get("https://www.google.com/");
		dr.get().findElement(By.xpath("//div[@class='KxwPGc iTjxkf']/a[1]")).click();
		Thread.sleep(1000);
		dr.get().findElement(By.xpath("(//a[contains(text(),'Overview')])[1]")).click();
		Thread.sleep(1000);
	}
	@AfterMethod
	public void logoff() {
		dr.get().close();
		dr.set(null);
	}

}
