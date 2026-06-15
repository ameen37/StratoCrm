package tests;

import org.testng.annotations.Test;

import BaseClass.BaseClass;
import Pages.Task_Creation;

public class task_test extends BaseClass{
	@Test(groups="smoke")
	public void creat() {
		Task_Creation tc= new Task_Creation(driver);
		tc.createtask();
	}

}
