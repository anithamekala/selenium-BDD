package pageObjects;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import stepdefs.Shared;

public class CheckoutPage {
	private static Logger LOGGER = LoggerFactory.getLogger(CheckoutPage.class);

	public Shared sh;
	private WebDriver driver;

	public CheckoutPage(Shared sh) {
		this.sh = sh;
		driver = this.sh.driver;
		PageFactory.initElements(this.sh.driver, this);
	}

	@FindBy(how = How.XPATH, using = "//input[@id='billing_first_name']")
	private WebElement txtbx_FirstName;

	@FindBy(how = How.XPATH, using = "//input[@id='billing_last_name']")
	private WebElement txtbx_LastName;

	@FindBy(how = How.XPATH, using = "//select[@id='billing_country']")
	private WebElement drpdwn_CountryDropDownArrow;

	@FindBy(how = How.CSS, using = "#billing_address_1")
	private WebElement txtbx_Address;

	@FindBy(how = How.CSS, using = "#billing_city")
	private WebElement txtbx_City;

	@FindBy(how = How.XPATH, using = "//select[@id='billing_state']")
	private WebElement drpdwn_StateDropDownArrow;

	@FindBy(how = How.CSS, using = "#billing_postcode")
	private WebElement txtbx_PostCode;

	@FindBy(how = How.XPATH, using = "//input[@name='billing_phone']")
	private WebElement txtbx_Phone;

	@FindBy(how = How.XPATH, using = "//input[@id='billing_email']")
	private WebElement txtbx_Email;

	@FindAll(@FindBy(how = How.CSS, using = "ul.wc_payment_methods li"))
	private List<WebElement> paymentMethod_List;

	@FindBy(how = How.XPATH, using = "//input[@id='terms']")
	private WebElement chkbx_AcceptTermsAndCondition;

	@FindBy(how = How.CSS, using = "#place_order")
	private WebElement btn_PlaceOrder;

	public void enter_Name(String name) {
		txtbx_FirstName.sendKeys(name);
	}

	public void enter_LastName(String lastName) {
		txtbx_LastName.sendKeys(lastName);
	}

	public void select_Country(String countryName) throws InterruptedException {
		Select s = new Select(drpdwn_CountryDropDownArrow);
		s.selectByVisibleText("Italy");
		Thread.sleep(2000);
	}

	public void enter_Address(String address) {
		txtbx_Address.sendKeys(address);
	}

	public void enter_City(String city) {
		txtbx_City.sendKeys(city);
	}

	public void enter_Phone(String phone) {
		txtbx_Phone.sendKeys(phone);
	}

	public void enter_PostCode(String postCode) {
		txtbx_PostCode.sendKeys(postCode);
	}

	public void enter_Email(String email) {
		txtbx_Email.sendKeys(email);
	}

	public void select_PROVINCE(String countryName) throws InterruptedException {
		Select s = new Select(drpdwn_StateDropDownArrow);
		s.selectByIndex(103);
		Thread.sleep(2000);
		s.selectByVisibleText("Cagliari");
		Thread.sleep(2000);
	}

	public void select_PaymentMethod(String paymentMethod) {
		if (paymentMethod.equals("CheckPayment")) {
			paymentMethod_List.get(0).click();
		} else if (paymentMethod.equals("Cash")) {
			paymentMethod_List.get(1).click();
		} else {
			new Exception("Payment Method not recognised : " + paymentMethod);
		}
	}

	public void check_TermsAndCondition(boolean value) {
		if (value)
			chkbx_AcceptTermsAndCondition.click();
	}
	
	public void clickOn_PlaceOrder() {
		btn_PlaceOrder.submit();
	}
	

	public void fill_PersonalDetails() throws InterruptedException {
		enter_Name("Amstra");
		enter_LastName("Test");
		enter_Phone("456789032");
		enter_Email("Automation@gmail.com");
		select_Country("Japan");
		select_PROVINCE("Cagliari");
		enter_City("xxxxx");
		enter_Address("Shalimar Bagh");
		enter_PostCode("00199");

	}

}