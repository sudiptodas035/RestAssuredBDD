package Utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Utility {
	private static Properties prop;
	private static String filename = "Resources/config.properties";

	public static Properties readConfig() {
		prop = new Properties();
		try {
			prop.load(new FileInputStream(filename));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;
	}

}
