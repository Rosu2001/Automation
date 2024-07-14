import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Selenium19HandleHTTPS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Lecture - 104 (Handling HTTPS certifications)
		ChromeOptions options=new ChromeOptions();
		options.setAcceptInsecureCerts(true);
		WebDriver driver=new ChromeDriver(options);
		driver.get("https://expired.badssl.com/");
		System.out.println(driver.getTitle());
		
		// Lecture - 107 (Maximize window and deleting cookies)
		driver.manage().deleteAllCookies();
	}

}
