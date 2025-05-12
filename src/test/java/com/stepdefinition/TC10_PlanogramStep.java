package com.stepdefinition;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebElement;

import com.base.BaseClass;
import com.pageManager.PageObjectManager;

import io.cucumber.java.en.*;

public class TC10_PlanogramStep extends BaseClass {
	PageObjectManager pom = new PageObjectManager();

	@Then("User navigates to Administration selects Planograms, verifies the page title should be {string}")
	public void userNavigatesToAdministrationSelectsPlanogramsVerifiesThePageTitleShouldBe(String breadcrumbTitle) {
		pom.getAdminDashboardPage().navigatesPlanograms();
		WebElement titlePlanogram = pom.getPlanogramsPage().getTitlePlanogram();
		assertEquals(titlePlanogram, breadcrumbTitle);

	}

	@Then("User should verifies to clicks on Add Planogram navigates through the {string}")
	public void userShouldVerifiesToClicksOnAddPlanogramNavigatesThroughThe(String titleAddPlanogram) {
		pom.getPlanogramsPage().clicksPlanogram();
		WebElement titlePlanogram = pom.getPlanogramsPage().getTitleAddPlanogram();
		assertEquals(titlePlanogram, titleAddPlanogram);
	}

	@When("User should submit the details with {string}, {string} and to upload file")
	public void userShouldSubmitTheDetailsWithAndToUploadFile(String name, String description) {
		pom.getPlanogramsPage().createPlanogram(name, description);
	}

	@Then("User clicks on {string} the new planogram should be listed on the Planograms page with the correct {string}")
	public void userClicksOnTheNewPlanogramShouldBeListedOnThePlanogramsPageWithTheCorrect(String string,
			String string2) {
		pom.getPlanogramsPage().clicksSave();
	}

	@When("User searches for {string} using the search bar then matching results should be displayed:")
	public void userSearchesForUsingTheSearchBarThenMatchingResultsShouldBeDisplayed(String string,
			io.cucumber.datatable.DataTable dataTable) throws InterruptedException {

		List<Map<String, String>> searchPlanogramsList = dataTable.asMaps();
		for (Map<String, String> planogram : searchPlanogramsList) {
			String searchPlanogram = planogram.get("searchPlanogram");
			pom.getPlanogramsPage().searchPlanogram(searchPlanogram);

		}
	}

	@When("User verifies that the sorting functionality in both ascending and descending Name, Description and Created date")
	public void userVerifiesThatTheSortingFunctionalityInBothAscendingAndDescendingNameDescriptionAndCreatedDate()
			throws InterruptedException {
		refreshNavigation();
		Thread.sleep(1500);
		pom.getPlanogramsPage().sorting();

	}

	@When("User clicks on the Planogram Name link, the {string} form with prefilled values should be displayed")
	public void userClicksOnThePlanogramNameLinkTheFormWithPrefilledValuesShouldBeDisplayed(String string)
			throws InterruptedException {

		pom.getPlanogramsPage().clicksPlanogramNameLink();
	}

	@When("User updates the Name to {string}, the Description to {string}, and optionally uploads a new file")
	public void userUpdatesTheNameToTheDescriptionToAndOptionallyUploadsANewFile(String updateName,
			String updateDescription) {
		pom.getPlanogramsPage().updatePlanogramDetails(updateName, updateDescription);
	}

	@When("clicks {string} the updated details should reflect in the listing")
	public void clicksTheUpdatedDetailsShouldReflectInTheListing(String string) {

		pom.getPlanogramsPage().clickwithUpdate();

	}

	@When("User clicks the PDF icon in the Action column, the planogram document should open in a new tab")
	public void userClicksThePDFIconInTheActionColumnThePlanogramDocumentShouldOpenInANewTab() {

		pom.getPlanogramsPage().pdfDocument();
	}

	@When("User deletes the planogram and confirms, it should be removed from the list and display {string}")
	public void userDeletesThePlanogramAndConfirmsItShouldBeRemovedFromTheListAndDisplay(String deleteMessage) {

		pom.getPlanogramsPage().deletePlanogram();
		WebElement toastMessagePlanogramDelete = pom.getPlanogramsPage().getToastMessagePlanogramDelete();
		assertEquals(toastMessagePlanogramDelete, deleteMessage);
	}

}
