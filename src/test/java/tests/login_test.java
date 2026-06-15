package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import BaseClass.BaseClass;
import Pages.login_page;

public class login_test extends BaseClass {

    @Test
    public void testLogin()  {
    	System.out.println("TEST STARTED");
        login_page lp =
                new login_page(driver);

        lp.valid_login(
                "sunithahr176@gmail.com",
                "Fortune@313");
      System.out.println(driver.getTitle());
    }
    @Test
    public void invalid() {
    	login_page lp= new login_page(driver);
    	lp.invalid_login("dfadf","adfafd");
    	    }
    @Test
    public void blank() {
    	login_page lp= new login_page(driver);
    	lp.blank(" "," ");
    }
}