package ecommerce.EcommerceMobileBrowserTest;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class ecommerceMobileBrowser_tc1 extends BaseMobileWebTest {

	@Test
	public void browserTest() throws InterruptedException {

		driver.get("https://google.com");
//		Thread.sleep(5000);
		driver.findElement(By.name("q")).sendKeys("Maverick");
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
		Thread.sleep(5000);

	}
}
