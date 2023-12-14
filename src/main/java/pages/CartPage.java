package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class CartPage extends TestBase
{

	@FindBy(xpath="//a[@class='shopping_cart_link']") private WebElement cart;
	@FindBy(xpath="//span[@class='title']")private WebElement productLable;
	
	//removeCart
	@FindBy(xpath="//button[@id='remove-sauce-labs-bike-light']")private WebElement removeBikeLight;
	@FindBy(xpath="//button[@id='remove-sauce-labs-backpack']")private WebElement removeBackPack;
	@FindBy(xpath="//button[@id='remove-sauce-labs-bolt-t-shirt']")private WebElement removeTshirt;
	
	@FindBy(xpath="//span[@class='shopping_cart_badge']")private WebElement cartcount;
	
	@FindBy(xpath="//button[@id='continue-shopping']")private WebElement continueshopping;
	
	@FindBy(xpath="//button[@class='btn btn_action btn_medium checkout_button ']")private WebElement checkoutBtn;
	
	@FindBy(xpath="//div[@class='cart_quantity_label']")private WebElement qtyLable;
	@FindBy(xpath="//div[@class='cart_desc_label']")private WebElement decriptionLable;
	
	@FindBy(xpath="//a[text()='Twitter']")private WebElement twitterLogo;
	@FindBy(xpath="//a[text()='Facebook']")private WebElement facebookLogo;
	@FindBy(xpath="//a[text()='LinkedIn']")private WebElement linkdinLogo;
	public CartPage() 
	{
		PageFactory.initElements(driver, this);
	}
	
	public String verifyCartUrlApplication() {
		cart.click();
		return driver.getCurrentUrl();
	}
	
	public String remove3ProductCart() throws InterruptedException {
		cart.click();
		removeBikeLight.click();
		removeBackPack.click();
		removeTshirt.click();
		Thread.sleep(3000);
		return cartcount.getText();
	}
	
	public String verifyProductLableCart() {
		cart.click();
		return productLable.getText();
	}
	
	public String verifyContinueShoppingCartUrl() throws InterruptedException {
		remove3ProductCart();
		continueshopping.click();
		return driver.getCurrentUrl();
	}
	
	public String verifyUrlCheckout() throws InterruptedException {
		remove3ProductCart();
		checkoutBtn.click();
		Thread.sleep(3000);
		return driver.getCurrentUrl();
	}
	
	public String verifyCartQTYlable() throws InterruptedException {
		remove3ProductCart();
		return qtyLable.getText();
	}
	
	public String verifyCartdecriptionLable() throws InterruptedException {
		remove3ProductCart();
		return decriptionLable.getText();
	}
	
	public boolean verifyCartPagetwitterLogo() throws InterruptedException {
		remove3ProductCart();
		return twitterLogo.isDisplayed();
	}
	
	public boolean verifyCartPageFacebookLogo() throws InterruptedException {
		remove3ProductCart();
		return facebookLogo.isDisplayed();
	}
	
	public boolean verifyCartPageLinkdinLogo() throws InterruptedException {
		remove3ProductCart();
		return linkdinLogo.isDisplayed();
	}
	
	public String checkoutbtn() {
		checkoutBtn.click();
		return driver.getCurrentUrl();
	}
	
}
