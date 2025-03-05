/**
	 * 
	 */
	package com.orangeHRM.pageobjects;

	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;

	import com.orangeHRM.actiondriver.Action;
	import com.orangeHRM.base.BaseClass;

	/**
	 * @author Hitendra
	 *  
	 */
	public class LoginPage extends BaseClass {
		
		Action action= new Action();
		
		@FindBy(name="username")
		WebElement userName;
		
		@FindBy(name="password")
		WebElement password;

		@FindBy(xpath="//button[@type='submit']")
		WebElement LoginBtn;
		
		@FindBy(xpath="//img[@alt='company-branding']")
		WebElement OragneHRMLogo;
		
		public LoginPage() {
			PageFactory.initElements(driver, this);
		}
		
		public boolean validateLogo() throws InterruptedException {
			Thread.sleep(3000);
			return Action.isDisplayed(driver, OragneHRMLogo);
		}
		
		public HomePage login(String uname, String pswd) throws Throwable {
			//Action.scrollByVisibilityOfElement(getDriver(), userName);
			Action.type(userName, uname);
			Action.type(password, pswd);
			//Action.JSClick(getDriver(), LoginBtn);
			Action.click(driver, LoginBtn);
			Thread.sleep(2000);
			return new HomePage();
		}
		
		public String getorangeHRMTitle()
		{
			return Action.getTitle(driver);
		}
		
		/* public String getcurrentURL()
		{
			return Action.getCurrentURL(driver);
		}*/
		
		/*public String getorangeHRMTitle() {
			String orangeHRMTitel=driver.getTitle();
			return orangeHRMTitel;
		}*/
}