package testCases;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pages.Inventory_Page2;
import pages.LoginPage;
import utility.CaptureScreenshot;
import utility.ReadData;

public class Inventory_Page2_Test extends TestBase
{

	LoginPage login;
	Inventory_Page2 invent;
	@BeforeMethod
	public void setup() throws InterruptedException, IOException 
	{
		initialization();
		login=new LoginPage();
		invent=new Inventory_Page2();
		login.loginToApplication();
	}
	
	@Test(priority = 2)
	public void verifyProductLableTest() throws EncryptedDocumentException, IOException 
	{
		String expLable=ReadData.readExcel(0, 3); //Products(0,3)
		String actLable=invent.verifyProductLable();
		Assert.assertEquals(expLable, actLable);
		Reporter.log("Lable Of Inventory Page = " +actLable);
	}
	@Test(priority = 3,groups="Sanity")
	public void verifytwitterLogoTest() 
	{
		boolean result=invent.verifytwitterLogo();
		Assert.assertEquals(result, true);
		Reporter.log("Visibility of Twiter Logo = " +result);
	}
	@Test(priority = 1,groups="Regression")
	public void add6CartTest() throws EncryptedDocumentException, IOException 
	{
		String expCount=ReadData.readExcel(0, 4);; //6 (0,4)
		String actCount=invent.add6Cart();
		Assert.assertEquals(expCount, actCount);
		Reporter.log("Total Product Added to Cart = " +actCount);
	}
	@Test(priority = 4,dependsOnMethods = "add6CartTest")
	public void remove2ProductTest() throws InterruptedException, EncryptedDocumentException, IOException 
	{
		String expCount=ReadData.readExcel(0, 5);; //4(0,5)
		String actCount=invent.remove2Product();
		Assert.assertEquals(expCount, actCount);
		Reporter.log("Count of Product after removing = " +actCount);
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
