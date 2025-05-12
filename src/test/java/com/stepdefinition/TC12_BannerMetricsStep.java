package com.stepdefinition;

import com.base.BaseClass;
import com.pageManager.PageObjectManager;

import io.cucumber.java.en.*;

public class TC12_BannerMetricsStep extends BaseClass {

	PageObjectManager pom = new PageObjectManager();

	@Then("User navigating to Administration, Banners, Banner Metrics should display the {string}")
	public void userNavigatingToAdministrationBannersBannerMetricsShouldDisplayThe(String string) {
		pom.getAdminDashboardPage().navigtesBannerMetrics();
	}

	@When("User enters valid member number {string} in the Member Number field")
	public void userEntersValidMemberNumberInTheMemberNumberField(String memberNumber) {
		pom.getBannerMetricsPage().memberNumber(memberNumber);
	}

	@When("User enters valid banner name {string} in the Banner Name field")
	public void userEntersValidBannerNameInTheBannerNameField(String bannerName) {
		pom.getBannerMetricsPage().bannerName(bannerName);
	}

	@When("User selects Start Date {string} and End Date {string}")
	public void userSelectsStartDateAndEndDate(String startDate, String endDate) {
		pom.getBannerMetricsPage().dateFields(startDate, endDate);
	}

	@When("User clicks the Filter button then Results should be displayed within the selected date range")
	public void userClicksTheFilterButtonThenResultsShouldBeDisplayedWithinTheSelectedDateRange() {
		pom.getBannerMetricsPage().clickFilter();

	}

}
