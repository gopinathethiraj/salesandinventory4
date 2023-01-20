package PracticePackage;

import static org.testng.Assert.assertNull;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertionTestNG {
	@Test
	public void simple1() {
		System.out.println("---Test Script1---");
		System.out.println("---Test Script2---");
		Assert.assertEquals("A","A");
		System.out.println("---Test Script3---");
		System.out.println("---Test Script4---");
	}
	@Test
	public void simple2() {
		System.out.println("---Test Script5---");
		System.out.println("---Test Script6---");
		Assert.assertNotEquals("A","B");
		System.out.println("---Test Script7---");
		System.out.println("---Test Script8---");
	}
	@Test
	public void simple3() {
		
			String a= null;
			assertNull(a);
			System.out.println("----");
		}
	@Test	
	public void simple4() {
		System.out.println("test9");
		SoftAssert sa = new SoftAssert();
		sa.assertEquals("X","Y");
		System.out.println("test10");
		sa.assertAll();
		
	}
		}
	


