package PracticePackage;

import org.testng.annotations.Test;

public class SampleTestNGTest_1 {
	@Test(groups = "smoke")
	public void sample1()
	{
		System.out.println("-- Testscript 1--");
	}
	@Test(groups= {"smoke","regression"})
	public void sample2()
	{
		System.out.println("-- Testscript 2--");
	}

}
