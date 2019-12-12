package bluAndroid.bluAndroid.TestScripts;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import org.openqa.selenium.WebElement;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.TestListenerAdapter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;

import org.testng.annotations.Test;

import bluAndroid.bluAndroid.pageObjects.LoginScreen;
import bluAndroid.bluAndroid.util.BaseClass;
import bluAndroid.bluAndroid.util.CommonUtil;
import io.appium.java_client.AppiumDriver;
//@Listeners(bluAndroid.bluAndroid.util.ListenerTest.class)
public class BluTestRunner extends TestListenerAdapter {

	static AppiumDriver<WebElement> driver;
	LoginScreen ls;
	String mobileNo, email, password, usernameBlank, passwordBlank, emailInvalid, mobileInvalid, maxAttemptCountAMS,
			mobileNotRegistered, emailNotRegistered, passwordInvalid;
	static ITestResult testResult;
	

	@BeforeMethod
	public void preCondition() throws IOException

	{
		System.out.println("Set Up....");
		BluTestRunner.driver = BaseClass.getAppCapabilities();
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
		passwordInvalid = CommonUtil.getPropertyValue("login", "passwoordInvalid");

		ls = new LoginScreen(driver);
	}

	@Test(testName = "splashScreen")
	public void splashScreen() {
		System.out.println("Splash screen displayed");
		}

	@Test
	public void tc01_valid_mobile_valid_password() throws IOException {
		ls.clickLoginLink();
		ls.bluLogin(mobileNo, password);
		assertTrue(ls.sendParcel().isDisplayed());
	}

	@Test
	public void verifyLogin1() throws IOException {
		System.out.println("Test started 2");
		System.out.println(driver);
		ls.clickLoginLink(); 
		ls.bluLogin(mobileNo, passwordBlank);
		assertTrue(ls.sendParcel().isDisplayed());
		System.out.println("Finished 2");
	}

	@AfterMethod
	public static void afterMethod(ITestResult testResult) throws IOException{
		//testResult = Reporter.getCurrentTestResult();
		//System.out.println("TestResult : "+ testResult.getMethod());
		//System.out.println("TestResultStatus : "+testResult.getName());
		//System.out.println("ITestResult.FAILURE:  "+ ITestResult.FAILURE);
		if (testResult.getStatus() == ITestResult.FAILURE) {
			System.out.println("Completed..Failed :" + testResult);
			CommonUtil.takesScreenShotFailed(driver , testResult.getName());
			//System.out.println(new Throwable() .getStackTrace()[0].getMethodName());
			System.out.println(testResult.getName());
		} else {
			CommonUtil.takesScreenShot(driver,testResult.getName());
			//System.out.println(new Throwable() .getStackTrace()[0].getMethodName());
			System.out.println(testResult.getMethod());
			System.out.println(testResult.getName());
			/*
			 * System.out.println(testResult.getStatus());
			 * System.out.println(testResult.getTestName());
			 * System.out.println(testResult.getAttributeNames());
			 * System.out.println(testResult.getTestContext());
			 * System.out.println(testResult.getInstanceName());
			 */
		}
		
	} 

}
