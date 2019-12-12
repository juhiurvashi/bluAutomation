package bluAndroid.bluAndroid.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.springframework.context.annotation.Description;
import org.testng.ITestResult;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

public class CommonUtil {
      public static String getPropertyValue(String fn,String key) throws IOException
      {
    	  FileInputStream fis=new FileInputStream("./TestData/"+fn+".properties");
    	  Properties p=new Properties();
    	  p.load(fis);
		return p.getProperty(key);
      }
      public static String getCorrectTimeDate()
  	{
  		DateFormat dateFormat=new SimpleDateFormat("dd_MMM_yyyy HH_mm_ss");
  		Date date=new Date();
  		int month=dateFormat.MONTH_FIELD;
  		int day=dateFormat.DATE_FIELD;
  		return dateFormat.format(date);
  		 
  	}
      
      public static String takesScreenShot(AppiumDriver<WebElement> driver,String methodName) throws IOException
      {
    	  DateFormat  dateformat=new SimpleDateFormat("dd_MMM_yyyy HH_mm_ss");
    	  Date date= new Date();
    	  File scrFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
    	  String destination=System.getProperty("user.dir")+"/Screenshot/"+methodName.replace("passed=0 failed=0 skipped=0", "")+" "+dateformat.format(date)+".png";
    	  FileUtils.copyFile(scrFile, new File(destination));
    	  System.out.println("Screenshot Taken");
		return destination; 
      } 
      public static String takesScreenShotFailed(AppiumDriver<WebElement> driver,String methodName) throws IOException
      {
    	  DateFormat  dateformat=new SimpleDateFormat("dd_MMM_yyyy HH_mm_ss");
    	  Date date= new Date();
    	  File scrFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
    	  String destination=System.getProperty("user.dir")+"/Screenshot/"+"Error_"+methodName.replace("passed=0 failed=0 skipped=0", "")+" "+dateformat.format(date)+".png";
    	  FileUtils.copyFile(scrFile, new File(destination));
    	  System.out.println("Screenshot Taken"); 
    	  return destination;
      }
	
    
}
