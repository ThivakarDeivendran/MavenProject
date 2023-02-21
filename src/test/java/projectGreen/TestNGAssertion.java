package projectGreen;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestNGAssertion {
	@DataProvider(name = "Testsaucedemo")
	public Object[][] testdata() {
		return new Object[][] { { "standard_user", "secret_sauce" } };
	}
	WebDriver referencedriver;SoftAssert assertReferenceName;

	@BeforeClass
	public void launchBrowse() {
		System.setProperty("webdriver.chrome.driver", ".\\Drivers\\msedgedriver.exe");
		referencedriver = new EdgeDriver();
		referencedriver.manage().window().maximize();
	}
	@Parameters({ "URL", "Title" })
	@Test(priority = 1)
	public void assertUrlTitleMethod(@Optional("Test1") String getUrl, @Optional("Test2") String expectedTitle) {
		referencedriver.get(getUrl);
		String actualTitle = referencedriver.getTitle();
		assertReferenceName = new SoftAssert();
		assertReferenceName.assertEquals(actualTitle, expectedTitle, "Title validation");
	}
	@Test(dependsOnMethods = "assertUrlTitleMethod", dataProvider = "Testsaucedemo")
	public void loginCredential(String userName, String passWord) throws InterruptedException {
		referencedriver.findElement(By.id("user-name")).sendKeys(userName);
		Thread.sleep(1000);
		referencedriver.findElement(By.id("password")).sendKeys(passWord);
		Thread.sleep(1000);
		referencedriver.findElement(By.id("login-button")).click();
	}

	@Parameters({ "homePage" })
	@Test(dependsOnMethods = "loginCredential")
	public void currentURLAssertMethod(String expectedCurrentUrl) {

		String acutualCurrentUrl = referencedriver.getCurrentUrl();
		assertReferenceName.assertEquals(acutualCurrentUrl, expectedCurrentUrl, "HomePage validation");
		assertReferenceName.assertAll();
		System.out.println("testing completed");

	}
}
