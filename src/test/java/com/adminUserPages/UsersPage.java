package com.adminUserPages;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.base.BaseClass;

public class UsersPage extends BaseClass {

	public UsersPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//h2[text()='Member Users']")
	private WebElement titleMemberUsers;

	@FindBy(xpath = "//button[normalize-space()='Invite User']")
	private WebElement btnInviteUser;

	@FindBy(xpath = "//input[@name='firstName']")
	private WebElement txtFirstName;

	@FindBy(xpath = "//input[@name='lastName']")
	private WebElement txtLastName;

	@FindBy(xpath = "//input[@name='email']")
	private WebElement txtEmail;

	@FindBy(xpath = "//mat-select[@name='memberNumber']")
	private WebElement ddMemberNumber;

	@FindBy(xpath = "//select[@name='roleId']")
	private WebElement ddUserRole;

	@FindBy(xpath = "//button[text()='Invite']")
	private WebElement btnInvite;

	@FindBy(xpath = "//div[contains(text(),'First Name is required')]")
	private WebElement errorMessageFirstName;

	@FindBy(xpath = "//div[contains(text(),'Last Name is required')]")
	private WebElement errorMessageLastName;

	@FindBy(xpath = "//div[contains(text(),'Email is required')]")
	private WebElement errorMessageEmail;

	@FindBy(xpath = "//div[contains(text(),'Email must be a valid email address')]")
	private WebElement errormessageInvalidEmail;

	@FindBy(xpath = "//div[contains(text(),'Member Number is required')]")
	private WebElement errorMessageMemberNumber;

	@FindBy(xpath = "//div[contains(text(),'User Role is required')]")
	private WebElement errorMessageUserRole;

	@FindBy(xpath = "//div[@aria-label='User invite sent.']")
	private WebElement successMessageUserInvite;

	@FindBy(xpath = "//input[@placeholder='Search for Member Users']")
	private WebElement txtSearch;

	@FindBy(xpath = "//button[@class='search']")
	private WebElement iSearch;

	@FindBy(xpath = "(//td[@class='mat-cell cdk-cell cdk-column-firstName mat-column-firstName ng-star-inserted']//a)[1]")
	private WebElement tdFirstcellFirstNamedata;

	@FindBy(xpath = "(//td[@class='mat-cell cdk-cell cdk-column-lastName mat-column-lastName ng-star-inserted']//a)[1]")
	private WebElement tdFirstcellLastNamedata;

	@FindBy(xpath = "//input[@class='mat-slide-toggle-input cdk-visually-hidden']")
	private WebElement toggleStatus;

	@FindBy(xpath = "//select[@placeholder='User Role']")
	private WebElement ddUserRoleMemberUserEdit;

	@FindBy(xpath = "//button[text()='Save']")
	private WebElement btnSave;

	@FindBy(xpath = "(//i[@class='fa fa-trash'])[1]")
	private WebElement deleteMemberAccounts;

	@FindBy(xpath = "//div[@aria-label='User details updated.']")
	private WebElement successMessageUserDetailsUpdate;

	@FindBy(xpath = "//button[text()='Resend Invite']")
	private WebElement btnResendInvite;

	@FindBy(xpath = "//div[@aria-label='Resent invite sent.']")
	private WebElement successMessageResendInvite;

	@FindBy(xpath = "//mat-select[@aria-label='Items per page:']")
	private WebElement ddItemsperPage;

	@FindBy(xpath = "//span[text()=' 10 ']")
	private WebElement ddTen;

	@FindBy(xpath = "//span[text()=' 25 ']")
	private WebElement ddTwentyFive;

	@FindBy(xpath = "//span[text()=' 50 ']")
	private WebElement ddFifty;

	@FindBy(xpath = "//span[text()=' 100 ']")
	private WebElement ddHundred;

	@FindBy(xpath = "//button[@aria-label='Next page']")
	private WebElement btnNextPage;

	@FindBy(xpath = "//button[@aria-label='Last page']")
	private WebElement btnLastPage;

	@FindBy(xpath = "//button[@aria-label='First page']")
	private WebElement btnFirstPage;

	@FindBy(xpath = "//button[@aria-label='Previous page']")
	private WebElement btnPreviousPage;
	
	@FindBy(xpath = "//div[normalize-space()='Email already exists.']")
	private WebElement alertMessageEmailAlreadyExists;

	public WebElement getTitleMemberUsers() {
		return titleMemberUsers;
	}

	public WebElement getBtnInviteUser() {
		return btnInviteUser;
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

	public WebElement getDdMemberNumber() {
		return ddMemberNumber;
	}

	public WebElement getDdUserRole() {
		return ddUserRole;
	}

	public WebElement getBtnInvite() {
		return btnInvite;
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

	public WebElement getErrormessageInvalidEmail() {
		return errormessageInvalidEmail;
	}

	public WebElement getErrorMessageMemberNumber() {
		return errorMessageMemberNumber;
	}

	public WebElement getErrorMessageUserRole() {
		return errorMessageUserRole;
	}

	public WebElement getSuccessMessageUserInvite() {
		return successMessageUserInvite;
	}

	public WebElement getTxtSearch() {
		return txtSearch;
	}

	public WebElement getiSearch() {
		return iSearch;
	}

	public WebElement getTdFirstcellFirstNamedata() {
		return tdFirstcellFirstNamedata;
	}

	public WebElement getTdFirstcellLastNamedata() {
		return tdFirstcellLastNamedata;
	}

	public WebElement getToggleStatus() {
		return toggleStatus;
	}

	public WebElement getDdUserRoleMemberUserEdit() {
		return ddUserRoleMemberUserEdit;
	}

	public WebElement getBtnSave() {
		return btnSave;
	}

	public WebElement getDeleteMemberAccounts() {
		return deleteMemberAccounts;
	}

	public WebElement getSuccessMessageUserDetailsUpdate() {
		return successMessageUserDetailsUpdate;
	}

	public WebElement getBtnResendInvite() {
		return btnResendInvite;
	}

	public WebElement getSuccessMessageResendInvite() {
		return successMessageResendInvite;
	}

	public WebElement getDdItemsperPage() {
		return ddItemsperPage;
	}

	public WebElement getDdTen() {
		return ddTen;
	}

	public WebElement getDdTwentyFive() {
		return ddTwentyFive;
	}

	public WebElement getDdFifty() {
		return ddFifty;
	}

	public WebElement getDdHundred() {
		return ddHundred;
	}

	public WebElement getBtnNextPage() {
		return btnNextPage;
	}

	public WebElement getBtnLastPage() {
		return btnLastPage;
	}

	public WebElement getBtnFirstPage() {
		return btnFirstPage;
	}

	public WebElement getBtnPreviousPage() {
		return btnPreviousPage;
	}

	public WebElement getAlertMessageEmailAlreadyExists() {
		return alertMessageEmailAlreadyExists;
	}

	public void selectOptioninDropDown(WebDriver driver, WebElement dropdownElement, String optionText) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(dropdownElement));
		click(dropdownElement);
		WebElement option = wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//mat-option//span[normalize-space()='" + optionText + "']")));
		clickElementUsingJavaScript(driver, option);
	}

	public void inviteUsers(String firstName, String lastName, String email, String memberNumbers, String userRoles) {
		click(getBtnInviteUser());
		insertValue(getTxtFirstName(), firstName);
		insertValue(getTxtLastName(), lastName);
		insertValue(getTxtEmail(), email);
		String[] memberList = memberNumbers.split(",");
		for (String member : memberList) {
			selectOptioninDropDown(driver, getDdMemberNumber(), member.trim());
		}
		selectByVisibleText(getDdUserRole(), userRoles);
		click(getBtnInvite());
	}

	public void emptyFieldsInviteUsers() {
		click(getBtnInviteUser());
		elementVisibility(getBtnInvite());
		click(getBtnInvite());
	}

	public void emailFieldValidation() {
		insertValue(getTxtEmail(), "MutualDrug.com");
		click(getBtnInvite());
	}

	public void alreadyInviteUser() {
		insertValue(getTxtFirstName(), "Pat");
		insertValue(getTxtLastName(), "Cummins");
		insertValue(getTxtEmail(), "loga.nagaraj@datacaliper.com");
		selectOptioninDropDown(driver, getDdMemberNumber(), "124040-A1 PHARMACY & SURGICAL G/COMBO (MEMBER)");
		selectByVisibleText(getDdUserRole(), "Member Admin");
		click(getBtnInvite());
	}

	public void searchUsers(String searchTerm) {
		refreshNavigation();
		elementVisibility(getTxtSearch());
		insertValue(getTxtSearch(), searchTerm);
		click(getiSearch());

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		String fn, ln, em;
		try {
			fn = wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("(//td[contains(@class,'mat-column-firstName')]//a)[1]")))
					.getText().trim();
			ln = wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("(//td[contains(@class,'mat-column-lastName')]//a)[1]")))
					.getText().trim();
			em = wait
					.until(ExpectedConditions
							.visibilityOfElementLocated(By.xpath("(//td[contains(@class,'mat-column-email')])[1]")))
					.getText().trim();
		} catch (TimeoutException e) {
			Assert.fail("No search results displayed for term: " + searchTerm);
			return;
		}

		boolean anyMatch = searchTerm.equals(fn) || searchTerm.equals(ln) || searchTerm.equals(em);
		Assert.assertTrue(String.format("'%s' did not match firstName('%s'), lastName('%s'), or email('%s')",
				searchTerm, fn, ln, em), anyMatch);
	}

	public void sortingFunction() throws InterruptedException {
		String[] columnNames = { "First Name", "Last Name", "Email", "Roles", "Members", "Joined Date" };

		for (int i = 0; i < columnNames.length; i++) {
			if ("Roles".equals(columnNames[i]) || "Members".equals(columnNames[i])) {
				System.out.println("Skipping column: " + columnNames[i]);
				continue;
			}
			WebElement columnHeader = driver.findElement(By.xpath("(//th[@role='columnheader'])[" + (i + 1) + "]"));
			clickElementUsingJavaScript(driver, columnHeader);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			String ariaSort = columnHeader.getAttribute("aria-sort");
			System.out.println("Initial Sorting Order for '" + columnNames[i] + "': " + ariaSort);
			if ("ascending".equals(ariaSort)) {
				System.out.println("Column '" + columnNames[i] + "' is initially sorted in ascending order.");
				clickElementUsingJavaScript(driver, columnHeader);
				Thread.sleep(500);
				ariaSort = columnHeader.getAttribute("aria-sort");
				System.out.println("Sorting Order After Click for '" + columnNames[i] + "': " + ariaSort);

				if ("descending".equals(ariaSort)) {
					System.out.println("Column '" + columnNames[i] + "' is now sorted in descending order.");
				} else {
					System.out.println("Column '" + columnNames[i] + "' is NOT sorted in descending order.");
				}
			} else if ("descending".equals(ariaSort)) {
				System.out.println("Column '" + columnNames[i] + "' is initially sorted in descending order.");
				clickElementUsingJavaScript(driver, columnHeader);
				Thread.sleep(500);
				ariaSort = columnHeader.getAttribute("aria-sort");
				System.out.println("Sorting Order After Click for '" + columnNames[i] + "': " + ariaSort);
				if ("ascending".equals(ariaSort)) {
					System.out.println("Column '" + columnNames[i] + "' is now sorted in ascending order.");
				} else {
					System.out.println("Column '" + columnNames[i] + "' is NOT sorted in ascending order.");
				}
			} else {
				System.out.println("Sorting order could not be determined for column '" + columnNames[i] + "'.");
			}
		}
	}

	public void updateMembersUser(String FirstName, String LastName, String MemberNumbers, String UsersRole) {
		click(getTdFirstcellFirstNamedata());
		insertValue(getTxtFirstName(), FirstName);
		insertValue(getTxtLastName(), LastName);
		String[] memberList = MemberNumbers.split(",");
		for (String member : memberList) {
			selectOptioninDropDown(driver, getDdMemberNumber(), member.trim());
		}
		selectByVisibleText(getDdUserRole(), UsersRole);
		click(getBtnSave());
	}

	public void resendInvite() {
		scrollToElement(getDdItemsperPage());
		clickElementUsingJavaScript(driver, getDdItemsperPage());
		clickElementUsingJavaScript(driver, getDdHundred());
		clickElementUsingJavaScript(driver, getBtnResendInvite());

	}
	public void firstNameLink() {
		clickElementUsingJavaScript(driver, getTdFirstcellFirstNamedata());
		elementVisibility(getBtnSave());
		click(getBtnSave());

	}
	public void lastNameLink() {
		clickElementUsingJavaScript(driver, getTdFirstcellLastNamedata());
		elementVisibility(getBtnSave());
		click(getBtnSave());

	}

}
