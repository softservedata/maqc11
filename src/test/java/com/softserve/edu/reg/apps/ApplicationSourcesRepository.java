package com.softserve.edu.reg.apps;

public final class ApplicationSourcesRepository {

	private ApplicationSourcesRepository() {
	}

	public static ApplicationSources getDefault() {
		return getChromeHeroku();
	}

	public static ApplicationSources getFirefox4701Heroku() {
		return new ApplicationSources("FireFox.47.0.1", "", 5L,
				"http://registrator.herokuapp.com/login",
				"http://registrator.herokuapp.com/logout");
	}

	public static ApplicationSources getFirefoxHeroku() {
		//System.out.println("+++++ PATH = "
		//		+ ApplicationSourcesRepository.class.getResource("/lib/geckodriver.exe").getPath().substring(1));
		return new ApplicationSources("FireFox.3.0.1",
				ApplicationSourcesRepository.class
					.getResource("/lib/geckodriver.exe").getPath().substring(1), 5L,
				"http://registrator.herokuapp.com/login",
				"http://registrator.herokuapp.com/logout");
	}

	public static ApplicationSources getChromeHeroku() {
		return new ApplicationSources("Chrome",
				//"C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe", 5L,
				ApplicationSourcesRepository.class
					.getResource("/lib/chromedriver.exe").getPath().substring(1), 5L,
				"http://registrator.herokuapp.com/login",
				"http://registrator.herokuapp.com/logout");
	}

	public static ApplicationSources getHtmlUnitHeroku() {
		return new ApplicationSources("HtmlUnit", "", 5L,
				"http://registrator.herokuapp.com/login",
				"http://registrator.herokuapp.com/logout");
	}

}
