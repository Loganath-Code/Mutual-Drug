package com.adminUserPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;

public class BannerMetricsPage extends BaseClass {

	public BannerMetricsPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//h2[text()='Banner Metrics']")
	private WebElement bcTitle;

	@FindBy(xpath = "//input[@placeholder='Member Number']")
	private WebElement txtMemberNumber;

	@FindBy(xpath = "//input[@placeholder='Banner Name']")
	private WebElement txtBannerName;

	@FindBy(xpath = "//input[@formcontrolname='startDate']")
	private WebElement txtStartDate;

	@FindBy(xpath = "//input[@formcontrolname='endDate']")
	private WebElement txtEndDate;

	@FindBy(xpath = "//form[@name='bannerMetricsFilterForm']//button[1]")
	private WebElement btnFilter;

	@FindBy(xpath = "//button[normalize-space()='Clear Filter']")
	private WebElement btnClearFilter;

	@FindBy(xpath = "//button[normalize-space()='Export']")
	private WebElement btnExport;

	@FindBy(xpath = "//div[contains(text(),'Start Date is required')]")
	private WebElement errorMessageStartDate;

	@FindBy(xpath = "//div[contains(text(),'End Date is required')]")
	private WebElement errorMessageEndDate;
	
	@FindBy(xpath = "//div[text()='End Date should not lesser than Start']")
	private WebElement errorMessageDateField;

	public WebElement getBcTitle() {
		return bcTitle;
	}

	public WebElement getTxtMemberNumber() {
		return txtMemberNumber;
	}

	public WebElement getTxtBannerName() {
		return txtBannerName;
	}

	public WebElement getTxtStartDate() {
		return txtStartDate;
	}

	public WebElement getTxtEndDate() {
		return txtEndDate;
	}

	public WebElement getBtnFilter() {
		return btnFilter;
	}

	public WebElement getBtnClearFilter() {
		return btnClearFilter;
	}

	public WebElement getBtnExport() {
		return btnExport;
	}

	public WebElement getErrorMessageStartDate() {
		return errorMessageStartDate;
	}

	public WebElement getErrorMessageEndDate() {
		return errorMessageEndDate;
	}

	public WebElement getErrorMessageDateField() {
		return errorMessageDateField;
	}
	
	public void memberNumber(String memberNumber) {
		insertValue(getTxtMemberNumber(), memberNumber);

	}
	
	public void bannerName(String bannerName) {
		insertValue(getTxtBannerName(), bannerName);

	}
	public void dateFields(String startDate, String endDate) {
		clearField(getTxtStartDate());
		insertValue(getTxtStartDate(), startDate);
		clearField(getTxtEndDate());
		insertValue(getTxtEndDate(), endDate);
	}
	public void clickFilter() {
		clickElementUsingJavaScript(driver, getBtnFilter());

	}

}
