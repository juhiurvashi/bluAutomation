package bluAndroid.bluAndroid.TestScripts;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
 
public class SignUp {
	
	public static void main(String[] args) {
		
		//Set the Desired Capabilities
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
			
				/*//driver.findElement(By.linkText("LOG IN")).click();
				System.out.println("Find Element");
				driver.findElement(By.id("sg.com.blu.android:id/log_in_btn")).click();
				/*driver.findElement(By.className("android.widget.EditText")).sendKeys("94561718");
				/*WebDriverWait wait = new WebDriverWait(driver, 300); 
				wait.until(ExpectedConditions.elementToBeClickable(By.className("android.widget.RelativeLayout"))); 
				//MobileElement pass= driver.findElement(By.className("android.widget.RelativeLayout"));
				MobileElement pass= driver.findElement(By.xpath("//android.widget.LinearLayout[@resource-id='sg.com.blu.android:id/password_inputField']"));
				//pass.click();
				pass.sendKeys("Admin@123");
				driver.findElement(By.id("sg.com.blu.android:id/log_in_btn")).click();
				System.out.println("Found Element");*/
				driver.findElement(By.id("sg.com.blu.android:id/sign_up_btn")).click();
				MobileElement email= driver.findElement(By.xpath("//android.widget.LinearLayout[@resource-id ='sg.com.blu.android:id/email_inputField']"));
				email.sendKeys("abc@123.com");
				MobileElement pass= driver.findElement(By.xpath("//android.widget.LinearLayout[@resource-id ='sg.com.blu.android:id/password_inputField']"));
				pass.sendKeys("abc@123.com");
				MobileElement conPass= driver.findElement(By.xpath("//android.widget.LinearLayout[@resource-id ='sg.com.blu.android:id/confirm_password_inputField']"));
				conPass.sendKeys("abc@123.com");
				MobileElement firstName= driver.findElement(By.xpath("//android.widget.LinearLayout[@resource-id ='sg.com.blu.android:id/first_name_inputField']"));
				firstName.sendKeys("Urvashi");
				MobileElement lastName= driver.findElement(By.xpath("//android.widget.LinearLayout[@resource-id ='sg.com.blu.android:id/last_name_inputField']"));
				lastName.sendKeys("Gupta");
				MobileElement mobile= driver.findElement(By.xpath("//android.widget.EditText[@resource-id ='sg.com.blu.android:id/input_mobile_number_et']"));
				mobile.sendKeys("94561718");
				//MobileElement dob= driver.findElement(By.xpath("//android.widget.LinearLayout[@resource-id ='sg.com.blu.android:id/dob_inputField']"));
				//dob.sendKeys("09/aug/1992");
				MobileElement gender= driver.findElement(By.xpath("//android.widget.RadioButton[@resource-id ='sg.com.blu.android:id/sg.com.blu.android:id/female_rb']"));
				MobileElement signUpBtn= driver.findElement(By.xpath("//android.widget.LinearLayout[@resource-id ='sg.com.blu.android:id/sign_up_btn']"));
				//((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", signUpBtn);

/*MobileElement elementToClick = (MobileElement) ((FindsByAndroidUIAutomator<MobileElement>) driver)
    .findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()"
        + ".resourceId(\"com.android.settings:id/content\")).scrollIntoView("
        + "new UiSelector().text(\"SIGN UP\"));");*/
				//gender.isSelected();
				//((AppiumDriver) driver).scrollToExact("");
				/*Dimension dimensions = driver.manage().window().getSize();
			      System.out.println("Size of Window= " +dimensions);
			      int scrollStart = (int) (dimensions.getHeight() * 0.5);
			      System.out.println("Size of scrollStart= " +scrollStart);
			      int scrollEnd = (int) (dimensions.getHeight() * 0.2);
			      System.out.println("Size of cscrollEnd= " + scrollEnd);             
			      driver.swipe(0,scrollStart,0,scrollEnd,1000);           
			      System.out.println("Screen Swiped " );*/
				
				MobileElement promoCode= driver.findElement(By.xpath("//android.widget.LinearLayout[@resource-id ='sg.com.blu.android:id/promo_code_inputField']"));
				promoCode.sendKeys("BLU452385");
				
				signUpBtn.click();
				System.out.println("Driver :"+driver);
			
		} catch (MalformedURLException e) {
			System.out.println(e.getMessage());
		}
	}

	/*private static boolean swipeFromUpToBottom() {
		AppiumDriver<MobileElement> driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), caps);
		 try {
	          JavascriptExecutor js = (JavascriptExecutor) driver;
	          HashMap<String, String> scrollObject = new HashMap<String, String>();
	          scrollObject.put("direction", "up");
	          js.executeScript("mobile: scroll", scrollObject);
	          System.out.println("Swipe up was Successfully done.");
	        }
	           catch (Exception e) 
	            {
	                System.out.println("swipe up was not successfull");
	            }   
	               return false;
		
	}*/
 
}