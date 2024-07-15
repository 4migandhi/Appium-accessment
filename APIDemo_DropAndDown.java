package Appium_Assesment;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class APIDemo_DropAndDown extends API_Base{
	
	@Test
	public void Drag() throws InterruptedException {
		
		driver.findElement(AppiumBy.androidUIAutomator
				("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Views\"));")).click();
		
		Thread.sleep(3000);
		
		driver.findElement(AppiumBy.accessibilityId("Drag and Drop")).click();
		Thread.sleep(2000);
		
		WebElement source = driver.findElement(By.id("io.appium.android.apis:id/drag_dot_1"));
		dragNDrop(source);
		
		String msg = driver.findElement(By.id("io.appium.android.apis:id/drag_result_text")).getText();
		
		assertEquals(msg, "Dropped!");
	}


}
