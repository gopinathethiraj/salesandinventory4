package PracticePackage;

import org.testng.annotations.Test;

public class SampleTestNGTest_2 {
	@Test(groups= {"smoke","regression"})
	public void sample3()
	{
		System.out.println("-- Testscript 3--");
	}
	@Test(groups = "smoke")
	public void sample4()
	{
		System.out.println("-- Testscript 4--");
	}

}


