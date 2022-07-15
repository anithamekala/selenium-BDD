package stepdefs;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginStepDefs {
	
	public Shared sh;

	public LoginStepDefs(Shared sh) {
		this.sh = sh;
	}
	
	@Given("^User is on Home Page$")
	public void user_is_on_Home_Page() throws Throwable {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.store.demoqa.com");
		}
		/*
		 * @When("^User Navigate to LogIn Page$") public void
		 * user_Navigate_to_LogIn_Page() throws Throwable {
		 * driver.findElement(By.xpath(".//*[@id='account']/a")).click(); }
		 */
}



