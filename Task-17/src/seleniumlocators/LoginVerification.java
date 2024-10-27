package seleniumlocators;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class LoginVerification {
public static void main(String[] args) {
	
	  // Initialize WebDriver
	WebDriver driver = new ChromeDriver();
	
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	 // Navigate to demoblaze website
	driver.get("https://www.demoblaze.com/");
	// Maximize the browser window
	driver.manage().window().maximize();
	 // Locate the "Sign In" button
	driver.findElement(By.xpath("//a[text()='Sign up']")).click();
	// Enter valid email ID & password
     driver.findElement(By.cssSelector("input#sign-username")).sendKeys("kaviya20");

     driver.findElement(By.cssSelector("input#sign-password")).sendKeys("VJkavi@1420");
  // Click on signup
     driver.findElement(By.xpath("//button[text()='Sign up']")).click();

  // Handle the alert that appears after signup
     try {
         // Wait a bit for the alert to appear
         Thread.sleep(2000);
         Alert alert = driver.switchTo().alert();
         String alertMessage = alert.getText();
         System.out.println("Alert message: " + alertMessage);

         // Accept the alert to close it
         alert.accept();

         // Check the alert message for signup success or failure
         if (alertMessage.contains("Sign up successful")) {
             System.out.println("Signup successful: User has been registered.");
         } else {
             System.out.println("Signup failed: " + alertMessage);
         }
     } catch (Exception e) {
         System.out.println("No alert displayed or issue with signup.");
         e.printStackTrace();
     }

     // Close the browser
     driver.quit();
 }
}