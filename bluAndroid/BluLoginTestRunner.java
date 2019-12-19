//Author
package bluAndroid.bluAndroid.TestScripts;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import org.openqa.selenium.WebElement;

import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import bluAndroid.bluAndroid.pageObjects.LoginScreen;
import bluAndroid.bluAndroid.util.BaseClass;

import bluAndroid.bluAndroid.util.CommonUtil;
import io.appium.java_client.AppiumDriver;

public class BluLoginTestRunner extends BaseClass {

	static AppiumDriver<WebElement> driver;
	LoginScreen ls;
	String mobileNo, email, password, usernameBlank, passwordBlank, emailInvalid, mobileInvalid, maxAttemptCountAMS,
			mobileNotRegistered, emailNotRegistered, passwordInvalid;

	@BeforeMethod
	public void preCondition() throws IOException

	{
		System.out.println("Set Up....");
		BluLoginTestRunner.driver = BaseClass.getAppCapabilities();
		mobileNo = CommonUtil.getPropertyValue("login", "mobileNo");
		password = CommonUtil.getPropertyValue("login", "password");
		usernameBlank = CommonUtil.getPropertyValue("login", "usernameBlank");
		passwordBlank = CommonUtil.getPropertyValue("login", "passwordBlank");
		email = CommonUtil.getPropertyValue("login", "email");
		emailInvalid = CommonUtil.getPropertyValue("login", "emailInvalid");
		mobileInvalid = CommonUtil.getPropertyValue("login", "mobileInvalid");
		maxAttemptCountAMS = CommonUtil.getPropertyValue("login", "maxAttemptCountAMS");
		mobileNotRegistered = CommonUtil.getPropertyValue("login", "mobileNotRegistered");
		emailNotRegistered = CommonUtil.getPropertyValue("login", "emailNotRegistered");
		passwordInvalid = CommonUtil.getPropertyValue("login", "passwordInvalid");
		ls = new LoginScreen(driver);
	}

	@Test(enabled = false)
	public void splashScreen() {
		extentTest = extentReports.createTest("splashScreen");
		System.out.println("Splash screen displayed");
		// assertTrue(ls.sendParcel().isDisplayed());
	}

	@Test
	public void tc01_validMobileValidPassword() throws IOException {
		System.out.println("tc01_validMobileValidPassword");
		extentTest = extentReports.createTest("tc01_validMobileValidPassword");

		ls.clickLoginLink();
		ls.bluLogin(mobileNo, password);
		assertTrue(ls.sendParcel().isDisplayed());

	}

	@Test
	public void tc02_invalidEmailValidPassword() throws IOException {
		System.out.println("tc02_invalidEmailValidPassword");
		extentTest = extentReports.createTest("tc02_invalidEmailValidPassword");
		ls.clickLoginLink();
		ls.bluLogin(emailInvalid, password);
		String expectedMsg = "Invalid email address or mobile number.";
		assertEquals(ls.inlineErrorBelowUsername(), expectedMsg);
	}

	@Test
	public void tc03_invalidMobileNumberValidPassword() throws IOException {
		extentTest = extentReports.createTest("tc03_invalidMobileNumberValidPassword");
		ls.clickLoginLink();
		ls.bluLogin(mobileInvalid, password);
		String expectedMsg = "Invalid email address or mobile number.";
		assertEquals(ls.inlineErrorBelowUsername(), expectedMsg);
	}

	@Test
	public void tc04_withoutCredentials() throws IOException {
		extentTest = extentReports.createTest("tc04_withoutCredentials");
		ls.clickLoginLink();
		ls.clickLoginLink();
		String expectedMsg1 = "Enter email address or mobile number";
		String expectedMsg2 = "Enter password";
		assertEquals(ls.inlineErrorBelowUsername(), expectedMsg1);
		assertEquals(ls.inlineErrorBelowPassword(), expectedMsg2);
		System.out.println(expectedMsg1);
		System.out.println(expectedMsg2);
	}

	 @Test (enabled=false)
	 public void tc05_maximumInvalidLoginAttemptError() 
	{
		extentTest = extentReports.createTest("tc05_maximumInvalidLoginAttemptError");
		ls.clickLoginLink();
		for (int i = 0; i < 5; i++) { // ls.bluLogin(mobileNo, passwordInvalid);
		}
		String expectedMsg = "Maximum login attempt exceeded";
		assertEquals(ls.inlineErrorBelowPassword(), expectedMsg);
	}

	@Test
	public void tc06_notRegisteredMobileNumber() throws IOException {
		extentTest = extentReports.createTest("tc06_notRegisteredMobileNumber");
		ls.clickLoginLink();
		ls.bluLogin(mobileNotRegistered, password);
		String expectedMsg = "Invalid mobile number/email address or password.";
		assertEquals(ls.inlineErrorBelowPassword(), expectedMsg);
		System.out.println(expectedMsg);
	}

	@Test
	public void tc07_notRegisteredEmail() throws IOException {
		extentTest = extentReports.createTest("tc07_notRegisteredEmail");
		ls.clickLoginLink();
		ls.bluLogin(emailNotRegistered, password);
		String expectedMsg = "Invalid mobile number/email address or password.";
		assertEquals(ls.inlineErrorBelowPassword(), expectedMsg);
	}

	@Test
	public void tc08_validEmailPassword() throws IOException {
		extentTest = extentReports.createTest("tc08_validEmailPassword");
		ls.clickLoginLink();
		ls.bluLogin(email, password);
		assertTrue(ls.sendParcel().isDisplayed());
	}

	@Test
	public void tc09_validEmailInvalidPassword() throws IOException {
		extentTest = extentReports.createTest("tc09_validEmailInvalidPassword");
		ls.clickLoginLink();
		ls.bluLogin(email, passwordInvalid);
		String expectedMsg = "Invalid mobile number/email address or password.";
		assertEquals(ls.inlineErrorBelowPassword(), expectedMsg);
	}

	@Test
	public void tc10_validMobileNumberInvalidPassword() throws IOException {
		extentTest = extentReports.createTest("tc10_validMobileNumberInvalidPassword");
		ls.clickLoginLink();
		ls.bluLogin(mobileNo, passwordInvalid);
		String expectedMsg = "Invalid mobile number/email address or password.";
		assertEquals(ls.inlineErrorBelowPassword(), expectedMsg);
	}

	@Test
	public void tc11_invalidMobileNumberInvalidPassword() throws IOException {
		extentTest = extentReports.createTest("tc11_invalidMobileNumberInvalidPassword");
		ls.clickLoginLink();
		ls.bluLogin(mobileInvalid, passwordInvalid);
		String expectedMsg = "Invalid email address or mobile number.";
		assertEquals(ls.inlineErrorBelowUsername(), expectedMsg);
	}

	@AfterMethod
	public void getResult(ITestResult testResult) throws IOException {
		if (testResult.getStatus() == ITestResult.SKIP) {
			System.out.println("Skipped extent report");
			extentTest.skip(MarkupHelper.createLabel(testResult.getName() + " Test Case SKIPPED", ExtentColor.BLUE));
			extentTest.skip(testResult.getThrowable());
			// extentTest.log(Status.SKIP, MarkupHelper.createLabel(testResult.getName() + "
			// - Test Case Skipped", ExtentColor.ORANGE));
		} else if (testResult.getStatus() == ITestResult.FAILURE) {
			extentTest.fail(MarkupHelper.createLabel(testResult.getName() + " Test case FAILED due to below issues:",
					ExtentColor.RED));
			extentTest.fail(testResult.getThrowable());
			String screenshotPath = CommonUtil.takesScreenShotFailed(driver, testResult.getName());
			extentTest.addScreenCaptureFromPath(screenshotPath);
		} else if (testResult.getStatus() == ITestResult.SUCCESS) {
			extentTest.pass(MarkupHelper.createLabel(testResult.getName() + " Test Case PASSED", ExtentColor.GREEN));
			String screenshotPath = CommonUtil.takesScreenShot(driver, testResult.getName());

			extentTest.addScreenCaptureFromPath(screenshotPath);
		}

	}

}
