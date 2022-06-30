package com.constants;

public class Constants {
	public static final long IMPLICIT_WAIT = 20;
	public static final long EXPLICIT_WAIT = 20;
	public static final String CONFIG_FILE_PATH = "config.properties";


	// TestRunner Constants
	public static final String FEATURE_FILES = "src/test/resources/featureFiles";
	public static final String GLUE = "stepdefinitions";
	public static final String APP_HOOKS = "apphooks";
	
	
	// DriverFactoryClass Constants
	public static final String CHROME_BROWSER = "chrome";
	public static final String FIREFOX_BROWSER = "firefox";
	public static final String SAFARI_BROWSER = "safari";

	// SearchPage Constants
	public static final String SEARCH_BOX = "q";

	// ResultsPage Constants
	public static final String FIRST_LINK = "//div[@class = 'BYM4Nd']/div/div/div/div/div/a/h3";

	// FirstLink on the results Page

	public static final String KEYWORD = "Eclipx";

	// ApplicationHookClass Constants
	public static final String BROWSER = "browser";
	public static final String URL = "url";
	public static final String WHITE_SPACE = " ";
	public static final String UNDERSCORE = "_";
	public static final String IMAGE_FORMAT = "image/png";
}
