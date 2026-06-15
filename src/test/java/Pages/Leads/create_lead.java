package Pages.Leads;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class create_lead {

    WebDriver driver;
    WebDriverWait wait;

    public create_lead(WebDriver driver) {

        this.driver = driver;

        PageFactory.initElements(driver, this);

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @FindBy(xpath ="//div[@data-tour= 'leads']")
    WebElement leadMenu;

    @FindBy(xpath = "//span[text()='Create Lead']")
    WebElement createLeadBtn;

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

    @FindBy(xpath = "//span[text()='Website']")
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
        wait.until(
                ExpectedConditions.elementToBeClickable(element));
        element.click();
    }
    private void enter(WebElement element, String txt) {
    	wait.until(ExpectedConditions.visibilityOf(element));
    	element.sendKeys(txt);
    }

    public void clickLeadMenu() {
    	  System.out.println("Lead Menu = " + leadMenu);
        click(leadMenu);
    }

    public void clickCreateLead() {
    	
        click(createLeadBtn);
    }

    public void enterFirstName(String name) {

        enter(firstName,name);
    }

    public void enterLastName(String name) {
        lastName.sendKeys(name);
    }

    public void enterPhone(String number) {
        phoneNumber.sendKeys(number);
    }

    public void enterAddress(String addr) {
        address.sendKeys(addr);
    }

    public void enterPinCode(String code) {
        pinCode.sendKeys(code);
    }

    public void selectLeadSource() {
        leadSourceDropdown.click();
        websiteOption.click();
    }

    public void selectPriority() {
        leadPriorityDropdown.click();

        Actions act = new Actions(driver);
        act.moveToElement(mediumOption).click().perform();
    }

    public void selectAssignedTo() {
        assignToDropdown.click();
        assignToEmployee.click();
    }

    public void clickSubmit() {
        Actions act = new Actions(driver);
        act.moveToElement(submitBtn).click().perform();
    }
    public String success() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(
                ExpectedConditions.visibilityOf(successMsg));
                return successMsg.getText();
    }

    public void createLead(String fname, String lname,
                           String phone, String addr,
                           String pincode) {

        clickLeadMenu();
        clickCreateLead();

        enterFirstName(fname);
        enterLastName(lname);
        enterPhone(phone);
        enterAddress(addr);
        enterPinCode(pincode);

        selectLeadSource();
        selectPriority();
        selectAssignedTo();

        clickSubmit();
    }
}