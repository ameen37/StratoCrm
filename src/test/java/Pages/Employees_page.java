package Pages;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Employees_page {
	WebDriver driver;
	WebDriverWait wait;
 public Employees_page(WebDriver driver){
	this.driver= driver;
	PageFactory.initElements(driver,this);
	  wait = new WebDriverWait(driver, Duration.ofSeconds(3));
	  }
@FindBy(xpath="//span[text()='Employees']")
WebElement emp;
@FindBy(xpath="//span[contains(text(),'New Employee')]")
WebElement newemp;
@FindBy(xpath="//button[normalize-space()='Invite by Link']")
WebElement link;
@FindBy(xpath="//button[@type='button']/following::span[contains(text(),'Select Role')]")
WebElement role;
@FindBy(xpath="//button[.//span[contains(text(),'Executive')]]")
WebElement exe;
@FindBy(xpath="//button[@type='button']/following::span[contains(text(),'Select Department')]")
WebElement dep;
@FindBy(xpath="//button[.//span[contains(text(),'Sales')]]")
WebElement sales;
@FindBy(xpath="//button[@type='button']/following::span[contains(text(),'Select Reporting Manager')]")
WebElement rept;
@FindBy(xpath="//button[.//span[contains(text(),'Balu')]]")
WebElement mana;
@FindBy(xpath="//span[normalize-space()='Generate Link']")
WebElement btn;
@FindBy(xpath="//button[contains(@class,'flex items-center gap-2 px-5 py-2 text-(--accent) rounded-lg hover:bg-(--accent-light)')]")
WebElement copy;

@FindBy(xpath="//input[@type='text'][1]")
WebElement names;

@FindBy(xpath="//label[contains(text(),'Email Address')]/following::input[@type='text']")
WebElement email;

@FindBy(xpath="//label[contains(text(),'Password')]/following::input[@type='password']")
WebElement pass;

@FindBy(xpath="//label[contains(text(),'Confirm Password')]/following::input[@type='password']")
WebElement confirm;
@FindBy(xpath="//button[@type='submit']")
WebElement submit;
		
	
public void click(WebElement element) {
	wait.until(ExpectedConditions.elementToBeClickable(element));
	element.click();
}
public void enter(WebElement element, String txt) {
	wait.until(ExpectedConditions.visibilityOf(element));
	element.sendKeys(txt);
}
public void navigate() {
	String gen= driver.findElement(By.xpath("//input[@readonly]")).getAttribute("value");
	driver.navigate().to(gen);
}
public void create_employee(String name, String emails,String passw, String cpass) throws InterruptedException {
	click(emp);
	click(newemp);
	click(link);
	click(role);
	click(exe);
	click(dep);
	click(sales);
	click(rept);
	click(mana);
	click(btn);
	Thread.sleep(1000);
	click(copy);
	navigate();
	enter(names,name);
	enter(email,emails);
	enter(pass,passw);
	enter(confirm,cpass);
	click(submit);
	 
}



}
