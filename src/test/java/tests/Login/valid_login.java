package tests.Login;

import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import BaseClass.BaseClassLogin;
import Pages.login_page;

public class valid_login extends BaseClassLogin {

    @Test(groups = "smoke")
    public void testLogin() {

        login_page lp = new login_page(driver);

        lp.valid_login(
                "sunithahr176@gmail.com",
                "Fortune@313");

        WebDriverWait wait =
                new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.urlContains("overview"));

        Assert.assertTrue(
                driver.getCurrentUrl().contains("overview"));
    }
}