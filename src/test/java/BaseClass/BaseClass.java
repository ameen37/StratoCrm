package BaseClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import Pages.login_page;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
public class BaseClass {

    protected WebDriver driver;

    @BeforeMethod(alwaysRun=true)
    public void setup() {
    	 System.out.println("SETUP RUNNING");
        ChromeOptions options = new ChromeOptions();
        
        options.addArguments("--force-device-scale-factor=0.9");

        driver = new ChromeDriver(options);

        driver.manage().window().maximize();

        driver.get("https://dev.stratocrm.com");
        login_page lp = new login_page(driver);
        lp.valid_login(
                "sunithahr176@gmail.com",
                "Fortune@313");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.urlContains("overview"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[@data-tour='leads']")));
        
    }

//    @AfterMethod
//  public void quit() {
//
//      driver.quit();
//   }
}