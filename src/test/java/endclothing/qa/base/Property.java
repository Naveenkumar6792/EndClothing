package endclothing.qa.base;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

public class Property {

	Properties prop;

	public Property() {
		try {
			prop = new Properties();
			InputStream input = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\testdata.properties");
			prop.load(input);
		} catch (Exception e) {
			System.out.println("There is as issues with reading the property file " + e);
		}
	}

	public String getProperty(String key) {
		return prop.getProperty(key);
	}

	public List<String> returnAsList(String key) {
		return Arrays.asList(prop.getProperty(key).split(","));
	}
}
