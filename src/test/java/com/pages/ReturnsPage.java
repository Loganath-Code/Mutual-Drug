package com.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.base.BaseClass;

public class ReturnsPage extends BaseClass {

	public ReturnsPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//h2[text()='Returns']")
	private WebElement titleReturns;

	@FindBy(xpath = "//input[@placeholder='Search for Returns']")
	private WebElement txtSearchReturns;

	@FindBy(xpath = "(//a[@href='/member/returns'])[2]")
	private WebElement lnkReturns;

	@FindBy(xpath = "(//i[@class='fa fa-search'])[2]")
	private WebElement iSearchReturns;

	@FindBy(xpath = "(//i[@class='fa fa-trash'])[1]")
	private WebElement iTrashReturns;

	@FindBy(xpath = "//button[text()='Yes']")
	private WebElement btnYes;

	@FindBy(xpath = "//div[@aria-label='Return details deleted.']")
	private WebElement alMeassageDelete;

	@FindBy(xpath = "//tbody//tr[1]//td[1]")
	private WebElement tdFirstcell;

	@FindBy(xpath = "(//span[@class='val'])[1]//parent::td")
	private WebElement firstReturnName;

	@FindBy(xpath = "(//th[@role='columnheader'])[3]")
	private WebElement titleSubmittedDate;

	@FindBy(xpath = "//button[text()=' Create New']")
	private WebElement btnCreateNew;

	@FindBy(xpath = "//input[@name='returnName']")
	private WebElement txtReturnName;

	@FindBy(xpath = "//button[@class='modal-btn']")
	private WebElement btnCreate;

	@FindBy(xpath = "//div[text()='Return Name is required']")
	private WebElement errorMessageReturnName;

	@FindBy(xpath = "//div[text()='Return Type is required']")
	private WebElement errorMessageReturnType;

	@FindBy(xpath = "//div[text()='Special characters not allowed']")
	private WebElement errorMessageSpecialChars;

	@FindBy(xpath = "//input[@name='returnName']")
	private WebElement txtReturnOrderName;

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

	@FindBy(xpath = "(//select[contains(@class, 'form-control') and contains(@class, 'ng-pristine')])[2]")
	private WebElement ddReturnReasonsRefineSearch;

	@FindBy(xpath = "//div[@class='col-lg-1 col-xs-12 col-sm-6 lot ng-star-inserted']//input[@type='text']")
	private WebElement txtRANumber;

	@FindBy(xpath = "//span[@class='checkmark']")
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

	@FindBy(xpath = "//input[@class='form-control order-qty ng-pristine ng-valid ng-touched']")
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

	public WebElement getTitleReturns() {
		return titleReturns;
	}

	public WebElement getTxtSearchReturns() {
		return txtSearchReturns;
	}

	public WebElement getLnkReturns() {
		return lnkReturns;
	}

	public WebElement getiSearchReturns() {
		return iSearchReturns;
	}

	public WebElement getBtnYes() {
		return btnYes;
	}

	public WebElement getAlMeassageDelete() {
		return alMeassageDelete;
	}

	public WebElement getiTrashReturns() {
		return iTrashReturns;
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

	public void createReturnOrder(String returnName, String returnType) {
		clickElementUsingJavaScript(driver, getBtnCreateNew());
		insertValue(getTxtReturnName(), returnName);
		clickRadioButton(returnType);
		click(getBtnCreate());

	}

	public boolean isElementVisible(WebElement element) {
		try {
			return element.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}

	public void deleteReturDetails() {
		SubmittedDateSorting();
		try {
			clickElementUsingJavaScript(driver, getiTrashReturns());
			elementVisibility(getBtnYes());
			clickElementUsingJavaScript(driver, getBtnYes());
		} catch (Exception e) {

		}
	}

	public void addReturnProducts(String searchProducts, String expirationDate, String lotNumber, String qty,
			String returnReason, String successMessage) throws InterruptedException {
		Thread.sleep(2000);
		scrollToElement(getTxtSearchProducts());
		insertValue(getTxtSearchProducts(), searchProducts);
		clickElementUsingJavaScript(driver, getiSearch());
		try {
			WebElement dateInput = driver.findElement(
					By.xpath("//div[@class='col-lg-2 col-xs-12 col-sm-4 date pin-date']//input[@type='date']"));
			clearTextUsingjs(dateInput);
			Thread.sleep(2000);
			dateInput.sendKeys("15-02-2025");
		} catch (Exception e) {
		}
		insertValue(getTxtLotLabel(), lotNumber);
		insertValue(getTxtQty(), qty);
		selectByVisibleText(getDdReturnReason(), returnReason);
		try {
			if (returnReason.equals("NR – Customer Service Authorized")) {
				if (isElementVisible(getTxtRANumber())) {
					insertValue(getTxtRANumber(), "1234");
				}
			}
		} catch (Exception e) {

		}
//		clickElementUsingJavaScript(driver, getCbxCase());
		clickElementUsingJavaScript(driver, getBtnAddToReturn());
		assertEquals(getAlertMessageAddReturnItems(), successMessage);

	}

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

	public void insertSignSubmitDetail(String authorisedSignature, String title, String signatureFont) {
		insertValue(getTxtAuthorizedSignature(), authorisedSignature);
		insertValue(getTxtTitle(), title);
		selectOptioninDropDown(driver, getDdSignatureFont(), signatureFont);
		click(getBtnSignsubmit());
	}

	public void c2ReturnItems(String searchProducts, String expirationDate, String lotNumber, String qty,
			String returnReason, String successMessage) {
		try {
			visibilityofElementLocated(getTxtSearchProducts());
			insertValue(getTxtSearchProducts(), searchProducts);
			clickElementUsingJavaScript(driver, getiSearch());
			elementVisibility(getTxtExpirationDate());
			clearTextUsingjs(getTxtExpirationDate());
			WebElement dateInput = driver.findElement(By.xpath("//input[@type='date']"));
			clearTextUsingjs(dateInput);
			dateInput.sendKeys(expirationDate);
			insertValue(getTxtLotLabel(), lotNumber);
			insertValue(getTxtQty(), qty);
			selectByVisibleText(getDdReturnReason(), returnReason);
			clickElementUsingJavaScript(driver, getBtnAddToReturn());
			assertEquals(getAlertMessageAddReturnItems(), successMessage);
		} catch (Exception e) {

		}
	}

	public void refrigeratedReturns(String searchRefrigeratedProducts, String expirationDate, String lotNumber,
			String qty, String returnReason, String successMessage) throws InterruptedException {
		insertValue(getTxtSearchProducts(), searchRefrigeratedProducts);
		clickElementUsingJavaScript(driver, getiSearch());
		Thread.sleep(2000);
		try {
			Thread.sleep(2000);
			visibilityofElementLocated(getTxtExpirationDate());
			clearTextUsingjs(getTxtExpirationDate());
			WebElement dateInput = driver.findElement(By.xpath("//input[@type='date']"));
			clearTextUsingjs(dateInput);
			dateInput.sendKeys(expirationDate);
		} catch (Exception e) {

		}
		insertValue(getTxtLotLabel(), lotNumber);
		insertValue(getTxtQty(), qty);
		selectByVisibleText(getDdReturnReason(), returnReason);
		try {
			if (returnReason.equals("Refrigerated – (Customer Service Authorized)")) {
				if (isElementVisible(getTxtRANumber())) {
					insertValue(getTxtRANumber(), "1234");
				}
			}
		} catch (Exception e) {

		}
		// clickElementUsingJavaScript(driver, getCbxDontwantBack());
		try {
			clickElementUsingJavaScript(driver, getBtnAddToReturn());
			assertEquals(getAlertMessageAddReturnItems(), successMessage);
		} catch (Exception e) {

		}
	}

	public void performSorting() {
		clickElementUsingJavaScript(driver, getMat_Sort_header_Items());
		clickElementUsingJavaScript(driver, getMat_Sort_header_ProductDescription());

	}

	public void refineSearchRegularItems(String addSearchProducts, String refineSearch, String category, String sortBy,
			String sortOrder, String lotNumber, String qty, String returnReasons, String successMessage)
			throws InterruptedException {
//		try {
		insertValue(getTxtSearchProducts(), addSearchProducts);
		Thread.sleep(2000);
		clickElementUsingJavaScript(driver, getiSearch());
		visibilityofElementLocated(getTxtRefineSearch());
		insertValue(getTxtRefineSearch(), refineSearch);
		visibilityofElementLocated(getTxtRefineSearch());
		clickElementUsingJavaScript(driver, getTxtRefineSearch());
		insertValue(getTxtRefineSearch(), refineSearch);
		keyDown(Keys.ENTER);
		keyUp(Keys.ENTER);
		elementVisibility(getDdCategory());
		selectByVisibleText(getDdCategory(), category);
		elementVisibility(getDdRelevance());
		selectByVisibleText(getDdRelevance(), sortBy);
		selectByVisibleText(getDdSortOrder(), sortOrder);
		Thread.sleep(2000);
		WebElement dateInput = driver.findElement(By.xpath("(//input[@type='date'])[1]"));
		clearTextUsingjs(dateInput);
		dateInput.sendKeys("05-03-2025");
		getTxtLotLabel().sendKeys("1234");
		getTxtQty().clear();
		getTxtQty().sendKeys("1");
		Thread.sleep(3000);
		selectByVisibleText(getDdReturnReasonsRefineSearch(), returnReasons);
		try {
			if (returnReasons.equals("NR – Customer Service Authorized")) {
				if (isElementVisible(getTxtRANumber())) {
					insertValue(getTxtRANumber(), "1234");
				}
			}
		} catch (Exception e) {

		}
		clickElementUsingJavaScript(driver, getCbxCase());
		clickElementUsingJavaScript(driver, getBtnAddToReturn());
		assertEquals(getAlertMessageAddReturnItems(), successMessage);
//		} catch (Exception e) {
//		}

	}

	public void refineSearchC2Items(String addSearchProducts, String refineSearch, String category, String sortBy,
			String sortOrder, String lotNumber, String qty, String returnReason, String successMessage) {
		try {
			insertValue(getTxtSearchProducts(), addSearchProducts);
			Thread.sleep(2000);
			clickElementUsingJavaScript(driver, getiSearch());
			visibilityofElementLocated(getTxtRefineSearch());
			insertValue(getTxtRefineSearch(), refineSearch);
			clickElementUsingJavaScript(driver, getTxtRefineSearch());
			keyDown(Keys.ENTER);
			keyUp(Keys.ENTER);
			elementVisibility(getDdCategory());
			selectByVisibleText(getDdCategory(), category);
			elementVisibility(getDdRelevance());
			selectByVisibleText(getDdRelevance(), sortBy);
			selectByVisibleText(getDdSortOrder(), sortOrder);
			Thread.sleep(2000);
			WebElement dateInput = driver.findElement(By.xpath("(//input[@type='date'])[1]"));
			clearTextUsingjs(dateInput);
			dateInput.sendKeys("05-03-2025");
			insertValue(getTxtLotLabel(), lotNumber);
			insertValue(getTxtQty(), qty);
			selectByVisibleText(getDdReturnReason(), returnReason);
			clickElementUsingJavaScript(driver, getBtnAddToReturn());
			assertEquals(getAlertMessageAddReturnItems(), successMessage);
		} catch (Exception e) {
		}
	}

	/**
	 * @see Used to Perform refine search in C2 returns
	 * @param addSearchProducts
	 * @param refineSearch
	 * @param category
	 * @param sortBy
	 * @param sortOrder
	 * @param lotNumber
	 * @param qty
	 * @param returnReason
	 * @param successMessage
	 * @throws InterruptedException 
	 */
	public void refineSearchRefrigeratedItems(String addSearchProducts, String refineSearch, String category,
			String sortBy, String sortOrder, String lotNumber, String qty, String returnReason, String successMessage) throws InterruptedException {
		Thread.sleep(1000);
		try {
			insertValue(getTxtSearchProducts(), addSearchProducts);
			Thread.sleep(2000);
			clickElementUsingJavaScript(driver, getiSearch());
			visibilityofElementLocated(getTxtRefineSearch());
			insertValue(getTxtRefineSearch(), refineSearch);
			Thread.sleep(1000);
			clickElementUsingJavaScript(driver, getiSearch());
			clickElementUsingJavaScript(driver, getTxtRefineSearch());
			keyDown(Keys.ENTER);
			keyUp(Keys.ENTER);
			elementVisibility(getDdCategory());
			selectByVisibleText(getDdCategory(), category);
			elementVisibility(getDdRelevance());
			selectByVisibleText(getDdRelevance(), sortBy);
			selectByVisibleText(getDdSortOrder(), sortOrder);
			WebElement dateInput = driver.findElement(By.xpath("(//input[@type='date'])[1]"));
			clearTextUsingjs(dateInput);
			dateInput.sendKeys("05-03-2025");
			insertValue(getTxtLotLabel(), lotNumber);
			insertValue(getTxtQty(), qty);
			selectByVisibleText(getDdReturnReason(), returnReason);
			try {
				if (returnReason.equals("Refrigerated – (Customer Service Authorized)")) {
					if (isElementVisible(getTxtRANumber())) {
						insertValue(getTxtRANumber(), "1234");
					}
				}
			} catch (Exception e) {

			}
			clickElementUsingJavaScript(driver, getBtnAddToReturn());
//			assertEquals(getAlertMessageAddReturnItems(), successMessage);
		} catch (Exception e) {

		}
	}

	/**
	 * @See used to update Regular returns in Grid
	 * @param expirationDateGrid
	 * @param lotNumberGrid
	 * @param qtyGrid
	 * @param returnReasonGrid
	 * @param updateAlertMessage
	 * @throws InterruptedException
	 */
	public void updateRegularReturns(String expirationDateGrid, String lotNumberGrid, String qtyGrid,
			String returnReasonGrid, String updateAlertMessage) throws InterruptedException {
		try {
			Thread.sleep(2000);
			elementVisibility(getTxtExpirationDateinGrid());
			clearTextUsingjs(getTxtExpirationDateinGrid());
			WebElement dateInput = driver
					.findElement(By.xpath("((//td[@role='gridcell'])[1]//following::input[@type='date'])[1]"));
			clearTextUsingjs(dateInput);
			dateInput.sendKeys("05-03-2025");
		} catch (Exception e) {
		}
		try {
			insertValue(getTxtLotNumberGrid(), lotNumberGrid);
			insertValue(getTxtQty(), qtyGrid);
			selectByVisibleText(getDdReturnReasoninGrid(), returnReasonGrid);
		} catch (Exception e) {
		}
		try {
			if (returnReasonGrid.equals("NR – Customer Service Authorized")) {
				if (isElementVisible(getTxtRANumber())) {
					insertValue(getTxtRANumber(), "1234");
				}
			}
		} catch (Exception e) {

		}
		try {
			clickElementUsingJavaScript(driver, getTxtLotNumberGrid());
			assertEquals(getAlUpdateMessage(), updateAlertMessage);
			clickElementUsingJavaScript(driver, getiClose());
		} catch (Exception e) {
		}

	}

	/**
	 * @see Used to update Refrigerate Items in grid
	 * @param expirationDateGrid
	 * @param lotNumberGrid
	 * @param qtyGrid
	 * @param returnReasonGrid
	 * @param updateAlertMessage
	 */
	public void updateRefrigeratedItems(String expirationDateGrid, String lotNumberGrid, String qtyGrid,
			String returnReasonGrid, String updateAlertMessage) {
		try {
			Thread.sleep(2000);
			elementVisibility(getTxtExpirationDate());
			clearTextUsingjs(getTxtExpirationDate());
			WebElement dateInput = driver.findElement(By.xpath("//input[@type='date']"));
			clearTextUsingjs(dateInput);
			dateInput.sendKeys("05-03-2025");
		} catch (Exception e) {
		}
		insertValue(getTxtLotNumberGrid(), lotNumberGrid);
		insertValue(getTxtQty(), qtyGrid);
		selectByVisibleText(getDdReturnReason(), returnReasonGrid);
		try {
			if (returnReasonGrid.equals("Refrigerated – (Customer Service Authorized)")) {
				if (isElementVisible(getTxtRANumber())) {
					insertValue(getTxtRANumber(), "1234");
				}
			}
		} catch (Exception e) {

		}
		try {
			clickElementUsingJavaScript(driver, getTxtLotNumberGrid());
			clickElementUsingJavaScript(driver, getTxtQty());
//			assertEquals(getAlUpdateMessage(), updateAlertMessage);
		} catch (Exception e) {

		}
	}

	/**
	 * @see Used to delete Return item in Grid
	 */
	public void deleteIteminGrid() {
		clickElementUsingJavaScript(driver, getiTrash());

	}

	/**
	 * @see Used to perform Ascending and Descending order in Item#
	 */
	public void itemsNumberSorting() {
		clickElementUsingJavaScript(driver, getSortingItems());
		WebElement sortedColumn = driver.findElement(By.xpath("(//th[@role='columnheader'])[1]"));
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

		} else if ("descending".equals(ariaSort)) {

			System.out.println(" The column is initially sorted in descending order.");
			clickElementUsingJavaScript(driver, sortedColumn);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			ariaSort = sortedColumn.getAttribute("aria-sort");
			System.out.println("Sorting Order After Click: " + ariaSort);

			if ("ascending".equals(ariaSort)) {
				System.out.println("The column is now sorted in ascending order.");
			} else {
				System.out.println("The column is not sorted in ascending order after clicking.");
			}

		} else {
			System.out.println("`The column sorting order is neither ascending nor descending.");
		}

	}

	/**
	 * @see Used to perform Ascending and Descending order in Product Discriptions
	 */
	public void productDiscriptionsSorting() {
		clickElementUsingJavaScript(driver, getSortingProductsDiscriptions());
		WebElement sortedColumn = driver.findElement(By.xpath("(//th[@role='columnheader'])[2]"));
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

		} else if ("descending".equals(ariaSort)) {

			System.out.println(" The column is initially sorted in descending order.");
			clickElementUsingJavaScript(driver, sortedColumn);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			ariaSort = sortedColumn.getAttribute("aria-sort");
			System.out.println("Sorting Order After Click: " + ariaSort);

			if ("ascending".equals(ariaSort)) {
				System.out.println("The column is now sorted in ascending order.");
			} else {
				System.out.println("The column is not sorted in ascending order after clicking.");
			}

		} else {
			System.out.println("`The column sorting order is neither ascending nor descending.");
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

	/**
	 * @see Used to Update Return Name
	 * @param returnName
	 */
	public void updateReturnName(String returnName) {
		insertValue(getTxtReturnName(), returnName);
		clickElementUsingJavaScript(driver, getTextStatus());
	}

	public void removeReturnName() {
		try {
			scrollToElement(getTxtReturnName());
			clearTextUsingjs(getTxtReturnName());
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void SubmittedDateSorting() {
		clickElementUsingJavaScript(driver, getTitleSubmittedDate());
		WebElement sortedColumn = driver.findElement(By.xpath("(//th[@role='columnheader'])[3]"));

		String ariaSort = sortedColumn.getAttribute("aria-sort");
		System.out.println("Sorting Order: " + ariaSort);

		if ("ascending".equals(ariaSort)) {
			clickElementUsingJavaScript(driver, sortedColumn);
			ariaSort = sortedColumn.getAttribute("aria-sort");
			System.out.println("Sorting Order After Click: " + ariaSort);
		}

		if ("descending".equals(ariaSort)) {
			System.out.println("✅ Dates are sorted in descending order.");

		} else {
			System.out.println(" Dates are NOT sorted in descending order.");
		}
	}

	public void navigatesReturns() {
		scrollToElement(getLnkReturns());
		clickElementUsingJavaScript(driver, getLnkReturns());

	}

	public void searchReturnsName(String returnName) {
		insertValue(getTxtSearchReturns(), returnName);
	}

	public void returnsWithoutName() throws InterruptedException {
		clickElementUsingJavaScript(driver, getBtnCreateNew());
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement returnNameField = wait.until(ExpectedConditions.elementToBeClickable(getTxtReturnName()));
		// Select all text
		returnNameField.sendKeys(Keys.chord(Keys.CONTROL, "a"));
		// Delete the selected text
		returnNameField.sendKeys(Keys.BACK_SPACE);
		clickElementUsingJavaScript(driver, getBtnCreate());
	}

	public void returnNameWithSpecialChar(String special, String returnType) {
		clearTextUsingjs(getTxtReturnName());
		insertValue(getTxtReturnName(), special);
		clickRadioButton(returnType);
		clickElementUsingJavaScript(driver, getBtnCreate());
	}

	public void returnNameWithSpace(String returnType) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement returnNameField = wait.until(ExpectedConditions.elementToBeClickable(getTxtReturnName()));
		// Select all text
		returnNameField.sendKeys(Keys.chord(Keys.CONTROL, "a"));
		// Delete the selected text
		returnNameField.sendKeys(Keys.BACK_SPACE);
		returnNameField.sendKeys(Keys.SPACE);
		clickRadioButton(returnType);
		clickElementUsingJavaScript(driver, getBtnCreate());

	}

	public void returnNameWithDoubleSpace(String returnType) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement returnNameField = wait.until(ExpectedConditions.elementToBeClickable(getTxtReturnName()));
		// Select all text
		returnNameField.sendKeys(Keys.chord(Keys.CONTROL, "a"));
		// Delete the selected text
		returnNameField.sendKeys(Keys.BACK_SPACE);
		returnNameField.sendKeys(Keys.SPACE);
		returnNameField.sendKeys(Keys.SPACE);
		clickRadioButton(returnType);
		clickElementUsingJavaScript(driver, getBtnCreate());

	}

	public void returnNameWithMaxChar(String returnType) {
		String returnNameMaxChar = " abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnop ";
		insertValue(getTxtReturnName(), returnNameMaxChar);
		clickRadioButton(returnType);
		clickElementUsingJavaScript(driver, getBtnCreate());
	}

	public void regularReturnsDiscountinedItems(String items, String warningMessage) {
		scrollToElement(getTxtSearchProducts());
		insertValue(getTxtSearchProducts(), items);
		clickElementUsingJavaScript(driver, getiSearch());
		elementVisibility(getTextErrorMessageNoMatch());
		assertEquals(getTextErrorMessageNoMatch(), warningMessage);

	}

	public void returnReasonValidate(String itemNumber) throws InterruptedException {
		scrollToElement(getTxtSearchProducts());
		insertValue(getTxtSearchProducts(), itemNumber);
		clickElementUsingJavaScript(driver, getiSearch());
		try {
			WebElement dateInput = driver.findElement(
					By.xpath("//div[@class='col-lg-2 col-xs-12 col-sm-4 date pin-date']//input[@type='date']"));
			clearTextUsingjs(dateInput);
			Thread.sleep(2000);
			dateInput.sendKeys("15-02-2025");
		} catch (Exception e) {
		}
		insertValue(getTxtLotLabel(), "1234");
		insertValue(getTxtQty(), "2");
		Thread.sleep(2000);
		clickElementUsingJavaScript(driver, getBtnAddToReturn());
	}

	public void validateReturnQty(String searchProducts, String expirationDate, String lotNumber, String qty,
			String returnReason, String warningmessage) throws InterruptedException {
		Thread.sleep(2000);
		scrollToElement(getTxtSearchProducts());
		insertValue(getTxtSearchProducts(), searchProducts);
		clickElementUsingJavaScript(driver, getiSearch());
		try {
			WebElement dateInput = driver.findElement(
					By.xpath("//div[@class='col-lg-2 col-xs-12 col-sm-4 date pin-date']//input[@type='date']"));
			clearTextUsingjs(dateInput);
			Thread.sleep(2000);
			dateInput.sendKeys("15-02-2025");
		} catch (Exception e) {
		}
		insertValue(getTxtLotLabel(), lotNumber);
		insertValue(getTxtQty(), qty);
		selectByVisibleText(getDdReturnReason(), returnReason);
		try {
			if (returnReason.equals("NR – Customer Service Authorized")) {
				if (isElementVisible(getTxtRANumber())) {
					insertValue(getTxtRANumber(), "1234");
				}
			}
		} catch (Exception e) {

		}
//		clickElementUsingJavaScript(driver, getCbxCase());
		clickElementUsingJavaScript(driver, getBtnAddToReturn());
		assertEquals(getErrorMessageReturnQty(), warningmessage);
		clickElementUsingJavaScript(driver, getiClose());

	}

	public void updateReturnQty(String updateQty) {
		try {
			getTxtQty().sendKeys(Keys.chord(Keys.CONTROL, "a"));
			getTxtQty().sendKeys(Keys.BACK_SPACE);
			insertValue(getTxtQty(), updateQty);
			insertValue(getTxtQty(), "0");
			clickElementUsingJavaScript(driver, getTxtLotNumberGrid());
		} catch (Exception e) {
		}
	}

	public void c2ReturnsDiscont(String items, String warningMessage) {
		scrollToElement(getTxtSearchProducts());
		insertValue(getTxtSearchProducts(), items);
		clickElementUsingJavaScript(driver, getiSearch());
		elementVisibility(getTextErrorMessageNoMatch());
		assertEquals(getTextErrorMessageNoMatch(), warningMessage);

	}

	public void insertInvalidDate(String invalidDate) throws InterruptedException {

		try {
			selectByIndex(getDdReturnReason(), 1);
			WebElement dateInput = driver.findElement(
					By.xpath("//div[@class='col-lg-2 col-xs-12 col-sm-4 date pin-date']//input[@type='date']"));
			clearTextUsingjs(dateInput);
			dateInput.sendKeys(Keys.chord(Keys.CONTROL, "a"));
			dateInput.sendKeys(Keys.BACK_SPACE);
			dateInput.sendKeys(" 9");
			clickElementUsingJavaScript(driver, getBtnAddToReturn());
		} catch (Exception e) {
		}

	}

	public void c2FieldErrorValidation(String searchProducts, String dateErrorMessage, String errorMessageLotNumber,
			String errorMessageQty, String ErrorMessageReturnReason) throws InterruptedException {
//		try {
		scrollToElement(getTxtSearchProducts());
		insertValue(getTxtSearchProducts(), searchProducts);
		clickElementUsingJavaScript(driver, getiSearch());
		clickElementUsingJavaScript(driver, getBtnAddToReturn());
		elementVisibility(getErrorMessagDate());
		assertEquals(getErrorMessagDate(), dateErrorMessage);
		clickElementUsingJavaScript(driver, getiClose());
		try {
			WebElement dateInput = driver.findElement(
					By.xpath("//div[@class='col-lg-2 col-xs-12 col-sm-4 date pin-date']//input[@type='date']"));
			clearTextUsingjs(dateInput);
			Thread.sleep(2000);
			dateInput.sendKeys("15-02-2025");
		} catch (Exception e) {
		}
		clickElementUsingJavaScript(driver, getBtnAddToReturn());
		assertEquals(getErrorMessageLotNumber(), errorMessageLotNumber);
		clickElementUsingJavaScript(driver, getiClose());
		insertValue(getTxtLotLabel(), "1234");
		clearTextUsingjs(getTxtQty());
		insertValue(getTxtQty(), "0");
		clickElementUsingJavaScript(driver, getBtnAddToReturn());
		assertEquals(getErrorMessageReturnQty(), errorMessageQty);
		clickElementUsingJavaScript(driver, getiClose());
		Thread.sleep(2000);
		clearTextUsingjs(getTxtQty());
		insertValue(getTxtQty(), "2");
		clickElementUsingJavaScript(driver, getBtnAddToReturn());
		assertEquals(getErrorMessageReturnReason(), ErrorMessageReturnReason);
		clickElementUsingJavaScript(driver, getiClose());
		String returnReason = "CII – 6 Months or Greater dating remain";
		selectByVisibleText(getDdReturnReason(), returnReason);
//		} catch (Exception e) {
//		}
	}

	public void selectsCbxDontWantBack() {
		clickElementUsingJavaScript(driver, getCbxDontwantBack());

	}

	/**
	 * @see Used to verify discountinued items
	 * @param items
	 * @param warningMessage
	 */
	public void refrigeratedDiscountinuedReturns(String items, String warningMessage) {
		scrollToElement(getTxtSearchProducts());
		insertValue(getTxtSearchProducts(), items);
		clickElementUsingJavaScript(driver, getiSearch());
		elementVisibility(getTextErrorMessageNoMatch());
		assertEquals(getTextErrorMessageNoMatch(), warningMessage);

	}

	/**
	 * @see used to Upate Return quantity
	 */
	public void returnQty() throws InterruptedException {
		try {
			clearTextUsingjs(getTxtQty());
			getTxtQty().sendKeys(Keys.chord(Keys.CONTROL, "a"));
			getTxtQty().sendKeys(Keys.BACK_SPACE);
			insertValue(getTxtQty(), "0");
			clickElementUsingJavaScript(driver, getBtnAddToReturn());
		} catch (Exception e) {

		}
	}

	/**
	 * @see used to Upate Return quantity in Grid
	 */
	public void updateReturnQty() {
		try {
			clearTextUsingjs(getTxtQtyinGrid());
			getTxtQtyinGrid().sendKeys(Keys.chord(Keys.CONTROL, "a"));
			getTxtQtyinGrid().sendKeys(Keys.BACK_SPACE);
			insertValue(getTxtQtyinGrid(), "0");
		} catch (Exception e) {

		}
		clickElementUsingJavaScript(driver, getTxtLotNumberGrid());
	}

	/**
	 * @see Used to validate Ra Number Error message
	 */
	public void refrigeratedReturnReason(String items, String returnReason) {
//		try {
		scrollToElement(getTxtSearchProducts());
		insertValue(getTxtSearchProducts(), items);
		clickElementUsingJavaScript(driver, getiSearch());
		insertValue(getTxtQty(), "2");
		selectByVisibleText(getDdReturnReason(), returnReason);
		elementVisibility(getTxtRANumber());
		getTxtRANumber().sendKeys(Keys.chord(Keys.CONTROL, "a"));
		getTxtRANumber().sendKeys(Keys.BACK_SPACE);
		clickElementUsingJavaScript(driver, getBtnAddToReturn());
//		} catch (Exception e) {
//		}
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
			dateInput.sendKeys(Keys.chord(Keys.CONTROL, "a"));
			// Delete the selected text
			dateInput.sendKeys(Keys.BACK_SPACE);
			dateInput.sendKeys("90");
			keyDown(Keys.ENTER);
			keyUp(Keys.ENTER);
			clickElementUsingJavaScript(driver, getTxtLotNumberGrid());
			doubleClick(getTxtQtyinGrid());
			keyDown(Keys.ENTER);
			keyUp(Keys.ENTER);
		} catch (Exception e) {
		}

	}

	/**
	 * @see Used sorting in returns webpage
	 */
	public void returnsSorting() {
		String[] columnNames = { "Return Name", "Status", "Submitted Date", "Submitted By", "Type", "Total Lines",
				"Total Pieces" };

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

}