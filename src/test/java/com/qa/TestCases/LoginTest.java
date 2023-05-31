package com.qa.TestCases;

import java.io.IOException;
import org.testng.annotations.Test;

import com.qa.BasePage.BaseClass;
import com.qa.PageObjects.LoginPage;

public class LoginTest extends BaseClass {
   
	
	
	@Test
	public void loginTest() throws InterruptedException, IOException{
		launchBrowser("edge");
		LoginPage lp = new LoginPage(driver);
	    lp.login(uname,pword);
	    Thread.sleep(6000);
	    screenShot();
		
		
	}
}
