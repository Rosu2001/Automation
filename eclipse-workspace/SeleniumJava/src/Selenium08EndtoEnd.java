import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Selenium08EndtoEnd {
	public static void main(String[] args) throws InterruptedException {
		// Lecture 66 - End to end Automation using all UI Elements
		WebDriver driver=new ChromeDriver(); 
		driver.get("https://www.rahulshettyacademy.com/dropdownsPractise/");
		driver.manage().window().maximize();
		
		// Select From and To
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		driver.findElement(By.xpath("//a[@value='DEL']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA']")).click();
		
		// For Calendar
		driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight")).click();
		if(driver.findElement(By.id("Div1")).getAttribute("style").contains("0.5")) {
			System.out.println("It is enabled");
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}
		
		
		// For selecting on adult
		driver.findElement(By.id("divpaxinfo")).click();
		Thread.sleep(2000);
		int i=1;
		while(i<3) {
			driver.findElement(By.id("hrefIncAdt")).click();   // It will click + icon 
			i++;
		}
		driver.findElement(By.id("btnclosepaxoption")).click();
		
		// Clicking search button 
		driver.findElement(By.xpath("//input[@id='ctl00_mainContent_btn_FindFlights']")).click();
		
	}
}
