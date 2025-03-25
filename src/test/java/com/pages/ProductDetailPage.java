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
 * @see Used to find the locators assign the values in Product Detail webpage
 * @Date 14-Feb-2025
 */
public class ProductDetailPage extends BaseClass {
	/**
	 * @see Constructor Used to initialize the values
	 */
	public ProductDetailPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "(//button[text()='Create New Order'])[1]")
	private WebElement btnCreateNewOrder;

	@FindBy(xpath = "(//mat-accordion[@class='mat-accordion']//child::button[text()='Create New Order'])[1]")
	private WebElement btnCreateNewOrderSuggestionTab;

	@FindBy(xpath = "//mat-expansion-panel-header[@role='button']//div")
	private WebElement matExpander;

	@FindBy(xpath = "//input[@name='orderName']")
	private WebElement txtOrderName;

	@FindBy(xpath = "//button[text()='Create']")
	private WebElement btnCreate;

	@FindBy(xpath = "//div[@aria-label='Success!']")
	private WebElement alertSuccessMessageOrderCreation;

	@FindBy(xpath = "//button[@class='btn btn-primary modal-btn']")
	private WebElement btnYes;

	@FindBy(xpath = "//div[@aria-label='Product added to order.']")
	private WebElement alertMessage_Ordercreation;
	
	@FindBy(xpath = "//input[@name='searchProduct']")
	private WebElement txtGlobalSearch;
	
	@FindBy(xpath = "//i[@class='fa fa-search']")
	private WebElement iGlobalSearch;

	@FindBy(xpath = "//button[@class='create-btn notify-Me']")
	private WebElement btnNotifyMe;

	@FindBy(xpath = "//mat-select[@name='chooseNotificationGroup']")
	private WebElement ddChooseNotificationGroup;

	@FindBy(xpath = "//input[@name='emailId']")
	private WebElement txtEmail;

	@FindBy(xpath = "(//input[@name='phoneNumber'])[2]")
	private WebElement txtPhoneNumber;

	@FindBy(xpath = "//button[text()='Notify Me']")
	private WebElement btnNotifyMeAl;
	
	@FindBy(xpath = "//div[@aria-label='Item #372904 added in the Notification group!']")
	private WebElement alertMessageItemAddedNotificationGroup;
	

	public WebElement getBtnCreateNewOrder() {
		return btnCreateNewOrder;
	}

	public WebElement getBtnCreateNewOrderSuggestionTab() {
		return btnCreateNewOrderSuggestionTab;
	}

	public WebElement getMatExpander() {
		return matExpander;
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

	public WebElement getBtnYes() {
		return btnYes;
	}

	public WebElement getAlertMessage_Ordercreation() {
		return alertMessage_Ordercreation;
	}

	public WebElement getTxtGlobalSearch() {
		return txtGlobalSearch;
	}

	public WebElement getiGlobalSearch() {
		return iGlobalSearch;
	}

	public WebElement getBtnNotifyMe() {
		return btnNotifyMe;
	}

	public WebElement getDdChooseNotificationGroup() {
		return ddChooseNotificationGroup;
	}

	public WebElement getTxtEmail() {
		return txtEmail;
	}

	public WebElement getTxtPhoneNumber() {
		return txtPhoneNumber;
	}

	public WebElement getBtnNotifyMeAl() {
		return btnNotifyMeAl;
	}

	public WebElement getAlertMessageItemAddedNotificationGroup(String globalSearchitem) {
		return driver.findElement(By.xpath("//div[contains(@aria-label, 'Item #" + globalSearchitem + "')]"));
	}

	/**
	 * @see Used to create new regular order in suggested list
	 * @param orderName
	 * @param autoSubmit
	 * @throws InterruptedException
	 */
	public void createNewRegularOrder(String orderName, String autoSubmit) throws InterruptedException {
		scrollToElement(getBtnCreateNewOrderSuggestionTab());
		Thread.sleep(2000);
		clickElementUsingJavaScript(driver, getBtnCreateNewOrderSuggestionTab());
		elementVisibility(getTxtOrderName());
		insertValue(getTxtOrderName(), orderName);
		clickRadioButton(autoSubmit);
		clickElementUsingJavaScript(driver, getBtnCreate());
	}

	/**
	 * @see Used to create case items New order
	 * @param orderName
	 * @param autoSubmit
	 */
	public void caseItemOrder(String orderName, String autoSubmit) {
		clickElementUsingJavaScript(driver, getBtnCreateNewOrder());
		clickElementUsingJavaScript(driver, getBtnYes());
		insertValue(getTxtOrderName(), orderName);
		elementVisibility(getTxtOrderName());
		insertValue(getTxtOrderName(), orderName);
		clickRadioButton(autoSubmit);
		clickElementUsingJavaScript(driver, getBtnCreate());
	}

	/**
	 * @see Used create New order product detail page
	 * @param orderName
	 * @param autoSubmit
	 */
	public void createNewOrder(String orderName, String autoSubmit) {
		clickElementUsingJavaScript(driver, getBtnCreateNewOrder());
		elementVisibility(getTxtOrderName());
		insertValue(getTxtOrderName(), orderName);
		clickRadioButton(autoSubmit);
		clickElementUsingJavaScript(driver, getBtnCreate());

	}
	public void selectOptioninDropDown(WebDriver driver, WebElement dropdownElement, String optionText) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(dropdownElement));
		click(dropdownElement);
		WebElement option = wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("//mat-option//span[text()='"+ optionText + " ']")));
		scrollToElement(option);
		clickElementUsingJavaScript(driver, option);
	}
	public void notifyMe(String globalSearchitem, String chooseNotificationGroup, String email, String phoneNo, String alertMessage) {
		insertValue(getTxtGlobalSearch(), globalSearchitem);
		clickElementUsingJavaScript(driver, getiGlobalSearch());
		clickElementUsingJavaScript(driver, getBtnNotifyMe());
		selectOptioninDropDown(driver, getDdChooseNotificationGroup(), chooseNotificationGroup);
//		selectByVisibleText(getDdChooseNotificationGroup(), chooseNotificationGroup);
		insertValue(getTxtEmail(), email);
		insertValue(getTxtPhoneNumber(), phoneNo);
		clickElementUsingJavaScript(driver, getBtnNotifyMeAl());
		assertEquals(getAlertMessageItemAddedNotificationGroup(globalSearchitem), alertMessage);
	}
	public void emptyFieldsitemsAddinNotificationGroup() throws InterruptedException {
		clickElementUsingJavaScript(driver, getBtnNotifyMe());
		getTxtEmail().sendKeys(Keys.chord(Keys.CONTROL, "a"));
		getTxtEmail().sendKeys(Keys.BACK_SPACE);
		clearTextUsingjs(getTxtEmail());
		clearTextUsingjs(getTxtPhoneNumber());
		clickElementUsingJavaScript(driver, getBtnNotifyMeAl());

	}
	public void insertInvalidMail() {
		elementVisibility(getTxtEmail());
		clearTextUsingjs(getTxtEmail());
		insertValue(getTxtEmail(), "aw12@12");
		clickElementUsingJavaScript(driver, getBtnNotifyMeAl());
	}
	public void insertInvalidPhNo() {
		elementVisibility(getTxtPhoneNumber());
		insertValue(getTxtPhoneNumber(), "23456");
		clickElementUsingJavaScript(driver, getBtnNotifyMeAl());
	}
}
