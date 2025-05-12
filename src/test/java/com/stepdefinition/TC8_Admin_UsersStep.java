package com.stepdefinition;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebElement;

import com.base.BaseClass;
import com.pageManager.PageObjectManager;

import io.cucumber.java.en.*;

public class TC8_Admin_UsersStep extends BaseClass {
	PageObjectManager pom = new PageObjectManager();

	@Then("User should navigates Members Users and verifies the title {string}")
	public void userShouldNavigatesMembersUsersAndVerifiesTheTitle(String string) {

		pom.getAdminDashboardPage().navigatesMemberUsers();

	}

	@When("User should perform inivite users {string}, {string}, {string}, {string}, {string}")
	public void userShouldPerformIniviteUsers(String firstName, String lastName, String email, String memberNumber,
			String userRoles) {
//		pom.getUsersPage().inviteUsers(firstName, lastName, email, memberNumber, userRoles);
	}

	@When("User searches using first name, last name and email {string} and verifies that the grid displays the search result for {string}")
	public void userSearchesUsingFirstNameLastNameAndEmailAndVerifiesThatTheGridDisplaysTheSearchResultFor(
			String string, String string2, io.cucumber.datatable.DataTable dataTable) {
		List<Map<String, String>> searchMembersList = dataTable.asMaps();
		for (Map<String, String> member : searchMembersList) {
			String searchTerm = member.get("searchTerm");
			pom.getDetailsPage().search(searchTerm);

		}
	}

	@When("User verifies that the sorting functionality in both ascending and descending first Name, last name, email and Joined date")
	public void userVerifiesThatTheSortingFunctionalityInBothAscendingAndDescendingFirstNameLastNameEmailAndJoinedDate()
			throws InterruptedException {

		pom.getUsersPage().sortingFunction();
	}

	@When("User performs Member User edit with {string}, {string}, {string}, and {string}")
	public void userPerformsMemberUserEditWithAnd(String FirstName, String LastName, String MemberNumber,
			String UsersRole) {
		pom.getUsersPage().updateMembersUser(FirstName, LastName, MemberNumber, UsersRole);
	}

	@When("User should clicks on Resent Invite then verifies the success message {string}")
	public void userShouldClicksOnResentInviteThenVerifiesTheSuccessMessage(String expectedMessage) {
		pom.getUsersPage().resendInvite();
		WebElement successMessageResendInvite = pom.getUsersPage().getSuccessMessageResendInvite();
		assertEquals(successMessageResendInvite, expectedMessage);

	}

	@Then("User should inviting with all fields empty should display the validation messages {string}, {string}, {string}, {string} and {string}")
	public void userShouldInvitingWithAllFieldsEmptyShouldDisplayTheValidationMessagesAnd(
			String expectedErrorMessageFirstName, String expectedErrorMessageLastName, String expectedErrorMessageEmail,
			String expectedErrorMMemberNumber, String expectedErrorMessageUserRole) {

		pom.getUsersPage().emptyFieldsInviteUsers();
		WebElement errorMessageFirstName = pom.getUsersPage().getErrorMessageFirstName();
		WebElement errorMessageLastName = pom.getUsersPage().getErrorMessageLastName();
		WebElement errorMessageEmail = pom.getUsersPage().getErrorMessageEmail();
		WebElement errorMessageMemberNumber = pom.getUsersPage().getErrorMessageMemberNumber();
		WebElement errorMessageUserRole = pom.getUsersPage().getErrorMessageUserRole();
		assertEquals(errorMessageFirstName, expectedErrorMessageFirstName);
		assertEquals(errorMessageLastName, expectedErrorMessageLastName);
		assertEquals(errorMessageEmail, expectedErrorMessageEmail);
		assertEquals(errorMessageMemberNumber, expectedErrorMMemberNumber);
		assertEquals(errorMessageUserRole, expectedErrorMessageUserRole);
	}

	@Then("User attempting to invite a user with an invalid email should display the error message {string}")
	public void userAttemptingToInviteAUserWithAnInvalidEmailShouldDisplayTheErrorMessage(String expectedErrorMessage) {
		pom.getUsersPage().emailFieldValidation();
		WebElement errormessageInvalidEmail = pom.getUsersPage().getErrormessageInvalidEmail();
		assertEquals(errormessageInvalidEmail, expectedErrorMessage);

	}

	@Then("User attempting to invite a user with an already used email should display the error message {string}")
	public void userAttemptingToInviteAUserWithAnAlreadyUsedEmailShouldDisplayTheErrorMessage(String expectedMessage) {

		pom.getUsersPage().alreadyInviteUser();
		WebElement alertMessageEmailAlreadyExists = pom.getUsersPage().getAlertMessageEmailAlreadyExists();
		assertEquals(alertMessageEmailAlreadyExists, expectedMessage);
	}

	@Then("editing a member via the First Name link with empty first and last name fields should display the errors {string} and {string}")
	public void editingAMemberViaTheFirstNameLinkWithEmptyFirstAndLastNameFieldsShouldDisplayTheErrorsAnd(
			String expectedErrorMessageFirstName, String expectedErrorMessageLastName) {

		pom.getUsersPage().firstNameLink();
		WebElement errorMessageFirstName = pom.getUsersPage().getErrorMessageFirstName();
		WebElement errorMessageLastName = pom.getUsersPage().getErrorMessageLastName();
		assertEquals(errorMessageFirstName, expectedErrorMessageFirstName);
		assertEquals(errorMessageLastName, expectedErrorMessageLastName);
	}

	@Then("editing a member via the Last Name link with empty first and last name fields should display the errors {string} and {string}")
	public void editingAMemberViaTheLastNameLinkWithEmptyFirstAndLastNameFieldsShouldDisplayTheErrorsAnd(
			String expectedErrorMessageFirstName, String expectedErrorMessageLastName) {
		pom.getUsersPage().lastNameLink();
		WebElement errorMessageFirstName = pom.getUsersPage().getErrorMessageFirstName();
		WebElement errorMessageLastName = pom.getUsersPage().getErrorMessageLastName();
		assertEquals(errorMessageFirstName, expectedErrorMessageFirstName);
		assertEquals(errorMessageLastName, expectedErrorMessageLastName);
	}

}
