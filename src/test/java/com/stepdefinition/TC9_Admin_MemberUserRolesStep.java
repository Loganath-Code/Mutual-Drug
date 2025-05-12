package com.stepdefinition;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebElement;

import com.base.BaseClass;
import com.pageManager.PageObjectManager;

import io.cucumber.java.en.*;

public class TC9_Admin_MemberUserRolesStep extends BaseClass {
	PageObjectManager pom = new PageObjectManager();

	@Then("User should navigates Member Roles and verifies the title {string}")
	public void userShouldNavigatesMemberRolesAndVerifiesTheTitle(String string) {
		pom.getAdminDashboardPage().navigtesMemberUserRoles();
	}

	@When("User should clicks on Add New to add new roles {string} with permissions")
	public void userShouldClicksOnAddNewToAddNewRolesWithPermissions(String roleName) {
		pom.getRolesPage().addNewRoles(roleName);
	}

	@When("User searches using Name {string} and verifies that the grid displays the search result for {string}")
	public void userSearchesUsingNameAndVerifiesThatTheGridDisplaysTheSearchResultFor(String string, String string2,
			io.cucumber.datatable.DataTable dataTable) {

		List<Map<String, String>> searchMembersList = dataTable.asMaps();
		for (Map<String, String> member : searchMembersList) {
			String searchMemberUserRoles = member.get("searchMemberUserRoles");
			pom.getRolesPage().searchMemberUserRoles(searchMemberUserRoles);
		}

	}

	@When("User clicks on the Name link to edit roles {string} and updates the role details")
	public void userClicksOnTheNameLinkToEditRolesAndUpdatesTheRoleDetails(String roleName) {
		refreshNavigation();
		pom.getRolesPage().updateRoles(roleName);

	}

	@When("User verifies that the sorting functionality in both ascending and descending Name and Created date")
	public void userVerifiesThatTheSortingFunctionalityInBothAscendingAndDescendingNameAndCreatedDate()
			throws InterruptedException {
		pom.getRolesPage().sortingFunction();
	}

	@Then("User should attempt to submit the form without entering a Role Name and verify that an error message {string} displayed")
	public void userShouldAttemptToSubmitTheFormWithoutEnteringARoleNameAndVerifyThatAnErrorMessageDisplayed(
			String expectedMessage) {
		pom.getRolesPage().validateAddNewRoles();
		WebElement errorMessageRoleName = pom.getRolesPage().getErrorMessageRoleName();
		assertEquals(errorMessageRoleName, expectedMessage);
	}

	@Then("User submitting a role without selecting any permissions should display the error {string}")
	public void userSubmittingARoleWithoutSelectingAnyPermissionsShouldDisplayTheError(String expectedErrorMessage) {

		pom.getRolesPage().validateWithoutSelectRole();
		WebElement errorMessagePermissions = pom.getRolesPage().getErrorMessagePermissions();
		assertEquals(errorMessagePermissions, expectedErrorMessage);
	}
}
