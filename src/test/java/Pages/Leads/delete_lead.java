package Pages.Leads;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class delete_lead {

    WebDriver driver;
    WebDriverWait wait;

    public delete_lead(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }


    @FindBy(xpath = "//div[@data-tour='leads']")
    WebElement leadMenu;

    @FindBy(xpath = "(//*[name()='svg' and contains(@class,'lucide-ellipsis-vertical')])[1]")
    WebElement threeDots;

    @FindBy(xpath = "//button[contains(text(),'Delete')]")
    WebElement deleteBtn;

    @FindBy(xpath = "//button[.//span[contains(text(),'Delete')]]")
    WebElement confirmDeleteBtn;

    @FindBy(xpath = "//*[contains(text(),'Lead deleted successfully')]")
    WebElement successMsg;
    @FindBy(xpath="//button[contains(text(),'Clear All')]")
    WebElement clearall;


    private void click(WebElement element) {

        wait.until(
                ExpectedConditions.elementToBeClickable(element));

        element.click();
    }


    public void clickLeadMenu() {
        click(leadMenu);
    }
    public void clear() {
    	wait.until(ExpectedConditions.visibilityOf(clearall));
    	click(clearall);
    }

    public void clickThreeDots() {
        click(threeDots);
    }

    public void clickDeleteButton() {
        click(deleteBtn);
    }

    public void clickConfirmDelete() {
        click(confirmDeleteBtn);
    }

    public String getSuccessMessage() {

        wait.until(
                ExpectedConditions.visibilityOf(successMsg));

        return successMsg.getText();
    }


    public String deleteLead() {

        clickLeadMenu();
        clear();
        clickThreeDots();
        clickDeleteButton();
        clickConfirmDelete();

        return getSuccessMessage();
    
}
}