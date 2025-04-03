package com.stepdefinition;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebElement;

import com.base.BaseClass;
import com.pageManager.PageObjectManager;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

/**
 * @see used to didplaying the current order webpage
 * @author nloga
 * @Date 10-Feb-2025
 * 
 */
public class TC2_CurrentOrderStep extends BaseClass {

	PageObjectManager pom = new PageObjectManager();

	/**
	 * @see Used to navigtes Current order webpage
	 * @param currentOrder
	 * @throws InterruptedException
	 */
	@Then("User navigates to Orders, selects Current Orders and verifies that the page is {string}")
	public void userNavigatesToOrdersSelectsCurrentOrdersAndVerifiesThatThePageIs(String currentOrder)
			throws InterruptedException {
		pom.getDashboardPage().navigatesCurrentOrderPage();
		WebElement titleCurrentOrders = pom.getCurrentOrderPage().getTitleCurrentOrders();
		verifyPageTitle(titleCurrentOrders, currentOrder);
	}

	/**
	 * @see used to create a new order
	 * @param orderName
	 * @param orderType
	 * @param autoSubmit
	 * @param orderReferance
	 */
	@When("User clicks on  Create New, Create New Regular Order with {string} , {string} , {string} , {string}")
	public void userClicksOnCreateNewCreateNewRegularOrderWith(String orderName, String orderType, String autoSubmit,
			String orderReferance) {
		pom.getCurrentOrderPage().createNewOrder(orderName, orderType, autoSubmit, orderReferance);
	}

	/**
	 * @see Used to add the items/products
	 * @param dataTable
	 */
	@When("User Adds the items\\/products using item number")
	public void userAddsTheItemsProductsUsingItemNumber(io.cucumber.datatable.DataTable dataTable) {
		List<Map<String, String>> itemsData = dataTable.asMaps();

		for (Map<String, String> item : itemsData) {
			String itemsNum = item.get("itemsNum");
			String specialCode = item.get("specialCode");
			String orderQty = item.get("orderQty");
			String successMessage = item.get("successMessage");
			pom.getCurrentOrderPage().addItems(itemsNum, specialCode, orderQty, successMessage);
		}
	}

	/**
	 * @see Used to add products Using NDC, UPC, GTIN
	 * @param dataTable
	 */
	@When("User Adds products Using NDC\\/UPC\\/GTIN and clicks Add To Order")
	public void userAddsProductsUsingNDCUPCGTINAndClicksAddToOrder(io.cucumber.datatable.DataTable dataTable) {
		List<Map<String, String>> productsData = dataTable.asMaps();

		for (Map<String, String> product : productsData) {
			String NDC = product.get("NDC");
			String addQuantity = product.get("addQuantity");
			String successMessage = product.get("successMessage");
			pom.getCurrentOrderPage().addProducts(NDC, addQuantity, successMessage);
		}
	}

	/**
	 * @see Used to submit regular order
	 */
	@When("User submits the regular order and clicks OK")
	public void userSubmitsTheRegularOrderAndClicksOK() {
		pom.getCurrentOrderPage().clicksSubmit();
		pom.getCurrentOrderPage().clicksOK();
	}

	/**
	 * @see Used to create new c2 order
	 * @param orderName
	 * @param orderType
	 */
	@When("User clicks Create New, Create New C2 Order with {string} , {string}")
	public void userClicksCreateNewCreateNewC2OrderWith(String orderName, String orderType) {
		pom.getCurrentOrderPage().createC2Order(orderName, orderType);
	}

	/**
	 * @see Used to submit c2 order
	 */
	@When("User clicks {string} to submit the order")
	public void userClicksToSubmitTheOrder(String string) {
		pom.getCurrentOrderPage().clicksSignSubmit();
	}

	/**
	 * @see Used to insert store password
	 * @param storePassword
	 */
	@When("User enters store password {string} and clicks Sign")
	public void userEntersStorePasswordAndClicksSign(String storePassword) {
		pom.getCurrentOrderPage().insertStorePassword(storePassword);
	}

	/**
	 * / * @see Used to order submission alert message
	 * 
	 * @param orderName
	 */
	@Then("User verifies the order submission with alert message {string}")
	public void userVerifiesTheOrderSubmissionWithAlertMessage(String string) {

		pom.getCurrentOrderPage().clicksOK();
		System.out.println(getCurrentrl());
	}

	/**
	 * @see Used to navigates Products catalog and Select DME
	 * @param string
	 */
	@Then("User navigates Products, selects Durable Medical Equipment \\(DME) and verify the page {string}")
	public void userNavigatesProductsSelectsDurableMedicalEquipmentDMEAndVerifyThePage(String string) {

		pom.getProductsCatalogPage().navigatesDME();
		WebElement titleProductCatalog = pom.getProductsCatalogPage().getTitleProductCatalog();
		verifyPageTitle(titleProductCatalog, string);
	}

	/**
	 * @see Used to create new order in full view
	 * @param orderName
	 * @param orderType
	 * @param autoSubmit
	 */
	@When("User select Full view and clicks Create New, Create New Order with {string} , {string} , {string}")
	public void userSelectFullViewAndClicksCreateNewCreateNewOrderWith(String orderName, String orderType,
			String autoSubmit) {
		pom.getProductsCatalogPage().clicksFullView();
		pom.getProductsCatalogPage().createNewOrder(orderName, orderType, autoSubmit);

	}

	/**
	 * @see Used to create new order in Compact view
	 * @param orderName
	 * @param orderType
	 * @param autoSubmit
	 */
	@When("User select Compact view and clicks Create New, Create New Order with {string} , {string} , {string}")
	public void userSelectCompactViewAndClicksCreateNewCreateNewOrderWith(String orderName, String orderType,
			String autoSubmit) {
		pom.getProductsCatalogPage().clickCompactView();
		pom.getProductsCatalogPage().compactViewOrderCreation(orderName, orderType, autoSubmit);
	}

	/**
	 * @see Used to order submission alert message
	 * @param orderName
	 */
	@Then("User User verify the order added alert success message {string}")
	public void userUserVerifyTheOrderAddedAlertSuccessMessage(String alertMessage) {

		WebElement alertSuccessMessageOrderCreation = pom.getProductsCatalogPage()
				.getAlertSuccessMessageOrderCreation();
//		assertEquals(alertSuccessMessageOrderCreation, alertMessage);

	}

	/**
	 * @see Used to product search using globalsearch
	 * @param globalSearch
	 */
	@Then("User performs global search for {string} to create a new regular order")
	public void userPerformsGlobalSearchForToCreateANewRegularOrder(String globalSearch) {

		pom.getDashboardPage().performGlobalSearch(globalSearch);
	}

	/**
	 * @see Used to create new order in product search webpage
	 * @param orderName
	 * @param autoSubmit
	 * @param string3
	 */
	@Then("User clicks on Create New Order with {string} , {string} and verifies the success message {string}")
	public void userClicksOnCreateNewOrderWithAndVerifiesTheSuccessMessage(String orderName, String autoSubmit,
			String string3) {

		pom.getProductsCatalogPage().clickCompactView();
		pom.getProductSearchPage().createNewOrder(orderName, autoSubmit);
	}

	/**
	 * @see Used to create new order in suggested products list
	 * @param orderName
	 * @param autoSubmit
	 * @param expectedAlertSuccessmessage
	 * @throws InterruptedException
	 */

	@Then("User should Create New Regular Order in Suggested Products list with {string} , {string} and verifies the success message {string}")
	public void userShouldCreateNewRegularOrderInSuggestedProductsListWithAndVerifiesTheSuccessMessage(String orderName,
			String autoSubmit, String expectedAlertSuccessmessage) throws InterruptedException {
		pom.getProductDetailPage().createNewRegularOrder(orderName, autoSubmit);
		WebElement alertSuccessMessageOrderCreation = pom.getProductDetailPage().getAlertSuccessMessageOrderCreation();
		assertEquals(alertSuccessMessageOrderCreation, expectedAlertSuccessmessage);

	}

	/**
	 * @see used to create case items order
	 * @param orderName
	 * @param autoSubmit
	 * @param expectedAlertSuccessmessage
	 */
	@Then("User clicks on Create New Order, clicks YES for Case Item order and enters {string} and {string} and verifies the success message {string}")
	public void userClicksOnCreateNewOrderClicksYESForCaseItemOrderAndEntersAndAndVerifiesTheSuccessMessage(
			String orderName, String autoSubmit, String expectedAlertSuccessmessage) {

		pom.getProductDetailPage().caseItemOrder(orderName, autoSubmit);
		WebElement alertSuccessMessageOrderCreation = pom.getProductDetailPage().getAlertSuccessMessageOrderCreation();
		assertEquals(alertSuccessMessageOrderCreation, expectedAlertSuccessmessage);
	}

	/**
	 * @see Clicks Create New Regular Order with order name and auto submit and
	 *      verifies the success message.
	 * @param orderName                 The order name.
	 * @param autoSubmit                The auto submit.
	 * @param alertOrdercreationMessage The order creation message.
	 * @throws InterruptedException
	 */
	@Then("User Clicks Create New Regular Order with {string} , {string} and verifies the success message {string}")
	public void userClicksCreateNewRegularOrderWithAndVerifiesTheSuccessMessage(String orderName, String autoSubmit,
			String alertOrdercreationMessage) throws InterruptedException {
		pom.getProductDetailPage().createNewOrder(orderName, autoSubmit);
		WebElement alertMessage_Ordercreation = pom.getProductDetailPage().getAlertMessage_Ordercreation();
		assertEquals(alertMessage_Ordercreation, alertOrdercreationMessage);
	}

	/**
	 * @see Changes the order name and verifies the alert message upon successful
	 *      update.
	 * @param orderName                The new order name to set.
	 * @param orderNameUpdateedMessage The expected text of the alert message after
	 *                                 the order name is updated.
	 */
	@When("User can change Order Name as {string} then  verifying the alert message {string}")
	public void userCanChangeOrderNameAsThenVerifyingTheAlertMessage(String orderName,
			String orderNameUpdateedMessage) {
		pom.getOrdersPage().orderNameUpdate(orderName);
		WebElement alertSuccessMessageOrderNameUpdate = pom.getOrdersPage().getAlertSuccessMessageOrderNameUpdate();
		assertEquals(alertSuccessMessageOrderNameUpdate, orderNameUpdateedMessage);

	}

	/**
	 * @see Verifies the sorting order of items and product descriptions in both
	 *      ascending and descending order.
	 */
	@When("User verifies sorting order in both ascending and descending order for items, Product Discriptions")
	public void userVerifiesSortingOrderInBothAscendingAndDescendingOrderForItemsProductDiscriptions() {
		pom.getOrdersPage().itemsNumberSorting();
		pom.getOrdersPage().productDiscriptionsSorting();
	}

	/**
	 * @see Updates item quantities and special codes in the grid and verifies the
	 *      alert message.
	 * @param string The expected text of the alert message after updating the
	 *               quantities and special codes.
	 */
	@When("User updates item quantities and special codes in the grid verifies the {string} alert message")
	public void userUpdatesItemQuantitiesAndSpecialCodesInTheGridVerifiesTheAlertMessage(String string) {
		pom.getOrdersPage().updateQty();
		pom.getOrdersPage().updateSpecialCode();
	}

	/**
	 * @see Deletes an order from the grid and verifies the displayed alert message.
	 * @param deleteSuccessMessage The expected text of the success alert message
	 *                             after deleting the order.
	 * @throws InterruptedException If any thread interruption occurs during the
	 *                              deletion process.
	 */
	@Then("User deletes an order from the Grid verifies the {string} alert message")
	public void userDeletesAnOrderFromTheGridVerifiesTheAlertMessage(String deleteSuccessMessage)
			throws InterruptedException {
		pom.getOrdersPage().deleteItemsInGrid();
		WebElement alertSuccessMessage = pom.getOrdersPage().getAlertSuccessMessage();
		assertEquals(alertSuccessMessage, deleteSuccessMessage);
	}

	/**
	 * @see Verifies the pagination functionality on the Orders web page.
	 * @throws InterruptedException If any thread interruption occurs during the
	 *                              process.
	 */
	@Then("User verifies pagination functionality on the Orders Web Page")
	public void userVerifiesPaginationFunctionalityOnTheOrdersWebPage() throws InterruptedException {
		pom.getOrdersPage().pageNavigations();
	}

	/**
	 * @see Clicks the "Save As Template" button and verifies the alert message.
	 * @param alertMessageTemplateSaved The expected text of the alert message.
	 */
	@Then("User clicks on Save As Template and see the alert message as {string}")
	public void userClicksOnSaveAsTemplateAndSeeTheAlertMessageAs(String alertMessageTemplateSaved) {
		pom.getCurrentOrderPage().clickSaveAsTemplateButton();
		WebElement alertMessageTemplateSaved2 = pom.getCurrentOrderPage().getAlertMessageTemplateSaved();
		assertEquals(alertMessageTemplateSaved2, alertMessageTemplateSaved);
	}

	/**
	 * @see Navigates back to the Current Order page, clicks on "Create New," and
	 *      selects "Use Template."
	 * @throws InterruptedException If any thread interruption occurs during
	 *                              navigation.
	 */
	@When("User navigates back to Current Order page Clicks on Create New and Use Template")
	public void userNavigatesBackToCurrentOrderPageClicksOnCreateNewAndUseTemplate() throws InterruptedException {

		pom.getDashboardPage().navigatesCurrentOrderPage();
	}

	/**
	 * @see Clicks on Create with order name and Choose Template.
	 */
	@Then("User should clicks on Create with order name and Choose Template")
	public void userShouldClicksOnCreateWithOrderNameAndChooseTemplate() {
		refreshNavigation();
		pom.getCurrentOrderPage().selectTemplete();

	}

	/**
	 * @see Clicks on "Create New" order without entering any details and then
	 *      clicks the "Create" button.
	 */
	@When("User clicks on Create New without entering any details and clicks Create")
	public void userClicksOnCreateNewWithoutEnteringAnyDetailsAndClicksCreate() {
		pom.getCurrentOrderPage().emptyFieldsOrderCreation();

	}

	/**
	 * @see Validates the error messages for empty order name and order type fields.
	 * @param emptyFieldOrderNameErrorMessage The expected error message for the
	 *                                        empty order name field.
	 * @param emptyFieldOrderType             The expected error message for the
	 *                                        empty order type field.
	 */
	@Then("User should verifies the error messages: {string} and {string}")
	public void userShouldVerifiesTheErrorMessagesAnd(String emptyFieldOrderNameErrorMessage,
			String emptyFieldOrderType) {
		try {
			WebElement errorMessageOrderName = pom.getCurrentOrderPage().getErrorMessageOrderName();
			assertEquals(errorMessageOrderName, emptyFieldOrderNameErrorMessage);
			WebElement errorMessageOrderType = pom.getCurrentOrderPage().getErrorMessageOrderType();
			assertEquals(errorMessageOrderType, emptyFieldOrderType);
		} catch (Exception e) {

		}
	}

	/**
	 * @see Enters an order name with special characters for a specified order type,
	 *      attempts to create an order, and verifies the expected error message.
	 * @param orderType                The type of order to create.
	 * @param orderNameWithSpecialChar The expected error message when an order name
	 *                                 contains special characters.
	 */
	@Then("User enter order name with special characters with {string} order type and tries to create an Order and should see the error message {string}")
	public void userEnterOrderNameWithSpecialCharactersWithOrderTypeAndTriesToCreateAnOrderAndShouldSeeTheErrorMessage(
			String orderType, String orderNameWithSpecialChar) {
		pom.getCurrentOrderPage().insertOrderNameWithSpecialChar(orderType);
		WebElement errorMessageOrdernameSpeclChar = pom.getCurrentOrderPage().getErrorMessageOrdernameSpeclChar();
		assertEquals(errorMessageOrdernameSpeclChar, orderNameWithSpecialChar);

	}

	/**
	 * @see Provides a space in the order name with a specified order type, attempts
	 *      to create an order, and verifies the expected error message.
	 * @param orderType          The type of order to create.
	 * @param orderNameWithSpace The expected error message when an order name
	 *                           contains a space.
	 */
	@Then("User provides Space in Order Name with {string} order type and tries to create an Order then see the error message {string}")
	public void userProvidesSpaceInOrderNameWithOrderTypeAndTriesToCreateAnOrderThenSeeTheErrorMessage(String orderType,
			String orderNameWithSpace) {
		pom.getCurrentOrderPage().currentOrderNameWithSpace(orderType);
		WebElement errorMessageOrderName = pom.getCurrentOrderPage().getErrorMessageOrderName();
		assertEquals(errorMessageOrderName, orderNameWithSpace);
	}

	/**
	 * @see Clicks on "Use a Template", attempts to create an order without entering
	 *      any details, and verifies the behavior.
	 */
	@Then("User should clicks on Use a Template and entering without anut details and clicks Create")
	public void userShouldClicksOnUseATemplateAndEnteringWithoutAnutDetailsAndClicksCreate() {
		pom.getCurrentOrderPage().emptyFieldsUseATemplate();
	}

	/**
	 * @see Validates the error messages for empty order name and template fields.
	 * @param emptyFieldOrderName The expected error message for the empty order
	 *                            name field.
	 * @param emptyFieldTemplate  The expected error message for the empty template
	 *                            field.
	 */
	@Then("User should validate the error message {string} , {string}")
	public void userShouldValidateTheErrorMessage(String emptyFieldOrderName, String emptyFieldTemplate) {
		WebElement errorMessageOrderName = pom.getCurrentOrderPage().getErrorMessageOrderName();
		assertEquals(errorMessageOrderName, emptyFieldOrderName);
		WebElement errorMessageTemplate = pom.getCurrentOrderPage().getErrorMessageTemplate();
		assertEquals(errorMessageTemplate, emptyFieldTemplate);
	}

	/**
	 * @see Searches for an order by name and verifies that the grid displays the
	 *      correct order name.
	 * @param orderName The name of the order to search for.
	 * @param string2   The expected order name to be displayed in the grid.
	 * @throws InterruptedException If any thread interruption occurs during the
	 *                              process.
	 */
	@When("User searches for a Order Name {string} and verifies that the grid displays the Order name is {string}")
	public void userSearchesForAOrderNameAndVerifiesThatTheGridDisplaysTheOrderNameIs(String orderName, String string2)
			throws InterruptedException {

		pom.getCurrentOrderPage().searchOrders(orderName);
	}

	/**
	 * @see Verifies the sorting functionality for orders in both ascending and
	 *      descending order for all columns: Order Name, Status, Created Date,
	 *      Order Type, Total Lines, Total Pieces, and Ext. Inv. Price.
	 */
	@When("User verifies sorting order in both ascending and descending order for all columns OrderName, Status, Created Date, Order Type, Total lines, Total pieces and Ext.Inv.Price")
	public void userVerifiesSortingOrderInBothAscendingAndDescendingOrderForAllColumnsOrderNameStatusCreatedDateOrderTypeTotalLinesTotalPiecesAndExtInvPrice() {
		pom.getCurrentOrderPage().sortingOrders();

	}

	/**
	 * @see Verifies the pagination functionality on the Orders page.
	 * @throws InterruptedException If any thread interruption occurs during the
	 *                              process.
	 */
	@When("User verifies pagination functionality on the Orders")
	public void userVerifiesPaginationFunctionalityOnTheOrders() throws InterruptedException {
		pom.getCurrentOrderPage().pageNavigations();

	}

	/**
	 * @see Deletes the order name and verifies the appearance of the success alert
	 *      message.
	 * @param deleteOrderMessage The expected text of the success alert message
	 *                           after deleting the order.
	 */
	@Then("User deletes the Order name and verifies the success alert message {string}")
	public void userDeletesTheOrderNameAndVerifiesTheSuccessAlertMessage(String deleteOrderMessage) {
		pom.getCurrentOrderPage().deleteOrder();
		WebElement alertMessageDeleteOrder = pom.getCurrentOrderPage().getAlertMessageDeleteOrder();
		assertEquals(alertMessageDeleteOrder, deleteOrderMessage);
	}

	/**
	 * @see Clicks the "View Order Templates" button and verifies that the page
	 *      title matches the expected title.
	 * @param pageTitle The expected title of the Order Templates page.
	 */
	@Then("User should clicks View Order Templates and verifies that the page is {string}")
	public void userShouldClicksViewOrderTemplatesAndVerifiesThatThePageIs(String pageTitle) {
		pom.getCurrentOrderPage().clicksViewOrderTemplates();
		WebElement titleOrderTemplates = pom.getTemplatesPage().getTitleOrderTemplates();
		assertEquals(titleOrderTemplates, pageTitle);

	}

	/**
	 * @see Searches for a template by name and verifies that the grid displays the
	 *      correct template name.
	 * @param templateName The name of the template to search for.
	 * @param orderName    The expected template name to be displayed in the grid.
	 */
	@Then("User search for Template name {string} verifies that the grid displays the Template name is {string}")
	public void userSearchForTemplateNameVerifiesThatTheGridDisplaysTheTemplateNameIs(String templateName,
			String orderName) {

		pom.getTemplatesPage().searchTemplate(templateName);
		WebElement tdFirstcell = pom.getCurrentOrderPage().getTdFirstcell();
		String text = getText(tdFirstcell);
		System.out.println(text);
		assertEquals(tdFirstcell, orderName);

	}

	/**
	 * @see Verifies that templates can be sorted in both ascending and descending
	 *      order for the following columns: Templates, Created Date, Order Type,
	 *      and Total Lines.
	 */

	@Then("User verifies sorting Templates in both ascending and descending order for all columns Templates, Created date, Order Type and Total lines")
	public void userVerifiesSortingTemplatesInBothAscendingAndDescendingOrderForAllColumnsTemplatesCreatedDateOrderTypeAndTotalLines() {
		pom.getTemplatesPage().sortingTemplates();
	}

	/**
	 * @see Deletes the template name and verifies the appearance of the success
	 *      alert message.
	 * @param string The expected text of the success alert message.
	 */
	@Then("User deletes the template name and verifies the success alert message {string}")
	public void userDeletesTheTemplateNameAndVerifiesTheSuccessAlertMessage(String string) {
		pom.getTemplatesPage().deleteTemplates();

	}

	/**
	 * @see Verifies the pagination functionality on the Order Templates web page.
	 * @throws InterruptedException If any thread interruption occurs during the
	 *                              process.
	 */
	@Then("User verifies pagination functionality on the Order Templates Web Page")
	public void userVerifiesPaginationFunctionalityOnTheOrderTemplatesWebPage() throws InterruptedException {

		pom.getTemplatesPage().pageNavigations();
	}

	/**
	 * @see Verifies that attempting to add an item without an item number displays
	 *      the expected warning message.
	 * @param warningMessageItemCodeRequired The expected warning message text.
	 */
	@Then("User attempts to add an item without an item number and verifies the warning message {string}")
	public void userAttemptsToAddAnItemWithoutAnItemNumberAndVerifiesTheWarningMessage(
			String warningMessageItemCodeRequired) {

		pom.getOrdersPage().clicksAdd();
		WebElement warningMessageItemCode = pom.getOrdersPage().getWarningMessageItemCode();
		assertEquals(warningMessageItemCode, warningMessageItemCodeRequired);
	}

	/**
	 * @see Adds an item with a specified quantity and verifies the displayed
	 *      warning message.
	 * @param itemNum                   The item number to add.
	 * @param orderQty                  The quantity of the item to add.
	 * @param WarningMessageMinQunatity The expected warning message text.
	 * @throws InterruptedException If any thread interruption occurs during the
	 *                              process.
	 */
	@Then("User adds an item {string} with a quantity of {string} and verifies the warning message {string}")
	public void userAddsAnItemWithAQuantityOfAndVerifiesTheWarningMessage(String itemNum, String orderQty,
			String WarningMessageMinQunatity) throws InterruptedException {
		pom.getOrdersPage().addZeroQuantity(itemNum, orderQty);
		WebElement warningMessageMinQty = pom.getOrdersPage().getWarningMessageMinQty();
		assertEquals(warningMessageMinQty, WarningMessageMinQunatity);
	}

	/**
	 * @see Verifies that attempting to add a C2 item to a regular order displays
	 *      the expected alert message.
	 * @param itemNum The item number of the C2 item being added.
	 * @param c2Items The expected alert message text.
	 * @throws InterruptedException If any thread interruption occurs during the
	 *                              process.
	 */
	@Then("User attempts to add C2 items {string} in Regular order and verifies the alert message {string}")
	public void userAttemptsToAddC2ItemsInRegularOrderAndVerifiesTheAlertMessage(String itemNum, String c2Items)
			throws InterruptedException {

		pom.getOrdersPage().RestrictionOrder(itemNum);
		WebElement alertMessageC2Item = pom.getOrdersPage().getAlertMessageC2Item();
		assertEquals(alertMessageC2Item, c2Items);
	}

	/**
	 * @see Verifies that attempting to add the same item again triggers the
	 *      expected warning message.
	 * @param itemNum          The item number of the item being added again.
	 * @param ItemAlreadyAdded The expected warning message text.
	 * @throws InterruptedException If any thread interruption occurs during the
	 *                              process.
	 */
	@Then("User attempts to add the same item {string} again and verifies the warning message {string}")
	public void userAttemptsToAddTheSameItemAgainAndVerifiesTheWarningMessage(String itemNum, String ItemAlreadyAdded)
			throws InterruptedException {

		pom.getOrdersPage().RestrictionOrder(itemNum);
		WebElement warningMessageItemAlreadyAdded = pom.getOrdersPage().getWarningMessageItemAlreadyAdded();
		assertEquals(warningMessageItemAlreadyAdded, ItemAlreadyAdded);
	}

	/**
	 * @see Verifies that the user can update the order quantity and that the
	 *      expected warning message is displayed.
	 * @param orderQty                  The order quantity to set.
	 * @param WarningMessageMinQunatity The expected warning message text.
	 */
	@Then("User should updates the order quantity to {string} and verifies the warning message {string}")
	public void userShouldUpdatesTheOrderQuantityToAndVerifiesTheWarningMessage(String orderQty,
			String WarningMessageMinQunatity) {
		pom.getOrdersPage().verifyUpdateWithZeroQuantityInGrid(orderQty);
		WebElement warningMessageMinQty = pom.getOrdersPage().getWarningMessageMinQty();
		assertEquals(warningMessageMinQty, WarningMessageMinQunatity);
	}

	/**
	 * @see Verifies that attempting to add a non-C2 item to a C2 order results in
	 *      the expected alert message.
	 * @param itemNum   The item number of the C2 item already in the order.
	 * @param nonC2Item The expected alert message text when attempting to add a
	 *                  non-C2 item.
	 * @throws InterruptedException If any thread interruption occurs during the
	 *                              process.
	 */
	@Then("User attempts to add Regular items {string} in c2 order and verifies the alert message {string}")
	public void userAttemptsToAddRegularItemsInC2OrderAndVerifiesTheAlertMessage(String itemNum, String nonC2Item)
			throws InterruptedException {

		pom.getOrdersPage().RestrictionOrder(itemNum);
		WebElement alertMessageNonC2Items = pom.getOrdersPage().getAlertMessageNonC2Items();
		assertEquals(alertMessageNonC2Items, nonC2Item);
	}

}
