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

	@Then("User navigates to the {string} page and verifies the page is displayed")
	public void userNavigatesToThePageAndVerifiesThePageIsDisplayed(String expectedTitle) {
		pom.getDashboardPage().navigatesReturns();
		WebElement titleReturns = pom.getReturnsPage().getTitleReturns();
		verifyPageTitle(titleReturns, expectedTitle);
	}

	@Then("User clicks on Create New to create a new return order")
	public void userClicksOnCreateNewToCreateANewReturnOrder(io.cucumber.datatable.DataTable dataTable)
			throws InterruptedException {
		List<Map<String, String>> returnOrders = dataTable.asMaps();

		for (Map<String, String> returnOrder : returnOrders) {
			String returnName = returnOrder.get("returnName");
			String returnType = returnOrder.get("returnType");
			pom.getReturnsPage().createReturnOrder(returnName, returnType);
		}
	}

	@Then("User adds return items by searching products:")
	public void userAddsReturnItemsBySearchingProducts(io.cucumber.datatable.DataTable dataTable)
			throws InterruptedException {

		List<Map<String, String>> returnItems = dataTable.asMaps();
		for (Map<String, String> Item : returnItems) {
			String searchProducts = Item.get("searchProducts");
			String expirationDate = Item.get("expirationDate");
			String lotNumber = Item.get("lotNumber");
			String qty = Item.get("qty");
			String returnReason = Item.get("returnReason");
			String successMessage = Item.get("successMessage");
			pom.getReturnsPage().addReturnProducts(searchProducts, expirationDate, lotNumber, qty, returnReason,
					successMessage);
		}
	}

	@Then("User deletes a return order from the returns list and verifies the {string} alert message")
	public void userDeletesAReturnOrderFromTheReturnsListAndVerifiesTheAlertMessage(String alertDeleteReturnsMessage) {
		pom.getReturnsPage().deleteReturDetails();
		WebElement returnsDelete = pom.getReturnsPage().getAlMeassageDelete();
		assertEquals(returnsDelete, alertDeleteReturnsMessage);

	}

	@Then("User adds C2 return  items by searching products:")
	public void userAddsC2ReturnItemsBySearchingProducts(io.cucumber.datatable.DataTable dataTable) {
		List<Map<String, String>> c2RuturnItems = dataTable.asMaps();

		for (Map<String, String> Item : c2RuturnItems) {
			String searchProducts = Item.get("searchProducts");
			String expirationDate = Item.get("expirationDate");
			String lotNumber = Item.get("lotNumber");
			String qty = Item.get("qty");
			String returnReason = Item.get("returnReason");
			String successMessage = Item.get("successMessage");
			pom.getReturnsPage().c2ReturnItems(searchProducts, expirationDate, lotNumber, qty, returnReason,
					successMessage);

		}
	}

	@Then("User adds Regular return items using refined search criteria, sorting by sort By in sort Order order:")
	public void userAddsRegularReturnItemsUsingRefinedSearchCriteriaSortingBySortByInSortOrderOrder(
			io.cucumber.datatable.DataTable dataTable) throws InterruptedException {
		List<Map<String, String>> searchRegularItems = dataTable.asMaps();
		for (Map<String, String> Item : searchRegularItems) {
			String addSearchProducts = Item.get("addSearchProducts");
			String refineSearch = Item.get("refineSearch");
			String category = Item.get("category");
			String sortBy = Item.get("sortBy");
			String sortOrder = Item.get("sortOrder");
			String lotNumber = Item.get("lotNumber");
			String qty = Item.get("qty");
			String returnReason = Item.get("returnReasons");
			String successMessage = Item.get("successMessage");
			pom.getReturnsPage().refineSearchRegularItems(addSearchProducts, refineSearch, category, sortBy, sortOrder,
					lotNumber, qty, returnReason, successMessage);
		}
	}

	@Then("User adds C2 return items using refined search criteria, sorting by sort By in sort Order order:")
	public void userAddsC2ReturnItemsUsingRefinedSearchCriteriaSortingBySortByInSortOrderOrder(
			io.cucumber.datatable.DataTable dataTable) {
		List<Map<String, String>> searchC2Items = dataTable.asMaps();
		for (Map<String, String> Item : searchC2Items) {
			String addSearchProducts = Item.get("addSearchProducts");
			String refineSearch = Item.get("refineSearch");
			String category = Item.get("category");
			String sortBy = Item.get("sortBy");
			String sortOrder = Item.get("sortOrder");
			String lotNumber = Item.get("lotNumber");
			String qty = Item.get("qty");
			String returnReason = Item.get("returnReason");
			String successMessage = Item.get("successMessage");
			pom.getReturnsPage().refineSearchC2Items(addSearchProducts, refineSearch, category, sortBy, sortOrder,
					lotNumber, qty, returnReason, successMessage);
		}
	}

	@Then("User adds Refrigerated  return  items by searching products:")
	public void userAddsRefrigeratedReturnItemsBySearchingProducts(io.cucumber.datatable.DataTable dataTable)
			throws InterruptedException {
		List<Map<String, String>> refrigeratedItems = dataTable.asMaps();
		for (Map<String, String> refrigeratedItem : refrigeratedItems) {
			String searchRefrigeratedProducts = refrigeratedItem.get("searchRefrigeratedProducts");
			String expirationDate = refrigeratedItem.get("expirationDate");
			String lotNumber = refrigeratedItem.get("lotNumber");
			String qty = refrigeratedItem.get("qty");
			String returnReason = refrigeratedItem.get("returnReason");
			String successMessage = refrigeratedItem.get("successMessage");
			pom.getReturnsPage().refrigeratedReturns(searchRefrigeratedProducts, expirationDate, lotNumber, qty,
					returnReason, successMessage);

		}
	}

	@Then("User adds return items using refined search criteria, sorting by sort By in sort Order order:")
	public void userAddsReturnItemsUsingRefinedSearchCriteriaSortingBySortByInSortOrderOrder(
			io.cucumber.datatable.DataTable dataTable) throws InterruptedException {
		List<Map<String, String>> searchItems = dataTable.asMaps();
		for (Map<String, String> Item : searchItems) {
			String addSearchProducts = Item.get("addSearchProducts");
			String refineSearch = Item.get("refineSearch");
			String category = Item.get("category");
			String sortBy = Item.get("sortBy");
			String sortOrder = Item.get("sortOrder");
			String lotNumber = Item.get("lotNumber");
			String qty = Item.get("qty");
			String returnReason = Item.get("returnReason");
			String successMessage = Item.get("successMessage");
			pom.getReturnsPage().refineSearchRefrigeratedItems(addSearchProducts, refineSearch, category, sortBy,
					sortOrder, lotNumber, qty, returnReason, successMessage);

		}

	}

	@Then("User updates the Regular Returns product list:")
	public void userUpdatesTheRegularReturnsProductList(io.cucumber.datatable.DataTable dataTable)
			throws InterruptedException {

		List<Map<String, String>> updateRegularItems = dataTable.asMaps();
		for (Map<String, String> Item : updateRegularItems) {
			String expirationDateGrid = Item.get("expirationDateGrid");
			String lotNumberGrid = Item.get("lotNumberGrid");
			String qtyGrid = Item.get("qtyGrid");
			String returnReasonGrid = Item.get("returnReasonGrid");
			String updateAlertMessage = Item.get("updateAlertMessage");
			pom.getReturnsPage().updateRegularReturns(expirationDateGrid, lotNumberGrid, qtyGrid, returnReasonGrid,
					updateAlertMessage);
		}
	}

	@Then("User updates the return products list:")
	public void userUpdatesTheReturnProductsList(io.cucumber.datatable.DataTable dataTable) {

		List<Map<String, String>> updateRefrigeratedItems = dataTable.asMaps();
		for (Map<String, String> Item : updateRefrigeratedItems) {
			String expirationDateGrid = Item.get("expirationDateGrid");
			String lotNumberGrid = Item.get("lotNumberGrid");
			String qtyGrid = Item.get("qtyGrid");
			String returnReasonGrid = Item.get("returnReasonGrid");
			String updateAlertMessage = Item.get("updateAlertMessage");
			pom.getReturnsPage().updateRefrigeratedItems(expirationDateGrid, lotNumberGrid, qtyGrid, returnReasonGrid,
					updateAlertMessage);

		}
	}

	@Then("User can change Return name as {string} then  verifying the alert message  {string}")
	public void userCanChangeReturnNameAsThenVerifyingTheAlertMessage(String returnName, String updatedMessage) {
		pom.getReturnsPage().updateReturnName(returnName);
		WebElement alMessageReturnNameUpdate = pom.getReturnsPage().getAlMessageReturnNameUpdate();
		assertEquals(alMessageReturnNameUpdate, updatedMessage);
	}

	@Then("User should sort by Items and Product Description and delete an item from the return list, verifying the alert message  {string}")
	public void userShouldSortByItemsAndProductDescriptionAndDeleteAnItemFromTheReturnListVerifyingTheAlertMessage(
			String alertDeleteMessage) {
		pom.getReturnsPage().itemsNumberSorting();
		pom.getReturnsPage().productDiscriptionsSorting();
		pom.getReturnsPage().deleteIteminGrid();
		WebElement alDeleteMessage = pom.getReturnsPage().getAlDeleteMessage();
		assertEquals(alDeleteMessage, alertDeleteMessage);
	}

	@Then("User should navigate through pages using pagination controls on the Returns items page")
	public void userShouldNavigateThroughPagesUsingPaginationControlsOnTheReturnsItemsPage()
			throws InterruptedException {
		pom.getReturnsPage().pageNavigations();
	}

	@Then("User clicks on Sign & Submit and submits with {string}, {string}, and {string} and verifying alert success message as {string}")
	public void userClicksOnSignSubmitAndSubmitsWithAndAndVerifyingAlertSuccessMessageAs(String authorisedSignature,
			String title, String signatureFont, String string4) throws InterruptedException {
		pom.getReturnsPage().clicksSignSubmit();
		pom.getReturnsPage().insertSignSubmitDetail(authorisedSignature, title, signatureFont);

//		WebElement btnPrintReturn = pom.getReturnsPage().getBtnPrintReturn();
//		click(btnPrintReturn);
//		Thread.sleep(15000);
	}

	@Then("User removes the Returns name and navigates back to the Returns page")
	public void userRemovesTheReturnsNameAndNavigatesBackToTheReturnsPage() throws InterruptedException {
		Thread.sleep(2000);
		pom.getReturnsPage().removeReturnName();
	}

	@Then("User searches for a return name {string} and verifies that the grid displays the return name is {string}")
	public void userSearchesForAReturnNameAndVerifiesThatTheGridDisplaysTheReturnNameIs(String returnName,
			String ReturnName) throws InterruptedException {
		Thread.sleep(4000);
		pom.getReturnsPage().navigatesReturns();
		pom.getReturnsPage().searchReturnsName(returnName);
		pom.getReturnsPage().SubmittedDateSorting();
		WebElement tdFirstcell = pom.getReturnsPage().getTdFirstcell();
		String text = getText(tdFirstcell);
		System.out.println(text);
		assertEquals(tdFirstcell, ReturnName);
		WebElement firstReturnName = pom.getReturnsPage().getFirstReturnName();
		clickElementUsingJavaScript(driver, firstReturnName);
		Thread.sleep(4000);
	}

	@Then("User clicks on Create New without entering a Return Name, Return Type and clicks the Create")
	public void userClicksOnCreateNewWithoutEnteringAReturnNameReturnTypeAndClicksTheCreate()
			throws InterruptedException {
		pom.getReturnsPage().returnsWithoutName();
	}

	@Then("User should see error messages {string} and {string}")
	public void userShouldSeeErrorMessagesAnd(String errorMessageReturnName, String errorMessageReturnType) {

		WebElement errorMessageReturnsName2 = pom.getReturnsPage().getErrorMessageReturnName();
		assertEquals(errorMessageReturnsName2, errorMessageReturnName);
		WebElement errorMessageReturnsType2 = pom.getReturnsPage().getErrorMessageReturnType();
		assertEquals(errorMessageReturnsType2, errorMessageReturnType);
	}

	@Then("User should insert Return Name with Special Characters {string} and Choose Return Type {string} and verifies the error message as {string}")
	public void userShouldInsertReturnNameWithSpecialCharactersAndChooseReturnTypeAndVerifiesTheErrorMessageAs(
			String special, String returnType, String errorMessageReturnNameSpecial) {
		pom.getReturnsPage().returnNameWithSpecialChar(special, returnType);
		WebElement errorMessageSpecialChars = pom.getReturnsPage().getErrorMessageSpecialChars();
		assertEquals(errorMessageSpecialChars, errorMessageReturnNameSpecial);
	}

	@Then("User provides double space in the Return Name with {string} Return type and tries to create a Return then see the error message {string}")
	public void userProvidesDoubleSpaceInTheReturnNameWithReturnTypeAndTriesToCreateAReturnThenSeeTheErrorMessage(
			String returnType, String errorMessageReturnName) {

		pom.getReturnsPage().returnNameWithSpace(returnType);
		WebElement errorMessageReturnsName2 = pom.getReturnsPage().getErrorMessageReturnName();
		assertEquals(errorMessageReturnsName2, errorMessageReturnName);
	}

	@Then("User provides Single space in Return Name with {string} Return type and tries to create a Return then see the error message {string}")
	public void userProvidesSingleSpaceInReturnNameWithReturnTypeAndTriesToCreateAReturnThenSeeTheErrorMessage(
			String returnType, String errorMessageReturnName) {
		pom.getReturnsPage().returnNameWithDoubleSpace(returnType);
		WebElement errorMessageReturnsName2 = pom.getReturnsPage().getErrorMessageReturnName();
		assertEquals(errorMessageReturnsName2, errorMessageReturnName);

	}

	@Then("User enters  more than {int}  characters as the Return Name is \" abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnop \"with {string} Return type and tries to create a Return and User should see the Return Name in the breadcrumb as {string}")
	public void userEntersMoreThanCharactersAsTheReturnNameIsAbcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopWithReturnTypeAndTriesToCreateAReturnAndUserShouldSeeTheReturnNameInTheBreadcrumbAs(
			Integer int1, String returnType, String expectedReturnOrderName) throws InterruptedException {
		pom.getReturnsPage().returnNameWithMaxChar(returnType);
		WebElement breadCrumbLinlReturnName = pom.getReturnsPage().getBreadCrumbLinlReturnName();
		String breadcrumbText = getText(breadCrumbLinlReturnName);
		System.out.println(breadcrumbText);
		String actualText = breadcrumbText.replace("Returns > ", "");
		Assert.assertEquals("Breadcrumb text does not match the expected value", expectedReturnOrderName, actualText);
	}

	@Then("User clicks on Sign & Submit without adding any Items and verifies the warning message {string}")
	public void userClicksOnSignSubmitWithoutAddingAnyItemsAndVerifiesTheWarningMessage(String errormessageSubmit) {

		pom.getReturnsPage().clicksSignSubmit();
		WebElement errorMessageSignSubmit = pom.getReturnsPage().getErrorMessageSignSubmit();
		assertEquals(errorMessageSignSubmit, errormessageSubmit);
		WebElement getiClose = pom.getReturnsPage().getiClose();
		clickElementUsingJavaScript(driver, getiClose);
	}

	@Then("User attempts to add C2, refrigerated, discontinued, and inactive items in Regular returns then see the warning message {string} for each item:")
	public void userAttemptsToAddC2RefrigeratedDiscontinuedAndInactiveItemsInRegularReturnsThenSeeTheWarningMessageForEachItem(
			String string, io.cucumber.datatable.DataTable dataTable) {
		List<Map<String, String>> regularDiscountinuedItems = dataTable.asMaps();
		for (Map<String, String> Item : regularDiscountinuedItems) {
			String items = Item.get("items");
			String warningMessage = Item.get("warningMessage");
			pom.getReturnsPage().regularReturnsDiscountinedItems(items, warningMessage);
		}
	}

	@Then("User attempts to add Regular, refrigerated, discontinued, and inactive items in Regular returns then see the warning message {string} for each item:")
	public void userAttemptsToAddRegularRefrigeratedDiscontinuedAndInactiveItemsInRegularReturnsThenSeeTheWarningMessageForEachItem(
			String string, io.cucumber.datatable.DataTable dataTable) {

		List<Map<String, String>> c2DiscountinuedItems = dataTable.asMaps();
		for (Map<String, String> Item : c2DiscountinuedItems) {
			String items = Item.get("items");
			String warningMessage = Item.get("warningMessage");
			pom.getReturnsPage().c2ReturnsDiscont(items, warningMessage);
		}
	}

	@Then("User adds a return by item number {string} , does not select a return reason, clicks on Add to Return and verifies the warning message {string}")
	public void userAddsAReturnByItemNumberDoesNotSelectAReturnReasonClicksOnAddToReturnAndVerifiesTheWarningMessage(
			String itemNumber, String expectedErrorMessageReturnReason) throws InterruptedException {

		pom.getReturnsPage().returnReasonValidate(itemNumber);
		WebElement errorMessageReturnReason = pom.getReturnsPage().getErrorMessageReturnReason();
		assertEquals(errorMessageReturnReason, expectedErrorMessageReturnReason);
		WebElement getiClose = pom.getReturnsPage().getiClose();
		clickElementUsingJavaScript(driver, getiClose);
	}

	@Then("User adds a C2 return by item number {string} with various missing fields \\(Expiration date, Lot Number, Qty, Return Reason) and verifies the corresponding warning messages: {string} , {string} , {string} and {string}")
	public void userAddsAC2ReturnByItemNumberWithVariousMissingFieldsExpirationDateLotNumberQtyReturnReasonAndVerifiesTheCorrespondingWarningMessagesAnd(
			String searchProducts, String dateErrorMessage, String errorMessageLotNumber, String errorMessageQty,
			String ErrorMessageReturnReason) throws InterruptedException {

		pom.getReturnsPage().c2FieldErrorValidation(searchProducts, dateErrorMessage, errorMessageLotNumber,
				errorMessageQty, ErrorMessageReturnReason);

	}

	@Then("User insert invalid date with {string} and clicks Add To Order then verifies the warning messages {string}")
	public void userInsertInvalidDateWithAndClicksAddToOrderThenVerifiesTheWarningMessages(String invalidDate,
			String errorMessage) throws InterruptedException {
		pom.getReturnsPage().insertInvalidDate(invalidDate);
//		WebElement errormessageInvalidDate = pom.getReturnsPage().getErrormessageInvalidDate();
//		assertEquals(errormessageInvalidDate, errorMessage);
//		WebElement getiClose = pom.getReturnsPage().getiClose();
//		clickElementUsingJavaScript(driver, getiClose);
	}

	@Then("User adds return items by searching products insert nill qty verifies warning message")
	public void userAddsReturnItemsBySearchingProductsInsertNillQtyVerifiesWarningMessage(
			io.cucumber.datatable.DataTable dataTable) throws InterruptedException {
		List<Map<String, String>> returnItems = dataTable.asMaps();
		for (Map<String, String> Item : returnItems) {
			String searchProducts = Item.get("searchProducts");
			String expirationDate = Item.get("expirationDate");
			String lotNumber = Item.get("lotNumber");
			String qty = Item.get("qty");
			String returnReason = Item.get("returnReason");
			String warningmessage = Item.get("warningmessage");
			pom.getReturnsPage().validateReturnQty(searchProducts, expirationDate, lotNumber, qty, returnReason,
					warningmessage);
			WebElement getiClose = pom.getReturnsPage().getiClose();
			clickElementUsingJavaScript(driver, getiClose);
		}
	}

	@Then("User enters a return quantity of {string} in the grid and sees the warning message {string}")
	public void userEntersAReturnQuantityOfInTheGridAndSeesTheWarningMessage(String updateQty,
			String expectedWarningMessage) {
		pom.getReturnsPage().updateReturnQty(updateQty);
		WebElement errorMessageReturnQty = pom.getReturnsPage().getErrorMessageReturnQty();
		assertEquals(errorMessageReturnQty, expectedWarningMessage);
		WebElement getiClose = pom.getReturnsPage().getiClose();
		clickElementUsingJavaScript(driver, getiClose);
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
//field validations
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

	@Then("User selects Don't want back all  without adding any Items and verifies the warning message {string}")
	public void userSelectsDonTWantBackAllWithoutAddingAnyItemsAndVerifiesTheWarningMessage(
			String expectedMessageDontwantBack) {
		pom.getReturnsPage().selectsCbxDontWantBack();
		WebElement errorMessageDontwantBack = pom.getReturnsPage().getErrorMessageDontwantBack();
		assertEquals(errorMessageDontwantBack, expectedMessageDontwantBack);
		WebElement getiClose = pom.getReturnsPage().getiClose();
		clickElementUsingJavaScript(driver, getiClose);
	}

	@Then("User attempts to add Regular, C2, discontinued, and inactive items in refrigerated returns then see the warning message {string} for each item:")
	public void userAttemptsToAddRegularC2DiscontinuedAndInactiveItemsInRefrigeratedReturnsThenSeeTheWarningMessageForEachItem(
			String string, io.cucumber.datatable.DataTable dataTable) {
		List<Map<String, String>> refrigeratedDiscountinuedItems = dataTable.asMaps();
		for (Map<String, String> Item : refrigeratedDiscountinuedItems) {
			String items = Item.get("items");
			String warningMessage = Item.get("warningMessage");
			pom.getReturnsPage().refrigeratedDiscountinuedReturns(items, warningMessage);

		}
	}

	@Then("User adds item {string} with Reaturn Reason as {string} and Clicks Add To Order without enter RA Number then verifies the warning messages {string}")
	public void userAddsItemWithReaturnReasonAsAndClicksAddToOrderWithoutEnterRANumberThenVerifiesTheWarningMessages(
			String items, String returnReason, String expectedRAErrorMessage) {
		pom.getReturnsPage().refrigeratedReturnReason(items, returnReason);
		WebElement errorMessageRANumber = pom.getReturnsPage().getErrorMessageRANumber();
		assertEquals(errorMessageRANumber, expectedRAErrorMessage);
		WebElement getiClose = pom.getReturnsPage().getiClose();
		clickElementUsingJavaScript(driver, getiClose);
	}

	@Then("User enters a return quantity of {string} and sees the warning message {string}")
	public void userEntersAReturnQuantityOfAndSeesTheWarningMessage(String returnQty, String expectedErrorMessage)
			throws InterruptedException {
		pom.getReturnsPage().returnQty();
		WebElement errorMessageReturnQty = pom.getReturnsPage().getErrorMessageReturnQty();
		assertEquals(errorMessageReturnQty, expectedErrorMessage);
		WebElement getiClose = pom.getReturnsPage().getiClose();
		clickElementUsingJavaScript(driver, getiClose);
	}

	@Then("User insert invalid date with {string} in the Grid then verifies the warning messages {string}")
	public void userInsertInvalidDateWithInTheGridThenVerifiesTheWarningMessages(String invalidDate,
			String invalidDateErrorMessage) throws InterruptedException {
		pom.getReturnsPage().invalidExpirationDateInGrid(invalidDate);

	}

	@Then("User verifies sorting order in both ascending and descending order for all columns Return Name, Status, Submitted Date, Submitted By, Type, Total Lines, and Total Pieces")
	public void userVerifiesSortingOrderInBothAscendingAndDescendingOrderForAllColumnsReturnNameStatusSubmittedDateSubmittedByTypeTotalLinesAndTotalPieces() {
		pom.getReturnsPage().returnsSorting();
	}

	@Then("User verifies pagination functionality on the Returns page")
	public void userVerifiesPaginationFunctionalityOnTheReturnsPage() throws InterruptedException {
		pom.getReturnsPage().pageNavigations();
	}


}
