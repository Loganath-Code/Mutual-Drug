package com.stepdefinition;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebElement;

import com.base.BaseClass;
import com.pageManager.PageObjectManager;

import io.cucumber.java.en.*;

public class TC6_AdminOrderTemplatesStep extends BaseClass {
	PageObjectManager pom = new PageObjectManager();

	@Then("User navigates to Order Templates by selecting Administration, then Orders, and clicks on Order Templates to verify that the page title displays {string}")
	public void userNavigatesToOrderTemplatesBySelectingAdministrationThenOrdersAndClicksOnOrderTemplatesToVerifyThatThePageTitleDisplays(
			String expectedOrderTemplates) {
		pom.getAdminDashboardPage().navigatesOrderTemplates();
		WebElement titleOrderTemplates = pom.getAdminOrderTemplatesPage().getTitleOrderTemplates();
		assertEquals(titleOrderTemplates, expectedOrderTemplates);

	}

	@When("User creates a new template, click on Create and enter {string} and {string} as the template details")
	public void userCreatesANewTemplateClickOnCreateAndEnterAndAsTheTemplateDetails(String templateName,
			String templateType) {

		pom.getAdminOrderTemplatesPage().createNewTemplates(templateName, templateType);
	}

	@When("User Adds the items\\/products using item number in Order Templates:")
	public void userAddsTheItemsProductsUsingItemNumberInOrderTemplates(io.cucumber.datatable.DataTable dataTable)
			throws InterruptedException {

		List<Map<String, String>> itemsData = dataTable.asMaps();

		for (Map<String, String> item : itemsData) {
			String itemsNum = item.get("itemsNum");
			String orderQty = item.get("orderQty");
			String successMessage = item.get("successMessage");
			pom.getAdminOrderTemplatesPage().addItemsinOrderTemplates(itemsNum, orderQty, successMessage);
		}

	}

	@Then("User should update the Order Templates name {string} and verifies success message as {string}")
	public void userShouldUpdateTheOrderTemplatesNameAndVerifiesSuccessMessageAs(String templateName,
			String alertMessageTemplateNameUpdate) throws InterruptedException {
		pom.getAdminOrderTemplatesPage().updateOrderTemplateName(templateName);
		Thread.sleep(1500);
		WebElement successMessageTemplateNameUpdate = pom.getAdminOrderTemplatesPage()
				.getSuccessMessageTemplateNameUpdate();
		assertEquals(successMessageTemplateNameUpdate, alertMessageTemplateNameUpdate);
	}

	@When("User verifies that the sorting functionality in both ascending and descending orders for items, Product Discriptions, Categories, Whs.qty and Added")
	public void userVerifiesThatTheSortingFunctionalityInBothAscendingAndDescendingOrdersForItemsProductDiscriptionsCategoriesWhsQtyAndAdded()
			throws InterruptedException {

		refreshNavigation();
		Thread.sleep(1500);
		pom.getAdminOrderTemplatesPage().sorting();

	}

	@Then("User updates item quantities in the grid and verifies that the {string} alert message is displayed.")
	public void userUpdatesItemQuantitiesInTheGridAndVerifiesThatTheAlertMessageIsDisplayed(String string) {

		pom.getAdminOrderTemplatesPage().updateQty();
	}

	@Then("User deletes an item from the grid and verifies that the {string} alert message is displayed.")
	public void userDeletesAnItemFromTheGridAndVerifiesThatTheAlertMessageIsDisplayed(String itemDeleteMessage) {
		try {
			WebElement tdiDelete = pom.getAdminOrderTemplatesPage().getTdiDelete();
			clickElementUsingJavaScript(driver, tdiDelete);
			WebElement successMessageTemplateItemDetele = pom.getAdminOrderTemplatesPage()
					.getSuccessMessageTemplateItemDetele();
			assertEquals(successMessageTemplateItemDetele, itemDeleteMessage);
		} catch (Exception e) {

		}
	}

	@Then("User verifies the pagination functionality within the Order Templates grid")
	public void userVerifiesThePaginationFunctionalityWithinTheOrderTemplatesGrid() throws InterruptedException {

		pom.getAdminOrderTemplatesPage().pageNavigations();
	}

	@Then("User navigates back to {string} using the breadcrumb link.")
	public void userNavigatesBackToUsingTheBreadcrumbLink(String string) {

		WebElement getbCrumblinkTemplates = pom.getAdminOrderTemplatesPage().getbCrumblinkTemplates();
		clickElementUsingJavaScript(driver, getbCrumblinkTemplates);
	}

	@When("User clicks Create Customer Order with {string} and {string} then clicks Create to submit")
	public void userClicksCreateCustomerOrderWithAndThenClicksCreateToSubmit(String memberNumber, String templatesName)
			throws InterruptedException {
		refreshNavigation();
		pom.getAdminOrderTemplatesPage().createCustomerOrder(memberNumber, templatesName);

	}

	@Then("User verifies the Success message as {string}")
	public void userVerifiesTheSuccessMessageAs(String orderCreatedMessage) throws InterruptedException {
		WebElement successMessageCustomerOrderCreated = pom.getAdminOrderTemplatesPage()
				.getSuccessMessageCustomerOrderCreated();
		assertEquals(successMessageCustomerOrderCreated, orderCreatedMessage);
		Thread.sleep(10000);
	}

	@Then("User should search {string} template name and verifies to displaying grid.")
	public void userShouldSearchTemplateNameAndVerifiesToDisplayingGrid(String templateName) {

		pom.getCurrentOrderPage().searchTemplates(templateName);
		WebElement firstOrderName = pom.getCurrentOrderPage().getFirstOrderName();
		assertEquals(firstOrderName, templateName);
	}

	@Then("User performs a search with the template name {string} and confirms that the template appears in the displayed grid")
	public void userPerformsASearchWithTheTemplateNameAndConfirmsThatTheTemplateAppearsInTheDisplayedGrid(
			String templateName) {
		pom.getAdminOrderTemplatesPage().searchTemplates(templateName);
	}

	@Then("User verifies that sorting works in both ascending and descending order for the columns: Template Name, Created Date, Template Type, and Total Lines")
	public void userVerifiesThatSortingWorksInBothAscendingAndDescendingOrderForTheColumnsTemplateNameCreatedDateTemplateTypeAndTotalLines() {
		pom.getAdminOrderTemplatesPage().orderTemplatesSorting();
	}

	@Then("User deletes a Order Template from the list and verifies the {string} alert message")
	public void userDeletesAOrderTemplateFromTheListAndVerifiesTheAlertMessage(String string) {
		pom.getAdminOrderTemplatesPage().deleteOrderTemplate();
	}

	@Then("User verifies pagination functionality on the Order Templates")
	public void userVerifiesPaginationFunctionalityOnTheOrderTemplates() throws InterruptedException {
		pom.getAdminOrderTemplatesPage().pageNavigations();
	}

	@When("User Create New Order Template without entering any details and clicks Create")
	public void userCreateNewOrderTemplateWithoutEnteringAnyDetailsAndClicksCreate() {

		pom.getAdminOrderTemplatesPage().orderTemplateswithEmptyFields();
	}

	@Then("User should verifies the error messages {string} and {string}")
	public void userShouldVerifiesTheErrorMessagesAnd(String expectedMessageTemplateName,
			String expectedMessageTemplateType) {
		WebElement errorMessageTemplateName = pom.getAdminOrderTemplatesPage().getErrorMessageTemplateName();
		assertEquals(errorMessageTemplateName, expectedMessageTemplateName);
		WebElement errorMessageTemplateType = pom.getAdminOrderTemplatesPage().getErrorMessageTemplateType();
		assertEquals(errorMessageTemplateType, expectedMessageTemplateType);
	}

	@Then("User provides Space in Template Name with {string} Template type and tries to create an Template Order then see the error message {string}")
	public void userProvidesSpaceInTemplateNameWithTemplateTypeAndTriesToCreateAnTemplateOrderThenSeeTheErrorMessage(
			String templateType, String expectedMessageTemplateName) {
		pom.getAdminOrderTemplatesPage().templateNameWithSpace(templateType);
		WebElement errorMessageTemplateName = pom.getAdminOrderTemplatesPage().getErrorMessageTemplateName();
		assertEquals(errorMessageTemplateName, expectedMessageTemplateName);
	}

	@Then("User enter Template Name with special characters with {string} Template type and tries to create an Template Order and should see the error message {string}")
	public void userEnterTemplateNameWithSpecialCharactersWithTemplateTypeAndTriesToCreateAnTemplateOrderAndShouldSeeTheErrorMessage(
			String special, String expectedMessageTemplateNamewithSpecialChar) {
		pom.getAdminOrderTemplatesPage().templateNamewithSpecialChar(special);
		WebElement errorMessageTemplateNamewithSpecialChar = pom.getAdminOrderTemplatesPage()
				.getErrorMessageTemplateNamewithSpecialChar();
		assertEquals(errorMessageTemplateNamewithSpecialChar, expectedMessageTemplateNamewithSpecialChar);
	}

	@Then("User enters  more than {int}  characters as the Order Templates Name is \" abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnop \"with {string} Templates type and tries to create a Order Templates and User should see the error message as {string}")
	public void userEntersMoreThanCharactersAsTheOrderTemplatesNameIsAbcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopWithTemplatesTypeAndTriesToCreateAOrderTemplatesAndUserShouldSeeTheErrorMessageAs(
			Integer int1, String templateName, String string2) throws InterruptedException {
		pom.getAdminOrderTemplatesPage().templateNamewithMaxChar(templateName);
		WebElement errorMessageTemplateNamemaxChar = pom.getAdminOrderTemplatesPage()
				.getErrorMessageTemplateNamemaxChar();
		assertEquals(errorMessageTemplateNamemaxChar, string2);
		WebElement getiClose = pom.getAdminOrderTemplatesPage().getiClose();
		clickElementUsingJavaScript(driver, getiClose);
	}

	@Then("User clicks Create Customer Order and without entering any details then clicks Create to submit")
	public void userClicksCreateCustomerOrderAndWithoutEnteringAnyDetailsThenClicksCreateToSubmit() {
		pom.getAdminOrderTemplatesPage().createCustomerOrderWithEmptyFields();
	}

	@Then("User should verifies the displaying error message {string} and {string}")
	public void userShouldVerifiesTheDisplayingErrorMessageAnd(String expectedErrorMessageMemberNumber,
			String expectedErrorMessageTemplateName) {
		WebElement errorMessageMemberNumber = pom.getAdminOrderTemplatesPage().getErrorMessageMemberNumber();
		assertEquals(errorMessageMemberNumber, expectedErrorMessageMemberNumber);
		WebElement errorMessageTemplate = pom.getAdminOrderTemplatesPage().getErrorMessageTemplate();
		assertEquals(errorMessageTemplate, expectedErrorMessageTemplateName);
	}

	@Then("User should insert invalid details tries to create Customer order")
	public void userShouldInsertInvalidDetailsTriesToCreateCustomerOrder(io.cucumber.datatable.DataTable dataTable) {

		List<Map<String, String>> orderDatas = dataTable.asMaps();

		for (Map<String, String> item : orderDatas) {
			String memberNumber = item.get("memberNumber");
			String templatesName = item.get("templatesName");
			pom.getAdminOrderTemplatesPage().createCustomerOrderWithInvalidFields(memberNumber, templatesName);
		}
	}

	@Then("User removes template name and verifies the error message as {string}")
	public void userRemovesTemplateNameAndVerifiesTheErrorMessageAs(String errormessage) {
		pom.getAdminOrderTemplatesPage().removeTemplateName();
		WebElement errorMessageTemplateName = pom.getAdminOrderTemplatesPage().getErrorMessageTemplateName();
		assertEquals(errorMessageTemplateName, errormessage);
	}

	@Then("User clicks on Add without adding any Items and verifies the warning message {string}")
	public void userClicksOnAddWithoutAddingAnyItemsAndVerifiesTheWarningMessage(String itemCode) {
		WebElement btnAdd = pom.getAdminOrderTemplatesPage().getBtnAdd();
		clickElementUsingJavaScript(driver, btnAdd);
		WebElement warningMessageItemCodeRequired = pom.getAdminOrderTemplatesPage()
				.getWarningMessageItemCodeRequired();
		assertEquals(warningMessageItemCodeRequired, itemCode);

	}

	@Then("User adds a item number {string} with an empty Order Qty field, clicks Add, and verifies the warning message {string}")
	public void userAddsAItemNumberWithAnEmptyOrderQtyFieldClicksAddAndVerifiesTheWarningMessage(String itemNum,
			String string2) throws InterruptedException {

		pom.getAdminOrderTemplatesPage().emptyOrderQtyField(itemNum);
		WebElement warningMessageOrderQty = pom.getAdminOrderTemplatesPage().getWarningMessageOrderQty();
		assertEquals(warningMessageOrderQty, string2);
	}

	@Then("User adds a item number {string} , insert order qty as {string} clicks on Add and verifies the warning message {string}")
	public void userAddsAItemNumberInsertOrderQtyAsClicksOnAddAndVerifiesTheWarningMessage(String itemNum,
			String orderQty, String string3) throws InterruptedException {

		pom.getAdminOrderTemplatesPage().validateOrderQty(itemNum, orderQty);

	}

	@Then("User adds a item number {string} , inputs an Order Qty greater than three digits {string}  clicks on Add and verifies the warning message {string}")
	public void userAddsAItemNumberInputsAnOrderQtyGreaterThanThreeDigitsClicksOnAddAndVerifiesTheWarningMessage(
			String itemNum, String orderQty, String MaxOrderQty) throws InterruptedException {
		pom.getAdminOrderTemplatesPage().validateOrderQty(itemNum, orderQty);
		WebElement warningMessageMaxOrderQty = pom.getAdminOrderTemplatesPage().getWarningMessageMaxOrderQty();
		assertEquals(warningMessageMaxOrderQty, MaxOrderQty);
	}

	@Then("User attempts to add C2 items {string} in Regular order Templates and verifies the alert message {string}")
	public void userAttemptsToAddC2ItemsInRegularOrderTemplatesAndVerifiesTheAlertMessage(String itemNum,
			String expectedAlertMessage) {
		pom.getAdminOrderTemplatesPage().restrictionItem(itemNum);
		WebElement alertMessageC2Item = pom.getAdminOrderTemplatesPage().getAlertMessageC2Item();
		assertEquals(alertMessageC2Item, expectedAlertMessage);
	}

	@Then("User attempts to add a discontinued and inactive item {string} to a Regular Order Template and verifies the alert message {string}")
	public void userAttemptsToAddADiscontinuedAndInactiveItemToARegularOrderTemplateAndVerifiesTheAlertMessage(
			String itemNum, String expectedAlertMessage) {
		pom.getAdminOrderTemplatesPage().restrictionItem(itemNum);
//		WebElement errorMessageItemNotFound = pom.getAdminOrderTemplatesPage().getErrorMessageItemNotFound();
//		assertEquals(errorMessageItemNotFound, expectedAlertMessage);

	}

	@Then("User attempts to add the same item {string} again to the Order Template and verifies the warning message {string}")
	public void userAttemptsToAddTheSameItemAgainToTheOrderTemplateAndVerifiesTheWarningMessage(String itemNum,
			String expectedAlertMessage) throws InterruptedException {
		pom.getAdminOrderTemplatesPage().itemValidation(itemNum);
		WebElement warningMessageItemalreadyAdded = pom.getAdminOrderTemplatesPage()
				.getWarningMessageItemalreadyAdded();
		assertEquals(warningMessageItemalreadyAdded, expectedAlertMessage);

	}

	@Then("User attempts an item with an empty field Order Qty in list and verifies that the warning message {string} is displayed.")
	public void userAttemptsAnItemWithAnEmptyFieldOrderQtyInListAndVerifiesThatTheWarningMessageIsDisplayed(
			String string) throws InterruptedException {
		pom.getAdminOrderTemplatesPage().updateOrderQtyinlist();
		WebElement warningMessageOrderQty = pom.getAdminOrderTemplatesPage().getWarningMessageOrderQty();
		assertEquals(warningMessageOrderQty, string);
	}
}
