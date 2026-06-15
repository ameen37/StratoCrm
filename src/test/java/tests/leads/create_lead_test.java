package tests.leads;

import org.testng.Assert;
import org.testng.annotations.Test;

import BaseClass.BaseClass;
import Pages.Leads.create_lead;

public class create_lead_test extends BaseClass {

    @Test(groups="smoke")
    public void createLeadTest() {
    	 System.out.println("Driver in test = " + driver);
        create_lead lead =
                new create_lead(driver);

        lead.createLead(
                "Ameen",
                "Pasha",
                "9876543210",
                "MG Road",
                "560001");

        Assert.assertEquals(
                lead.success(),
                "Lead Created Successfully");
     
    }
}