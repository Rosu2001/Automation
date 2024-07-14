
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class Selenium25Multipletabs {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		
		// Lecture - 125 (Invoking multiple window or tabs using selenium)
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		driver.switchTo().newWindow(WindowType.TAB); // Here it will open the new tab but the control is on the first page
		Set<String> allWindow=driver.getWindowHandles();  // it will get 2 window - parent and child
		Iterator<String> it=allWindow.iterator();
		String parentWindow=it.next();
		String childWindow=it.next();

		driver.switchTo().window(childWindow);
		driver.get("https://rahulshettyacademy.com/");
		String coursename=driver.findElement(By.xpath("(//a[contains(@href,'https://courses.rahulshettyacademy.com/p')])[2]")).getText();
		
		driver.switchTo().window(parentWindow);
		WebElement name=driver.findElement(By.xpath("(//input[@name='name'])[1]"));
		name.sendKeys(coursename);
		
		//Lecture -126 (Taking partial screenshot of webwlement)
		File file=name.getScreenshotAs(OutputType.FILE); // It is a object of file class but we need a physical file so it can be open
		FileUtils.copyFile(file, new File("ex.png"));
		
		//Lecture - 127 (Getting Height and width of webElement)
		System.out.println(name.getRect().getDimension().getHeight());
		System.out.println(name.getRect().getDimension().getWidth());		
	}

}
