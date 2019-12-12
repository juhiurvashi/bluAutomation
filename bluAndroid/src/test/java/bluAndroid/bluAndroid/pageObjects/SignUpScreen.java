package bluAndroid.bluAndroid.pageObjects;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import bluAndroid.bluAndroid.util.CommonUtil;
import io.appium.java_client.AppiumDriver;

public class SignUpScreen {
	private AppiumDriver<WebElement> driver;

	public SignUpScreen() {

	}

	public SignUpScreen(AppiumDriver<WebElement> driver) {
		this.driver = driver;
	}

	public void clickSignUpBtn() {
		driver.findElement(By.id("sg.com.blu.android:id/sign_up_btn")).click();
	}

	public WebElement enterEmail() {
		WebElement email = driver.findElement(
				By.xpath("//android.widget.LinearLayout[@resource-id ='sg.com.blu.android:id/email_inputField']"));
		return email;
	}

	public WebElement enterPassword() {
		WebElement pass = driver.findElement(
				By.xpath("//android.widget.LinearLayout[@resource-id ='sg.com.blu.android:id/password_inputField']"));
		return pass;
	}

	public WebElement enterConPassword() {
		WebElement conPass = driver.findElement(By.xpath(
				"//android.widget.LinearLayout[@resource-id ='sg.com.blu.android:id/confirm_password_inputField']"));
		return conPass;
	}

	public WebElement enterFirstName() {
		WebElement fname = driver.findElement(
				By.xpath("//android.widget.LinearLayout[@resource-id ='sg.com.blu.android:id/first_name_inputField']"));
		return fname;
	}

	public WebElement enterLastName() {
		WebElement lname = driver.findElement(
				By.xpath("//android.widget.LinearLayout[@resource-id ='sg.com.blu.android:id/last_name_inputField']"));
		return lname;
	}

	public WebElement enterMobile() {
		WebElement mobile = driver.findElement(
				By.xpath("//android.widget.EditText[@resource-id ='sg.com.blu.android:id/input_mobile_number_et']"));
		return mobile;
	}

	public WebElement selectDOB() {
		WebElement dob = driver.findElement(
				By.xpath("//android.widget.LinearLayout[@resource-id ='sg.com.blu.android:id/dob_inputField']"));
		return dob;
	}

	public WebElement selectGender() {
		WebElement gender = driver.findElement(By.xpath(
				"//android.widget.RadioButton[@resource-id ='sg.com.blu.android:id/sg.com.blu.android:id/female_rb']"));
		return gender;
	}

	public WebElement enterReferralCode() {
		WebElement referralCode = driver.findElement(
				By.xpath("//android.widget.LinearLayout[@resource-id ='sg.com.blu.android:id/promo_code_inputField']"));
		return referralCode;
	}

	public void bluSignUp() throws IOException {
		String email = CommonUtil.getPropertyValue("signup", "email");
		String password = CommonUtil.getPropertyValue("signup", "password");
		String conPassword = CommonUtil.getPropertyValue("signup", "conPassword");
		String firstName = CommonUtil.getPropertyValue("signup", "firstName");
		String lastName = CommonUtil.getPropertyValue("signup", "lastName");
		String mobile = CommonUtil.getPropertyValue("signup", "mobile");
		String dob = CommonUtil.getPropertyValue("signup", "dob");
		String gender = CommonUtil.getPropertyValue("signup", "gender");
		String referralCode = CommonUtil.getPropertyValue("signup", "referralCode");
		enterEmail().sendKeys(email);
		enterPassword().sendKeys(password);
		enterConPassword().sendKeys(conPassword);
		enterFirstName().sendKeys(firstName);
		enterLastName().sendKeys(lastName);
		enterMobile().sendKeys(mobile);
		// selectDOB().sendKeys(dob);
		// selectGender().sendKeys(gender);
		// enterReferralCode().sendKeys(referralCode);
		/*
		 * TouchAction tAction=new TouchAction(driver); WebElement
		 * fromElement=driver.findElement(By.
		 * xpath("//android.widget.LinearLayout[@resource-id ='sg.com.blu.android:id/last_name_inputField']"
		 * )); WebElement
		 * toElement=driver.findElement(By.id("sg.com.blu.android:id/sign_up_btn"));
		 * 
		 * tAction.press(fromElement).moveTo(toElement).release().perform(); String
		 * str="SIGN"; configuration.driver
		 * .findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""
		 * + str + "\").instance(0))"); clickSignUpBtn();
		 * 
		 * tAction.press(fromElement).moveTo(toElement).release();
		 */
	}
}
