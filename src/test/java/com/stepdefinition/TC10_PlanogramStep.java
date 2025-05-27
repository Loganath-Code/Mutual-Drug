package com.stepdefinition;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebElement;

import com.base.BaseClass;
import com.pageManager.PageObjectManager;

import io.cucumber.java.en.*;

public class TC10_PlanogramStep extends BaseClass {
	PageObjectManager pom = new PageObjectManager();

	/**
	 * Navigates to the Administration section, selects Planograms, and verifies
	 * that the title of the Planograms page matches the expected breadcrumb title.
	 *
	 * @param expectedBreadcrumbTitle The expected title of the Planograms page.
	 */
	@Then("User navigates to Administration selects Planograms, verifies the page title should be {string}")
	public void userNavigatesToAdministrationSelectsPlanogramsVerifiesThePageTitleShouldBe(String breadcrumbTitle) {
		pom.getAdminDashboardPage().navigatesPlanograms();
		WebElement titlePlanogram = pom.getPlanogramsPage().getTitlePlanogram();
		assertEquals(titlePlanogram, breadcrumbTitle);

	}

	/**
	 * Verifies that clicking on "Add Planogram" navigates the user to the page with
	 * the specified title.
	 *
	 * @param expectedTitleAddPlanogram The expected title of the "Add Planogram"
	 *                                  page.
	 */
	@Then("User should verifies to clicks on Add Planogram navigates through the {string}")
	public void userShouldVerifiesToClicksOnAddPlanogramNavigatesThroughThe(String titleAddPlanogram) {
		pom.getPlanogramsPage().clicksPlanogram();
		WebElement titlePlanogram = pom.getPlanogramsPage().getTitleAddPlanogram();
		assertEquals(titlePlanogram, titleAddPlanogram);
	}

	/**
	 * @see Used to Submits the planogram details, including the name, description,
	 *      and optionally uploads a file.
	 *
	 * @param name        The name of the planogram to submit.
	 * @param description The description of the planogram to submit.
	 */
	@When("User should submit the details with {string}, {string} and to upload file")
	public void userShouldSubmitTheDetailsWithAndToUploadFile(String name, String description) {
		pom.getPlanogramsPage().createPlanogram(name, description);
	}

	/**
	 * @see Clicks on a "Save" and then verifies that the newly created planogram is
	 *      listed on the Planograms page with the correct details.
	 * @param string
	 * @param string2
	 */
	@Then("User clicks on {string} the new planogram should be listed on the Planograms page with the correct {string}")
	public void userClicksOnTheNewPlanogramShouldBeListedOnThePlanogramsPageWithTheCorrect(String string,
			String string2) {
		pom.getPlanogramsPage().clicksSave();
	}

	/**
	 * @see Used to Searches for planograms using the search bar and then verifies
	 *      that the displayed results match the provided data table.
	 * @param string
	 * @param dataTable
	 * @throws InterruptedException
	 */
	@When("User searches for {string} using the search bar then matching results should be displayed:")
	public void userSearchesForUsingTheSearchBarThenMatchingResultsShouldBeDisplayed(String string,
			io.cucumber.datatable.DataTable dataTable) throws InterruptedException {

		List<Map<String, String>> searchPlanogramsList = dataTable.asMaps();
		for (Map<String, String> planogram : searchPlanogramsList) {
			String searchPlanogram = planogram.get("searchPlanogram");
			pom.getPlanogramsPage().searchPlanogram(searchPlanogram);

		}
	}

	/**
	 * @see Used to Verifies the sorting functionality for the Name, Description,
	 *      and Created Date columns in both ascending and descending order.
	 *
	 * @throws InterruptedException If the thread is interrupted during the
	 *                              operation.
	 */

	@When("User verifies that the sorting functionality in both ascending and descending Name, Description and Created date")
	public void userVerifiesThatTheSortingFunctionalityInBothAscendingAndDescendingNameDescriptionAndCreatedDate()
			throws InterruptedException {
		refreshNavigation();
		Thread.sleep(1500);
		pom.getPlanogramsPage().sorting();

	}

	/**
	 * @see Used to Clicks on the Planogram Name link in the planogram list. This
	 *      action is expected to navigate the user to the specified form (e.g.,
	 *      "Edit Planogram") with the existing planogram details pre-filled.
	 *
	 * @param formTitle The expected title of the form that appears after clicking
	 *                  the planogram name link.
	 * @throws InterruptedException If the thread is interrupted during the
	 *                              operation.
	 */
	@When("User clicks on the Planogram Name link, the {string} form with prefilled values should be displayed")
	public void userClicksOnThePlanogramNameLinkTheFormWithPrefilledValuesShouldBeDisplayed(String string)
			throws InterruptedException {

		pom.getPlanogramsPage().clicksPlanogramNameLink();
	}

	/**
	 * @see Used to Updates the Name and Description of the planogram. This step
	 *      also optionally handles the upload of a new file
	 *
	 * @param updateName        The new name to update the planogram to.
	 * @param updateDescription The new description to update the planogram to.
	 */
	@When("User updates the Name to {string}, the Description to {string}, and optionally uploads a new file")
	public void userUpdatesTheNameToTheDescriptionToAndOptionallyUploadsANewFile(String updateName,
			String updateDescription) {
		pom.getPlanogramsPage().updatePlanogramDetails(updateName, updateDescription);
	}

	/**
	 * @see Used to Clicks the Update button with planogram details.
	 *
	 * @param buttonText The text of the button to click ("Update").
	 */
	@When("clicks {string} the updated details should reflect in the listing")
	public void clicksTheUpdatedDetailsShouldReflectInTheListing(String string) {

		pom.getPlanogramsPage().clickwithUpdate();

	}

	/**
	 * @see Used to Clicks the PDF icon in the Action column for a planogram. This
	 *      action is expected to open the planogram document in a new browser tab.
	 */
	@When("User clicks the PDF icon in the Action column, the planogram document should open in a new tab")
	public void userClicksThePDFIconInTheActionColumnThePlanogramDocumentShouldOpenInANewTab() {

		pom.getPlanogramsPage().pdfDocument();
	}

	/**
	 * @see Used to Deletes the planogram and confirms the deletion. It then
	 *      verifies that the planogram is removed from the list and that the
	 *      expected delete message is displayed.
	 *
	 * @param deleteMessage The expected message displayed after successful
	 *                      deletion.
	 */
	@When("User deletes the planogram and confirms, it should be removed from the list and display {string}")
	public void userDeletesThePlanogramAndConfirmsItShouldBeRemovedFromTheListAndDisplay(String deleteMessage) {

		pom.getPlanogramsPage().deletePlanogram();
		WebElement toastMessagePlanogramDelete = pom.getPlanogramsPage().getToastMessagePlanogramDelete();
		assertEquals(toastMessagePlanogramDelete, deleteMessage);
	}

	/**
	 * @see Used to Clicks the save button without entering any planogram details.
	 *
	 * @param buttonText The text of the button to click ("Save").
	 */
	@Then("User clicks the {string} button without entering any planogram details")
	public void userClicksTheButtonWithoutEnteringAnyPlanogramDetails(String string) {
		pom.getPlanogramsPage().clicksSave();
	}

	/**
	 * @see Used to Verifies that the error messages for name, file, and description
	 *      are displayed and match the expected values.
	 *
	 * @param expectedMessageName        The expected error message for the name
	 *                                   field.
	 * @param expectedMessageFile        The expected error message for the file
	 *                                   field.
	 * @param expectedMessageDescription The expected error message for the
	 *                                   description field.
	 */
	@Then("User verifies that the error messages {string}, {string} and {string} is displayed")
	public void userVerifiesThatTheErrorMessagesAndIsDisplayed(String expectedMessageName, String expectedMessageFile,
			String expectedMessageDescription) {
		WebElement errorMessageName = pom.getPlanogramsPage().getErrorMessageName();
		WebElement errorMessageFile = pom.getPlanogramsPage().getErrorMessageFile();
		WebElement errorMessageDescription = pom.getPlanogramsPage().getErrorMessageDescription();
		assertEquals(errorMessageName, expectedMessageName);
		assertEquals(errorMessageFile, expectedMessageFile);
		assertEquals(errorMessageDescription, expectedMessageDescription);
	}
}
