package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public final class ConfigUtil {

	private static ConfigUtil INSTANCE;
	private static Properties properties;
    
    private ConfigUtil() {        
    }
    
    public static ConfigUtil getInstance() throws IOException {
        if(INSTANCE == null) {
            INSTANCE = new ConfigUtil();
            
            String filePath = System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\config.properties";
            File file = new File(filePath);
            FileInputStream fileInputStream = new FileInputStream(file);
            
            properties = new Properties(); 
            properties.load(fileInputStream);
        }
        return INSTANCE;
    }
    
    public Properties getProperties() {
    	return properties;
    }
}
