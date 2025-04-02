package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;

public class OrdersPage extends BaseClass {

	public OrdersPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@name='orderName']")
	private WebElement txtOrderName;

	@FindBy(xpath = "//input[@name='autoSubmitDate']")
	private WebElement txtDate;

	@FindBy(xpath = "//mat-select[@name='autoSubmitTime']")
	private WebElement ddTime;

	@FindBy(xpath = "//input[@name='orderReference']")
	private WebElement txtOrderReferance;

	@FindBy(xpath = "//select[@class='form-control ng-pristine ng-valid ng-touched']")
	private WebElement ddSpecialCode;

	@FindBy(xpath = "//input[@name='itemSearch']")
	private WebElement txtItemSearch;

	@FindBy(xpath = "(//input[@max='999'])[1]")
	private WebElement txtQty;

	@FindBy(xpath = "//button[text()='Update']")
	private WebElement btnUpdate;

	@FindBy(xpath = "//i[@class='fa fa-trash']")
	private WebElement iTrash;

	@FindBy(xpath = "//button[@class='mat-tooltip-trigger add-btn ng-star-inserted']")
	private WebElement btnAdd;

	@FindBy(xpath = "(//input[@placeholder='Item #, Description, NDC, UPC, GTIN'])[2]")
	private WebElement txtAddProduct;

	@FindBy(xpath = "(//button[@class='search'])[2]")
	private WebElement iSearchAddProduct;

	@FindBy(xpath = "(//th[@role='columnheader'])[1]")
	private WebElement sortingItems;

	@FindBy(xpath = "(//th[@role='columnheader'])[2]")
	private WebElement sortingProductsDiscriptions;

	@FindBy(xpath = "(//input[@class='form-control order-qty ng-untouched ng-pristine ng-valid'])[1]")
	private WebElement txtQtyinGrid;

	@FindBy(xpath = "(//select[@class='form-control special ng-untouched ng-pristine ng-valid'])[1]")
	private WebElement ddSpecialCodeinGrid;

	@FindBy(xpath = "(//i[@class='fa fa-trash ng-star-inserted'])[1]")
	private WebElement iTrashinGrid;

	@FindBy(xpath = "//div[@aria-label='Item is not found or unavailable for purchase.']")
	private WebElement errorMessageItemNotFound;

	@FindBy(xpath = "//div[@aria-label='Cannot add C2 item to non C2 order.']")
	private WebElement alertMessageC2Item;

	@FindBy(xpath = "//span[@class='text-muted']")
	private WebElement errorMessageNoMatchProductFound;

	@FindBy(xpath = "//button[text()='Delete Selected']")
	private WebElement btnDeleteSelected;

	@FindBy(xpath = "//div[@aria-label='Please select one or more item(s).']")
	private WebElement warningMessagePleaseSelectOne;

	@FindBy(xpath = "//div[contains(@aria-label, 'updated from order')]")
	private WebElement successMessgeUpdateItem;

	@FindBy(xpath = "//div[contains(@aria-label, 'deleted from order')]")
	private WebElement successMessageDelete;

	@FindBy(xpath = "//div[contains(@aria-label, 'added to order')]")
	private WebElement successMessageItemAddedtoOrder;

	@FindBy(xpath = "//button[text()='Sign & Submit']")
	private WebElement btnSignSubmit;

	@FindBy(xpath = "//button[text()='Print Order']")
	private WebElement btnPrintOrder;

	@FindBy(xpath = "//input[@id='store_password']")
	private WebElement txtStorePassword;

	@FindBy(xpath = "//span[text()='Sign']")
	private WebElement btnSign;

	@FindBy(xpath = "//span[text()='Cancel']")
	private WebElement btnCancel;

	@FindBy(xpath = "//*[text()=' Thank you, your CSOS order (02/13/2025 Order auto 1) was successfully signed and transmitted.']")
	private WebElement alertC2OrderSuccessMessage;

	@FindBy(xpath = "//div[@aria-label='Success!']")
	private WebElement alertSuccessMessageOrderCreation;

	@FindBy(xpath = "//div[text()='Order Name is required']")
	private WebElement errorMessageOrderName;

	@FindBy(xpath = "//div[text()='Order Type is required']")
	private WebElement errorMessageOrderType;

	@FindBy(xpath = "//div[text()='Template is required ']")
	private WebElement errorMessageTemplate;

	@FindBy(xpath = "//button[text()='Save as Template']")
	private WebElement btnSaveASTemplate;

	@FindBy(xpath = "//div[@aria-label='Order template saved.']")
	private WebElement alertMessageTemplateSaved;

	@FindBy(xpath = "//div[text()='Special characters not allowed']")
	private WebElement errorMessageOrdernameSpeclChar;

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

	@FindBy(xpath = "(//button[@type='submit'])[2]")
	private WebElement btnAddToOrder;

	@FindBy(xpath = "//button[normalize-space()='Submit']")
	private WebElement btnSubmit;

	@FindBy(xpath = "//button[@class='navigate-btn']")
	private WebElement btnOkAlertmessage;

	@FindBy(xpath = "//div[@aria-label='Order name updated.']")
	private WebElement alertSuccessMessageOrderNameUpdate;

	@FindBy(xpath = "//div[@aria-label='Success!']")
	private WebElement alertSuccessMessage;

	@FindBy(xpath = "//div[@aria-label='Item code is required.']")
	private WebElement warningMessageItemCode;

	@FindBy(xpath = "//div[@aria-label='Item already added to order.']")
	private WebElement warningMessageItemAlreadyAdded;

	@FindBy(xpath = "//div[@aria-label='Min allowed order qty is 1.']")
	private WebElement warningMessageMinQty;

	public WebElement getTxtOrderName() {
		return txtOrderName;
	}

	public WebElement getTxtDate() {
		return txtDate;
	}

	public WebElement getDdTime() {
		return ddTime;
	}

	public WebElement getTxtOrderReferance() {
		return txtOrderReferance;
	}

	public WebElement getDdSpecialCode() {
		return ddSpecialCode;
	}

	public WebElement getTxtItemSearch() {
		return txtItemSearch;
	}

	public WebElement getTxtQty() {
		return txtQty;
	}

	public WebElement getBtnUpdate() {
		return btnUpdate;
	}

	public WebElement getiTrash() {
		return iTrash;
	}

	public WebElement getBtnAdd() {
		return btnAdd;
	}

	public WebElement getTxtAddProduct() {
		return txtAddProduct;
	}

	public WebElement getiSearchAddProduct() {
		return iSearchAddProduct;
	}

	public WebElement getSortingItems() {
		return sortingItems;
	}

	public WebElement getSortingProductsDiscriptions() {
		return sortingProductsDiscriptions;
	}

	public WebElement getTxtQtyinGrid() {
		return txtQtyinGrid;
	}

	public WebElement getDdSpecialCodeinGrid() {
		return ddSpecialCodeinGrid;
	}

	public WebElement getiTrashinGrid() {
		return iTrashinGrid;
	}

	public WebElement getErrorMessageItemNotFound() {
		return errorMessageItemNotFound;
	}

	public WebElement getAlertMessageC2Item() {
		return alertMessageC2Item;
	}

	public WebElement getErrorMessageNoMatchProductFound() {
		return errorMessageNoMatchProductFound;
	}

	public WebElement getBtnDeleteSelected() {
		return btnDeleteSelected;
	}

	public WebElement getWarningMessagePleaseSelectOne() {
		return warningMessagePleaseSelectOne;
	}

	public WebElement getSuccessMessgeUpdateItem() {
		return successMessgeUpdateItem;
	}

	public WebElement getSuccessMessageDelete() {
		return successMessageDelete;
	}

	public WebElement getSuccessMessageItemAddedtoOrder() {
		return successMessageItemAddedtoOrder;
	}

	public WebElement getBtnSignSubmit() {
		return btnSignSubmit;
	}

	public WebElement getBtnPrintOrder() {
		return btnPrintOrder;
	}

	public WebElement getTxtStorePassword() {
		return txtStorePassword;
	}

	public WebElement getBtnSign() {
		return btnSign;
	}

	public WebElement getBtnCancel() {
		return btnCancel;
	}

	public WebElement getAlertC2OrderSuccessMessage() {
		return alertC2OrderSuccessMessage;
	}

	public WebElement getAlertSuccessMessageOrderCreation() {
		return alertSuccessMessageOrderCreation;
	}

	public WebElement getErrorMessageOrderName() {
		return errorMessageOrderName;
	}

	public WebElement getErrorMessageOrderType() {
		return errorMessageOrderType;
	}

	public WebElement getErrorMessageTemplate() {
		return errorMessageTemplate;
	}

	public WebElement getBtnSaveASTemplate() {
		return btnSaveASTemplate;
	}

	public WebElement getAlertMessageTemplateSaved() {
		return alertMessageTemplateSaved;
	}

	public WebElement getErrorMessageOrdernameSpeclChar() {
		return errorMessageOrdernameSpeclChar;
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

	public WebElement getBtnAddToOrder() {
		return btnAddToOrder;
	}

	public WebElement getBtnSubmit() {
		return btnSubmit;
	}

	public WebElement getBtnOkAlertmessage() {
		return btnOkAlertmessage;
	}

	public WebElement getAlertSuccessMessageOrderNameUpdate() {
		return alertSuccessMessageOrderNameUpdate;
	}

	public WebElement getAlertSuccessMessage() {
		return alertSuccessMessage;
	}

	public WebElement getWarningMessageItemCode() {
		return warningMessageItemCode;
	}

	public WebElement getWarningMessageItemAlreadyAdded() {
		return warningMessageItemAlreadyAdded;
	}

	public WebElement getWarningMessageMinQty() {
		return warningMessageMinQty;
	}

	/**
	 * @see Used to update Order Name
	 * @param updatedOrderName
	 */
	public void orderNameUpdate(String updatedOrderName) {
		elementVisibility(txtOrderName);
		clearTextUsingjs(txtOrderName);
		getTxtOrderName().sendKeys(Keys.chord(Keys.CONTROL, "a"));
		getTxtOrderName().sendKeys(Keys.BACK_SPACE);
		insertValue(getTxtOrderName(), updatedOrderName);
		clickElementUsingJavaScript(driver, getTxtQty());
	}

	/**
	 * @see Update item qty in grid
	 */

	public void updateQty() {
		elementVisibility(txtQtyinGrid);
		clearTextUsingjs(getTxtQtyinGrid());
		insertValue(txtQtyinGrid, "2");
	}

	/**
	 * @see Used to update special code in Grid
	 */
	public void updateSpecialCode() {
		if (getDdSpecialCodeinGrid().isDisplayed()) {
			selectByVisibleText(getDdSpecialCodeinGrid(), "Do Not Substitute");
		}
	}

	/**
	 * @see Used to delete item in Grid
	 */
	public void deleteItemsInGrid() {
		elementVisibility(getiTrashinGrid());
		elementToBeClickable(getiTrashinGrid());
		clickElementUsingJavaScript(driver, getiTrashinGrid());

	}

	public void itemsSorting() {
		clickElementUsingJavaScript(driver, getSortingItems());
		WebElement sortedColumn = driver.findElement(By.xpath("(//th[@role='columnheader'])[1]"));
		String ariaSort = sortedColumn.getAttribute("aria-sort");
		System.out.println("Initial Sorting Order: " + ariaSort);

		clickElementUsingJavaScript(driver, sortedColumn);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		ariaSort = sortedColumn.getAttribute("aria-sort");
		System.out.println("Sorting Order After Click: " + ariaSort);

		String expectedSort = "ascending".equals(ariaSort) ? "descending" : "ascending";
		System.out.println("The column is now sorted in " + ariaSort + " order.");
	}

	/**
	 * @see Used to perform Ascending and Descending order in Item#
	 */
	public void itemsNumberSorting() {
		clickElementUsingJavaScript(driver, getSortingItems());
		WebElement sortedColumn = driver.findElement(By.xpath("(//th[@role='columnheader'])[1]"));
		String ariaSort = sortedColumn.getAttribute("aria-sort");
		System.out.println("Initial Sorting Order: " + ariaSort);

		if ("ascending".equals(ariaSort)) {
			clickElementUsingJavaScript(driver, sortedColumn);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			ariaSort = sortedColumn.getAttribute("aria-sort");
			System.out.println("Sorting Order After Click: " + ariaSort);

			if ("descending".equals(ariaSort)) {
				System.out.println("The column is now sorted in descending order.");
			} else {
				System.out.println("The column is not sorted in descending order after clicking.");
			}

		} else if ("descending".equals(ariaSort)) {

			System.out.println(" The column is initially sorted in descending order.");
			clickElementUsingJavaScript(driver, sortedColumn);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			ariaSort = sortedColumn.getAttribute("aria-sort");
			System.out.println("Sorting Order After Click: " + ariaSort);

			if ("ascending".equals(ariaSort)) {
				System.out.println("The column is now sorted in ascending order.");
			} else {
				System.out.println("The column is not sorted in ascending order after clicking.");
			}

		} else {
			System.out.println("`The column sorting order is neither ascending nor descending.");
		}

	}

	/**
	 * @see Used to perform Ascending and Descending order in Product Discriptions
	 */
	public void productDiscriptionsSorting() {
		clickElementUsingJavaScript(driver, getSortingProductsDiscriptions());
		WebElement sortedColumn = driver.findElement(By.xpath("(//th[@role='columnheader'])[2]"));
		String ariaSort = sortedColumn.getAttribute("aria-sort");
		System.out.println("Initial Sorting Order: " + ariaSort);

		if ("ascending".equals(ariaSort)) {
			clickElementUsingJavaScript(driver, sortedColumn);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			ariaSort = sortedColumn.getAttribute("aria-sort");
			System.out.println("Sorting Order After Click: " + ariaSort);

			if ("descending".equals(ariaSort)) {
				System.out.println("The column is now sorted in descending order.");
			} else {
				System.out.println("The column is not sorted in descending order after clicking.");
			}

		} else if ("descending".equals(ariaSort)) {

			System.out.println(" The column is initially sorted in descending order.");
			clickElementUsingJavaScript(driver, sortedColumn);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			ariaSort = sortedColumn.getAttribute("aria-sort");
			System.out.println("Sorting Order After Click: " + ariaSort);

			if ("ascending".equals(ariaSort)) {
				System.out.println("The column is now sorted in ascending order.");
			} else {
				System.out.println("The column is not sorted in ascending order after clicking.");
			}

		} else {
			System.out.println("`The column sorting order is neither ascending nor descending.");
		}
	}

	/**
	 * @see Used to Perform Pagination
	 * @throws InterruptedException
	 */
	public void pageNavigations() throws InterruptedException {
		Thread.sleep(3000);
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

	public void clicksAdd() {
		clickElementUsingJavaScript(driver, getBtnAdd());
	}

	public void addZeroQuantity(String itemNum, String orderQty) throws InterruptedException {
		elementVisibility(getTxtItemSearch());
		setTextUsingJS(getTxtItemSearch(), itemNum);
		getTxtItemSearch().sendKeys(Keys.ENTER);
		elementVisibility(getTxtQty());
		getTxtQty().sendKeys(Keys.chord(Keys.CONTROL, "a"));
		getTxtQty().sendKeys(Keys.BACK_SPACE);
		String qty = "00";
		insertValue(getTxtQty(), qty);
		System.out.println("Updated Qty: " + getTxtQty().getAttribute("value"));
		Thread.sleep(2000);
		clickElementUsingJavaScript(driver, getBtnAdd());
	}

	public void RestrictionOrder(String itemNum) throws InterruptedException {
		Thread.sleep(2500);
		elementVisibility(getTxtItemSearch());
		clearTextUsingjs(getTxtItemSearch());
		insertValue(getTxtItemSearch(), itemNum);
		clickElementUsingJavaScript(driver, getTxtItemSearch());
//		getTxtItemSearch().sendKeys(Keys.ENTER);
		getTxtQty().sendKeys(Keys.chord(Keys.CONTROL, "a"));
		getTxtQty().sendKeys(Keys.BACK_SPACE);
		String qty = "1";
		elementVisibility(getTxtQty());
		insertValue(getTxtQty(), qty);
		Thread.sleep(2000);
		clickElementUsingJavaScript(driver, getBtnAdd());

	}

	public void verifyUpdateWithZeroQuantityInGrid(String orderQty) {
		elementVisibility(getTxtQtyinGrid());
		clearTextUsingjs(getTxtQtyinGrid());
		getTxtQtyinGrid().sendKeys(Keys.chord(Keys.CONTROL, "a"));
		getTxtQtyinGrid().sendKeys(Keys.BACK_SPACE);
		String qty = "000";
		insertValue(getTxtQtyinGrid(), qty);
		selectByVisibleText(getDdSpecialCodeinGrid(), "Shelf Label Only");
	}

}
