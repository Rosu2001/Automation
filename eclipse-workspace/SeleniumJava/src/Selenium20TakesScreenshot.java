import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.google.common.io.Files;

public class Selenium20TakesScreenshot {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		// Lecture 108 (Taking Screenshot in Selenium)
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.com");
		driver.manage().window().maximize();
		File src=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		Files.copy(src,new File("/home/cavisson/Downloads/screenshot.png"));
	}

}
