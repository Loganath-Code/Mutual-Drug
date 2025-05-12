package com.adminUserPages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;



public class DetailsPage extends BaseClass {

	public DetailsPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//h2[text()='Members']")
	private WebElement titleMembers;

	@FindBy(xpath = "//input[@placeholder='Search for Member Users']")
	private WebElement txtSearchMembers;

	@FindBy(xpath = "//i[@class='fa fa-search']")
	private WebElement iSearch;

	@FindBy(xpath = "//tr[1]//td[2]")
	private WebElement tdMemberNumberFirstcell;

	@FindBy(xpath = "//tr[2]//td[2]")
	private WebElement tdMemberNumberSecondcell;

	@FindBy(xpath = "(//td[@role='gridcell'])[1]")
	private WebElement tdMemberName;

	@FindBy(xpath = "(//td[@role='gridcell'])[2]")
	private WebElement tdMemberNumber;

	@FindBy(xpath = "//form[@name='memberUserDetailsForm']")
	private WebElement memberUserDetails;

	@FindBy(xpath = "//i[@class='fa fa-times']")
	private WebElement iClose;

	@FindBy(xpath = "(//td[text()='PREMIER']//following::input[@type='checkbox'])[1]")
	private WebElement cbxRxPurchaseChartPremier;

	@FindBy(xpath = "(//td[text()='PRO']//following::input[@type='checkbox'])[1]")
	private WebElement cbxRxPurchaseChartPro;

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
	
	@FindBy(xpath = "//div[@aria-label='Invoice Chart status has been updated.']")
	private WebElement successMessageRxchartUpdate;

	public WebElement getTitleMembers() {
		return titleMembers;
	}

	public WebElement getTxtSearchMembers() {
		return txtSearchMembers;
	}

	public WebElement getiSearch() {
		return iSearch;
	}

	public WebElement getTdMemberNumberFirstcell() {
		return tdMemberNumberFirstcell;
	}

	public WebElement getTdMemberNumberSecondcell() {
		return tdMemberNumberSecondcell;
	}

	public WebElement getTdMemberName() {
		return tdMemberName;
	}

	public WebElement getTdMemberNumber() {
		return tdMemberNumber;
	}

	public WebElement getMemberUserDetails() {
		return memberUserDetails;
	}

	public WebElement getiClose() {
		return iClose;
	}

	public WebElement getCbxRxPurchaseChartPremier() {
		return cbxRxPurchaseChartPremier;
	}

	public WebElement getCbxRxPurchaseChartPro() {
		return cbxRxPurchaseChartPro;
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

	public WebElement getSuccessMessageRxchartUpdate() {
		return successMessageRxchartUpdate;
	}

	/**
	 * @see Used to search members details
	 * @param searchMemberUserRoles
	 */
	public void search(String searchMemberUserRoles) {
		elementVisibility(getTxtSearchMembers());
		insertValue(getTxtSearchMembers(), searchMemberUserRoles);
		click(getiSearch());

	}

	/**
	 * @see Used to perform sortinf functionality
	 */

	public void sortingFunction() {
		String[] columnNames = { "Name", "Member Number" };

		for (int i = 0; i < columnNames.length; i++) {

			WebElement columnHeader = driver.findElement(By.xpath("(//th[@role='columnheader'])[" + (i + 1) + "]"));

			clickElementUsingJavaScript(driver, columnHeader);

			try {

				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			String ariaSort = columnHeader.getAttribute("aria-sort");
			System.out.println("Initial Sorting Order for '" + columnNames[i] + "': " + ariaSort);
			if ("ascending".equals(ariaSort)) {
				System.out.println("column '" + columnNames[i] + "' is initially sorted in ascending order.");

				clickElementUsingJavaScript(driver, columnHeader);
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

				ariaSort = columnHeader.getAttribute("aria-sort");
				System.out.println("Sorting Order After Click for '" + columnNames[i] + "': " + ariaSort);

				if ("descending".equals(ariaSort)) {
					System.out.println(" Column '" + columnNames[i] + "' is now sorted in descending order.");
				} else {
					System.out.println(" Column '" + columnNames[i] + "' is NOT sorted in descending order.");
				}
			} else if ("descending".equals(ariaSort)) {
				System.out.println(" Column '" + columnNames[i] + "' is initially sorted in descending order.");

				clickElementUsingJavaScript(driver, columnHeader);
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

				ariaSort = columnHeader.getAttribute("aria-sort");
				System.out.println("Sorting Order After Click for '" + columnNames[i] + "': " + ariaSort);

				if ("ascending".equals(ariaSort)) {
					System.out.println(" Column '" + columnNames[i] + "' is now sorted in ascending order.");
				} else {
					System.out.println(" Column '" + columnNames[i] + "' is NOT sorted in ascending order.");
				}
			} else {
				System.out.println("Sorting order could not be determined for column '" + columnNames[i] + "'.");
			}
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
	public void selectRxPurchaseChart() {
		 WebElement checkbox = driver.findElement(By.xpath("(//td[text()='PREMIER'])[1]/ancestor::tr//mat-checkbox"));
		    String classAttribute = checkbox.getAttribute("class");

		    if (!classAttribute.contains("mat-checkbox-checked")) {
		        checkbox.click();
		        System.out.println("Rx Chart checkbox was not selected. Selected now.");
		    } else {
		        System.out.println("Rx Chart checkbox already selected. No action needed.");
		    }
	}
	
	public void rxChartVisibility() {
		try {
	        WebElement rxChart = driver.findElement(By.xpath("//mat-panel-title[text()=' RX Purchase Chart ']")); 
	        Assert.assertTrue("Rx Chart should be visible to the member.", rxChart.isDisplayed());
	        System.out.println("Rx Chart is visible for the member.");
	    } catch (NoSuchElementException e) {
	        System.out.println(" Rx Chart is NOT visible for the member.");
	        Assert.fail("Rx Chart not visible when it should be.");
	    }
	}
}
