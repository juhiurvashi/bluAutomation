package bluAndroid.bluAndroid.TestScripts;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

/**
 * Unit test for simple App.
 */
public class AppTest {
public static void main(String[] args) throws Exception {
    // Prepare Appium session
	DesiredCapabilities caps = new DesiredCapabilities();
	caps.setCapability("deviceName", "Galaxy S8+");
	caps.setCapability("udid", "ce031713d5fad93001"); //Give Device ID of your mobile phone
	caps.setCapability("platformName", "Android");
	caps.setCapability("platformVersion", "8.0.0"); 
	System.out.println("Start");
	caps.setCapability("appPackage", "sg.com.blu.android");
	System.out.println("Start1");
	caps.setCapability("appActivity", "sg.com.blu.android.features.account.SplashActivity"); 
//	caps.setCapability("appActivity", "sg.com.blu.android.features.account.LogInActivity");
	System.out.println("Start2");
	//caps.setCapability("appActivity", "sg.com.blu.android.features.dashboard.HomeActivity");
	//caps.setCapability("noReset", "true");
	//caps.setCapability("app", "C:\\Users\\urvashi\\Downloads\\flipcart.apk");
//	caps.setCapability("appPackage", "com.flipkart.android");
//	caps.setCapability("appActivity", "com.flipkart.android.SplashActivity");
//	caps.setCapability(AndroidMobileCapabilityType.AUTO_GRANT_PERMISSIONS, "true"); //valid from Android 6.0
//Instantiate Appium Driver
	try {
		System.out.println("Find Element0");
			AppiumDriver<MobileElement> driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), caps);
			driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
			
			//driver.findElement(By.linkText("LOG IN")).click();
			System.out.println("Find Element");
			driver.findElement(By.id("sg.com.blu.android:id/log_in_btn")).click();
			driver.findElement(By.className("android.widget.EditText")).sendKeys("94561718");
			/*WebDriverWait wait = new WebDriverWait(driver, 300); 
			wait.until(ExpectedConditions.elementToBeClickable(By.className("android.widget.RelativeLayout"))); */
			//MobileElement pass= driver.findElement(By.className("android.widget.RelativeLayout"));
			MobileElement pass= driver.findElement(By.xpath("//android.widget.LinearLayout[@resource-id='sg.com.blu.android:id/password_inputField']"));
			//pass.click();
			pass.sendKeys("Admin@123");
			driver.findElement(By.id("sg.com.blu.android:id/log_in_btn")).click();
			System.out.println("Driver :"+driver); 
		
	} catch (MalformedURLException e) {
		System.out.println(e.getMessage());
	}
}
}

