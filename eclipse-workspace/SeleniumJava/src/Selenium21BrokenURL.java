import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class Selenium21BrokenURL {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws MalformedURLException, IOException {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		
		// Lecture - 109 (Automate Broken links/URL)
		//Step 1 - To get all The URL tied up to the the links using SELENIUM
		//Java Method will call URL and get the status code (IF URL_CODE>400 - broken links)
		String url=driver.findElement(By.xpath("//a[text()='Broken Link']")).getAttribute("href");
		HttpURLConnection conn=(HttpURLConnection)new URL(url).openConnection();
		conn.setRequestMethod("HEAD");
		conn.connect();
		int respCode=conn.getResponseCode();
		System.out.println(respCode);
		
		// Lecture - 110 (Click all links in footer and check if it is broken or not)
		List<WebElement> links=driver.findElements(By.xpath("//li[@class='gf-li']/a"));
		SoftAssert a=new SoftAssert();
		for(WebElement link:links) {
			String url1=link.getAttribute("href");
			HttpURLConnection conn1=(HttpURLConnection)new URL(url1).openConnection();
			conn1.setRequestMethod("HEAD");
			conn1.connect();
			int respCode1=conn1.getResponseCode();
			System.out.println(respCode1);
			a.assertTrue(respCode1<400, "The link with text "+link.getText()+" is broken with code: "+respCode1);
		}
		a.assertAll();
	}

}
