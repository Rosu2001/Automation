import org.testng.annotations.BeforeTest;
//import org.testng.annotations.Test;

public class TestNG03Annotations {
	@BeforeTest
	public void method1() {
		System.out.println("**** Before Test ***** I am in Annotations File");	}
}
