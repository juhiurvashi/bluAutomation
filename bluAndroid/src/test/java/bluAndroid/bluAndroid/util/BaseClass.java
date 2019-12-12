package bluAndroid.bluAndroid.util;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class BaseClass {

	protected static AndroidDriver<WebElement> driver;

	public static AndroidDriver<WebElement> getAppCapabilities() throws IOException {

		try {
			// Set the Desired Capabilities
			DesiredCapabilities caps = new DesiredCapabilities();
			caps.setCapability("deviceName", "Galaxy S8+");
			caps.setCapability("udid", "ce031713d5fad93001"); // Give Device ID of your mobile phone
			caps.setCapability("platformName", "Android");
			caps.setCapability("platformVersion", "8.0.0");
			caps.setCapability("appPackage", "sg.com.blu.android");
			caps.setCapability("appActivity", "sg.com.blu.android.features.account.SplashActivity");
			caps.setCapability("unicodeKeyboard", true);
			caps.setCapability("resetKeyboard", true);

			driver = new AndroidDriver<WebElement>(new URL("http://0.0.0.0:4723/wd/hub"), caps);
			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		} catch (MalformedURLException e) {
			System.out.println("Cause is :" + e.getCause());
			System.out.println("Message is :" + e.getMessage());
			e.printStackTrace();
		}
		return driver;

	}
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extentReports;
	public static ExtentTest extentTest;
	
	@BeforeSuite
	public void SetUp() {
		String path = System.getProperty("user.dir") + "./ExtentReport/bluTestReport" + CommonUtil.getCorrectTimeDate()
				+ ".html";
		htmlReporter = new ExtentHtmlReporter(path);
		extentReports = new ExtentReports();
		extentReports.attachReporter(htmlReporter);
		
		extentReports.setSystemInfo("Host Name", "Urvashi PC");
		extentReports.setSystemInfo("Username", "Urvashi");
		extentReports.setSystemInfo("Environment", "QA");

		
		htmlReporter.config().setDocumentTitle("AutomationTesting Blu Report");
		htmlReporter.config().setReportName("My Own Report");
		htmlReporter.getRunDuration();
		htmlReporter.getStartTime();
		htmlReporter.getEndTime();	
		
	}
	
	@AfterSuite
	public void tearDown()
	{
		extentReports.flush();
	}

	

}