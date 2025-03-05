package com.orangeHRM.testcases;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.orangeHRM.base.BaseClass;
import com.orangeHRM.pageobjects.EditPage;
import com.orangeHRM.pageobjects.HomePage;
import com.orangeHRM.pageobjects.LoginPage;
import com.orangeHRM.pageobjects.SystemUserPage;

public class EditPageTest extends BaseClass {

	LoginPage lp;
	HomePage hp;
	SystemUserPage sup;
	EditPage ed;
	
	@BeforeTest()
 	public void setup() throws Throwable 
 	{
 		launchApp();  	
		lp = new LoginPage();
	    hp = lp.login(prop.getProperty("username"), prop.getProperty("password"));
		//hp=lp.login(uname,pswd);
	    hp.validateAdminTab();
	    sup = new SystemUserPage();
	    ed = new EditPage();
 	}
	
	@Test(priority=1)
	public void verifyUsername() {
	     sup.validateUsername();
	}
	
	@Test(priority=2)
	public void verifyUserRole() throws Throwable {
	     sup.validateUserRole();
	}
	
	@Test(priority=3)
	public void verifyEmployee() throws InterruptedException {
	     sup.validateEmployeeName();
	}
	
	@AfterTest()
	public void tearDown() {
		driver.quit();
	}
}
