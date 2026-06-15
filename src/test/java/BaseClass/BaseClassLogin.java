package BaseClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseClassLogin {

    protected WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void setup() {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--force-device-scale-factor=0.9");

        driver = new ChromeDriver(options);

        driver.manage().window().maximize();

        driver.get("https://dev.stratocrm.com");
    }

    @AfterMethod(alwaysRun = true)
    public void quit() {

        if(driver != null) {
            driver.quit();
        }
    }
}