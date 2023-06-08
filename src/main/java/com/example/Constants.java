package com.example;

public class Constants {
	public static final Long LOCK_KEY = Long.valueOf(1L);
	public static final Long TIMESTAMP_KEY = Long.valueOf(2L);
	public static final Long LOCK_VALUE = Long.valueOf(1L);
	public static final String MAP_NAME = "timestamp-map";
	public static final String FILE_PATH = System.getProperty("user.home") + "/" + MAP_NAME + ".dat";
}
