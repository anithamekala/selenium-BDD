package pageObjects;

import org.openqa.selenium.support.PageFactory;

import stepdefs.Shared;

public class HomePage {
	
	public Shared sh;
	
	public HomePage(Shared sh) {
		this.sh = sh;
		PageFactory.initElements(this.sh.driver, this);
	}

	public void navigateTo_HomePage() {
		sh.driver.get("https://shop.demoqa.com");
	}

	public void perform_Search(String search) {
		sh.driver.navigate().to("https://shop.demoqa.com/?s=" + search + "&post_type=product");
	}

}
