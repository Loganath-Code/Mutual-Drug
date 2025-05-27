package com.pages;

import java.text.Normalizer;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.base.BaseClass;

public class ReturnsPage extends BaseClass {

	public ReturnsPage() {
		PageFactory.initElements(driver, this);
	}

	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	@FindBy(xpath = "//i[@class='fa fa-retweet']")
	private WebElement iReturns;

	@FindBy(xpath = "//span[text()='Returns']")
	private WebElement lnkReturns;

	@FindBy(xpath = "(//a[@href='/member/returns'])[1]")
	private WebElement lnkUnsubmitted;

	@FindBy(xpath = "(//a[@href='/member/returns/return-submitted'])[1]")
	private WebElement lnkSubmitted;

	@FindBy(xpath = "(//a[@href='/member/returns/return-ack-history'])[1]")
	private WebElement lnkAcknowledgement;
	// unsubmitted
	@FindBy(xpath = "//h2[@class='breadcrumb-title']")
	private WebElement bctitleReturns;

	@FindBy(xpath = "//input[@placeholder='Search for Returns']")
	private WebElement txtSearchReturns;

	@FindBy(xpath = "(//i[@class='fa fa-search'])[2]")
	private WebElement iSearchReturns;

	@FindBy(xpath = "(//i[@class='fa fa-trash'])[1]")
	private WebElement iTrashReturns;

	@FindBy(xpath = "//button[text()='Yes']")
	private WebElement btnYes;

	@FindBy(xpath = "//a[@class='breadcrumb-link current-link' and text()='Returns ']")
	private WebElement bclnkReturns;

	@FindBy(xpath = "//tbody//tr[1]//td[1]")
	private WebElement tdFirstcell;

	@FindBy(xpath = "(//td[@role='gridcell']//a)[1]")
	private WebElement firstReturnName;

	@FindBy(xpath = "(//th[@role='columnheader'])[3]")
	private WebElement titleSubmittedDate;

	@FindBy(xpath = "//button[text()=' Create New']")
	private WebElement btnCreateNew;

	@FindBy(xpath = "//input[@name='returnName']")
	private WebElement txtReturnName;

	@FindBy(xpath = "//button[@class='modal-btn']")
	private WebElement btnCreate;

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

	@FindBy(xpath = "//div[@aria-label='Return details deleted.']")
	private WebElement alMeassageDelete;

	@FindBy(xpath = "//div[text()='Return Name is required']")
	private WebElement errorMessageReturnName;

	@FindBy(xpath = "//div[text()='Return Type is required']")
	private WebElement errorMessageReturnType;

	@FindBy(xpath = "//div[text()='Special characters not allowed']")
	private WebElement errorMessageSpecialChars;

	@FindBy(xpath = "//input[@name='returnName']")
	private WebElement txtReturnOrderName;

	// returns Details

	@FindBy(xpath = "//input[@placeholder='Search Products']")
	private WebElement txtSearchProducts;

	@FindBy(xpath = "//button[@type='button']//i[@class='fa fa-search']")
	private WebElement iSearch;

	@FindBy(xpath = "(//button[@class='search'])[2]")
	private WebElement btnSearch;

	@FindBy(xpath = "//input[@class='form-control refine-search-style']")
	private WebElement txtRefineSearch;

	@FindBy(xpath = "(//select[@name='sort'])[1]")
	private WebElement ddCategory;

	@FindBy(xpath = "(//select[@name='sort'])[2]")
	private WebElement ddRelevance;

	@FindBy(xpath = "(//select[@name='sort'])[3]")
	private WebElement ddSortOrder;

	@FindBy(xpath = "(//input[@type='date']//parent::div[contains(@class, 'pin-date')])[1]")
	private WebElement txtExpirationDate;

	@FindBy(xpath = "(//div[@class='col-lg-2 col-xs-12 col-sm-4 lot']//input[@type='text'])[1]")
	private WebElement txtLotLabel;

	@FindBy(xpath = "(//input[contains(@class, 'form-control') and contains(@class, 'order-qty')])[1]")
	private WebElement txtQty;

	@FindBy(xpath = "(//div[@class='ng-star-inserted']//select)[4]")
	private WebElement ddReturnReason;

	@FindBy(xpath = "(//select[contains(@class, 'form-control') and contains(@class, 'ng-valid')])[4]")
	private WebElement ddReturnReasonsRefineSearch;

	@FindBy(xpath = "//div[@class='col-lg-1 col-xs-12 col-sm-6 lot ng-star-inserted']//input[@type='text']")
	private WebElement txtRANumber;

	@FindBy(xpath = "(//label[text()='Case']//following::span[@class='checkmark'])[1]")
	private WebElement cbxCase;

	@FindBy(xpath = "(//input[@name='dontWantBackAll']//following::span[@class='checkmark'])[1]")
	private WebElement cbxDontwantBack;

	@FindBy(xpath = "//tbody/tr[1]/td[9]/span[2]/label[1]/span[1]")
	private WebElement cbxDontwantBackGrid;

	@FindBy(xpath = "//button[text()='Add to Return']")
	private WebElement btnAddToReturn;

	@FindBy(xpath = "//div[@aria-label='Return item added.']")
	private WebElement alertMessageAddReturnItems;

	@FindBy(xpath = "(//div[contains(@class, 'mat-sort-header-stem')])[1]")
	private WebElement mat_Sort_header_Items;

	@FindBy(xpath = "(//div[contains(@class, 'mat-sort-header-stem')])[2]")
	private WebElement mat_Sort_header_ProductDescription;

	@FindBy(xpath = "((//td[@role='gridcell'])[1]//following::input[@type='date'])[1]")
	private WebElement txtExpirationDateinGrid;

	@FindBy(xpath = "//tbody//tr[1]//td[5]//span[2]//input[1]")
	private WebElement txtQtyinGrid;

	@FindBy(xpath = "((//td[@role='gridcell'])[1]//following::input[@type='string'])[1]")
	private WebElement txtLotNumberGrid;

	@FindBy(xpath = "((//td[@role='gridcell'])[1]//following::select[contains(@class, 'form-control') and contains(@class, 'ng-pristine')])[1]")
	private WebElement ddReturnReasoninGrid;

	@FindBy(xpath = "(//i[@class='fa fa-trash'])[1]")
	private WebElement iTrash;

	@FindBy(xpath = "//button[text()='Sign & Submit']")
	private WebElement btnSignSubmit;

	@FindBy(xpath = "//input[@name='authorizedSignature']")
	private WebElement txtAuthorizedSignature;

	@FindBy(xpath = "//input[@name='title']")
	private WebElement txtTitle;

	@FindBy(xpath = "//mat-select[@name='signatureFont']")
	private WebElement ddSignatureFont;

	@FindBy(xpath = "(//button[text()='Sign & Submit'])[2]")
	private WebElement btnSignsubmit;

	@FindBy(xpath = "//div[@aria-label='Return item updated.']")
	private WebElement alUpdateMessage;

	@FindBy(xpath = "//div[@aria-label='Return item deleted.']")
	private WebElement alDeleteMessage;

	@FindBy(xpath = "(//div[@class='product-box'])[1]")
	private WebElement textRefineSearchResults;

	@FindBy(xpath = "//div[@aria-label='Your C2 Return document has successfully been emailed to Mutual Drug.  Please contact customer service if you have additional questions.']")
	private WebElement alMessageC2Returns;

	@FindBy(xpath = "//div[@aria-label='Your Refrigerated Form has been submitted']")
	private WebElement alMessageRefrigerated;

	@FindBy(xpath = "(//th[@role='columnheader'])[1]")
	private WebElement sortingItems;

	@FindBy(xpath = "(//th[@role='columnheader'])[2]")
	private WebElement sortingProductsDiscriptions;

	@FindBy(xpath = "//div[@class='status']")
	private WebElement textStatus;

	@FindBy(xpath = "//div[@aria-label='Return name updated.']")
	private WebElement alMessageReturnNameUpdate;

	@FindBy(xpath = "//span[text()='No matching product(s) found']")
	private WebElement textErrorMessageNoMatch;

	@FindBy(xpath = "//*[text()=' abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefgh ']")
	private WebElement breadCrumbLinlReturnName;

	@FindBy(xpath = "//div[@aria-label='Please add at least one item to submit.']")
	private WebElement errorMessageSignSubmit;

	@FindBy(xpath = "//div[@aria-label='Please select expiration date.']")
	private WebElement errorMessagDate;

	@FindBy(xpath = "//div[@aria-label='Please select valid expiration date.']")
	private WebElement errormessageInvalidDate;

	@FindBy(xpath = "//div[@aria-label='Lot number is required.']")
	private WebElement errorMessageLotNumber;

	@FindBy(xpath = "//div[@aria-label='Return reason is required.']")
	private WebElement errorMessageReturnReason;

	@FindBy(xpath = "//div[@aria-label='RA Number is required.']")
	private WebElement errorMessageRANumber;

	@FindBy(xpath = "//div[@aria-label='Min allowed return qty is 1.']")
	private WebElement errorMessageReturnQty;

	@FindBy(xpath = "//div[@aria-label='Please select one or more item(s).']")
	private WebElement errorMessageDontwantBack;

	@FindBy(xpath = "//div[contains(text(),'Authorized Signature is required')]")
	private WebElement errorMessageAuthorizedSignature;

	@FindBy(xpath = "//div[contains(text(),'Title is required')]")
	private WebElement errorMessageTitle;

	@FindBy(xpath = "//button[@aria-label='Close']")
	private WebElement iClose;

	@FindBy(xpath = "//div[@class='signatureContainer']")
	private WebElement signatureContainer;

	@FindBy(xpath = "(//div[@class='input-group'])[3]")
	private WebElement titleField;

	@FindBy(xpath = "//button[@class='create-btn pull-right ng-star-inserted']")
	private WebElement btnPrintReturn;

	@FindBy(xpath = "//div[@aria-label='Your Regular Form has been submitted']")
	private WebElement successMessageRegularReturnSubmitted;

	@FindBy(xpath = "//div[@role='alertdialog']")
	private WebElement successMessageReturnSubmitted;

	@FindBy(xpath = "//div[@role='alertdialog']")
	private WebElement warningMessage;

	public WebDriverWait getWait() {
		return wait;
	}

	public WebElement getiReturns() {
		return iReturns;
	}

	public WebElement getLnkReturns() {
		return lnkReturns;
	}

	public WebElement getLnkUnsubmitted() {
		return lnkUnsubmitted;
	}

	public WebElement getLnkSubmitted() {
		return lnkSubmitted;
	}

	public WebElement getLnkAcknowledgement() {
		return lnkAcknowledgement;
	}

	public WebElement getBctitleReturns() {
		return bctitleReturns;
	}

	public WebElement getTxtSearchReturns() {
		return txtSearchReturns;
	}

	public WebElement getiSearchReturns() {
		return iSearchReturns;
	}

	public WebElement getiTrashReturns() {
		return iTrashReturns;
	}

	public WebElement getBtnYes() {
		return btnYes;
	}

	public WebElement getBclnkReturns() {
		return bclnkReturns;
	}

	public WebElement getTdFirstcell() {
		return tdFirstcell;
	}

	public WebElement getFirstReturnName() {
		return firstReturnName;
	}

	public WebElement getTitleSubmittedDate() {
		return titleSubmittedDate;
	}

	public WebElement getBtnCreateNew() {
		return btnCreateNew;
	}

	public WebElement getTxtReturnName() {
		return txtReturnName;
	}

	public WebElement getBtnCreate() {
		return btnCreate;
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

	public WebElement getAlMeassageDelete() {
		return alMeassageDelete;
	}

	public WebElement getErrorMessageReturnName() {
		return errorMessageReturnName;
	}

	public WebElement getErrorMessageReturnType() {
		return errorMessageReturnType;
	}

	public WebElement getErrorMessageSpecialChars() {
		return errorMessageSpecialChars;
	}

	public WebElement getTxtReturnOrderName() {
		return txtReturnOrderName;
	}

	public WebElement getTxtSearchProducts() {
		return txtSearchProducts;
	}

	public WebElement getiSearch() {
		return iSearch;
	}

	public WebElement getBtnSearch() {
		return btnSearch;
	}

	public WebElement getTxtRefineSearch() {
		return txtRefineSearch;
	}

	public WebElement getDdCategory() {
		return ddCategory;
	}

	public WebElement getDdRelevance() {
		return ddRelevance;
	}

	public WebElement getDdSortOrder() {
		return ddSortOrder;
	}

	public WebElement getTxtExpirationDate() {
		return txtExpirationDate;
	}

	public WebElement getTxtLotLabel() {
		return txtLotLabel;
	}

	public WebElement getTxtQty() {
		return txtQty;
	}

	public WebElement getDdReturnReason() {
		return ddReturnReason;
	}

	public WebElement getDdReturnReasonsRefineSearch() {
		return ddReturnReasonsRefineSearch;
	}

	public WebElement getTxtRANumber() {
		return txtRANumber;
	}

	public WebElement getCbxCase() {
		return cbxCase;
	}

	public WebElement getCbxDontwantBack() {
		return cbxDontwantBack;
	}

	public WebElement getCbxDontwantBackGrid() {
		return cbxDontwantBackGrid;
	}

	public WebElement getBtnAddToReturn() {
		return btnAddToReturn;
	}

	public WebElement getAlertMessageAddReturnItems() {
		return alertMessageAddReturnItems;
	}

	public WebElement getMat_Sort_header_Items() {
		return mat_Sort_header_Items;
	}

	public WebElement getMat_Sort_header_ProductDescription() {
		return mat_Sort_header_ProductDescription;
	}

	public WebElement getTxtExpirationDateinGrid() {
		return txtExpirationDateinGrid;
	}

	public WebElement getTxtQtyinGrid() {
		return txtQtyinGrid;
	}

	public WebElement getTxtLotNumberGrid() {
		return txtLotNumberGrid;
	}

	public WebElement getDdReturnReasoninGrid() {
		return ddReturnReasoninGrid;
	}

	public WebElement getiTrash() {
		return iTrash;
	}

	public WebElement getBtnSignSubmit() {
		return btnSignSubmit;
	}

	public WebElement getTxtAuthorizedSignature() {
		return txtAuthorizedSignature;
	}

	public WebElement getTxtTitle() {
		return txtTitle;
	}

	public WebElement getDdSignatureFont() {
		return ddSignatureFont;
	}

	public WebElement getBtnSignsubmit() {
		return btnSignsubmit;
	}

	public WebElement getAlUpdateMessage() {
		return alUpdateMessage;
	}

	public WebElement getAlDeleteMessage() {
		return alDeleteMessage;
	}

	public WebElement getTextRefineSearchResults() {
		return textRefineSearchResults;
	}

	public WebElement getAlMessageC2Returns() {
		return alMessageC2Returns;
	}

	public WebElement getAlMessageRefrigerated() {
		return alMessageRefrigerated;
	}

	public WebElement getSortingItems() {
		return sortingItems;
	}

	public WebElement getSortingProductsDiscriptions() {
		return sortingProductsDiscriptions;
	}

	public WebElement getTextStatus() {
		return textStatus;
	}

	public WebElement getAlMessageReturnNameUpdate() {
		return alMessageReturnNameUpdate;
	}

	public WebElement getTextErrorMessageNoMatch() {
		return textErrorMessageNoMatch;
	}

	public WebElement getBreadCrumbLinlReturnName() {
		return breadCrumbLinlReturnName;
	}

	public WebElement getErrorMessageSignSubmit() {
		return errorMessageSignSubmit;
	}

	public WebElement getErrorMessagDate() {
		return errorMessagDate;
	}

	public WebElement getErrormessageInvalidDate() {
		return errormessageInvalidDate;
	}

	public WebElement getErrorMessageLotNumber() {
		return errorMessageLotNumber;
	}

	public WebElement getErrorMessageReturnReason() {
		return errorMessageReturnReason;
	}

	public WebElement getErrorMessageRANumber() {
		return errorMessageRANumber;
	}

	public WebElement getErrorMessageReturnQty() {
		return errorMessageReturnQty;
	}

	public WebElement getErrorMessageDontwantBack() {
		return errorMessageDontwantBack;
	}

	public WebElement getErrorMessageAuthorizedSignature() {
		return errorMessageAuthorizedSignature;
	}

	public WebElement getErrorMessageTitle() {
		return errorMessageTitle;
	}

	public WebElement getiClose() {
		return iClose;
	}

	public WebElement getSignatureContainer() {
		return signatureContainer;
	}

	public WebElement getTitleField() {
		return titleField;
	}

	public WebElement getBtnPrintReturn() {
		return btnPrintReturn;
	}

	public WebElement getSuccessMessageRegularReturnSubmitted() {
		return successMessageRegularReturnSubmitted;
	}

	public WebElement getSuccessMessageReturnSubmitted() {
		return successMessageReturnSubmitted;
	}

	public WebElement getWarningMessage() {
		return warningMessage;
	}

	/**
	 * @see Used to naigates returns Submenus
	 */
	public void navigatesReturns(String linkedMenu) {
		scrollToElement(getiReturns());
		Actions action = new Actions(driver);
		action.moveToElement(getiReturns()).perform();
		WebElement returnSubmenu = wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//span[contains(normalize-space(),'" + linkedMenu + "')]")));
		returnSubmenu.click();

	}

	/**
	 * @see Used to Creates a new return order by providing a return name and
	 *      selecting the return type.
	 *
	 * @param returnName The name to assign to the new return order.
	 * @param returnType The type of return (e.g., "Regular", "C2", "Refrigerate")
	 *                   to select via radio button.
	 */
	public void createReturnOrder(String returnName, String returnType) {
		clickElementUsingJavaScript(driver, getBtnCreateNew());
		insertValue(getTxtReturnName(), returnName);
		clickRadioButton(returnType);
		click(getBtnCreate());

	}

	/**
	 * @see used to Removes the current value from the Return Name input field using
	 *      JavaScript.
	 */

	public void removeReturnName() {
		try {
			scrollToElement(getTxtReturnName());
			clearTextUsingjs(getTxtReturnName());
		} catch (Exception e) {

		}
	}

	/**
	 * @see Used to Checks whether a given web element is visible on the page.
	 */
	public boolean isElementVisible(WebElement element) {
		try {
			return element.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * @ see Used to Navigates back to the Returns page using the breadcrumb link.
	 * 
	 * This method waits for the breadcrumb link to become visible and then clicks
	 * it
	 */
	public void navigatesBackUsingBclink() {
		elementVisibility(bclnkReturns);
		scrollToElement(bclnkReturns);
		clickElementUsingJavaScript(driver, bclnkReturns);

	}

	/**
	 * @see Used to Searches for a return entry by name.
	 * @param returnName the name of the return entry to search for
	 */
	public void searchReturnsName(String returnName) {
		insertValue(getTxtSearchReturns(), returnName);
	}

	/**
	 * @see Used toDeletes the most recently submitted return based on sorting by
	 *      submission date.
	 * 
	 *      This method first performs sorting by submitted date, then attempts to
	 *      click the trash icon to delete the return. If the confirmation dialog
	 *      appears, it clicks 'Yes' to confirm the deletion
	 */
	public void deleteReturDetails() {
		SubmittedDateSorting();
		try {
			clickElementUsingJavaScript(driver, getiTrashReturns());
			elementVisibility(getBtnYes());
			clickElementUsingJavaScript(driver, getBtnYes());
		} catch (Exception e) {

		}
	}

	/**
	 * @see Used to Verifies ascending and descending sorting functionality for each
	 *      sortable column. Ensures each column responds correctly to repeated
	 *      sorting clicks.
	 */

	public void verifySortingFunctionality(String[] columnNames) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		for (int i = 0; i < columnNames.length; i++) {
			int columnIndex = i + 1;
			By columnLocator = By.xpath("(//th[@role='columnheader'])[" + columnIndex + "]");
			WebElement columnHeader = wait.until(ExpectedConditions.elementToBeClickable(columnLocator));
			System.out.println("Testing column: " + columnNames[i]);
			clickElementUsingJavaScript(driver, columnHeader);
			waitShort();
			String firstSort = columnHeader.getAttribute("aria-sort");
			System.out.println("Initial Sort Order: " + (firstSort != null ? firstSort : "Not Available"));
			if (firstSort == null) {
				System.out.println("Column '" + columnNames[i] + "' does not support sorting. Skipping.\n");
				continue;
			}
			clickElementUsingJavaScript(driver, columnHeader);
			waitShort();
			String secondSort = columnHeader.getAttribute("aria-sort");
			System.out.println("After 2nd Click - Sort Order: " + (secondSort != null ? secondSort : "Not Available"));
			if (!firstSort.equalsIgnoreCase(secondSort)) {
				System.out.println("Sort order toggled correctly.");
			} else {
				System.out.println("Sort order did NOT toggle after 2nd click.");
			}
			clickElementUsingJavaScript(driver, columnHeader);
			waitShort();
			String thirdSort = columnHeader.getAttribute("aria-sort");
			System.out.println("After 3rd Click - Sort Order: " + (thirdSort != null ? thirdSort : "Not Available"));
			if ((firstSort == null && thirdSort == null)
					|| (firstSort != null && firstSort.equalsIgnoreCase(thirdSort))) {
				System.out.println("Returned to original sort order.\n");
			} else {
				System.out.println("Did not return to original sort order.\n");
			}
		}
	}

	/**
	 * Utility method for short explicit waits (can replace with WebDriverWait if
	 * preferred).
	 */
	private void waitShort() {
		try {
			Thread.sleep(800);
		} catch (InterruptedException e) {
			e.printStackTrace();
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

	public boolean isElementEnabled(WebElement element) {
		try {
			return element.isEnabled();
		} catch (NoSuchElementException e) {
			System.out.println("⚠️ Element not found.");
			return false;
		} catch (Exception e) {
			System.out.println("⚠️ Error while checking if element is enabled: " + e.getMessage());
			return false;
		}
	}

	/**
	 * @see used to Adds a product to the return order with provided details and
	 *      verifies the success message.
	 *
	 * @param searchProducts Product name or keyword to search.
	 * @param expirationDate Expiration date in format (dd-MM-yyyy).
	 * @param lotNumber      Lot number for the product.
	 * @param qty            Quantity to be returned.
	 * @param returnReason   Reason for the return (drop down selection).
	 * @param successMessage Expected success message after adding the return item.
	 * @throws InterruptedException if any sleep or wait gets interrupted.
	 */
	public void addReturnItem(String product, String expirationDate, String lotNumber, String quantity,
			String returnReason, String successMessage) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		scrollToElement(getTxtSearchProducts());
		elementVisibility(getTxtSearchProducts());
		insertValue(getTxtSearchProducts(), product);
		elementToBeClickable(getiSearch());
		clickElementUsingJavaScript(driver, getiSearch());
		try {
			WebElement dateInput = wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("(//div[contains(@class, 'date pin-date')]//following::input[@type='date'])[1]")));
			elementVisibility(dateInput);
			clearTextUsingjs(dateInput);
			dateInput.sendKeys(expirationDate);
		} catch (Exception e) {
			System.out.println("Expiration date input not found. Skipping date entry.");
		}
		wait.until(ExpectedConditions.visibilityOf(getTxtLotLabel()));
		insertValue(getTxtLotLabel(), lotNumber);
		wait.until(ExpectedConditions.visibilityOf(getTxtQty()));
		getTxtQty().clear();
		getTxtQty().sendKeys(quantity);
		wait.until(ExpectedConditions.elementToBeClickable(getDdReturnReasonsRefineSearch()));
		selectByVisibleText(getDdReturnReasonsRefineSearch(), returnReason);
		if (returnReason.contains("Customer Service Authorized")) {
			try {
				WebElement raInput = wait.until(ExpectedConditions.visibilityOf(getTxtRANumber()));
				insertValue(raInput, "1234");
			} catch (TimeoutException ignored) {
				System.out.println("RA Number field not visible, skipping.");
			}
		}
		try {
			if (isElementEnabled(getCbxCase())) {
				clickElementUsingJavaScript(driver, getCbxCase());
			}
		} catch (Exception e) {
			System.out.println("Case checkbox not clickable.");
		}
		wait.until(ExpectedConditions.elementToBeClickable(getBtnAddToReturn()));
		clickElementUsingJavaScript(driver, getBtnAddToReturn());
		assertEquals(getAlertMessageAddReturnItems(), successMessage);
	}

	/**
	 * @see Used to Generic method to perform refine search and add item to return
	 *      (Regular, C2, or Refrigerated).
	 *
	 * @param addSearchProducts Search term
	 * @param refineSearch      Refine search filter
	 * @param category          Category to select
	 * @param sortBy            Sort by option
	 * @param sortOrder         Sort order option
	 * @param lotNumber         Lot number value
	 * @param qty               Quantity value
	 * @param returnReason      Return reason to select
	 * @param successMessage    Expected success message
	 * @param isRefrigerated    Is the item refrigerated
	 * @param isC2              Is the item C2 controlled
	 * @param checkCaseBox      Should check the case checkbox (used for regular
	 *                          returns)
	 */
	public void refineSearchAndAddItem(String addSearchProducts, String refineSearch, String category, String sortBy,
			String sortOrder, String expirationDate, String lotNumber, String qty, String returnReason,
			String successMessage) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		try {
			insertValue(getTxtSearchProducts(), addSearchProducts);
			elementToBeClickable(getiSearch());
			clickElementUsingJavaScript(driver, getiSearch());

			wait.until(ExpectedConditions.visibilityOf(getTxtRefineSearch()));
			insertValue(getTxtRefineSearch(), refineSearch);
			clickElementUsingJavaScript(driver, getTxtRefineSearch());
			keyDown(Keys.ENTER);
			keyUp(Keys.ENTER);

			wait.until(ExpectedConditions.visibilityOf(getDdCategory()));
			selectByVisibleText(getDdCategory(), category);
			selectByVisibleText(getDdRelevance(), sortBy);
			selectByVisibleText(getDdSortOrder(), sortOrder);

			WebElement dateInput = wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("(//div[contains(@class, 'date pin-date')]//following::input[@type='date'])[1]")));
			elementVisibility(dateInput);
			clearTextUsingjs(dateInput);
			dateInput.sendKeys("05-03-2025");
			insertValue(getTxtLotLabel(), lotNumber);
			getTxtQty().clear();
			getTxtQty().sendKeys(qty);

			selectByVisibleText(getDdReturnReason(), returnReason);

			if (returnReason.contains("Customer Service Authorized")) {
				try {
					if (isElementVisible(getTxtRANumber())) {
						insertValue(getTxtRANumber(), "1234");
					}
				} catch (Exception e) {
					System.out.println(" RA Number field not found.");
				}
			}

			try {
				if (isElementVisible(getCbxCase())) {
					// clickElementUsingJavaScript(driver, getCbxCase());
				}
			} catch (Exception e) {
				System.out.println("Case checkbox not clickable.");
			}

			clickElementUsingJavaScript(driver, getBtnAddToReturn());
			WebElement alert = wait.until(ExpectedConditions.visibilityOf(getAlertMessageAddReturnItems()));
			assertEquals(getAlertMessageAddReturnItems(), successMessage);

		} catch (Exception e) {
			System.out.println("Refine search failed: " + e.getMessage());
			e.printStackTrace();
		}
	}

	/**
	 * @see Used to Updates the item details in a grid with the provided expiration
	 *      date, lot number, quantity, return reason, and RA number (if
	 *      applicable).
	 * @param expirationDateGrid the expiration date to input (format: YYYY-MM-DD)
	 * @param lotNumber          the lot number to input
	 * @param qty                the quantity to input
	 * @param returnReason       the return reason to select from the dropdown; may
	 *                           trigger RA number input
	 * @param updateAlertMessage the expected update alert message to verify
	 *                           (optional)
	 * @param raNumber           the RA number to input if the return reason
	 *                           requires it (optional)
	 */
	public void updateListItems(String expirationDateGrid, String lotNumber, String qty, String returnReason,
			String updateAlertMessage, String raNumber) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		try {
			WebElement dateInput = wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("(//span[text()='Expiration Date']//following::input[@type='date'])[1]")));
			elementVisibility(dateInput);
			clearTextUsingjs(dateInput);
			dateInput.sendKeys(expirationDateGrid);

			WebElement lotInput = wait.until(ExpectedConditions.visibilityOf(getTxtLotNumberGrid()));
			lotInput.clear();
			lotInput.sendKeys(lotNumber);

			WebElement qtyInput = wait.until(ExpectedConditions.visibilityOf(getTxtQty()));
			qtyInput.clear();
			qtyInput.sendKeys(qty);

			WebElement reasonDropdown = wait.until(ExpectedConditions.visibilityOf(getDdReturnReason()));
			selectByVisibleText(reasonDropdown, returnReason);
			if (returnReason != null && returnReason.contains("Customer Service Authorized")) {
				try {
					WebElement raInput = getTxtRANumber();
					if (isElementVisible(raInput) && raNumber != null && !raNumber.isEmpty()) {
						insertValue(raInput, raNumber);
					}
				} catch (Exception e) {
					System.out.println("RA Number field is not visible or not required.");
				}
			}
			clickElementUsingJavaScript(driver, getTxtLotNumberGrid());
			clickElementUsingJavaScript(driver, getTxtQty());
			if (updateAlertMessage != null && !updateAlertMessage.isEmpty()) {
				assertEquals(getAlUpdateMessage(), updateAlertMessage);
				clickElementUsingJavaScript(driver, getiClose());
			}

		} catch (Exception e) {
			System.out.println("Error while updating item details: " + e.getMessage());
			e.printStackTrace();
		}
	}

	/**
	 * @see Used to Update Return Name
	 * @param returnName
	 */
	public void updateReturnName(String returnName) {
		insertValue(getTxtReturnName(), returnName);
		clickElementUsingJavaScript(driver, getDdItemsperPage());
	}

	/**
	 * Verifies and ensures that the "Submitted Date" column in the grid is sorted
	 * in descending order.
	 */
	public void SubmittedDateSorting() {
		WebElement submittedDateHeader = wait.until(ExpectedConditions.elementToBeClickable(getTitleSubmittedDate()));
		submittedDateHeader.click();
		WebElement sortedColumn = wait
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//th[@role='columnheader'])[3]")));
		String ariaSort = sortedColumn.getAttribute("aria-sort");
		if ("descending".equalsIgnoreCase(ariaSort)) {
			System.out.println("Submitted Date is already sorted in descending order.");
		} else if ("ascending".equalsIgnoreCase(ariaSort)) {
			clickElementUsingJavaScript(driver, sortedColumn);
			wait.until(ExpectedConditions.attributeToBe(sortedColumn, "aria-sort", "descending"));
		} else {

		}

	}

	/**
	 * @see Used to delete Return item in Grid
	 */
	public void deleteIteminGrid() {
		clickElementUsingJavaScript(driver, getiTrash());

	}

	/**
	 * @see Used to Clicks the "Sign & Submit" button.
	 */
	public void clicksSignSubmit() {
		click(getBtnSignSubmit());

	}

	public void selectOptioninDropDown(WebDriver driver, WebElement dropdownElement, String optionText) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(dropdownElement));
		click(dropdownElement);
		WebElement option = wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//mat-option//span[text()= ' " + optionText + " ']")));
		scrollToElement(option);
		clickElementUsingJavaScript(driver, option);
	}

	/**
	 * @see Used to Fills in the authorized signature details and submits the form.
	 * @param authorisedSignature the name or text to be used as the authorized
	 *                            signature
	 * @param title               the title or position associated with the
	 *                            signature
	 * @param signatureFont       the font to be applied to the signature, selected
	 *                            from a dropdown
	 */
	public void insertSignSubmitDetail(String authorisedSignature, String title, String signatureFont) {
		insertValue(getTxtAuthorizedSignature(), authorisedSignature);
		insertValue(getTxtTitle(), title);
		selectOptioninDropDown(driver, getDdSignatureFont(), signatureFont);
		click(getBtnSignsubmit());
	}

	public void returnsWithoutName() throws InterruptedException {
		clickElementUsingJavaScript(driver, getBtnCreateNew());
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement returnNameField = wait.until(ExpectedConditions.elementToBeClickable(getTxtReturnName()));
		clearField(returnNameField);
		clickElementUsingJavaScript(driver, getBtnCreate());
	}

	/**
	 * @see used to Enters a return name containing special characters and attempts
	 *      to create the return.
	 * @param returnName The return name to be entered, which may contain special
	 *                   characters.
	 * @param returnType The return type to be selected (e.g., "Regular", "C2").
	 */
	public void returnNameWithSpecialChar(String returnName, String returnType) {
		clearField(getTxtReturnName());
		insertValue(getTxtReturnName(), returnName);
		clickRadioButton(returnType);
		clickElementUsingJavaScript(driver, getBtnCreate());
	}

	/**
	 * @see Used to Enters the specified number of spaces as the return name and
	 *      submits the form.
	 *
	 * @param returnType The return type radio button to select.
	 * @param spaceCount The number of spaces to enter as the return name.
	 */
	public void returnNameWithSpaces(String returnType, int spaceCount) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement returnNameField = wait.until(ExpectedConditions.elementToBeClickable(getTxtReturnName()));
		clearField(returnNameField);
		for (int i = 0; i < spaceCount; i++) {
			returnNameField.sendKeys(Keys.SPACE);
		}
		clickRadioButton(returnType);
		clickElementUsingJavaScript(driver, getBtnCreate());
	}

	public void iClose() {
		click(getiClose());

	}

	public void searchAndTryToAddItem(String products, String warningMessage) {
		scrollToElement(getTxtSearchProducts());
		insertValue(getTxtSearchProducts(), products);
		elementToBeClickable(getiSearch());
		clickElementUsingJavaScript(driver, getiSearch());
		elementVisibility(getTextErrorMessageNoMatch());
		assertEquals(getTextErrorMessageNoMatch(), warningMessage);

	}

	public void searchItem(String products) {
		scrollToElement(getTxtSearchProducts());
		insertValue(getTxtSearchProducts(), products);
		elementToBeClickable(getiSearch());
		clickElementUsingJavaScript(driver, getiSearch());

	}

	public void clickAddToReturnWithoutSelectingReason() {
		try {
			WebElement dateInput = wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath("//div[contains(@class,'date pin-date')]//input[@type='date']")));
			clearField(dateInput);
			dateInput.sendKeys("2025-02-15");
		} catch (Exception e) {

		}
		insertValue(getTxtLotLabel(), "1234");
		insertValue(getTxtQty(), "2");
		elementToBeClickable(getBtnAddToReturn());
		clickElementUsingJavaScript(driver, getBtnAddToReturn());

	}

	/**
	 * @see Used to Inserts an invalid date into the return form and attempts to
	 *      submit it. This is typically used for validation testing to ensure the
	 *      system handles invalid dates properly.
	 *
	 * @param invalidDate the invalid date string to input (e.g., "invalid" or an
	 *                    incorrectly formatted date)
	 * @throws InterruptedException if the thread is interrupted while waiting
	 */
	public void insertInvalidDate(String invalidDate) {

		try {
			selectByIndex(getDdReturnReason(), 1);
			WebElement dateInput = driver
					.findElement(By.xpath("//div[contains(@class,'date pin-date')]//input[@type='date']"));
			elementVisibility(dateInput);
			clearField(dateInput);
			dateInput.sendKeys(" 9");
			clickElementUsingJavaScript(driver, getBtnAddToReturn());
		} catch (Exception e) {
		}

	}

	/**
	 * @see Used to validate Ra Number Error message
	 */
	public void submitReturnWithoutRANumber(String items, String returnReason) {
		try {
			scrollToElement(getTxtSearchProducts());
			insertValue(getTxtSearchProducts(), items);
			clickElementUsingJavaScript(driver, getiSearch());
			insertValue(getTxtQty(), "2");
			selectByVisibleText(getDdReturnReason(), returnReason);
			elementVisibility(getTxtRANumber());
			clearField(getTxtRANumber());
			clickElementUsingJavaScript(driver, getBtnAddToReturn());
		} catch (Exception e) {
		}
	}

	/**
	 * @see Used to Updates the item details in a grid with the provided expiration
	 *      date, lot number, quantity, return reason, and RA number (if
	 *      applicable).
	 * @param expirationDateGrid the expiration date to input (format: YYYY-MM-DD)
	 * @param lotNumber          the lot number to input
	 * @param qty                the quantity to input
	 * @param returnReason       the return reason to select from the dropdown; may
	 *                           trigger RA number input
	 */
	public void addReturnItemwithNillQty(String product, String expirationDate, String lotNumber, String quantity,
			String returnReason, String warningmessage) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		scrollToElement(getTxtSearchProducts());
		elementVisibility(getTxtSearchProducts());
		insertValue(getTxtSearchProducts(), product);
		elementToBeClickable(getiSearch());
		clickElementUsingJavaScript(driver, getiSearch());
		try {
			WebElement dateInput = wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("(//div[contains(@class, 'date pin-date')]//following::input[@type='date'])[1]")));
			elementVisibility(dateInput);
			clearTextUsingjs(dateInput);
			dateInput.sendKeys(expirationDate);
		} catch (Exception e) {
			System.out.println("Expiration date input not found. Skipping date entry.");
		}
		wait.until(ExpectedConditions.visibilityOf(getTxtLotLabel()));
		insertValue(getTxtLotLabel(), lotNumber);
		wait.until(ExpectedConditions.visibilityOf(getTxtQty()));
		getTxtQty().clear();
		getTxtQty().sendKeys(quantity);
		wait.until(ExpectedConditions.elementToBeClickable(getDdReturnReasonsRefineSearch()));
		selectByVisibleText(getDdReturnReasonsRefineSearch(), returnReason);
		if (returnReason.contains("Customer Service Authorized")) {
			try {
				WebElement raInput = wait.until(ExpectedConditions.visibilityOf(getTxtRANumber()));
				insertValue(raInput, "1234");
			} catch (TimeoutException ignored) {
				System.out.println("RA Number field not visible, skipping.");
			}
		}
		try {
			if (isElementEnabled(getCbxCase())) {
				clickElementUsingJavaScript(driver, getCbxCase());
			}
		} catch (Exception e) {
			System.out.println("Case checkbox not clickable.");
		}
		wait.until(ExpectedConditions.elementToBeClickable(getBtnAddToReturn()));
		clickElementUsingJavaScript(driver, getBtnAddToReturn());
		assertEquals(getErrorMessageReturnQty(), warningmessage);
	}

	/**
	 * @see used to Upate Return quantity in Grid
	 */
	public void updateReturnQtyinList(String updateQty) {
		try {
			clearField(getTxtQtyinGrid());
			insertValue(getTxtQtyinGrid(), updateQty);
		} catch (Exception e) {
		}
		clickElementUsingJavaScript(driver, getTxtLotNumberGrid());
	}

	/**
	 * @see Used to insert Invalid date in grid
	 * @param invalidDate
	 * @throws InterruptedException
	 */
	public void invalidExpirationDateInGrid(String invalidDate) throws InterruptedException {
		try {
			WebElement dateInput = driver
					.findElement(By.xpath("((//td[@role='gridcell'])[1]//following::input[@type='date'])[1]"));
			clearTextUsingjs(dateInput);
			Thread.sleep(2000);
			clearField(dateInput);
			dateInput.sendKeys("m0#2");
			keyDown(Keys.ENTER);
			keyUp(Keys.ENTER);
			clickElementUsingJavaScript(driver, getTxtLotNumberGrid());
			doubleClick(getTxtQtyinGrid());
			keyDown(Keys.ENTER);
			keyUp(Keys.ENTER);
		} catch (Exception e) {
		}

	}

	public void addToReturn() {
		elementToBeClickable(getBtnAddToReturn());
		clickElementUsingJavaScript(driver, getBtnAddToReturn());
	}

	/**
	 * Drives the C2 return flow, validating each required field’s error message in
	 * turn: 1) Date missing 2) Lot Number missing 3) Quantity invalid 4) Return
	 * Reason missing Finally selects a valid return reason to complete the form.
	 *
	 * @param itemCode    The product code to search and add.
	 * @param dateError   Expected error when date is not set.
	 * @param lotError    Expected error when lot number is not set.
	 * @param qtyError    Expected error for invalid quantity.
	 * @param reasonError Expected error when return reason is not set.
	 */
	public void c2FieldErrorValidation(String searchProducts, String dateErrorMessage, String errorMessageLotNumber,
			String errorMessageQty, String ErrorMessageReturnReason) throws InterruptedException {
		try {
			scrollToElement(getTxtSearchProducts());
			insertValue(getTxtSearchProducts(), searchProducts);
			elementToBeClickable(getiSearch());
			clickElementUsingJavaScript(driver, getiSearch());
			addToReturn();
			verifyAndCloseError(getErrorMessagDate(), dateErrorMessage);

			setDate("2025-02-15");
			addToReturn();
			verifyAndCloseError(getErrorMessageLotNumber(), errorMessageLotNumber);

			insertValue(getTxtLotLabel(), "1234");
			clearTextUsingjs(getTxtQty());
			insertValue(getTxtQty(), "0");
			addToReturn();
			verifyAndCloseError(getErrorMessageReturnQty(), errorMessageQty);

			Thread.sleep(2000);
			clearTextUsingjs(getTxtQty());
			insertValue(getTxtQty(), "2");
			addToReturn();
			verifyAndCloseError(getErrorMessageReturnReason(), ErrorMessageReturnReason);

			String returnReason = "CII – 6 Months or Greater dating remain";
			selectByVisibleText(getDdReturnReason(), returnReason);
		} catch (Exception e) {
		}
	}

	/** Clears and sets the HTML5 date field */
	private void setDate(String isoDate) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		try {
			WebElement dateInput = wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath("//div[contains(@class,'date pin-date')]//input[@type='date']")));
			clearField(dateInput);
			dateInput.sendKeys(isoDate);
		} catch (TimeoutException e) {
			System.err.println("Date field not ready: " + e.getMessage());
		}
	}

	public void verifyAndCloseError(WebElement errorElem, String expectedMessage) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		WebElement e = wait.until(ExpectedConditions.visibilityOf(errorElem));
		assertEquals(e, expectedMessage);
		clickElementUsingJavaScript(driver, getiClose());
	}

	public void validateClosedOutItemReturnReasons(String expectedErrorMessage) {

		String validReturnReason = "NR– (Customer Service Authorized)";

		setDate("08-01-2025");
		insertValue(getTxtLotLabel(), "124");
		insertValue(getTxtQty(), "1");

		Select reasonDropdown = new Select(getDdReturnReason());
		List<WebElement> allReasons = reasonDropdown.getOptions();
		for (WebElement reason : allReasons) {
			String reasonText = reason.getText().trim();

			if (reasonText.contains("NR – Customer Service Authorized")) {
				System.out.println("Skipping valid return reason: " + reasonText);
				continue;
			}
			selectByVisibleText(getDdReturnReason(), reasonText);
			clickElementUsingJavaScript(driver, getBtnAddToReturn());

			if (!reasonText.equals(validReturnReason)) {
				WebElement error = wait.until(ExpectedConditions.visibilityOf(getWarningMessage()));
				assertEquals(error, expectedErrorMessage);
				getiClose();
			}
		}
	}

	public void selectsCbxDontWantBack() {
		clickElementUsingJavaScript(driver, getCbxDontwantBack());
	}
}
