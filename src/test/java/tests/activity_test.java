package tests;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import BaseClass.BaseClass;
import Pages.Activities;
public class activity_test extends BaseClass{
	@DataProvider
	public Object[][] act(){
		return new Object[][] {
		{"call to confirm visit","Call"},
		{"write email to confirm visit ","Email"}
		};
	
	}
	@Test(dataProvider="act", groups="smoke")
public void create_activity(String type,String info) {
	Activities act1= new Activities(driver);
	act1.create_activity(type, info);
}
}
