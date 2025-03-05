package com.orangeHRM.pageobjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.orangeHRM.actiondriver.Action;
import com.orangeHRM.base.BaseClass;

public class AddUserPage extends BaseClass {
	Actions act;
	
	@FindBy(xpath="//div[@class='oxd-grid-item oxd-grid-item--gutters'][1]/div/div/div/div/div/i")
	WebElement addUserUserRole;
	
	@FindBy(xpath="//div[@class='oxd-grid-item oxd-grid-item--gutters'][1]/div/div/div/div")
	WebElement adminUserUserRole;
	
	@FindBy(xpath="//input[@placeholder='Type for hints...']")
	WebElement addUserEmployeeName;
	
	@FindBy(xpath="//div[@class='oxd-grid-item oxd-grid-item--gutters'][3]/div/div/div/div/div/i")
	WebElement addUserStatus;
	
	//form[@class='oxd-form']/div/div/div/div/div/input
	
	@FindBy(xpath="//div[@class='oxd-grid-item oxd-grid-item--gutters'][3]/div/div/div/div")
	WebElement enabledaddUserStatus;
	
	//div[@class='oxd-grid-item oxd-grid-item--gutters'][3]/div/div/div/div
	
	@FindBy(xpath="//div[@class='oxd-grid-item oxd-grid-item--gutters'][4]/div/div[2]/input")
	WebElement addUserUsername;
	
	//form[@class='oxd-form']/div/div/div[2]/div/div[2]/div[1]/div/div
	//form[@class='oxd-form']/div/div/div[2]/div/div[2]/div[1]/div/div/i
	//form[@class='oxd-form']/div/div/div[2]/div/div[2]/div[1]/div
	//form[@class='oxd-form']/div/div/div[2]/div/div[2]/div[1]/div/div
	
	@FindBy(xpath="//div[@class='oxd-grid-item oxd-grid-item--gutters user-password-cell']/div/div[2]/input")
	WebElement addUserPassword;
	
	@FindBy(xpath="//div[@class='oxd-form-row user-password-row']/div/div[2]/div/div[2]/input")
	WebElement addUserConfirmPassword;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement saveAddUser;
	
	//button[@type='submit']
	//div[@class='oxd-form-actions']/button[2]
	
	public AddUserPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void validateAddUserUsersRole() throws Throwable {
		Thread.sleep(2000);
		Action.click(driver, addUserUserRole);
		Thread.sleep(1000);
		Action.selectByIndex(adminUserUserRole, 1);
		//Action.selectByValue(addUserUserRole, "Admin");
		Thread.sleep(2000);
		act = new Actions(driver);
		act.keyDown(Keys.ARROW_DOWN).build().perform();
		act.click();
		//Action.click(driver, addUserUserRole);
	}
	
	//@Parameters({"empuname1"})
	public void validateAddUserEMPname() throws Throwable {
		Thread.sleep(2000);
		
		String ename= "Orange Test"; //Keely Ellsworth Daniel
		//String ename= "Keely Ellsworth Daniel";
		int count = 0;
		
		//Action.selectBySendkeys("Test", addUserEmployeeName);
		addUserEmployeeName.sendKeys("Orange");
		//addUserEmployeeName.sendKeys("Keely");
		Thread.sleep(3000);
		
		List<WebElement> allemployeenames = driver.findElements(By.xpath("//div[@role='listbox']"));
		
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
	
		
	public void validateAddUserStatus() throws Throwable {
		Thread.sleep(2000);
		Action.click(driver, addUserStatus);
		Thread.sleep(1000);
		Action.selectByVisibleText("Enabled", enabledaddUserStatus);
		//Action.selectByValue(addUserStatus, "Enabled");
		Thread.sleep(2000);
		act = new Actions(driver);
		act.keyDown(Keys.ARROW_DOWN).build().perform();
		act.click();
	}
		
	public void validateAddUserUsername() throws Throwable {
		Action.selectBySendkeys("Orange Test123", addUserUsername);
	}
	
	public SystemUserPage validatePassword() throws Throwable {
		Thread.sleep(1000);
		Action.selectBySendkeys("Test@28", addUserPassword);
		Thread.sleep(2000);
		//act.sendKeys(Keys.TAB);
		//Action.selectBySendkeys("Test@28", addUserConfirmPassword);
		addUserConfirmPassword.sendKeys("Test@28");
		Thread.sleep(1000);
		Action.click(driver, saveAddUser);
		//Action.JSClick(driver, saveAddUser);
		Thread.sleep(1000);
		//WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		//wait.until(ExpectedConditions.visibilityOfElementLocated("//div[@class='oxd-input-group oxd-input-field-bottom-space']/div/input"));
		//wait.until(ExpectedConditions.elementToBeClickable(("//div[@class='oxd-input-group oxd-input-field-bottom-space']/div/input"));
		return new SystemUserPage();
		
	}
	
	/*public void validateConfirmPassword() throws Throwable {
		Thread.sleep(3000);
		Action.selectBySendkeys("Test@28", addUserConfirmPassword);
	}*/
	
	/*public SystemUserPage validateAddUserSave() throws Exception  
	{
		//Thread.sleep(2000);
		Action.click(driver, saveAddUser);
		//Action.JSClick(driver, saveAddUser);
		Thread.sleep(2000);
		return new SystemUserPage();
	}*/
}
