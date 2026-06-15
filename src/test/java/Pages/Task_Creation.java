package Pages;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class Task_Creation {
	WebDriver driver;
	WebDriverWait wait;

	public Task_Creation(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver,this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	@FindBy(xpath="//span[normalize-space()='Quick Create']")
	WebElement quick;
	@FindBy(xpath="//button[contains(text(),'Task')]")
	WebElement task;
	@FindBy(xpath="//button[.//span[contains(text(),'Select Owner')]]")
	WebElement dropdown;
	@FindBy(xpath="//button[.//span[contains(text(),'Radhe Mohan')]]")
	WebElement selectowner;
	@FindBy(xpath="//button[.//span[contains(text(),'Select Lead')]]")
	WebElement leaddrop;
	@FindBy(xpath="//button[.//span[contains(text(),'sachin Kalal')]]")
	WebElement selectlead;
	@FindBy(name="subject")
	WebElement info;
	@FindBy(xpath="//input[@placeholder='Select date & time']")
	WebElement datepicker;
	@FindBy(xpath="//div[@aria-label='Choose Thursday, June 18th, 2026']")
	WebElement choosedate;
	@FindBy(xpath="//li[contains(text(),'12:15')]")
	WebElement selecttime;
	@FindBy(xpath="//label[contains(text(),'End Date & Time')]/following::input[@placeholder='Select date & time'][1]")
	WebElement selectend;
	@FindBy(xpath="//div[@aria-label='Choose Thursday, June 18th, 2026']")
	WebElement chooseenddate;
	@FindBy(xpath="//li[contains(text(),'12:30')]")
	WebElement selectendtime;
	@FindBy(xpath="//button[.//span[contains(text(),'Select Priority')]]")
	WebElement dropdwonpriority;
	@FindBy(xpath="//button[.//span[contains(text(),'Medium')]]")
	WebElement selectpriority;
	@FindBy(xpath="//button[@type='submit']")
	WebElement create;
	public void owner() {
		Actions act= new Actions(driver);

		act.moveToElement(selectowner).click().perform();
	}
	public void selectstarttime() {
		Actions act= new Actions(driver);

		act.moveToElement(selecttime).click().perform();
	}
	public void selecendtime() {
		Actions act= new Actions(driver);

		act.moveToElement(selectendtime).click().perform();

	}
	public void click(WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element));
		element.click();
	}
	public void type(WebElement element, String text) {
		wait.until(ExpectedConditions.visibilityOf(element));
		element.sendKeys(text);
	}
	public void createtask() {
		click(quick);
		click(task);
		click(dropdown);
		owner();
		click(leaddrop);
		click(selectlead);
		type(info,"meet the client");
		click(datepicker);
		click(choosedate);
		selectstarttime();
		click(selectend);
		click(chooseenddate);
		selecendtime();
		click(dropdwonpriority);
		click(selectpriority);
		click(create);
		
		
		
		
		
	}
	
}
