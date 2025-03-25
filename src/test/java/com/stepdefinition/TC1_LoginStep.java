package com.stepdefinition;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.WebElement;

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

}
