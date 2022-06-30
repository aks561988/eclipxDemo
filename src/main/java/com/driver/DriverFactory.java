package com.driver;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import com.constants.Constants;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	public WebDriver driver;

	public static ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<>();

	public WebDriver initDriver(String browser) {
		System.out.println("Browser value is : " + browser);

		if (browser.equalsIgnoreCase(Constants.CHROME_BROWSER)) {
			WebDriverManager.chromedriver().setup();
			threadLocalDriver.set(new ChromeDriver());
			System.out.println("Launching Chrome Browser");

		} else if (browser.equalsIgnoreCase(Constants.FIREFOX_BROWSER)) {
			WebDriverManager.firefoxdriver().setup();
			threadLocalDriver.set(new FirefoxDriver());
			System.out.println("Launching FireFox Browser");

		} else if (browser.equalsIgnoreCase(Constants.SAFARI_BROWSER)) {
			threadLocalDriver.set(new SafariDriver());
			System.out.println("Launching Safari Browser");

		} else {
			System.out.println("Provide the browser name : " + browser);
		}

		getDriver().manage().window().maximize();
		getDriver().manage().deleteAllCookies();
		getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(Constants.IMPLICIT_WAIT));
		return getDriver();

	}

	/**
	 * this is used to get the driver with ThreadLocal
	 * 
	 * @return
	 */
	public static synchronized WebDriver getDriver() {
		return threadLocalDriver.get();
	}
}
