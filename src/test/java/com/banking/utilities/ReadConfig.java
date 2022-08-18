package com.banking.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

	Properties props;

	public ReadConfig() {

		File src = new File("./Configuration/config.properties");

		try {
			FileInputStream fis = new FileInputStream(src);
			props = new Properties();
			props.load(fis);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	public String getApplicationUrl() {
		String url = props.getProperty("baseUrl");
		return url;
	}

	public String getUsername() {
		String username = props.getProperty("username");
		return username;
	}

	public String getPassword() {
		String password = props.getProperty("password");
		return password;
	}
}
