package Appium_Assesment;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;

public class ApiDemo_Scroll extends API_Base {
	
		@Test
		public void scroll() throws InterruptedException {
			
			driver.findElement(AppiumBy.accessibilityId("Views")).click();
			
			driver.findElement(AppiumBy.androidUIAutomator
				("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"));")).click();
			
			Thread.sleep(3000);
			
		}
}
	
