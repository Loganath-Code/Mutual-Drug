package com.pages;

import java.lang.reflect.Constructor;
import java.time.Duration;

import org.openqa.selenium.By;
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

	public WebElement getTitleCurrentOrders() {
		return titleCurrentOrders;
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
	public void clickSaveAsTemplateButton() {
	click(getBtnSaveASTemplate());

	}
	public void selectTemplateOptionDropDown(WebDriver driver, WebElement dropdownElement, String optionText) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(dropdownElement));
		click(dropdownElement);
		WebElement option = wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("//mat-option//span[text()='"+ optionText + " ']")));
		clickElementUsingJavaScript(driver, option);
	}
	public void selectTemplete() {
		elementToBeClickable(getBtnCreateNew());
		clickElementUsingJavaScript(driver, getBtnCreateNew());
		clickElementUsingJavaScript(driver, getTabUseATemplate());
		selectTemplateOptionDropDown(driver, getDdChooseTemplate(), "sample test order New");

	}
}
