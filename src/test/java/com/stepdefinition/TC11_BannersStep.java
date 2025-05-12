package com.stepdefinition;

import java.util.List;
import java.util.Map;

import com.base.BaseClass;
import com.pageManager.PageObjectManager;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TC11_BannersStep extends BaseClass {

	PageObjectManager pom = new PageObjectManager();

	@Then("User navigating to Administration, Banners, Create Banner should display the {string}")
	public void userNavigatingToAdministrationBannersCreateBannerShouldDisplayThe(String string) {
		pom.getAdminDashboardPage().navigatesCreateBanners();

	}

	@Then("User should verifies to clicks on Add Banner navigates through the {string} form is displayed")
	public void userShouldVerifiesToClicksOnAddBannerNavigatesThroughTheFormIsDisplayed(String string) {
		pom.getBannersPage().clickAddBanner();
	}

	@Then("User should enters {string} into the Name field")
	public void userShouldEntersIntoTheNameField(String name) {
		pom.getBannersPage().insertName(name);
	}

	@Then("User sets Start Date to {string} and End Date to {string}")
	public void userSetsStartDateToAndEndDateTo(String startDate, String endDate) {
		pom.getBannersPage().dateFields(startDate, endDate);
	}

	@Then("User should enters {string} into the URL field")
	public void userShouldEntersIntoTheURLField(String url) {
		pom.getBannersPage().insertURL(url);

	}

	@Then("User sets Open New Tab to {string} and Banner Lock to {string}")
	public void userSetsOpenNewTabToAndBannerLockTo(String value, String string2) {
		pom.getBannersPage().rdobtnOpenNewTab(value);
	}

	@Then("User should enters {string} into the Description field and uploads the image File")
	public void userShouldEntersIntoTheDescriptionFieldAndUploadsTheImageFile(String description) {

		pom.getBannersPage().description(description);
	}

	@Then("User clicks {string} and the banner list should show {string} with the updated description")
	public void userClicksAndTheBannerListShouldShowWithTheUpdatedDescription(String string, String string2) {
		pom.getBannersPage().clickSave();
	}

	@Then("the user searches for banner details using the following queries and verifies the correct banner results are displayed:")
	public void theUserSearchesForBannerDetailsUsingTheFollowingQueriesAndVerifiesTheCorrectBannerResultsAreDisplayed(
			io.cucumber.datatable.DataTable dataTable) throws InterruptedException {

		List<Map<String, String>> searchBannersList = dataTable.asMaps();
		for (Map<String, String> detail : searchBannersList) {
			String searchBanners = detail.get("searchBanners");
			pom.getBannersPage().searchBanners(searchBanners);

		}

	}

	@Then("User verifies that the sorting functionality in both ascending and descending Name, Description, Start Date, End Date, Created Date and Status")
	public void userVerifiesThatTheSortingFunctionalityInBothAscendingAndDescendingNameDescriptionStartDateEndDateCreatedDateAndStatus()
			throws InterruptedException {
		pom.getBannersPage().sorting();
	}

	@When("User clicks on the Banner Name link, the {string} form with prefilled values should be displayed")
	public void userClicksOnTheBannerNameLinkTheFormWithPrefilledValuesShouldBeDisplayed(String string)
			throws InterruptedException {
		pom.getBannersPage().clickBannerNameLink();
	}

	@When("User clicks {string} and the banner list should show {string} with the updated Banner description")
	public void userClicksAndTheBannerListShouldShowWithTheUpdatedBannerDescription(String string, String string2) {
		pom.getBannersPage().updateBanners();

	}

	@When("User deletes the Banner and confirms, it should be removed from the list and display {string}")
	public void userDeletesTheBannerAndConfirmsItShouldBeRemovedFromTheListAndDisplay(String string) {
		pom.getBannersPage().deleteBanners();
	}
}
