package com.stepdefinition;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.base.BaseClass;
import com.pageManager.PageObjectManager;

import io.cucumber.java.en.*;

public class UserProfileStep extends BaseClass {
	PageObjectManager pom = new PageObjectManager();
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	
	@When("User perform login with Username and Updating Password")
	public void userPerformLoginWithUsernameAndUpdatingPassword() throws FileNotFoundException, IOException {
	   
		pom.getLoginPage().memberLoginWithUpdateProfile();
	}

	@Then("User navigates to the User Profile page and verifies the page title is {string}")
	public void userNavigatesToTheUserProfilePageAndVerifiesThePageTitleIs(String string) {
		pom.getUserProfilePage().navigatesUserProfile();
	}

	@When("User should updates profiles with {string}, {string}, {string}, {string}, {string}")
	public void userShouldUpdatesProfilesWith(String firstName, String lastName, String oldPassword, String newPassword,
			String confirmPassword) {
		pom.getUserProfilePage().updateProfile(firstName, lastName, oldPassword, newPassword, confirmPassword);

	}

	@Then("User should clicks on Update, then verifes the alert success message {string}")
	public void userShouldClicksOnUpdateThenVerifesTheAlertSuccessMessage(String profileUpdatedMessage) {
		pom.getUserProfilePage().clicksUpdate();
		WebElement alertMessageProfileUpdated = pom.getUserProfilePage().getAlertMessageProfileUpdated();
		assertEquals(alertMessageProfileUpdated, profileUpdatedMessage);
	}

	@Then("User attempts to update the profile with empty fields and verifies the error messages {string} and {string}")
	public void userAttemptsToUpdateTheProfileWithEmptyFieldsAndVerifiesTheErrorMessagesAnd(String expErrorMsgFirstName,
			String expErrorMsgLastName) {
		pom.getUserProfilePage().emptyFieldValidation();
		pom.getUserProfilePage().clicksUpdate();
		WebElement errorMessageFirstName = pom.getUserProfilePage().getErrorMessageFirstName();
		WebElement errorMessageLastName = pom.getUserProfilePage().getErrorMessageLastName();
		assertEquals(errorMessageFirstName, expErrorMsgFirstName);
		assertEquals(errorMessageLastName, expErrorMsgLastName);

	}

	@Then("User enters an Old Password and New Password with fewer than {int} characters {string} and verifies that the error messages {string} and {string} are displayed")
	public void userEntersAnOldPasswordAndNewPasswordWithFewerThanCharactersAndVerifiesThatTheErrorMessagesAndAreDisplayed(
			Integer int1, String password, String expErrorMsgOldPasswordLength, String expErrorMsgNewPasswordLength) {
		pom.getUserProfilePage().PasswordFieldValidations(password);
		WebElement errorMessageOldPasswordLength = pom.getUserProfilePage().getErrorMessageOldPasswordLength();
		WebElement errorMessageNewPasswordLength = pom.getUserProfilePage().getErrorMessageNewPasswordLength();
		assertEquals(errorMessageOldPasswordLength, expErrorMsgOldPasswordLength);
		assertEquals(errorMessageNewPasswordLength, expErrorMsgNewPasswordLength);
	}

	@Then("User enters mismatched values in the New Password and Confirm Password fields and verifies the error message {string}")
	public void userEntersMismatchedValuesInTheNewPasswordAndConfirmPasswordFieldsAndVerifiesTheErrorMessage(
			String confirmPasswordErrorMessage) {
		pom.getUserProfilePage().insertMismatchedPasswords();
		pom.getUserProfilePage().clicksUpdate();
		WebElement errorMessageConfirmPassword = pom.getUserProfilePage().getErrorMessageConfirmPassword();
		assertEquals(errorMessageConfirmPassword, confirmPasswordErrorMessage);

	}

	@Then("User attempts to update the profile without providing the Old Password and verifies that the error message {string} is displayed")
	public void userAttemptsToUpdateTheProfileWithoutProvidingTheOldPasswordAndVerifiesThatTheErrorMessageIsDisplayed(
			String string) {
		pom.getUserProfilePage().validatewithoutprovidingOldPassword();
		pom.getUserProfilePage().clicksUpdate();
		WebElement errormessageOldPassword = pom.getUserProfilePage().getErrormessageOldPassword();
		assertEquals(errormessageOldPassword, string);

	}

	@Then("User attempts to update the profile without entering the Confirm Password and verifies that the error message {string} is displayed")
	public void userAttemptsToUpdateTheProfileWithoutEnteringTheConfirmPasswordAndVerifiesThatTheErrorMessageIsDisplayed(
			String confirmPasswordErrorMessage) {
		pom.getUserProfilePage().validatewithoutprovidingConfirmPassword();
		WebElement errorMessageConfirmPassword = pom.getUserProfilePage().getErrorMessageConfirmPassword();
		assertEquals(errorMessageConfirmPassword, confirmPasswordErrorMessage);
	}

	@Then("User attempts to update the profile with invalid Old Password and verifies that the warning message {string}")
	public void userAttemptsToUpdateTheProfileWithInvalidOldPasswordAndVerifiesThatTheWarningMessage(String string) {
		pom.getUserProfilePage().invalidOldPassword();
		pom.getUserProfilePage().clicksUpdate();
		WebElement warningmessageOldPasswordIncorrect = pom.getUserProfilePage()
				.getWarningmessageOldPasswordIncorrect();
		assertEquals(warningmessageOldPasswordIncorrect, string);
	}

}
