package com.softserve.edu.reg.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.reg.data.IUser;
import com.softserve.edu.reg.data.UserRepository;
import com.softserve.edu.reg.pages.LogPage;
import com.softserve.edu.reg.pages.LoginPage;

public class LogTest {

	@DataProvider //(parallel = true)
	public Object[][] invalidUsers() {
		return new Object[][] {
			//{ UserRepository.getInvalidUser() },
			{ UserRepository.getInvalidUser() }
		};
	}

	@Test(dataProvider = "invalidUsers")
	public void checkInvalidLog(IUser invalidUser) throws Exception {
		// Precondition
		System.setProperty("webdriver.gecko.driver",
				LogTest.class.getResource("/lib/geckodriver.exe").getPath().substring(1));
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(5L, TimeUnit.SECONDS);
		driver.get("http://registrator.herokuapp.com/login");
		//
		// Steps
		LogPage logPage = new LogPage(driver); // 1st item
		//LogPage logPage = PageFactory.initElements(driver, LogPage.class); // 2nd item
		//
		Thread.sleep(2000);
		logPage.setLoginInput("Ha-Ha-Ha");
		Thread.sleep(2000);
		driver.navigate().refresh();
		Thread.sleep(2000);
		//
		logPage = logPage.unsuccessfulLogin(invalidUser); // Ok
		//
		// Check
		//
		// Return to previous state
		Thread.sleep(2000);
		driver.quit();
	}

	//@Test(dataProvider = "invalidUsers")
	public void checkInvalidLogin(IUser invalidUser) throws Exception {
		// Precondition
		System.setProperty("webdriver.gecko.driver",
				LogTest.class.getResource("/lib/geckodriver.exe").getPath().substring(1));
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(5L, TimeUnit.SECONDS);
		driver.get("http://registrator.herokuapp.com/login");
		//
		// Steps
		LoginPage loginPage = new LoginPage(driver);
		//
		Thread.sleep(2000);
		loginPage.setLoginInput("Ha-Ha-Ha");
		Thread.sleep(2000);
		driver.navigate().refresh();
		Thread.sleep(2000);
		//
		loginPage = loginPage.unsuccessfulLogin(invalidUser); // ERROR, after refresh page not found.
		//
		// Check
		//
		// Return to previous state
		Thread.sleep(2000);
		driver.quit();
	}

}
