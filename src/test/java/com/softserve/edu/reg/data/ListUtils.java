package com.softserve.edu.reg.data;

import java.util.List;

import com.softserve.edu.reg.apps.ApplicationSources;

public final class ListUtils {
	private static final String COLUMNS_NUMBER_ERROR = "Columns Number must be bigger than 1";
	private static final String LISTS_EQUAL_ERROR = "Size of Lists must be equal";
	private static final String ARRAY_LISTS_ERROR = "Array of Lists is Empty";
	//
	private static volatile ListUtils instance = null;

	private ListUtils() {
	}

	public static ListUtils get() {
		if (instance == null) {
			synchronized (ListUtils.class) {
				if (instance == null) {
					instance = new ListUtils();
				}
			}
		}
		return instance;
	}

	public Object[][] toMultiArray(List<?> list) {
		Object[][] array = new Object[list.size()][1];
		for (int i = 0; i < list.size(); i++) {
			array[i][0] = list.get(i);
		}
		return array;
	}

	public Object[][] toMultiArrayNumber(ApplicationSources applicationSources, Object testData, List<?> list) {
		Object[][] array = new Object[list.size()][3];
		for (int i = 0; i < list.size(); i++) {
			array[i][0] = applicationSources;
			array[i][1] = testData;
			array[i][2] = list.get(i);
		}
		return array;
	}

}
