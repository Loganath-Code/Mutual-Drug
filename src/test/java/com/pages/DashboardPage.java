package com.pages;

import java.lang.reflect.Constructor;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.base.BaseClass;

/**
 * @see Used to find the locators assign the values in Dashboard webpage
 * @Date 07-Feb-2025
 */
public class DashboardPage extends BaseClass {
	/**
	 * @see Constructor Used to initialize the values
	 */
	public DashboardPage() {
		PageFactory.initElements(driver, this);
	}

	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	@FindBy(xpath = "//i[@class='fa fa-tachometer']")
	private WebElement Rx_Doses_Chart;

	@FindBy(xpath = "//i[@class='fa fa-cube']")
	private WebElement iProducts;

	@FindBy(xpath = "//i[@class='fa fa-th-list']")
	private WebElement iInventory;

	@FindBy(xpath = "//span[text()='Orders']")
	private WebElement iOrders;

	@FindBy(xpath = "//span[@class='submenu-icon'][normalize-space()='Orders']")
	private WebElement menuOrder;

	@FindBy(xpath = "//a[@href='/member/orders/current-orders']")
	private WebElement lnkCurrentOrders;

	@FindBy(xpath = "//a[@href='/member/orders/order-history']")
	private WebElement lnkOrder_History;

	@FindBy(xpath = "//a[@href='/member/orders/back-order']")
	private WebElement lnkBack_Order;

	@FindBy(xpath = "//span[text()='Invoice History']")
	private WebElement lnkInvoice_History;

	@FindBy(xpath = "//span[text()='ASN History']")
	private WebElement lnkASN_Histroy;

	@FindBy(xpath = "//a[@href='/map/pages/recalls-and-safety-information']")
	private WebElement lnkRecalls;

	@FindBy(xpath = "//i[@class='fa fa-retweet']")
	private WebElement iReturns;

	@FindBy(xpath = "//span[text()='Returns']")
	private WebElement lnkReturnsm;

	@FindBy(xpath = "(//a[@href='/member/returns'])[1]")
	private WebElement lnkUnsubmitted;

	@FindBy(xpath = "(//a[@href='/member/returns/return-submitted'])[1]")
	private WebElement lnkSubmitted;

	@FindBy(xpath = "(//a[@href='/member/returns/return-ack-history'])[1]")
	private WebElement lnkAcknowledgement;

	@FindBy(xpath = "//span[contains(text(),'Reports')]")
	private WebElement iReports;

	@FindBy(xpath = "//span[contains(text(),'Statements')]")
	private WebElement lnkStatements;

	@FindBy(xpath = "//span[contains(text(),'Monthly Reports')]")
	private WebElement lnkMonthly_Reports;

	@FindBy(xpath = "//span[contains(text(),'Invoice History')]")
	private WebElement lnkInvoice_History_Reports;

	@FindBy(xpath = "//span[contains(text(),'ASN History')]")
	private WebElement lnkASN_History_Reports;

	@FindBy(xpath = "//span[contains(text(),'Rebate Checks')]")
	private WebElement lnkRebate_Checks;

	@FindBy(xpath = "//span[contains(text(),'Planograms')]")
	private WebElement lnkPlanograms;

	@FindBy(xpath = "//span[contains(text(),'Store')]")
	private WebElement iStore;

	@FindBy(xpath = "//a[@href='/member/store/store-profile']")
	private WebElement lnkStore_Profile;

	@FindBy(xpath = "//a[@href='/member/store/store-calendar']")
	private WebElement lnkStore_Calender;

	@FindBy(xpath = "//a[@href='/member/notification-groups']")
	private WebElement lnk_NotifictionList;

	@FindBy(xpath = "//span[text()='Mutual Drug Analytics (MDA)']")
	private WebElement lnk_MutualDrug_Analystics;

	@FindBy(xpath = "//div[@class='wid-100-per']//span[contains(text(),'Home')]")
	private WebElement lnkHome;

	@FindBy(xpath = "//a[@href='/map/pages/pharmacy']")
	private WebElement lnk_Pharmacy;

	@FindBy(xpath = "//a[@href='/map/pages/state-news-and-advocacy']")
	private WebElement lnkStateNewsandAdvocacy;

	@FindBy(xpath = "//a[@href='/map/pages/north-carolina-pharmacy-toolbox']")
	private WebElement lnkNC_PharmacyToolbox;

	@FindBy(xpath = "//a[@href='/map/pages/south-carolina-pharmacy-toolbox']")
	private WebElement lnkSC_PharmacyToolbox;

	@FindBy(xpath = "//a[@href='/map/pages/virginia-pharmacy-toolbox']")
	private WebElement lnkVA_PharmacyToolbox;

	@FindBy(xpath = "//a[@href='/map/pages/west-virginia-pharmacy-toolbox']")
	private WebElement lnkWV_PharmacyToolbox;

	@FindBy(xpath = "//a[@href='/map/pages/covid-19-vaccine-resources']")
	private WebElement lnkCovid19VaccineResources;

	@FindBy(xpath = "//a[@href='/map/pages/education-opportunities']")
	private WebElement lnkEducationOppurtunities;

	@FindBy(xpath = "//a[@href='/map/pages/marketing-resources']")
	private WebElement lnkMarkrtingResources;

	@FindBy(xpath = "//a[@href='/map/pages/compliance']")
	private WebElement lnkCompliance;

	@FindBy(xpath = "//a[@href='/map/pages/recalls-and-safety-information']")
	private WebElement lnkRecalls_MDA;

	@FindBy(xpath = "//a[@href='/map/pages/events']")
	private WebElement lnkEvents;

	@FindBy(xpath = "//a[@href='/map/pages/vendor-and-community-partnerships']")
	private WebElement lnkPartnerships;

	@FindBy(xpath = "//a[@href='/map/pages/promotions']")
	private WebElement lnkPromotions;

	@FindBy(xpath = "//a[@href='/map/pages/frequently-asked-questions']")
	private WebElement lnkFAQs;

	@FindBy(xpath = "//a[@href='/map/pages/returns']")
	private WebElement lnkRetruns;

	@FindBy(xpath = "//a[@href='/map/pages/2023-2024-flu-vaccine-pre-order-program']")
	private WebElement lnkDescriptions;

	@FindBy(xpath = "//a[@href='/map/pages/detail-video123']")
	private WebElement lnkDetailNow;

	@FindBy(xpath = "//mat-slide-toggle[@class='mat-slide-toggle mat-accent ng-star-inserted mat-checked']")
	private WebElement toggle;

	@FindBy(xpath = "//input[@name='searchProduct']")
	private WebElement txtGlobalsearch;

	@FindBy(xpath = "//i[@class='fa fa-search']")
	private WebElement iSearch;

	@FindBy(xpath = "//button[text()='Create New']")
	private WebElement btnCreateNew;

	@FindBy(xpath = "//input[@name='orderName']")
	private WebElement txtOrderName;

	@FindBy(xpath = "//button[text()='Create']")
	private WebElement btnCreate;

	@FindBy(xpath = "//div[@aria-label='Product added to order.']")
	private WebElement alertSuccessMessageOrderCreation;

	@FindBy(xpath = "(//input[@type='checkbox'])[2]")
	private WebElement cbxReturnPolicyUpdates;

	@FindBy(xpath = "//button[@class='btn btn-primary modal-btn']")
	private WebElement btnIAccept;

	@FindBy(xpath = "//button[text()='Next']")
	private WebElement btnNext;

	@FindBy(xpath = "//h4[normalize-space()='Important : Return Policy Update']")
	private WebElement titleReturnPolicy;

	public WebElement getRx_Doses_Chart() {
		return Rx_Doses_Chart;
	}

	public WebElement getiProducts() {
		return iProducts;
	}

	public WebElement getiInventory() {
		return iInventory;
	}

	public WebElement getiOrders() {
		return iOrders;
	}

	public WebElement getMenuOrder() {
		return menuOrder;
	}

	public WebElement getLnkCurrentOrders() {
		return lnkCurrentOrders;
	}

	public WebElement getLnkOrder_History() {
		return lnkOrder_History;
	}

	public WebElement getLnkBack_Order() {
		return lnkBack_Order;
	}

	public WebElement getLnkInvoice_History() {
		return lnkInvoice_History;
	}

	public WebElement getLnkASN_Histroy() {
		return lnkASN_Histroy;
	}

	public WebElement getLnkRecalls() {
		return lnkRecalls;
	}

	public WebElement getiReturns() {
		return iReturns;
	}

	public WebElement getLnkReturnsm() {
		return lnkReturnsm;
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

	public WebElement getiReports() {
		return iReports;
	}

	public WebElement getLnkStatements() {
		return lnkStatements;
	}

	public WebElement getLnkMonthly_Reports() {
		return lnkMonthly_Reports;
	}

	public WebElement getLnkInvoice_History_Reports() {
		return lnkInvoice_History_Reports;
	}

	public WebElement getLnkASN_History_Reports() {
		return lnkASN_History_Reports;
	}

	public WebElement getLnkRebate_Checks() {
		return lnkRebate_Checks;
	}

	public WebElement getLnkPlanograms() {
		return lnkPlanograms;
	}

	public WebElement getiStore() {
		return iStore;
	}

	public WebElement getLnkStore_Profile() {
		return lnkStore_Profile;
	}

	public WebElement getLnkStore_Calender() {
		return lnkStore_Calender;
	}

	public WebElement getLnk_NotifictionList() {
		return lnk_NotifictionList;
	}

	public WebElement getLnk_MutualDrug_Analystics() {
		return lnk_MutualDrug_Analystics;
	}

	public WebElement getLnkHome() {
		return lnkHome;
	}

	public WebElement getLnk_Pharmacy() {
		return lnk_Pharmacy;
	}

	public WebElement getLnkStateNewsandAdvocacy() {
		return lnkStateNewsandAdvocacy;
	}

	public WebElement getLnkNC_PharmacyToolbox() {
		return lnkNC_PharmacyToolbox;
	}

	public WebElement getLnkSC_PharmacyToolbox() {
		return lnkSC_PharmacyToolbox;
	}

	public WebElement getLnkVA_PharmacyToolbox() {
		return lnkVA_PharmacyToolbox;
	}

	public WebElement getLnkWV_PharmacyToolbox() {
		return lnkWV_PharmacyToolbox;
	}

	public WebElement getLnkCovid19VaccineResources() {
		return lnkCovid19VaccineResources;
	}

	public WebElement getLnkEducationOppurtunities() {
		return lnkEducationOppurtunities;
	}

	public WebElement getLnkMarkrtingResources() {
		return lnkMarkrtingResources;
	}

	public WebElement getLnkCompliance() {
		return lnkCompliance;
	}

	public WebElement getLnkRecalls_MDA() {
		return lnkRecalls_MDA;
	}

	public WebElement getLnkEvents() {
		return lnkEvents;
	}

	public WebElement getLnkPartnerships() {
		return lnkPartnerships;
	}

	public WebElement getLnkPromotions() {
		return lnkPromotions;
	}

	public WebElement getLnkFAQs() {
		return lnkFAQs;
	}

	public WebElement getLnkRetruns() {
		return lnkRetruns;
	}

	public WebElement getLnkDescriptions() {
		return lnkDescriptions;
	}

	public WebElement getLnkDetailNow() {
		return lnkDetailNow;
	}

	public WebElement getToggle() {
		return toggle;
	}

	public WebElement getTxtGlobalsearch() {
		return txtGlobalsearch;
	}

	public WebElement getiSearch() {
		return iSearch;
	}

	public WebElement getBtnCreateNew() {
		return btnCreateNew;
	}

	public WebElement getTxtOrderName() {
		return txtOrderName;
	}

	public WebElement getBtnCreate() {
		return btnCreate;
	}

	public WebElement getAlertSuccessMessageOrderCreation() {
		return alertSuccessMessageOrderCreation;
	}

	public WebElement getCbxReturnPolicyUpdates() {
		return cbxReturnPolicyUpdates;
	}

	public WebElement getBtnIAccept() {
		return btnIAccept;
	}

	public WebElement getBtnNext() {
		return btnNext;
	}

	public WebElement getTitleReturnPolicy() {
		return titleReturnPolicy;
	}

	/**
	 * @see Used to Select Order
	 * @throws InterruptedException
	 */
	public void navigatesOrders() throws InterruptedException {
		scrollToElement(getiOrders());
		Actions action = new Actions(driver);
		action.moveToElement(getiOrders()).perform();
		clickElementUsingJavaScript(driver, getMenuOrder());

	}

	/**
	 * @see Used to navigates Current order webpage
	 * @throws InterruptedException
	 */
	public void navigatesCurrentOrderPage() throws InterruptedException {
		navigatesOrders();
		elementToBeClickable(getLnkCurrentOrders());
		clickElementUsingJavaScript(driver, getLnkCurrentOrders());

	}

	/**
	 * @see Used to perform global search
	 * @param globalSearch
	 */
	public void performGlobalSearch(String globalSearch) {
		insertValue(getTxtGlobalsearch(), globalSearch);
		clickElementUsingJavaScript(driver, getiSearch());
	}

	/**
	 * @see Used to navigates Notifications webpage
	 */
	public void navigatesNotifications() {
		scrollToElement(getLnk_NotifictionList());
		Actions action = new Actions(driver);
		action.moveToElement(getiOrders()).perform();
		clickElementUsingJavaScript(driver, getLnk_NotifictionList());

	}

	/**
	 * @see Used to naigates returns Submenus
	 */
	public void navigatesReturns(String linkedMenu) {
		scrollToElement(getiReturns());
		Actions action = new Actions(driver);
		action.moveToElement(getiReturns()).perform();
		clickElementUsingJavaScript(driver, getLnkReturnsm());
		WebElement returnSubmenu = wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//span[contains(normalize-space(),'" + linkedMenu + "')]")));
		returnSubmenu.click();
		
	}

	/**
	 * @see Used to navigates Rx charts
	 */
	public void navigatesRxDoesCharts() {
		scrollToElement(getRx_Doses_Chart());
		click(getRx_Doses_Chart());

	}

	public void returnPolicy() throws InterruptedException {
		if (getTitleReturnPolicy().isDisplayed()) {
			elementToBeClickable(getCbxReturnPolicyUpdates());
			clickElementUsingJavaScript(driver, getCbxReturnPolicyUpdates());
			clickElementUsingJavaScript(driver, getBtnIAccept());
			Thread.sleep(800);
			clickWithWait(getCbxReturnPolicyUpdates());
			clickElementUsingJavaScript(driver, getBtnNext());
			Thread.sleep(800);
			clickWithWait(getCbxReturnPolicyUpdates());
			clickElementUsingJavaScript(driver, getBtnIAccept());
		}
	}
}