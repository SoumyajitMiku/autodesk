package com.crm.autodesk.POMpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import GenericUtilities.WebDriverUtilities;

public class LoginPage {
	
	//declaration of web Elements
	
	@FindBy (name = "user_name")
	private WebElement usernameTextField;
	
	@FindBy (name = "user_password")
	private WebElement passwordTextField;
	
	@FindBy (id="submitButton")
	private WebElement loginButton;
	
	//initialization of webElements
	
	public LoginPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
		
	}
	//utilization of webElements in test scripts
	public void login(String username, String password ) {
		usernameTextField.sendKeys(username);
		passwordTextField.sendKeys(password);
		loginButton.click();
		
	}
	public WebElement getUsernameTextField() {
		return usernameTextField;
	}
	public void setUsernameTextField(WebElement usernameTextField) {
		this.usernameTextField = usernameTextField;
	}
	public WebElement getPasswordTextField() {
		return passwordTextField;
	}
	public void setPasswordTextField(WebElement passwordTextField) {
		this.passwordTextField = passwordTextField;
	}
	public WebElement getLoginButton() {
		return loginButton;
	}
	public void setLoginButton(WebElement loginButton) {
		this.loginButton = loginButton;
	}
	
	
}
