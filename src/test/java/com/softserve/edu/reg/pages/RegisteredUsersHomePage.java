package com.softserve.edu.reg.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.softserve.edu.reg.data.IUser;

public class RegisteredUsersHomePage extends AdminHomePage {

	// Fields
	private WebElement firstname;
	private WebElement lastname;
	private WebElement email;
	private WebElement login;
	private WebElement password;
	private WebElement confirmPassword;
	private Select territorialCommunity;
	private WebElement submit;
	
	public RegisteredUsersHomePage(WebDriver driver) {
        super(driver);
        this.firstname = driver.findElement(By.id("firstName"));
        this.lastname = driver.findElement(By.id("lastName"));
        this.email = driver.findElement(By.id("email"));
        this.login = driver.findElement(By.id("login"));
        this.password = driver.findElement(By.id("password"));
        this.confirmPassword = driver.findElement(By.id("confirmPassword"));
        this.territorialCommunity = new Select(driver.findElement(By.id("territorial_Community")));
        this.submit = driver.findElement(By.id("submit"));
    }

	// PageObject

	// get Data

	public WebElement getFirstnameInput() {
		return this.firstname;
	}

	public WebElement getLastnameInput() {
		return this.lastname;
	}

	public WebElement getEmailInput() {
		return this.email;
	}

	public WebElement getLoginInput() {
		return this.login;
	}

	public WebElement getPasswordInput() {
		return this.password;
	}

	public WebElement getConfirmPasswordInput() {
		return this.confirmPassword;
	}

	public Select getTerritorialCommunitySelect() {
		return this.territorialCommunity;
	}

	public WebElement getTerritorialCommunityInput() {
		return getTerritorialCommunitySelect().getFirstSelectedOption();
	}

	public WebElement getSubmitButton() {
		return this.submit;
	}

	// Functional

	public String getFirstnameInputText() {
		return getFirstnameInput().getText();
	}

	public String getLastnameInputText() {
		return getLastnameInput().getText();
	}

	public String getEmailInputText() {
		return getEmailInput().getText();
	}

	public String getLoginInputText() {
		return getLoginInput().getText();
	}

	public String getPasswordInputText() {
		return getPasswordInput().getText();
	}

	public String getConfirmPasswordInputText() {
		return getConfirmPasswordInput().getText();
	}

	public String getTerritorialCommunityInputText() {
		return getTerritorialCommunityInput().getText();
	}

	public String getSubmitButtonText() {
		return getSubmitButton().getText();
	}

	// set Data

	public void setFirstnameInput(String firstname) {
		getFirstnameInput().sendKeys(firstname);
	}

	public void setLastnameInput(String lastname) {
		getLastnameInput().sendKeys(lastname);
	}

	public void setEmailInput(String email) {
		getEmailInput().sendKeys(email);
	}

	public void setLoginInput(String login) {
		getLoginInput().sendKeys(login);
	}

	public void setPasswordInput(String password) {
		getPasswordInput().sendKeys(password);
	}

	public void setConfirmPasswordInput(String password) {
		getConfirmPasswordInput().sendKeys(password);
	}

	public void setTerritorialCommunitySelect(String community) {
		// TODO Check String community from Database
		getTerritorialCommunitySelect().selectByVisibleText(community);
	}

	public void setFirstnameInputClear(String firstname) {
		clearFirstnameInput();
		setFirstnameInput(firstname);
	}

	public void setLastnameInputClear(String lastname) {
		clearLastnameInput();
		setLastnameInput(lastname);
	}

	public void setEmailInputClear(String email) {
		clearEmailInput();
		setEmailInput(email);
	}

	public void setLoginInputClear(String login) {
		clearLoginInput();
		setLoginInput(login);
	}

	public void setPasswordInputClear(String password) {
		clearPasswordInput();
		setPasswordInput(password);
	}

	public void setConfirmPasswordInputClear(String password) {
		clearConfirmPasswordInput();
		setConfirmPasswordInput(password);
	}

	public void clearFirstnameInput() {
		getFirstnameInput().clear();
	}

	public void clearLastnameInput() {
		getLastnameInput().clear();
	}

	public void clearEmailInput() {
		getEmailInput().clear();
	}

	public void clearLoginInput() {
		getLoginInput().clear();
	}

	public void clearPasswordInput() {
		getPasswordInput().clear();
	}

	public void clearConfirmPasswordInput() {
		getConfirmPasswordInput().clear();
	}

	public void clickFirstnameInput() {
		getFirstnameInput().click();
	}

	public void clickLastnameInput() {
		getLastnameInput().click();
	}

	public void clickEmailInput() {
		getEmailInput().click();
	}

	public void clickLoginInput() {
		getLoginInput().click();
	}

	public void clickPasswordInput() {
		getPasswordInput().click();
	}

	public void clickConfirmPasswordInput() {
		getConfirmPasswordInput().click();
	}

	public void clickTerritorialCommunitySelect() {
		((WebElement)getTerritorialCommunitySelect()).click();
	}

	public void clickSubmitButton() {
		getSubmitButton().click();
	}

    // Business Logic
	
	private void setCoownerData(IUser coowner) {
		setFirstnameInputClear(coowner.getFirstname());
		setLastnameInputClear(coowner.getLastname());
		setEmailInputClear(coowner.getEmail());
		setLoginInputClear(coowner.getLogin());
		setPasswordInputClear(coowner.getPassword());
		setConfirmPasswordInputClear(coowner.getPassword());
		setTerritorialCommunitySelect(coowner.getCommunity());
		clickSubmitButton();
	}

	public NonConfirmedCoownersPage createCoowner(IUser coowner) {
		setCoownerData(coowner);
		return new NonConfirmedCoownersPage(driver);
	}
	
}
