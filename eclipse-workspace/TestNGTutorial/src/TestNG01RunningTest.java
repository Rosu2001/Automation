import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;


public class TestNG01RunningTest {
	
	@Test
	public void first() {
		System.out.println("hello in Running test file");
	}
	@Test
	public void second() {
		System.out.println("bye in Running test file");
	}
	
	@BeforeSuite
	public void before() {
		System.out.println("******* Before Suite ********* Always in First");
	}
}
