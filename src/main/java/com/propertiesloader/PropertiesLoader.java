package com.propertiesloader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import com.constants.Constants;

public class PropertiesLoader {
	
	private static Properties prop = null;
	
	public static Properties initProp() {
		if (prop == null) {
			try {
				prop = new Properties();
				FileInputStream ip = new FileInputStream(Constants.CONFIG_FILE_PATH);
				prop.load(ip);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}			
		}
		return prop;
	}
}
