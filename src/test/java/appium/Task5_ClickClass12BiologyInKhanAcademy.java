package appium;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class Task5_ClickClass12BiologyInKhanAcademy {

	AndroidDriver<AndroidElement> driver;

	@BeforeClass
	public void launchKhanAcademy() throws MalformedURLException {
		DesiredCapabilities capability = new DesiredCapabilities();
		capability.setCapability("deviceName", "emulator-5558");
		capability.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		capability.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "org.khanacademy.android");
		capability.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY,
				"org.khanacademy.android.ui.library.MainActivity");
		capability.setCapability("unicodeKeyboard", true);
		capability.setCapability("resetKeyboard", true);
		driver = new AndroidDriver<AndroidElement>(new URL("http://0.0.0.0:4723/wd/hub"), capability);
	}

	@Test
	public void clickClass12Biology() throws InterruptedException {
		driver.findElement(MobileBy.AccessibilityId("Search tab")).click();
		Thread.sleep(3000);
		driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Science\")")).click();
		Thread.sleep(3000);
		TouchAction act = new TouchAction(driver);
		Dimension d = driver.manage().window().getSize();
		int width = d.width;
		int height = d.height;
		int x1 = width / 2;
		int y1 = 4 * height / 5;
		int x2 = width / 2;
		int y2 = height / 5;
		act.press(PointOption.point(x1, y1)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3)))
				.moveTo(PointOption.point(x2, y2)).release().perform();
		Thread.sleep(3000);
		driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Class 12 Biology (India)\")")).click();
		Thread.sleep(3000);
		String Expected = "Class 12 Biology (India)";
		String Actual = driver
				.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Class 12 Biology (India)\")")).getText();
		Assert.assertEquals(Actual, Expected);
	}

	@AfterClass
	public void quitBrowser() {
		driver.quit();
	}
}
