package com.qa.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

	 Properties pro;
	
	public ReadConfig() {
		File src = new File("./Configurations/config.properties");
		
		 
		try {
			FileInputStream	fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}			
	}
	
	public  String getApplicationUrl() {
		String url=pro.getProperty("baseurl");
		return url;
	}
	
	public String getUserName() {
		String username=pro.getProperty("uname");
		return username;
	}
	
	public String getPassword() {
		String pwd=pro.getProperty("pword");
		return pwd;
	}
	
}
