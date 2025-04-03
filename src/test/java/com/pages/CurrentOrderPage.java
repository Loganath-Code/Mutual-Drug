package com.pages;

import java.lang.reflect.Constructor;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.base.BaseClass;

/**
 * @see Used to find the locators assign the values in Current Order webpage
 * @Date 07-Feb-2025
 */
public class CurrentOrderPage extends BaseClass {

	/**
	 * @see Constructor Used to initialize the values
	 */
	public CurrentOrderPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//h4[text()='Current Orders']")
	private WebElement titleCurrentOrders;

	@FindBy(xpath = "//button[@class='template-btn']")
	private WebElement btnViewOrderTemplate;

	@FindBy(xpath = "//button[text()='Create New']")
	private WebElement btnCreateNew;

	@FindBy(xpath = "//input[@name='orderName']")
	private WebElement txtOrderName;

	@FindBy(xpath = "(//span[@class='checkmark'])[1]")
	private WebElement rdbtnRegular;

	@FindBy(xpath = "(//span[@class='checkmark'])[2]")
	private WebElement rdbtnC2Order;

	@FindBy(xpath = "(//span[@class='checkmark'])[3]")
	private WebElement rdbtnBackOrder;

	@FindBy(xpath = "//input[@name='orderReference']")
	private WebElement txtOrderReference;

	@FindBy(xpath = "//button[text()='Create']")
	private WebElement btnCreate;

	@FindBy(xpath = "(//div[@role='tab'])[1]")
	private WebElement tabNewOrder;

	@FindBy(xpath = "(//div[@role='tab'])[2]")
	private WebElement tabUseATemplate;

	@FindBy(xpath = "//mat-select[@name='chooseTemplate']")
	private WebElement ddChooseTemplate;

	@FindBy(xpath = "//input[@name='orderName']")
	private WebElement txtOrdername_Template;

	@FindBy(xpath = "//label[normalize-space()='Regular Order']//span[@class='checkmark']")
	private WebElement rdbtnRegularOrder;

	@FindBy(xpath = "(//a[@href='/member/orders/current-orders'])[2]")
	private WebElement bCrumbLinkCurrentOrder;

	@FindBy(xpath = "//input[@placeholder='Search']")
	private WebElement txtSearchOrders;

	@FindBy(xpath = "(//button[@class='search'])[2]")
	private WebElement iSearchOrders;

	@FindBy(xpath = "(//i[@class='fa fa-trash'])[1]")
	private WebElement iTrash;

	@FindBy(xpath = "//button[@class='btn btn-primary modal-btn']")
	private WebElement btnYes;

	@FindBy(xpath = "//div[@aria-label='Order details deleted.']")
	private WebElement alertMessageDeleteOrder;

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

	@FindBy(xpath = "//tbody//tr[1]//td[1]")
	private WebElement tdFirstcell;

	@FindBy(xpath = "(//span[@class='val'])[1]//parent::td")
	private WebElement firstOrderName;

	@FindBy(xpath = "//input[@name='itemSearch']")
	private WebElement txtItemNum;

	@FindBy(xpath = "(//td[@class='tableCell'])[2]")
	private WebElement tdProductDiscription;

	@FindBy(xpath = "//select[@class='form-control ng-pristine ng-valid ng-touched']")
	private WebElement ddSpecialCode;

	@FindBy(xpath = "//input[@min='1']")
	private WebElement txtOrderQty;

	@FindBy(xpath = "//button[text()='Add']")
	private WebElement btnAdd;

	@FindBy(xpath = "//i[@class='fa fa-trash']")
	private WebElement iconDelete;

	@FindBy(xpath = "//input[@name='searchKey']")
	private WebElement txtSearchAddProducts;

	@FindBy(xpath = "//button[@type='button']//i[@class='fa fa-search']")
	private WebElement iSearch;

	@FindBy(xpath = "//input[@placeholder='Qty']")
	private WebElement txtAddQty;

	@FindBy(xpath = "(//button[@type='submit'])[2]")
	private WebElement btnAddToOrder;

	@FindBy(xpath = "//button[normalize-space()='Submit']")
	private WebElement btnSubmit;

	@FindBy(xpath = "//button[@class='navigate-btn']")
	private WebElement btnOkAlertmessage;

	@FindBy(xpath = "//div[contains(@aria-label, 'Item #')]")
	private WebElement alertSuccessMessageOrderAdded;
	// c2 order
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

	public WebElement getTitleCurrentOrders() {
		return titleCurrentOrders;
	}

	public WebElement getBtnViewOrderTemplate() {
		return btnViewOrderTemplate;
	}

	public WebElement getBtnCreateNew() {
		return btnCreateNew;
	}

	public WebElement getTxtOrderName() {
		return txtOrderName;
	}

	public WebElement getRdbtnRegular() {
		return rdbtnRegular;
	}

	public WebElement getRdbtnC2Order() {
		return rdbtnC2Order;
	}

	public WebElement getRdbtnBackOrder() {
		return rdbtnBackOrder;
	}

	public WebElement getTxtOrderReference() {
		return txtOrderReference;
	}

	public WebElement getBtnCreate() {
		return btnCreate;
	}

	public WebElement getTabNewOrder() {
		return tabNewOrder;
	}

	public WebElement getTabUseATemplate() {
		return tabUseATemplate;
	}

	public WebElement getTxtOrdername_Template() {
		return txtOrdername_Template;
	}

	public WebElement getDdChooseTemplate() {
		return ddChooseTemplate;
	}

	public WebElement getRdbtnRegularOrder() {
		return rdbtnRegularOrder;
	}

	public WebElement getbCrumbLinkCurrentOrder() {
		return bCrumbLinkCurrentOrder;
	}

	public WebElement getTxtSearchOrders() {
		return txtSearchOrders;
	}

	public WebElement getiSearchOrders() {
		return iSearchOrders;
	}

	public WebElement getiTrash() {
		return iTrash;
	}

	public WebElement getBtnYes() {
		return btnYes;
	}

	public WebElement getAlertMessageDeleteOrder() {
		return alertMessageDeleteOrder;
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

	public WebElement getTdFirstcell() {
		return tdFirstcell;
	}

	public WebElement getFirstOrderName() {
		return firstOrderName;
	}

	public WebElement getTxtItemNum() {
		return txtItemNum;
	}

	public WebElement getTdProductDiscription() {
		return tdProductDiscription;
	}

	public WebElement getDdSpecialCode() {
		return ddSpecialCode;
	}

	public WebElement getTxtOrderQty() {
		return txtOrderQty;
	}

	public WebElement getBtnAdd() {
		return btnAdd;
	}

	public WebElement getIconDelete() {
		return iconDelete;
	}

	public WebElement getTxtSearchAddProducts() {
		return txtSearchAddProducts;
	}

	public WebElement getiSearch() {
		return iSearch;
	}

	public WebElement getTxtAddQty() {
		return txtAddQty;
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

	public WebElement getAlertSuccessMessageOrderAdded() {
		return alertSuccessMessageOrderAdded;
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

	public WebElement getAlertC2OrderSuccessMessage(String orderName) {
		return driver.findElement(By.xpath("//*[contains(text(), 'Thank you, your CSOS order (" + orderName
				+ ") was successfully signed and transmitted.')]"));
	}

	public WebElement getAlertMessageByItemNumber(String itemsNum) {
		return driver.findElement(By.xpath("//div[contains(@aria-label, 'Item #" + itemsNum + "')]"));
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

	/**
	 * @see Used to click button View Order Templates
	 */
	public void clicksViewOrderTemplates() {
		clickElementUsingJavaScript(driver, getBtnViewOrderTemplate());

	}

	/**
	 * @throws InterruptedException
	 * @see Used to search Orders
	 */
	public void searchOrders(String orderName) throws InterruptedException {
		elementVisibility(getbCrumbLinkCurrentOrder());
		Thread.sleep(2000);
		clickElementUsingJavaScript(driver, getbCrumbLinkCurrentOrder());
		elementVisibility(getTxtSearchOrders());
		Thread.sleep(2000);
		insertValue(getTxtSearchOrders(), orderName);

		clickElementUsingJavaScript(driver, getiSearchOrders());
	}

	/**
	 * @see Used to delete order
	 */
	public void deleteOrder() {
		elementVisibility(getiTrash());
		clickElementUsingJavaScript(driver, getiTrash());
		clickElementUsingJavaScript(driver, getBtnYes());
	}

	/**
	 * @see Used to clicking radio button dynamically using label name
	 * @param rdbtnName
	 */
	public void clickRadioButton(String rdbtnName) {
		String xpath = "//label[normalize-space()='" + rdbtnName + "']//span[@class='checkmark']";
		// Waiting until the radio button is clickable
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement radioButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
		radioButton.click();
	}

	/**
	 * @see Used to create a new order
	 * @param orderName
	 * @param orderType
	 * @param autoSubmit
	 * @param orderReferance
	 */
	public void createNewOrder(String orderName, String orderType, String autoSubmit, String orderReferance) {
		clickElementUsingJavaScript(driver, getBtnCreateNew());
		insertValue(getTxtOrderName(), orderName);
		clickRadioButton(orderType);
		clickRadioButton(autoSubmit);
		insertValue(getTxtOrderReference(), orderReferance);
		clickElementUsingJavaScript(driver, getBtnCreate());
	}

	/**
	 * @see Used to add items
	 * @param itemsNum
	 * @param specialCode
	 * @param orderQty
	 */
	public void addItems(String itemsNum, String specialCode, String orderQty, String successMessage) {
		elementVisibility(getTxtItemNum());
		insertValue(getTxtItemNum(), itemsNum);
		insertValue(getTxtOrderQty(), orderQty);
		click(getBtnAdd());
		assertEquals(getAlertMessageByItemNumber(itemsNum), successMessage);
	}

	/**
	 * @See Used to insert value add products
	 * @param NDC
	 * @param addQuantity
	 * @param successMessage
	 */
	public void addProducts(String NDC, String addQuantity, String successMessage) {
		elementVisibility(getTxtSearchAddProducts());
		insertValue(getTxtSearchAddProducts(), NDC);
		clickElementUsingJavaScript(driver, getiSearch());
		elementVisibility(getTxtAddQty());
		insertValue(getTxtAddQty(), addQuantity);
		clickElementUsingJavaScript(driver, getBtnAddToOrder());
//		assertEquals(getAlertMessageByItemNumber(itemsNum), successMessage);
	}

	/**
	 * @see Used to create C2 order
	 * @param orderName
	 * @param orderType
	 */
	public void createC2Order(String orderName, String orderType) {
		clickElementUsingJavaScript(driver, getBtnCreateNew());
		insertValue(getTxtOrderName(), orderName);
		clickRadioButton(orderType);
		clickElementUsingJavaScript(driver, getBtnCreate());
	}

	/**
	 * @see Used to clicks submit button
	 */
	public void clicksSubmit() {
		scrollToElement(getBtnSubmit());
		clickElementUsingJavaScript(driver, getBtnSubmit());

	}

	/**
	 * @see Used to clicks Sign & Submit button
	 */
	public void clicksSignSubmit() {
		scrollToElement(getBtnSignSubmit());
		clickElementUsingJavaScript(driver, getBtnSignSubmit());
	}

	/**
	 * @see Used to insert store password and clicks sign button
	 * @param storePassword
	 */
	public void insertStorePassword(String storePassword) {
		elementVisibility(getTxtStorePassword());
		insertValue(getTxtStorePassword(), storePassword);
		clickElementUsingJavaScript(driver, getBtnSign());
	}

	/**
	 * @see Used to clicks OK button in alert prompt
	 */
	public void clicksOK() {
		clickElementUsingJavaScript(driver, btnOkAlertmessage);

	}

	/**
	 * @see Used to click Save as Template button
	 */
	public void clickSaveAsTemplateButton() {
		click(getBtnSaveASTemplate());

	}

	/**
	 * @see Used to select Template name in dropDown
	 * @param driver
	 * @param dropdownElement
	 * @param optionText
	 */
	public void selectTemplateOptionDropDown(WebDriver driver, WebElement dropdownElement, String optionText) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(dropdownElement));
		click(dropdownElement);
		WebElement option = wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("//mat-option//span[text()='" + optionText + " ']")));
		clickElementUsingJavaScript(driver, option);
	}

	/**
	 * @see Used to select Template name in dropDown
	 */
	public void selectTemplete() {
		elementToBeClickable(getBtnCreateNew());
		clickElementUsingJavaScript(driver, getBtnCreateNew());
		clickElementUsingJavaScript(driver, getTabUseATemplate());
		selectTemplateOptionDropDown(driver, getDdChooseTemplate(), "sample test order New");

	}

	/**
	 * @see used to create empty field order creations
	 */
	public void emptyFieldsOrderCreation() {
		clickElementUsingJavaScript(driver, getBtnCreateNew());
		elementVisibility(getTxtOrderName());
		getTxtOrderName().sendKeys(Keys.chord(Keys.CONTROL, "a"));
		getTxtOrderName().sendKeys(Keys.BACK_SPACE);
		if (getBtnCreate().isEnabled() && getBtnCreate().isDisplayed()) {
			clickElementUsingJavaScript(driver, getBtnCreate());
		} else {
			System.out.println("Button is either disabled or not visible");
		}

	}

	/**
	 * @see Used to Create OrderName with special characters
	 * @param orderType
	 */
	public void insertOrderNameWithSpecialChar(String orderType) {
		elementVisibility(getTxtOrderName());
		insertValue(getTxtOrderName(), "!@#$%");
		clickRadioButton(orderType);
		clickElementUsingJavaScript(driver, getBtnCreate());
	}

	/**
	 * @see Used to create order name with space
	 * @param orderType
	 */
	public void currentOrderNameWithSpace(String orderType) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement orderNameField = wait.until(ExpectedConditions.elementToBeClickable(getTxtOrderName()));
		orderNameField.sendKeys(Keys.chord(Keys.CONTROL, "a"));
		orderNameField.sendKeys(Keys.BACK_SPACE);
		orderNameField.sendKeys(Keys.SPACE);
		clickRadioButton(orderType);
		int attempt = 0;
		while (attempt < 5) {
			try {
				clickElementUsingJavaScript(driver, getBtnCreate());

				System.out.println("Clicked successfully on attempt " + (attempt + 1));
				break;
			} catch (Exception e) {
				attempt++;
				System.out.println("Attempt " + attempt + " failed: " + e.getClass().getSimpleName() + ". Retrying...");

			}
		}

		if (attempt == 5)
			System.out.println("Failed after 10 attempts.");
		click(getBtnCreate());

	}

	/**
	 * @see Used to create Empty Fields Use A template
	 */
	public void emptyFieldsUseATemplate() {
		try {
			clickElementUsingJavaScript(driver, getTabUseATemplate());
			elementVisibility(getTxtOrderName());
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			WebElement orderNameField = wait.until(ExpectedConditions.elementToBeClickable(getTxtOrderName()));
			orderNameField.sendKeys(Keys.chord(Keys.CONTROL, "a"));
			orderNameField.sendKeys(Keys.chord(Keys.CONTROL, "a"));
			orderNameField.sendKeys(Keys.BACK_SPACE);
			orderNameField.sendKeys(Keys.chord(Keys.CONTROL, "a"));
			orderNameField.sendKeys(Keys.BACK_SPACE);
			clearTextField(orderNameField);
			clickElementUsingJavaScript(driver, getBtnCreate());
			clickElementUsingJavaScript(driver, getBtnCreate());
		} catch (Exception e) {
			// TODO: handle exception
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

	/**
	 * @see Used to perform sorting in order name
	 */

	public void sortingOrders() {
		String[] columnNames = { "OrderName", "Status", "Created Date", "Order Type", "Total lines", "Total pieces",
				"Ext.Inv.Price" };

		try {
			for (int i = 0; i < columnNames.length; i++) {
				WebElement columnHeader = driver.findElement(By.xpath("(//th[@role='columnheader'])[" + (i + 1) + "]"));
				clickElementUsingJavaScript(driver, columnHeader);

				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
				wait.until(ExpectedConditions.attributeToBeNotEmpty(columnHeader, "aria-sort"));
				String ariaSort = columnHeader.getAttribute("aria-sort");
				System.out.println("Initial Sorting Order for '" + columnNames[i] + "': " + ariaSort);

				if ("ascending".equals(ariaSort)) {
					System.out.println("✅ Column '" + columnNames[i] + "' is initially sorted in ascending order.");

					clickElementUsingJavaScript(driver, columnHeader);

					wait.until(ExpectedConditions.attributeToBeNotEmpty(columnHeader, "aria-sort"));
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
					wait.until(ExpectedConditions.attributeToBeNotEmpty(columnHeader, "aria-sort"));
					ariaSort = columnHeader.getAttribute("aria-sort");
					System.out.println("Sorting Order After Click for '" + columnNames[i] + "': " + ariaSort);
					if ("ascending".equals(ariaSort)) {
						System.out.println("✅ Column '" + columnNames[i] + "' is now sorted in ascending order.");
					} else {
						System.out.println("❌ Column '" + columnNames[i] + "' is NOT sorted in ascending order.");
					}
				} else {
					System.out.println("Sorting order could not be determined for column '" + columnNames[i] + "'.");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
