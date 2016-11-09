package com.softserve.edu.reg.pages;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginValidatorPage extends LoginPage {

	public static enum LoginValidatorPageL10n {
        INVALID_LOGIN_PASSWORD("Неправильний логін або пароль",
        		"Неправильний логін або пароль", "Неправильний логін або пароль");
        //
        private HashMap<ChangeLanguageFields, String> field;

        private LoginValidatorPageL10n(String... localization) {
        	this.field = new HashMap<ChangeLanguageFields, String>();
        	int i = 0;
        	for (ChangeLanguageFields language : ChangeLanguageFields.values()) {
        		this.field.put(language, localization[i]);
        		i++;
        	}
        }

        public String getLocalization(ChangeLanguageFields language) {
            return this.field.get(language).trim();
        }
    }

	// - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

	// Fields
	
    private WebElement invalidLoginValidator;

	public LoginValidatorPage(WebDriver driver) {
		super(driver);
		this.invalidLoginValidator = driver.findElement(By.xpath("//div[contains(@style,'color: red;')]"));
	}
	
    // PageObject

	// get Data
	
	public WebElement getInvalidLoginValidator() {
		return this.invalidLoginValidator;
	}

	// Functional
	
	public String getInvalidLoginValidatorText() {
		return getInvalidLoginValidator().getText().trim();
	}

}
