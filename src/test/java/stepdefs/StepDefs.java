package stepdefs;

import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pageObjects.CartPage;
import pageObjects.CheckoutPage;
import pageObjects.HomePage;
import pageObjects.ProductListingPage;

public class StepDefs {

	WebDriver driver;
	HomePage home;
	ProductListingPage productListingPage;
	CartPage cartPage;
	CheckoutPage checkoutPage;

	public Shared sh;

	public StepDefs(Shared sh) {
		this.sh = sh;
	}

	@Given("^User is on Home Page$")
	public void user_is_on_Home_Page() throws Throwable {
		driver = sh.driver;
	}

	@When("He searches for {string}")
	public void he_search_for(String product) {
	WebElement search = driver.findElement(By.xpath(" //a[@class='noo-search']"));
        
	}
	
	@When("^Choose to buy the first item$")
	public void choose_to_buy_the_first_item() {
		List<WebElement> items = driver.findElements(By.xpath("//a[normalize-space()='Black Cross Back Maxi Dress']"));
		items.get(0).click();

		Select colorSelect = new Select(driver.findElement(By.xpath("//select[@id='pa_color']")));
		Select sizeSelect = new Select(driver.findElement(By.xpath("//select[@id='pa_size']")));

		colorSelect.selectByVisibleText("Black");
		sizeSelect.selectByVisibleText("Medium");

		WebElement cart = driver.findElement(By.xpath("//button[normalize-space()='Add to cart']"));
		cart.click();
	}

	@And("^Moves to checkout from mini cart")
	public void Moves_to_checkout_from_mini_cart() {
		WebElement viewCart = driver.findElement(By.xpath("//a[@class='button wc-forward']"));
		viewCart.click();

		WebElement continueToCheckout = driver
				.findElement(By.xpath("//a[@class='checkout-button button alt wc-forward']"));
		continueToCheckout.click();
	}

	@And("^Enter personal details on checkout page$")
	public void Enter_personal_details_on_checkout_page() throws InterruptedException {
		checkoutPage = new CheckoutPage(sh);
		checkoutPage.fill_PersonalDetails();
	}


	 @When("^place the order$")
	 public void place_the_order() {
		checkoutPage.check_TermsAndCondition(true);
		checkoutPage.clickOn_PlaceOrder();

	}

}
