package com.pages;

import java.lang.reflect.Constructor;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
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

	@FindBy(xpath = "//span[text()='Full View ']")
	private WebElement btnFullView;

	@FindBy(xpath = "//span[text()='Customer View ']")
	private WebElement btnCustomerView;

	@FindBy(xpath = "//i[@class='fa fa-print']")
	private WebElement btnPrint;

	@FindBy(xpath = "//input[@placeholder='Qty']")
	private WebElement txtQty;

	@FindBy(xpath = "//select[@name='orderId']")
	private WebElement ddOrderName;

	@FindBy(xpath = "//button[text()='Add to Order']")
	private WebElement btnAddToOrder;

	@FindBy(xpath = "(//button[text()='Create New Order'])[1]")
	private WebElement btnCreateNewOrder;

	@FindBy(xpath = "(//mat-accordion[@class='mat-accordion']//child::button[text()='Create New Order'])[1]")
	private WebElement btnCreateNewOrderSuggestionTab;

	@FindBy(xpath = "(//mat-accordion[@class='mat-accordion']//child::input[@placeholder='Qty'])[1]")
	private WebElement txtQtySuggestionProduct;

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

	@FindBy(xpath = "(//input[@placeholder='Qty'])[2]")
	private WebElement txtQtySuggest;

	@FindBy(xpath = "(//select[@formcontrolname='regularOrderArr'])[1]")
	private WebElement ddOrderNameSuggest;

	@FindBy(xpath = "(//button[text()='Add'])[1]")
	private WebElement btnAddSuggest;

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

	@FindBy(xpath = "//div[@aria-label='Success!']")
	private WebElement alertSuccessMessage;

	public WebElement getBtnFullView() {
		return btnFullView;
	}

	public WebElement getBtnCustomerView() {
		return btnCustomerView;
	}

	public WebElement getBtnPrint() {
		return btnPrint;
	}

	public WebElement getTxtQty() {
		return txtQty;
	}

	public WebElement getDdOrderName() {
		return ddOrderName;
	}

	public WebElement getBtnAddToOrder() {
		return btnAddToOrder;
	}

	public WebElement getAlertMessageItemAddedNotificationGroup() {
		return alertMessageItemAddedNotificationGroup;
	}

	public WebElement getBtnCreateNewOrder() {
		return btnCreateNewOrder;
	}

	public WebElement getBtnCreateNewOrderSuggestionTab() {
		return btnCreateNewOrderSuggestionTab;
	}

	public WebElement getTxtQtySuggestionProduct() {
		return txtQtySuggestionProduct;
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

	public WebElement getTxtQtySuggest() {
		return txtQtySuggest;
	}

	public WebElement getDdOrderNameSuggest() {
		return ddOrderNameSuggest;
	}

	public WebElement getBtnAddSuggest() {
		return btnAddSuggest;
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

	public WebElement getAlertSuccessMessage() {
		return alertSuccessMessage;
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

	public void addQty(String qty) {
		elementVisibility(getTxtQty());
		insertValue(getTxtQty(), qty);

	}

	public void clicksAddToOrder() {
		elementVisibility(getBtnAddToOrder());
		clickElementUsingJavaScript(driver, getBtnAddToOrder());
	}

	public void selectOrderName(String OrderName) {
		selectByVisibleText(getDdOrderName(), OrderName);

	}

	public void addAlreadyAddedItem(String updateQty, String selectOrderName) {
		addQty(updateQty);
		selectOrderName(selectOrderName);
		clicksAddToOrder();
	}

	public void updateSuggestItem(String selectOrderName, String updateQty) {
//		try {
		scrollToElement(getDdOrderNameSuggest());
		selectByVisibleText(getDdOrderNameSuggest(), selectOrderName);
		insertValue(getTxtQtySuggest(), updateQty);
		getTxtQtySuggest().sendKeys(Keys.ENTER);
		clickElementUsingJavaScript(driver, getBtnAddSuggest());
//		} catch (Exception e) {
//
//		}
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
				ExpectedConditions.elementToBeClickable(By.xpath("//mat-option//span[text()='" + optionText + " ']")));
		scrollToElement(option);
		clickElementUsingJavaScript(driver, option);
	}

	public void notifyMe(String globalSearchitem, String chooseNotificationGroup, String email, String phoneNo,
			String alertMessage) {
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

	public void removeOrderName() {
		elementVisibility(getTxtOrderName());
		getTxtOrderName().sendKeys(Keys.chord(Keys.CONTROL, "a"));
		getTxtOrderName().sendKeys(Keys.BACK_SPACE);
		click(getBtnCreate());
	}

	public void orderNameValidation(String orderName) {
		elementVisibility(getTxtOrderName());
		insertValue(getTxtOrderName(), orderName);
		click(getBtnCreate());

	}

	public void suggestedProductOrderCreationValidations() throws InterruptedException {
		scrollToElement(getBtnCreateNewOrderSuggestionTab());
		Thread.sleep(2000);
		clickElementUsingJavaScript(driver, getBtnCreateNewOrderSuggestionTab());

	}

	public void validateQuantityFieldInput(WebElement qtyField, String input) {
	    try {
	        qtyField.clear();
	        qtyField.sendKeys(input);
	        qtyField.sendKeys(Keys.TAB); // Trigger blur/validation logic

	        String actualValue = qtyField.getAttribute("value");
	        System.out.println("Input: '" + input + "' | Field Value After Entry: '" + actualValue + "'");

	        if (!actualValue.equals(input)) {
	            System.out.println("Field rejected part of the input as expected (trimmed to: " + actualValue + "')");
	        } else {
	            System.out.println("Input accepted as-is.- Field accepted full input as expected.");
	        }

	    } catch (Exception e) {
	        System.out.println("Exception while validating quantity field: " + e.getMessage());
	        Assert.fail("Test failed due to exception: " + e.getMessage());
	    }
	}
	public void validateQuantityFieldInput(WebElement qtyField, String input, String expectedBehavior) {
		try {
			qtyField.clear();
			qtyField.sendKeys(input);
			qtyField.sendKeys(Keys.TAB); 

			String actualValue = qtyField.getAttribute("value");
			System.out.println("Input: '" + input + "' | Field Value: '" + actualValue + "'");
			boolean wasTrimmed = !actualValue.equals(input); 
			if ("accept".equalsIgnoreCase(expectedBehavior)) {
				Assert.assertEquals("Field did not accept full input.", input, actualValue);
				System.out.println("Field accepted full input as expected.");
			} else if ("reject".equalsIgnoreCase(expectedBehavior)) {
				Assert.assertTrue("Field accepted input when it should have been rejected.", wasTrimmed);
				System.out.println("Field rejected part of the input as expected (trimmed to: '" + actualValue + "').");
			} else {
				System.out.println(" Unknown expected behavior. Use 'accept' or 'reject'.");
			}
		} catch (Exception e) {
			System.out.println("Exception while validating quantity field: " + e.getMessage());
			Assert.fail("Test failed due to exception: " + e.getMessage());
		}
	}
	
	public void validateQtyInputs(WebElement qtyField) throws InterruptedException {
	    List<String> inputs = Arrays.asList(
	        "1234", "999", "1000", "1111",
	        "-11", "0.01", "3/4", "2%50",
	        "-1234", "abc", "0010");

	    for (String input : inputs) {
	        boolean shouldAccept = input.matches("^\\d{1,3}$");
	        clearField(qtyField);
	        Thread.sleep(800);
	        qtyField.sendKeys(input);
	        qtyField.sendKeys(Keys.TAB);  
	        String actual = qtyField.getAttribute("value");
	        System.out.printf("Input: '%s' | Expected: %s | Actual: '%s'%n",input,shouldAccept ? "accept" : "reject",actual);
	        if (shouldAccept) {	          
	            Assert.assertEquals("Expected to accept but did not: " + input,input, actual);
	            System.out.println("Accepted as expected: " + input);
	        } else {	            
	            Assert.assertTrue( " Expected to reject but accepted full input: " + input,!actual.equals(input));
	            System.out.println("Rejected as expected: input='" 
	                                + input + "' → actual='" + actual + "'");
	        }
	    }
	}
}
