package com.pages;

import java.lang.reflect.Constructor;
import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.base.BaseClass;

import io.cucumber.java.sl.Privzeto;

/**
 * @see Used to find the locators assign the values in Notifications webpage
 * @Date 18-Feb-2025
 */
public class NotificationPage extends BaseClass {
	/**
	 * @see Constructor Used to initialize the values
	 */

	public NotificationPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//h2[text()='Notifications']")
	private WebElement textNotifications;

	@FindBy(xpath = "//input[@placeholder='Search']")
	private WebElement txtSearchNotificationGroup;

	@FindBy(xpath = "(//i[@class='fa fa-search'])[2]")
	private WebElement iSearchNotificationGroup;

	@FindBy(xpath = "//button[text()=' Create Notification Group']")
	private WebElement btnCreateNotificationGroup;

	@FindBy(xpath = "//input[@name='notificationGroupName']")
	private WebElement txtGroupName;

	@FindBy(xpath = "//button[text()='Create']")
	private WebElement btnCreate;

	@FindBy(xpath = "//div[@aria-label='Notification Group Deleted Successfully']")
	private WebElement alertMsgDeleteNotificationGroup;

	@FindBy(xpath = "(//span[@class='val'])[1]")
	private WebElement tdFirstCell;

	@FindBy(xpath = "//*[text()='Order Type']")
	private WebElement txtOrderType;

	@FindBy(xpath = "(//th[@role='columnheader'])[1]")
	private WebElement sortGroupName;

	@FindBy(xpath = "(//th[@role='columnheader'])[2]")
	private WebElement sortGroupType;

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

	@FindBy(xpath = "//input[@name='searchProduct']")
	private WebElement txtGlobalSearch;

	@FindBy(xpath = "//i[@class='fa fa-search']")
	private WebElement iSearch;

	@FindBy(xpath = "(//a[@href='/member/notification-groups'])[1]")
	private WebElement bcNotificationGroupsLink;

	@FindBy(xpath = "//div[@aria-label='Notification Group Created.']")
	private WebElement alertNotificationGroupCreatedMessage;

	@FindBy(xpath = "//div[text()='Group Name is required']")
	private WebElement errorMessageGroupName;

	@FindBy(xpath = "//div[text()='Special characters not allowed']")
	private WebElement errorMessageGroupNameSpecialChar;

	@FindBy(xpath = "//div[text()='Group is required']")
	private WebElement errorMessageGroupType;

	@FindBy(xpath = "//input[@name='groupName']")
	private WebElement txtNotificationGruupName;

	@FindBy(xpath = "(//input[@name='emailId'])[1]")
	private WebElement txtEmail;

	@FindBy(xpath = "(//input[@name='phoneNumber'])[1]")
	private WebElement txtPhoneNumber;

	@FindBy(xpath = "//button[text()='Update All']")
	private WebElement btnUpdateAll;

	@FindBy(xpath = "(//select[@formcontrolname='regularOrderArr'])[1]")
	private WebElement ddNotificationGroup;

	@FindBy(xpath = "(//input[@placeholder='Qty'])[1]")
	private WebElement txtQty;

	@FindBy(xpath = "((//input[@name='emailId'])[2]//parent::div)[1]")
	private WebElement txtEmailinGrid;

	@FindBy(xpath = "(//input[@name='phoneNumber'])[3]//following::div")
	private WebElement txtPhoneNuminGrid;

	@FindBy(xpath = "//button[text()='Update']")
	private WebElement btnUpdateinGrid;

	@FindBy(xpath = "(//i[@class='fa fa-trash'])[1]")
	private WebElement iTrashinGrid;

	@FindBy(xpath = "//button[text()='Yes']")
	private WebElement btnYes;

	@FindBy(xpath = "//div[@aria-label='Delete NotificationItem Successfully']")
	private WebElement alertMessageDeleteItem;

	@FindBy(xpath = "//div[@aria-label='Successfully updated email and phonenumber for overall items']")
	private WebElement alertMessageUpdateEmailPhNo;

	@FindBy(xpath = "//div[@aria-label='Notification Group name updated.']")
	private WebElement alertMsgUpdateGrpName;

	@FindBy(xpath = "//div[text()='Notification Group is required ']")
	private WebElement errorMessageDdNotificationGroup;

	@FindBy(xpath = "//div[text()='Email is required']")
	private WebElement errorMessageEmail;

	@FindBy(xpath = "//div[text()='Email must be a valid email address']")
	private WebElement errorMessageInvalidEmail;

	@FindBy(xpath = "//div[text()='Phone number must have at least 10 digits']")
	private WebElement errorMessageInvalidPhoneNo;

	public WebElement getTextNotifications() {
		return textNotifications;
	}

	public WebElement getTxtSearchNotificationGroup() {
		return txtSearchNotificationGroup;
	}

	public WebElement getiSearchNotificationGroup() {
		return iSearchNotificationGroup;
	}

	public WebElement getBtnCreateNotificationGroup() {
		return btnCreateNotificationGroup;
	}

	public WebElement getTxtGroupName() {
		return txtGroupName;
	}

	public WebElement getBtnCreate() {
		return btnCreate;
	}

	public WebElement getAlertMsgDeleteNotificationGroup() {
		return alertMsgDeleteNotificationGroup;
	}

	public WebElement getTdFirstCell() {
		return tdFirstCell;
	}

	public WebElement getTxtOrderType() {
		return txtOrderType;
	}

	public WebElement getSortGroupName() {
		return sortGroupName;
	}

	public WebElement getSortGroupType() {
		return sortGroupType;
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

	public WebElement getTxtGlobalSearch() {
		return txtGlobalSearch;
	}

	public WebElement getiSearch() {
		return iSearch;
	}

	public WebElement getBcNotificationGroupsLink() {
		return bcNotificationGroupsLink;
	}

	public WebElement getAlertNotificationGroupCreatedMessage() {
		return alertNotificationGroupCreatedMessage;
	}

	public WebElement getErrorMessageGroupName() {
		return errorMessageGroupName;
	}

	public WebElement getErrorMessageGroupNameSpecialChar() {
		return errorMessageGroupNameSpecialChar;
	}

	public WebElement getErrorMessageGroupType() {
		return errorMessageGroupType;
	}

	public WebElement getTxtNotificationGruupName() {
		return txtNotificationGruupName;
	}

	public WebElement getTxtEmail() {
		return txtEmail;
	}

	public WebElement getTxtPhoneNumber() {
		return txtPhoneNumber;
	}

	public WebElement getBtnUpdateAll() {
		return btnUpdateAll;
	}

	public WebElement getDdNotificationGroup() {
		return ddNotificationGroup;
	}

	public WebElement getTxtQty() {
		return txtQty;
	}

	public WebElement getTxtEmailinGrid() {
		return txtEmailinGrid;
	}

	public WebElement getTxtPhoneNuminGrid() {
		return txtPhoneNuminGrid;
	}

	public WebElement getBtnUpdateinGrid() {
		return btnUpdateinGrid;
	}

	public WebElement getiTrashinGrid() {
		return iTrashinGrid;
	}

	public WebElement getBtnYes() {
		return btnYes;
	}

	public WebElement getAlertMessageDeleteItem() {
		return alertMessageDeleteItem;
	}

	public WebElement getAlertMessageUpdateEmailPhNo() {
		return alertMessageUpdateEmailPhNo;
	}

	public WebElement getAlertMsgUpdateGrpName() {
		return alertMsgUpdateGrpName;
	}

	public WebElement getErrorMessageDdNotificationGroup() {
		return errorMessageDdNotificationGroup;
	}

	public WebElement getErrorMessageEmail() {
		return errorMessageEmail;
	}

	public WebElement getErrorMessageInvalidEmail() {
		return errorMessageInvalidEmail;
	}

	public WebElement getErrorMessageInvalidPhoneNo() {
		return errorMessageInvalidPhoneNo;
	}

	/**
	 * @see Used to Create New Notification Group
	 * @param groupName
	 * @param autoSubmit
	 * @param successMessage
	 */
	public void createNotificationGroup(String groupName, String autoSubmit, String successMessage) {
		clickElementUsingJavaScript(driver, getBtnCreateNotificationGroup());
		elementVisibility(getTxtGroupName());
		insertValue(getTxtGroupName(), groupName);
		clickRadioButton(autoSubmit);
		click(getBtnCreate());
		WebElement alertMessageElement = getAlertNotificationGroupCreatedMessage();
		Assert.assertEquals(alertMessageElement.getText(), successMessage);
	}

	/**
	 * @see Used to clicks Notification names in list
	 * @param groupName
	 */
	public void notificationlistNameClick(String groupName) {
		WebElement element = driver
				.findElement(By.xpath("//a[text()='" + groupName + "']//parent::span[@class='val']"));
		clickElementUsingJavaScript(driver, element);

	}

	/**
	 * @see Used to global search in notification group webpage
	 * @param globalSearch
	 */
	public void globalSearch(String globalSearch) {
		elementVisibility(getTxtGlobalSearch());
		insertValue(getTxtGlobalSearch(), globalSearch);
		clickElementUsingJavaScript(driver, getiSearch());
	}

	/**
	 * @see Used to validate empty fields Notification Group Creations
	 */
	public void emptyFieldsCreateNotificationGroupCreations() {
		clickElementUsingJavaScript(driver, getBtnCreateNotificationGroup());
		elementVisibility(getTxtGroupName());
		getTxtGroupName().sendKeys(Keys.chord(Keys.CONTROL, "a"));
		getTxtGroupName().sendKeys(Keys.BACK_SPACE);
		clearTextUsingjs(getTxtGroupName());
		click(getBtnCreate());

	}

	/**
	 * @see Used to notification Group Name With Special Character
	 * @param groupType
	 */
	public void notificationGroupNameWithSpecialChar(String groupType) {
		elementVisibility(getTxtGroupName());
		clearTextUsingjs(getTxtGroupName());
		insertValue(getTxtGroupName(), "Sample@#$$%");
		clickRadioButton(groupType);
		click(getBtnCreate());
	}

	/**
	 * @see Used to notification Group Name With Space
	 * @param groupType
	 */
	public void notificationGroupNameWithSpace(String groupType) {
		elementVisibility(getTxtGroupName());
		getTxtGroupName().sendKeys(Keys.chord(Keys.CONTROL, "a"));
		getTxtGroupName().sendKeys(Keys.BACK_SPACE);
		insertValue(getTxtGroupName(), " ");
		clickRadioButton(groupType);
		click(getBtnCreate());

	}

	public void searchNotificationGroup(String notificationGroupName) throws InterruptedException {
		try {
			insertValue(getTxtSearchNotificationGroup(), notificationGroupName);
			clickElementUsingJavaScript(driver, getiSearchNotificationGroup());
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			WebElement element = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath("//table[contains(@class, 'mat-table')]//tr[contains(@class, 'mat-row')]//td[contains(@class, 'mat-cell')]//a")));
			JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
			jsExecutor.executeScript("arguments[0].scrollIntoView(true);", element);	
			clickWithActions(element);

		} catch (StaleElementReferenceException e) {
			
		}
		Thread.sleep(3000);
	}

	public void deleteNotificationGroup() {
		scrollToElement(getiTrashinGrid());
		clickElementUsingJavaScript(driver, getiTrashinGrid());
		clickElementUsingJavaScript(driver, getBtnYes());

	}

	public void updatenotificationGroupName(String updateName) {
		elementVisibility(getTxtNotificationGruupName());
		clearTextUsingjs(getTxtNotificationGruupName());
		insertValue(getTxtNotificationGruupName(), updateName);
		clickElementUsingJavaScript(driver, getTxtOrderType());

	}

	public void updateEmailPh() {
		scrollToElement(getTxtEmail());
		insertValue(getTxtEmail(), "loga");
		clearTextUsingjs(getTxtPhoneNumber());
		clickElementUsingJavaScript(driver, getBtnUpdateAll());
	}

	public void deleteNotificationItem() {
		scrollToElement(getiSearchNotificationGroup());
		clickElementUsingJavaScript(driver, getiTrashinGrid());
		clickElementUsingJavaScript(driver, btnYes);
	}

	public void sorting() {
		String[] columnNames = { "Group Name", "Group Type" };

		for (int i = 0; i < columnNames.length; i++) {

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
				System.out.println("✅ Column '" + columnNames[i] + "' is initially sorted in ascending order.");

				clickElementUsingJavaScript(driver, columnHeader);
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

				ariaSort = columnHeader.getAttribute("aria-sort");
				System.out.println("Sorting Order After Click for '" + columnNames[i] + "': " + ariaSort);

				if ("descending".equals(ariaSort)) {
					System.out.println("✅ Column '" + columnNames[i] + "' is now sorted in descending order.");
				} else {
					System.out.println("❌ Column '" + columnNames[i] + "' is NOT sorted in descending order.");
				}
			} else if ("descending".equals(ariaSort)) {
				System.out.println("✅ Column '" + columnNames[i] + "' is initially sorted in descending order.");

				clickElementUsingJavaScript(driver, columnHeader);
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

				ariaSort = columnHeader.getAttribute("aria-sort");
				System.out.println("Sorting Order After Click for '" + columnNames[i] + "': " + ariaSort);

				// Verify it's in ascending order after second click
				if ("ascending".equals(ariaSort)) {
					System.out.println("✅ Column '" + columnNames[i] + "' is now sorted in ascending order.");
				} else {
					System.out.println("❌ Column '" + columnNames[i] + "' is NOT sorted in ascending order.");
				}
			} else {
				System.out.println("Sorting order could not be determined for column '" + columnNames[i] + "'.");
			}
		}
	}

	public void pagination() throws InterruptedException {
		scrollToElement(getDdItemsperPage());
		clickElementUsingJavaScript(driver, getDdItemsperPage());
		clickElementUsingJavaScript(driver, getDdTen());
		Thread.sleep(3000);
		scrollToElement(getBtnNextPage());
		if (isButtonEnabled(getBtnNextPage())) {
			clickElementUsingJavaScript(driver, getBtnNextPage());
		} else {
			System.out.println("Next Page button is disabled.");
		}
		if (isButtonEnabled(getBtnPreviousPage())) {
			clickElementUsingJavaScript(driver, getBtnPreviousPage());
		} else {
			System.out.println("Previous Page button is disabled.");
		}

		if (isButtonEnabled(getBtnLastPage())) {
			clickElementUsingJavaScript(driver, getBtnLastPage());
		} else {
			System.out.println("Last Page button is disabled.");
		}
		if (isButtonEnabled(getBtnFirstPage())) {
			clickElementUsingJavaScript(driver, getBtnFirstPage());
		} else {
			System.out.println("First Page button is disabled.");
		}

	}

	/**
	 * @see Used to verify button is enabled or not
	 * @param button
	 * @return
	 */
	private boolean isButtonEnabled(WebElement button) {
		try {
			return button.isEnabled();
		} catch (Exception e) {
			System.out.println("Button not found: " + e.getMessage());
			return false;
		}
	}

}
