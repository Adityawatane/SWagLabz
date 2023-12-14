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
import pages.Inventory_Page2;
import pages.LoginPage;

public class CheckOutPage2_Test extends TestBase
{
	LoginPage login;
	Inventory_Page2 invent;
	CartPage cart;
	CheckOutPage1 check1;
	CheckOutPage2 check2;
	@BeforeMethod
	public void setup() throws InterruptedException, IOException
	{
		initialization();
		login=new LoginPage();
		invent=new Inventory_Page2();
		cart=new CartPage();
		check1=new CheckOutPage1();
		check2=new CheckOutPage2();
		login.loginToApplication();
		invent.add6Cart();
		cart.remove3ProductCart();
		cart.checkoutbtn();
		check1.inputInformation();
		
	}
	
	@Test(priority = 2)
	public void verifyCheckoutPage2LableTest() {
		String expLable="Checkout: Overview";
		String actLable=check2.verifyCheckoutPage2Lable();
		Assert.assertEquals(expLable, actLable);
		Reporter.log("Lable of CheckOut Page 2"+actLable);
	}
	@Test(priority = 1)
	public void verifyPaymentInfoLableTest() {
		String expLable="Payment Information";
		String actLable=check2.verifyPaymentInfoLable();
		Assert.assertEquals(expLable, actLable);
		Reporter.log("Lable of Payment Info"+actLable);
	}
	@Test(priority = 7)
	public void verifyShippingInfoLableTest() {
		String expLable="Shipping Information";
		String actLable=check2.verifyShippingInfoLable();
		Assert.assertEquals(expLable, actLable);
		Reporter.log("Lable of Shipping Info"+actLable);
	}
	@Test(priority = 3)
	public void verifyPriceTotalLableTest() {
		String expLable="Price Total";
		String actLable=check2.verifyPriceTotalLable();
		Assert.assertEquals(expLable, actLable);
		Reporter.log("Lable of Price Info"+actLable);
	}
	@Test(priority = 4)
	public void verifyFinishbtnUrl() {
		String expUrl="https://www.saucedemo.com/checkout-complete.html";
		String actUrl=check2.finishbtnclick();
		Assert.assertEquals(expUrl, actUrl);
		Reporter.log("Url of FinshBtn Click "+actUrl);
	}
	@Test(priority = 5)
	public void cancelbtnTest() {
		String expUrl="https://www.saucedemo.com/inventory.html";
		String actUrl=check2.verifyCancelbtn();
		Assert.assertEquals(expUrl, actUrl);
		Reporter.log("Url of CancelBtn Click "+actUrl);
	}
	@Test(priority = 6)
	public void verifyTotalFinalPriceTest() {
		String exptext="Total: $79.89";
		String actText=check2.verifyTotalFinalPrice();
		Assert.assertEquals(exptext, actText);
		Reporter.log("Total Final Price "+actText);
	}
	
	@AfterMethod
	public void closeBroweser() {
		driver.close();
	}
	
}
