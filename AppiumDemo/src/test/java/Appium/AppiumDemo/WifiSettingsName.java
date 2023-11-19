package Appium.AppiumDemo;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class WifiSettingsName extends BaseTest {

	@Test
	public void WifiSettingsName() throws MalformedURLException {

//		configureAppium();

		driver.findElement(AppiumBy.accessibilityId("Preference")).click();

		driver.findElement(AppiumBy.accessibilityId("3. Preference dependencies")).click();
		;

		driver.findElement(AppiumBy.id("android:id/checkbox")).click();

		driver.findElement(AppiumBy.xpath(
				"//android.widget.ListView[@resource-id=\"android:id/list\"]/android.widget.LinearLayout[2]/android.widget.RelativeLayout"))
				.click();

		String wifiTitle = driver.findElement(AppiumBy.id("android:id/alertTitle")).getText();
		Assert.assertEquals(wifiTitle, "WiFi settings");

		driver.findElement(AppiumBy.id("android:id/edit")).sendKeys("maverick");

		driver.findElement(AppiumBy.id("android:id/button1")).click();

//		tearDownAppium();
	}

}
