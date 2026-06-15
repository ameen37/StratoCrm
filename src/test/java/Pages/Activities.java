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

public class Activities {
	WebDriverWait wait;
	WebDriver driver;
	public Activities(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver,this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	@FindBy(xpath="//span[contains(text(),'Activities')]")
	WebElement module;
	@FindBy(xpath="//button[.//span[contains(text(),'Add Activity')]]")
	WebElement Add;
	@FindBy(name="activity_info")
	WebElement Name;
	@FindBy(xpath="//span[contains(text(),'Select Activity Type')]")
	WebElement activitytype;
	
	@FindBy(xpath="//input[@placeholder='Select date']")
	WebElement date;
	@FindBy(xpath="//div[@aria-label='Choose Wednesday, June 24th, 2026']")
	WebElement dateselection;
	@FindBy(xpath="//input[@placeholder='Select time'][1]")
	WebElement starttime;
	@FindBy(xpath="//li[normalize-space()='10:45']")
	WebElement selectstarttime;
	@FindBy(xpath="//label[text()='End Time']/following::input[@placeholder='Select time'][1]")
	WebElement endtime;
	@FindBy(xpath="//li[normalize-space()='15:45']")
	WebElement selectendtime;
	@FindBy(xpath="//label[text()='Assign To']/following::button[@type='button']")
	WebElement assignee;
	@FindBy(xpath="//button[.//span[contains(text(),'Priya')]]")
	WebElement selectassignee;
	@FindBy(xpath="//span[contains(text(),'Select Lead')]")
	WebElement lead;
	@FindBy(xpath="//button[.//span[contains(text(),'sachin Kalal')]]")
	WebElement selectlead;
	
	@FindBy(xpath="//button[.//span[text()='Select Priority']]")
	WebElement priority;
	
	@FindBy(xpath="//button[.//span[text()='Medium']]")
	WebElement selectpriority;

	@FindBy(xpath="//span[text()='Save Activity']")
	WebElement save;
	public void click(WebElement element) {
		wait.until(ExpectedConditions.elementToBeClickable(element));
		element.click();
	}
	public void selecting() {
		Actions act= new Actions(driver);
		act.moveToElement(selectlead).click().perform();
		
	}
	public void enter(WebElement element, String txt) {
		wait.until(ExpectedConditions.visibilityOf( element));
		element.sendKeys(txt);
	}
	public void activity_type(String typename) {
		By type= By.xpath("//button[.//span[contains(text(),'"+typename+"')]]");
		wait.until(
    	        ExpectedConditions.presenceOfElementLocated(type)
    	    );
		driver.findElement(type).click();
}
	public void select_assigneeto() {
		Actions act= new Actions(driver);
		act.moveToElement(assignee).click().perform();
		
	}
	public void select_assignee() {
		Actions act= new Actions(driver);
		act.moveToElement(selectassignee).click().perform();
		
	}
	

	public void create_activity(String name,String type) {
		click(module);
		click(Add);
		enter(Name, name);
		click(activitytype);
		activity_type(type);
		click(date);
		click(dateselection);
		click(starttime);
		click(selectstarttime);
		click(endtime);
		click(selectendtime);
		select_assigneeto();
		select_assignee();
		click(lead);
		selecting();
		click(priority);
		click(selectpriority);
		click(save);
		
	}


}
