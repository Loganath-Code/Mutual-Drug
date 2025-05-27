package com.pages;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.base.BaseClass;

/**
 * @see Used to find the locators assign the values in Login Page
 * @Date 06-Feb-2025
 */
public class LoginPage extends BaseClass {

	/**
	 * @see Constructor Used to initialize the values
	 */
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@name='username']")
	private WebElement txtUserName;

	@FindBy(xpath = "//input[@type='password']")
	private WebElement txtPassword;

	@FindBy(xpath = "//a[@routerlink='/forgot-password']")
	private WebElement forgot_Password;

	@FindBy(xpath = "//button[@class='btn-primary login-btn']")
	private WebElement btnLogin;

	@FindBy(xpath = "//a[@routerlink='/sign-up']")
	private WebElement sign_up;

	@FindBy(xpath = "//div[contains(text(),'Email is required')]")
	private WebElement textEmptyField_Username_Error_Message;

	@FindBy(xpath = "//div[contains(text(),'Password is required')]")
	private WebElement textEmptyField_Password_Error_Message;

	@FindBy(xpath = "//div[@class='alert alert-danger unAuthorizedAlert']")
	private WebElement textInvalidCredential_Error_Message;

	@FindBy(xpath = "//div[contains(text(),'Email must be a valid email address')]")
	private WebElement textInvaild_UserName_Error_Message;

	// forgot password

	@FindBy(xpath = "//input[@name='email']")
	private WebElement txtEmail_Address;

	@FindBy(xpath = "//button[@class='btn-primary login-btn']")
	private WebElement btnSend_Reset_Link;

	@FindBy(xpath = "//a[@class='cancel-btn']")
	private WebElement btnCancel;

	@FindBy(xpath = "//div[text()='Email is required']")
	private WebElement errorMessageEmailAddress;

	@FindBy(xpath = "//div[contains(text(),'Email must be a valid email address')]")
	private WebElement textInvaild_EmailAddress_Error_Message;

	// signUp
	@FindBy(xpath = "//input[@name='memberNo']")
	private WebElement txtMember_Number;

	@FindBy(xpath = "//input[@name='firstName']")
	private WebElement txtFirst_Name;

	@FindBy(xpath = "//input[@name='lastName']")
	private WebElement txtLast_Name;

	@FindBy(xpath = "//input[@name='email']")
	private WebElement txtUsername;

	@FindBy(xpath = "//input[@name='password']")
	private WebElement txtPassWord;

	@FindBy(xpath = "//input[@name='confirmPassword']")
	private WebElement txtConfirm_Password;

	@FindBy(xpath = "//button[@class='btn-primary login-btn']")
	private WebElement btnSign_Up;

	@FindBy(xpath = "//a[@class='signup-link']")
	private WebElement sign_in;

	@FindBy(xpath = "//div[contains(text(),'Member Number is required')]")
	private WebElement errorMessageMemberNumberRequired;

	@FindBy(xpath = "//div[contains(text(),'First Name is required')]")
	private WebElement errorMessageFirstName;

	@FindBy(xpath = "//div[contains(text(),'Last Name is required')]")
	private WebElement errorMessageLastName;

	@FindBy(xpath = "//div[contains(text(),'Email is required')]")
	private WebElement errorMessageEmail;

	@FindBy(xpath = "//div[contains(text(),'Email must be a valid email address')]")
	private WebElement errorMessageInvalidEmail;

	@FindBy(xpath = "//div[contains(text(),'Password is required')]")
	private WebElement errorMessagePassword;

	@FindBy(xpath = "//div[contains(text(),'Password must be at least 8 characters ')]")
	private WebElement errorMessageinvalidPassword;

	@FindBy(xpath = "//div[contains(text(),'Confirm Password is required')]")
	private WebElement errorMessageConfirmPassword;

	@FindBy(xpath = "//div[contains(text(),'Confirm Password must match with password.')]")
	private WebElement errorMessageinvalidConfirmPassword;

	@FindBy(xpath = "//div[contains(text(), 'Email already exists')]")
	private WebElement alertMessageEmailAlreadyExists;

	@FindBy(xpath = "//div[contains(text(), ' Invalid member number.')]")
	private WebElement alertMessageInvalidmembernumber;

	@FindBy(xpath = "//a[text()='Sign in']")
	private WebElement btnSignIn;

//dashboard

	@FindBy(xpath = "(//select[contains(@class, 'form-control')])")
	private WebElement ddSelect_Your_Customer_Account;

	@FindBy(xpath = "//button[@class='modal-btn']")
	private WebElement btnSubmit;

	@FindBy(xpath = "//h3[text()='Member Access Portal']")
	private WebElement textMemberAccessPortal;

	@FindBy(xpath = "//a[@class='user-profile-icon']")
	private WebElement iconUserProfile;

	@FindBy(xpath = "//a[text()='Logout']")
	private WebElement logOut;

	@FindBy(xpath = "//div[@aria-label='C2 CERTIFICATE NOTIFICATION !!']")
	private WebElement alertMessage;

	@FindBy(xpath = "//button[@aria-label='Close']")
	private WebElement iClose;

	public WebElement getTxtUserName() {
		return txtUserName;
	}

	public WebElement getTxtPassword() {
		return txtPassword;
	}

	public WebElement getForgot_Password() {
		return forgot_Password;
	}

	public WebElement getBtnLogin() {
		return btnLogin;
	}

	public WebElement getSign_up() {
		return sign_up;
	}

	public WebElement getTextEmptyField_Username_Error_Message() {
		return textEmptyField_Username_Error_Message;
	}

	public WebElement getTextEmptyField_Password_Error_Message() {
		return textEmptyField_Password_Error_Message;
	}

	public WebElement getTextInvalidCredential_Error_Message() {
		return textInvalidCredential_Error_Message;
	}

	public WebElement getTxtEmail_Address() {
		return txtEmail_Address;
	}

	public WebElement getBtnSend_Reset_Link() {
		return btnSend_Reset_Link;
	}

	public WebElement getBtnCancel() {
		return btnCancel;
	}

	public WebElement getErrorMessageEmailAddress() {
		return errorMessageEmailAddress;
	}

	public WebElement getTxtMember_Number() {
		return txtMember_Number;
	}

	public WebElement getTextInvaild_UserName_Error_Message() {
		return textInvaild_UserName_Error_Message;
	}

	public WebElement getTextInvaild_EmailAddress_Error_Message() {
		return textInvaild_EmailAddress_Error_Message;
	}

	public WebElement getTxtFirst_Name() {
		return txtFirst_Name;
	}

	public WebElement getTxtLast_Name() {
		return txtLast_Name;
	}

	public WebElement getTxtUsername() {
		return txtUsername;
	}

	public WebElement getTxtPassWord() {
		return txtPassWord;
	}

	public WebElement getTxtConfirm_Password() {
		return txtConfirm_Password;
	}

	public WebElement getErrorMessageMemberNumberRequired() {
		return errorMessageMemberNumberRequired;
	}

	public WebElement getErrorMessageFirstName() {
		return errorMessageFirstName;
	}

	public WebElement getErrorMessageLastName() {
		return errorMessageLastName;
	}

	public WebElement getErrorMessageEmail() {
		return errorMessageEmail;
	}

	public WebElement getErrorMessageInvalidEmail() {
		return errorMessageInvalidEmail;
	}

	public WebElement getErrorMessagePassword() {
		return errorMessagePassword;
	}

	public WebElement getErrorMessageinvalidPassword() {
		return errorMessageinvalidPassword;
	}

	public WebElement getErrorMessageConfirmPassword() {
		return errorMessageConfirmPassword;
	}

	public WebElement getErrorMessageinvalidConfirmPassword() {
		return errorMessageinvalidConfirmPassword;
	}

	public WebElement getAlertMessageEmailAlreadyExists() {
		return alertMessageEmailAlreadyExists;
	}

	public WebElement getBtnSign_Up() {
		return btnSign_Up;
	}

	public WebElement getSign_in() {
		return sign_in;
	}

	public WebElement getAlertMessageInvalidmembernumber() {
		return alertMessageInvalidmembernumber;
	}

	public WebElement getBtnSignIn() {
		return btnSignIn;
	}

	public WebElement getDdSelect_Your_Customer_Account() {
		return ddSelect_Your_Customer_Account;
	}

	public WebElement getBtnSubmit() {
		return btnSubmit;
	}

	public WebElement getTextMemberAccessPortal() {
		return textMemberAccessPortal;
	}

	public WebElement getIconUserProfile() {
		return iconUserProfile;
	}

	public WebElement getLogOut() {
		return logOut;
	}

	public WebElement getAlertMessage() {
		return alertMessage;
	}

	public WebElement getiClose() {
		return iClose;
	}

	/**
	 * @see Used to insert only values for Username and Password
	 * @param Username
	 * @param password
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public void loginStep() throws FileNotFoundException, IOException {

		String username = getPropertyFileValue("userName");
		String password = getPropertyFileValue("passWord");
		insertValue(getTxtUserName(), username);
		insertValue(getTxtPassword(), password);

	}

	/**
	 * @see Used to insert the values for username and password with click login
	 *      button
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public void loginWithClick() throws FileNotFoundException, IOException {
		loginStep();
		click(getBtnLogin());

	}

	public void selectCustomerAccount(String selectYourCustomerAccount) throws InterruptedException {
		if (getDdSelect_Your_Customer_Account().isDisplayed()) {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(getDdSelect_Your_Customer_Account()));
			selectByVisibleText(getDdSelect_Your_Customer_Account(), selectYourCustomerAccount);
			System.out.println(selectYourCustomerAccount);
			wait.until(ExpectedConditions.elementToBeClickable(getBtnSubmit()));
			clickWithActions(getBtnSubmit());
			Thread.sleep(2000);
			clickElementUsingJavaScript(driver, getBtnSubmit());
		}
	}

	/**
	 * @see Used to insert the values for Username and password using robotclass to
	 *      click login button
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public void loginWithEnterKey() throws FileNotFoundException, IOException {
		loginStep();
		keyDown(Keys.TAB);
		keyUp(Keys.TAB);
		keyDown(Keys.TAB);
		keyUp(Keys.TAB);
		keyDown(Keys.TAB);
		keyUp(Keys.TAB);
		keyDown(Keys.TAB);
		keyUp(Keys.TAB);
		keyDown(Keys.TAB);
		keyUp(Keys.TAB);
		keyDown(Keys.TAB);
		keyUp(Keys.TAB);
		keyDown(Keys.ENTER);
		keyUp(Keys.ENTER);

	}

	/**
	 * @see Used to Login Button
	 * 
	 */
	public void clickLogin() {
		click(getBtnLogin());

	}

	/**
	 * @see Used to insert invalid username and password
	 * @param username
	 * @param password
	 */
	public void insertInvalidLoginCredentials(String invalid_Username, String Invalid_Password) {
		insertValue(getTxtUserName(), invalid_Username);
		insertValue(getTxtPassword(), Invalid_Password);

	}

	/**
	 * @see Used to insert invalid Username and valid Password
	 * @param invalid_Username
	 * @param password
	 */
	public void insertInvalidUsername_Password(String invalid_Username, String password) {
		insertValue(getTxtUserName(), invalid_Username);
		insertValue(getTxtPassword(), password);

	}

	public void closeNotifications() {
		try {
			if (getiClose().isDisplayed()) {
				clickElementUsingJavaScript(driver, getiClose());
			}
		} catch (Exception e) {

		}
	}

	/**
	 * @see Used to logout
	 */
	public void performLogout() {
		closeNotifications();
		// moveToElement(getIconUserProfile());
		scrollToElement(getIconUserProfile());
		click(getIconUserProfile());
		click(getLogOut());

	}

	/**
	 * @see Used login with admin User
	 * @throws IOException
	 * @throws FileNotFoundException
	 * @see Used to admin Login
	 */
	public void adminLogin() throws FileNotFoundException, IOException {
		String username = getPropertyFileValue("adminUserName");
		String password = getPropertyFileValue("adminPassword");
		insertValue(getTxtUserName(), username);
		insertValue(getTxtPassword(), password);
		click(getBtnLogin());

	}

	/**
	 * @see Used to Member login
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public void memberLogin() throws FileNotFoundException, IOException {
		String username = getPropertyFileValue("memberUserName");
		String password = getPropertyFileValue("memberPassWord");
		insertValue(getTxtUserName(), username);
		insertValue(getTxtPassword(), password);
		click(getBtnLogin());

	}

	/**
	 * @see Used to login after update profile
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public void memberLoginWithUpdateProfile() throws FileNotFoundException, IOException {
		String username = getPropertyFileValue("memberUserName");
		String password = getPropertyFileValue("memberNewPassWord");
		insertValue(getTxtUserName(), username);
		insertValue(getTxtPassword(), password);
		click(getBtnLogin());

	}

	/**
	 * @see User to admin User logged out
	 */
	public void adminLogout() {
		moveToElement(getIconUserProfile());
		click(getIconUserProfile());
		click(getLogOut());

	}

	/**
	 * @see Used to clicks SignUp link
	 */
	public void clicksSignUp() {
		elementToBeClickable(getSign_up());
		clickElementUsingJavaScript(driver, getSign_up());
	}

	/**
	 * @see Used to Insert SignUp details
	 */
	public void insertSignUpDetails(String memberNumber, String firstName, String lastName, String userName,
			String password, String confirmPassword) {
		insertValue(getTxtMember_Number(), memberNumber);
		insertValue(getTxtFirst_Name(), firstName);
		insertValue(getTxtLast_Name(), lastName);
		insertValue(getTxtUsername(), userName);
		insertValue(getTxtPassWord(), password);
		insertValue(getTxtConfirm_Password(), confirmPassword);
		click(getBtnSign_Up());
	}

	/**
	 * @see Used to clicks SignIn button after insert SignUp Datails
	 */
	public void clicksSignIn() {
		elementVisibility(getBtnSignIn());
		clickElementUsingJavaScript(driver, getBtnSignIn());
	}

	/**
	 * @see Used login after signUp
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public void login_SignUp() throws FileNotFoundException, IOException {
		String username = getPropertyFileValue("signUpUserName");
		String password = getPropertyFileValue("signUpPassword");
		insertValue(getTxtUserName(), username);
		insertValue(getTxtPassword(), password);
		click(getBtnLogin());

	}

	/**
	 * @see Used to Signup with empty fields
	 */
	public void signupwithemptyFields() {
		clearTextField(getTxtMember_Number());
		clearTextField(getTxtFirst_Name());
		clearTextField(getTxtLast_Name());
		clearTextField(getTxtUsername());
		clearTextField(getTxtPassWord());
		clearTextField(getTxtConfirm_Password());
		click(getBtnSign_Up());

	}

	/**
	 * @see Used to signup with UserName, Password, confirm password
	 * @param userName
	 * @param password
	 * @param confirmPassword
	 */
	public void signupwithUserNamePassword(String userName, String password, String confirmPassword) {
		insertValue(getTxtUsername(), userName);
		insertValue(getTxtPassWord(), password);
		insertValue(getTxtConfirm_Password(), confirmPassword);
		click(getBtnSign_Up());

	}

	/**
	 * @see Used to entering invalid email
	 * @param invalidmail
	 */
	public void invalidEmail(String invalidmail) {
		clearTextUsingjs(getTxtUsername());
		insertValue(getTxtUsername(), invalidmail);

	}

	/**
	 * @see Used to password validation
	 */
	public void passwordValidation(String password) {
		clearTextUsingjs(getTxtPassWord());
		insertValue(getTxtPassWord(), password);

	}

	/**
	 * @see Used to Confirm Password validation
	 */
	public void confirmPasswordValidation() {
		clearTextUsingjs(getTxtPassWord());
		insertValue(getTxtPassWord(), "Test1234");
		insertValue(getTxtConfirm_Password(), "Test");

	}

	/**
	 * @see used Sign Up with an already used Member
	 */
	public void signUpwithAlreadyUsedMember(String memberNumber) {
		insertValue(getTxtMember_Number(), memberNumber);
		insertValue(getTxtFirst_Name(), "Test");
		insertValue(getTxtLast_Name(), "TEST");
		insertValue(getTxtUsername(), "sajeso6269@linxues.com");
		insertValue(getTxtPassWord(), "Test1234");
		insertValue(getTxtConfirm_Password(), "Test1234");
		click(getBtnSign_Up());
	}

	public void invalidMemberNumber(String memberNumber) {
		insertValue(getTxtMember_Number(), memberNumber);
		insertValue(getTxtFirst_Name(), "Test");
		insertValue(getTxtLast_Name(), "TEST");
		insertValue(getTxtUsername(), "cowoc38407@lushosa.com");
		insertValue(getTxtPassWord(), "Test1234");
		insertValue(getTxtConfirm_Password(), "Test1234");
		click(getBtnSign_Up());

	}

	public void mailValidation() {
		insertValue(getTxtMember_Number(), "126367");
		insertValue(getTxtFirst_Name(), "Test");
		insertValue(getTxtLast_Name(), "TEST");
		insertValue(getTxtUsername(), "cowoc38407@lushosa.com");
		insertValue(getTxtPassWord(), "Test1234");
		insertValue(getTxtConfirm_Password(), "Test1234");
		click(getBtnSign_Up());
	}

	public void clicksForgotPasswordLink() {
		clickElementUsingJavaScript(driver, getForgot_Password());

	}

	/**
	 * @see Used insert email address
	 * @param emailAddress
	 */
	public void insertEmailAddress(String emailAddress) {
		insertValue(getTxtEmail_Address(), emailAddress);
		click(getBtnSend_Reset_Link());

	}

	/**
	 * @see Used to attempts empty fields EmailAddress to clicks on send Reset Link
	 */
	public void emptyfieldsEmailAddress() {
		clearTextField(getTxtEmail_Address());
		click(getBtnSend_Reset_Link());

	}

}
