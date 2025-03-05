package com.orangeHRM.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.orangeHRM.actiondriver.Action;
import com.orangeHRM.base.BaseClass;

public class AdminPage extends BaseClass {
	Action action= new Action();
	
	@FindBy(xpath="//button[@class='oxd-button oxd-button--medium oxd-button--secondary']/i")
	WebElement addbutton;
	//div[@class='orangehrm-header-container']/button
	
	/*@FindBy(xpath="//div[@class='oxd-grid-item oxd-grid-item--gutters'][1]/div/div/div/div/div[1]")
	WebElement addUserUserRole;
	
	@FindBy(xpath="//input[@placeholder='Type for hints...']")
	WebElement addUserEmployeeName;
	
	@FindBy(xpath="//div[@class='oxd-grid-item oxd-grid-item--gutters'][3]/div/div/div/div/div[1]")
	WebElement addUserStatus;
	
	//form[@class='oxd-form']/div/div/div/div/div/input
	
	@FindBy(xpath="//div[@class='oxd-grid-item oxd-grid-item--gutters'][4]/div/div[2]/input")
	WebElement addUserUsername;
	
	//form[@class='oxd-form']/div/div/div[2]/div/div[2]/div[1]/div/div
	//form[@class='oxd-form']/div/div/div[2]/div/div[2]/div[1]/div/div/i
	//form[@class='oxd-form']/div/div/div[2]/div/div[2]/div[1]/div
	//form[@class='oxd-form']/div/div/div[2]/div/div[2]/div[1]/div/div
	
	@FindBy(xpath="//div[@class='oxd-grid-item oxd-grid-item--gutters user-password-cell']/div/div[2]/input")
	WebElement addUserPassword;
	
	@FindBy(xpath="//div[@class='oxd-form-row user-password-row']/div/div[2]/div/div/input]")
	WebElement addUserConfirmPassword;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement SaveUser;*/
	
	public AdminPage() {
		PageFactory.initElements(driver, this);
	}
	
	public AddUserPage validateAddUser() throws Throwable{
		
		
		Thread.sleep(2000);
		//addbutton.click();
		Action.click(driver, addbutton);
		//Action.JSClick(driver, addbutton);
		return new AddUserPage();
	}
	
}
/*
	public void validateAddUserUsersRole() throws Throwable {
		Thread.sleep(2000);
		Action.click(driver, addUserUserRole);
		Action.selectByValue(addUserUserRole, "Admin");
		Action.click(driver, addUserUserRole);
	}
	
	//@Parameters({"empuname1"})
		public void validateAddUserEMPname(String empuname1) throws Throwable {
			Action.type(addUserEmployeeName, empuname1);
		}
		
	public void validateAddUserStatus() throws Throwable {
		Action.click(driver, addUserStatus);
		Thread.sleep(2000);
		Action.selectByValue(addUserStatus, "Enabled");
		Action.click(driver, addUserStatus);
	}
		
	//@Parameters({"uname1"})
	public void validateAddUserUsername(String uname1) throws Throwable {
		Action.type(addUserUsername, uname1);
	}
	
	public void validatePassword(String pass1) throws Throwable {
		Action.type(addUserUsername, pass1);
	}
	
	public void validateConfirmPassword(String cpass1) throws Throwable {
		Action.type(addUserUsername, cpass1);
	}
	
	public void validateAddUserSave() 
	{
		Action.click(driver, SaveUser);
	}
	
	
	
}
*/