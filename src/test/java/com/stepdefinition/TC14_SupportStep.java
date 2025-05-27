package com.stepdefinition;

import com.pageManager.PageObjectManager;

import io.cucumber.java.en.*;

public class TC14_SupportStep {
	PageObjectManager pom = new PageObjectManager();

	@When("User clicks the Help menu icon and selects {string}")
	public void userClicksTheHelpMenuIconAndSelects(String text) {
		pom.getSupportPage().supportNavigation();
		pom.getSupportPage().selectSupportLink(text);

	}

	@When("User clicks the Support menu and selects {string}")
	public void userClicksTheSupportMenuAndSelects(String text) {

		pom.getSupportPage().supportMenuNevigation(text);
	}

	@Then("the {string} document should open in a modal")
	public void theDocumentShouldOpenInAModal(String expectedTitle) {
		pom.getSupportPage().expectedTitle(expectedTitle);

	}

	@When("User clicks the {string} button in the modal and the document should be downloaded successfully")
	public void userClicksTheButtonInTheModalAndTheDocumentShouldBeDownloadedSuccessfully(String string) {
		pom.getSupportPage().download();

	}

	@Then("the {string} page should be displayed")
	public void thePageShouldBeDisplayed(String expectedTitle) {

		pom.getSupportPage().expectedTitle(expectedTitle);
	}

	@Then("User should clicks the {string} navigates to the {string} webpage")
	public void userShouldClicksTheNavigatesToTheWebpage(String string, String string2) {

		pom.getSupportPage().navigatesRecallsFDAAlerts();
	}
}
