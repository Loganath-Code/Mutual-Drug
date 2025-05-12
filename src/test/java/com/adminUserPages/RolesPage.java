package com.adminUserPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;

public class RolesPage extends BaseClass {

	public RolesPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//h2[text()='Member User Roles']")
	private WebElement titleMemberUserRoles;

	@FindBy(xpath = "//button[text()=' Add New']")
	private WebElement btnAddNew;

	@FindBy(xpath = "//input[@placeholder='Role Name']")
	private WebElement txtRoleName;

	@FindBy(xpath = "//label[normalize-space()='Member Profile Full Access']//span[@class='checkmark']")
	private WebElement cbxMemberProfileFullAccess;

	@FindBy(xpath = "//label[normalize-space()='Member Profile Limited Access']//span[@class='checkmark']")
	private WebElement cbxMemberProfileLimitedAccess;

	@FindBy(xpath = "//label[normalize-space()='Products']//span[@class='checkmark']")
	private WebElement cbxProducts;

	@FindBy(xpath = "//label[normalize-space()='Returns']//span[@class='checkmark']")
	private WebElement cbxReturns;

	@FindBy(xpath = "//label[normalize-space()='Regular Orders']//span[@class='checkmark']")
	private WebElement cbxRegularOrders;

	@FindBy(xpath = "//label[normalize-space()='C2 Orders']//span[@class='checkmark']")
	private WebElement cbxC2Orders;

	@FindBy(xpath = "//label[normalize-space()='Monthly Statements']//span[@class='checkmark']")
	private WebElement cbxMonthlyStatements;

	@FindBy(xpath = "//label[normalize-space()='Monthly Reports']//span[@class='checkmark']")
	private WebElement cbxMonthlyReports;

	@FindBy(xpath = "//label[normalize-space()='Invoices']//span[@class='checkmark']")
	private WebElement cbxInvoices;

	@FindBy(xpath = "//label[normalize-space()='ASN History Details']//span[@class='checkmark']")
	private WebElement cbxASNHistoryDetails;

	@FindBy(xpath = "//label[normalize-space()='Patronage Rebate']//span[@class='checkmark']")
	private WebElement cbxPatronageRebate;

	@FindBy(xpath = "//label[normalize-space()='Annual Rebate']//span[@class='checkmark']")
	private WebElement cbxAnnualRebate;

	@FindBy(xpath = "//label[normalize-space()='Inventory']//span[@class='checkmark']")
	private WebElement cbxInventory;

	@FindBy(xpath = "//button[text()='Save']")
	private WebElement btnSave;

	@FindBy(xpath = "//input[@placeholder='Search for Member User Roles']")
	private WebElement txtSearchmemberUserRoles;

	@FindBy(xpath = "//button[@class='search']")
	private WebElement iSearch;

	@FindBy(xpath = "//td[@role='gridcell']//a[normalize-space()='Auto Testing']")
	private WebElement tdNamelink;

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

	@FindBy(xpath = "//div[text()=' Role Name is required']")
	private WebElement errorMessageRoleName;
	
	@FindBy(xpath = "//span[text()='Permissions are required!!']")
	private WebElement errorMessagePermissions;

	public WebElement getTitleMemberUserRoles() {
		return titleMemberUserRoles;
	}

	public WebElement getBtnAddNew() {
		return btnAddNew;
	}

	public WebElement getTxtRoleName() {
		return txtRoleName;
	}

	public WebElement getCbxMemberProfileFullAccess() {
		return cbxMemberProfileFullAccess;
	}

	public WebElement getCbxMemberProfileLimitedAccess() {
		return cbxMemberProfileLimitedAccess;
	}

	public WebElement getCbxProducts() {
		return cbxProducts;
	}

	public WebElement getCbxReturns() {
		return cbxReturns;
	}

	public WebElement getCbxRegularOrders() {
		return cbxRegularOrders;
	}

	public WebElement getCbxC2Orders() {
		return cbxC2Orders;
	}

	public WebElement getCbxMonthlyStatements() {
		return cbxMonthlyStatements;
	}

	public WebElement getCbxMonthlyReports() {
		return cbxMonthlyReports;
	}

	public WebElement getCbxInvoices() {
		return cbxInvoices;
	}

	public WebElement getCbxASNHistoryDetails() {
		return cbxASNHistoryDetails;
	}

	public WebElement getCbxPatronageRebate() {
		return cbxPatronageRebate;
	}

	public WebElement getCbxAnnualRebate() {
		return cbxAnnualRebate;
	}

	public WebElement getCbxInventory() {
		return cbxInventory;
	}

	public WebElement getBtnSave() {
		return btnSave;
	}

	public WebElement getTxtSearchmemberUserRoles() {
		return txtSearchmemberUserRoles;
	}

	public WebElement getiSearch() {
		return iSearch;
	}

	public WebElement getTdNamelink() {
		return tdNamelink;
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

	public WebElement getErrorMessageRoleName() {
		return errorMessageRoleName;
	}

	public WebElement getErrorMessagePermissions() {
		return errorMessagePermissions;
	}

	public void addNewRoles(String roleName) {
		elementVisibility(getBtnAddNew());
		click(getBtnAddNew());
		insertValue(getTxtRoleName(), roleName);
		clickElementUsingJavaScript(driver, getCbxMemberProfileFullAccess());
		clickElementUsingJavaScript(driver, getCbxProducts());
		clickElementUsingJavaScript(driver, getCbxReturns());
		clickElementUsingJavaScript(driver, getCbxRegularOrders());
		clickElementUsingJavaScript(driver, getCbxC2Orders());
		clickElementUsingJavaScript(driver, getCbxMonthlyStatements());
		clickElementUsingJavaScript(driver, getCbxMonthlyReports());
		clickElementUsingJavaScript(driver, getCbxInvoices());
		clickElementUsingJavaScript(driver, getCbxASNHistoryDetails());
		clickElementUsingJavaScript(driver, getCbxPatronageRebate());
		clickElementUsingJavaScript(driver, getCbxAnnualRebate());
		clickElementUsingJavaScript(driver, getCbxInventory());
		clickElementUsingJavaScript(driver, getBtnSave());
	}

	public void searchMemberUserRoles(String searchMemberUserRoles) {
		elementVisibility(getTxtSearchmemberUserRoles());
		insertValue(getTxtSearchmemberUserRoles(), searchMemberUserRoles);
		clickElementUsingJavaScript(driver, getiSearch());

	}

	public void updateRoles(String roleName) {
		elementToBeClickable(getTdNamelink());
		clickElementUsingJavaScript(driver, getTdNamelink());
		insertValue(getTxtRoleName(), roleName);
		clickElementUsingJavaScript(driver, getTdNamelink());
		clickWithWait(getCbxMonthlyStatements());
		clickWithWait(getCbxMonthlyReports());
		clickWithWait(getCbxInvoices());
		clickWithWait(getCbxASNHistoryDetails());
		clickWithWait(getCbxPatronageRebate());
		clickWithWait(getCbxAnnualRebate());
		clickWithWait(getCbxInventory());
		clickElementUsingJavaScript(driver, getBtnSave());
	}

	public void sortingFunction() throws InterruptedException {
		String[] columnNames = { "Name", "Permissions", "Created Date" };
		for (int i = 0; i < columnNames.length; i++) {
			if ("Permissions".equals(columnNames[i])) {
				System.out.println("Skipping sorting check for column: " + columnNames[i]);
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

	public void validateAddNewRoles() {
		click(getBtnAddNew());
		elementVisibility(getBtnSave());
		click(getBtnSave());

	}
	public void validateWithoutSelectRole() {
		click(getBtnAddNew());
		elementVisibility(getTxtRoleName());
		insertValue(getTxtRoleName(), "Pat");
		click(getBtnSave());
	}
}
