/* Task 2 : write script to check user can able to add product into cart with login and with out 
 *          login and generate report for testcase result */
package Appium_Assesment;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;

public class Amazon_Add_To_Cart {
	
	@Test
    public static void main(String[] args) throws IOException {
    	
    	 DesiredCapabilities caps = new DesiredCapabilities();

	        caps.setCapability("deviceName", "motorola edge 40");
	        caps.setCapability("udid","ZD222F4B6R");
	        caps.setCapability("platformName", "Android");
			caps.setCapability("platformVersion", "14.0");
			caps.setCapability( "appPackage","com.Amazon.android");
			caps.setCapability("appActivity","com.miui.Amazon.Amz.AmazonActivity");
			caps.setCapability("automationName", "UIAutomator2");

        AppiumDriver driver = null;
        try {
        	driver= new AppiumDriver(new URL("http://127.0.0.1:4723/"),caps);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
     /*   Amazon_Add_To_Cart(driver, true);
        generateReport(driver, "Add_To_Cart_With_Login_Result.png");
        Amazon_Add_To_Cart(driver, false);
        generateReport(driver, "Add_To_Cart_Without_Login_Result.png");

        driver.quit();*/
    }
	@Test
    public static void addToCart(AppiumDriver driver, boolean login) {
        try {
          
            if (login) {
            
            driver.findElement(AppiumBy.accessibilityId
            		("com.amazon.mShop.android.shopping:id/sign_in_button")).click();

             driver.findElement(AppiumBy.accessibilityId
            		 ("ap_email")).sendKeys("gandhi4mi@gmail.com");
         
                driver.findElement(AppiumBy.accessibilityId("ap_password")).sendKeys("14577491");

                driver.findElement(AppiumBy.accessibilityId("signInSubmit")).click();

                Thread.sleep(5000);
            }
            
            
            driver.findElement(AppiumBy.accessibilityId
            		("com.amazon.mShop.android.shopping:id/rs_search_src_text")).sendKeys("Shoes");
            
            driver.findElement(AppiumBy.accessibilityId
            		("com.amazon.mShop.android.shopping:id/iss_search_dropdown_item_text_layout"))
            						.click(); 
            
            driver.findElement(By.id("product_id")).click();
            
            driver.findElement(AppiumBy.accessibilityId("add_to_cart_button")).click();

        
            Thread.sleep(5000);

        } catch (Exception e) {
            System.out.println("Test case failed: " + e.getMessage());
        }
    }

    public static void generateReport(AppiumDriver driver, String filename) throws IOException {
       
    	TakesScreenshot screenshot = (TakesScreenshot) driver;

    	File srcFile = screenshot.getScreenshotAs(OutputType.FILE);

        File destFile = new File(filename);

        org.apache.commons.io.FileUtils.copyFile(srcFile, destFile);
        
        	if (driver.findElements(AppiumBy.accessibilityId("charmigandhi")).size() > 0) {
        		
            System.out.println("Test case successful: Product added to cart!");
            
        } else {
        	
            System.out.println("Test case failed: Product not added to cart!");
        }
    }
}
