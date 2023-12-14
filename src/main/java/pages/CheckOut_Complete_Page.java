package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class CheckOut_Complete_Page extends TestBase

{

	@FindBy(xpath="//span[@class='title']")private WebElement checkoutCompleteLable;
	@FindBy(xpath="//img[@alt='Pony Express']")private WebElement image;
	@FindBy(xpath="//h2[@class='complete-header']")private WebElement textThankyou;
	@FindBy(xpath="//div[@class='complete-text']")private WebElement textyourorder;
	
	@FindBy(xpath="//button[@class='btn btn_primary btn_small']")private WebElement backHomebtn;
	
	public CheckOut_Complete_Page()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String verifycheckoutCompleteLable()
	{
		return checkoutCompleteLable.getText();
	}
	
	public boolean imagedisplay()
	{
		return image.isDisplayed();
	}
	
	public String verifyThankyouMessage()
	{
		return textThankyou.getText();
	}
	
	public String verifyYourOrderMessage()
	{
		return textyourorder.getText();
	}
	
	public String verifyBackHomebtn()
	{
		backHomebtn.click();
		return driver.getCurrentUrl();
	}
}
