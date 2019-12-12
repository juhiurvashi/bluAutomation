package bluAndroid.bluAndroid.pageObjects;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import bluAndroid.bluAndroid.TestScripts.BluLoginTestRunner;
import bluAndroid.bluAndroid.util.BaseClass;
import bluAndroid.bluAndroid.util.CommonUtil;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class LoginScreen {
	private AppiumDriver<WebElement> driver;

	public LoginScreen() {

	}

	public LoginScreen(AppiumDriver<WebElement> driver2) throws IOException {
		this.driver = driver2;
	}

	public void clickLoginLink() {
		driver.findElement(By.id("sg.com.blu.android:id/log_in_btn")).click();
	}

	public WebElement enterUserName() {
		WebElement username = driver.findElement(By.className("android.widget.EditText"));
		return username;
	}

	public WebElement enterPassword() {
		WebElement password = driver.findElement(
				By.xpath("//android.widget.LinearLayout[@resource-id='sg.com.blu.android:id/password_inputField']"));
		return password;
	} 
	
	public String inlineErrorBelowUsername() {
		String errorMsg = driver.findElement(By.id("sg.com.blu.android:id/error_tv")).getText();
		return errorMsg;
	}
	public String inlineErrorBelowPassword() {
		String errorMsg = driver.findElement(By.xpath("//android.widget.LinearLayout[@resource-id='sg.com.blu.android:id/password_inputField']//android.widget.TextView[@resource-id='sg.com.blu.android:id/error_tv']")).getText();
		return errorMsg;
	}
	public WebElement sendParcel() { 
		WebElement sendparcel=driver.findElement(By.id("sg.com.blu.android:id/sendParcelButton"));
		return sendparcel;
		
	}
	public void bluLogin(String username, String password) throws IOException {
		enterUserName().sendKeys(username);
		/*
		 * WebDriverWait wait = new WebDriverWait(driver, 300);
		 * wait.until(ExpectedConditions.elementToBeClickable(By.className(
		 * "android.widget.RelativeLayout")));
		 */
		enterPassword().sendKeys(password);
		clickLoginLink();
	}
}