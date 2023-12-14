package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class CheckOutPage2 extends TestBase
{

	@FindBy(xpath="//span[@class='title']")private WebElement checkoutpage2Lable;
	
	@FindBy(xpath="//div[text()='Payment Information']")private WebElement paymentinfoLable;
	@FindBy(xpath="//div[text()='Shipping Information']")private WebElement shippinginfoLable;
	@FindBy(xpath="//div[text()='Price Total']")private WebElement priceTotalLable;
	@FindBy(xpath="//div[@class='summary_info_label summary_total_label']")private WebElement totalFinalPriceLable;
	
	@FindBy(xpath="//button[text()='Finish']")private WebElement finishbtn;
	
	@FindBy(xpath="//button[@name='cancel']")private WebElement cancelbtn;
	public CheckOutPage2() {
		PageFactory.initElements(driver, this);
	}
	
	public String verifyCheckoutPage2Lable()
	{
		return checkoutpage2Lable.getText();
	}
	
	public String verifyPaymentInfoLable()
	{
		return paymentinfoLable.getText();
	}
	
	public String verifyShippingInfoLable()
	{
		return shippinginfoLable.getText();
	}
	
	public String verifyPriceTotalLable()
	{
		return priceTotalLable.getText();
	}
	
	public String finishbtnclick() {
		finishbtn.click();
		return driver.getCurrentUrl();
	}
	
	public String verifyCancelbtn() {
		cancelbtn.click();
		return driver.getCurrentUrl();
	}
	public String verifyTotalFinalPrice() {
		return totalFinalPriceLable.getText();
	}
	
}
