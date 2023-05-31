package com.qa.BasePage;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;


import com.qa.utilities.ReadConfig;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
    ReadConfig read = new ReadConfig();
   public static WebDriver driver;
   public String uname=read.getUserName();
   public String pword=read.getPassword();
   public  String baseurl=read.getApplicationUrl();
  
  
	public  void launchBrowser(String browser) {
		
	   if(browser.equalsIgnoreCase("chrome")) {
			 WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
		 }else if (browser.equalsIgnoreCase("edge")) {
			 WebDriverManager.edgedriver().setup();
			 driver = new EdgeDriver();
		 }else if (browser.equalsIgnoreCase("firefox")) {
			 WebDriverManager.firefoxdriver().setup();
			 driver = new FirefoxDriver();
		 }else {
			 System.out.println("invalid browser");
		 }
		
		driver.get(baseurl);
		driver.manage().window().maximize();
	    
	}
   
   public  void screenShot() throws IOException {
	   String timestamp=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
	   TakesScreenshot ts = (TakesScreenshot)driver;
	   File src =ts.getScreenshotAs(OutputType.FILE);
	   File dest = new File(".\\ScreenShot\\"+timestamp+"\\img.png");
	   FileUtils.copyFile(src, dest);
	   System.out.println("ScreenShot taken Succesfully");
   }
	
   @AfterClass
	public void tearDown() {
		driver.close();
	}
	
}
