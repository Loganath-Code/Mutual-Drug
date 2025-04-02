package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;

import io.cucumber.java.sl.Privzeto;

public class TemplatesPage extends BaseClass {

	public TemplatesPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//h2[text()='Order Templates']")
	private WebElement titleOrderTemplates;

	@FindBy(xpath = "(//a[@href='/member/orders/current-orders'])[2]")
	private WebElement bCrumbLinkCurrentOrder;

	@FindBy(xpath = "//input[@placeholder='Search for Order Templates']")
	private WebElement txtSearchTemplates;

	@FindBy(xpath = "(//button[@class='search'])[2]")
	private WebElement iSearchTemplates;

	@FindBy(xpath = "(//th[@role='columnheader'])[1]")
	private WebElement thTemplates;

	@FindBy(xpath = "(//th[@role='columnheader'])[2]")
	private WebElement thCreatedDate;

	@FindBy(xpath = "(//th[@role='columnheader'])[3]")
	private WebElement thOrderType;

	@FindBy(xpath = "(//th[@role='columnheader'])[4]")
	private WebElement thTotalLines;

	@FindBy(xpath = "(//i[@class='fa fa-trash'])[1]")
	private WebElement iTrash;

	@FindBy(xpath = "//button[@class='btn btn-primary modal-btn']")
	private WebElement btnYes;

	@FindBy(xpath = "//div[@aria-label='Template deleted successfully!']")
	private WebElement alertMessageDeleteTemplate;

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

	public WebElement getTitleOrderTemplates() {
		return titleOrderTemplates;
	}

	public WebElement getbCrumbLinkCurrentOrder() {
		return bCrumbLinkCurrentOrder;
	}

	public WebElement getTxtSearchTemplates() {
		return txtSearchTemplates;
	}

	public WebElement getiSearchTemplates() {
		return iSearchTemplates;
	}

	public WebElement getThTemplates() {
		return thTemplates;
	}

	public WebElement getThCreatedDate() {
		return thCreatedDate;
	}

	public WebElement getThOrderType() {
		return thOrderType;
	}

	public WebElement getThTotalLines() {
		return thTotalLines;
	}

	public WebElement getiTrash() {
		return iTrash;
	}

	public WebElement getBtnYes() {
		return btnYes;
	}

	public WebElement getAlertMessageDeleteTemplate() {
		return alertMessageDeleteTemplate;
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

	/**
	 * @see Used to search template Name
	 */

	public void searchTemplate(String templateName) {
		elementVisibility(getTxtSearchTemplates());
		insertValue(getTxtSearchTemplates(), templateName);
		clickElementUsingJavaScript(driver, getiSearchTemplates());
	}

	/**
	 * @see Used to perform Sorting o
	 */

	public void sortingTemplates() {
		String[] columnNames = { "Templates", "Created date", "Order Type", "Total lines" };

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
				System.out.println("✅ Column '" + columnNames[i] + "' is initially sorted in ascending order.");

				clickElementUsingJavaScript(driver, columnHeader);
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

				ariaSort = columnHeader.getAttribute("aria-sort");
				System.out.println("Sorting Order After Click for '" + columnNames[i] + "': " + ariaSort);

				if ("descending".equals(ariaSort)) {
					System.out.println("✅ Column '" + columnNames[i] + "' is now sorted in descending order.");
				} else {
					System.out.println("❌ Column '" + columnNames[i] + "' is NOT sorted in descending order.");
				}
			} else if ("descending".equals(ariaSort)) {
				System.out.println("✅ Column '" + columnNames[i] + "' is initially sorted in descending order.");

				clickElementUsingJavaScript(driver, columnHeader);
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

				ariaSort = columnHeader.getAttribute("aria-sort");
				System.out.println("Sorting Order After Click for '" + columnNames[i] + "': " + ariaSort);

				// Verify it's in ascending order after second click
				if ("ascending".equals(ariaSort)) {
					System.out.println("✅ Column '" + columnNames[i] + "' is now sorted in ascending order.");
				} else {
					System.out.println("❌ Column '" + columnNames[i] + "' is NOT sorted in ascending order.");
				}
			} else {
				System.out.println("Sorting order could not be determined for column '" + columnNames[i] + "'.");
			}
		}
	}

	public void deleteTemplates() {
		clickElementUsingJavaScript(driver, getiTrash());
		clickElementUsingJavaScript(driver, getBtnYes());

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

}
