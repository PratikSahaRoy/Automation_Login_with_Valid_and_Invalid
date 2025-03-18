//Write a Selenium script to test the login functionality with valid and invalid credentials.

package automationExcercise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test {

	public static void main(String[] args) throws InterruptedException {
		
		//Set up the webdriver
		WebDriver driver =new ChromeDriver();

		//Open the login page
		driver.get("https://www.automationexercise.com/login");
		driver.manage().window().maximize();
		
		// Test with valid credentials
        System.out.println("Testing valid credentials...");
        driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/form/input[2]")).sendKeys("sahapratik03@gmail.com");
        driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/form/input[3]")).sendKeys("pratikautomation");
        driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/form/button")).click();

        try {
            WebElement logoutButton = driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[4]/a"));
            if (logoutButton.isDisplayed()) {
                System.out.println("Successfully logged in with valid credentials.");
                logoutButton.click();
                Thread.sleep(5000);
            }
        } 
        catch (Exception e) {
            System.out.println("Login failed with valid credentials.");
        }
		
        //Test with invalid credential
        System.out.println("Testing invalid credentials...");
        driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/form/input[2]")).sendKeys("sahapratik@gmail.com");
        driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/form/input[3]")).sendKeys("pratikomation");
        driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/form/button")).click();
        
        Thread.sleep(2000);
        try {
            WebElement errorMessage = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[1]/div[1]/form/p"));
            System.out.println("Error message displayed: " + errorMessage.getText());
        } catch (Exception e) {
            System.out.println("No error message found.");
        }

        // Close the browser
        driver.quit();
    }
		
}


