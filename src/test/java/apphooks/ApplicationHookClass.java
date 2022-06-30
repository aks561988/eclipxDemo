package apphooks;

import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.constants.Constants;
import com.driver.DriverFactory;
import com.propertiesloader.PropertiesLoader;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class ApplicationHookClass {

	private DriverFactory driverFactory;
	private WebDriver driver;
	Properties prop;

	@Before(order = 0)
	public void getProperties() {
		prop = PropertiesLoader.initProp();
	}
	//Launch Browser
	@Before(order = 1)
	public void launchBrowser() {
		driverFactory = new DriverFactory();
		String browserName = prop.getProperty(Constants.BROWSER);
		driver = driverFactory.initDriver(browserName);
		driver.get(prop.getProperty(Constants.URL));
	}

	//Browser Close
	@After(order = 0)
	public void quitBrowser() {
		driver.quit();
		System.out.println("Closed Browser");
	}

	@After(order = 1)
	public void tearDown(Scenario scenario) {
		if (scenario.isFailed()) {
			// take screenshot
			String screenshotName = scenario.getName().replace(Constants.WHITE_SPACE, Constants.UNDERSCORE);
			final byte[] sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(sourcePath, Constants.IMAGE_FORMAT, screenshotName);
		}

	}
}
