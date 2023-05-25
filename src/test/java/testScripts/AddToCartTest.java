package testScripts;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import genericLibraries.BaseClass;

public class AddToCartTest  extends BaseClass {

	@Test
	
	public void addToCartTest() 
	{
		SoftAssert soft = new SoftAssert();
		
		home.clickGearsTab();
		home.clickSkillraryDemoApp();
		web.handleChildBrowser();
		
		soft.assertTrue(demoApp.getLogoText().contains("ECommerce"));
		demoApp.mouseHoverTiCourse(web);
		demoApp.clickSeleniumTrainig();
		
		soft.assertEquals(selenium.getPageHeader(), "Selenium Training");
		
		int initialQuantity = Integer.parseInt(selenium.getQuantity());
		selenium.doubleClickPlusButton(web);
		int finalQuantity = Integer.parseInt(selenium.getQuantity());
		soft.assertEquals(finalQuantity, initialQuantity);
		
		selenium.clickAddToCart();
		web.handleAlert("ok");
		soft.assertEquals(selenium.getMessage(), "Item added to cart");
		
		soft.assertAll();
	}
	
}
