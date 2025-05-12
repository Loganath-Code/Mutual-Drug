package com.runner;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.base.BaseClass;
import com.report.Reporting;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;

@RunWith(Cucumber.class)
@CucumberOptions(features = "C:\\Users\\nloga\\eclipse-workspace\\MutualDrug\\src\\test\\resources\\Feature", glue = ("com.stepdefinition"), tags = "@BannerMetrics", snippets = SnippetType.CAMELCASE, dryRun = true , publish = true, monochrome = false, plugin = {
		"pretty", "json:target\\sample.json" }, stepNotifications = true)
public class TestRunner extends BaseClass {
	@AfterClass
	public static void afterClass() throws FileNotFoundException, IOException {
		Reporting.generateJVMReport(getProjectPath() + getPropertyFileValue("jsonPath")); 
	}

}
 