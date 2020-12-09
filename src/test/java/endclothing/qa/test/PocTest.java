package endclothing.qa.test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import atu.testrecorder.ATUTestRecorder;
import endclothing.qa.base.Property;
import endclothing.qa.pageobjects.EndClothing_CatalogPage;
import endclothing.qa.pageobjects.EndClothing_HomePage;

public class PocTest {

	WebDriver driver;
	ATUTestRecorder recorder;
	Property prop = new Property();

	@BeforeTest
	@Parameters("browser")
	public void setup(String browser) throws Exception {
		DateFormat dateFormat = new SimpleDateFormat("yy-MM-dd HH-mm-ss");
		  Date date = new Date();
		  //Created object of ATUTestRecorder
		  //Provide path to store videos and file name format.
//		  recorder = new ATUTestRecorder("D:\\ScriptVideos\\","TestVideo-"+dateFormat.format(date),false);
		  recorder = new ATUTestRecorder(System.getProperty("user.dir") + "\\ScriptVideos\\","TestVideo-"+dateFormat.format(date),false);
		  //To start video recording.
		  recorder.start();  
		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\repo\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\repo\\geckodriver.exe");
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.edge.driver", System.getProperty("user.dir") + "\\repo\\msedgedriver.exe");
			driver = new EdgeDriver();
		} else {
			throw new Exception("Browser is not correct");
		}
		driver.get(prop.getProperty("application.url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}

	@Test
	public void pocTest() {
		EndClothing_HomePage home = new EndClothing_HomePage(driver);
		EndClothing_CatalogPage catalog = new EndClothing_CatalogPage(driver);
		home.searchProduct(prop.getProperty("search.text"));
		catalog.selectProduct();
		catalog.clickAddToCart();
		catalog.clickCheckoutSecurely();
		home.loginToApplication(prop.getProperty("username"), prop.getProperty("password"));
	}

	@AfterTest()
	public void close() throws Exception {
		driver.close();
		recorder.stop();
	}
}
