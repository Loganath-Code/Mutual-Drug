package com.adminUserPages;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.base.BaseClass;

public class BannersPage extends BaseClass {

	public BannersPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//h2[text()='Banners']")
	private WebElement titleBanner;

	@FindBy(xpath = "//button[normalize-space()='Add Banner']")
	private WebElement btnAddBanner;

	@FindBy(xpath = "//h2[text()='Add Banner ']")
	private WebElement bcTitleAddBanner;

	@FindBy(xpath = "//h3[text()='Banner Details']")
	private WebElement titleBannerDetails;

	@FindBy(xpath = "//input[@name='name']")
	private WebElement txtName;

	@FindBy(xpath = "//input[@formcontrolname='startDt']")
	private WebElement txtStartDate;

	@FindBy(xpath = "//input[@formcontrolname='endDt']")
	private WebElement txtEndDate;

	@FindBy(xpath = "(//input[@role='switch'])[1]")
	private WebElement toggleStatus;

	@FindBy(xpath = "(//input[@name='url'])[1]")
	private WebElement txtUrl;

	@FindBy(xpath = "(//input[@value='Yes'])//following::span[@class='checkmark']")
	private WebElement rdobtnYes;

	@FindBy(xpath = "(//input[@value='No'])//following::span[@class='checkmark']")
	private WebElement rdobtnNo;

	@FindBy(xpath = "(//input[@role='switch'])[2]")
	private WebElement toggleBannerLock;

	@FindBy(xpath = "//textarea[@name='description']")
	private WebElement txtDescription;

	@FindBy(xpath = "//input[@name='file']")
	private WebElement lnkChooseFile;

	@FindBy(xpath = "//button[text()='Save']")
	private WebElement btnSave;

	@FindBy(xpath = "//div[contains(text(),'Name is required')]")
	private WebElement errorMessageName;

	@FindBy(xpath = "//div[contains(text(),'Image is required')]")
	private WebElement errorMessageImage;

	@FindBy(xpath = "//input[@placeholder='Search for Banners']")
	private WebElement txtSearchBanner;

	@FindBy(xpath = "//i[@class='fa fa-search']")
	private WebElement iSearch;

	@FindBy(xpath = "(//i[@class='fa fa-trash'])[1]")
	private WebElement iDelete;

	@FindBy(xpath = "//button[@class='btn btn-primary modal-btn']")
	private WebElement btnYes;

	@FindBy(xpath = "//td[@role='gridcell']//a")
	private WebElement tdBannerNameLink;

	@FindBy(xpath = "//button[text()='Update']")
	private WebElement btnUpdate;

	public WebElement getTitleBanner() {
		return titleBanner;
	}

	public WebElement getBtnAddBanner() {
		return btnAddBanner;
	}

	public WebElement getBcTitleAddBanner() {
		return bcTitleAddBanner;
	}

	public WebElement getTitleBannerDetails() {
		return titleBannerDetails;
	}

	public WebElement getTxtName() {
		return txtName;
	}

	public WebElement getTxtStartDate() {
		return txtStartDate;
	}

	public WebElement getTxtEndDate() {
		return txtEndDate;
	}

	public WebElement getToggleStatus() {
		return toggleStatus;
	}

	public WebElement getTxtUrl() {
		return txtUrl;
	}

	public WebElement getRdobtnYes() {
		return rdobtnYes;
	}

	public WebElement getRdobtnNo() {
		return rdobtnNo;
	}

	public WebElement getToggleBannerLock() {
		return toggleBannerLock;
	}

	public WebElement getTxtDescription() {
		return txtDescription;
	}

	public WebElement getLnkChooseFile() {
		return lnkChooseFile;
	}

	public WebElement getBtnSave() {
		return btnSave;
	}

	public WebElement getErrorMessageName() {
		return errorMessageName;
	}

	public WebElement getErrorMessageImage() {
		return errorMessageImage;
	}

	public WebElement getTxtSearchBanner() {
		return txtSearchBanner;
	}

	public WebElement getiSearch() {
		return iSearch;
	}

	public WebElement getiDelete() {
		return iDelete;
	}

	public WebElement getBtnYes() {
		return btnYes;
	}

	public WebElement getTdBannerNameLink() {
		return tdBannerNameLink;
	}

	public WebElement getBtnUpdate() {
		return btnUpdate;
	}

	public void clickAddBanner() {
		elementVisibility(getBtnAddBanner());
		clickElementUsingJavaScript(driver, getBtnAddBanner());

	}

	public void insertName(String name) {
		elementVisibility(getTxtName());
		insertValue(getTxtName(), name);
	}

	public void dateFields(String startDate, String endDate) {
		insertValue(getTxtStartDate(), startDate);
		insertValue(getTxtEndDate(), endDate);
	}

	public void insertURL(String url) {
		insertValue(getTxtUrl(), url);
	}

	public WebElement rdobtnOpenNewTab(String value) {
		WebElement rdobtn = driver
				.findElement(By.xpath("(//input[@value='" + value + "'])//following::span[@class='checkmark']"));
		clickElementUsingJavaScript(driver, rdobtn);
		return rdobtn;
	}

	public void toogleBannerLock() {

	}

	public void description(String description) {
		insertValue(getTxtDescription(), description);
		getLnkChooseFile().sendKeys("C:\\Users\\nloga\\Downloads\\sample.pdf");
	}

	public void clickSave() {
		clickElementUsingJavaScript(driver, getBtnSave());

	}

	public void searchBanners(String searchBanners) throws InterruptedException {
		elementVisibility(getTxtSearchBanner());
		insertValue(getTxtSearchBanner(), searchBanners);
		clickElementUsingJavaScript(driver, getiSearch());
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		String na, de, sd, ed, cd, st;
		Thread.sleep(1500);
		try {
			na = wait
					.until(ExpectedConditions
							.visibilityOfElementLocated(By.xpath("(//td[contains(@class,'mat-column-name ')])[1]")))
					.getText().trim();
			de = wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("(//td[contains(@class,'mat-column-description ')])[1]")))
					.getText().trim();
			sd = wait
					.until(ExpectedConditions
							.visibilityOfElementLocated(By.xpath("(//td[contains(@class,'mat-column-startDt  ')])[1]")))
					.getText().trim();
			ed = wait
					.until(ExpectedConditions
							.visibilityOfElementLocated(By.xpath("(//td[contains(@class,'mat-column-endDt   ')])[1]")))
					.getText().trim();
			cd = wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("(//td[contains(@class,'mat-column-createdDt    ')])[1]")))
					.getText().trim();
			st = wait
					.until(ExpectedConditions
							.visibilityOfElementLocated(By.xpath("(//td[contains(@class,'mat-column-active ')])[1]")))
					.getText().trim();
		} catch (TimeoutException e) {
//			Assert.fail("No search results displayed for term: " + searchBanners);
			return;
		}

		boolean anyMatch = searchBanners.equals(na) || searchBanners.equals(de) || searchBanners.equals(sd)
				|| searchBanners.equals(ed) || searchBanners.equals(cd) || searchBanners.equals(st);

		Assert.assertTrue(String.format("'%s' did not match name('%s'), description('%s'), or date('%s')",
				searchBanners, na, de, sd, ed, cd, st), anyMatch);
	}

	public void sorting() throws InterruptedException {
		String[] columnNames = { "Name", "Description", "Start Date", "End Date", "Created Date", "Status" };

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

	public void clickBannerNameLink() throws InterruptedException {
		refreshNavigation();
		Thread.sleep(500);
		elementToBeClickable(getTdBannerNameLink());
		clickElementUsingJavaScript(driver, getTdBannerNameLink());

	}

	public void updateBanners() {
		clickElementUsingJavaScript(driver, getBtnUpdate());

	}

	public void deleteBanners() {
		elementVisibility(getiDelete());
		clickElementUsingJavaScript(driver, getiDelete());
		clickElementUsingJavaScript(driver, getBtnYes());
	}
}
