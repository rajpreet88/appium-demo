package ecommerce.EcommerceTest;

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

public class ecommerce_tc3 extends BaseTest {

	@Test
	public void fillForm() throws InterruptedException {

		driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/nameField"))
				.sendKeys("Pete Mitchell Maverick");
		driver.hideKeyboard();

		driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/spinnerCountry")).click();
		driver.findElement(
				AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Australia\"))"));
		driver.findElement(
				AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"Australia\"]"))
				.click();

		if (driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/nameField")).getText().isEmpty()) {
			String toastMessage = driver.findElement(AppiumBy.xpath("//android.widget.Toast[1]")).getAttribute("name");
			Assert.assertEquals(toastMessage, "Please enter your name");
		} else {

			driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		}

		Thread.sleep(2000);
		int productCount = 0;

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.attributeContains(
				driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/toolbar_title")), "text",
				"Products"));

		driver.findElement(AppiumBy.androidUIAutomator(
				"new UiScrollable(new UiSelector()).scrollIntoView(text(\"Air Jordan 4 Retro\"));"));
		addProductToCart("Air Jordan 4 Retro");
		productCount++;

		driver.findElement(AppiumBy.androidUIAutomator(
				"new UiScrollable(new UiSelector()).scrollIntoView(text(\"Air Jordan 9 Retro\"));"));
		addProductToCart("Air Jordan 9 Retro");
		productCount++;

		driver.findElement(AppiumBy
				.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Jordan 6 Rings\"));"));
		addProductToCart("Jordan 6 Rings");
		productCount++;
		Thread.sleep(1000);

		driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();

		WebElement ele = driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/termsButton"));
		longPressAction(ele);

		driver.findElement(AppiumBy.id("android:id/button1")).click();

		driver.findElement(AppiumBy.className("android.widget.CheckBox")).click();

		driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/btnProceed")).click();
		Thread.sleep(6000);

		Set<String> handles = driver.getContextHandles();

		for (String contextName : handles) {
			System.out.println(contextName);

		}
		driver.context("WEBVIEW_com.androidsample.generalstore");
		driver.findElement(By.name("q")).sendKeys("Maverick");
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
		Thread.sleep(5000);
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		driver.context("NATIVE_APP");

	}
}