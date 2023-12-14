package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pages.CartPage;
import pages.Inventory_Page2;
import pages.LoginPage;
import utility.CaptureScreenshot;

public class CartPageTest extends TestBase
{

	LoginPage login;
	Inventory_Page2 invent;
	CartPage cart;
	@BeforeMethod
	public void setup() throws InterruptedException, IOException 
	{
		initialization();
		login=new LoginPage();
		invent=new Inventory_Page2();
		cart=new CartPage();
		login.loginToApplication();
		invent.add6Cart();
	}
	
	@Test(priority = 2)
	public void verifyCartUrlApplicationTest() throws InterruptedException 
	{
		String actUrl="https://www.saucedemo.com/cart.html";
		String expUrl=cart.verifyCartUrlApplication();
		Thread.sleep(3000);
		Assert.assertEquals(expUrl, actUrl);
	}
	@Test(priority = 1)
	public void verifyProductLableCartTest() 
	{
		String expLable="Your Cart";
		String actLable=cart.verifyProductLableCart();
		Assert.assertEquals(expLable, actLable);
		
	}
	@Test(priority = 3)
	public void remove3ProductCartTest() throws InterruptedException {
		String expCount="3";
		String actCount=cart.remove3ProductCart();
		Assert.assertEquals(expCount, actCount);
	}
	@Test(priority = 4)
	public void verifyContinueShoppingCartUrlTest() throws InterruptedException {
		String expUrl="https://www.saucedemo.com/inventory.html";
		String actUrl=cart.verifyContinueShoppingCartUrl();
		Assert.assertEquals(expUrl, actUrl);
	}
	@Test(priority = 6)
	public void verifyUrlCheckoutTest() throws InterruptedException {
		String expUrl="https://www.saucedemo.com/checkout-step-one.html";
		String actUrl=cart.verifyUrlCheckout();
		Assert.assertEquals(expUrl, actUrl);
	}
	@Test(priority = 5)
	public void verifyCartQTYlableTest() throws InterruptedException {
		String explable="QTY";
		String actLable=cart.verifyCartQTYlable();
		Assert.assertEquals(explable, actLable);
	}
	@Test(priority = 8)
	public void verifyCartdecriptionLableTest() throws InterruptedException {
		String expLable="Description";
		String actLable=cart.verifyCartdecriptionLable();
		Assert.assertEquals(expLable, actLable);
	}
	@Test(priority = 7)
	public void verifyCartPagetwitterLogoTest() throws InterruptedException {
		boolean result=cart.verifyCartPagetwitterLogo();
		Assert.assertEquals(result, true);
		Reporter.log("Visibility of Cart page Twiter Logo = " +result);
	}
	@Test(priority = 1)
	public void verifyCartPageFacebookLogoTest() throws InterruptedException {
		boolean result=cart.verifyCartPageFacebookLogo();
		Assert.assertEquals(result, true);
		Reporter.log("Visibility of Cart page FaceBook Logo = " +result);
	}
	@Test(priority = 9)
	public void verifyCartPageLinkdinLogoTest() throws InterruptedException {
		boolean result=cart.verifyCartPageLinkdinLogo();
		Assert.assertEquals(result, true);
		Reporter.log("Visibility of Cart page Linkdin Logo = " +result);
	}
	@Test(enabled = false,priority = 10)
	public void checkoutbtnTest() {
		String expUrl="https://www.saucedemo.com/checkout-step-one.html";
		String actUrl=cart.checkoutbtn();
		Assert.assertEquals(expUrl, actUrl);
	}
	
	@AfterMethod
	public void closeBrowser(ITestResult it) throws IOException 
	{
		if(it.FAILURE==it.getStatus()) {
			CaptureScreenshot.screenshot(it.getName());
		}
		driver.close();
	}
}
