package Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class pipeline {

    WebDriver driver;
    WebDriverWait wait;

    public pipeline(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @FindBy(xpath = "//span[text()='Pipeline']")
    WebElement pip;

    @FindBy(name = "first_name")
    WebElement firstName;

    @FindBy(name = "last_name")
    WebElement lastName;

    @FindBy(name = "phone_number")
    WebElement phoneNumber;

    @FindBy(name = "address")
    WebElement address;

    @FindBy(name = "pin_code")
    WebElement pinCode;

    @FindBy(xpath = "//span[contains(text(),'Select Lead Source')]")
    WebElement leadSourceDropdown;

    @FindBy(xpath = "//button[@type='button']//span[text()='Website']")
    WebElement websiteOption;

    @FindBy(xpath = "//span[text()='Select Lead Priority']")
    WebElement leadPriorityDropdown;

    @FindBy(xpath = "//span[text()='Medium']")
    WebElement mediumOption;

    @FindBy(xpath = "//span[text()='Select Lead Owner / Assigned To']")
    WebElement assignToDropdown;

    @FindBy(xpath = "//button[.//span[contains(text(),'Ameen Pasha')]]")
    WebElement assignToEmployee;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement submitBtn;

    @FindBy(xpath = "//h2[text()='Lead Created Successfully']")
    WebElement successMsg;


    private void click(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    private void enter(WebElement element, String txt) {
        wait.until(ExpectedConditions.visibilityOf(element));
        element.clear();
        element.sendKeys(txt);
    }


    public void clickLeadMenu() {
        click(pip);
    }

    public void clickStage(String stageName) {


    	    By stageBtn = By.xpath(
    	        "//h3[text()='" + stageName +
    	        "']/following::button[@class='flex items-center justify-center p-2 transition cursor-pointer']"
    	    );

    	    wait.until(
    	        ExpectedConditions.presenceOfElementLocated(stageBtn)
    	    );

    	    driver.findElement(stageBtn).click();
    	}
    

    public void enterFirstName(String name) {
        enter(firstName, name);
    }

    public void enterLastName(String name) {
        enter(lastName, name);
    }

    public void enterPhone(String number) {
        enter(phoneNumber, number);
    }

    public void enterAddress(String addr) {
        enter(address, addr);
    }

    public void enterPinCode(String code) {
        enter(pinCode, code);
    }

    public void selectLeadSource() {
        click(leadSourceDropdown);
    }

    public void selectWebsite() {
        click(websiteOption);
    }

    public void selectPriority() {
        click(leadPriorityDropdown);
    }

    public void selectMediumPriority() {
        Actions act = new Actions(driver);
        act.moveToElement(mediumOption).click().perform();
    }

    public void selectAssignedTo() {
        click(assignToDropdown);
    }

    public void selectEmployee() {
        click(assignToEmployee);
    }

    public void clickSubmit() {
        Actions act = new Actions(driver);
        act.moveToElement(submitBtn).click().perform();
    }

    public String success() {
        wait.until(ExpectedConditions.visibilityOf(successMsg));
        return successMsg.getText();
    }


    public void createLead(String stageName,
                           String fname,
                           String lname,
                           String phone,
                           String addr,
                           String pincode) {

        clickLeadMenu();

        clickStage(stageName);

        enterFirstName(fname);
        enterLastName(lname);
        enterPhone(phone);
        enterAddress(addr);
        enterPinCode(pincode);

        selectLeadSource();
        selectWebsite();

        selectPriority();
        selectMediumPriority();

        selectAssignedTo();
        selectEmployee();

        clickSubmit();
    }
}