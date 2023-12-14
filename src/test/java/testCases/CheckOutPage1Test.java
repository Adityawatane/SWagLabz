package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pages.CartPage;
import pages.CheckOutPage1;
import pages.Inventory_Page2;
import pages.LoginPage;

public class CheckOutPage1Test extends TestBase

{

	LoginPage login;
	Inventory_Page2 invent;
	CartPage cart;
	CheckOutPage1 check1;
	@BeforeMethod
	public void setup() throws InterruptedException, IOException
	{
		initialization();
		login=new LoginPage();
		invent=new Inventory_Page2();
		cart=new CartPage();
		check1=new CheckOutPage1();
		login.loginToApplication();
		invent.add6Cart();
		cart.remove3ProductCart();
		cart.checkoutbtn();
	}
	
	@Test(priority = 1)
	public void verifyUrlCheckoutPage1Test()
	{
		String expUrl="https://www.saucedemo.com/checkout-step-one.html";
		String actUrl=check1.verifyUrlCheckoutPage1();
		Assert.assertEquals(expUrl, actUrl);
		Reporter.log("URL of checkoutPage 1 " +actUrl);
	}
	@Test(priority = 2,enabled = false)
	public void verifyLableCheckoutPage1Test() {
		String expLable="Checkout: Your Information";
		String actLable=check1.verifyLableCheckoutPage1();
		Assert.assertEquals(expLable, actLable);
		Reporter.log("Lable of checkoutPage 1 " +actLable);
	}
	@Test(priority = 3)
	public void inputInformationTest() 
	{
		String expUrl="https://www.saucedemo.com/checkout-step-two.html";
		String actUrl=check1.inputInformation();
		Assert.assertEquals(expUrl, actUrl);
		Reporter.log("Url Of checkout Page 2 " +actUrl);
	}
	
	@AfterMethod
	public void closebrowser() {
		driver.close();
	}
}
