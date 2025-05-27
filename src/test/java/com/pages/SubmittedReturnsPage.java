package com.pages;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;

public class SubmittedReturnsPage extends BaseClass {

	public SubmittedReturnsPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//h2[@class='breadcrumb-title']")
	private WebElement bcTitle;

	@FindBy(xpath = "//input[@formcontrolname='generalSearch']")
	private WebElement searchReturns;

	@FindBy(xpath = "//div[@class='filter']//i[@class='fa fa-search']")
	private WebElement iSearch;

	@FindBy(xpath = "//mat-select[@name='orderType']")
	private WebElement ddOrderType;

	@FindBy(xpath = "//input[@formcontrolname='submittedFrom']")
	private WebElement txtSubmittedFormDate;

	@FindBy(xpath = "//input[@formcontrolname='submittedTo']")
	private WebElement txtSubmittedToDate;

	@FindBy(xpath = "//button[@class='search-btn']")
	private WebElement btnSearch;

	@FindBy(xpath = "//button[@class='clear-btn']")
	private WebElement btnClear;

	@FindBy(xpath = "//a[@class='breadcrumb-link']")
	private WebElement bclink;

	@FindBy(xpath = "(//td[@role='gridcell']//a)[1]")
	private WebElement tdReturnNamelink;

	public WebElement getBcTitle() {
		return bcTitle;
	}

	public WebElement getSearchReturns() {
		return searchReturns;
	}

	public WebElement getiSearch() {
		return iSearch;
	}

	public WebElement getDdOrderType() {
		return ddOrderType;
	}

	public WebElement getTxtSubmittedFormDate() {
		return txtSubmittedFormDate;
	}

	public WebElement getTxtSubmittedToDate() {
		return txtSubmittedToDate;
	}

	public WebElement getBtnSearch() {
		return btnSearch;
	}

	public WebElement getBtnClear() {
		return btnClear;
	}

	public WebElement getBclink() {
		return bclink;
	}

	public WebElement getTdReturnNamelink() {
		return tdReturnNamelink;
	}
	
	public void searchReturns(String search) {
		elementVisibility(getSearchReturns());
		insertValue(getSearchReturns(), search);
		clickElementUsingJavaScript(driver, getiSearch());
	}
	
	public void filters(String orderType, String formDate, String toDate) {
		selectOptionDropDown(getDdOrderType(), orderType);
		insertValue(getTxtSubmittedFormDate(), formDate);
		insertValue(getTxtSubmittedToDate(), toDate);
		clickElementUsingJavaScript(driver, getBtnSearch());
	}
	public void clearDetails() {
		elementToBeClickable(getBtnClear());
		clickElementUsingJavaScript(driver, getBtnClear());
		
	}
	public void typeFilter(String orderType) {
		selectOptionDropDown(getDdOrderType(), orderType);
		clickElementUsingJavaScript(driver, getBtnSearch());
	}
	public void dateFilters(String formDate, String toDate) {
		insertValue(getTxtSubmittedFormDate(), formDate);
		insertValue(getTxtSubmittedToDate(), toDate);
		clickElementUsingJavaScript(driver, getBtnSearch());

	}
	public void verifySubmittedReturnsDateRange(String fromDateStr, String toDateStr) {
	    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
	    LocalDate fromDate = LocalDate.parse(fromDateStr, formatter);
	    LocalDate toDate = LocalDate.parse(toDateStr, formatter);

	    // Locate all return date elements (Update the locator as per your app)
	    List<WebElement> dateElements = driver.findElements(By.xpath("//table//tr//td[3]"));

	    for (WebElement dateElement : dateElements) {
	        String dateText = dateElement.getText().trim();
	        LocalDate returnDate = LocalDate.parse(dateText, formatter);

	        Assert.assertTrue("Return date " + returnDate + " is before the from date", !returnDate.isBefore(fromDate));
	        Assert.assertTrue("Return date " + returnDate + " is after the to date", !returnDate.isAfter(toDate));
	    }
	}
}
