import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Selenium14WindowHandle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Lecture - 88 (Window Handle)
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://rahulshettyacademy.com/loginpagePractise/#");
		driver.findElement(By.className("blinkingText")).click();
		Set<String> windows = driver.getWindowHandles(); // [parent,child]
		Iterator<String> it = windows.iterator();
		String parentid = it.next();
		String childid = it.next();
		driver.switchTo().window(childid);
//		String email=driver.findElement(By.xpath("//p[contains(text(),'Please')]/strong")).getText();
		
		// Lecture - 89 ( Switch window example )
//		System.out.println(driver.findElement(By.xpath("//p[contains(text(),'Please')]/strong")).getText());
//		driver.switchTo().window(parentid);
//		driver.findElement(By.xpath("//input[@id='username']")).sendKeys(email);
		
		// We can use the above method ----or---- we have to grab complete text and split the string
		System.out.println(driver.findElement(By.cssSelector(".im-para.red")).getText());
		String[] line=driver.findElement(By.cssSelector(".im-para.red")).getText().split(" ");
		System.out.println(line[4]);
		String email=line[4];
		driver.switchTo().window(parentid);
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys(email);
	}
}

