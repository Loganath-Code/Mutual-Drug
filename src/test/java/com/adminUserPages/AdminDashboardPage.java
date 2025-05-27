package com.adminUserPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;

public class AdminDashboardPage extends BaseClass {

	public AdminDashboardPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//h2[text()='Member Users']")
	private WebElement titleMemberUsers;

	@FindBy(xpath = "//a[@href='/admin/members/applications']")
	private WebElement lnkMemberApplications;

	@FindBy(xpath = "(//a[@routerlinkactive='router-link-active'])[2]")
	private WebElement iMembers;

	@FindBy(xpath = "//span[text()='Members']")
	private WebElement lnkMembers;

	@FindBy(xpath = "//a[@href='/admin/members/details']")
	private WebElement lnkDetails;

	@FindBy(xpath = "//a[@href='/admin/members/users']")
	private WebElement lnkUsers;

	@FindBy(xpath = "//a[@href='/admin/members/roles']")
	private WebElement lnkRoles;

	@FindBy(xpath = "(//a[@routerlinkactive='router-link-active'])[3]")
	private WebElement iMutualDrug;

	@FindBy(xpath = "//span[text()='Mutual Drug']")
	private WebElement lnkMutualDrug;

	@FindBy(xpath = "//a[@href='/admin/administration/users']")
	private WebElement lnkAdministrators;

	@FindBy(xpath = "//i[@class='fa fa-user-secret']")
	private WebElement iAdministrations;

	@FindBy(xpath = "//span[text()='Administration']")
	private WebElement lnkAdministration;

	@FindBy(xpath = "//span[text()='Orders']")
	private WebElement lnkOrders;

	@FindBy(xpath = "//span[text()='Order Templates']")
	private WebElement lnkOrderTemplates;

	@FindBy(xpath = "//a[@href='/admin/planograms']")
	private WebElement lnkPlanograms;

	@FindBy(xpath = "//span[text()='Banners']")
	private WebElement lbkBanners;

	@FindBy(xpath = "//span[text()='Create Banner']")
	private WebElement lnkCreateBanner;

	@FindBy(xpath = "//span[text()='Banner Metrics']")
	private WebElement lnkBannerMetrics;

	@FindBy(xpath = "//span[text()='Returns']")
	private WebElement lnkReturns;

	@FindBy(xpath = "//span[text()='Return Policies']")
	private WebElement lnkReturnPolices;

	@FindBy(xpath = "//span[text()='C2 Returns']")
	private WebElement lnkC2Returns;
	
	@FindBy(xpath = "//span[text()='Open C2 Returns']")
	private WebElement lnkOpenC2Returns;

	@FindBy(xpath = "//span[text()='Closed C2 Returns']")
	private WebElement tnkClosedC2Returns;

	public WebElement getTitleMemberUsers() {
		return titleMemberUsers;
	}

	public WebElement getLnkMemberApplications() {
		return lnkMemberApplications;
	}

	public WebElement getiMembers() {
		return iMembers;
	}

	public WebElement getLnkMembers() {
		return lnkMembers;
	}

	public WebElement getLnkDetails() {
		return lnkDetails;
	}

	public WebElement getLnkUsers() {
		return lnkUsers;
	}

	public WebElement getLnkRoles() {
		return lnkRoles;
	}

	public WebElement getiMutualDrug() {
		return iMutualDrug;
	}

	public WebElement getLnkMutualDrug() {
		return lnkMutualDrug;
	}

	public WebElement getLnkAdministrators() {
		return lnkAdministrators;
	}

	public WebElement getiAdministrations() {
		return iAdministrations;
	}

	public WebElement getLnkAdministration() {
		return lnkAdministration;
	}

	public WebElement getLnkOrders() {
		return lnkOrders;
	}

	public WebElement getLnkOrderTemplates() {
		return lnkOrderTemplates;
	}

	public WebElement getLnkPlanograms() {
		return lnkPlanograms;
	}

	public WebElement getLbkBanners() {
		return lbkBanners;
	}

	public WebElement getLnkCreateBanner() {
		return lnkCreateBanner;
	}

	public WebElement getLnkBannerMetrics() {
		return lnkBannerMetrics;
	}

	public WebElement getLnkReturns() {
		return lnkReturns;
	}

	public WebElement getLnkReturnPolices() {
		return lnkReturnPolices;
	}

	public WebElement getLnkC2Returns() {
		return lnkC2Returns;
	}

	public WebElement getLnkOpenC2Returns() {
		return lnkOpenC2Returns;
	}

	public WebElement getTnkClosedC2Returns() {
		return tnkClosedC2Returns;
	}

	public void navigatesOrderTemplates() {
		moveToElement(iAdministrations);
		clickElementUsingJavaScript(driver, getLnkAdministration());
		clickElementUsingJavaScript(driver, getLnkOrders());
		clickElementUsingJavaScript(driver, getLnkOrderTemplates());
	}

	public void navigatesMembersDetails() {
		moveToElement(getiMembers());
		clickElementUsingJavaScript(driver, getLnkMembers());
		clickElementUsingJavaScript(driver, getLnkDetails());
	}

	public void navigatesMemberUsers() {
		moveToElement(getiMembers());
		clickElementUsingJavaScript(driver, getLnkMembers());
		clickElementUsingJavaScript(driver, getLnkUsers());
	}

	public void navigtesMemberUserRoles() {
		moveToElement(getiMembers());
		clickElementUsingJavaScript(driver, getLnkMembers());
		clickElementUsingJavaScript(driver, getLnkRoles());
	}

	public void navigatesPlanograms() {
		moveToElement(getiAdministrations());
		clickElementUsingJavaScript(driver, getLnkAdministration());
		clickElementUsingJavaScript(driver, getLnkPlanograms());
	}

	public void navigatesCreateBanners() {
		moveToElement(getiAdministrations());
		clickElementUsingJavaScript(driver, getLnkAdministration());
		clickElementUsingJavaScript(driver, getLbkBanners());
		clickElementUsingJavaScript(driver, getLnkCreateBanner());

	}

	public void navigtesBannerMetrics() {
		moveToElement(getiAdministrations());
		clickElementUsingJavaScript(driver, getLnkAdministration());
		clickElementUsingJavaScript(driver, getLbkBanners());
		clickElementUsingJavaScript(driver, getLnkBannerMetrics());

	}

	public void navigatesOpenC2Returns() {
		moveToElement(getiAdministrations());
		clickElementUsingJavaScript(driver, getLnkAdministration());
		clickElementUsingJavaScript(driver, getLnkReturns());
		clickElementUsingJavaScript(driver, getLnkC2Returns());
		clickElementUsingJavaScript(driver, getLnkOpenC2Returns());

	}
}
