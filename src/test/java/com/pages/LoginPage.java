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

	@FindBy(xpath = "//div[contains(text(),'Email must be a valid email address')]")
	private WebElement textInvaild_EmailAddress_Error_Message;

	// signUp
	@FindBy(xpath = "//input[@name='memberNo']")
	private WebElement txtMember_Number;

	@FindBy(xpath = "//input[@name='firstName']")
	private WebElement txtFirst_Name;

	@FindBy(xpath = "//input[@name='lastName']")
	private WebElement txtLast_Name;

	@FindBy(xpath = "//input[@name='confirmPassword']")
	private WebElement txtConfirm_Password;

	@FindBy(xpath = "//button[@class='btn-primary login-btn']")
	private WebElement btnSign_Up;

	@FindBy(xpath = "//a[@class='signup-link']")
	private WebElement sign_in;

	@FindBy(xpath = "//select[@class='form-control']")
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

	public WebElement getTxtMember_Number() {
		return txtMember_Number;
	}

	public WebElement getTextInvaild_EmailAddress_Error_Message() {
		return textInvaild_EmailAddress_Error_Message;
	}

	public WebElement getTextInvaild_UserName_Error_Message() {
		return textInvaild_UserName_Error_Message;
	}

	public WebElement getTxtFirst_Name() {
		return txtFirst_Name;
	}

	public WebElement getTxtLast_Name() {
		return txtLast_Name;
	}

	public WebElement getTxtConfirm_Password() {
		return txtConfirm_Password;
	}

	public WebElement getBtnSign_Up() {
		return btnSign_Up;
	}

	public WebElement getSign_in() {
		return sign_in;
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
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(getDdSelect_Your_Customer_Account()));
		selectByVisibleText(getDdSelect_Your_Customer_Account(), selectYourCustomerAccount);
		System.out.println(selectYourCustomerAccount);
		wait.until(ExpectedConditions.elementToBeClickable(getBtnSubmit()));
		clickWithActions(getBtnSubmit());
		Thread.sleep(2000);
		clickElementUsingJavaScript(driver, getBtnSubmit());

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
		clickElementUsingJavaScript(driver, getiClose());

	}

	/**
	 * @see Used to logout
	 */
	public void performLogout() {
		closeNotifications();
		moveToElement(getIconUserProfile());
		click(getIconUserProfile());
		click(getLogOut());

	}

}
