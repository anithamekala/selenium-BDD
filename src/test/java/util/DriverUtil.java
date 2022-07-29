package util;

import java.io.IOException;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DriverUtil {

	private RemoteWebDriver driver;
	private WebDriverWait wait;
    
    public DriverUtil() {   
    	driver = null;
    	wait = null;
    }
    
    public String getPropertyValue(String propertyName) throws IOException {
    	return ConfigUtil.getInstance().getProperties().getProperty(propertyName);
    }
}
