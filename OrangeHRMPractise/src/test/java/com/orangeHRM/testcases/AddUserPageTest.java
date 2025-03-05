package com.orangeHRM.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.orangeHRM.actiondriver.Action;
import com.orangeHRM.base.BaseClass;
import com.orangeHRM.pageobjects.AddUserPage;
import com.orangeHRM.pageobjects.AdminPage;
import com.orangeHRM.pageobjects.HomePage;
import com.orangeHRM.pageobjects.LoginPage;
import com.orangeHRM.pageobjects.SystemUserPage;

public class AddUserPageTest extends BaseClass {
	LoginPage lp;
	HomePage hp;
	AdminPage ap;
	AddUserPage aup;
	SystemUserPage sup;
	
		//@Parameters("browser")
	 	@BeforeTest()
	 	public void setup() throws Throwable 
	 	{
	 		launchApp();  	
			lp = new LoginPage();
		    hp = lp.login(prop.getProperty("username"), prop.getProperty("password")); //loginpage
			//hp=lp.login(uname,pswd);
		    ap = hp.validateAdminTab(); //homepage
		    aup = ap.validateAddUser(); //adminpage 
		    aup = new AddUserPage(); //adduserpage
	 	}
	
	@Test(priority=1)
	public void verifyAddUserUsername() throws Throwable {
		Thread.sleep(3000);
		aup.validateAddUserUsername();
	}
	
	@Test(priority=2)
	public void verifyAddUserUserRole() throws Throwable {
		aup.validateAddUserUsersRole();
	}
	
	@Test(priority=3)
	public void veifyAddUserEMPname() throws Throwable {
		aup.validateAddUserEMPname();
	}
	
	@Test(priority=4)
	public void verifyAddUserStatus() throws Throwable {
		aup.validateAddUserStatus();
	}

	@Test(priority=5)
	public void verifyPassword() throws Throwable {
		sup = aup.validatePassword();
		
		
		//aup.validatePassword();
	}
	
	/*@Test(priority=6)
	public void verifyConfirmPassword() throws Throwable {
		aup.validateConfirmPassword();
	}*/
	
	/*@Test(priority=6)
	public void verifySaveUserButton() throws Throwable {
		sup = aup.validateAddUserSave();
	}*/
	
	@AfterTest()
	public void tearDown() {
		driver.quit();
	}
}
