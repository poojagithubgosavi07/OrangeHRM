/**
	 * 
	 */
	package com.orangeHRM.testcases;
	import static org.testng.Assert.assertTrue;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
//import org.testng.annotations.DataProvider;
	import org.testng.annotations.Test;

import com.orangeHRM.base.BaseClass;
//import com.mystore.dataprovider.DataProviders;
	import com.orangeHRM.pageobjects.HomePage;
	import com.orangeHRM.pageobjects.LoginPage;
import com.orangeHRM.utility.Log;
	//import com.mystore.utility.Log;

	/**
	 * @author Hitendra
	 *
	 */
	public class LoginPageTest extends BaseClass {
		 LoginPage lp;
		 HomePage hp;
		
		//private static final Logger logger = LogManager.getLogger(LoginPageTest.class);
		 
		 //@Parameters("browser")
		 @BeforeTest()
		 public void setup() 
		 {
			launchApp();  
			//BaseClassP.initialization();
		 }
		 
		 @Test(priority = 1)
		 public void verifyLogo() throws InterruptedException
		 {
			 lp = new LoginPage();
			 boolean result = lp.validateLogo();
			 Assert.assertTrue(result);
		 }
		 
		 @Test(priority = 2)
		 public void verifyTitle()
		 {
			 String title = lp.getorangeHRMTitle();
			 Assert.assertEquals(title, "OrangeHRM");
		 }
		
		 @Test(priority = 3)
			public void loginTest() throws Throwable
			//public void loginTest() throws Throwable
			{
			Log.startTestCase("loginTest");
			lp = new LoginPage();
			Log.info("Enter Username and Password");
			//hp=lg.login(uname,pswd);
			hp=lp.login(prop.getProperty("username"), prop.getProperty("password"));
			//String actualURL=hp.validategetCurrURL();
			String actualURL = driver.getCurrentUrl();
			String expectedURL="https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";
			Log.info("Verifying if user is able to login");
			Assert.assertEquals(actualURL, expectedURL);
			Log.info("Login is Sucess");
			Log.endTestCase("loginTest");
		}
		 
		@AfterTest()
		public void tearDown() {
			driver.quit();
		}
}

