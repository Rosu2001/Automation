import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Selenium16Practice {
	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		// Lecture 93 -- Count the links of webpage
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		System.out.println("The links on the webpage "+driver.findElements(By.tagName("a")).size());
		// Count links in footer section
		WebElement footer=driver.findElement(By.id("gf-BIG"));
		System.out.println("The links on footer section "+footer.findElements(By.tagName("a")).size());
		
		//Lecture 94 -- First column links in footer section
		WebElement columndriver=footer.findElement(By.xpath("//table[@class='gf-t']/tbody/tr/td[1]/ul"));
		System.out.println("The links on footer section in first column "+columndriver.findElements(By.tagName("a")).size());
		//Click on each link on the first column and check all the links are opening or not
		for(int i=1;i<columndriver.findElements(By.tagName("a")).size();i++) {
			//Lecture 95 -- Open in new tab
			String clickonnewtab=Keys.chord(Keys.CONTROL,Keys.ENTER);
			columndriver.findElements(By.tagName("a")).get(i).sendKeys(clickonnewtab);
		}
		
		
		// Lecture 96 -- get the titles of child tabs with optimize while loop
		Set<String> window=driver.getWindowHandles();
		Iterator<String> it=window.iterator();
			
		while(it.hasNext()) {
			driver.switchTo().window(it.next());
			System.out.println(driver.getTitle());
		}
	}
}

