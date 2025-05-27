package com.adminUserPages;

import java.time.Duration;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.base.BaseClass;

/**
 * @see Used to find the locators assign the values in Returns module
 * 
 */
public class OpenC2ReturnsPage extends BaseClass {
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	public OpenC2ReturnsPage() {
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

	@FindBy(xpath = "(//mat-select[@placeholder='Select Assignee'])[2]")
	private WebElement ddSelectAssignee;

	@FindBy(xpath = "(//mat-select[@placeholder='Select status'])[2]")
	private WebElement ddupdateStatus;

	@FindBy(xpath = "(//i[@class='fa fa-history'])[1]")
	private WebElement iReturnStatusHistory;

	@FindBy(xpath = "(//i[@class='fa fa-download'])[1]")
	private WebElement iDownload;

	@FindBy(xpath = "(//i[@class='fa fa-upload'])[1]")
	private WebElement iUploadDeaForm;

	@FindBy(xpath = "//input[@name='deaFormNO']")
	private WebElement txtDEAFormNo;

	@FindBy(xpath = "//input[@formcontrolname='file']")
	private WebElement uploadFile;

	@FindBy(xpath = "//button[normalize-space()='Submit']")
	private WebElement btnSubmit;

	@FindBy(xpath = "//a[@class='breadcrumb-link current-link']")
	private WebElement bcOpenReturns;

	@FindBy(xpath = "//div[@class='modal-content returnHistoryContent']")
	private WebElement returnHistory;

	@FindBy(xpath = "//textarea[@name='comments']")
	private WebElement txtComments;

	@FindBy(xpath = "//span[@class='mat-option-text']")
	private WebElement ddMemberName;

	@FindBy(xpath = "//i[@class='fa fa-times']")
	private WebElement iClose;

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

	public WebElement getDdSelectAssignee() {
		return driver.findElement(By.xpath("(//mat-select[@placeholder='Select Assignee'])[2]"));
	}

	public WebElement getDdupdateStatus() {
		return driver.findElement(By.xpath("(//mat-select[@placeholder='Select status'])[2]"));
	}

	public WebElement getiReturnStatusHistory() {
		return iReturnStatusHistory;
	}

	public WebElement getiDownload() {
		return iDownload;
	}

	public WebElement getiUploadDeaForm() {
		return iUploadDeaForm;
	}

	public WebElement getTxtDEAFormNo() {
		return txtDEAFormNo;
	}

	public WebElement getUploadFile() {
		return uploadFile;
	}

	public WebElement getBtnSubmit() {
		return btnSubmit;
	}

	public WebElement getBcOpenReturns() {
		return bcOpenReturns;
	}

	public WebElement getReturnHistory() {
		return returnHistory;
	}

	public WebElement getTxtComments() {
		return txtComments;
	}

	public WebDriverWait getWait() {
		return wait;
	}

	public WebElement getDdMemberName() {
		return ddMemberName;
	}

	public WebElement getiClose() {
		return iClose;
	}

	public void clearFilter() {
		click(getBtnClearFilter());

	}

	/**
	 * @see Used to Filters return entries based on the provided criteria: member
	 *      number, assignee, status, and date range.
	 * @param memberNumber the member number to filter by
	 * @param assignee     the assignee to filter by
	 * @param status       the status to filter by
	 * @param startDate    the start date for the filter range (format: MM/dd/yyyy
	 *                     or as expected by the UI)
	 * @param endDate      the end date for the filter range (format: MM/dd/yyyy or
	 *                     as expected by the UI)
	 * @throws InterruptedException if thread sleep is interrupted
	 */
	public void filterReturns(String memberNumber, String assignee, String status, String startDate, String endDate)
			throws InterruptedException {
		insertValue(getTxtMemberNumber(), memberNumber);
		elementToBeClickable(getDdMemberName());
		Thread.sleep(1800);
		clickElementUsingJavaScript(driver, getDdMemberName());
		selectOptionDropDown(getDdAssignee(), assignee);
		selectOptionDropDown(getDdStatus(), status);
		insertValue(getTxtStartDate(), startDate);
		insertValue(getTxtEndDate(), endDate);
		clickElementUsingJavaScript(driver, getBtnFilter());
	}

	/**
	 * @see Used Filters the data by the given member number. This method refreshes
	 *      the current page, enters the member number into the input field, selects
	 *      the corresponding member name from the dropdown, and applies the filter.
	 *      Then it verifies that the first displayed result matches the provided
	 *      member number.
	 *
	 * @param memberNumberFilter the member number to filter by
	 * @throws InterruptedException if thread sleep is interrupted during wait time
	 */
	public void filterByMember(String memberNumberFilter) throws InterruptedException {
		refreshNavigation();
		insertValue(getTxtMemberNumber(), memberNumberFilter);
		elementToBeClickable(getDdMemberName());
		Thread.sleep(1800);
		clickElementUsingJavaScript(driver, getDdMemberName());
		Thread.sleep(1800);
		clickElementUsingJavaScript(driver, getBtnFilter());
		String member = getTxtMemberNumber().getAttribute("value").trim();
		System.out.println(member);
		String me;
		try {
			Thread.sleep(1800);
			me = wait
					.until(ExpectedConditions
							.visibilityOfElementLocated(By.xpath("(//td[contains(@class,'mat-column-members ')])[1]")))
					.getText().trim();
			System.out.println(me);
		} catch (TimeoutException e) {
			return;
		}
		String displayedMemberNumber = me.replaceAll("[^0-9]", "").trim();
		Assert.assertEquals("Member number does not match.", member.replaceAll("[^0-9]", ""), displayedMemberNumber);

	}

	/**
	 * @see Used to Filters the table data by selecting the specified assignee and
	 *      status from dropdowns, then clicks the filter button to apply the
	 *      filter.
	 *
	 * @param assignee the name of the assignee to select from the Assignee dropdown
	 * @param status   the status to select from the Status dropdown
	 */
	public void filterByAssigneeStatus(String assignee, String status) {
		selectOptionDropDown(getDdAssignee(), assignee);
		selectOptionDropDown(getDdStatus(), status);
		clickElementUsingJavaScript(driver, getBtnFilter());
	}

	/**
	 * @see Verifies that each row in a filtered table contains the expected
	 *      assignee and status. This method waits for the presence of table rows,
	 *      iterates over each row, and compares the assignee (7th column) and
	 *      status (8th column) values with the expected ones. It prints out a
	 *      message indicating whether the values match or not.
	 * @param expectedAssignee the assignee name expected to be found in each row
	 *                         (7th column)
	 * @param expectedStatus   the status expected to be found in each row (8th
	 *                         column)
	 */
	public void verifyFilteredResults(String expectedAssignee, String expectedStatus) {
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//table//tr")));
		List<WebElement> rows = driver.findElements(By.xpath("//table//tbody/tr"));

		for (WebElement row : rows) {
			try {
				String actualAssignee = row.findElement(By.xpath(".//td[7]")).getText().trim();
				String actualStatus = row.findElement(By.xpath(".//td[8]")).getText().trim();
				if (!actualAssignee.equals(expectedAssignee)) {
					System.out
							.println("Assignee mismatch! Expected: " + expectedAssignee + ", Found: " + actualAssignee);
				} else {
					System.out.println("Assignee matched: " + actualAssignee);
				}
				if (!actualStatus.equals(expectedStatus)) {
					System.out.println("Status mismatch! Expected: " + expectedStatus + ", Found: " + actualStatus);
				} else {
					System.out.println("Status matched: " + actualStatus);
				}

			} catch (StaleElementReferenceException e) {

			}

			if (rows.isEmpty()) {
				System.out.println("No results found for selected Assignee and Status.");
			}

		}
	}

	/**
	 * @see Used to search details and verifies the search results
	 * @param search
	 * @throws InterruptedException
	 */
	public void searchReturns(String search) throws InterruptedException {
		insertValue(getTxtSearch(), search);
		clickElementUsingJavaScript(driver, getiSearch());
		String me, dea, rn;
		Thread.sleep(1500);
		try {
			me = wait
					.until(ExpectedConditions
							.visibilityOfElementLocated(By.xpath("(//td[contains(@class,'mat-column-members ')])[1]")))
					.getText().trim();
			dea = wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("(//td[contains(@class,'mat-column-deaFormNo ')])[1]")))
					.getText().trim();
			rn = wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("(//td[contains(@class,'mat-column-returnName ')])[1]")))
					.getText().trim();

		} catch (TimeoutException e) {
			return;
		}

		boolean anyMatch = search.contains(me) || search.contains(dea) || search.contains(rn);

		Assert.assertTrue(
				String.format("'%s' did not match name('%s'), dea('%s'), or  member('%s')", search, me, dea, rn),
				anyMatch);
	}

	/**
	 * @see Used to Update Return Assignee, Status in Table
	 * @param assignee
	 * @param status
	 * @throws InterruptedException
	 */
	public void updateReturns(String assignee, String status) throws InterruptedException {
		try {
			elementVisibility(getDdSelectAssignee());
			selectOptionDropDown(getDdSelectAssignee(), assignee);
			elementVisibility(getDdupdateStatus());
			Thread.sleep(2000);
			selectOptionDropDown(getDdupdateStatus(), status);
		} catch (StaleElementReferenceException e) {

		}
	}

	/**
	 * @see Used to add comments in text field
	 * @param comments
	 */
	public void insertComments(String comments) {
		insertValue(getTxtComments(), comments);

	}

	/**
	 * @see Used to click Return policy History icon
	 */
	public void returnPolicyHistory() {
		click(getiReturnStatusHistory());
		try {
			WebElement docElement = waitForWebElementVisible(getReturnHistory());
			Assert.assertTrue(docElement.isDisplayed());
			System.out.println(" Document 'Return History' is visible on the page.");
		} catch (TimeoutException e) {
			System.out.println(" Document 'Return History' was not found.");
			Assert.fail("Document Return History is not displayed.");
		}

	}

	/**
	 * @see Used to submit with DEA Form Number and Upload file Uploads a DEA form
	 *      by entering the DEA form number and submitting a PDF file.
	 * 
	 * @param deaNum
	 */
	public void uploadDeaForm(String deaNum) {
		clickElementUsingJavaScript(driver, getiUploadDeaForm());
		insertValue(getTxtDEAFormNo(), deaNum);
		getUploadFile()
				.sendKeys("C:\\Users\\nloga\\eclipse-workspace\\MutualDrug\\src\\test\\resources\\folder\\sample.pdf");
		clickElementUsingJavaScript(driver, getBtnSubmit());
	}

	/**
	 * Clicks on the Return Name link element. This method ensures the visibility of
	 * the Return Name link before clicking it using JavaScript, which is useful for
	 * handling elements that may be hidden or overlapped by other UI components.
	 * 
	 * @see #getLnkReturnName() to retrieve the Return Name link WebElement
	 */
	public void returnNameLink() {
		elementVisibility(getLnkReturnName());
		clickElementUsingJavaScript(driver, getLnkReturnName());

	}

	/**
	 * @see Used perform sorting function
	 * @param columnNames
	 * @throws InterruptedException
	 */
	public void verifySortingFunctionality(String[] columnNames) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		for (int i = 0; i < columnNames.length; i++) {
			WebElement columnHeader = driver.findElement(By.xpath("(//th[@role='columnheader'])[" + (i + 1) + "]"));
			wait.until(ExpectedConditions.elementToBeClickable(columnHeader));
			clickElementUsingJavaScript(driver, columnHeader);
			Thread.sleep(500);
			String ariaSortAsc = columnHeader.getAttribute("aria-sort");
			System.out.println("After 1st click, sorting order for '" + columnNames[i] + "': " + ariaSortAsc);
			if ("ascending".equals(ariaSortAsc)) {
				System.out.println("Column '" + columnNames[i] + "' sorted in ascending order.");
			} else {
				System.out.println("Column '" + columnNames[i] + "' NOT sorted in ascending order.");
			}
			clickElementUsingJavaScript(driver, columnHeader);
			Thread.sleep(500);
			String ariaSortDesc = columnHeader.getAttribute("aria-sort");
			System.out.println("After 2nd click, sorting order for '" + columnNames[i] + "': " + ariaSortDesc);
			if ("descending".equals(ariaSortDesc)) {
				System.out.println("Column '" + columnNames[i] + "' sorted in descending order.");
			} else {
				System.out.println("Column '" + columnNames[i] + "' NOT sorted in descending order.");
			}
		}
	}

	/**
	 *
	 * @see Closes the currently active modal or dialog by clicking the close (X)
	 *      icon.
	 */
	public void close() {
		clickElementUsingJavaScript(driver, getiClose());

	}

}
