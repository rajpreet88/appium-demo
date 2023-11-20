package ecommerce.EcommerceTest;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class BaseTest {
	AndroidDriver driver;
	AppiumDriverLocalService service;

	@BeforeClass
	public void configureAppium() throws MalformedURLException {
		service = new AppiumServiceBuilder()
				.withAppiumJS(
						new File("C:\\Users\\mmyst\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
				.withIPAddress("127.0.0.1").usingPort(4723).build();

		service.start();

		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName("Pixel7Pro_Preet");
		options.setApp(
				"C:\\Users\\mmyst\\eclipse-workspace\\APPIUM\\AppiumDemo\\src\\test\\java\\resources\\General-Store.apk");

		// AndroidDriver
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}

	@AfterClass
	public void tearDownAppium() {
		driver.quit();
		service.stop();
	}

//	public void scrollGoogleEngineAction() {
//		driver.findElement(
//				AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"India\"))"))
//				.click();
//		;
//	}
	
	public void scrollAppiumAction() {
		boolean canScrollMore;
		do {
			canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile:scrollGesture", ImmutableMap
					.of("left", 100, "top", 100, "width", 200, "height", 200, "direction", "down", "percent", 3.0));
		} while (canScrollMore);

		// here goes the code to handle the element if found while scrolling
	}
	
	
	
}
