package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import stepdefs.Shared;

public class CartPage {
	public Shared sh;

	public CartPage(Shared sh) {
		this.sh = sh;
		PageFactory.initElements(this.sh.driver, this);
	}

	@FindBy(how = How.XPATH, using = "//a[@class='button wc-forward']")
	private WebElement btn_Cart;

	@FindBy(how = How.XPATH, using = "//a[@class='checkout-button button alt wc-forward'")
	private WebElement btn_ContinueToCheckout;

	public void clickOn_Cart() {
		btn_Cart.click();
	}

	public void clickOn_ContinueToCheckout() {
		btn_ContinueToCheckout.click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
		}
	}

}
