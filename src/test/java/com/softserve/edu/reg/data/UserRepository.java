package com.softserve.edu.reg.data;

import java.util.List;

public final class UserRepository {

	private UserRepository() {
	}

	public static IUser getAdmin() {
		return User.get()
				.setFirstname("Адміністратор")
				.setLastname("Адміністратор")
				.setEmail("admin@admin.com")
				.setLogin("admin1")
				.setPassword("admin1")
				.setCommunity("Україна")
				.build();
	}

	public static IUser getRegistrator() {
		return User.get()
				.setFirstname("registrator")
				.setLastname("registrator")
				.setEmail("harasym@mail.ua")
				.setLogin("registrator")
				.setPassword("registrator")
				.setCommunity("Україна")
				.build(); 
	}

	public static IUser getNewUser() {
		return  User.get()
				.setFirstname("registrator")
				.setLastname("registrator")
				.setEmail("registrator@mail.ua")
				.setLogin("registrator11")
				.setPassword("registrator10")
				.setCommunity("Україна")
				.build();
	}

	public static IUser getInvalidUser() {
		return  User.get()
				.setFirstname("abcd")
				.setLastname("abcd")
				.setEmail("abcd@mail.ua")
				.setLogin("abcd")
				.setPassword("abcd")
				.setCommunity("Україна")
				.build();
	}

	public static List<IUser> getNewUsersFromCsvFile() {
		return new UserUtils().getAllUsers();
	}

	public static List<IUser> getNewUsersFromExcelFile() {
		return new UserUtils("/newUsers.xlsx", new ExcelUtils()).getAllUsers();
	}

	// public static User getFromDB() {
	// MyDBManager dbm = new MyDBManager();
	// return dbm.getUser();
	// }

}
