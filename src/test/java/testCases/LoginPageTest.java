package testCases;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pages.LoginPage;
import utility.CaptureScreenshot;
import utility.ReadData;

public class LoginPageTest extends TestBase
{
	LoginPage login;

	@BeforeMethod
	public void setup() throws InterruptedException, IOException {
		initialization();
		login=new LoginPage();
	}
	@Test(priority = 1,groups="Sanity")
	public void verifyTitileOfApplicationTest() throws EncryptedDocumentException, IOException {
		String expTitle=ReadData.readExcel(0, 0);  //Swag Labs(0,0)
		String actTitle=login.verifyTitileOfApplication();
		Assert.assertEquals(expTitle, actTitle);
	}
	@Test(priority = 2,groups="Regression")
	public void verifyUrlOfApplicationTest() throws EncryptedDocumentException, IOException {
		String actUrl=ReadData.readExcel(0, 1); //https://www.saucedemo.com/ (0,1)
		String expUrl=login.verifyUrlOfApplication();
		Assert.assertEquals(actUrl, expUrl);
	}
	
	@Test(priority = 3,groups="Sanity")
	public void loginToApplicationTest() throws IOException
	{
		String expURL=ReadData.readExcel(0, 2);; //https://www.saucedemo.com/inventory.html (0,2)
		String actURL=login.loginToApplication();
		Assert.assertEquals(expURL,actURL);
	}

	@AfterMethod()
	public void closeBrowser(ITestResult it) throws IOException 
	{
		if(it.FAILURE==it.getStatus()) {
			CaptureScreenshot.screenshot(it.getName());
		}
		report.flush();
		driver.close();
	}
}
