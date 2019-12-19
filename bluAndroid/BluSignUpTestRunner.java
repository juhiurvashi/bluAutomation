package bluAndroid.bluAndroid.TestScripts;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import bluAndroid.bluAndroid.pageObjects.SignUpScreen;
import bluAndroid.bluAndroid.util.BaseClass;
import bluAndroid.bluAndroid.util.CommonUtil;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.touch.offset.PointOption;

public class BluSignUpTestRunner extends BaseClass {
	public static AppiumDriver<WebElement> driver;
	SignUpScreen su;
	@BeforeMethod
	public void preCondition() throws IOException

	{
		System.out.println("Set Up....");
		BluSignUpTestRunner.driver = BaseClass.getAppCapabilities();

		su = new SignUpScreen(driver);
	}
	


	@Test 
	public void tc01_signup() throws IOException, InterruptedException {
		extentTest = extentReports.createTest("tc01_signup()");
		System.out.println("Sign up");
		su.clickSignUpBtn();
		su.bluSignUp();
		//WebElement list= driver.findElement(By.xpath("//android.widget.LinearLayout"));
		/*
		 * WebElement
		 * signup=driver.findElement(By.id("sg.com.blu.android:id/sign_up_btn"));
		 * scrollToAnElementByText(driver, signup.getText());
		 * System.out.println("Element is :"+signup.getText());
		 */
		//((Object)driver).pressKey(66);
		//((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.ENTER));
		//WebElement pick = (WebElement) By.xpath("//android.widget.LinearLayout[@resource-id ='sg.com.blu.android:id/dob_inputField']");         
		String expected=CommonUtil.getPropertyValue("signup", "OTPScreenText");
		WebElement otpScreenText= driver.findElement(By.id("sg.com.blu.android:id/recipient_tv"));
		String actual=otpScreenText.getText();
		Assert.assertEquals(actual, expected);
		System.out.println("Textmatched"+ expected+actual);
	}
	@Test
	public void tc02_signupWithoutReferralCode() throws IOException
	{
		extentTest = extentReports.createTest("tc02_signupWithoutReferralCode()");
		su.clickSignUpBtn();
		su.signupWithoutReferralCode();
		String expected=CommonUtil.getPropertyValue("signup", "OTPScreenText");
		WebElement otpScreenText= driver.findElement(By.id("sg.com.blu.android:id/recipient_tv"));
		String actual=otpScreenText.getText();
		Assert.assertEquals(actual, expected);
	}
	@Test
	public void tc03_signupWithoutGenderAndRefferalCode() throws IOException
	{
		extentTest = extentReports.createTest("tc03_signupWithoutGenderAndRefferalCode()");
		su.signupWithoutGenderAndRefferalCode();
		String expected=CommonUtil.getPropertyValue("signup", "OTPScreenText");
		WebElement otpScreenText= driver.findElement(By.id("sg.com.blu.android:id/recipient_tv"));
		String actual=otpScreenText.getText();
		Assert.assertEquals(actual, expected);
	}
	@Test
	public void tc04_signupWithoutDOBGenderAndRefferalCode() throws IOException
	{
		extentTest = extentReports.createTest("tc04_signupWithoutDOBGenderAndRefferalCode()");
		su.signupWithoutDOBGenderAndRefferalCode();
		String expected=CommonUtil.getPropertyValue("signup", "OTPScreenText");
		WebElement otpScreenText= driver.findElement(By.id("sg.com.blu.android:id/recipient_tv"));
		String actual=otpScreenText.getText();
		Assert.assertEquals(actual, expected);
	}
	@Test
	public void tc05_signupManDetails() throws IOException
	{
		extentTest = extentReports.createTest("tc05_signupManDetails");
		su.bluSignUpManDetails();
		String expected=CommonUtil.getPropertyValue("signup", "OTPScreenText");
		WebElement otpScreenText= driver.findElement(By.id("sg.com.blu.android:id/recipient_tv"));
		String actual=otpScreenText.getText();
		Assert.assertEquals(actual, expected);
	}
	@Test
	public void tc06_signupInvalidEmail() throws IOException
	{
		extentTest = extentReports.createTest("tc06_signupInvalidEmail()");
		String invalidEmail= CommonUtil.getPropertyValue("signup", "invalidEmail");
		String password = CommonUtil.getPropertyValue("signup", "password");
		String conPassword = CommonUtil.getPropertyValue("signup", "conPassword");
		String firstName = CommonUtil.getPropertyValue("signup", "firstName");
		String mobile = CommonUtil.getPropertyValue("signup", "mobile");
		su.clickSignUpBtn();
		su.enterEmail().sendKeys(invalidEmail);
		su.enterPassword().sendKeys(password);
		su.enterConPassword().sendKeys(conPassword);
		su.enterFirstName().sendKeys(firstName);
		su.enterMobile().sendKeys(mobile);
		su.clickSignUpBtn();
		String expected="Invalid email address.";
		WebElement error= driver.findElement(By.id("sg.com.blu.android:id/error_tv"));
		String actual=error.getText();
		Assert.assertEquals(actual, expected);
		
	}
	@Test
	public void tc17_signupRegisteredEmail() throws IOException
	{
		extentTest = extentReports.createTest("tc06_signupInvalidEmail()");
		String usedEmail= CommonUtil.getPropertyValue("signup", "usedEmail");
		String password = CommonUtil.getPropertyValue("signup", "password");
		String conPassword = CommonUtil.getPropertyValue("signup", "conPassword");
		String firstName = CommonUtil.getPropertyValue("signup", "firstName");
		String mobile = CommonUtil.getPropertyValue("signup", "mobile");
		su.clickSignUpBtn();
		su.enterEmail().sendKeys(usedEmail);
		su.enterPassword().sendKeys(password);
		su.enterConPassword().sendKeys(conPassword);
		su.enterFirstName().sendKeys(firstName);
		su.enterMobile().sendKeys(mobile);
		su.clickSignUpBtn();
		String expected2="Email address already used.";
		WebElement error= driver.findElement(By.id("sg.com.blu.android:id/error_tv"));
		String actual2=error.getText();
		Assert.assertEquals(actual2, expected2);
	}
	@Test
	public void tc07_signupInvalidPassword() throws IOException
	{
		extentTest = extentReports.createTest("tc07_signupInvalidPassword()");
		String email= CommonUtil.getPropertyValue("signup", "email");
		String invalidpassword = CommonUtil.getPropertyValue("signup", "invalidPass");
		String conPassword = CommonUtil.getPropertyValue("signup", "conPassword");
		String firstName = CommonUtil.getPropertyValue("signup", "firstName");
		String mobile = CommonUtil.getPropertyValue("signup", "mobile");
		su.clickSignUpBtn();
		su.enterEmail().sendKeys(email);
		su.enterPassword().sendKeys(invalidpassword);
		su.enterConPassword().sendKeys(conPassword);
		su.enterFirstName().sendKeys(firstName);
		su.enterMobile().sendKeys(mobile);
		su.clickSignUpBtn();
		String expected="Password should be 8 or more letters, with at least one uppercase letter, one lowercase letter, and one number or symbol.";
		WebElement passError = driver.findElement(
				By.xpath("//android.widget.LinearLayout[@resource-id ='sg.com.blu.android:id/password_inputField']//android.widget.TextView[@resource-id ='sg.com.blu.android:id/error_tv']"));
		String actual=passError.getText();
		Assert.assertEquals(actual, expected);
		
	}
	@Test
	public void tc08_signupNonMatchingPassword() throws IOException
	{
		extentTest = extentReports.createTest("tc08_signupNonMatchingPassword()");
		String email= CommonUtil.getPropertyValue("signup", "email");
		String password = CommonUtil.getPropertyValue("signup", "password");;
		String conPassword = CommonUtil.getPropertyValue("signup", "nonMatchingPass");
		String firstName = CommonUtil.getPropertyValue("signup", "firstName");
		String mobile = CommonUtil.getPropertyValue("signup", "mobile");
		su.clickSignUpBtn();
		su.enterEmail().sendKeys(email);
		su.enterPassword().sendKeys(password);
		su.enterConPassword().sendKeys(conPassword);
		su.enterFirstName().sendKeys(firstName);
		su.enterMobile().sendKeys(mobile);
		((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.ENTER));
		su.clickSignUpBtn();
		String expected="Passwords do not match";
		WebElement passError = driver.findElement(
				By.xpath("//android.widget.LinearLayout[@resource-id ='sg.com.blu.android:id/confirm_password_inputField']//android.widget.TextView[@resource-id ='sg.com.blu.android:id/error_tv']"));
		String actual=passError.getText();
		Assert.assertEquals(actual, expected);
		
	}
	@Test
	public void tc09_signupInvalidFirstname() throws IOException
	{
		extentTest = extentReports.createTest("tc09_signupInvalidFirstname()");
		String email= CommonUtil.getPropertyValue("signup", "email");
		String password = CommonUtil.getPropertyValue("signup", "password");;
		String conPassword = CommonUtil.getPropertyValue("signup", "nonMatchingPass");
		String invalidfirstName = CommonUtil.getPropertyValue("signup", "invalidFirstName");
		String mobile = CommonUtil.getPropertyValue("signup", "mobile");
		su.clickSignUpBtn();
		su.enterEmail().sendKeys(email);
		su.enterPassword().sendKeys(password);
		su.enterConPassword().sendKeys(conPassword);
		su.enterFirstName().sendKeys(invalidfirstName);
		su.enterMobile().sendKeys(mobile);
		su.clickSignUpBtn();
		String expected="Only alphabets and spaces allowed.";
		WebElement passError = driver.findElement(
				By.xpath("//android.widget.LinearLayout[@resource-id ='sg.com.blu.android:id/first_name_inputField']//android.widget.TextView[@resource-id ='sg.com.blu.android:id/error_tv']"));
		String actual=passError.getText();
		Assert.assertEquals(actual, expected);
		
	}
	@Test
	public void tc10_signupInvalidMobile() throws IOException
	{
		extentTest = extentReports.createTest("tc10_signupInvalidMobile()");
		String email= CommonUtil.getPropertyValue("signup", "email");
		String password = CommonUtil.getPropertyValue("signup", "password");
		String conPassword = CommonUtil.getPropertyValue("signup", "conPassword");
		String firstName = CommonUtil.getPropertyValue("signup", "firstName");
		String mobile = CommonUtil.getPropertyValue("signup", "invalidMobile");
		String usedmobile = CommonUtil.getPropertyValue("signup", "usedMobile");
		su.clickSignUpBtn();
		su.enterEmail().sendKeys(email);
		su.enterPassword().sendKeys(password);
		su.enterConPassword().sendKeys(conPassword);
		su.enterFirstName().sendKeys(firstName);
		su.enterMobile().sendKeys(mobile);
		((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.ENTER));
		su.clickSignUpBtn();
		//	Enter your date of birth.
		String expected="Enter a valid mobile number.";
		WebElement Error = driver.findElement(
				By.xpath("//android.widget.LinearLayout[@resource-id ='sg.com.blu.android:id/mobile_number_inputField']//android.widget.TextView[@resource-id ='sg.com.blu.android:id/error_tv']"));
		String actual=Error.getText();
		Assert.assertEquals(actual, expected);
		
	}
	@Test
	public void tc18_signupRegisteredMobile() throws IOException
	{
		extentTest = extentReports.createTest("tc10_signupInvalidMobile()");
		String email= CommonUtil.getPropertyValue("signup", "email");
		String password = CommonUtil.getPropertyValue("signup", "password");
		String conPassword = CommonUtil.getPropertyValue("signup", "conPassword");
		String firstName = CommonUtil.getPropertyValue("signup", "firstName");
		String mobile = CommonUtil.getPropertyValue("signup", "invalidMobile");
		String usedmobile = CommonUtil.getPropertyValue("signup", "usedMobile");
		su.clickSignUpBtn();
		su.enterEmail().sendKeys(email);
		su.enterPassword().sendKeys(password);
		su.enterConPassword().sendKeys(conPassword);
		su.enterFirstName().sendKeys(firstName);
		su.enterMobile().sendKeys(usedmobile);
		((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.ENTER));
		su.clickSignUpBtn();
		WebElement Error = driver.findElement(
				By.xpath("//android.widget.LinearLayout[@resource-id ='sg.com.blu.android:id/mobile_number_inputField']//android.widget.TextView[@resource-id ='sg.com.blu.android:id/error_tv']"));
		String expected2="Mobile Number already used.";
		String actual2=Error.getText();
		Assert.assertEquals(actual2, expected2);
	}
	@Test
	public void tc11_signupInvalidRefferalCode() throws IOException
	{
		extentTest = extentReports.createTest("tc11_signupInvalidRefferalCode()");
		String email= CommonUtil.getPropertyValue("signup", "email");
		String password = CommonUtil.getPropertyValue("signup", "password");
		String conPassword = CommonUtil.getPropertyValue("signup", "conPassword");
		String firstName = CommonUtil.getPropertyValue("signup", "firstName");
		String mobile = CommonUtil.getPropertyValue("signup", "mobile");
		String invalidreferralCode = CommonUtil.getPropertyValue("signup", "invalidReferralCode");
		su.clickSignUpBtn();
		su.enterEmail().sendKeys(email);
		su.enterPassword().sendKeys(password);
		su.enterConPassword().sendKeys(conPassword);
		su.enterFirstName().sendKeys(firstName);
		su.enterMobile().sendKeys(mobile);
		((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.ENTER));
		su.enterReferralCode().sendKeys(invalidreferralCode);
		su.clickSignUpBtn();
		String expected="Enter a valid referral code.";
		WebElement passError = driver.findElement(
				By.xpath("//android.widget.LinearLayout[@resource-id ='sg.com.blu.android:id/promo_code_inputField']//android.widget.TextView[@resource-id ='sg.com.blu.android:id/error_tv']"));
		String actual=passError.getText();
		Assert.assertEquals(actual, expected);
	}
	@Test
	public void tc12_signupWithoutEmail() throws IOException
	{
		extentTest = extentReports.createTest("tc12_signupWithoutEmail()");
		String password = CommonUtil.getPropertyValue("signup", "password");
		String conPassword = CommonUtil.getPropertyValue("signup", "conPassword");
		String firstName = CommonUtil.getPropertyValue("signup", "firstName");
		String mobile = CommonUtil.getPropertyValue("signup", "mobile");
		su.clickSignUpBtn();
		su.enterPassword().sendKeys(password);
		su.enterConPassword().sendKeys(conPassword);
		su.enterFirstName().sendKeys(firstName);
		su.enterMobile().sendKeys(mobile);
		((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.ENTER));
		su.clickSignUpBtn();
		String expected="Enter your email address";
		WebElement otpScreenText= driver.findElement(By.id("sg.com.blu.android:id/error_tv"));
		String actual=otpScreenText.getText();
		Assert.assertEquals(actual, expected);
	}
	@Test
	public void tc13_signupWithoutPassword() throws IOException
	{
		extentTest = extentReports.createTest("tc13_signupWithoutPassword()");
		String email= CommonUtil.getPropertyValue("signup", "email");
		String conPassword = CommonUtil.getPropertyValue("signup", "conPassword");
		String firstName = CommonUtil.getPropertyValue("signup", "firstName");
		String mobile = CommonUtil.getPropertyValue("signup", "mobile");			
		su.clickSignUpBtn();
		su.enterEmail().sendKeys(email);
		su.enterConPassword().sendKeys(conPassword);
		su.enterFirstName().sendKeys(firstName);
		su.enterMobile().sendKeys(mobile);	
		((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.ENTER));
		su.clickSignUpBtn();
		String expected="Enter password.";
		WebElement passError = driver.findElement(
				By.xpath("//android.widget.LinearLayout[@resource-id ='sg.com.blu.android:id/password_inputField']//android.widget.TextView[@resource-id ='sg.com.blu.android:id/error_tv']"));
		String actual=passError.getText();
		Assert.assertEquals(actual, expected);
		String expected2="Passwords do not match";
		WebElement Error = driver.findElement(
				By.xpath("//android.widget.LinearLayout[@resource-id ='sg.com.blu.android:id/confirm_password_inputField']//android.widget.TextView[@resource-id ='sg.com.blu.android:id/error_tv']"));
		String actual2=Error.getText();
		Assert.assertEquals(actual2, expected2);
	}
	@Test
	public void tc14_signupWithoutConfirmingPass() throws IOException
	{
		extentTest = extentReports.createTest("tc14_signupWithoutConfirmingPass");
		String email= CommonUtil.getPropertyValue("signup", "email");
		String password = CommonUtil.getPropertyValue("signup", "password");
		String firstName = CommonUtil.getPropertyValue("signup", "firstName");
		String mobile = CommonUtil.getPropertyValue("signup", "mobile");
		su.clickSignUpBtn();
		su.enterEmail().sendKeys(email);
		su.enterPassword().sendKeys(password);
		su.enterFirstName().sendKeys(firstName);
		su.enterMobile().sendKeys(mobile);
		((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.ENTER));
		su.clickSignUpBtn();
		String expected="Passwords do not match.";
		WebElement Error = driver.findElement(
				By.xpath("//android.widget.LinearLayout[@resource-id ='sg.com.blu.android:id/confirm_password_inputField']//android.widget.TextView[@resource-id ='sg.com.blu.android:id/error_tv']"));
		String actual=Error.getText();
		Assert.assertEquals(actual, expected);
	}
	@Test
	public void tc15_signupWithoutFirstName() throws IOException
	{
		extentTest = extentReports.createTest("tc15_signupWithoutFirstName()");
		String email= CommonUtil.getPropertyValue("signup", "email");
		String password = CommonUtil.getPropertyValue("signup", "password");
		String conPassword = CommonUtil.getPropertyValue("signup", "conPassword");
		String mobile = CommonUtil.getPropertyValue("signup", "mobile");
		su.clickSignUpBtn();
		su.enterEmail().sendKeys(email);
		su.enterPassword().sendKeys(password);
		su.enterConPassword().sendKeys(conPassword);
		su.enterMobile().sendKeys(mobile);
		((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.ENTER));
		su.clickSignUpBtn();
		String expected="Enter your first name.";
		WebElement mobileError = driver.findElement(
				By.xpath("//android.widget.LinearLayout[@resource-id ='sg.com.blu.android:id/first_name_inputField']//android.widget.TextView[@resource-id ='sg.com.blu.android:id/error_tv']"));
		String actual=mobileError.getText();
		Assert.assertEquals(actual, expected);
	}
	@Test
	public void tc16_signupWithoutMobileNumber() throws IOException
	{
		extentTest = extentReports.createTest("tc16_signupWithoutMobileNumber()");
		String email= CommonUtil.getPropertyValue("signup", "email");
		String password = CommonUtil.getPropertyValue("signup", "password");
		String conPassword = CommonUtil.getPropertyValue("signup", "conPassword");
		String firstName = CommonUtil.getPropertyValue("signup", "firstName");
		su.clickSignUpBtn();
		su.enterEmail().sendKeys(email);
		su.enterPassword().sendKeys(password);
		su.enterConPassword().sendKeys(conPassword);
		su.enterFirstName().sendKeys(firstName);
		((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.ENTER));
		su.clickSignUpBtn();
		String expected="Enter your mobile number.";
		WebElement mobileError = driver.findElement(
				By.xpath("//android.widget.LinearLayout[@resource-id ='sg.com.blu.android:id/mobile_number_inputField']//android.widget.TextView[@resource-id ='sg.com.blu.android:id/error_tv']"));
		String actual=mobileError.getText();
		Assert.assertEquals(actual, expected);
	}
	@AfterMethod
	public void getResult(ITestResult testResult) throws IOException
	{
		if (testResult.getStatus() == ITestResult.FAILURE) {
		extentTest.fail( MarkupHelper
				.createLabel(testResult.getName() + " Test case FAILED due to below issues:", ExtentColor.RED));
		extentTest.fail(testResult.getThrowable());
		String screenshotPath =CommonUtil.takesScreenShotFailed(driver, testResult.getName());
				  extentTest.addScreenCaptureFromPath(screenshotPath);
	} else if (testResult.getStatus() == ITestResult.SUCCESS) { 
		extentTest.pass(
				MarkupHelper.createLabel(testResult.getName() + " Test Case PASSED", ExtentColor.GREEN));
		String screenshotPath =CommonUtil.takesScreenShot(driver, testResult.getName());
		
		extentTest.addScreenCaptureFromPath(screenshotPath);
	} else if(testResult.getStatus() == ITestResult.SKIP) {
		extentTest.skip(
				MarkupHelper.createLabel(testResult.getName() + " Test Case SKIPPED", ExtentColor.BLUE));
		extentTest.skip(testResult.getThrowable());
	} 
	 
	}

}
