/* Task 2 : Write script to login in instagram with valid and invalid data and generate report for 
 * result */

package Appium_Assesment;

import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;

public class ValidInvalid_Login {
	
	@Test
	public void opencalc() throws InterruptedException, IOException {
		DesiredCapabilities cap=new DesiredCapabilities();
		
		cap.setCapability("deviceName", "motorola edge 40");
		cap.setCapability("udid","ZD222F4B6R");
		cap.setCapability("platformName", "Android");
		cap.setCapability("platformVersion", "14.0");
		cap.setCapability( "appPackage","com.instagram.android");
		cap.setCapability("appActivity","com.instagram.mainactivity.InstagramMainActivity");
		cap.setCapability("automationName", "UIAutomator2");
		
		AppiumDriver driver= new AppiumDriver(new URL("http://127.0.0.1:4723/"),cap);
		
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//android.view.View[@content-desc=\"Log in to another account\"]")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.className("android.widget.EditText")).sendKeys("gandhi4mi@gmail.com");
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout[2]/android.widget.FrameLayout[1]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.EditText")).sendKeys("4Mi25111992");
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//android.view.View[@content-desc=\"Log in\"]")).click();
		Thread.sleep(12000);
		
		driver.findElement(By.className("android.widget.EditText")).sendKeys("gandhi4mi@gmail.com");
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout[2]/android.widget.FrameLayout[1]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.EditText")).sendKeys("4Mi@25111992");
		Thread.sleep(2000);
	}
}
