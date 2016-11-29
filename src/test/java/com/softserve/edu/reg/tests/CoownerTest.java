package com.softserve.edu.reg.tests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.reg.apps.ApplicationSources;
import com.softserve.edu.reg.apps.ApplicationSourcesRepository;
import com.softserve.edu.reg.data.IUser;
import com.softserve.edu.reg.data.ListUtils;
import com.softserve.edu.reg.data.UserRepository;
import com.softserve.edu.reg.pages.AdminHomePage;
import com.softserve.edu.reg.pages.Application;
import com.softserve.edu.reg.pages.HomePage;
import com.softserve.edu.reg.pages.LoginPage;
import com.softserve.edu.reg.pages.NonConfirmedCoownersPage;
import com.softserve.edu.reg.pages.RegisteredUsersHomePage;

public class CoownerTest {

	@AfterClass
	public void afterClass() {
		Application.remove();
	}

	@AfterMethod
	public void afterMethod() throws Exception {
		Application.get().logout();
		//Application.remove();
		Thread.sleep(2000);
	}

	@DataProvider // (parallel = true)
	public Object[][] createNewCoowner() {
		//return new Object[][] {
				// { ApplicationSourcesRepository.getChromeHeroku(),
				// UserRepository.getAdmin(), UserRepository.getNewUser() },
				// { ApplicationSourcesRepository.getFirefoxHeroku(),
				// UserRepository.getAdmin(), UserRepository.getNewUser() }
				// };
//		return ListUtils.get()
//				.toMultiArrayNumber(ApplicationSourcesRepository.getFirefoxHeroku(),
//						UserRepository.getAdmin(),
//						UserRepository.getNewUsersFromExcelFile());
//		return ListUtils.get()
//				.toMultiArrayNumber(ApplicationSourcesRepository.getFirefox4701Heroku(),
//						UserRepository.getAdmin(),
//						UserRepository.getNewUsersFromDB());
		return ListUtils.get()
				.toMultiArrayNumber(ApplicationSourcesRepository.getChromeHeroku(),
						UserRepository.getAdmin(),
						UserRepository.getNewUsersFromDB());
	}

	@Test(dataProvider = "createNewCoowner")
	public void checkCreateNewCoowner(ApplicationSources applicationSources,
			IUser admin, IUser coowner) throws Exception {
		//System.out.println("+++++ " + coowner); 
		// Precondition
		//LoginPage loginPage = Application.get(applicationSources).load();
		AdminHomePage adminHomePage = Application.get(applicationSources).load()
				.successAdminLogin(admin);
		//
		// Steps
		RegisteredUsersHomePage registeredUsersHomePage = adminHomePage.gotoRegisteredUsers();
		NonConfirmedCoownersPage nonConfirmedCoownersPage = registeredUsersHomePage.createCoowner(coowner);
		//
		// Check
		Assert.assertEquals(nonConfirmedCoownersPage.getFirstnameNodeText(coowner.getLogin()),
				coowner.getFirstname());
		Assert.assertEquals(nonConfirmedCoownersPage.getLastnameNodeText(coowner.getLogin()),
				coowner.getLastname());
		Assert.assertEquals(nonConfirmedCoownersPage.getEmailNodeText(coowner.getLogin()),
				coowner.getEmail());
		//
		// Return to previous state
		Thread.sleep(2000);
		//nonConfirmedCoownersPage.logout();
		//Thread.sleep(2000);
	}

	
	@DataProvider //(parallel = true)
	public Object[][] coownerLogin() {
		return new Object[][] {
			//{ ApplicationSourcesRepository.getChromeHeroku(), UserRepository.getAdmin() },
			{ ApplicationSourcesRepository.getFirefoxHeroku(), UserRepository.getAdmin() },
			{ ApplicationSourcesRepository.getFirefoxHeroku(), UserRepository.getRegistrator() }
		};
	}

	//@Test(dataProvider = "coownerLogin")
	public void checkCoownerLogin(ApplicationSources applicationSources,
			IUser coowner) throws Exception {
		// Precondition
		LoginPage loginPage = Application.get(applicationSources).load();
		//
		// Steps
		HomePage homePage = loginPage.successUserLogin(coowner);
		//
		// Check
		Assert.assertEquals(homePage.getLoginAccountText(),
				coowner.getLogin());
		//
		// Return to previous state
		Thread.sleep(3000);
		//homePage.logout();
		//Thread.sleep(2000);
	}

}
