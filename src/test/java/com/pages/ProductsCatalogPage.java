package com.pages;

import java.lang.reflect.Constructor;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.base.BaseClass;

/**
 * @see Used to find the locators assign the values in Product catalog webpage
 * @Date 10-Feb-2025
 */
public class ProductsCatalogPage extends BaseClass {
	/**
	 * @see Constructor Used to initialize the values
	 */
	public ProductsCatalogPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//i[@class='fa fa-cube']")
	private WebElement iProducts;

	@FindBy(xpath = "//span[text()='Products']")
	private WebElement menuProducts;

	@FindBy(xpath = "//a[text()='Monthly Promotions']")
	private WebElement lnkMonthlyPromotions;

	@FindBy(xpath = "//a[text()='Short Dated / Opportunity Buy / Close Out Items']")
	private WebElement lnkShortDated;

	@FindBy(xpath = "//a[text()='Dollar Items']")
	private WebElement lnkDollarItems;

	@FindBy(xpath = "//a[text()='New Items']")
	private WebElement lnkNewItems;

	@FindBy(xpath = "(//a[text()='Durable Medical Equipment (DME)'])[2]")
	private WebElement lnkDurableMedicalEquipment;

	@FindBy(xpath = "//h2[text()='Product Catalog']")
	private WebElement titleProductCatalog;

	@FindBy(xpath = "(//a[text()='Over the Counter (OTC)'])[2]")
	private WebElement lnkOverTheCounter;

	@FindBy(xpath = "//a[text()='Full View']")
	private WebElement viewlinkFullView;

	@FindBy(xpath = "//a[text()='Compact View']")
	private WebElement viewLinkCompactView;

	@FindBy(xpath = "(//button[text()='Add'])[1]")
	private WebElement btnAdd;

	@FindBy(xpath = "(//button[text()='Create New Order'])[5]")
	private WebElement btnCreateNewOrder;

	@FindBy(xpath = "//input[@name='orderName']")
	private WebElement txtOrderName;

	@FindBy(xpath = "//button[text()='Create']")
	private WebElement btnCreate;

	@FindBy(xpath = "//div[@aria-label='Success!']")
	private WebElement alertSuccessMessageOrderCreation;

	@FindBy(xpath = "(//select[@formcontrolname='regularOrderArr'])[1]")
	private WebElement ddOrderName;

	@FindBy(xpath = "(//input[@placeholder='Qty'])[1]")
	private WebElement txtQty;

	@FindBy(xpath = "(//input[@placeholder='Order Qty'])[1]")
	private WebElement txtOrderQty;

	@FindBy(xpath = "//button[text()='Add To Order']")
	private WebElement btnAddToOrder;

	@FindBy(xpath = "//mat-slide-toggle[@class='mat-slide-toggle mat-accent ng-star-inserted']")
	private WebElement toogleInStock;

	@FindBy(xpath = "//button[@class='btn btn-primary modal-btn']")
	private WebElement btnYes;

	@FindBy(xpath = "(//a[@href='/member/products'])[2]")
	private WebElement lnkProductCatalog;

	@FindBy(xpath = "(//a[text()='Over the Counter (OTC)'])[2]")
	private WebElement lnkOTC;

	@FindBy(xpath = "(//a[text()='Compact View'])[1]")
	private WebElement lnkCompactView;

	@FindBy(xpath = "(//input[@role='switch'])[2]")
	private WebElement toogleSwitchInStock;

	@FindBy(xpath = "//mat-select[@aria-label='Items per page:']")
	private WebElement ddItemsPerPage;

	@FindBy(xpath = "//span[text()=' 100 ']")
	private WebElement ddPagePerItems;

	@FindBy(xpath = "//button[@aria-label='Next page']")
	private WebElement btnNextPage;

	@FindBy(xpath = "//button[@aria-label='Last page']")
	private WebElement btnLastPage;

	@FindBy(xpath = "//button[@aria-label='Previous page']")
	private WebElement btnPreviousPage;

	@FindBy(xpath = "//button[@aria-label='First page']")
	private WebElement btnFirstpage;

	@FindBy(xpath = "//div[contains(@class, 'toast-message')]")
	private WebElement alMsgItemsAdded;

	public WebElement getiProducts() {
		return iProducts;
	}

	public WebElement getMenuProducts() {
		return menuProducts;
	}

	public WebElement getLnkMonthlyPromotions() {
		return lnkMonthlyPromotions;
	}

	public WebElement getLnkShortDated() {
		return lnkShortDated;
	}

	public WebElement getLnkDollarItems() {
		return lnkDollarItems;
	}

	public WebElement getLnkNewItems() {
		return lnkNewItems;
	}

	public WebElement getLnkDurableMedicalEquipment() {
		return lnkDurableMedicalEquipment;
	}

	public WebElement getTitleProductCatalog() {
		return titleProductCatalog;
	}

	public WebElement getLnkOverTheCounter() {
		return lnkOverTheCounter;
	}

	public WebElement getViewlinkFullView() {
		return viewlinkFullView;
	}

	public WebElement getViewLinkCompactView() {
		return viewLinkCompactView;
	}

	public WebElement getBtnAdd() {
		return btnAdd;
	}

	public WebElement getBtnCreateNewOrder() {
		return btnCreateNewOrder;
	}

	public WebElement getTxtOrderName() {
		return txtOrderName;
	}

	public WebElement getBtnCreate() {
		return btnCreate;
	}

	public WebElement getAlertSuccessMessageOrderCreation() {
		return alertSuccessMessageOrderCreation;
	}

	public WebElement getDdOrderName() {
		return ddOrderName;
	}

	public WebElement getTxtQty() {
		return txtQty;
	}

	public WebElement getTxtOrderQty() {
		return txtOrderQty;
	}

	public WebElement getBtnAddToOrder() {
		return btnAddToOrder;
	}

	public WebElement getToogleInStock() {
		return toogleInStock;
	}

	public WebElement getBtnYes() {
		return btnYes;
	}

	public WebElement getLnkProductCatalog() {
		return lnkProductCatalog;
	}

	public WebElement getLnkOTC() {
		return lnkOTC;
	}

	public WebElement getLnkCompactView() {
		return lnkCompactView;
	}

	public WebElement getToogleSwitchInStock() {
		return toogleSwitchInStock;
	}

	public WebElement getDdItemsPerPage() {
		return ddItemsPerPage;
	}

	public WebElement getDdPagePerItems() {
		return ddPagePerItems;
	}

	public WebElement getBtnNextPage() {
		return btnNextPage;
	}

	public WebElement getBtnLastPage() {
		return btnLastPage;
	}

	public WebElement getBtnPreviousPage() {
		return btnPreviousPage;
	}

	public WebElement getBtnFirstpage() {
		return btnFirstpage;
	}

	public WebElement getAlMsgItemsAdded() {
		return alMsgItemsAdded;
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
	 * @see Used to navigates to Product Catalog webpage
	 */
	public void navigatesProductCatalog() {
		scrollToElement(getiProducts());
		Actions action = new Actions(driver);
		action.moveToElement(getiProducts()).perform();
		clickElementUsingJavaScript(driver, getMenuProducts());

	}

	/**
	 * @see Used to select Durable MedicalEquipment
	 */
	public void navigatesDME() {
		navigatesProductCatalog();
		scrollToElement(getLnkDurableMedicalEquipment());
		clickElementUsingJavaScript(driver, getLnkDurableMedicalEquipment());

	}

	/**
	 * @see Used to clicks Full view in Product Search webpage
	 */
	public void clicksFullView() {
		elementToBeClickable(getViewlinkFullView());
		clickElementUsingJavaScript(driver, getViewlinkFullView());

	}

	/**
	 * @see Used to Used to create new order in Product search page
	 * @param orderName
	 * @param orderType
	 * @param autoSubmit
	 */
	public void createNewOrder(String orderName, String orderType, String autoSubmit) {
		try {
			scrollToElement(getBtnCreateNewOrder());
			clickElementUsingJavaScript(driver, getBtnCreateNewOrder());
			insertValue(getTxtOrderName(), orderName);
//		clickRadioButton(orderType);
			clickRadioButton(autoSubmit);
			clickElementUsingJavaScript(driver, getBtnCreate());
		} catch (Exception e) {

		}
	}

	/**
	 * @see Used to clicks Compact view in Product Search webpage
	 */
	public void clickCompactView() {
		elementToBeClickable(getViewLinkCompactView());
		clickElementUsingJavaScript(driver, getViewLinkCompactView());

	}

	/**
	 * @see Used to create New order in compact view - product catalog page
	 * @param orderName
	 * @param orderType
	 * @param autoSubmit
	 */
	public void compactViewOrderCreation(String orderName, String orderType, String autoSubmit) {
		elementToBeClickable(getBtnAdd());
		clickElementUsingJavaScript(driver, getBtnAdd());
		insertValue(getTxtOrderName(), orderName);
//		clickRadioButton(orderType);
		clickRadioButton(autoSubmit);
		clickElementUsingJavaScript(driver, getBtnCreate());
	}

	public void toggleSwitch() {
		// Wait until the mat-slide-toggle element is clickable
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement toggle = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//mat-slide-toggle")));

		// Check the current state of the toggle
		String classValue = toggle.getAttribute("class");
		if (classValue.contains("mat-checked")) {
			System.out.println("Toggle is currently ON, switching to OFF");
			// Click to turn off
		} else {
			System.out.println("Toggle is currently OFF, switching to ON");
			toggle.click(); // Click to turn on
		}
	}

	public void multipleOrderCreation(String ddOrderNames) {

		implicitWait();
		int count = 15;
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

		for (int i = 6; i <= count; i++) {
			try {

			String dynamicXPathForDropdown = "(//select[@formcontrolname='regularOrderArr'])[" + i + "]";
			WebElement orderDropdown = driver.findElement(By.xpath(dynamicXPathForDropdown));
			System.out.println(orderDropdown);
			implicitWait();
			scrollToElement(orderDropdown);
			Select dropdown = new Select(orderDropdown);
			dropdown.selectByVisibleText(" 12AB Sample test auto - Regular");

			String dynamicXPathForQtyField = "(//input[@placeholder='Qty'])[" + i + "]";
			implicitWait();
			WebElement qtyField = driver.findElement(By.xpath(dynamicXPathForQtyField));
			qtyField.clear();
			qtyField.sendKeys("1");
			String dynamicXPathForAddButton = "(//button[text()='Add'])[" + i + "]";

			WebElement addButton = driver.findElement(By.xpath(dynamicXPathForAddButton));
			clickElementUsingJavaScript(driver, addButton);
			System.out.println(addButton);
			try {
				String text = getText(getAlMsgItemsAdded());
				System.out.println(text);
			} catch (Exception e) {

			}
			try {
				WebElement caseItems = wait.until(ExpectedConditions
						.visibilityOfElementLocated(By.xpath("//mat-dialog-container[@role='dialog'][1]")));
				if (caseItems.isDisplayed()) {
					clickElementUsingJavaScript(driver, btnYes);
				}
			} catch (Exception e) {

			}
			} catch (StaleElementReferenceException e) {
				retryOrderCreation(i, ddOrderNames, wait);
			}
		}

	}

	public void retryOrderCreation(int index, String ddOrderNames, WebDriverWait wait) {

		String dynamicXPathForDropdown = "(//select[@formcontrolname='regularOrderArr'])[" + index + "]";
		WebElement orderDropdown = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath(dynamicXPathForDropdown)));

		scrollToElement(orderDropdown);
		Select dropdown = new Select(orderDropdown);
		dropdown.selectByVisibleText(" 12AB Sample test auto - Regular");

		String dynamicXPathForQtyField = "(//input[@placeholder='Qty'])[" + index + "]";
		WebElement qtyField = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(dynamicXPathForQtyField)));

		qtyField.clear();
		qtyField.sendKeys("6");

		String dynamicXPathForAddButton = "(//button[text()='Add'])[" + index + "]";
		WebElement addButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(dynamicXPathForAddButton)));
		clickElementUsingJavaScript(driver, addButton);
	}

	public void toogleOnInStockIems() {
		clickElementUsingJavaScript(driver, getToogleSwitchInStock());

	}

	public void navigatesOTC() {
		clickElementUsingJavaScript(driver, getLnkProductCatalog());
		clickElementUsingJavaScript(driver, getLnkOTC());

	}

	public void addProduct(String orderName) {
		int count = 10;

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		for (int i = 2; i <= count; i++) {
			try {
				String dynamicXPathBtnAdd = "(//button[text()='Add'])[" + i + "]";
				WebElement btnAdd = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(dynamicXPathBtnAdd)));
				System.out.println(btnAdd);
				clickElementUsingJavaScript(driver, btnAdd);
				Select dropdown = new Select(getDdOrderName());
				dropdown.selectByVisibleText(" 12AB Sample test auto - Regular");
				clearTextField(getTxtOrderQty());
				insertValue(getTxtOrderQty(), "1");
				clickElementUsingJavaScript(driver, getBtnAddToOrder());
				String text = getText(getAlMsgItemsAdded());
				System.out.println(text);
			} catch (Exception e) {

			}
		}
	}
}
