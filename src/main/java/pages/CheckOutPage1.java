package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class CheckOutPage1 extends TestBase
{

	@FindBy(xpath="//span[@class='title']")private WebElement checkout1lable;
	@FindBy(xpath="//input[@id='first-name']")private WebElement fnamecheckout;
	@FindBy(xpath="//input[@id='last-name']")private WebElement lnamecheckout;
	@FindBy(xpath="//input[@id='postal-code']")private WebElement postalcodecheckout;
	@FindBy(xpath="//input[@id='continue']")private WebElement continuebtn;
	
	public CheckOutPage1() 
	{
		PageFactory.initElements(driver, this);
	}
	
	public String verifyUrlCheckoutPage1() 
	{
		return driver.getCurrentUrl();
	}
	
	public String verifyLableCheckoutPage1() 
	{
		return checkout1lable.getText();
	}
	
	public String inputInformation()
	{
		fnamecheckout.sendKeys("Aditya");
		lnamecheckout.sendKeys("watane");
		postalcodecheckout.sendKeys("411236");
		continuebtn.click();
		return driver.getCurrentUrl();
	}
	
}
