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

public class AdminPageTest extends BaseClass {
	LoginPage lp;
	HomePage hp;
	AdminPage ap;
	AddUserPage aup;
	
		//@Parameters("browser")
	 	@BeforeTest()
	 	public void setup() throws Throwable 
	 	{
	 		launchApp();  	
			lp = new LoginPage();
		    hp = lp.login(prop.getProperty("username"), prop.getProperty("password"));
			//hp=lp.login(uname,pswd);
		    ap = hp.validateAdminTab();
		    ap = new AdminPage();
	 	}
	
	 	@Test
		public void verifyAddUser() throws Throwable
		{
			aup = ap.validateAddUser();  //aup=add user page //ap=admin page
			Thread.sleep(2000);
			String acctualURL = driver.getCurrentUrl();
			String expectedURL = "https://opensource-demo.orangehrmlive.com/web/index.php/admin/saveSystemUser";
			Assert.assertEquals(acctualURL, expectedURL);
		}
		
		@AfterTest()
		public void tearDown() {
			driver.quit();
		}
		
		/*try {
			ap.validateAddUserButton();
			
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("Here we are getting null pointer exception");
		}
		
		String acctualURL = driver.getCurrentUrl();
		String expectedURL = "https://opensource-demo.orangehrmlive.com/web/index.php/admin/saveSystemUser";
		Assert.assertEquals(acctualURL, expectedURL);*/	
}

	/*
	 //@Parameters({"uname1"})
	 
	@Test(priority=5)
	public void verifyAddUserUsername() throws Throwable {
		Thread.sleep(3000);
		ap.validateAddUserUsername("Test");
	}
	
	@Test(priority=2)
	public void verifyAddUserUserRole() throws Throwable {
		ap.validateAddUserUsersRole();
	}
	
	@Parameters({"empuname1"})
	@Test(priority=3)
	public void veifyAddUserEMPname(@Optional("Test")String empuname1) throws Throwable {
		ap.validateAddUserEMPname("Orange Test");
	}
	
	@Test(priority=4)
	public void verifyAddUserStatus() throws Throwable {
		ap.validateAddUserStatus();
	}

	@Test(priority=6)
	public void verifyPassword(String pass1) throws Throwable {
		ap.validatePassword("Test@123");
	}
	
	@Test(priority=7)
	public void verifyConfirmPassword() throws Throwable {
		ap.validateConfirmPassword("Test@123");
	}
	
	@Test(priority=8)
	public void verifySaveUserButton() throws Throwable {
		Thread.sleep(3000);
		ap.validateAddUserSave();
	}

	
	@AfterTest()
	public void tearDown() {
		driver.quit();
	}
}

*/