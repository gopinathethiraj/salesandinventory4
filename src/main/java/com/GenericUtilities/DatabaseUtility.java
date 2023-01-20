package com.GenericUtilities;





import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;




public class DatabaseUtility {
	
	Connection con =null;

	public void connectionToDB() throws SQLException  {
	
	    Driver driver=new Driver();
	   DriverManager.registerDriver(driver);
	   con=DriverManager.getConnection(Ipathconstants.DBURL, Ipathconstants.DBUSERNAME, Ipathconstants.DBPASSWORD);
	   
}
   public String executeQueryAndgetData(String query, int coloumnINdex, String expData) throws Throwable
{
	ResultSet result= con.createStatement().executeQuery(query);
	boolean flag = false;
	while(result.next())
	{
		String data = result.getString(coloumnINdex);
		System.out.println(data);
		if(data.equalsIgnoreCase(expData))//compairing
		{
			flag= true;
			break;
		}
	}
	if(flag)
	{
		System.out.println(expData+"project is created");
		return expData;
		}
	else
	{
		System.out.println("project is not created");
		return"";
	}
}


}
