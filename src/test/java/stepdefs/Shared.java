package stepdefs;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import util.ConfigUtil;

public class Shared {
	public ChromeDriver driver;
	public Properties properties;
	
	@Before
	public void Method1(Scenario s) throws IOException
	{
		properties = ConfigUtil.getInstance().getProperties();
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(properties.getProperty("url"));
	}
	
	@After
	public void Method2(Scenario s)
	{
		properties = null;
	}

}
