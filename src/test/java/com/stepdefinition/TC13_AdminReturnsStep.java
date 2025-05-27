package com.stepdefinition;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebElement;

import com.base.BaseClass;
import com.pageManager.PageObjectManager;

import io.cucumber.java.en.*;

public class TC13_AdminReturnsStep extends BaseClass {

	PageObjectManager pom = new PageObjectManager();

	@When("User navigates to Administration Selects Returns, clicks C2 Returns and selects Open C2 Returns verifies the {string}")
	public void userNavigatesToAdministrationSelectsReturnsClicksC2ReturnsAndSelectsOpenC2ReturnsVerifiesThe(
			String title) {

		pom.getAdminDashboardPage().navigatesOpenC2Returns();
		WebElement titleOpenC2Returns = pom.getOpenC2ReturnsPage().getTitleOpenC2Returns();
		assertEquals(titleOpenC2Returns, title);
	}

	@When("User should filters the C2 returns by {string}, {string}, {string}, {string}, {string}")
	public void userShouldFiltersTheC2ReturnsBy(String memberNumber, String assignee, String status, String startDate,
			String endDate) throws InterruptedException {
		pom.getOpenC2ReturnsPage().filterReturns(memberNumber, assignee, status, startDate, endDate);

	}

	@Then("The list should display C2 Returns with {string}")
	public void theListShouldDisplayC2ReturnsWith(String memberNumberFilter) throws InterruptedException {
		refreshNavigation();
		Thread.sleep(1800);
		pom.getOpenC2ReturnsPage().filterByMember(memberNumberFilter);
	}

	@Then("User resets the filters by clicking the {string} button")
	public void userResetsTheFiltersByClickingTheButton(String string) {
		pom.getOpenC2ReturnsPage().clearFilter();

	}

	@When("User filters the C2 Returns with Assignee {string} and Status {string}")
	public void userFiltersTheC2ReturnsWithAssigneeAndStatus(String assignee, String status) {

		pom.getOpenC2ReturnsPage().filterByAssigneeStatus(assignee, status);
	}

	@Then("User verifies list should display only C2 Returns with Assignee {string} and Status {string}")
	public void userVerifiesListShouldDisplayOnlyC2ReturnsWithAssigneeAndStatus(String expectedAssignee,
			String expectedStatus) {
		pom.getOpenC2ReturnsPage().verifyFilteredResults(expectedAssignee, expectedStatus);

	}

	@Then("User verifies Search for a Return by Return Name, DEA Number, Member")
	public void userVerifiesSearchForAReturnByReturnNameDEANumberMember(io.cucumber.datatable.DataTable dataTable)
			throws InterruptedException {
		refreshNavigation();
		List<Map<String, String>> openC2Returns = dataTable.asMaps();
		for (Map<String, String> detail : openC2Returns) {
			String search = detail.get("search");
			pom.getOpenC2ReturnsPage().searchReturns(search);

		}
	}

	@Then("User verifies that the sorting functionality in both ascending and descending Return Name, DEA Number, Member, Submitted Date, DEA Form#, Department, Assignee and Status")
	public void userVerifiesThatTheSortingFunctionalityInBothAscendingAndDescendingReturnNameDEANumberMemberSubmittedDateDEAFormDepartmentAssigneeAndStatus()
			throws InterruptedException {
		refreshNavigation();
		String[] returnColumns = { "Return Name", "DEA Number", "Member", "Submitted Date", "DEA Form#", "Department",
				"Assignee", "Status" };
		pom.getOpenC2ReturnsPage().verifySortingFunctionality(returnColumns);

	}

	@When("User Updates the C2 Returns {string}, {string} with comments {string}")
	public void userUpdatesTheC2ReturnsWithComments(String assignee, String status, String comments)
			throws InterruptedException {
		Thread.sleep(2000);
		pom.getOpenC2ReturnsPage().updateReturns(assignee, status);
		pom.getOpenC2ReturnsPage().insertComments(comments);
	}

	@When("User should view the C2 Returns status history")
	public void userShouldViewTheC2ReturnsStatusHistory() {
		pom.getOpenC2ReturnsPage().returnPolicyHistory();
		pom.getOpenC2ReturnsPage().close();
	}

	@When("User clicks upload icon to upload {string} and upload file")
	public void userClicksUploadIconToUploadAndUploadFile(String deaNum) {
		pom.getOpenC2ReturnsPage().uploadDeaForm(deaNum);
	}

	@When("User clicks Reutrn Name link navigates {string} page")
	public void userClicksReutrnNameLinkNavigatesPage(String string) {
		pom.getOpenC2ReturnsPage().returnNameLink();

	}

	@When("User should view the returns status history")
	public void userShouldViewTheReturnsStatusHistory() {
		pom.getOpenC2ReturnsPage().returnPolicyHistory();
		pom.getOpenC2ReturnsPage().close();
	}

	@When("User Upload the DEA Form with {string} with upload file")
	public void userUploadTheDEAFormWithWithUploadFile(String deaNum) {
		pom.getOpenC2ReturnsPage().uploadDeaForm(deaNum);

	}

	@When("User verifies that the sorting functionality in both ascending and descending item#, Production Description, Expiration Date, Lot Number, Return Qty, Return Reason and RA#")
	public void userVerifiesThatTheSortingFunctionalityInBothAscendingAndDescendingItemProductionDescriptionExpirationDateLotNumberReturnQtyReturnReasonAndRA()
			throws InterruptedException {
		String[] itemColumns = { "Item #", "Product Description", "Expiration Date", "Lot Number", "Return Qty",
				"Return Reason", "RA #" };
		pom.getOpenC2ReturnsPage().verifySortingFunctionality(itemColumns);

	}
}
