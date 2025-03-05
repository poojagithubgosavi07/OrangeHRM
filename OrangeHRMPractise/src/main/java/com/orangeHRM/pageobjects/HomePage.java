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
	public class HomePage extends BaseClass {
		
		Action action= new Action();
		
		@FindBy(xpath="//li[@class='oxd-main-menu-item-wrapper'][1]/a")
		WebElement adminTab;
		
		public HomePage() {
			PageFactory.initElements(driver, this);
		}
		
		public AdminPage validateAdminTab() throws Throwable {
			 Action.click(driver, adminTab);
			 Thread.sleep(2000);
			 return new AdminPage();
		}

		/*public String validategetCurrURL() throws Throwable {
			String adminPageURL=Action.getCurrentURL(driver);
			return adminPageURL;
		}*/
}

