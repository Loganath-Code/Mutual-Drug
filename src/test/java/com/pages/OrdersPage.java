package com.pages;

import java.time.Duration;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.base.BaseClass;

public class OrdersPage extends BaseClass {

	public OrdersPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "(//a[@href='/member/orders/current-orders'])[3]")
	private WebElement bclnkCurrentOrderPage;
	
	@FindBy(xpath = "//input[@name='orderName']")
	private WebElement txtOrderName;

	@FindBy(xpath = "//input[@name='autoSubmitDate']")
	private WebElement txtDate;

	@FindBy(xpath = "//mat-select[@name='autoSubmitTime']")
	private WebElement ddTime;

	@FindBy(xpath = "//button[text()='Auto Submit']")
	private WebElement btnAutoSubmit;

	@FindBy(xpath = "//button[text()='Cancel Auto Submit']")
	private WebElement btnCancelAutoSubmit;

	@FindBy(xpath = "//div[@aria-label='Order auto submit canceled.']")
	private WebElement successMessageCancelAutoSubmit;

	@FindBy(xpath = "//a[@class='history-icon ng-star-inserted']")
	private WebElement lnkAutoSubmitHistory;

	@FindBy(xpath = "//h4[text()='Auto Submit History']")
	private WebElement AutoSubmitHistory;

	@FindBy(xpath = "//div[@class='modal-content']")
	private WebElement autoSubmitHistoryDoc;

	@FindBy(xpath = "//i[@class='fa fa-times']")
	private WebElement iClose;

	@FindBy(xpath = "//input[@name='orderReference']")
	private WebElement txtOrderReferance;

	@FindBy(xpath = "//div[@aria-label='Order Reference updated.']")
	private WebElement successMessageOrderReference;

	@FindBy(xpath = "//div[@aria-label='Order auto submit scheduled.']")
	private WebElement successMessageAutoSubmit;

	@FindBy(xpath = "//select[contains(@class, 'form-control') and contains(@class, 'ng-valid')]")
	private WebElement ddSpecialCode;

	@FindBy(xpath = "//input[@name='itemSearch']")
	private WebElement txtItemSearch;

	@FindBy(xpath = "(//input[@max='999'])[1]")
	private WebElement txtQty;

	@FindBy(xpath = "(//button[text()='Update'])[1]")
	private WebElement btnUpdate;

	@FindBy(xpath = "//i[@class='fa fa-trash']")
	private WebElement iTrash;

	@FindBy(xpath = "//button[@class='mat-tooltip-trigger add-btn ng-star-inserted']")
	private WebElement btnAdd;

	@FindBy(xpath = "(//input[@placeholder='Item #, Description, NDC, UPC, GTIN'])[2]")
	private WebElement txtAddProduct;

	@FindBy(xpath = "(//button[@class='search'])[2]")
	private WebElement iSearchAddProduct;

	@FindBy(xpath = "//span[@class='checkmark']")
	private WebElement cbxInvalidItemFirst;

	@FindBy(xpath = "(//input[@type='checkbox'][@class='mat-checkbox-input cdk-visually-hidden'])[2]")
	private WebElement cbxTd;

	@FindBy(xpath = "(//th[@role='columnheader'])[1]")
	private WebElement sortingItems;

	@FindBy(xpath = "(//th[@role='columnheader'])[2]")
	private WebElement sortingProductsDiscriptions;

	@FindBy(xpath = "(//input[contains(@class, 'form-control') and contains(@class, 'order-qty')])[2]")
	private WebElement txtQtyinGrid;

	@FindBy(xpath = "(//select[contains(@class, 'form-control') and contains(@class, 'special')])[1]")
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

	@FindBy(xpath = "//div[@aria-label='Items deleted from order.']")
	private WebElement succesMessageItemDeleted;

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

	@FindBy(xpath = "//button[text()='Save as Template']")
	private WebElement btnSaveAsTemplate;

	@FindBy(xpath = "//div[@aria-label='Order template saved.']")
	private WebElement successMessageOrderTemplateSaved;

	@FindBy(xpath = "//input[@id='store_password']")
	private WebElement txtStorePassword;

	@FindBy(xpath = "//span[text()='Sign']")
	private WebElement btnSign;

	@FindBy(xpath = "//span[text()='Cancel']")
	private WebElement btnCancel;

	@FindBy(xpath = "(//input[@placeholder='Qty'])[1]")
	private WebElement txtAddQty;

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

	@FindBy(xpath = "//div[@aria-label='Cannot add non C2 item to C2 order.']")
	private WebElement alertMessageNonC2Items;

	@FindBy(xpath = "(//span[@class='val netweight'])[1]")
	private WebElement tdNetPrice;

	@FindBy(xpath = "(//button[text()='Add To Order'])[1]")
	private WebElement btnAddtoOrder;

	@FindBy(xpath = "(//input[@placeholder='Order Qty'])[1]")
	private WebElement txtOrderQty;

	@FindBy(xpath = "(//select[@formcontrolname='specialCode'])[1]")
	private WebElement ddUpdateSpecialCode;

	@FindBy(xpath = "//h4[text()='Item Already Exist']")
	private WebElement modaltitle;

	@FindBy(xpath = "//a[text()='Full View']")
	private WebElement viewlinkFullView;

	@FindBy(xpath = "//a[text()='Compact View']")
	private WebElement viewLinkCompactView;

	@FindBy(xpath = "//div[contains(@aria-label, 'Item #') and contains(@aria-label, 'already added to order')]")
	private WebElement warningMessageItemAlreadyAddedToOrder;

	@FindBy(xpath = "//div[text()='Order Reference must be less than 15 characters']")
	private WebElement errorMessageOrderReference;

	@FindBy(xpath = "//div[@aria-label='Please select one or more item(s).']")
	private WebElement errorMessageWithoutSelectItem;

	@FindBy(xpath = "//div[@aria-label=\"Text 'null' could not be parsed at index 0\"]")
	private WebElement warningMessageAutoSubmit;

	@FindBy(xpath = "//span[text()='No matching product(s) found.']")
	private WebElement errorMessageNOMatchingProducts;

	@FindBy(xpath = "//div[@aria-label='Item is not found or unavailable for purchase.']")
	private WebElement warningMessageUnavailable;

	@FindBy(xpath = "//div[@aria-label='C2 products cannot be added to a regular order.']")
	private WebElement warningMessageC2addedRegular;
	
	@FindBy(xpath = "//div[@aria-label='Regular products cannot be added to a C2 order.']")
	private WebElement warningmessageRegularAddedC2;
	
	@FindBy(xpath = "//div[text()='Certificate is not registered or password did not match.']")
	private WebElement alertmessageC2PasswordnotMatch;
	
	@FindBy(xpath = "//div[text()='Please enter valid qty']")
	private WebElement errorMessageQty;
	
	@FindBy(xpath = "//div[text()='Order Qty is not valid']")
	private WebElement errorMessageOrderQty;
	
	@FindBy(xpath = "//button[text()='Cancel']")
	private WebElement btncance;
	
	public WebElement getBclnkCurrentOrderPage() {
		return bclnkCurrentOrderPage;
	}

	public WebElement getTxtAddQty() {
		return txtAddQty;
	}

	public WebElement getTxtOrderName() {
		return txtOrderName;
	}

	public WebElement getTxtDate() {
		return txtDate;
	}

	public WebElement getDdTime() {
		return ddTime;
	}

	public WebElement getBtnAutoSubmit() {
		return btnAutoSubmit;
	}

	public WebElement getBtnCancelAutoSubmit() {
		return btnCancelAutoSubmit;
	}

	public WebElement getSuccessMessageCancelAutoSubmit() {
		return successMessageCancelAutoSubmit;
	}

	public WebElement getLnkAutoSubmitHistory() {
		return lnkAutoSubmitHistory;
	}

	public WebElement getAutoSubmitHistory() {
		return AutoSubmitHistory;
	}

	public WebElement getAutoSubmitHistoryDoc() {
		return autoSubmitHistoryDoc;
	}

	public WebElement getiClose() {
		return iClose;
	}

	public WebElement getTxtOrderReferance() {
		return txtOrderReferance;
	}

	public WebElement getSuccessMessageOrderReference() {
		return successMessageOrderReference;
	}

	public WebElement getSuccessMessageAutoSubmit() {
		return successMessageAutoSubmit;
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

	public WebElement getCbxInvalidItemFirst() {
		return cbxInvalidItemFirst;
	}

	public WebElement getCbxTd() {
		return cbxTd;
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

	public WebElement getSuccesMessageItemDeleted() {
		return succesMessageItemDeleted;
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

	public WebElement getBtnSaveAsTemplate() {
		return btnSaveAsTemplate;
	}

	public WebElement getSuccessMessageOrderTemplateSaved() {
		return successMessageOrderTemplateSaved;
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

	public WebElement getAlertMessageNonC2Items() {
		return alertMessageNonC2Items;
	}

	public WebElement getTdNetPrice() {
		return tdNetPrice;
	}

	public WebElement getBtnAddtoOrder() {
		return btnAddtoOrder;
	}

	public WebElement getTxtOrderQty() {
		return txtOrderQty;
	}

	public WebElement getDdUpdateSpecialCode() {
		return ddUpdateSpecialCode;
	}

	public WebElement getModaltitle() {
		return modaltitle;
	}

	public WebElement getViewlinkFullView() {
		return viewlinkFullView;
	}

	public WebElement getViewLinkCompactView() {
		return viewLinkCompactView;
	}

	public WebElement getWarningMessageItemAlreadyAddedToOrder() {
		return warningMessageItemAlreadyAddedToOrder;
	}

	public WebElement getErrorMessageOrderReference() {
		return errorMessageOrderReference;
	}

	public WebElement getErrorMessageWithoutSelectItem() {
		return errorMessageWithoutSelectItem;
	}

	public WebElement getWarningMessageAutoSubmit() {
		return warningMessageAutoSubmit;
	}

	public WebElement getErrorMessageNOMatchingProducts() {
		return errorMessageNOMatchingProducts;
	}

	public WebElement getWarningMessageUnavailable() {
		return warningMessageUnavailable;
	}

	public WebElement getWarningMessageC2addedRegular() {
		return warningMessageC2addedRegular;
	}

	public WebElement getWarningmessageRegularAddedC2() {
		return warningmessageRegularAddedC2;
	}

	public WebElement getAlertmessageC2PasswordnotMatch() {
		return alertmessageC2PasswordnotMatch;
	}

	public WebElement getErrorMessageQty() {
		return errorMessageQty;
	}

	public WebElement getErrorMessageOrderQty() {
		return errorMessageOrderQty;
	}

	public WebElement getBtncance() {
		return btncance;
	}

	public WebElement getUpdateMessageByItemNumber(String itemsNum) {
		String xpath = "//div[contains(@aria-label, 'Item #" + itemsNum
				+ "') and contains(@aria-label, 'updated from order')]";
		return driver.findElement(By.xpath(xpath));
	}

	/**
	 * @see Used to Update Order Referance
	 * @param orderReferance
	 */
	public void updateOrderReferance(String orderReferance) {
		elementVisibility(getTxtOrderReferance());
		insertValue(getTxtOrderReferance(), orderReferance);
		getTxtOrderReferance().sendKeys(Keys.ENTER);
		click(getBtnAutoSubmit());
	}

	public static void selectFromMatSelectByText(WebDriver driver, WebElement matSelectElement, String visibleText) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(matSelectElement)).click();
		String optionXPath = "//mat-option//span[normalize-space(text())='" + visibleText + "']";
		WebElement option = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(optionXPath)));
		clickElementUsingJavaScript(driver, option);
	}

	/**
	 * @see Used to Update Auto Submit
	 */
	public void updateAutoSubmit(String date, String time) {
		try {
			getTxtDate().sendKeys(Keys.chord(Keys.CONTROL, "a"));
			getTxtDate().sendKeys(Keys.BACK_SPACE);
			insertValue(getTxtDate(), date);
			selectFromMatSelectByText(driver, getDdTime(), time);
			clickElementUsingJavaScript(driver, getBtnAutoSubmit());
		} catch (Exception e) {
		}
	}

	public void autoSubmitValidation(String date) {
		try {
			getTxtDate().sendKeys(Keys.chord(Keys.CONTROL, "a"));
			getTxtDate().sendKeys(Keys.BACK_SPACE);
			insertValue(getTxtDate(), date);
			clickElementUsingJavaScript(driver, getBtnAutoSubmit());
		} catch (Exception e) {
		}
	}

	/**
	 * @see Used to Cancel Auto Submit
	 */
	public void cancelAutoSubmit() {
		elementVisibility(getBtnCancelAutoSubmit());
		click(getBtnCancelAutoSubmit());

	}

	/**
	 * @see Used to view the Auto Submit History
	 */
	public void autoSubmitHistory() {
		elementVisibility(getLnkAutoSubmitHistory());
		clickElementUsingJavaScript(driver, getAutoSubmitHistory());
		try {
			WebElement docElement = waitForWebElementVisible(getAutoSubmitHistoryDoc());
			Assert.assertTrue(docElement.isDisplayed());
			System.out.println(" Document 'AutoSubmitHistory' is visible on the page.");
		} catch (TimeoutException e) {
			System.out.println(" Document 'AutoSubmitHistory' was not found.");
			Assert.fail("Document AutoSubmitHistory is not displayed.");
		}

	}

	/**
	 * @See Used checked show Invalid Items First
	 */
	public void selectShowInvalidItemsFirst() {
		clickElementUsingJavaScript(driver, getCbxInvalidItemFirst());

	}

	/**
	 * @see Used to delete item using select checkbox and clicks Delete selected
	 */
	public void deleteProducts() {
		clickElementUsingJavaScript(driver, getCbxTd());
		click(getBtnDeleteSelected());

	}

	public void sortingFunctionality() throws InterruptedException {
		String[] columnNames = { "items", "Product Descriptions", "Categories", "Order Qty", "Whs. Qty", "Net Price",
				"Ext. Net Price", "Inv. Price", "Ext. Inv Price", "Special Code", "Added" };
		for (int i = 0; i < columnNames.length; i++) {

			if (columnNames[i].equalsIgnoreCase("Order Qty") || columnNames[i].equalsIgnoreCase("Special Code")) {
				System.out.println("Skipping sorting for column: '" + columnNames[i] + "'");
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
				System.out.println(
						"Result: " + ("descending".equals(ariaSort) ? "Descending ✔️" : "❌ Not sorted descending"));
			} else if ("descending".equals(ariaSort)) {
				System.out.println("Column '" + columnNames[i] + "' is initially sorted in descending order.");
				clickElementUsingJavaScript(driver, columnHeader);
				Thread.sleep(500);
				ariaSort = columnHeader.getAttribute("aria-sort");
				System.out.println("Sorting Order After Click for '" + columnNames[i] + "': " + ariaSort);
				System.out.println(
						"Result: " + ("ascending".equals(ariaSort) ? "Ascending ✔️" : "❌ Not sorted ascending"));
			} else {
				System.out.println("Sorting order could not be determined for column '" + columnNames[i] + "'.");
			}
		}
	}

	public void updateItem(String itemsNum, String specialCode, String orderQty, String updateMessage)
			throws InterruptedException {
		elementVisibility(getTxtItemSearch());
		if (itemsNum != null)
			insertValue(getTxtItemSearch(), itemsNum);
		if (orderQty != null)
			insertValue(getTxtQty(), orderQty);
		WebElement specialCodeDropdown = getDdSpecialCode();
		if (specialCodeDropdown != null && specialCodeDropdown.isDisplayed()) {
			new WebDriverWait(driver, Duration.ofSeconds(5))
					.until(ExpectedConditions.visibilityOf(specialCodeDropdown));
			Select dropdown = new Select(specialCodeDropdown);
			System.out.println("Special Code: [" + specialCode + "]");
			if (specialCode != null && !specialCode.trim().isEmpty()
					&& !"[empty]".equalsIgnoreCase(specialCode.trim())) {
				Thread.sleep(1000);
				try {
					dropdown.selectByVisibleText(specialCode);
					System.out.println("Selected: " + specialCode.trim());
				} catch (NoSuchElementException e) {
					dropdown.selectByValue(specialCode.trim());
				}
			} else {
				dropdown.selectByIndex(0);
				System.out.println("Selected: [empty] (index 0)");
			}
		}
		click(getBtnUpdate());
		assertEquals(getUpdateMessageByItemNumber(itemsNum), updateMessage);
	}

	public void saveTemplates() {
		elementToBeClickable(getBtnSaveAsTemplate());
		click(getBtnSaveAsTemplate());

	}

	public void printOrder() throws InterruptedException {
		click(getBtnPrintOrder());
		Thread.sleep(6000);

	}

	public void updateAlreadyAddedItemFromAddProducts(String updateItems, String warningMessage, String updateQty,
			String updateSpecialCode, String updateMessage) throws InterruptedException {
		elementVisibility(getTxtAddProduct());
		Thread.sleep(1000);
		insertValue(getTxtAddProduct(), updateItems);
		implicitWait();
		clickElementUsingJavaScript(driver, getiSearchAddProduct());
		clickElementUsingJavaScript(driver, getBtnAddtoOrder());
		elementVisibility(getWarningMessageItemAlreadyAddedToOrder());
		assertEquals(getWarningMessageItemAlreadyAddedToOrder(), warningMessage);
		elementVisibility(getTxtOrderQty());
		Thread.sleep(1000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement qtyField = wait.until(ExpectedConditions.elementToBeClickable(getTxtOrderQty()));
		qtyField.clear();
		qtyField.sendKeys(updateQty);
		System.out.println(" Quantity updated: " + updateQty);
		String text = getText(getTxtOrderQty());
		System.out.println(text);
		List<WebElement> dropdowns = driver.findElements(By.xpath("//select[@formcontrolname='specialCode']"));

		if (!dropdowns.isEmpty()) {
			WebElement specialCodeDropdown = dropdowns.get(0);

			if (specialCodeDropdown.isDisplayed()) {
				Select dropdown = new Select(specialCodeDropdown);
				System.out.println("📋 Special Code Provided: [" + updateSpecialCode + "]");

				if (updateSpecialCode != null && !updateSpecialCode.trim().isEmpty()
						&& !"[empty]".equalsIgnoreCase(updateSpecialCode.trim())) {
					try {
						dropdown.selectByVisibleText(updateSpecialCode.trim());
						System.out.println(" Special Code selected: " + updateSpecialCode.trim());
					} catch (NoSuchElementException e) {
						dropdown.selectByValue(updateSpecialCode.trim());
						System.out.println(" Fallback: selected by value.");
					}
				} else {
					dropdown.selectByIndex(0);
					System.out.println(" Defaulted to index 0 ([empty])");
				}
			} else {
				System.out.println(" Special Code dropdown is in DOM but not displayed. Skipping for C2 item.");
			}
		} else {
			System.out.println(" Special Code dropdown not found. Skipping for C2 item.");
		}

		Thread.sleep(2000);
		clickElementUsingJavaScript(driver, getBtnUpdate());
		elementVisibility(getSuccessMessgeUpdateItem());
		assertEquals(getSuccessMessgeUpdateItem(), updateMessage);

	}

	/**
	 * @see Used to update Order Name
	 * @param updatedOrderName
	 */
	public void orderNameUpdate(String updatedOrderName) {
		try {
			elementVisibility(getTxtOrderName());
			clearTextUsingjs(getTxtOrderName());
			getTxtOrderName().sendKeys(Keys.chord(Keys.CONTROL, "a"));
			getTxtOrderName().sendKeys(Keys.BACK_SPACE);
			insertValue(getTxtOrderName(), updatedOrderName);
			getTxtOrderName().sendKeys(Keys.ENTER);
			clickElementUsingJavaScript(driver, getSortingItems());
		} catch (Exception e) {

		}
	}

	/**
	 * @see Used to claer Order Name
	 */
	public void clearOrderName() {

		getTxtOrderName().sendKeys(Keys.chord(Keys.CONTROL, "a"));
		getTxtOrderName().sendKeys(Keys.BACK_SPACE);
		clickElementUsingJavaScript(driver, getSortingItems());
	}

	public void orderReference(String updatedOrderReference) {
		elementVisibility(getTxtOrderReferance());
		clearTextUsingjs(getTxtOrderReferance());
		getTxtOrderReferance().sendKeys(Keys.chord(Keys.CONTROL, "a"));
		getTxtOrderReferance().sendKeys(Keys.BACK_SPACE);
		insertValue(getTxtOrderReferance(), updatedOrderReference);
		getTxtOrderReferance().sendKeys(Keys.ENTER);

	}

	/**
	 * @see Update item qty in grid
	 */

	public void updateQty(String qty) {
		try {
			elementVisibility(txtQtyinGrid);
			clearTextUsingjs(getTxtQtyinGrid());
			insertValue(txtQtyinGrid, qty);
		} catch (Exception e) {

		}
	}

	/**
	 * @see Used to clicks Full view in Product Search webpage
	 */
	public void selectsFullView() {

		elementToBeClickable(getViewlinkFullView());
		clickElementUsingJavaScript(driver, getViewlinkFullView());

	}

	/**
	 * @see Used to update special code in Grid
	 * @param specialCode - The visible text to be selected from the dropdown
	 */
	public void updateSpecialCode(String specialCode) {
		try {
			WebElement dropdown = getDdSpecialCodeinGrid();
			if (dropdown != null && dropdown.isDisplayed()) {
				System.out.println("Attempting to select Special Code: " + specialCode);
				if (specialCode != null && !specialCode.trim().isEmpty()) {
					selectByVisibleText(dropdown, specialCode.trim());
					System.out.println("Special Code updated to: " + specialCode);
				} else {
					System.out.println("Provided Special Code is null or empty. Skipping selection.");
				}
			} else {
				System.out.println("Special Code dropdown is not visible.");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

//	/**
//	 * @see Used to update special code in Grid
//	 */
//	public void updateSpecialCode(String specialCode) {
//		
//		if (getDdSpecialCodeinGrid().isDisplayed()) {
//			try {
//			selectByVisibleText(getDdSpecialCodeinGrid(), specialCode);
//			}catch (Exception e) {
//				
//			}
//		}
//	}

	/**
	 * @see Used to delete item in Grid
	 */
	public void deleteItemsInGrid() {
		elementVisibility(getiTrashinGrid());
		elementToBeClickable(getiTrashinGrid());
		clickElementUsingJavaScript(driver, getiTrashinGrid());

	}

	/**
	 * @see Used to perform ascending and descending order in items
	 */
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
	 * 
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

	/**
	 * @see Used to set quantity as zero
	 * @param itemNum
	 * @param orderQty
	 * @throws InterruptedException
	 */
	public void addZeroQuantity(String itemNum, String orderQty) throws InterruptedException {
		elementVisibility(getTxtItemSearch());
		setTextUsingJS(getTxtItemSearch(), itemNum);
		getTxtItemSearch().sendKeys(Keys.ENTER);
		elementVisibility(getTxtQty());
		getTxtQty().sendKeys(Keys.chord(Keys.CONTROL, "a"));
		getTxtQty().sendKeys(Keys.BACK_SPACE);
		Thread.sleep(1000);
		String qty = "00";
		insertValue(getTxtQty(), qty);
		System.out.println("Updated Qty: " + getTxtQty().getAttribute("value"));
		Thread.sleep(2000);
		clickElementUsingJavaScript(driver, getBtnAdd());
	}

	/**
	 * @see Used to insert Restriction items
	 * @param itemNum
	 * @throws InterruptedException
	 */
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

	/**
	 * @see Used to verify to set quantity as zero in grid
	 * @param orderQty
	 */
	public void verifyUpdateWithZeroQuantityInGrid(String orderQty) {
		elementVisibility(getTxtQtyinGrid());
		clearTextUsingjs(getTxtQtyinGrid());
		getTxtQtyinGrid().sendKeys(Keys.chord(Keys.CONTROL, "a"));
		getTxtQtyinGrid().sendKeys(Keys.BACK_SPACE);
		String qty = "00";
		insertValue(getTxtQtyinGrid(), qty);
		if (getDdSpecialCodeinGrid().isDisplayed()) {
			selectByVisibleText(getDdSpecialCodeinGrid(), "Shelf Label Only");
		}
		clickElementUsingJavaScript(driver, getTdNetPrice());
	}

//	public void verifySelectAllCheckboxFunctionality() throws InterruptedException {
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//
//		// 1. Click the header checkbox (mat-checkbox wrapper)
//		WebElement headerCheckboxWrapper = wait
//				.until(ExpectedConditions.elementToBeClickable(By.xpath("//th//mat-checkbox")));
//		clickElementUsingJavaScript(driver, headerCheckboxWrapper);
//
//		Thread.sleep(1000); // Wait for state change
//
//		// 2. Verify row checkboxes are all selected
//		List<WebElement> rowCheckboxes = driver.findElements(By.xpath("//td//mat-checkbox"));
//		boolean allSelected = true;
//		for (WebElement checkbox : rowCheckboxes) {
//			if (!"true".equals(checkbox.getAttribute("aria-checked"))) {
//				allSelected = false;
//				break;
//			}
//		}
//		Thread.sleep(1000);
//		if (allSelected) {
//			System.out.println(" All row checkboxes are selected after clicking header checkbox.");
//			verifyMessageDisplayed("All items selected"); // Adjust message based on UI
//		} else {
////			System.out.println(" Some checkboxes are not selected.");
//		}
//
//		// 3. Click header checkbox again to deselect all
//		clickElementUsingJavaScript(driver, headerCheckboxWrapper);
//		Thread.sleep(1000);
//
//		boolean noneSelected = true;
//		for (WebElement checkbox : rowCheckboxes) {
//			if (!"false".equals(checkbox.getAttribute("aria-checked"))) {
//				noneSelected = false;
//				break;
//			}
//		}
//
//		if (noneSelected) {
//			System.out.println("All row checkboxes are deselected after toggling header checkbox.");
//			verifyMessageDisplayed("All items deselected");
//		} else {
//			System.out.println("Some checkboxes are still selected after deselecting.");
//		}
//	}
	public void verifySelectAllCheckboxFunctionality() {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	    try {
	        // 1. Click the header checkbox to select all
	        WebElement headerCheckboxWrapper = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//th//mat-checkbox//input[@type='checkbox']")));
	        clickElementUsingJavaScript(driver, headerCheckboxWrapper);

	        // Wait for UI to reflect selection
	        wait.until(ExpectedConditions.attributeToBe(headerCheckboxWrapper, "class", "mat-checkbox-checked"));

	        // 2. Verify that all row checkboxes are selected
	        List<WebElement> rowCheckboxes = driver.findElements(By.xpath("//td//mat-checkbox"));
	        boolean allSelected = true;
	        for (WebElement checkbox : rowCheckboxes) {
	            if (!"true".equals(checkbox.getAttribute("checked"))) {
	                allSelected = false;
	                break;
	            }
	        }

	        if (allSelected) {
	            System.out.println(" All row checkboxes are selected after clicking header checkbox.");
	            verifyMessageDisplayed("All items selected"); // Adjust message if needed
	        } else {
	            System.out.println("Some checkboxes are not selected.");
	        }

	        // 3. Click header checkbox again to deselect all
	        clickElementUsingJavaScript(driver, headerCheckboxWrapper);

	        // Re-fetch the row checkboxes to avoid stale element exception
	        wait.until(ExpectedConditions.attributeToBe(headerCheckboxWrapper, "aria-checked", "false"));
	        rowCheckboxes = driver.findElements(By.xpath("//td//mat-checkbox"));

	        boolean noneSelected = true;
	        for (WebElement checkbox : rowCheckboxes) {
	            if (!"false".equals(checkbox.getAttribute("checked"))) {
	                noneSelected = false;
	                break;
	            }
	        }

	        if (noneSelected) {
	            System.out.println(" All row checkboxes are deselected after toggling header checkbox.");
	            verifyMessageDisplayed("All items deselected");
	        } else {
	            System.out.println(" Some checkboxes are still selected after deselecting.");
	        }

	    } catch (Exception e) {
	        System.out.println("Exception during Select All checkbox validation: " + e.getMessage());
//	        Assert.fail("Select All checkbox test failed.");
	    }
	}

	public void verifyMessageDisplayed(String expectedText) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
			WebElement toast = wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("//div[contains(@class,'snackbar') or contains(@aria-label,'" + expectedText + "')]")));

			String actualText = toast.getText();
			if (actualText.contains(expectedText)) {
				System.out.println("Message verified: " + actualText);
			} else {
				System.out.println("Message mismatch. Expected: " + expectedText + " | Actual: " + actualText);
			}
		} catch (TimeoutException e) {
			System.out.println("Message not displayed: " + expectedText);
		}
	}

	/**
	 * @see Used to add Products using NDC, UPC, GTIN, Product discrptions, Item#
	 * @param NDC_ProductDescription
	 * @throws InterruptedException
	 */
	public void restrictedItemsUsingAddProducts(String products) throws InterruptedException {
		elementVisibility(getTxtAddProduct());
		Thread.sleep(1000);
		insertValue(getTxtAddProduct(), products);
		implicitWait();
		clickElementUsingJavaScript(driver, getiSearchAddProduct());
		selectsFullView();
//		elementVisibility(getTxtOrderQty());
//		insertValue(getTxtOrderQty(), "2");
//		clickElementUsingJavaScript(driver, getBtnAddToOrder());

	}

	public void verifyDiscontinuedMessage(String expectedText) {
		WebElement discontinuedMessage = driver
				.findElement(By.xpath("//div[@class='text-danger-text discontinued-text ng-star-inserted']"));
		String actualMessage = discontinuedMessage.getText().trim();
		Assert.assertTrue("Expected message not found! Actual: " + actualMessage, actualMessage.contains(expectedText));
		System.out.println(" Discontinued message verified: " + actualMessage);
	}

	public void c2AlternativeItems(String products) throws InterruptedException {

		elementVisibility(getTxtAddProduct());
		insertValue(getTxtAddProduct(), products);
		clickElementUsingJavaScript(driver, getiSearchAddProduct());
		selectsFullView();
		elementVisibility(getTxtAddQty());
		insertValue(getTxtAddQty(), "1");
		clickElementUsingJavaScript(driver, getBtnAddToOrder());
		Thread.sleep(1500);
	}

	public void regularAlternativeItems(String products) throws InterruptedException {

		elementVisibility(getTxtAddProduct());
		insertValue(getTxtAddProduct(), products);
		clickElementUsingJavaScript(driver, getiSearchAddProduct());
		selectsFullView();
		elementVisibility(getTxtAddQty());
		insertValue(getTxtAddQty(), "1");
		clickElementUsingJavaScript(driver, getBtnAddToOrder());
		Thread.sleep(1500);
	}

	public void c2ItemsAddedInRegularOrder(String products) {
		elementVisibility(getTxtAddProduct());
		insertValue(getTxtAddProduct(), products);
		clickElementUsingJavaScript(driver, getiSearchAddProduct());

	}

	public void regularItemsAddedInC2Order(String products) {
		elementVisibility(getTxtAddProduct());
		insertValue(getTxtAddProduct(), products);
		clickElementUsingJavaScript(driver, getiSearchAddProduct());

	}

	public void submitOrder() {
		

	}
	public void clicksbclnk() {
		elementVisibility(getBclnkCurrentOrderPage());
		clickElementUsingJavaScript(driver, getBclnkCurrentOrderPage());

	}
	public void emptyFieldOrderQty() {
		elementVisibility(getTxtOrderQty());
		clearField(getTxtOrderQty());
		clickElementUsingJavaScript(driver, getBtnUpdate());
	}
	public void orderQty(String qty) {
		elementVisibility(getTxtOrderQty());
		insertValue(getTxtOrderQty(), qty);
		clickElementUsingJavaScript(driver, getBtnUpdate());
	}
	
}
