/*
 * package bluAndroid.bluAndroid.TestScripts;
 * 
 * 
 * 
 * 
 * import java.net.MalformedURLException; import java.net.URL; import
 * java.util.List; import java.util.concurrent.TimeUnit;
 * 
 * import org.openqa.selenium.By; import org.openqa.selenium.WebElement; import
 * org.openqa.selenium.remote.DesiredCapabilities; import
 * org.testng.annotations.Test;
 * 
 * import io.appium.java_client.AppiumDriver; import
 * io.appium.java_client.FindsByAndroidUIAutomator; import
 * io.appium.java_client.MobileBy; import io.appium.java_client.MobileElement;
 * import io.appium.java_client.TouchAction; import
 * io.appium.java_client.android.AndroidDriver; import
 * io.appium.java_client.touch.offset.PointOption;
 * 
 * public class DOB {
 * 
 * 
 * 
 * public static void main(String[] args) throws MalformedURLException {
 * 
 * 
 * DesiredCapabilities caps = new DesiredCapabilities();
 * caps.setCapability("deviceName", "Galaxy S8+"); caps.setCapability("udid",
 * "ce031713d5fad93001"); caps.setCapability("platformName", "Android");
 * caps.setCapability("platformVersion", "8.0.0");
 * caps.setCapability("appPackage", "sg.com.blu.android");
 * caps.setCapability("appActivity",
 * "sg.com.blu.android.features.account.SplashActivity");
 * AppiumDriver<MobileElement> driver = new AndroidDriver<MobileElement>(new
 * URL("http://0.0.0.0:4723/wd/hub"), caps);
 * driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
 * 
 * driver.findElement(By.id("sg.com.blu.android:id/sign_up_btn")).click();
 * driver.findElement(By.
 * xpath("//android.widget.LinearLayout[@resource-id ='sg.com.blu.android:id/dob_inputField']"
 * )).click();
 * driver.findElement(By.id("android:id/date_picker_header_year")).click();
 * List<MobileElement>
 * list=driver.findElements(By.className("android.widget.TextView"));
 * swipeInListTillExpectedTextAndTap(list, "1991", 20);
 * swipeInListFromLastToFirst(List<MobileElement> listID) { int items =
 * listID.size();
 * 
 * TouchAction action = new TouchAction(driver); PointOption p1 = new
 * PointOption(); org.openqa.selenium.Point centerOfFirstElement =
 * listID.get(0).getCenter(); org.openqa.selenium.Point centerOfLastElement =
 * listID.get(items - 1).getCenter(); new
 * TouchAction(driver).longPress(p1.point(centerOfLastElement.x,
 * centerOfLastElement.y)) .moveTo(p1.point(centerOfFirstElement.x,
 * centerOfFirstElement.y)).release().perform();
 * 
 * } public static void swipeInListTillExpectedTextAndTap(List<MobileElement>
 * list, String expectedText, int time) { int i = 1; while
 * (!driver.getPageSource().contains(expectedText)) {
 * swipeInListFromLastToFirst(list); i++; if (i == time) break; }
 * driver.findElement(MobileBy.
 * AndroidUIAutomator("new UiSelector().textContains(\"" +expectedText +
 * "\")")); } }
 * 
 * private static void swipeInListTillExpectedTextAndTap(List<MobileElement>
 * list, String string, int i) { // TODO Auto-generated method stub
 * 
 * }
 * 
 * public void selectDate() { register.birthDate.click();
 * general.datePickerYear.click();
 * u.swipeInListTillExpectedTextAndTap(general.yearList, "1991", 20);
 * general.datePickerNextButton.click(); general.datePickerDay.click();
 * general.datePickerOK.click(); }
 * 
 * 
 * 
 * }
 * 
 */