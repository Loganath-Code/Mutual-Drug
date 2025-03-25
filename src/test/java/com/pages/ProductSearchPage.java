package com.pages;

import java.lang.reflect.Constructor;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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
}
