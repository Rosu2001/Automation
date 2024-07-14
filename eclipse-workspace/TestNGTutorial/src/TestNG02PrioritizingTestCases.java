import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNG02PrioritizingTestCases {
	@BeforeMethod
	public void bfmethod() {
		System.out.println("******* Before Method ********* run before every test method in first file");
	}
	
	@Test
	public void webLoginCarLoan() {
		System.out.println("Web Login Car Loan in first file");
	}
	
	@Test
	public void mobileLoginCarLoan() {
		System.out.println("Mobile Login Car Loan in first file");
	}
	
	@Test
	public void ApiLoginCarLoan() {
		System.out.println("Api Login Car Loan in first file");
	}
	
	@AfterSuite
	public void after() {
		System.out.println("******* After Suite ********* Always in last");
	}
	
	@AfterMethod
	public void afmethod() {
		System.out.println("******* After Method ********* run after every test method in first file");
	}
}
