package Pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class login_page {

    WebDriver driver;

    public login_page(WebDriver driver) {

        this.driver = driver;

        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath="(//input[@type='text'])[1]")
    WebElement username;

    @FindBy(xpath="//input[@type='password']")
    WebElement password;

    @FindBy(xpath="//button[@type='submit']")
    WebElement submit;
    @FindBy(xpath="//div[contains(text(),'Invalid credentials')]")
   WebElement err;

    public void valid_login(String uname,String pwd) {

        WebDriverWait wait =
                new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.visibilityOf(username));
        wait.until(ExpectedConditions.visibilityOf(password));

        username.clear();
        username.sendKeys(uname);

        password.clear();
        password.sendKeys(pwd);

        submit.click();
    }
    public void invalid_login(String uname,
            String pwd) {
    	WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(3));
    	wait.until(ExpectedConditions.visibilityOf(username));
    	username.sendKeys(uname);
    	password.sendKeys(pwd);
    	submit.click();
    }
    
    public void blank(String unamne,
            String pwwd) {
    	WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(3));
    	wait.until(ExpectedConditions.visibilityOf(username));
    	username.sendKeys(unamne);
    	password.sendKeys(pwwd);
    	submit.click();
    	
    }
    public String error() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.visibilityOf(err));

    	return err.getText();
    }
    
    
}