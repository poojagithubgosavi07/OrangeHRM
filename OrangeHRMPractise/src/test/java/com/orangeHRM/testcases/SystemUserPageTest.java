package com.orangeHRM.testcases;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.orangeHRM.base.BaseClass;
import com.orangeHRM.pageobjects.AddUserPage;
import com.orangeHRM.pageobjects.AdminPage;
import com.orangeHRM.pageobjects.EditPage;
import com.orangeHRM.pageobjects.HomePage;
import com.orangeHRM.pageobjects.LoginPage;
import com.orangeHRM.pageobjects.SystemUserPage;

public class SystemUserPageTest extends BaseClass {

	LoginPage lp;
	HomePage hp;
	AdminPage ap;
	//AddUserPage aup;
	SystemUserPage sup;
	EditPage ed;
	
	@BeforeTest()
 	public void setup() throws Throwable 
 	{
 		launchApp();  	
		lp = new LoginPage();
	    hp = lp.login(prop.getProperty("username"), prop.getProperty("password"));
		//hp=lp.login(uname,pswd);
	    ap = hp.validateAdminTab();
	    //aup = ap.validateAddUser();
	    //aup = new AddUserPage();
	    sup = new SystemUserPage();
	    //sup = aup.validatePassword();
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
	
	@Test(priority=4)
	public void verifyStatus() throws Throwable {
	     sup.validateStatus();
	}
	
	@Test(priority=5)
	public void verifySearch() throws Throwable {
	     ed = sup.validateSearch();
	}
	
	/*@Test(priority=6)
	public void verifyEdit() throws Throwable {
	     sup.validateEdit();
	}*/
	
	@AfterTest()
	public void tearDown() {
		driver.quit();
	}
	
}
