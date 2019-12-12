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
	public static void swipeInListFromLastToFirst(List<WebElement> list) {
		int items = list.size();
		System.out.println("List Size is: "+ items);
		TouchAction action = new TouchAction(driver);
		PointOption p1 = new PointOption();
		org.openqa.selenium.Point centerOfFirstElement = ((MobileElement) list.get(0)).getCenter();
		org.openqa.selenium.Point centerOfLastElement = ((MobileElement) list.get(items - 1)).getCenter();
		System.out.println("center of first element: "+centerOfFirstElement+ "  center of last element: "+centerOfLastElement);
		new TouchAction(driver).longPress(p1.point(centerOfFirstElement.x, centerOfFirstElement.y+300))
				.moveTo(p1.point(centerOfLastElement.x, centerOfLastElement.y+80)).release().perform();
		
	}
	public static void swipeInListTillExpectedTextAndTap(List<WebElement> list, String expectedText, int time) {
		int i = 1;
		while (!driver.getPageSource().contains(expectedText)) {
			swipeInListFromLastToFirst(list);
			i++;
			if (i == time)
				break;
		}
		driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().textContains(\"" +expectedText + "\")")).click();;
	}


	@Test 
	public void tc01_signup() throws IOException, InterruptedException {
		extentTest = extentReports.createTest("tc01_signup()");
		System.out.println("Sign up");
		su.clickSignUpBtn();
		//su.bluSignUp();
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
		su.selectDOB().click();
		driver.findElement(By.id("android:id/date_picker_header_year")).click();
		List<WebElement> list=driver.findElements(By.className("android.widget.TextView"));
		String year=CommonUtil.getPropertyValue("signup", "year");
		swipeInListTillExpectedTextAndTap(list, year, 20);
  		int month=Calendar.getInstance().get(Calendar.MONTH)+1;
   		System.out.println(" Current Month is :"+ month);
  		String monthTarget=CommonUtil.getPropertyValue("signup", "month");
  		int resultMonth = Integer.parseInt(monthTarget);
  		if(resultMonth>month)
  		{
  			for(int i=0;i<resultMonth-month;i++)
  			driver.findElement(By.id("android:id/next")).click();	
  		}
  		if(resultMonth<month)
  		{
  			for(int i=0;i<month-resultMonth;i++)
  			driver.findElement(By.id("android:id/prev")).click();	
  		}
		//for(int i=0;i<6;i++)
		//driver.findElement(By.id("android:id/prev")).click();
		//driver.findElement(By.id("android:id/next")).click();
		String dob=CommonUtil.getPropertyValue("signup", "dob");
		System.out.println(dob);
		driver.findElement(By.xpath("//android.view.View[@content-desc=\"" +dob + "\"]")).click();
		//driver.findElement(By.xpath("//android.view.View[@resource-id='android:id/month_view']//android.view.View[contains(text(),'7')]")).click();
		System.out.println("Selected Date");
		driver.findElement(By.id("android:id/button1")).click();//button 2 for cancel
		
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
