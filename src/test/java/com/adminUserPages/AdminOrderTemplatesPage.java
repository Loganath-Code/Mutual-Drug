package com.adminUserPages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.base.BaseClass;

public class AdminOrderTemplatesPage extends BaseClass {

	public AdminOrderTemplatesPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//h2[text()='Order Templates']")
	private WebElement titleOrderTemplates;

	@FindBy(xpath = "//button[text()='Create New']")
	private WebElement btnCreateNew;

	@FindBy(xpath = "//input[@placeholder='Template Name']")
	private WebElement txtTemplateName;

	@FindBy(xpath = "(//span[@class='checkmark'])[1]")
	private WebElement rdobtnRegular;

	@FindBy(xpath = "//button[text()='Create']")
	private WebElement btnCreate;

	@FindBy(xpath = "//button[text()=' Create Customer Order']")
	private WebElement btnCreateCustomerOrder;

	@FindBy(xpath = "//input[@placeholder='Member Number']")
	private WebElement txtMemberNumber;

	@FindBy(xpath = "//input[@placeholder='Search for Templates']")
	private WebElement txtSeachTemplates;

	@FindBy(xpath = "//button[@class='search']")
	private WebElement iSearch;

	@FindBy(xpath = "//div[@aria-label='Customer order created successfully!']")
	private WebElement successMessageCustomerOrderCreated;

	@FindBy(xpath = "(//th[@role='columnheader'])[1]")
	private WebElement thTemplateName;

	@FindBy(xpath = "(//i[@class='fa fa-trash'])[1]")
	private WebElement iDelete;

	@FindBy(xpath = "//button[@class='btn btn-primary modal-btn']")
	private WebElement btnYes;

	@FindBy(xpath = "//div[@aria-label='Template deleted successfully.']")
	private WebElement successMessageTemplateDelete;

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

	@FindBy(xpath = "//div[contains(text(),'Template Name is required')]")
	private WebElement errorMessageTemplateName;

	@FindBy(xpath = "//div[contains(text(),'Special characters not allowed')]")
	private WebElement errorMessageTemplateNamewithSpecialChar;

	@FindBy(xpath = "//div[text()='Template Name must be less than 60 characters']")
	private WebElement errorMessageTemplateNamemaxChar;

	@FindBy(xpath = "//div[contains(text(),'Template Type is required')]")
	private WebElement errorMessageTemplateType;

	@FindBy(xpath = "//div[text()='Member Number is required']")
	private WebElement errorMessageMemberNumber;

	@FindBy(xpath = "//div[text()='Template Name is required']")
	private WebElement errorMessageTemplate;

	// Order

	@FindBy(xpath = "(//a[@href='/admin/templates'])[2]")
	private WebElement bCrumblinkTemplates;

	@FindBy(xpath = "//input[@name='templateName']")
	private WebElement txtUTemplateName;

	@FindBy(xpath = "//input[@name='itemSearch']")
	private WebElement txtItemSearch;

	@FindBy(xpath = "(//input[contains(@class, 'order-qty')])[1]")
	private WebElement txtOrderQty;

	@FindBy(xpath = "//button[text()='Add']")
	private WebElement btnAdd;

	@FindBy(xpath = "(//input[contains(@class, 'order-qty')])[2]")
	private WebElement txtQtyinGrid;

	@FindBy(xpath = "(//i[@class='fa fa-trash']//parent::span)[1]")
	private WebElement tdiDelete;

	@FindBy(xpath = "//button[@class='delete-btn']")
	private WebElement iTrash;

	@FindBy(xpath = "//div[@aria-label='Template item deleted.']")
	private WebElement successMessageTemplateItemDetele;

	@FindBy(xpath = "//div[@aria-label='Template name updated.']")
	private WebElement successMessageTemplateNameUpdate;

	@FindBy(xpath = "//div[contains(text(),'Template Name is required')]")
	private WebElement errorMessageOrderTemplatesName;

	@FindBy(xpath = "//div[@aria-label='Item code is required.']")
	private WebElement warningMessageItemCodeRequired;

	@FindBy(xpath = "//div[@aria-label='Item already added to order.']")
	private WebElement warningMessageItemalreadyAdded;

	@FindBy(xpath = "//div[@aria-label='Item is not found or unavailable for purchase.']")
	private WebElement errorMessageItemnotFound;

	@FindBy(xpath = "//div[@aria-label='Enter valid Order Qty.']")
	private WebElement warningMessageOrderQty;

	@FindBy(xpath = "//div[@aria-label='Max allowed order qty is 999.']")
	private WebElement warningMessageMaxOrderQty;

	@FindBy(xpath = "(//button[@class='close-button'])[1]")
	private WebElement iClose;

	@FindBy(xpath = "//div[@aria-label='Item is not found or unavailable for purchase.']")
	private WebElement errorMessageItemNotFound;

	@FindBy(xpath = "//div[@aria-label='Cannot add C2 item to non C2 order.']")
	private WebElement alertMessageC2Item;

	public WebElement getTitleOrderTemplates() {
		return titleOrderTemplates;
	}

	public WebElement getBtnCreateNew() {
		return btnCreateNew;
	}

	public WebElement getTxtTemplateName() {
		return txtTemplateName;
	}

	public WebElement getRdobtnRegular() {
		return rdobtnRegular;
	}

	public WebElement getBtnCreate() {
		return btnCreate;
	}

	public WebElement getBtnCreateCustomerOrder() {
		return btnCreateCustomerOrder;
	}

	public WebElement getTxtMemberNumber() {
		return txtMemberNumber;
	}

	public WebElement getTxtSeachTemplates() {
		return txtSeachTemplates;
	}

	public WebElement getiSearch() {
		return iSearch;
	}

	public WebElement getSuccessMessageCustomerOrderCreated() {
		return successMessageCustomerOrderCreated;
	}

	public WebElement getThTemplateName() {
		return thTemplateName;
	}

	public WebElement getiDelete() {
		return iDelete;
	}

	public WebElement getBtnYes() {
		return btnYes;
	}

	public WebElement getSuccessMessageTemplateDelete() {
		return successMessageTemplateDelete;
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

	public WebElement getErrorMessageTemplateName() {
		return errorMessageTemplateName;
	}

	public WebElement getErrorMessageTemplateNamewithSpecialChar() {
		return errorMessageTemplateNamewithSpecialChar;
	}

	public WebElement getErrorMessageTemplateNamemaxChar() {
		return errorMessageTemplateNamemaxChar;
	}

	public WebElement getErrorMessageTemplateType() {
		return errorMessageTemplateType;
	}

	public WebElement getErrorMessageMemberNumber() {
		return errorMessageMemberNumber;
	}

	public WebElement getErrorMessageTemplate() {
		return errorMessageTemplate;
	}

	public WebElement getbCrumblinkTemplates() {
		return bCrumblinkTemplates;
	}

	public WebElement getTxtUTemplateName() {
		return txtUTemplateName;
	}

	public WebElement getTxtItemSearch() {
		return txtItemSearch;
	}

	public WebElement getTxtOrderQty() {
		return txtOrderQty;
	}

	public WebElement getBtnAdd() {
		return btnAdd;
	}

	public WebElement getTxtQtyinGrid() {
		return txtQtyinGrid;
	}

	public WebElement getTdiDelete() {
		return tdiDelete;
	}

	public WebElement getSuccessMessageTemplateItemDetele() {
		return successMessageTemplateItemDetele;
	}

	public WebElement getiTrash() {
		return iTrash;
	}

	public WebElement getErrorMessageOrderTemplatesName() {
		return errorMessageOrderTemplatesName;
	}

	public WebElement getWarningMessageItemCodeRequired() {
		return warningMessageItemCodeRequired;
	}

	public WebElement getWarningMessageItemalreadyAdded() {
		return warningMessageItemalreadyAdded;
	}

	public WebElement getErrorMessageItemnotFound() {
		return errorMessageItemnotFound;
	}

	public WebElement getWarningMessageOrderQty() {
		return warningMessageOrderQty;
	}

	public WebElement getWarningMessageMaxOrderQty() {
		return warningMessageMaxOrderQty;
	}

	public WebElement getAlertMessageByItemNumber(String itemsNum) {
		return driver.findElement(By.xpath("//div[contains(@aria-label, 'Item # " + itemsNum + "')]"));
	}

	public WebElement getSuccessMessageTemplateNameUpdate() {
		return successMessageTemplateNameUpdate;
	}

	public WebElement getiClose() {
		return iClose;
	}

	public WebElement getErrorMessageItemNotFound() {
		return errorMessageItemNotFound;
	}

	public WebElement getAlertMessageC2Item() {
		return alertMessageC2Item;
	}

	/**
	 * @see Used to Create New Templates
	 * @param templateName
	 * @param templateType
	 */
	public void createNewTemplates(String templateName, String templateType) {
		try {
			clickElementUsingJavaScript(driver, getBtnCreateNew());
			insertValue(getTxtTemplateName(), templateName);
			clickRadioButton(templateType);
			clickElementUsingJavaScript(driver, getBtnCreate());
		} catch (Exception e) {
		}
	}

	/**
	 * @see Used to add items in Order Tem
	 * @param itemsNum
	 * @param orderQty
	 * @param successMessage
	 * @throws InterruptedException
	 */
	public void addItemsinOrderTemplates(String itemsNum, String orderQty, String successMessage)
			throws InterruptedException {

		elementVisibility(getTxtItemSearch());
		insertValue(getTxtItemSearch(), itemsNum);
		Thread.sleep(1000);
		getTxtItemSearch().sendKeys(Keys.ENTER);
		getTxtOrderQty().sendKeys(Keys.chord(Keys.CONTROL, "a"));
		// Delete the selected text
		getTxtOrderQty().sendKeys(Keys.BACK_SPACE);
		insertValue(getTxtOrderQty(), orderQty);
		click(getBtnAdd());
		assertEquals(getAlertMessageByItemNumber(itemsNum), successMessage);

	}

	public void updateOrderTemplateName(String templateName) {
		elementVisibility(getTxtUTemplateName());
		scrollToElement(getTxtUTemplateName());
		getTxtUTemplateName().sendKeys(Keys.chord(Keys.CONTROL, "a"));
		getTxtUTemplateName().sendKeys(Keys.BACK_SPACE);
		insertValue(getTxtUTemplateName(), templateName);
		clickElementUsingJavaScript(driver, getBtnAdd());
	}

	/**
	 * @see Used to perform sorting in Order Templates Grid
	 */

	public void sorting() {

		String[] columnNames = { "Item #", "Product Description", "Categories", "Order Qty", "Whs. Qty", "Added" };
		try {
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
		} catch (Exception e) {

		}
	}

	public void deleteTemplateItem() {
		clickElementUsingJavaScript(driver, getiDelete());

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

	public void selectOptionByIndex(WebDriver driver, WebElement dropdownElement, int index) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(dropdownElement));
		click(dropdownElement);
		String optionXPath = "(//mat-option//span)[" + index + "]";
		WebElement option = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(optionXPath)));
		elementVisibility(option);
		click(dropdownElement);
		clickElementUsingJavaScript(driver, option);
	}

	public void createCustomerOrder(String memberNumber, String templatesName) {
		click(getBtnCreateCustomerOrder());
		insertValue(txtMemberNumber, memberNumber);
		clickElementUsingJavaScript(driver, getTxtMemberNumber());
		selectOptionByIndex(driver, getTxtMemberNumber(), 1);
		insertValue(getTxtTemplateName(), templatesName);
		selectOptionDropDown(getTxtTemplateName(), templatesName);
		clickElementUsingJavaScript(driver, getBtnCreate());
		click(getBtnCreate());
	}

	public void updateQty() {
		try {
			elementToBeClickable(getTxtQtyinGrid());
			getTxtQtyinGrid().sendKeys(Keys.chord(Keys.CONTROL, "a"));
			// Delete the selected text
			getTxtQtyinGrid().sendKeys(Keys.BACK_SPACE);
			Thread.sleep(500);
			insertValue(getTxtQtyinGrid(), "2");
			clickElementUsingJavaScript(driver, getTxtQtyinGrid());
		} catch (Exception e) {
		}
	}

	public void searchTemplates(String templateName) {
		elementVisibility(getTxtSeachTemplates());
		insertValue(getTxtSeachTemplates(), templateName);
		clickElementUsingJavaScript(driver, getiSearch());
	}

	public void orderTemplatesSorting() {
		String[] columnNames = { "Template Name", "Created Date", "Template Type", "Total Lines" };

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

	public void deleteOrderTemplate() {
		clickElementUsingJavaScript(driver, getiDelete());
		clickElementUsingJavaScript(driver, getBtnYes());

	}

	public void orderTemplateswithEmptyFields() {
		clickElementUsingJavaScript(driver, getBtnCreateNew());
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement returnNameField = wait.until(ExpectedConditions.elementToBeClickable(getTxtTemplateName()));
		returnNameField.sendKeys(Keys.chord(Keys.CONTROL, "a"));
		returnNameField.sendKeys(Keys.BACK_SPACE);
		clickElementUsingJavaScript(driver, getBtnCreate());

	}

	public void templateNamewithSpecialChar(String special) {
		clearTextUsingjs(getTxtTemplateName());
		insertValue(getTxtTemplateName(), special);
		clickElementUsingJavaScript(driver, getBtnCreate());

	}

	public void templateNameWithSpace(String templateType) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement returnNameField = wait.until(ExpectedConditions.elementToBeClickable(getTxtTemplateName()));
		returnNameField.sendKeys(Keys.chord(Keys.CONTROL, "a"));
		returnNameField.sendKeys(Keys.BACK_SPACE);
		returnNameField.sendKeys(Keys.SPACE);
		clickElementUsingJavaScript(driver, getBtnCreate());

	}

	public void templateNamewithMaxChar(String templateName) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement returnNameField = wait.until(ExpectedConditions.elementToBeClickable(getTxtTemplateName()));
		returnNameField.sendKeys(Keys.chord(Keys.CONTROL, "a"));
		returnNameField.sendKeys(Keys.BACK_SPACE);
		String returnNameMaxChar = " abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnop ";
		insertValue(getTxtTemplateName(), returnNameMaxChar);
		clickElementUsingJavaScript(driver, getBtnCreate());

	}

	public void createCustomerOrderWithEmptyFields() {
		click(getBtnCreateCustomerOrder());
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement memberNumber = wait.until(ExpectedConditions.elementToBeClickable(getTxtMemberNumber()));
		memberNumber.sendKeys(Keys.chord(Keys.CONTROL, "a"));
		memberNumber.sendKeys(Keys.BACK_SPACE);
		clickElementUsingJavaScript(driver, getBtnCreate());

	}

	public void createCustomerOrderWithInvalidFields(String memberNumber, String templatesName) {
		insertValue(getTxtMemberNumber(), memberNumber);
		clickElementUsingJavaScript(driver, getTxtMemberNumber());
		insertValue(getTxtTemplateName(), templatesName);
//		selectOptionDropDown(driver, getTxtTemplateName(), templatesName);
		clickElementUsingJavaScript(driver, getBtnCreate());

	}

	public void removeTemplateName() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement templateName = wait.until(ExpectedConditions.elementToBeClickable(getTxtUTemplateName()));
		templateName.sendKeys(Keys.chord(Keys.CONTROL, "a"));
		templateName.sendKeys(Keys.BACK_SPACE);

	}

	public void emptyOrderQtyField(String itemsNum) throws InterruptedException {
		elementVisibility(getTxtItemSearch());
		insertValue(getTxtItemSearch(), itemsNum);
		Thread.sleep(1000);
		getTxtItemSearch().sendKeys(Keys.ENTER);
		insertValue(getTxtOrderQty(), "55");
		getTxtOrderQty().sendKeys(Keys.chord(Keys.CONTROL, "a"));
		getTxtOrderQty().sendKeys(Keys.BACK_SPACE);
//		Thread.sleep(500);
		clearTextUsingjs(getTxtOrderQty());
		getTxtOrderQty().sendKeys(Keys.ENTER);

	}

	public void itemValidation(String itemsNum) throws InterruptedException {
		try {
			elementVisibility(getTxtItemSearch());
			insertValue(getTxtItemSearch(), itemsNum);
			Thread.sleep(1000);
			getTxtItemSearch().sendKeys(Keys.ENTER);
			getTxtOrderQty().sendKeys(Keys.chord(Keys.CONTROL, "a"));
			// Delete the selected text
			getTxtOrderQty().sendKeys(Keys.BACK_SPACE);
			insertValue(getTxtOrderQty(), "1");
			getTxtOrderQty().sendKeys(Keys.ENTER);
		} catch (Exception e) {
		}
	}

	public void validateOrderQty(String itemsNum, String orderQty) throws InterruptedException {
		try {
			elementVisibility(getTxtItemSearch());
			insertValue(getTxtItemSearch(), itemsNum);
			Thread.sleep(1000);
			getTxtItemSearch().sendKeys(Keys.ENTER);
			getTxtOrderQty().sendKeys(Keys.chord(Keys.CONTROL, "a"));
			// Delete the selected text
			getTxtOrderQty().sendKeys(Keys.BACK_SPACE);
			insertValue(getTxtOrderQty(), orderQty);
			getTxtOrderQty().sendKeys(Keys.ENTER);
			click(getBtnAdd());
		} catch (Exception e) {

		}
	}

	public void updateOrderQtyinlist() throws InterruptedException {
		try {
			elementToBeClickable(getTxtQtyinGrid());
			Thread.sleep(1000);
			getTxtItemSearch().sendKeys("2");
			getTxtQtyinGrid().sendKeys(Keys.chord(Keys.CONTROL, "a"));
			// Delete the selected text
			getTxtQtyinGrid().sendKeys(Keys.BACK_SPACE);
			Thread.sleep(500);
			getTxtQtyinGrid().sendKeys(Keys.ENTER);
			clickElementUsingJavaScript(driver, getTxtQtyinGrid());
		} catch (Exception e) {

		}
	}

	public void restrictionItem(String itemsNum) {
		try {
			elementVisibility(getTxtItemSearch());
			insertValue(getTxtItemSearch(), itemsNum);
			Thread.sleep(1000);
			getTxtItemSearch().sendKeys(Keys.ENTER);
			getTxtOrderQty().sendKeys(Keys.chord(Keys.CONTROL, "a"));
			// Delete the selected text
			getTxtOrderQty().sendKeys(Keys.BACK_SPACE);
			insertValue(getTxtOrderQty(), "1");
			getTxtOrderQty().sendKeys(Keys.ENTER);
			click(getBtnAdd());
		} catch (Exception e) {
		}
	}
}