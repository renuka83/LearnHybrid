package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {

	WebDriver driver;
	public HomePage(WebDriver ldriver)
	{
		this.driver=ldriver;
	}
	
	@FindBy(xpath="//a[text()='Sign In']") WebElement signInLink;
	@FindBy(xpath="//a[text()='My Account']") WebElement myAccountLink;
	@FindBy(xpath="//a[text()='My cart']") WebElement myCartLink;
	@FindBy(xpath="//a[text()='Checkout']") WebElement checkoutLink;
	
	public void clickOnSignInLink()
	{
		signInLink.click();
	}
	public void clickOnMyAccountLink()
	{
		myAccountLink.click();
	}
	public void clickOnMyCartLink()
	{
		myCartLink.click();
	}
	public void clickOnCheckoutLink()
	{
		checkoutLink.click();
	}
	public String getApplicationTitle()
	{
		return driver.getTitle();
	}
	
}
