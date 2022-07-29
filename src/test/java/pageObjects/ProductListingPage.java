package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import stepdefs.Shared;

public class ProductListingPage {

	public Shared sh;

	public ProductListingPage(Shared sh) {
		this.sh = sh;
		PageFactory.initElements(this.sh.driver, this);
	}

	@FindBy(how = How.XPATH, using = "//button[normalize-space()='Add to cart'")
	private WebElement btn_AddToCart;

	@FindAll(@FindBy(how = How.XPATH, using = "a[normalize-space()='Black Cross Back Maxi Dress']"))
	private List<WebElement> prd_List;

	public void clickOn_AddToCart() {
		btn_AddToCart.click();
	}

	public void select_Product(int productNumber) {
		prd_List.get(productNumber).click();
	}

}
