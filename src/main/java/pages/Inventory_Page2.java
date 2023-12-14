package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import base.TestBase;
import utility.HandleDropDownList;

public class Inventory_Page2 extends TestBase
{

	//object repository
	@FindBy(xpath="//span[@class='title']")private WebElement productLable;
	@FindBy(xpath="//a[@class='shopping_cart_link']") private WebElement addToCart;
	@FindBy(xpath="//span[@class='shopping_cart_badge']")private WebElement cartCount;
	@FindBy(xpath="//select[@class='product_sort_container']")private WebElement dropdown;
	@FindBy(xpath="//a[text()='Twitter']")private WebElement twitterLogo;
	
	
	//added cart element
	@FindBy(xpath="//button[@id='add-to-cart-sauce-labs-backpack']") private WebElement backPackProduct;
	@FindBy(xpath="//button[@id='add-to-cart-sauce-labs-bike-light']")private WebElement backLightProduct;
	@FindBy(xpath="//button[@id='add-to-cart-sauce-labs-bolt-t-shirt']")private WebElement boultTshirtProduct;
	@FindBy(xpath="//button[@id='add-to-cart-sauce-labs-fleece-jacket']")private WebElement fleeceJacketProduct;
	@FindBy(xpath="//button[@id='add-to-cart-sauce-labs-onesie']")private WebElement labsOnesieProduct;
	@FindBy(xpath="//button[@id='add-to-cart-test.allthethings()-t-shirt-(red)']")private WebElement tshirtredProduct;
	
	//remove cart element
	@FindBy(xpath="//button[@id='remove-sauce-labs-backpack']")private WebElement removebackpackProduct;
	@FindBy(xpath="remove-sauce-labs-bike-light")private WebElement removeBikeLightProduct;
	@FindBy(xpath="//button[@id='remove-sauce-labs-bolt-t-shirt']")private WebElement removeBoltTshirtProduct;
	@FindBy(xpath="//button[@id='remove-sauce-labs-fleece-jacket']")private WebElement removefleeceJacketProduct;
	@FindBy(xpath="//button[@id='remove-sauce-labs-onesie']")private WebElement removeOnesieProduct;
	@FindBy(xpath="//button[@id='remove-test.allthethings()-t-shirt-(red)']")private WebElement removetshirtRedProduct;
	public Inventory_Page2() 
	{
		PageFactory.initElements(driver, this);
	}
	
	public String verifyProductLable() {
		return productLable.getText();
	}
	
	public boolean verifytwitterLogo() {
		return twitterLogo.isDisplayed();
	}
	
	public String add6Cart() {
		HandleDropDownList.handleSelectClass(dropdown, "Price (low to high)");
		backPackProduct.click();
		backLightProduct.click();
		boultTshirtProduct.click();
		fleeceJacketProduct.click();
		labsOnesieProduct.click();
		tshirtredProduct.click();
		return cartCount.getText();
	}
	
	public String remove2Product() throws InterruptedException {
		add6Cart();
		Thread.sleep(3000);
		removebackpackProduct.click();
		removeBoltTshirtProduct.click();
		return cartCount.getText();
	}
	
	
}
