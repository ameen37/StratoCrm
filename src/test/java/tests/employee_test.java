package tests;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import BaseClass.BaseClass;
import Pages.Employees_page;

public class employee_test extends BaseClass{
@DataProvider
public Object[][] em(){
	return new Object[][] {
		{"darshan","darsrgfvhgh54g@g.co","Dar@12122","Dar@12122"},
		{"ganesh","ganeyrt55tt@sdfdsg.co","Gan@12122","Gan@12122"},
		{"vimal","dadwefr54456tf@g.co","Fg@12122","Fg@12122"},
	};
}
@Test(dataProvider="em",groups="smoke")
public void create(String name,String emails,String passw,String cpass) throws InterruptedException {
    System.out.println("Driver = " + driver);
    Employees_page pp= new Employees_page(driver);
    pp.create_employee( name, emails,passw,cpass);
}
}
