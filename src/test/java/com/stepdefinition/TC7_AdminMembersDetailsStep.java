package com.stepdefinition;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebElement;

import com.base.BaseClass;
import com.pageManager.PageObjectManager;

import io.cucumber.java.en.Then;

public class TC7_AdminMembersDetailsStep extends BaseClass {
	PageObjectManager pom = new PageObjectManager();

	@Then("User should navigates Member Details and verifies the title {string}")
	public void userShouldNavigatesMemberDetailsAndVerifiesTheTitle(String expectedTitle) {
		pom.getAdminDashboardPage().navigatesMembersDetails();
		WebElement titleMembers = pom.getDetailsPage().getTitleMembers();
		assertEquals(titleMembers, expectedTitle);
	}

	@Then("User searches using Member Number or Name {string} and verifies that the grid displays the search result for {string}")
	public void userSearchesUsingMemberNumberOrNameAndVerifiesThatTheGridDisplaysTheSearchResultFor(
			String searchMembers, String name, io.cucumber.datatable.DataTable dataTable) {

		List<Map<String, String>> searchMembersList = dataTable.asMaps();
		for (Map<String, String> member : searchMembersList) {
			String searchMember = member.get("searchMembers");
			pom.getDetailsPage().search(searchMember);
		}

	}

	@Then("User verifies that the sorting functionality in both ascending and descending orders for Name and Member Number")
	public void userVerifiesThatTheSortingFunctionalityInBothAscendingAndDescendingOrdersForNameAndMemberNumber() {
		pom.getDetailsPage().sortingFunction();

	}

	@Then("User clicks on the Member Number to view member details")
	public void userClicksOnTheMemberNumberToViewMemberDetails() {
		WebElement tdMemberNumberFirstcell = pom.getDetailsPage().getTdMemberNumberFirstcell();
		click(tdMemberNumberFirstcell);
		WebElement getiClose = pom.getDetailsPage().getiClose();
		click(getiClose);

	}

	@Then("User navigates through pages and verifies that pagination works correctly")
	public void userNavigatesThroughPagesAndVerifiesThatPaginationWorksCorrectly() throws InterruptedException {
		refreshNavigation();
		pom.getDetailsPage().pageNavigations();
		
	}

	@Then("User selects the Rx Purchase chart checkbox for visible member accounts and verifies the success message as {string}")
	public void userSelectsTheRxPurchaseChartCheckboxForVisibleMemberAccountsAndVerifiesTheSuccessMessageAs(
			String successmessage) {
		refreshNavigation();
		pom.getDetailsPage().selectRxPurchaseChart();
		WebElement successMessageRxchartUpdate = pom.getDetailsPage().getSuccessMessageRxchartUpdate();
		assertEquals(successMessageRxchartUpdate, successmessage);
	}

	@Then("User should clicks to Rx Does Chart navigates {string}")
	public void userShouldClicksToRxDoesChartNavigates(String string) {
		pom.getDashboardPage().navigatesRxDoesCharts();
		
	}

	@Then("User verifies whether the Rx Purchase chart is displayed")
	public void userVerifiesWhetherTheRxPurchaseChartIsDisplayed() {
		pom.getDetailsPage().rxChartVisibility();
		
	}

}
