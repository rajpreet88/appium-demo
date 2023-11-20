package ecommerce.EcommerceTest;

import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class ecommerce_tc2 extends BaseTest {

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

//		int count = driver.findElements(AppiumBy.id("com.androidsample.generalstore:id/productPrice")).size();
		Double sum = 0.0;
		System.out.println(productCount);

		for (int i = 0; i < productCount; i++) {
			if (driver.findElements(AppiumBy.id("com.androidsample.generalstore:id/productPrice")).get(i)
					.isDisplayed()) {
				String price = driver.findElements(AppiumBy.id("com.androidsample.generalstore:id/productPrice")).get(i)
						.getText();
				String formattedPrice = price.substring(1);
				sum = sum + Double.parseDouble(formattedPrice);
			} else {
				driver.findElement(AppiumBy.androidUIAutomator(
						"new UiScrollable(new UiSelector()).scrollIntoView(text(\"Jordan 6 Rings\"));"));
				String price = driver.findElements(AppiumBy.id("com.androidsample.generalstore:id/productPrice")).get(i)
						.getText();
				String formattedPrice = price.substring(1);
				sum = sum + Double.parseDouble(formattedPrice);
			}

		}
		System.out.println(sum);
	}
}
