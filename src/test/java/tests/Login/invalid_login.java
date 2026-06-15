package tests.Login;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import BaseClass.BaseClassLogin;
import Pages.login_page;

public class invalid_login extends BaseClassLogin {

    @DataProvider(name = "invalid")
    public Object[][] inv() {
        return new Object[][] {
            {"sunithahr176@gmail.com","adna"},
            {"khkhjbjb@gmail.coom","Fortune@313"},
            {"sdfdf@wgmail.com","sdfas"}
        };
    }

    @Test(dataProvider = "invalid", groups = "smoke")
    public void invalid(String uname, String pwd) {

        login_page lp = new login_page(driver);

        lp.invalid_login(uname, pwd);

        Assert.assertEquals(
                lp.error(),
                "Invalid credentials");
    }
}