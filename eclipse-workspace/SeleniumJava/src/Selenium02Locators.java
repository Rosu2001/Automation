import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Selenium02Locators {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
//		System.setProperty("webdriver.chrome.driver", "/home/cavisson/Downloads/chromedriver-linux64/chromedriver");
		WebDriver driver=new ChromeDriver();
				
		// Implicit wait - To wait how much time to wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.get("https://www.rahulshettyacademy.com/locatorspractice/");
		
		//1. Find Element By id...... sendKeys is method to input the value in that ----- (( Input username ))
		driver.findElement(By.id("inputUsername")).sendKeys("Roshan");
		
		//2. Find Element By name.... ---- (( Input password ))
		driver.findElement(By.name("inputPassword")).sendKeys("rahulshettyacadmy");
		
		//3. Find Element By class-name... 
		driver.findElement(By.className("submit")).click();
		
		//4. Find element By CSS selectors... getText is to get the text ---- (( To capture Error message ))
		System.out.println(driver.findElement(By.cssSelector("p.error")).getText());
		
		//5. Find Element by LinkText -- (( Forgot password ))
		driver.findElement(By.linkText("Forgot your password?")).click();
		
		//6. Find Element By XPATH -- <input type="text" placeholder="Name">
		driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("Roshan");
		
		// Customized CSS selectors
		driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("roshan2001gupta@gmail.com");
		
		//7. XPATH using tagname and child ---- Phone Number field
		driver.findElement(By.xpath("//form/input[3]")).sendKeys("7809395125");

		Thread.sleep(2000);
		driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
		
		System.out.println(driver.findElement(By.cssSelector("form p")).getText());
		
		// Go to login button click
		driver.findElement(By.xpath("//div[@class='forgot-pwd-btn-conainer']/button[1]")).click();
		}

}
