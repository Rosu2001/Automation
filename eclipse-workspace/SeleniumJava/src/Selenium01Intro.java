import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Selenium01Intro {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		System.setProperty("webdriver.chrome.driver","/home/cavisson/Downloads/chromedriver-linux64/chromedriver");
		WebDriver driver=new ChromeDriver();
		
//		//Firefox Automation
//		System.setProperty("webdriver.gecko.driver","/home/cavisson/Downloads/geckodriver");
//		WebDriver driver=new FirefoxDriver();
		
//		Edge Automation
//		System.setProperty("webdriver.chrome.driver","/home/cavisson/Downloads/msedgedriver");
//		WebDriver driver=new EdgeDriver();
		
		driver.manage().window().maximize();
		driver.get("https://www.rahulshettyacademy.com/locatorspractice/");
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
//		driver.close();  //Closes the specific window
//		driver.quit();   //All the tabs which opened by automation (Multiple window)
	}

}
