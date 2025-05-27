package com.pages;

import java.lang.reflect.Constructor;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.base.BaseClass;

import junit.framework.Assert;

/**
 * @see Used to find the locators assign the values in support
 * 
 */
public class SupportPage extends BaseClass {
	/**
	 * @see Constructor Used to initialize the values
	 */
	public SupportPage() {
		PageFactory.initElements(driver, this);
	}

	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	@FindBy(xpath = "//mat-icon[@svgicon='headset_noface']//*[name()='svg']")
	private WebElement iSupport;

	@FindBy(xpath = "//a[text()=' Mobile Order User Guide']")
	private WebElement lnkMobileOrderUserGuide;

	@FindBy(xpath = "//a[text()=' Mobile Return User Guide']")
	private WebElement lnkMobileReturnUserGuide;

	@FindBy(xpath = "//a[text()=' Return Policy']")
	private WebElement lnkReturnPolicy;

	@FindBy(xpath = "//*[text()='Recalls ']")
	private WebElement lnkRecalls;

	@FindBy(xpath = "//button[text()=' Download ']")
	private WebElement btnDownload;

	@FindBy(xpath = "//span[text()='Support']")
	private WebElement lnkSupport;

	@FindBy(xpath = "//span[text()='Mobile Order User Guide']")
	private WebElement mobileOrderUserGuide;

	@FindBy(xpath = "//span[text()='Mobile Return User Guide']")
	private WebElement mobileReturnUserGuide;

	@FindBy(xpath = "//span[text()= Return Policy']")
	private WebElement returnPolicy;

	@FindBy(xpath = "//span[text()='Recalls']")
	private WebElement recalls;

	@FindBy(xpath = "//h4[text()='Mobile Order User Guide']")
	private WebElement titleMobileOrderUserGuide;

	@FindBy(xpath = "//h4[text()='Mobile Return User Guide']")
	private WebElement titleMobileReturnUserGuide;

	@FindBy(xpath = "//h4[text()= Return Policy']")
	private WebElement titleReturnPolicy;

	@FindBy(xpath = "//h2[text()='Access for Premier Member’s Only']")
	private WebElement titleRecalls;

	@FindBy(xpath = "//a[text()='Click here to access FDA Alerts']")
	private WebElement lnkFDAAlerts;

	@FindBy(xpath = "(//embed[@type='application/pdf'])[1]")
	private WebElement pdf;

	@FindBy(xpath = "//i[@class='fa fa-times']")
	private WebElement iClose;

	@FindBy(xpath = "//img[@class='support-icon']")
	private WebElement iSupportmenu;

	@FindBy(xpath = "//span[text()='Support']")
	private WebElement mteSupport;

	@FindBy(xpath = "//ul[@class='nav nav--no-borders flex-column submenu one submenuTree submenushow ng-star-inserted']")
	private WebElement hoverElement;

	public WebElement getiSupport() {
		return iSupport;
	}

	public WebElement getLnkMobileOrderUserGuide() {
		return lnkMobileOrderUserGuide;
	}

	public WebElement getLnkMobileReturnUserGuide() {
		return lnkMobileReturnUserGuide;
	}

	public WebElement getLnkReturnPolicy() {
		return lnkReturnPolicy;
	}

	public WebElement getLnkRecalls() {
		return lnkRecalls;
	}

	public WebElement getBtnDownload() {
		return btnDownload;
	}

	public WebElement getLnkSupport() {
		return lnkSupport;
	}

	public WebElement getMobileOrderUserGuide() {
		return mobileOrderUserGuide;
	}

	public WebElement getMobileReturnUserGuide() {
		return mobileReturnUserGuide;
	}

	public WebElement getReturnPolicy() {
		return returnPolicy;
	}

	public WebElement getRecalls() {
		return recalls;
	}

	public WebElement getTitleMobileOrderUserGuide() {
		return titleMobileOrderUserGuide;
	}

	public WebElement getTitleMobileReturnUserGuide() {
		return titleMobileReturnUserGuide;
	}

	public WebElement getTitleReturnPolicy() {
		return titleReturnPolicy;
	}

	public WebElement getTitleRecalls() {
		return titleRecalls;
	}

	public WebDriverWait getWait() {
		return wait;
	}

	public WebElement getLnkFDAAlerts() {
		return lnkFDAAlerts;
	}

	public WebElement getPdf() {
		return pdf;
	}

	public WebElement getiClose() {
		return iClose;
	}

	public WebElement getiSupportmenu() {
		return iSupportmenu;
	}

	public WebElement getMteSupport() {
		return mteSupport;
	}

	public WebElement getHoverElement() {
		return hoverElement;
	}

	/**
	 * @see Used to select support submenus
	 * @param text
	 */
	public void selectSupportLink(String text) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement dynamicLink = wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(normalize-space(),'" + text + "')]")));
		dynamicLink.click();
	}

	/**
	 * @see Used to verifies the Document is displayed or not
	 */
	public void displayedDocument() {
		elementVisibility(getPdf());
		try {
			WebElement docElement = waitForWebElementVisible(getPdf());
			Assert.assertTrue(docElement.isDisplayed());
			System.out.println(" Document is visible on the page.");
		} catch (TimeoutException e) {
			System.out.println(" Document was not found.");
			Assert.fail("Document is not displayed.");
		}
	}

	/**
	 * @see Used to Mouse hover action in Support Menu
	 */
	public void supportNavigation() {
		elementToBeClickable(getiSupport());
		moveToElement(getiSupport());

	}

	/**
	 * @see Used to verifies the model title
	 * @param expectedTitle
	 */
	public void expectedTitle(String expectedTitle) {
		WebElement modalTitleElement = wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//h4[contains(normalize-space(),'" + expectedTitle + "')]")));
		String actualTitle = modalTitleElement.getText().trim().toUpperCase();
		Assert.assertEquals("Modal title does not match!", expectedTitle.toUpperCase(), actualTitle);

	}

	/**
	 * @see Used to click Download button and close document
	 */
	public void download() {
		displayedDocument();
		clickElementUsingJavaScript(driver, getBtnDownload());
		click(getiClose());
	}

	/**
	 * @see Used to clicks the Recalls FDA Alerts link
	 */
	public void navigatesRecallsFDAAlerts() {
		clickElementUsingJavaScript(driver, getLnkFDAAlerts());
	}

	/**
	 * @see Used to Support menu submenu Selection
	 * @param text
	 */
	public void supportMenuNevigation(String text) {
		moveToElement(getiSupportmenu());
		List<WebElement> submenus = driver
				.findElements(By.xpath("//ul[contains(@class,'submenuTree') and contains(@class,'submenushow')]"));
		if (submenus.isEmpty()) {
			WebElement supportMenu = wait.until(ExpectedConditions.visibilityOf(getiSupportmenu()));
			clickElementUsingJavaScript(driver, supportMenu);
			wait.until(ExpectedConditions.presenceOfElementLocated(
					By.xpath("//ul[contains(@class,'submenuTree') and contains(@class,'submenushow')]")));
		}
		WebElement submenuLink = wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("(//a[contains(normalize-space(),'" + text + "')])[2]")));
		clickElementUsingJavaScript(driver, submenuLink);
	}

}
