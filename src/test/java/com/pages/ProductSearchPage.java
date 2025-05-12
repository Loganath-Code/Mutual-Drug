package com.pages;

import java.lang.reflect.Constructor;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.base.BaseClass;

/**
 * @see Used to find the locators assign the values in Product search webpage
 * @Date 13-Feb-2025
 */
public class ProductSearchPage extends BaseClass {
	/**
	 * @see Constructor Used to initialize the values
	 */
	public ProductSearchPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "(//select[@formcontrolname='regularOrderArr'])[1]")
	private WebElement ddSelectOrder;

	@FindBy(xpath = "(//input[@placeholder='Qty'])[1]")
	private WebElement txtQty;

	@FindBy(xpath = "(//button[text()='Add'])[1]")
	private WebElement btnAdd;

	@FindBy(xpath = "(//button[text()='Create New Order'])[1]")
	private WebElement btnCreateNewOrder;

	@FindBy(xpath = "//input[@name='orderName']")
	private WebElement txtOrderName;

	@FindBy(xpath = "//button[text()='Create']")
	private WebElement btnCreate;

	@FindBy(xpath = "//div[@aria-label='Success!']")
	private WebElement alertSuccessMessage;
	// itemAlreadyexist

	@FindBy(xpath = "//input[@placeholder='Order Qty']")
	private WebElement txtOrderQty;

	@FindBy(xpath = "//select[@formcontrolname='specialCode']")
	private WebElement ddSpecialCode;

	@FindBy(xpath = "//button[text()='Update']")
	private WebElement btnUpdate;

	@FindBy(xpath = "//h4[text()='Item Already Exist']")
	private WebElement modaltitle;

	public WebElement getDdSelectOrder() {
		return ddSelectOrder;
	}

	public WebElement getTxtQty() {
		return txtQty;
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

	public WebElement getAlertSuccessMessage() {
		return alertSuccessMessage;
	}

	public WebElement getTxtOrderQty() {
		return txtOrderQty;
	}

	public WebElement getDdSpecialCode() {
		return ddSpecialCode;
	}

	public WebElement getBtnUpdate() {
		return btnUpdate;
	}

	public WebElement getModaltitle() {
		return modaltitle;
	}

	/**
	 * @see Used to create New order in product search webpage
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

	public void addQuantity(String qty) {
		elementVisibility(getTxtQty());
		insertValue(getTxtQty(), qty);

	}

	public void updateAlreadyAddedItemToOrder(String selectOrderName,String updateQty, String titleItemAlreadyExist, String qtyUpdate, String specialCode, String successMessage) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

		String dropdownXPath = "(//select[@formcontrolname='regularOrderArr'])[1]";
		WebElement orderDropdown = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(dropdownXPath)));
		scrollToElement(orderDropdown);
		Select dropdown = new Select(orderDropdown);
		dropdown.selectByVisibleText(selectOrderName.trim());
		String qtyFieldXPath = "(//input[@placeholder='Qty'])[1]";
		WebElement qtyField = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(qtyFieldXPath)));
		qtyField.clear();
		qtyField.sendKeys(updateQty);
		String addButtonXPath = "(//button[text()='Add'])[1]";
		WebElement addButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(addButtonXPath)));
		clickElementUsingJavaScript(driver, addButton);
		assertEquals(getModaltitle(), titleItemAlreadyExist);
		elementVisibility(getTxtOrderQty());
		Thread.sleep(1000);
		WebElement qtyFieldUpdate = wait.until(ExpectedConditions.elementToBeClickable(getTxtOrderQty()));
		qtyFieldUpdate.clear();
		qtyFieldUpdate.sendKeys(qtyUpdate);
		List<WebElement> dropdowns = driver.findElements(By.xpath("//select[@formcontrolname='specialCode']"));
		if (!dropdowns.isEmpty() && dropdowns.get(0).isDisplayed()) {
			WebElement specialCodeDropdown = dropdowns.get(0);
			Select dropdownspecialCode = new Select(specialCodeDropdown);
			if (specialCode != null && !specialCode.trim().isEmpty()
					&& !"[empty]".equalsIgnoreCase(specialCode.trim())) {
				Thread.sleep(1000);
				try {
					dropdownspecialCode.selectByVisibleText(specialCode.trim());
				} catch (Exception e) {
					dropdownspecialCode.selectByValue(specialCode.trim());
				}
			} else {
				dropdownspecialCode.selectByIndex(0);
			}
		} else {
			System.out.println("Special Code dropdown is not present or not visible. Skipping this step.");		
		
		}
		Thread.sleep(800);
		clickElementUsingJavaScript(driver, getBtnUpdate());
		assertEquals(getAlertSuccessMessage(), successMessage);
	}
}
