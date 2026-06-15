package tests.leads;

import org.testng.Assert;
import org.testng.annotations.Test;

import BaseClass.BaseClass;
import Pages.Leads.delete_lead;

public class delete_lead_test extends BaseClass {
	
    @Test(groups="smoke")
    
    public void deleteLeadTest() {
    	  System.out.println("Driver = " + driver);

    	    delete_lead dp = new delete_lead(driver);
    	    for(int i=0;i<3;i++) {

    	    String actual = dp.deleteLead();
    	    
        Assert.assertEquals(
                actual,
                "Lead deleted successfully");
    	    }
    }
}