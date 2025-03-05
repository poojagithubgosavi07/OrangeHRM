/**
 * 
 */
package com.orangeHRM.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.orangeHRM.actiondriver.Action;
import com.orangeHRM.base.BaseClass;
import com.orangeHRM.pageobjects.HomePage;
import com.orangeHRM.pageobjects.LoginPage;

/**
 * @author we
 *
 */
public class HomePageTest extends BaseClass {
	LoginPage lp;
	HomePage hp;
	
		//@Parameters("browser")
	 	@BeforeTest()
	 	public void setup() throws Throwable 
	 	{
	 		launchApp();  
		//BaseClass.initialization();
		lp = new LoginPage();
	    hp = lp.login(prop.getProperty("username"), prop.getProperty("password"));
		//hp=lp.login(uname,pswd);
	}
	
	@AfterTest()
	public void tearDown() {
		driver.quit();
	}
	
	@Test(priority=1)
	public void verifyAdminTab() throws Throwable
	{
		hp.validateAdminTab();
		String acctualURL = driver.getCurrentUrl();
		String expectedURL = "https://opensource-demo.orangehrmlive.com/web/index.php/admin/viewSystemUsers";
		Assert.assertEquals(acctualURL, expectedURL);
	}
	
	/*@Test(priority=2)
	public String verifygetCurrURL() throws Throwable {
		String adminPageURL=Action.getCurrentURL(driver);
		return adminPageURL;
	}*/

}
