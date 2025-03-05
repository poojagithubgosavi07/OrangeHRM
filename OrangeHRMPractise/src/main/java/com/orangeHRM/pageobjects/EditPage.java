package com.orangeHRM.pageobjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.orangeHRM.actiondriver.Action;
import com.orangeHRM.base.BaseClass;

public class EditPage extends BaseClass {
	Actions act;

	@FindBy(xpath="//div[@class='oxd-table-body']/div[2]/div/div[6]/div/button[2]")
	WebElement edit;
	
	@FindBy(xpath="//div[@class='oxd-grid-2 orangehrm-full-width-grid']/div[1]/div/div[2]/div/div/div[2]/i")
	WebElement userRole;
	
	@FindBy(xpath="//div[@class='oxd-grid-2 orangehrm-full-width-grid']/div[1]/div/div[2]/div/div")
	WebElement essUserRole;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement saveEditUser;
	
	public EditPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void validateEdit() throws InterruptedException
	{
		Thread.sleep(2000);
		Action.click(driver, edit);
	}
	
	public void validateUserRole() throws InterruptedException
	{
		Thread.sleep(2000);
		Action.click(driver, userRole);
		Thread.sleep(1000);
		Action.selectByIndex(essUserRole, 1);
		Thread.sleep(2000);
		act = new Actions(driver);
		act.keyDown(Keys.ARROW_DOWN).build().perform();
		act.keyDown(Keys.ARROW_DOWN).build().perform();
		act.click();
	}
	
	public void validateSave() throws Exception  
	{
		Thread.sleep(2000);
		//Action.click(driver, saveEditUser);
		Action.JSClick(driver, saveEditUser);
		Thread.sleep(2000);
		//return new SystemUserPage();
	}
}
