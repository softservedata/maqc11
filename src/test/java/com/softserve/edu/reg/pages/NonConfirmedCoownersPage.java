package com.softserve.edu.reg.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NonConfirmedCoownersPage extends AdminHomePage {
	private static final String LOGIN_SEARCH = "//td[contains(text(),'%s')]";

	// Fields
	// private List<WebElement> firstname;
	// private List<WebElement> lastname;
	// private List<WebElement> email;
	// private List<WebElement> login;

	public NonConfirmedCoownersPage(WebDriver driver) {
		super(driver);
		// this.firstname = driver.findElements(By.cssSelector("td.firstName"));
		// this.lastname = driver.findElements(By.cssSelector("td.lastName"));
		// this.email = driver.findElements(By.cssSelector("td.email"));
		// this.login = driver.findElements(By.cssSelector("td.login"));
	}

	// PageObject

	// get Data

	public WebElement getFirstnameNode(String login) {
		// return this.firstname;
		return driver.findElement(By.xpath(String.format(LOGIN_SEARCH, login)
				+ "/preceding-sibling::td[2]"));
	}

	public WebElement getLastnameNode(String login) {
		// return this.lastname;
		return driver.findElement(By.xpath(String.format(LOGIN_SEARCH, login)
				+ "/preceding-sibling::td[1]"));
	}

	public WebElement getEmailNode(String login) {
		// return this.email;
		return driver.findElement(By.xpath(String.format(LOGIN_SEARCH, login)
				+ "/following-sibling::td[2]"));
	}

	public WebElement getLoginNode(String login) {
		// return this.login;
		return driver.findElement(By.xpath(String.format(LOGIN_SEARCH, login)));
	}

	// Functional

	public String getFirstnameNodeText(String login) {
		return getFirstnameNode(login).getText();
	}

	public String getLastnameNodeText(String login) {
		return getLastnameNode(login).getText();
	}

	public String getEmailNodeText(String login) {
		return getEmailNode(login).getText();
	}

	public String getLoginNodeText(String login) {
		return getLoginNode(login).getText();
	}

	// Business Logic

}
