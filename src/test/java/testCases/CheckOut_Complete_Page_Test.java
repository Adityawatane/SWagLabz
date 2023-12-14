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
import pages.CheckOutPage2;
import pages.CheckOut_Complete_Page;
import pages.Inventory_Page2;
import pages.LoginPage;

public class CheckOut_Complete_Page_Test extends TestBase
{

	LoginPage login;
	Inventory_Page2 invent;
	CartPage cart;
	CheckOutPage1 check1;
	CheckOutPage2 check2;
	CheckOut_Complete_Page completePage;
	@BeforeMethod
	public void setup() throws InterruptedException, IOException
	{
		initialization();
		login=new LoginPage();
		invent=new Inventory_Page2();
		cart=new CartPage();
		check1=new CheckOutPage1();
		check2=new CheckOutPage2();
		completePage=new CheckOut_Complete_Page();
		login.loginToApplication();
		invent.add6Cart();
		cart.remove3ProductCart();
		cart.checkoutbtn();
		check1.inputInformation();
		check2.finishbtnclick();
	}
	@Test
	public void verifycheckoutCompleteLableTest()
	{
		String expLable="Checkout: Complete!";
		String actLable=completePage.verifycheckoutCompleteLable();
		Assert.assertEquals(expLable, actLable);
		Reporter.log("Complete Level Page Lable "+actLable);
	}
	@Test
	public void imagedisplayTest() {
		boolean result=completePage.imagedisplay();
		Assert.assertEquals(result, true);
		Reporter.log("Visibility of Image = " +result);
	}
	@Test
	public void verifyThankyouMessageTest()
	{
		String expText="Thank you for your order!";
		String actText=completePage.verifyThankyouMessage();
		Assert.assertEquals(expText, actText);
		Reporter.log("Text Message Thank You "+actText);
	}
	@Test
	public void verifyYourOrderMessageTest()
	{
		String expText="Your order has been dispatched, and will arrive just as fast as the pony can get there!";
		String actText=completePage.verifyYourOrderMessage();
		Assert.assertEquals(expText, actText);
		Reporter.log("Text Message You Order "+actText);
	}
	@Test
	public void verifyBackHomebtnTest()
	{
		String expUrl="https://www.saucedemo.com/inventory.html";
		String actUrl=completePage.verifyBackHomebtn();
		Assert.assertEquals(expUrl, actUrl);
		Reporter.log("Url of Page "+actUrl);
	}
	
	@AfterMethod
	public void closeBrowser() {
		driver.close();
	}
}
