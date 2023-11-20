package Appium.AppiumDemo;

import org.openqa.selenium.DeviceRotation;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class MiscellenousDemo extends BaseTest {

	@Test
	public void miscellenousDemo() throws MalformedURLException {

//		configureAppium();
//		Activity activity = new Activity("io.appium.android.apis",
//				"io.appium.android.apis.preference.PreferenceDependcies");
//		driver.st
		driver.findElement(AppiumBy.accessibilityId("Preference")).click();

		driver.findElement(AppiumBy.accessibilityId("3. Preference dependencies")).click();
		;

		driver.findElement(AppiumBy.id("android:id/checkbox")).click();

		DeviceRotation landscape = new DeviceRotation(0, 0, 90);
		driver.rotate(landscape);

		driver.findElement(AppiumBy.xpath(
				"//android.widget.ListView[@resource-id=\"android:id/list\"]/android.widget.LinearLayout[2]/android.widget.RelativeLayout"))
				.click();

		String wifiTitle = driver.findElement(AppiumBy.id("android:id/alertTitle")).getText();
		Assert.assertEquals(wifiTitle, "WiFi settings");

		driver.setClipboardText("Maverick");

		driver.findElement(AppiumBy.id("android:id/edit")).sendKeys(driver.getClipboardText());
		driver.pressKey(new KeyEvent(AndroidKey.ENTER));

		driver.findElement(AppiumBy.id("android:id/button1")).click();

		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		driver.pressKey(new KeyEvent(AndroidKey.HOME));
//		tearDownAppium();
	}

}
