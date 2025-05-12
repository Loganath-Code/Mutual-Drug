package com.pages;

import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.base.BaseClass;

public class UserProfilePage extends BaseClass {
	public UserProfilePage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@class='user-profile-icon']")
	private WebElement iUserProfile;

	@FindBy(xpath = "//a[normalize-space()='Account']")
	private WebElement mteAccount;

	@FindBy(xpath = "//h2[text()='User Profile']")
	private WebElement titleUserProfile;

	@FindBy(xpath = "//input[@name='firstName']")
	private WebElement txtFirstName;

	@FindBy(xpath = "//input[@name='lastName']")
	private WebElement txtLastName;

	@FindBy(xpath = "//input[@name='email']")
	private WebElement txtEmail;

	@FindBy(xpath = "//input[@name='oldPassword']")
	private WebElement txtOldPassword;

	@FindBy(xpath = "//input[@name='password']")
	private WebElement txtNewPassword;

	@FindBy(xpath = "//input[@name='confirmPassword']")
	private WebElement txtConfirmPassword;

	@FindBy(xpath = "//button[text()='Update']")
	private WebElement btnUpdate;

	@FindBy(xpath = "//div[text()='First Name is required']")
	private WebElement errorMessageFirstName;

	@FindBy(xpath = "//div[text()='Last Name is required']")
	private WebElement errorMessageLastName;

	@FindBy(xpath = "//div[text()='Old Password must be at least 8 characters ']")
	private WebElement errorMessageOldPasswordLength;

	@FindBy(xpath = "//div[text()='New Password must be at least 8 characters ']")
	private WebElement errorMessageNewPasswordLength;

	@FindBy(xpath = "//div[text()='Confirm Password must match with New Password.']")
	private WebElement errorMessageConfirmPassword;

	@FindBy(xpath = "//div[contains(text(),'Old Password is required')]")
	private WebElement errormessageOldPassword;

	@FindBy(xpath = "//div[text()='New Password is required']")
	private WebElement errormessageNewPassword;

	@FindBy(xpath = "//div[@aria-label='Profile updated.']")
	private WebElement alertMessageProfileUpdated;

	@FindBy(xpath = "//div[normalize-space()='Old password is incorrect.']")
	private WebElement warningmessageOldPasswordIncorrect;

	public WebElement getiUserProfile() {
		return iUserProfile;
	}

	public WebElement getMteAccount() {
		return mteAccount;
	}

	public WebElement getTitleUserProfile() {
		return titleUserProfile;
	}

	public WebElement getTxtFirstName() {
		return txtFirstName;
	}

	public WebElement getTxtLastName() {
		return txtLastName;
	}

	public WebElement getTxtEmail() {
		return txtEmail;
	}

	public WebElement getTxtOldPassword() {
		return txtOldPassword;
	}

	public WebElement getTxtNewPassword() {
		return txtNewPassword;
	}

	public WebElement getTxtConfirmPassword() {
		return txtConfirmPassword;
	}

	public WebElement getBtnUpdate() {
		return btnUpdate;
	}

	public WebElement getErrorMessageFirstName() {
		return errorMessageFirstName;
	}

	public WebElement getErrorMessageLastName() {
		return errorMessageLastName;
	}

	public WebElement getErrorMessageOldPasswordLength() {
		return errorMessageOldPasswordLength;
	}

	public WebElement getErrorMessageNewPasswordLength() {
		return errorMessageNewPasswordLength;
	}

	public WebElement getErrorMessageConfirmPassword() {
		return errorMessageConfirmPassword;
	}

	public WebElement getErrormessageOldPassword() {
		return errormessageOldPassword;
	}

	public WebElement getErrormessageNewPassword() {
		return errormessageNewPassword;
	}

	public WebElement getAlertMessageProfileUpdated() {
		return alertMessageProfileUpdated;
	}

	public WebElement getWarningmessageOldPasswordIncorrect() {
		return warningmessageOldPasswordIncorrect;
	}

	public void navigatesUserProfile() {
		moveToElement(getiUserProfile());
		clickElementUsingJavaScript(driver, getiUserProfile());
		clickElementUsingJavaScript(driver, getMteAccount());

	}

	/**
	 * @see Used to updating User Profile details
	 * @param firstName
	 * @param lastName
	 * @param oldPassword
	 * @param newPassword
	 * @param confirmPassword
	 */
	public void updateProfile(String firstName, String lastName, String oldPassword, String newPassword,
			String confirmPassword) {
		insertValue(getTxtFirstName(), firstName);
		insertValue(getTxtLastName(), lastName);
		insertValue(getTxtOldPassword(), oldPassword);
		insertValue(getTxtNewPassword(), newPassword);
		insertValue(getTxtConfirmPassword(), confirmPassword);

	}

	public void clicksUpdate() {
		clickElementUsingJavaScript(driver, getBtnUpdate());

	}

	public void clearValueUsingRobotClass(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement field = wait.until(ExpectedConditions.elementToBeClickable(element));
		field.sendKeys("test");
		field.sendKeys(Keys.chord(Keys.CONTROL, "a")); // Select all existing text
		field.sendKeys(Keys.BACK_SPACE); // Delete it

	}

	/**
	 * @see Used to empty field validations
	 */
	public void emptyFieldValidation() {
		clearValueUsingRobotClass(getTxtFirstName());
		clearValueUsingRobotClass(getTxtLastName());
		clearTextField(getTxtOldPassword());
		clearTextField(getTxtNewPassword());
		clearTextField(getTxtConfirmPassword());

	}

	/**
	 * @see Used Old Password and New Password Fields validations
	 */
	public void PasswordFieldValidations(String password) {
		insertValue(getTxtFirstName(), "Pat");
		insertValue(getTxtLastName(), "Cummins");
		insertValue(getTxtOldPassword(), password);
		insertValue(getTxtNewPassword(), password);
		insertValue(getTxtConfirmPassword(), password);

	}

	public void insertMismatchedPasswords() {
		emptyFieldValidation();
		insertValue(getTxtFirstName(), "Pat");
		insertValue(getTxtLastName(), "Cummins");
		insertValue(getTxtOldPassword(), "Test1234");
		insertValue(getTxtNewPassword(), "Test1234");
		insertValue(getTxtConfirmPassword(), "Test123455");

	}

	public void validatewithoutprovidingOldPassword() {
		emptyFieldValidation();
		insertValue(getTxtFirstName(), "Pat");
		insertValue(getTxtLastName(), "Cummins");
		clearValueUsingRobotClass(getTxtOldPassword());
		insertValue(getTxtNewPassword(), "Test1234");
		insertValue(getTxtConfirmPassword(), "Test1234");

	}

	public void validatewithoutprovidingConfirmPassword() {
		emptyFieldValidation();
		insertValue(getTxtFirstName(), "Patrick");
		insertValue(getTxtLastName(), "Cummins");
		insertValue(getTxtOldPassword(), "Test1234");
		insertValue(getTxtNewPassword(), "Test1234");
		clearValueUsingRobotClass(getTxtConfirmPassword());

	}

	public void invalidOldPassword() {
		emptyFieldValidation();
		insertValue(getTxtFirstName(), "Pat");
		insertValue(getTxtLastName(), "Cummins");
		insertValue(getTxtOldPassword(), "Test12345556");
		insertValue(getTxtNewPassword(), "Test1234");
		insertValue(getTxtConfirmPassword(), "Test1234");

	}
}
