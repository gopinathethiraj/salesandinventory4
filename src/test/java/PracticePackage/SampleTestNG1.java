package PracticePackage;

import org.testng.annotations.Test;

public class SampleTestNG1 {
	
	@Test
	public void create() {
		System.out.println("created");
	}
	@Test(dependsOnMethods= "create",priority = -1)
	public void updated() {
		System.out.println("updated");
	}
	@Test(invocationCount = 6)
	public void deleted() {
		System.out.println("deleted");
	}
	

}
