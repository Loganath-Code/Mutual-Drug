package com.adminUserPages;

import java.time.Duration;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.base.BaseClass;

public class PlanogramsPage extends BaseClass {

	public PlanogramsPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//h2[text()='Planograms']")
	private WebElement titlePlanogram;

	@FindBy(xpath = "//h3[text()='Planogram Details']")
	private WebElement titlePlanogramDetails;

	@FindBy(xpath = "//button[text()='Add Planogram']")
	private WebElement btnAddPlanogram;

	@FindBy(xpath = "//h2[text()='Add Planogram ']")
	private WebElement titleAddPlanogram;

	@FindBy(xpath = "//input[@name='name']")
	private WebElement txtName;

	@FindBy(xpath = "//textarea[@name='description']")
	private WebElement txtDescription;

	@FindBy(xpath = "//input[@name='file']")
	private WebElement btnChooseFile;

	@FindBy(xpath = "//button[text()='Save']")
	private WebElement btnSave;

	@FindBy(xpath = "//button[text()='Update']")
	private WebElement btnUpdate;

	@FindBy(xpath = "//div[text()='Name is required ']")
	private WebElement errorMessageName;

	@FindBy(xpath = "//div[text()='Description is required ']")
	private WebElement errorMessageDescription;

	@FindBy(xpath = "//div[text()='File is required ']")
	private WebElement errorMessageFile;

	@FindBy(xpath = "//input[@placeholder='Search for Planograms']")
	private WebElement txtSearch;

	@FindBy(xpath = "//i[@class='fa fa-search']")
	private WebElement iSearch;

	@FindBy(xpath = "(//td[@role='gridcell']//a)[1]")
	private WebElement tdNameLink;

	@FindBy(xpath = "(//a[@target='_blank'])[1]")
	private WebElement iPdf;

	@FindBy(xpath = "(//i[@class='fa fa-trash'])[1]")
	private WebElement iDelete;

	@FindBy(xpath = "//button[@class='btn btn-primary modal-btn']")
	private WebElement btnYes;

	@FindBy(xpath = "//div[@aria-label='Planogram deleted.']")
	private WebElement toastMessagePlanogramDelete;

	public WebElement getTitlePlanogram() {
		return titlePlanogram;
	}

	public WebElement getTitlePlanogramDetails() {
		return titlePlanogramDetails;
	}

	public WebElement getBtnAddPlanogram() {
		return btnAddPlanogram;
	}

	public WebElement getTitleAddPlanogram() {
		return titleAddPlanogram;
	}

	public WebElement getTxtName() {
		return txtName;
	}

	public WebElement getTxtDescription() {
		return txtDescription;
	}

	public WebElement getBtnChooseFile() {
		return btnChooseFile;
	}

	public WebElement getBtnSave() {
		return btnSave;
	}

	public WebElement getBtnUpdate() {
		return btnUpdate;
	}

	public WebElement getErrorMessageName() {
		return errorMessageName;
	}

	public WebElement getErrorMessageDescription() {
		return errorMessageDescription;
	}

	public WebElement getErrorMessageFile() {
		return errorMessageFile;
	}

	public WebElement getTxtSearch() {
		return txtSearch;
	}

	public WebElement getiSearch() {
		return iSearch;
	}

	public WebElement getTdNameLink() {
		return tdNameLink;
	}

	public WebElement getiPdf() {
		return iPdf;
	}

	public WebElement getiDelete() {
		return iDelete;
	}

	public WebElement getBtnYes() {
		return btnYes;
	}

	public WebElement getToastMessagePlanogramDelete() {
		return toastMessagePlanogramDelete;
	}

	/**
	 * @see Used to clicks on Add Planograms
	 */
	public void clicksPlanogram() {
		elementToBeClickable(getBtnAddPlanogram());
		clickElementUsingJavaScript(driver, getBtnAddPlanogram());

	}

	/**
	 * @see Used to add planogram details
	 */
	public void createPlanogram(String name, String description) {
		insertValue(getTxtName(), name);
		insertValue(getTxtDescription(), description);
		getBtnChooseFile().sendKeys("C:\\Users\\nloga\\Downloads\\sample.pdf");

	}

	/**
	 * @see Used to click save button
	 */

	public void clicksSave() {
		clickElementUsingJavaScript(driver, getBtnSave());

	}

	/**
	 * @throws InterruptedException
	 * @see Used to search planogram
	 */
	public void searchPlanogram(String searchPlanogram) throws InterruptedException {
		elementVisibility(getTxtSearch());
		insertValue(getTxtSearch(), searchPlanogram);
		clickElementUsingJavaScript(driver, getiSearch());
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		String fn, ln, em;
		Thread.sleep(1500);
		try {
			fn = wait
					.until(ExpectedConditions
							.visibilityOfElementLocated(By.xpath("(//td[contains(@class,'mat-column-name ')])[1]")))
					.getText().trim();
			ln = wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("(//td[contains(@class,'mat-column-description ')])[1]")))
					.getText().trim();
			em = wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("(//td[contains(@class,'mat-column-createdDt ')])[1]")))
					.getText().trim();
		} catch (TimeoutException e) {
			Assert.fail("No search results displayed for term: " + searchPlanogram);
			return;
		}

		boolean anyMatch = searchPlanogram.equals(fn) || searchPlanogram.equals(ln) || searchPlanogram.equals(em);

		Assert.assertTrue(String.format("'%s' did not match name('%s'), description('%s'), or date('%s')",
				searchPlanogram, fn, ln, em), anyMatch);
//		 elementVisibility(getTxtSearch());
//		    insertValue(getTxtSearch(), searchPlanogram);
//		    clickElementUsingJavaScript(driver, getiSearch());
//		    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//		    List<WebElement> rows;
//		    try {
//		        rows = wait.until(ExpectedConditions
//		            .visibilityOfAllElementsLocatedBy(By.cssSelector("table mat-row")));
//		    } catch (TimeoutException e) {
//		        Assert.fail("No search results displayed for term: " + searchPlanogram);
//		        return;
//		    }
//		    boolean matched = false;
//		    for (WebElement row : rows) {
//		        String name = row.findElement(By.xpath(".//td[contains(@class,'mat-column-name')]")).getText().trim();
//		        String desc = row.findElement(By.xpath(".//td[contains(@class,'mat-column-description')]")).getText().trim();
//		        String date = row.findElement(By.xpath(".//td[contains(@class,'mat-column-createdDt')]")).getText().trim();
//
//		        if (searchPlanogram.equals(name) ||
//		            searchPlanogram.equals(desc) ||
//		            searchPlanogram.equals(date)) {
//		            matched = true;
//		            break;
//		        }
//		    }
//
//		    Assert.assertTrue(
//		        String.format("'%s' did not match any Name, Description, or Date in the results", searchPlanogram),
//		        matched);
//		    
	}

	/**
	 * @throws InterruptedException
	 * @see Used to verifies sorting functionality
	 */
	public void sorting() throws InterruptedException {
		String[] columnNames = { "Name", "Description", "Created Date" };

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
				System.out.println("Column '" + columnNames[i] + "' is initially sorted in ascending order.");
				clickElementUsingJavaScript(driver, columnHeader);
				Thread.sleep(500);
				ariaSort = columnHeader.getAttribute("aria-sort");
				System.out.println("Sorting Order After Click for '" + columnNames[i] + "': " + ariaSort);

				if ("descending".equals(ariaSort)) {
					System.out.println("Column '" + columnNames[i] + "' is now sorted in descending order.");
				} else {
					System.out.println("Column '" + columnNames[i] + "' is NOT sorted in descending order.");
				}
			} else if ("descending".equals(ariaSort)) {
				System.out.println("Column '" + columnNames[i] + "' is initially sorted in descending order.");
				clickElementUsingJavaScript(driver, columnHeader);
				Thread.sleep(500);
				ariaSort = columnHeader.getAttribute("aria-sort");
				System.out.println("Sorting Order After Click for '" + columnNames[i] + "': " + ariaSort);
				if ("ascending".equals(ariaSort)) {
					System.out.println("Column '" + columnNames[i] + "' is now sorted in ascending order.");
				} else {
					System.out.println("Column '" + columnNames[i] + "' is NOT sorted in ascending order.");
				}
			} else {
				System.out.println("Sorting order could not be determined for column '" + columnNames[i] + "'.");
			}
		}

	}

	public void clicksPlanogramNameLink() throws InterruptedException {
		Thread.sleep(1500);
		createdDateSorting();
		Thread.sleep(500);
		elementVisibility(getTdNameLink());
		clickElementUsingJavaScript(driver, getTdNameLink());

		
	}

	public void updatePlanogramDetails(String updateName, String updateDescription) {
		clearTextField(getTxtName());
		insertValue(getTxtName(), updateName);
		insertValue(getTxtDescription(), updateDescription);
		getBtnChooseFile().sendKeys("C:\\Users\\nloga\\Downloads\\sample.pdf");

	}

	public void clickwithUpdate() {
		clickElementUsingJavaScript(driver, getBtnUpdate());

	}

	public void pdfDocument() {
		getWindowHandle();
		clickElementUsingJavaScript(driver, getiPdf());
		getWindowHandles();
	}

	public void deletePlanogram() {
		clickElementUsingJavaScript(driver, getiDelete());
		clickElementUsingJavaScript(driver, getBtnYes());

	}

	public void createdDateSorting() {
		WebElement sortedColumn = driver.findElement(By.xpath("(//th[@role='columnheader'])[3]"));
		clickElementUsingJavaScript(driver, sortedColumn);
		String ariaSort = sortedColumn.getAttribute("aria-sort");
		System.out.println("Initial Sorting Order: " + ariaSort);

		if ("ascending".equals(ariaSort)) {
			clickElementUsingJavaScript(driver, sortedColumn);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			ariaSort = sortedColumn.getAttribute("aria-sort");
			System.out.println("Sorting Order After Click: " + ariaSort);

			if ("descending".equals(ariaSort)) {
				System.out.println("The column is now sorted in descending order.");
			} else {
				System.out.println("The column is not sorted in descending order after clicking.");
			}

		}
	}
}
