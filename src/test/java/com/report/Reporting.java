package com.report;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.base.BaseClass;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

public class Reporting extends BaseClass {

	public static void generateJVMReport(String jsonFile) throws FileNotFoundException, IOException {

		File file = new File(getProjectPath() + getPropertyFileValue("jvmFile"));
		Configuration configuration = new Configuration(file, "Mutual Drug");
		configuration.addClassifications("Browser", "Chrome");
		configuration.addClassifications("Version", "134");
		configuration.addClassifications("OS", "WIN 11");

		List<String> jsonFiles = new ArrayList<String>();
		jsonFiles.add(jsonFile);

		ReportBuilder builder = new ReportBuilder(jsonFiles, configuration);
		builder.generateReports();

	}
}
