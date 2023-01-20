package PracticePackage;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderTestNG {
	
	@Test(dataProvider = "data")
	public void travel(String src,String dst)
	{
		System.out.println("from"+"  "+src + " to  "+ dst );
	}
	@DataProvider
	public Object[][]  data() {
		        Object[][]objarr = new Object [2][2];
				objarr[0][0] = "bangalore";
		        objarr[0][1] = "mysore";
		        objarr[1][0] = "mysore";
		        objarr[1][1] = "bangalore";
		        return objarr;
	}
		
	}
	


