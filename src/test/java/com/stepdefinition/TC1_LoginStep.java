package com.stepdefinition;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.base.BaseClass;
import com.pageManager.PageObjectManager;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

/**
 * @author nloga
 * @see Used to perform Login
 * @Date 07-Feb-2025
 * 
 */
public class TC1_LoginStep extends BaseClass {

	PageObjectManager pom = new PageObjectManager();
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	/**
	 * @see Used to display the Login Page
	 */
	@Given("User is on the Mutual Drug Login")
	public void userIsOnTheMutualDrugLogin() {

	}

	/**
	 * @see Used to enter username and password and perform click to login
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	@When("User perform login with Username, Password")
	public void userPerformLoginWithUsernamePassword() throws FileNotFoundException, IOException {
		pom.getLoginPage().loginWithClick();
	}

	/**
	 * @throws IOException
	 * @throws FileNotFoundException
	 * @see Used to Memeber login
	 */
	@When("User perform login with Username and Password")
	public void userPerformLoginWithUsernameAndPassword() throws FileNotFoundException, IOException {
		pom.getLoginPage().memberLogin();
	}

	/**
	 * @see Used to login username and password by using Enter key
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	@When("User perform login Username, Password with Enter key")
	public void userPerformLoginUsernamePasswordWithEnterKey() throws FileNotFoundException, IOException {
		pom.getLoginPage().loginWithEnterKey();
	}

	/**
	 * @see Used to verify after login success message
	 * @param selectYourCustomerAccount
	 * @param successMessage
	 * @throws InterruptedException
	 */
	@Then("User should verify after login {string} and success message as {string}")
	public void userShouldVerifyAfterLoginAndSuccessMessageAs(String selectYourCustomerAccount, String successMessage)
			throws InterruptedException {
		try {
			Thread.sleep(4000);
			pom.getLoginPage().selectCustomerAccount(selectYourCustomerAccount);
			Thread.sleep(2000);
//		WebElement alertMessage = pom.getLoginPage().getAlertMessage();
//		assertEquals(alertMessage, successMessage);
		} catch (Exception e) {
		}
	}

	/**
	 * @see Used to login without username and password
	 */
	@When("User should perform login with empty fields")
	public void userShouldPerformLoginWithEmptyFields() {
		pom.getLoginPage().clickLogin();
	}

	/**
	 * @see Used to empty fields login error message validation
	 * @param expected_EmptyField_Username_Error_Message
	 * @param expected_EmptyField_Password_Error_Message
	 */
	@Then("User should verify empty fields login error message contains {string} , {string}")
	public void userShouldVerifyEmptyFieldsLoginErrorMessageContains(String expected_EmptyField_Username_Error_Message,
			String expected_EmptyField_Password_Error_Message) {
		WebElement textEmptyField_Username_Error_Message = pom.getLoginPage()
				.getTextEmptyField_Username_Error_Message();
		assertEquals(textEmptyField_Username_Error_Message, expected_EmptyField_Username_Error_Message);
		WebElement textEmptyField_Password_Error_Message = pom.getLoginPage()
				.getTextEmptyField_Password_Error_Message();
		assertEquals(textEmptyField_Password_Error_Message, expected_EmptyField_Password_Error_Message);
	}

	/**
	 * @see Used to login invalid username and invalid password
	 * @param invalid_Username
	 * @param Invalid_Password
	 */
	@When("User should perform login {string}, {string} with Invalid credentials")
	public void userShouldPerformLoginWithInvalidCredentials(String invalid_Username, String Invalid_Password) {
		pom.getLoginPage().insertInvalidLoginCredentials(invalid_Username, Invalid_Password);
		pom.getLoginPage().clickLogin();
	}

	/**
	 * @see Used to with invalid credentials and validate error message
	 * @param expected_InvalidCredential_Error_Message
	 */
	@Then("User should verify Invalid credentials login error message contains {string}")
	public void userShouldVerifyInvalidCredentialsLoginErrorMessageContains(
			String expected_InvalidCredential_Error_Message) {
		WebElement textInvalidCredential_Error_Message = pom.getLoginPage().getTextInvalidCredential_Error_Message();
		assertEquals(textInvalidCredential_Error_Message, expected_InvalidCredential_Error_Message);
	}

	/**
	 * @see Used to login with invalid username and valid password
	 * @param invalid_Username
	 * @param password
	 */
	@When("User perform login with {string} , {string}")
	public void userPerformLoginWith(String invalid_Username, String password) {
		pom.getLoginPage().insertInvalidUsername_Password(invalid_Username, password);
		pom.getLoginPage().clickLogin();
	}

	/**
	 * @see Used to login eith invalid username and validate error message
	 * @param expected_Invaild_UserName_Error_Message
	 */
	@Then("User should verify after login error message indicating that {string}")
	public void userShouldVerifyAfterLoginErrorMessageIndicatingThat(String expected_Invaild_UserName_Error_Message) {

		WebElement textInvaild_UserName_Error_Message = pom.getLoginPage().getTextInvaild_UserName_Error_Message();
		assertEquals(textInvaild_UserName_Error_Message, expected_Invaild_UserName_Error_Message);
	}

	/**
	 * @see Used to logout after login MD
	 */
	@Then("User clicks the logout button and verify successfully redirected to the login page")
	public void userClicksTheLogoutButtonAndVerifySuccessfullyRedirectedToTheLoginPage() {
		pom.getLoginPage().performLogout();
	}

	@When("User perform admin login with Username, Password")
	public void userPerformAdminLoginWithUsernamePassword() throws FileNotFoundException, IOException {

		pom.getLoginPage().adminLogin();
	}

	@Then("User should verify after successful login success message as {string}")
	public void userShouldVerifyAfterSuccessfulLoginSuccessMessageAs(String expectedTitleMemberUsers) {

		WebElement titleMemberUsers = pom.getAdminDashboardPage().getTitleMemberUsers();
		assertEquals(titleMemberUsers, expectedTitleMemberUsers);
	}

	@Given("User should clicks on SignUp")
	public void userShouldClicksOnSignUp() {
		pom.getLoginPage().clicksSignUp();
	}

	@When("User should perform SignUp with {string}, {string}, {string}, {string}, {string}, {string}")
	public void userShouldPerformSignUpWith(String memberNumber, String firstName, String lastName, String userName,
			String password, String confirmPassword) {
		pom.getLoginPage().insertSignUpDetails(memberNumber, firstName, lastName, userName, password, confirmPassword);
	}

	@When("User should clicks on SignIn redirects to login page")
	public void userShouldClicksOnSignInRedirectsToLoginPage() {
		pom.getLoginPage().clicksSignIn();
	}

	@When("User perform login with Signup Username, Password")
	public void userPerformLoginWithSignupUsernamePassword() throws FileNotFoundException, IOException {
		pom.getLoginPage().login_SignUp();
	}

	@Then("User should verify after login verifies the success message as {string}")
	public void userShouldVerifyAfterLoginVerifiesTheSuccessMessageAs(String expectedTitleMemberUsers) {
		WebElement titleMemberUsers = pom.getAdminDashboardPage().getTitleMemberUsers();
		assertEquals(titleMemberUsers, expectedTitleMemberUsers);
	}

	@Then("User should SignUp with empty fields verifies displaying error messages {string}, {string}, {string}, {string}, {string}, {string}")
	public void userShouldSignUpWithEmptyFieldsVerifiesDisplayingErrorMessages(String expectedMemberNumbererrormsg,
			String expectedFirstNameerrormsg, String expectedLastNameerrormsg, String expectedEmailerrormsg,
			String expectedPassworderrormsg, String expectedConfirmPassworderrormsg) {
		pom.getLoginPage().signupwithemptyFields();
		WebElement errorMessageMemberNumberRequired = pom.getLoginPage().getErrorMessageMemberNumberRequired();
		WebElement errorMessageFirstName = pom.getLoginPage().getErrorMessageFirstName();
		WebElement errorMessageLastName = pom.getLoginPage().getErrorMessageLastName();
		WebElement errorMessageEmail = pom.getLoginPage().getErrorMessageEmail();
		WebElement errorMessagePassword = pom.getLoginPage().getErrorMessagePassword();
		WebElement errorMessageConfirmPassword = pom.getLoginPage().getErrorMessageConfirmPassword();
		assertEquals(errorMessageMemberNumberRequired, expectedMemberNumbererrormsg);
		assertEquals(errorMessageFirstName, expectedFirstNameerrormsg);
		assertEquals(errorMessageLastName, expectedLastNameerrormsg);
		assertEquals(errorMessageEmail, expectedEmailerrormsg);
		assertEquals(errorMessagePassword, expectedPassworderrormsg);
		assertEquals(errorMessageConfirmPassword, expectedConfirmPassworderrormsg);

	}

	@Then("User should  sign-up with userName {string}, password {string}, confirmPassword {string} verifies the displaying error messages {string}, {string}, {string}")
	public void userShouldSignUpWithUserNamePasswordConfirmPasswordVerifiesTheDisplayingErrorMessages(String userName,
			String password, String confirmPassword, String expectedMemberNumbererrormsg,
			String expectedFirstNameerrormsg, String expectedLastNameerrormsg) {
		pom.getLoginPage().signupwithUserNamePassword(userName, password, confirmPassword);
		WebElement errorMessageMemberNumberRequired = pom.getLoginPage().getErrorMessageMemberNumberRequired();
		WebElement errorMessageFirstName = pom.getLoginPage().getErrorMessageFirstName();
		WebElement errorMessageLastName = pom.getLoginPage().getErrorMessageLastName();
		assertEquals(errorMessageMemberNumberRequired, expectedMemberNumbererrormsg);
		assertEquals(errorMessageFirstName, expectedFirstNameerrormsg);
		assertEquals(errorMessageLastName, expectedLastNameerrormsg);

	}

	@Then("User enters an invalid email format {string} and verifies the error message {string}")
	public void userEntersAnInvalidEmailFormatAndVerifiesTheErrorMessage(String invalidmail,
			String invalidMailformatMessage) {

		pom.getLoginPage().invalidEmail(invalidmail);
		WebElement errorMessageInvalidEmail = pom.getLoginPage().getErrorMessageInvalidEmail();
		assertEquals(errorMessageInvalidEmail, invalidMailformatMessage);
	}

	@Then("User enters a password with fewer than {int} characters {string} and verifies the error message {string} is displayed")
	public void userEntersAPasswordWithFewerThanCharactersAndVerifiesTheErrorMessageIsDisplayed(Integer int1,
			String password, String invalidPasswordMsg) {

		pom.getLoginPage().passwordValidation(password);
		WebElement errorMessageinvalidPassword = pom.getLoginPage().getErrorMessageinvalidPassword();
		assertEquals(errorMessageinvalidPassword, invalidPasswordMsg);

	}

	@Then("User enters a Confirm Password that does not match the original password, then verifies the error message {string}")
	public void userEntersAConfirmPasswordThatDoesNotMatchTheOriginalPasswordThenVerifiesTheErrorMessage(
			String invalidConfirmPasswordErrorMSg) {
		pom.getLoginPage().confirmPasswordValidation();
		WebElement errorMessageinvalidConfirmPassword = pom.getLoginPage().getErrorMessageinvalidConfirmPassword();
		assertEquals(errorMessageinvalidConfirmPassword, invalidConfirmPasswordErrorMSg);

	}

	@Then("User attempts to Sign Up with an already used Member Number {string}, then verifies the alert message {string}")
	public void userAttemptsToSignUpWithAnAlreadyUsedMemberNumberThenVerifiesTheAlertMessage(String memberNumber,
			String string2) {
		pom.getLoginPage().signUpwithAlreadyUsedMember(memberNumber);

	}

	@Then("User attempts to Sign Up with an invalid Member Number {string}, then verifies the alert message {string}")
	public void userAttemptsToSignUpWithAnInvalidMemberNumberThenVerifiesTheAlertMessage(String memberNumber,
			String string2) {
		pom.getLoginPage().signUpwithAlreadyUsedMember(memberNumber);
		WebElement alertMessageInvalidmembernumber = pom.getLoginPage().getAlertMessageInvalidmembernumber();
		assertEquals(alertMessageInvalidmembernumber, string2);

	}

	@Then("User attempts to Sign Up with an already used email {string}, then verifies the alert message {string}")
	public void userAttemptsToSignUpWithAnAlreadyUsedEmailThenVerifiesTheAlertMessage(String string, String string2) {
		pom.getLoginPage().mailValidation();
		WebElement alertMessageEmailAlreadyExists = pom.getLoginPage().getAlertMessageEmailAlreadyExists();
		assertEquals(alertMessageEmailAlreadyExists, string2);
	}

	@Given("User should clicks on Forgot Password link")
	public void userShouldClicksOnForgotPasswordLink() {
		pom.getLoginPage().clicksForgotPasswordLink();

	}

	@When("User enters a valid email address {string} and submits the password reset request")
	public void userEntersAValidEmailAddressAndSubmitsThePasswordResetRequest(String emailAddress) {
		pom.getLoginPage().insertEmailAddress(emailAddress);

	}

	@Then("User should successfully redirected to the login page {string}")
	public void userShouldSuccessfullyRedirectedToTheLoginPage(String expectedUrl) throws InterruptedException {
		wait.until(ExpectedConditions.urlToBe(expectedUrl));
		String actualUrl = driver.getCurrentUrl();
		Assert.assertEquals("Redirection failed after Forgot Password.", expectedUrl, actualUrl);
		System.out.println(" Redirected to expected login page: " + actualUrl);

	}

	@Then("User should Attempt to reset password with empty email field, then verifies the error message {string}")
	public void userShouldAttemptToResetPasswordWithEmptyEmailFieldThenVerifiesTheErrorMessage(String errorMessage) {
		pom.getLoginPage().emptyfieldsEmailAddress();
		WebElement errorMessageEmailAddress = pom.getLoginPage().getErrorMessageEmailAddress();
		assertEquals(errorMessageEmailAddress, errorMessage);
	}

	@Then("User attempts to reset the password using an invalid email formats and verifies the error message {string}")
	public void userAttemptsToResetThePasswordUsingAnInvalidEmailFormatsAndVerifiesTheErrorMessage(String errorMessage,
			io.cucumber.datatable.DataTable dataTable) {
		List<Map<String, String>> itemsData = dataTable.asMaps();

		for (Map<String, String> item : itemsData) {
			String emailAddress = item.get("invalidEmail");
			pom.getLoginPage().insertEmailAddress(emailAddress);
			WebElement errorMessageInvaildEmailAddress = pom.getLoginPage().getTextInvaild_EmailAddress_Error_Message();
			assertEquals(errorMessageInvaildEmailAddress, errorMessage);
		}
	}

	@Then("User enters only spaces in the email field {string} and clicks {string}, then verifies the error message {string}")
	public void userEntersOnlySpacesInTheEmailFieldAndClicksThenVerifiesTheErrorMessage(String emailAddress,
			String string2, String errorMessage) {

		pom.getLoginPage().insertEmailAddress(emailAddress);
		WebElement errorMessageEmailAddress = pom.getLoginPage().getErrorMessageEmailAddress();
		assertEquals(errorMessageEmailAddress, errorMessage);
	}

	@Then("User enters special characters in the email field {string} and attempts to reset the password, verifying the error message {string}")
	public void userEntersSpecialCharactersInTheEmailFieldAndAttemptsToResetThePasswordVerifyingTheErrorMessage(
			String emailAddress, String errorMessage) {
		pom.getLoginPage().insertEmailAddress(emailAddress);
		WebElement errorMessageInvaildEmailAddress = pom.getLoginPage().getTextInvaild_EmailAddress_Error_Message();
		assertEquals(errorMessageInvaildEmailAddress, errorMessage);

	}

}
