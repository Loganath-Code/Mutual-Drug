package com.stepdefinition;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;

import com.base.BaseClass;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

/**
 * @see Used to run the method before and after of each scenario
 * @author
 * @Date 06-Feb-2025
 * 
 */
public class Hook extends BaseClass {
	static Scenario sc;

	/**
	 * @see Used to run the method before the @test method
	 * @param Scenario
	 * @throws FileNotFoundException
	 * @throws IOException
	 */

	@Before
	public void beforeScenario(Scenario Scenario) throws FileNotFoundException, IOException {

		getDriver(getPropertyFileValue("browser"));
		loadUrl(getPropertyFileValue("Url"));
		driver.manage().deleteAllCookies();
		JavascriptExecutor js = (JavascriptExecutor) driver;

		// Clear localStorage
		js.executeScript("window.localStorage.clear();");

		// Clear sessionStorage
		js.executeScript("window.sessionStorage.clear();");

		// Clear the cache using Service Workers (modern browsers)
		js.executeScript(
				"caches.keys().then(function(keys) { keys.forEach(function(key) { caches.delete(key); }); });");

		maximizeWindow();
		implicitWait();
		sc = Scenario;
	}

	/**
	 * @see Used to run the method after the @test method
	 * @param scenario
	 */
	@After
	public void afterScenario(Scenario scenario) {
		scenario.attach(screenshot(), "image/png", "Every Scenario");
		driver.quit();

	}

}
