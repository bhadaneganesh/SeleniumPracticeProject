package com.qa.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.BasePage.BaseClass;

public class LoginPage extends BaseClass {

	WebDriver driver;
	
	public LoginPage(WebDriver driver){
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//*[@name='username']")
	WebElement username;
	
	@FindBy(xpath="//*[@name='password']")
	WebElement password;
	
	@FindBy(xpath="//*[@type='submit']")
	WebElement loginButton;
	
	public void login(String uname,String pword) throws InterruptedException {
		Thread.sleep(2000);
		username.sendKeys(uname);
		Thread.sleep(2000);
		password.sendKeys(pword);
		loginButton.click();
	}
	
}