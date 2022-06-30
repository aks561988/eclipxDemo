package testrunner;

import org.junit.runner.RunWith;

import com.constants.Constants;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

	@RunWith(Cucumber.class)
	@CucumberOptions(features={Constants.FEATURE_FILES},glue = {Constants.GLUE,Constants.APP_HOOKS})
	public class TestRunner {

	}
