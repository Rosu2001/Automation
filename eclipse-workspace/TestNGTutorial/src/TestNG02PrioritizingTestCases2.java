import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class TestNG02PrioritizingTestCases2 {
	@AfterClass
	public void afclass() {		
		System.out.println("***** After Class ***** Execute after executing any method in a class");
	}
	
	@BeforeClass
	public void bfclass() {
		System.out.println("***** Before Class ***** Execute before executing any method in a class");
	}
	
	@Test
	public void webLoginHomeLoan() {
		System.out.println("Web Login Home Loan in second file");
	}
	
	@Test
	public void mobileLoginHomeLoan() {
		System.out.println("Mobile Login Home Loan in second file");
	}
	
	@Test
	public void ApiLoginHomeLoan() {
		System.out.println("Api Login Home Loan in second file");
	}
	
	@AfterTest
	public void aftertest() {
		System.out.println("***** After Test ***** I am in Test case 2 file");
	}
}
