package com.stepdefinition;

import org.openqa.selenium.WebElement;

import com.base.BaseClass;
import com.pageManager.PageObjectManager;

import io.cucumber.java.en.*;

public class PageNotFoundStep extends BaseClass {
	PageObjectManager pom = new PageObjectManager();

	@When("User should navigates to non-existent page  {string}")
	public void userShouldNavigatesToNonExistentPage(String url) {

		pom.getPageNotFoundPage().navigatesNonExistentPage(url);
	}

	@Then("User should see a {string} error page with the message {string}")
	public void userShouldSeeAErrorPageWithTheMessage(String expected404Message, String expetedMDMessage) {
		WebElement text404 = pom.getPageNotFoundPage().getText404();
		WebElement notFoundMessage = pom.getPageNotFoundPage().getNotFoundMessage();
		assertEquals(text404, expected404Message);
		assertEquals(notFoundMessage, expetedMDMessage);
	}

	@When("User clicks on Go Back redirected back to the {string} page")
	public void userClicksOnGoBackRedirectedBackToThePage(String string) {
		pom.getPageNotFoundPage().clickGoBack();
		WebElement titleCurrentOrders = pom.getCurrentOrderPage().getTitleCurrentOrders();
		assertEquals(titleCurrentOrders, string);
	}

	@When("User clicks on Go Back redirected back to the admin {string}  page")
	public void userClicksOnGoBackRedirectedBackToTheAdminPage(String expectedTitleMemberUsers) {
		pom.getPageNotFoundPage().clickGoBack();
		WebElement titleMemberUsers = pom.getAdminDashboardPage().getTitleMemberUsers();
		assertEquals(titleMemberUsers, expectedTitleMemberUsers);
	}

}
