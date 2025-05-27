package com.adminUserPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;

public class ClosedC2ReturnsPage extends BaseClass {

	public ClosedC2ReturnsPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//h2[@class='breadcrumb-title']")
	private WebElement titleOpenC2Returns;

	@FindBy(xpath = "//input[@placeholder='Member Number']")
	private WebElement txtMemberNumber;

	@FindBy(xpath = "(//mat-select[@placeholder='Select Assignee'])[1]")
	private WebElement ddAssignee;

	@FindBy(xpath = "(//mat-select[@placeholder='Select status'])[1]")
	private WebElement ddStatus;

	@FindBy(xpath = "(//input[@formcontrolname='startDate'])[1]")
	private WebElement txtStartDate;

	@FindBy(xpath = "(//input[@formcontrolname='endDate'])[1]")
	private WebElement txtEndDate;

	@FindBy(xpath = "(//input[@placeholder='Search for Return Name, DEA Form#, Member'])")
	private WebElement txtSearch;

	@FindBy(xpath = "//i[@class='fa fa-search']")
	private WebElement iSearch;

	@FindBy(xpath = "//i[@class='fa fa-filter']")
	private WebElement btnFilter;

	@FindBy(xpath = "//button[text()='Clear Filter ']")
	private WebElement btnClearFilter;

	@FindBy(xpath = "//td[@role='gridcell']//a")
	private WebElement lnkReturnName;

	@FindBy(xpath = "(//img[@src='assets/icons/reopen_window.svg'])[1]")
	private WebElement iReopen;

	@FindBy(xpath = "//button[@class='btn btn-primary modal-btn']")
	private WebElement btnYes;

	public WebElement getTitleOpenC2Returns() {
		return titleOpenC2Returns;
	}

	public WebElement getTxtMemberNumber() {
		return txtMemberNumber;
	}

	public WebElement getDdAssignee() {
		return ddAssignee;
	}

	public WebElement getDdStatus() {
		return ddStatus;
	}

	public WebElement getTxtStartDate() {
		return txtStartDate;
	}

	public WebElement getTxtEndDate() {
		return txtEndDate;
	}

	public WebElement getTxtSearch() {
		return txtSearch;
	}

	public WebElement getiSearch() {
		return iSearch;
	}

	public WebElement getBtnFilter() {
		return btnFilter;
	}

	public WebElement getBtnClearFilter() {
		return btnClearFilter;
	}

	public WebElement getLnkReturnName() {
		return lnkReturnName;
	}

	public WebElement getiReopen() {
		return iReopen;
	}

	public WebElement getBtnYes() {
		return btnYes;
	}

}
