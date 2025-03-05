package com.orangeHRM.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.orangeHRM.actiondriver.Action;
import com.orangeHRM.base.BaseClass;

public class SystemUserPage extends BaseClass {

	Actions act;
	
	@FindBy(xpath="//div[@class='oxd-input-group oxd-input-field-bottom-space']/div/input")
	WebElement username;
	
	@FindBy(xpath="//i[@class='oxd-icon bi-caret-down-fill oxd-select-text--arrow']")
	WebElement userrole;
	
	@FindBy(xpath="//div[@class='oxd-select-text oxd-select-text--active']")
	WebElement essuserrole;
	
	@FindBy(xpath="//div[@class='oxd-autocomplete-text-input oxd-autocomplete-text-input--active']/input")
	WebElement employeename;
	
	@FindBy(xpath="//div[@class='oxd-form-row']/div/div[4]/div/div[2]/div/div/div[2]/i")
	WebElement status;
	
	@FindBy(xpath="//div[@class='oxd-grid-item oxd-grid-item--gutters'][4]/div/div[2]/div/div")
	WebElement enablestatus;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement search;
	
	@FindBy(xpath="//div[@class='oxd-table-body']/div/div/div[6]/div/button[2]")
	WebElement edit;
	
	public SystemUserPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void validateUsername(){
		//username.sendKeys("Nina.Patel");
		//Action.selectBySendkeys("Orange Test123", username);
		Action.selectBySendkeys("Admin", username);
	}
	
	public void validateUserRole() throws InterruptedException{
		Thread.sleep(2000);
		Action.click(driver, userrole);
		Thread.sleep(1000);
		//Action.selectByVisibleText("ESS", essuserrole);
		Action.selectByVisibleText("Admin", essuserrole);
		Thread.sleep(2000);
		act = new Actions(driver);
		act.keyDown(Keys.ARROW_DOWN).build().perform();
		//act.keyDown(Keys.ARROW_DOWN).build().perform();
		act.click();
		//Action.JSClick(driver, essuserrole);
		//Action.click(driver, essuserrole);
	}
	
	public void validateEmployeeName() throws InterruptedException{
		Thread.sleep(2000);
		
		//String ename = "Orange Test";
		String ename = "NewFirstNameNewFirstNameabc user123"; //Ahmed shanwany
		int count = 0;
		
		//Action.selectBySendkeys("Ni", employeename);
		//employeename.sendKeys("Oran");
		employeename.sendKeys("NewFirstNameNewFirstNameabc user123");
		Thread.sleep(4000);
		
		List<WebElement> allemployeenames = driver.findElements(By.xpath("//div[@role='listbox']"));
		//List<WebElement> allemployeenames = driver.findElements(By.xpath("//div[@role='option']"));
		
		for(WebElement aen: allemployeenames)
		{
			String currentOption = aen.getText();
			if(currentOption.contains(ename))
			{
				aen.click();
				break;
			}
		}
		if(count!=0)
		{
			System.out.println(ename+"has been selected from autosuggestion dropdown");
		}
		else
		{
			System.out.println("Option which you want to select is not avalilable in the autosuggestion dropdown");
		}
	}
	
	public void validateStatus() throws InterruptedException{
		Thread.sleep(2000);
		Action.click(driver, enablestatus);
		Thread.sleep(2000);
		Action.selectByVisibleText("Enabled", status);
		//Action.click(driver, enablestatus);
		Thread.sleep(2000);
		act = new Actions(driver);
		act.keyDown(Keys.ARROW_DOWN).build().perform();
		act.click();
	}
	
	public EditPage validateSearch() throws InterruptedException{
		Thread.sleep(1000);
		Action.JSClick(driver, search);
		//search.click();
		Thread.sleep(2000);
		return new EditPage();
	}

	/*public void validateEdit() throws InterruptedException{
		Thread.sleep(1000);
		Action.click(driver, edit);
		Thread.sleep(2000);
	}*/
	
	
}
