package com.stepdefinition;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import com.base.BaseClass;
import com.pageManager.PageObjectManager;

import io.cucumber.java.en.*;

public class TC4_ReturnsStep extends BaseClass {
	PageObjectManager pom = new PageObjectManager();

	/**
	 * @see used for navigating to the Returns section and clicking on a specified
	 *      menu link.
	 *
	 * @param linkedMenu The name of the menu link to be clicked under Returns.
	 */
	@When("User navigates to Returns and clicks on {string}")
	public void userNavigatesToReturnsAndClicksOn(String linkedMenu) {

		pom.getDashboardPage().navigatesReturns(linkedMenu);

	}

	/**
	 * @see used for verify that the bread crumb title is displayed on the page and
	 *      matches the expected title.
	 *
	 * @param expectedTitle The expected bread crumb title text to verify.
	 */
	@Then("User should verify the breadcrumb title {string} is displayed on the page")
	public void userShouldVerifyTheBreadcrumbTitleIsDisplayedOnThePage(String expectedTitle) {

		WebElement titleReturns = pom.getReturnsPage().getBctitleReturns();
		verifyPageTitle(titleReturns, expectedTitle);
	}

	/**
	 * @see used to click on "Create New" and create one or more new return orders
	 *      based on the provided data table.
	 *
	 * @param dataTable A Cucumber DataTable containing return order details with
	 *                  columns like "returnName" and "returnType".
	 */
	@Then("User clicks on Create New to create a new returns")
	public void userClicksOnCreateNewToCreateANewReturns(io.cucumber.datatable.DataTable dataTable) {
		List<Map<String, String>> returnOrders = dataTable.asMaps();

		for (Map<String, String> returnOrder : returnOrders) {
			String returnName = returnOrder.get("returnName");
			String returnType = returnOrder.get("returnType");
			pom.getReturnsPage().createReturnOrder(returnName, returnType);
		}
	}

	/**
	 * @see used to remove the current Returns name and then navigate back to the
	 *      Returns page.
	 *
	 * @throws InterruptedException if the thread sleep is interrupted.
	 */
	@Then("User removes the Returns name and navigates back to the Returns page")
	public void userRemovesTheReturnsNameAndNavigatesBackToTheReturnsPage() throws InterruptedException {
		Thread.sleep(2000);
		pom.getReturnsPage().removeReturnName();
		pom.getReturnsPage().navigatesBackUsingBclink();
	}

	/**
	 * @see used to search for a returns name and verify that the grid displays the
	 *      expected returns name.
	 *
	 * @param returnName         The returns name to search for.
	 * @param expectedReturnName The expected returns name displayed in the grid.
	 * @throws InterruptedException if the thread sleep or wait is interrupted.
	 */
	@Then("User searches for a returns name {string} and verifies that the grid displays the returns name is {string}")
	public void userSearchesForAReturnsNameAndVerifiesThatTheGridDisplaysTheReturnsNameIs(String returnName,
			String ReturnName) throws InterruptedException {

		pom.getReturnsPage().searchReturnsName(returnName);
		pom.getReturnsPage().SubmittedDateSorting();
		WebElement tdFirstcell = pom.getReturnsPage().getTdFirstcell();
		assertEquals(tdFirstcell, ReturnName);

	}

	/**
	 * @see used to verify sorting functionality in both ascending and descending
	 *      order for all specified columns in the Returns grid.
	 * 
	 *      The columns verified are: Return Name, Status, Submitted Date, Submitted
	 *      By, Type, Total Lines, and Total Pieces.
	 */
	@Then("User verifies sorting order in both ascending and descending order for all columns Return Name, Status, Submitted Date, Submitted By, Type, Total Lines, and Total Pieces")
	public void userVerifiesSortingOrderInBothAscendingAndDescendingOrderForAllColumnsReturnNameStatusSubmittedDateSubmittedByTypeTotalLinesAndTotalPieces() {
		String[] columnNames = { "Return Name", "Status", "Submitted Date", "Submitted By", "Type", "Total Lines",
				"Total Pieces" };
		pom.getReturnsPage().verifySortingFunctionality(columnNames);
	}

	/**
	 * @see used to delete a return order from the returns list and verify the
	 *      displayed alert message.
	 *
	 * @param alertDeleteReturnsMessage The expected alert message after deleting
	 *                                  the return order.
	 */
	@Then("User deletes a return order from the returns list and verifies the {string} alert message")
	public void userDeletesAReturnOrderFromTheReturnsListAndVerifiesTheAlertMessage(String alertDeleteReturnsMessage) {
		pom.getReturnsPage().deleteReturDetails();
		WebElement returnsDelete = pom.getReturnsPage().getAlMeassageDelete();
		assertEquals(returnsDelete, alertDeleteReturnsMessage);
	}

	/**
	 * @see used to verify pagination functionality on the Returns page.
	 *
	 * @throws InterruptedException if any thread sleep or wait inside
	 *                              pageNavigations() is interrupted.
	 */
	@Then("User verifies pagination functionality on the Returns page")
	public void userVerifiesPaginationFunctionalityOnTheReturnsPage() throws InterruptedException {
		pom.getReturnsPage().pageNavigations();
	}

//	Regular returns
	/**
	 * 
	 * @see Used to that adds return items by searching for products
	 * @param dataTable a Cucumber DataTable containing return item details
	 * @throws InterruptedException if the thread is interrupted during execution
	 */
	@Then("User adds returns items by searching products:")
	public void userAddsReturnsItemsBySearchingProducts(io.cucumber.datatable.DataTable dataTable)
			throws InterruptedException {
		List<Map<String, String>> returnItems = dataTable.asMaps();
		for (Map<String, String> Item : returnItems) {
			String products = Item.get("products");
			String expirationDate = Item.get("expirationDate");
			String lotNumber = Item.get("lotNumber");
			String qty = Item.get("qty");
			String returnReason = Item.get("returnReason");
			String successMessage = Item.get("successMessage");
			pom.getReturnsPage().addReturnItem(products, expirationDate, lotNumber, qty, returnReason, successMessage);
		}
	}

	/**
	 * @see Used to that adds return items by using NDC or Product Description, then
	 *      adds Quantity with a Return Reason and clicks "Add To Return".
	 * @param dataTable a Cucumber DataTable containing return item details
	 */
	@Then("User should Add Returns items Using NDC, Product Description then add Quantity with Return Reason to clicks Add To Return")
	public void userShouldAddReturnsItemsUsingNDCProductDescriptionThenAddQuantityWithReturnReasonToClicksAddToReturn(
			io.cucumber.datatable.DataTable dataTable) throws InterruptedException {
		List<Map<String, String>> returnItems = dataTable.asMaps();
		for (Map<String, String> Item : returnItems) {
			String products = Item.get("products");
			String expirationDate = Item.get("expirationDate");
			String lotNumber = Item.get("lotNumber");
			String qty = Item.get("qty");
			String returnReason = Item.get("returnReason");
			String successMessage = Item.get("successMessage");
			pom.getReturnsPage().addReturnItem(products, expirationDate, lotNumber, qty, returnReason, successMessage);
		}
	}

	/**
	 * @see Used to that adds return items using UPC, then adds Quantity and Return
	 *      Reason, and finally clicks "Add To Return".
	 *
	 *      It iterates over the provided DataTable, extracts each return item’s
	 *      details, and invokes the <code>addReturnItem</code> method from the
	 *      Returns Page Object to simulate the return process.
	 * 
	 *      The UPC identifier of the product Expiration date of the product Lot
	 *      number for the returned item Quantity of the item to be returned Reason
	 *      for returning the item The expected success message after adding the
	 *      item
	 * 
	 * @param dataTable a Cucumber DataTable containing return item details
	 * @throws InterruptedException if the thread is interrupted during execution
	 */
	@Then("User Adds Returns items using UPC then add Quantity with Return Reason to clicks Add To Return:")
	public void userAddsReturnsItemsUsingUPCThenAddQuantityWithReturnReasonToClicksAddToReturn(
			io.cucumber.datatable.DataTable dataTable) throws InterruptedException {
		List<Map<String, String>> returnItems = dataTable.asMaps();
		for (Map<String, String> Item : returnItems) {
			String products = Item.get("products");
			String expirationDate = Item.get("expirationDate");
			String lotNumber = Item.get("lotNumber");
			String qty = Item.get("qty");
			String returnReason = Item.get("returnReason");
			String successMessage = Item.get("successMessage");
			pom.getReturnsPage().addReturnItem(products, expirationDate, lotNumber, qty, returnReason, successMessage);
		}
	}

	/**
	 * @see Used to that adds return items using GTIN, then adds Quantity and Return
	 *      Reason, and finally clicks "Add To Return".
	 * @param dataTable a Cucumber DataTable containing return item details
	 * @throws InterruptedException if the thread is interrupted during execution
	 */
	@Then("User Adds Add Returns items using GTIN then add Quantity with Return Reason to clicks Add To Return:")
	public void userAddsAddReturnsItemsUsingGTINThenAddQuantityWithReturnReasonToClicksAddToReturn(
			io.cucumber.datatable.DataTable dataTable) {
		List<Map<String, String>> returnItems = dataTable.asMaps();
		for (Map<String, String> Item : returnItems) {
			String products = Item.get("products");
			String expirationDate = Item.get("expirationDate");
			String lotNumber = Item.get("lotNumber");
			String qty = Item.get("qty");
			String returnReason = Item.get("returnReason");
			String successMessage = Item.get("successMessage");
			pom.getReturnsPage().addReturnItem(products, expirationDate, lotNumber, qty, returnReason, successMessage);
		}
	}

	/**
	 * Step definition to add return items using refined search criteria and sorting
	 * preferences.
	 * 
	 * @param string    a scenario label or descriptor (e.g., "regular", "special")
	 *                  for identifying the test case
	 * @param dataTable a Cucumber DataTable containing item details for search and
	 *                  return
	 */
	@Then("User adds {string} returns items using refined search criteria, sorting by sort By in sort Order order:")
	public void userAddsReturnsItemsUsingRefinedSearchCriteriaSortingBySortByInSortOrderOrder(String string,
			io.cucumber.datatable.DataTable dataTable) {

		List<Map<String, String>> searchRegularItems = dataTable.asMaps();
		for (Map<String, String> Item : searchRegularItems) {
			String addSearchProducts = Item.get("addSearchProducts");
			String refineSearch = Item.get("refineSearch");
			String category = Item.get("category");
			String sortBy = Item.get("sortBy");
			String sortOrder = Item.get("sortOrder");
			String expirationDate = Item.get("expirationDate");
			String lotNumber = Item.get("lotNumber");
			String qty = Item.get("qty");
			String returnReason = Item.get("returnReason");
			String successMessage = Item.get("successMessage");
			pom.getReturnsPage().refineSearchAndAddItem(addSearchProducts, refineSearch, category, sortBy, sortOrder,
					expirationDate, lotNumber, qty, returnReason, successMessage);
		}
	}

	/**
	 * Step definition to update the Returns product list based on data provided
	 * through a Cucumber DataTable. This method extracts a list of items from the
	 * DataTable where each row represents an item with fields such as expiration
	 * date, lot number, quantity, return reason, and an expected alert message. For
	 * each item, the method calls the `updateListItems` method from the Returns
	 * page object to perform the update operation.
	 *
	 * @param string    A placeholder string from the step definition, typically
	 *                  representing the type of return (e.g., "C2" or "Regular").
	 * @param dataTable The Cucumber DataTable containing rows of item information
	 *                  to be updated. Each row should have
	 */
	@Then("User updates the {string} Returns product list:")
	public void userUpdatesTheReturnsProductList(String string, io.cucumber.datatable.DataTable dataTable) {
		List<Map<String, String>> updateRegularItems = dataTable.asMaps();
		for (Map<String, String> Item : updateRegularItems) {
			String expirationDateGrid = Item.get("expirationDateGrid");
			String lotNumberGrid = Item.get("lotNumberGrid");
			String qtyGrid = Item.get("qtyGrid");
			String returnReasonGrid = Item.get("returnReasonGrid");
			String updateAlertMessage = Item.get("updateAlertMessage");
			pom.getReturnsPage().updateListItems(expirationDateGrid, lotNumberGrid, qtyGrid, returnReasonGrid,
					updateAlertMessage, lotNumberGrid);
		}
	}

	/**
	 * @see Used for changing the Returns name and verifying the alert message. This
	 *      method updates the return name using the provided string and then
	 *      retrieves the resulting alert message displayed on the UI. It asserts
	 *      that the actual alert message matches the expected one.
	 *
	 * @param returnName     The new name to be set for the return.
	 * @param updatedMessage The expected alert message that should appear after
	 *                       updating the return name.
	 */
	@Then("User can change Returns name as {string} then  verifying the alert message  {string}")
	public void userCanChangeReturnsNameAsThenVerifyingTheAlertMessage(String returnName, String updatedMessage) {
		pom.getReturnsPage().updateReturnName(returnName);
		WebElement alMessageReturnNameUpdate = pom.getReturnsPage().getAlMessageReturnNameUpdate();
		assertEquals(alMessageReturnNameUpdate, updatedMessage);
	}

	/**
	 * @see Used for verifying sorting and deletion functionality in the Returns
	 *      product list. Verifies that sorting works correctly for the "Item#" and
	 *      "Product Description" columns. Deletes an item from the return list.
	 *      Asserts that the alert message displayed after deletion matches the
	 *      expected message.
	 *
	 * @param alertDeleteMessage The expected alert message displayed after an item
	 *                           is deleted from the return list.
	 */
	@Then("User should sort by Items and Product Description and delete an item from the return list, verifying the alert message  {string}")
	public void userShouldSortByItemsAndProductDescriptionAndDeleteAnItemFromTheReturnListVerifyingTheAlertMessage(
			String alertDeleteMessage) {
		String[] columnNames = { "Item#", "product Discription" };
		pom.getReturnsPage().verifySortingFunctionality(columnNames);
		pom.getReturnsPage().deleteIteminGrid();
		WebElement alDeleteMessage = pom.getReturnsPage().getAlDeleteMessage();
		assertEquals(alDeleteMessage, alertDeleteMessage);
	}

	/**
	 * @see Used for verifying pagination functionality on the Returns items page.
	 *      This method triggers the pagination logic to navigate through multiple
	 *      pages of return items, ensuring that the pagination controls (e.g.,
	 *      next, previous, specific page numbers) function as expected.
	 *
	 * @throws InterruptedException if the thread is interrupted during page
	 *                              navigation (e.g., due to waits or sleep calls).
	 */
	@Then("User should navigate through pages using pagination controls on the Returns items page")
	public void userShouldNavigateThroughPagesUsingPaginationControlsOnTheReturnsItemsPage()
			throws InterruptedException {

		pom.getReturnsPage().pageNavigations();
	}

	/**
	 * @see Used for signing and submitting the Returns form and verifying the
	 *      success alert message. Clicks the "Sign & Submit" button on the Returns
	 *      page. Fills in the signature details including the authorized signature
	 *      name, title, and signature font. Verifies that the alert success message
	 *      displayed after submission matches the expected message.
	 * 
	 *
	 * @param authorisedSignature The name to be used as the authorized signature.
	 * @param title               The title associated with the signature.
	 * @param signatureFont       The font style used for the signature.
	 * @param string4             The expected alert message after successful
	 *                            submission.
	 */
	@Then("User clicks on Sign & Submit and submits with {string}, {string}, and {string} and verifying alert success message as {string}")
	public void userClicksOnSignSubmitAndSubmitsWithAndAndVerifyingAlertSuccessMessageAs(String authorisedSignature,
			String title, String signatureFont, String string4) {
		pom.getReturnsPage().clicksSignSubmit();
		pom.getReturnsPage().insertSignSubmitDetail(authorisedSignature, title, signatureFont);
		WebElement successMessageReturnSubmitted = pom.getReturnsPage().getSuccessMessageReturnSubmitted();
		assertEquals(successMessageReturnSubmitted, string4);

	}

	/**
	 * @see Used to adding return items by searching for products during a Cucumber
	 *      test.
	 * 
	 *      This method reads data from a Cucumber DataTable, where each row
	 *      represents a return item with fields such as product name, expiration
	 *      date, lot number, quantity, return reason, and an expected success
	 *      message.
	 *
	 * 
	 * 
	 * @param string    A string parameter passed from the Cucumber step (typically
	 *                  unused in this implementation but may be used as a scenario
	 *                  label or identifier).
	 * @param dataTable A DataTable from the Cucumber feature file containing return
	 *                  item details. Expected column headers include: "products",
	 *                  "expirationDate", "lotNumber", "qty", "returnReason",
	 *                  "successMessage".
	 */
	@Then("User adds {string} returns items by searching products:")
	public void userAddsReturnsItemsBySearchingProducts(String string, io.cucumber.datatable.DataTable dataTable) {

		List<Map<String, String>> returnItems = dataTable.asMaps();
		for (Map<String, String> Item : returnItems) {
			String products = Item.get("products");
			String expirationDate = Item.get("expirationDate");
			String lotNumber = Item.get("lotNumber");
			String qty = Item.get("qty");
			String returnReason = Item.get("returnReason");
			String successMessage = Item.get("successMessage");
			pom.getReturnsPage().addReturnItem(products, expirationDate, lotNumber, qty, returnReason, successMessage);
		}
	}

	/**
	 * @see Used to clicking the "Print Returns" button printing a return and
	 *      viewing the PDF document
	 *
	 * @throws InterruptedException if the thread sleep is interrupted while waiting
	 *                              for the PDF to open.
	 */
	@Then("User should Cliks Print Returns then view the PDF document")
	public void userShouldCliksPrintReturnsThenViewThePDFDocument() throws InterruptedException {

		WebElement btnPrintReturn = pom.getReturnsPage().getBtnPrintReturn();
		click(btnPrintReturn);
		Thread.sleep(5000);
		getWindowHandle();
	}

	@Then("User clicks on Create New without entering a Return Name, Return Type and clicks the Create")
	public void userClicksOnCreateNewWithoutEnteringAReturnNameReturnTypeAndClicksTheCreate()
			throws InterruptedException {

		pom.getReturnsPage().returnsWithoutName();
	}

	@Then("User should see error messages {string} and {string}")
	public void userShouldSeeErrorMessagesAnd(String errorMessageReturnName, String errorMessageReturnType) {
		WebElement errorMessageReturnsName2 = pom.getReturnsPage().getErrorMessageReturnName();
		WebElement errorMessageReturnsType2 = pom.getReturnsPage().getErrorMessageReturnType();
		assertEquals(errorMessageReturnsName2, errorMessageReturnName);
		assertEquals(errorMessageReturnsType2, errorMessageReturnType);

	}

	@Then("User should insert Return Name with Special Characters {string} and Choose Return Type {string} and verifies the error message as {string}")
	public void userShouldInsertReturnNameWithSpecialCharactersAndChooseReturnTypeAndVerifiesTheErrorMessageAs(
			String returnName, String returnType, String errorMessageReturnNameSpecial) {
		pom.getReturnsPage().createReturnOrder(returnName, returnType);
		WebElement errorMessageSpecialChars = pom.getReturnsPage().getErrorMessageSpecialChars();
		assertEquals(errorMessageSpecialChars, errorMessageReturnNameSpecial);
	}

	@Then("User provides double space in the Return Name with {string} Return type and tries to create a Return then see the error message {string}")
	public void userProvidesDoubleSpaceInTheReturnNameWithReturnTypeAndTriesToCreateAReturnThenSeeTheErrorMessage(
			String returnType, String errorMessageReturnName) {
		pom.getReturnsPage().returnNameWithSpaces(returnType, 2);
		WebElement errorMessageReturnsName2 = pom.getReturnsPage().getErrorMessageReturnName();
		assertEquals(errorMessageReturnsName2, errorMessageReturnName);
	}

	@Then("User provides Single space in Return Name with {string} Return type and tries to create a Return then see the error message {string}")
	public void userProvidesSingleSpaceInReturnNameWithReturnTypeAndTriesToCreateAReturnThenSeeTheErrorMessage(
			String returnType, String errorMessageReturnName) {
		pom.getReturnsPage().returnNameWithSpaces(returnType, 1);
		WebElement errorMessageReturnsName2 = pom.getReturnsPage().getErrorMessageReturnName();
		assertEquals(errorMessageReturnsName2, errorMessageReturnName);
	}

	@Then("User enters  more than {int}  characters as the Return Name is {string} with {string} Return type and tries to create a Return and User should see the Return Name in the breadcrumb as {string}")
	public void userEntersMoreThanCharactersAsTheReturnNameIsWithReturnTypeAndTriesToCreateAReturnAndUserShouldSeeTheReturnNameInTheBreadcrumbAs(
			Integer int1, String returnName, String returnType, String expectedReturnOrderName) {

		pom.getReturnsPage().createReturnOrder(returnName, returnType);
		WebElement breadCrumbLinlReturnName = pom.getReturnsPage().getBreadCrumbLinlReturnName();
		String breadcrumbText = getText(breadCrumbLinlReturnName);
		String actualText = breadcrumbText.replace("Returns > ", "");
		Assert.assertEquals("Breadcrumb text does not match the expected value", expectedReturnOrderName, actualText);

	}

	// negative Regular
	@Then("User clicks on Sign & Submit without adding any Items and verifies the warning message {string}")
	public void userClicksOnSignSubmitWithoutAddingAnyItemsAndVerifiesTheWarningMessage(String errormessageSubmit) {
		pom.getReturnsPage().clicksSignSubmit();
		WebElement errorMessageSignSubmit = pom.getReturnsPage().getErrorMessageSignSubmit();
		assertEquals(errorMessageSignSubmit, errormessageSubmit);
		pom.getReturnsPage().iClose();
	}

	@Then("User searches for item {string} and verifies input validation on the Returns quantity field")
	public void userSearchesForItemAndVerifiesInputValidationOnTheReturnsQuantityField(String products)
			throws InterruptedException {
		pom.getReturnsPage().searchItem(products);
		pom.getProductDetailPage().validateQtyInputs(pom.getReturnsPage().getTxtQty());
	}

	@Then("User attempts to add {string} and discontinued items in {string} then see the warning message {string} for each item:")
	public void userAttemptsToAddAndDiscontinuedItemsInThenSeeTheWarningMessageForEachItem(String string,
			String string2, String warningMessage, io.cucumber.datatable.DataTable dataTable) {

		List<Map<String, String>> items = dataTable.asMaps();
		for (Map<String, String> Item : items) {
			String products = Item.get("products");
			pom.getReturnsPage().searchAndTryToAddItem(products, warningMessage);
		}
	}

	@Then("User attempts to add {string} and discontinued items using NDC and Product Discriptions in {string} then see the warning message {string} for each item:")
	public void userAttemptsToAddAndDiscontinuedItemsUsingNDCAndProductDiscriptionsInThenSeeTheWarningMessageForEachItem(
			String string, String string2, String warningMessage, io.cucumber.datatable.DataTable dataTable) {
		List<Map<String, String>> items = dataTable.asMaps();
		for (Map<String, String> Item : items) {
			String products = Item.get("products");
			pom.getReturnsPage().searchAndTryToAddItem(products, warningMessage);
		}
	}

	@Then("User attempts to add {string} and discontinued items using UPC in {string} then see the warning message {string} for each item:")
	public void userAttemptsToAddAndDiscontinuedItemsUsingUPCInThenSeeTheWarningMessageForEachItem(String string,
			String string2, String warningMessage, io.cucumber.datatable.DataTable dataTable) {
		List<Map<String, String>> items = dataTable.asMaps();
		for (Map<String, String> Item : items) {
			String products = Item.get("products");
			pom.getReturnsPage().searchAndTryToAddItem(products, warningMessage);
		}
	}

	@Then("User attempts to add {string} and discontinued items using GTIN in {string} then see the warning message {string} for each item:")
	public void userAttemptsToAddAndDiscontinuedItemsUsingGTINInThenSeeTheWarningMessageForEachItem(String string,
			String string2, String warningMessage, io.cucumber.datatable.DataTable dataTable) {
		List<Map<String, String>> items = dataTable.asMaps();
		for (Map<String, String> Item : items) {
			String products = Item.get("products");
			pom.getReturnsPage().searchAndTryToAddItem(products, warningMessage);
		}
	}

	@Then("User adds a returns by item number {string}, does not select a return reason, clicks on Add to Return and verifies the warning message {string}")
	public void userAddsAReturnsByItemNumberDoesNotSelectAReturnReasonClicksOnAddToReturnAndVerifiesTheWarningMessage(
			String products, String expectedErrorMessageReturnReason) {
		pom.getReturnsPage().searchItem(products);
		pom.getReturnsPage().clickAddToReturnWithoutSelectingReason();
		WebElement errorMessageReturnReason = pom.getReturnsPage().getErrorMessageReturnReason();
		assertEquals(errorMessageReturnReason, expectedErrorMessageReturnReason);
		pom.getReturnsPage().iClose();
	}

	@Then("User insert invalid date with {string} and clicks Add To Order then verifies the warning messages {string}")
	public void userInsertInvalidDateWithAndClicksAddToOrderThenVerifiesTheWarningMessages(String invalidDate,
			String errorMessage) {

		pom.getReturnsPage().insertInvalidDate(invalidDate);
		WebElement errormessageInvalidDate = pom.getReturnsPage().getErrormessageInvalidDate();
		assertEquals(errormessageInvalidDate, errorMessage);
		pom.getReturnsPage().iClose();
	}

	@Then("User adds item {string} with Reaturn Reason as {string} and Clicks Add To Order without enter RA Number then verifies the warning messages {string}")
	public void userAddsItemWithReaturnReasonAsAndClicksAddToOrderWithoutEnterRANumberThenVerifiesTheWarningMessages(
			String items, String returnReason, String expectedRAErrorMessage) {

		pom.getReturnsPage().submitReturnWithoutRANumber(items, returnReason);
		WebElement errorMessageRANumber = pom.getReturnsPage().getErrorMessageRANumber();
		assertEquals(errorMessageRANumber, expectedRAErrorMessage);
	}

	@Then("User adds return items by searching products insert nill qty verifies warning message")
	public void userAddsReturnItemsBySearchingProductsInsertNillQtyVerifiesWarningMessage(
			io.cucumber.datatable.DataTable dataTable) {
		List<Map<String, String>> returnItems = dataTable.asMaps();
		for (Map<String, String> Item : returnItems) {
			String products = Item.get("products");
			String expirationDate = Item.get("expirationDate");
			String lotNumber = Item.get("lotNumber");
			String qty = Item.get("qty");
			String returnReason = Item.get("returnReason");
			String warningmessage = Item.get("warningmessage");
			pom.getReturnsPage().addReturnItemwithNillQty(products, expirationDate, lotNumber, qty, returnReason,
					warningmessage);

		}
	}

	@Then("User insert invalid date with {string} in the Grid then verifies the warning messages {string}")
	public void userInsertInvalidDateWithInTheGridThenVerifiesTheWarningMessages(String invalidDate, String string2)
			throws InterruptedException {
		pom.getReturnsPage().invalidExpirationDateInGrid(invalidDate);

	}

	@Then("User enters a returns quantity of {string} in the grid and sees the warning message {string}")
	public void userEntersAReturnsQuantityOfInTheGridAndSeesTheWarningMessage(String updateQty,
			String expectedWarningMessage) {
		pom.getReturnsPage().updateReturnQtyinList(updateQty);
		WebElement errorMessageReturnQty = pom.getReturnsPage().getErrorMessageReturnQty();
		assertEquals(errorMessageReturnQty, expectedWarningMessage);
		pom.getReturnsPage().iClose();
	}

	@Then("User clicks on Sign & Submit and submits")
	public void userClicksOnSignSubmitAndSubmits() {
		pom.getReturnsPage().clicksSignSubmit();
	}

	@Then("User should clicks on Sign & Submit and Without entering Authorized Signature \\(Type First & Last Name), title then see the error message as {string} , {string}")
	public void userShouldClicksOnSignSubmitAndWithoutEnteringAuthorizedSignatureTypeFirstLastNameTitleThenSeeTheErrorMessageAs(
			String expectedErrorMessageAuthorizedSignature, String expectedErrorMessageTitle) {
		WebElement btnSignsubmit = pom.getReturnsPage().getBtnSignsubmit();
		clickElementUsingJavaScript(driver, btnSignsubmit);
		WebElement errorMessageAuthorizedSignature = pom.getReturnsPage().getErrorMessageAuthorizedSignature();
		assertEquals(errorMessageAuthorizedSignature, expectedErrorMessageAuthorizedSignature);
		WebElement errorMessageTitle = pom.getReturnsPage().getErrorMessageTitle();
		assertEquals(errorMessageTitle, expectedErrorMessageTitle);
		// field validations
		WebElement txtAuthorizedSignature = pom.getReturnsPage().getTxtAuthorizedSignature();
		txtAuthorizedSignature.sendKeys("abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz ");
		WebElement txtTitle = pom.getReturnsPage().getTxtTitle();
		txtTitle.sendKeys("abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz ");
		WebElement signatureContainer = pom.getReturnsPage().getSignatureContainer();
		String text = getText(signatureContainer);
		System.out.println(text);
		System.out.println("Length of text from signature container: " + text.length());
		WebElement txtTitles = pom.getReturnsPage().getTitleField();
		String text2 = getText(txtTitles);
		System.out.println("Length of text from Title: " + text2.length());
		System.out.println(text2);
	}

	@Then("User adds a C2 returns by item number {string} with various missing fields \\(Expiration date, Lot Number, Qty, Return Reason) and verifies the corresponding warning messages: {string} , {string} , {string} and {string}")
	public void userAddsAC2ReturnsByItemNumberWithVariousMissingFieldsExpirationDateLotNumberQtyReturnReasonAndVerifiesTheCorrespondingWarningMessagesAnd(
			String searchProducts, String dateErrorMessage, String errorMessageLotNumber, String errorMessageQty,
			String ErrorMessageReturnReason) throws InterruptedException {

		pom.getReturnsPage().c2FieldErrorValidation(searchProducts, dateErrorMessage, errorMessageLotNumber,
				errorMessageQty, ErrorMessageReturnReason);
	}

	@Then("User validated return reason with closed out item {string} and see the error message {string}")
	public void userValidatedReturnReasonWithClosedOutItemAndSeeTheErrorMessage(String products,
			String expectedErrorMessage) {

		pom.getReturnsPage().searchItem(products);
		pom.getReturnsPage().validateClosedOutItemReturnReasons(expectedErrorMessage);
	}

	@Then("User selects Don't want back all  without adding any Items and verifies the warning message {string}")
	public void userSelectsDonTWantBackAllWithoutAddingAnyItemsAndVerifiesTheWarningMessage(
			String expectedMessageDontwantBack) {
		pom.getReturnsPage().selectsCbxDontWantBack();
		WebElement errorMessageDontwantBack = pom.getReturnsPage().getErrorMessageDontwantBack();
		assertEquals(errorMessageDontwantBack, expectedMessageDontwantBack);
	}

	@When("User searches for {string} using the search box and clicks the Search")
	public void userSearchesForUsingTheSearchBoxAndClicksTheSearch(String search) {
		pom.getSubmittedReturnsPage().searchReturns(search);

	}

	@Then("the results should include rows containing {string} in Return Name")
	public void theResultsShouldIncludeRowsContainingInReturnName(String string) {
		WebElement tdReturnNamelink = pom.getSubmittedReturnsPage().getTdReturnNamelink();
		assertEquals(tdReturnNamelink, string);

	}

	@When("User selects {string} from the {string} dropdown and clicks the {string} button")
	public void userSelectsFromTheDropdownAndClicksTheButton(String orderType, String string2, String string3) {
		pom.getSubmittedReturnsPage().typeFilter(orderType);

	}

	@Then("User verifies submitted returns of type {string} should be displayed")
	public void userVerifiesSubmittedReturnsOfTypeShouldBeDisplayed(String string) {

	}

	@When("User selects the Submitted From Date as {string}, the Submitted To Date as {string}, and clicks the {string} button.")
	public void userSelectsTheSubmittedFromDateAsTheSubmittedToDateAsAndClicksTheButton(String formDate, String toDate,
			String string3) {
		pom.getSubmittedReturnsPage().clearDetails();
		pom.getSubmittedReturnsPage().dateFilters(formDate, toDate);

	}

	@Then("User verifies submitted returns within the date range {string} to {string} should be displayed")
	public void userVerifiesSubmittedReturnsWithinTheDateRangeToShouldBeDisplayed(String formDate, String toDate) {

		pom.getSubmittedReturnsPage().verifySubmittedReturnsDateRange(formDate, toDate);

	}



}
