package tests;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import BaseClass.BaseClass;
import Pages.pipeline;
import Pages.Leads.create_lead;


public class pipeline_test extends BaseClass {
	@DataProvider
	public Object[][] st(){
		return new Object[][] {
			{"New Leads","Vinod","kamli", "8976453212","st","560010"},
			{"Site Schedule Fixed","Viji","kumar","8976431212","mg","560011"},
			{"Site Visit Done","akram","sab","6564346899","pasha","560089"},
			{"Booked","abhii","tripathi","8976453212","sharma","560078"}
		};
	}
	
	@Test(dataProvider = "st")
	public void createLeadTest(String stageName,
	                           String fname,
	                           String lname,
	                           String phone,
	                           String addr,
	                           String pincode) {

	    pipeline pp = new pipeline(driver);

	    pp.createLead(stageName,
	                  fname,
	                  lname,
	                  phone,
	                  addr,
	                  pincode);

	    Assert.assertEquals(
	            pp.success(),
	            "Lead Created Successfully");
	}
}
