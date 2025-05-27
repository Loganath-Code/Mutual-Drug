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
	/**
	 * Page Object Manager instance used to access page objects
	 *
	 */

	PageObjectManager pom = new PageObjectManager();
	@Then("User should Read and Accept the Returns Policy Update")
	public void userShouldReadAndAcceptTheReturnsPolicyUpdate() throws InterruptedException {
		pom.getDashboardPage().returnPolicy();
	}
	/**
	 * @see Navigates to the Current Orders page and verifies the page title
	 * @param expectedTitle The expected title of the Current Orders page
	 * @throws InterruptedException if any wait or sleep is used internally
	 */
	@Then("User navigates to Orders, selects Current Orders and verifies that the page is {string}")
	public void userNavigatesToOrdersSelectsCurrentOrdersAndVerifiesThatThePageIs(String currentOrder)
			throws InterruptedException {
		pom.getDashboardPage().navigatesCurrentOrderPage();
		WebElement titleCurrentOrders = pom.getCurrentOrderPage().getTitleCurrentOrders();
		verifyPageTitle(titleCurrentOrders, currentOrder);
	}
	@When("User clicks the Create New button and selects {string} as the customer account for the new order")
	public void userClicksTheCreateNewButtonAndSelectsAsTheCustomerAccountForTheNewOrder(String selectPharmacyAccount) throws InterruptedException {
	  
		pom.getCurrentOrderPage().clickBtnCreateNew();
		pom.getCurrentOrderPage().selectYourPharmacyAccount(selectPharmacyAccount);
	}
	/**
	 * @see Used to create a new regular order
	 * @param orderName      - The name of the order
	 * @param orderType      - The type of order (e.g., Regular)
	 * @param autoSubmit     - Auto Submit option (e.g., Yes/No)
	 * @param orderReference - Custom reference for the order
	 */
	
	@When("User should Create New Regular Orders with {string}, {string} , {string} , {string} , {string}")
	public void userShouldCreateNewRegularOrdersWith(String selectedPharmacyAccount, String orderName, String orderType, String autoSubmit,
			String orderReferance) {
		WebElement textMemberSelection = pom.getCurrentOrderPage().getTextMemberSelection();
		assertEquals(textMemberSelection, selectedPharmacyAccount);
		pom.getCurrentOrderPage().createNewOrder(orderName, orderType, autoSubmit, orderReferance);
	}
	@When("User verifies that the selected Member Pharmacy Account {string} is displayed on the Orders page")
	public void userVerifiesThatTheSelectedMemberPharmacyAccountIsDisplayedOnTheOrdersPage(String selectedPharmacyAccount) {
		WebElement textMemberSelection = pom.getCurrentOrderPage().getTextMemberSelection();
		assertEquals(textMemberSelection, selectedPharmacyAccount);
	}
	@When("User should Create New Regular Orders with {string} , {string} , {string} , {string}")
	public void userShouldCreateNewRegularOrdersWith(String orderName, String orderType, String autoSubmit,
			String orderReferance) {
		pom.getCurrentOrderPage().createNewOrder(orderName, orderType, autoSubmit, orderReferance);
	  
	}
	/**
	 * @see Used to create a new regular order
	 * @param orderName      - The name of the order
	 * @param orderType      - The type of order (e.g., Regular)
	 * @param autoSubmit     - Auto Submit option (e.g., Yes/No)
	 * @param orderReference - Custom reference for the order
	 */

	@When("User clicks on  Create New, Create New Regular Orders with {string} , {string} , {string} , {string}")
	public void userClicksOnCreateNewCreateNewRegularOrdersWith(String orderName, String orderType, String autoSubmit,
			String orderReferance) {
		pom.getCurrentOrderPage().createNewOrder(orderName, orderType, autoSubmit, orderReferance);
	}

	/**
	 * @see Used to create a new C2 order
	 * @param orderName - The name of the C2 order
	 * @param orderType - The type/category of the order
	 */
	@When("User should Create New C2 Orders  with {string} , {string}")
	public void userShouldCreateNewC2OrdersWith(String orderName, String orderType) {
		pom.getCurrentOrderPage().createC2Order(orderName, orderType);

		
	}
	/**
	 * @see This step definition is used to add multiple products to the order using
	 *      either NDC, Product Description, UPC, or GTIN values along with
	 *      quantity.
	 * 
	 * @param dataTable DataTable containing product details such as NDC/Product
	 *                  Description, quantity to be added, and expected success
	 *                  message.
	 * @throws InterruptedException in case of thread interruption during wait.
	 */

	@When("User Adds the items\\/products using item number")
	public void userAddsTheItemsProductsUsingItemNumber(io.cucumber.datatable.DataTable dataTable)
			throws InterruptedException {
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
	 * @see This step definition is used to add multiple products to the order using
	 *      either NDC, Product Description along with quantity.
	 * 
	 * @param dataTable DataTable containing product details such as NDC/Product
	 *                  Description, quantity to be added, and expected success
	 *                  message.
	 * @throws InterruptedException in case of thread interruption during wait.
	 */
	@When("User Adds products Using NDC, Product Description then add Quantity to clicks Add To Order")
	public void userAddsProductsUsingNDCProductDescriptionThenAddQuantityToClicksAddToOrder(
			io.cucumber.datatable.DataTable dataTable) throws InterruptedException {

		List<Map<String, String>> productsData = dataTable.asMaps();

		for (Map<String, String> product : productsData) {
			String NDC_ProductDescription = product.get("NDC_ProductDescription");
			String addQuantity = product.get("addQuantity");
			String successMessage = product.get("successMessage");
			pom.getCurrentOrderPage().addProducts(NDC_ProductDescription, addQuantity, successMessage);
		}
	}

	/**
	 * @see used to add multiple products to the order using UPC values along with
	 *      quantity.
	 *
	 * @param dataTable DataTable containing product details such as UPC, quantity
	 *                  to be added, and expected success message.
	 * @throws InterruptedException if the thread is interrupted while waiting.
	 */

	@When("User Adds products using UPC then add Quantity to clicks Add To order:")
	public void userAddsProductsUsingUPCThenAddQuantityToClicksAddToOrder(io.cucumber.datatable.DataTable dataTable)
			throws InterruptedException {
		List<Map<String, String>> productsData = dataTable.asMaps();

		for (Map<String, String> product : productsData) {
			String UPC = product.get("UPC");
			String addQuantity = product.get("addQuantity");
			String successMessage = product.get("successMessage");
			pom.getCurrentOrderPage().addProductsUsingUPC(UPC, addQuantity, successMessage);

		}
	}

	/**
	 * @see used to add multiple products to the order using GTIN values along with
	 *      quantity.
	 *
	 * @param dataTable DataTable containing product details such as GTIN, quantity
	 *                  to be added, and expected success message.
	 * @throws InterruptedException if the thread is interrupted while waiting.
	 */
	@When("User Adds products using GTIN then add Quantity to clicks Add To order:")
	public void userAddsProductsUsingGTINThenAddQuantityToClicksAddToOrder(io.cucumber.datatable.DataTable dataTable)
			throws InterruptedException {
		List<Map<String, String>> productsData = dataTable.asMaps();

		for (Map<String, String> product : productsData) {
			String GTIN = product.get("GTIN");
			String addQuantity = product.get("addQuantity");
			String successMessage = product.get("successMessage");
			pom.getCurrentOrderPage().addProductsUsingGTIN(GTIN, addQuantity, successMessage);
		}
	}

	/**
	 * @see used to update items that were already added to an order.
	 *
	 * @param dataTable A Cucumber DataTable containing the details of each item to
	 *                  be updated such as item number, special code, order
	 *                  quantity, and the expected update confirmation message.
	 * @throws InterruptedException if interrupted while waiting for any UI element.
	 */
	@When("User should updates already added item:")
	public void userShouldUpdatesAlreadyAddedItem(io.cucumber.datatable.DataTable dataTable)
			throws InterruptedException {
		List<Map<String, String>> updatedItemsData = dataTable.asMaps();

		for (Map<String, String> data : updatedItemsData) {
			String itemsNum = data.get("itemsNum");
			String specialCode = data.get("specialCode");
			String orderQty = data.get("orderQty");
			String updateMessage = data.get("updateMessage");
			pom.getOrdersPage().updateItem(itemsNum, specialCode, orderQty, updateMessage);
		}

	}

	/**
	 * @See Used for updating already added items using the "Add Products" feature.
	 *      It reads item data from a Cucumber DataTable and updates each item
	 *      accordingly.
	 * 
	 * @param string    The expected message to verify after updating the item
	 *                  (e.g., success or warning message).
	 * @param dataTable A Cucumber DataTable containing rows of item data to update.
	 *                  Each row should include: - updateItems: the item to update -
	 *                  warningMessage: any expected warning message before update -
	 *                  updateQty: the quantity to update - updateSpecialCode:
	 *                  special code to apply to the item - updateMessage: the
	 *                  expected message after update
	 * 
	 * @throws InterruptedException if the thread is interrupted during wait or
	 *                              sleep
	 */
	@When("User should Updates already added items Using Add Products, verifies the message {string}:")
	public void userShouldUpdatesAlreadyAddedItemsUsingAddProductsVerifiesTheMessage(String string,
			io.cucumber.datatable.DataTable dataTable) throws InterruptedException {
		List<Map<String, String>> updateItemslist = dataTable.asMaps();

		for (Map<String, String> items : updateItemslist) {
			String updateItems = items.get("updateItems");
			String warningMessage = items.get("warningMessage");
			String updateQty = items.get("updateQty");
			String updateSpecialCode = items.get("updateSpecialCode");
			String updateMessage = items.get("updateMessage");
			pom.getOrdersPage().updateAlreadyAddedItemFromAddProducts(updateItems, warningMessage, updateQty,
					updateSpecialCode, updateMessage);
		}
	}

	/**
	 * @see Changes the order name and verifies the alert message upon successful
	 *      update.
	 * @param orderName                The new order name to set.
	 * @param orderNameUpdateedMessage The expected text of the alert message after
	 *                                 the order name is updated.
	 */
	@When("User updates the orders name to {string} and verifies the alert message {string}")
	public void userUpdatesTheOrdersNameToAndVerifiesTheAlertMessage(String orderName,
			String orderNameUpdateedMessage) {

		pom.getOrdersPage().orderNameUpdate(orderName);
		WebElement alertSuccessMessageOrderNameUpdate = pom.getOrdersPage().getAlertSuccessMessageOrderNameUpdate();
		assertEquals(alertSuccessMessageOrderNameUpdate, orderNameUpdateedMessage);

	}

	/**
	 * @See Used to update the auto-submit settings by selecting a specific date and
	 *      time. It then clicks on the Auto Submit button and verifies the success
	 *      message displayed.
	 *
	 * @param date            The date to be selected for auto-submit
	 * @param time            The time to be selected for auto-submit
	 * @param expectedMessage The expected success message to verify after
	 *                        submitting
	 */

	@Then("User should update the auto submit by selecting date {string} and time {string}, clicks on Auto Submit, and verifies the success message {string}")
	public void userShouldUpdateTheAutoSubmitBySelectingDateAndTimeClicksOnAutoSubmitAndVerifiesTheSuccessMessage(
			String date, String time, String expectedMessage) {

		pom.getOrdersPage().updateAutoSubmit(date, time);
		WebElement successMessageAutoSubmit = pom.getOrdersPage().getSuccessMessageAutoSubmit();
		assertEquals(successMessageAutoSubmit, expectedMessage);
	}

	/**
	 * @see Used to update the Order Reference with a given value and verify the
	 *      corresponding success message.
	 *
	 * @param orderReferance                The new Order Reference to be updated.
	 * @param expectedMessageOrderReferance The expected success message after
	 *                                      updating the Order Reference.
	 */
	@Then("User should update the Order Reference with {string} and verify the success message {string}")
	public void userShouldUpdateTheOrderReferenceWithAndVerifyTheSuccessMessage(String orderReferance,
			String expectedMessageOrderReferance) {
		pom.getOrdersPage().updateOrderReferance(orderReferance);
		WebElement successMessageOrderReference = pom.getOrdersPage().getSuccessMessageOrderReference();
		assertEquals(successMessageOrderReference, expectedMessageOrderReferance);
	}

	/**
	 * @see Used to cancel the Auto Submit feature and verify the corresponding
	 *      success message.
	 *
	 * @param cancelAutoSubmitmessage The expected success message after cancelling
	 *                                Auto Submit.
	 */

	@Then("User should cancel Auto Submit and verify the success message as {string}")
	public void userShouldCancelAutoSubmitAndVerifyTheSuccessMessageAs(String cancelAutoSubmitmessage) {
		pom.getOrdersPage().cancelAutoSubmit();
		WebElement successMessageCancelAutoSubmit = pom.getOrdersPage().getSuccessMessageCancelAutoSubmit();
		assertEquals(successMessageCancelAutoSubmit, cancelAutoSubmitmessage);
	}

	/**
	 * @See Used to clicks on the Auto Submit History and successfully views the
	 *      history details
	 * 
	 */
	@Then("the user clicks on Auto Submit History and successfully views the details")
	public void theUserClicksOnAutoSubmitHistoryAndSuccessfullyViewsTheDetails() {
		pom.getOrdersPage().autoSubmitHistory();
	}

	/**
	 * @See Used to selects the "Show Invalid Items First" option.
	 * 
	 *      This action is typically used to filter or prioritize invalid items in
	 *      the list for better visibility and correction.
	 */
	@Then("User should select Show Invalid Items First option")
	public void userShouldSelectShowInvalidItemsFirstOption() {
		pom.getOrdersPage().selectShowInvalidItemsFirst();

	}

	/**
	 * @see Used to selecting the header (select-all) checkbox correctly selects all
	 *      individual row check boxes in the list or table.
	 * @throws InterruptedException if the test execution is interrupted during wait
	 *                              operations
	 */
	@Then("User should verify that selecting the header checkbox selects all row checkboxes")
	public void userShouldVerifyThatSelectingTheHeaderCheckboxSelectsAllRowCheckboxes() throws InterruptedException {

		pom.getOrdersPage().verifySelectAllCheckboxFunctionality();
	}

	/**
	 * @see Used to selects an item in the list, clicks "Delete Selected", and
	 *      verifies that the expected success message is displayed.
	 *
	 * @param alertMessageDelete The expected success message displayed after
	 *                           deletion.
	 */
	@Then("User should selects the item in list and clicks Delete Selected then verifies the success message {string}")
	public void userShouldSelectsTheItemInListAndClicksDeleteSelectedThenVerifiesTheSuccessMessage(
			String alertMessageDelete) {
		pom.getOrdersPage().deleteProducts();
		WebElement successMessageDelete = pom.getOrdersPage().getSuccesMessageItemDeleted();
		assertEquals(successMessageDelete, alertMessageDelete);

	}

	/**
	 * @see Verifies the sorting order of items and product descriptions in both
	 *      ascending and descending order.
	 */

	@When("User verifies sorting orders in both ascending and descending orders for items, Product Discriptions")
	public void userVerifiesSortingOrdersInBothAscendingAndDescendingOrdersForItemsProductDiscriptions() {
		pom.getOrdersPage().itemsNumberSorting();
		pom.getOrdersPage().productDiscriptionsSorting();

	}

	/**
	 * @see Used to verify the sorting order (ascending and descending) for multiple
	 *      columns in the Orders page, including: items, Product Descriptions,
	 *      Categories, Whs. Qty, Net Price, Ext. Net Price, Inv. Price, Ext. Inv.
	 *      Price, and Added.
	 * 
	 *      This ensures that each column can be correctly sorted in both ascending
	 *      and descending order.
	 * 
	 * @throws InterruptedException if the test execution is interrupted during wait
	 *                              operations or sorting actions
	 */
	@Then("User verifies sorting order in both ascending and descending order for all columns: items, Product Descriptions, Categories, Whs. Qty, Net Price, Ext. Net Price, Inv. Price, Ext. Inv Price, and Added")
	public void userVerifiesSortingOrderInBothAscendingAndDescendingOrderForAllColumnsItemsProductDescriptionsCategoriesWhsQtyNetPriceExtNetPriceInvPriceExtInvPriceAndAdded()
			throws InterruptedException {
		pom.getOrdersPage().sortingFunctionality();
	}

	/**
	 * @see Updates item quantities and special codes in the grid and verifies
	 * 
	 *      alert message.
	 * @param string The expected text of the alert message after updating the
	 *               quantities and special codes.
	 */
	@Then("User should updates the item quantity to {string} and selects the special code {string} in the grid, then verifies the success alert message {string}")
	public void userShouldUpdatesTheItemQuantityToAndSelectsTheSpecialCodeInTheGridThenVerifiesTheSuccessAlertMessage(
			String qty, String specialCode, String string3) {

		pom.getOrdersPage().updateQty(qty);
		pom.getOrdersPage().updateSpecialCode(specialCode);
	}

	/**
	 * @see Updates item quantities in the grid and verifies the alert message.
	 * @param string The expected text of the alert message after updating the
	 *               quantities
	 */
	@Then("User should updates the item quantity to {string} in the grid, then verifies the success alert message {string}")
	public void userShouldUpdatesTheItemQuantityToInTheGridThenVerifiesTheSuccessAlertMessage(String qty,
			String string2) {
		pom.getOrdersPage().updateQty(qty);
	}

	/**
	 * @see Deletes an order from the grid and verifies the displayed alert message.
	 * @param deleteSuccessMessage The expected text of the success alert message
	 *                             after deleting the order.
	 * @throws InterruptedException If any thread interruption occurs during the
	 *                              deletion process.
	 */
	@Then("User deletes an item from the list and confirms the {string} alert message appears")
	public void userDeletesAnItemFromTheListAndConfirmsTheAlertMessageAppears(String deleteSuccessMessage) {
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
	 * @see Used to submit current C2 order
	 */
	@Then("User clicks {string} to submit the orders")
	public void userClicksToSubmitTheOrders(String string) {
		pom.getCurrentOrderPage().clicksSignSubmit();
	}

	/**
	 * @see Used Submitregular order by clicking the "Submit" button and then
	 *      confirms the action by clicking the "OK" button
	 */
	@Then("User submits the regular orders and clicks OK")
	public void userSubmitsTheRegularOrdersAndClicksOK() {
		pom.getCurrentOrderPage().clicksSubmit();
		pom.getCurrentOrderPage().clicksOK();
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
	 * @see Used to order submission alert message
	 * 
	 * @param orderName
	 */
	@Then("User verifies the orders submission with alert message {string}")
	public void userVerifiesTheOrdersSubmissionWithAlertMessage(String string) {
		pom.getCurrentOrderPage().clicksOK();
		System.out.println(getCurrentrl());
	}

	/**
	 * @see Used to save the template with confirm message
	 * @param orderTemplateMsg
	 */
	@Then("User should save the template and confirm the success alert message {string}")
	public void userShouldSaveTheTemplateAndConfirmTheSuccessAlertMessage(String orderTemplateMsg) {

		pom.getOrdersPage().saveTemplates();
		WebElement successMessageOrderTemplateSaved = pom.getOrdersPage().getSuccessMessageOrderTemplateSaved();
		assertEquals(successMessageOrderTemplateSaved, orderTemplateMsg);
	}

	/**
	 * @see Used to print the order details
	 * @param string
	 * @throws InterruptedException
	 */
	@Then("User clicks on {string} to view the order details.")
	public void userClicksOnToViewTheOrderDetails(String string) throws InterruptedException {
//		pom.getOrdersPage().printOrder();
	}

	/**
	 * @see Used to navigates Products catalog and Select DME
	 * @param string
	 */
	@Then("User should clicks Products, selects {string} and verify the page {string}")
	public void userShouldClicksProductsSelectsAndVerifyThePage(String linkText, String productCatalog) {
		pom.getProductsCatalogPage().chooseProductCatalog(linkText);
		WebElement titleProductCatalog = pom.getProductsCatalogPage().getTitleProductCatalog();
		verifyPageTitle(titleProductCatalog, productCatalog);
	}

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
	@When("User select Full view and clicks Create New for first product, Create New Orders with {string} , {string} , {string}")
	public void userSelectFullViewAndClicksCreateNewForFirstProductCreateNewOrdersWith(String orderName,
			String orderType, String autoSubmit) {
		pom.getProductsCatalogPage().selectsFullView();
		pom.getProductsCatalogPage().createNewOrder(orderName, orderType, autoSubmit);

	}

	/**
	 * @see Used to create new order in Compact view
	 * @param orderName
	 * @param orderType
	 * @param autoSubmit
	 */
	@When("User select Compact view and clicks Create New for first product, Create New Orders with {string} , {string} , {string}")
	public void userSelectCompactViewAndClicksCreateNewForFirstProductCreateNewOrdersWith(String orderName,
			String orderType, String autoSubmit) {

		pom.getProductsCatalogPage().selectsCompactView();
		pom.getProductsCatalogPage().compactViewOrderCreation(orderName, orderType, autoSubmit);
	}

	/**
	 * @see Used to order submission alert message
	 * @param orderName
	 */

	@Then("User should verifies that a success alert with the message {string} is displayed, confirming the item has been added to the order")
	public void userShouldVerifiesThatASuccessAlertWithTheMessageIsDisplayedConfirmingTheItemHasBeenAddedToTheOrder(
			String alertMessage) {
		WebElement alertSuccessMessageOrderCreation = pom.getProductsCatalogPage()
				.getAlertSuccessMessageOrderCreation();
		assertEquals(alertSuccessMessageOrderCreation, alertMessage);
	}

	/**
	 * @see Used to add another item to an existing order with the specified
	 *      quantity, clicks the "Add" button, and confirms that the success alert
	 *      message is displayed.
	 * 
	 *      This step verifies that the user can successfully add a new item to an
	 *      existing order and receive a confirmation message after doing so.
	 * 
	 * @param orderName      The name or identifier of the existing order to which
	 *                       the item is added.
	 * @param qty            The quantity of the item being added to the existing
	 *                       order.
	 * @param successMessage The expected success message displayed upon
	 *                       successfully adding the item.
	 * 
	 * @see pom.getProductsCatalogPage().addItemToExistingOrder() Used to add an
	 *      item to the existing order.
	 */
	@Then("User adds another item to the existing order {string} with quantity {string}, clicks Add, and confirms the {string} alert is displayed")
	public void userAddsAnotherItemToTheExistingOrderWithQuantityClicksAddAndConfirmsTheAlertIsDisplayed(
			String orderName, String qty, String successMessage) {
		refreshNavigation();
		pom.getProductsCatalogPage().addItemToExistingOrder(orderName, qty, successMessage);
	}

	/**
	 * @see Used to adds another item to an existing order in the Compact View,
	 *      specifies the quantity of the item, clicks the "Add" button, and
	 *      confirms that the expected success alert message is displayed after the
	 *      action.
	 * 
	 *      This step verifies that users can successfully add an item to an
	 *      existing order in a more compact interface (typically a condensed view)
	 *      and receive a confirmation message indicating the success of the action.
	 * 
	 * @param orderName      The name or identifier of the existing order to which
	 *                       the item will be added.
	 * @param qty            The quantity of the item to be added to the order.
	 * @param successMessage The expected success message displayed after the item
	 *                       is successfully added.
	 * 
	 * @see pom.getProductsCatalogPage().addItemInCompactView() Used to add the item
	 *      to the existing order in compact view.
	 */
	@Then("User should Add another item to an existing order in Compact View {string} with quantity {string}, clicks Add, and confirms the {string} alert is displayed")
	public void userShouldAddAnotherItemToAnExistingOrderInCompactViewWithQuantityClicksAddAndConfirmsTheAlertIsDisplayed(
			String orderName, String qty, String successMessage) throws InterruptedException {
		refreshNavigation();
		pom.getProductsCatalogPage().addItemInCompactView(orderName, qty, successMessage);
	}

	/**
	 * @see Used clicks the "Add" button with a specified order name, and when the
	 *      item is already added to the order, the system verifies the warning
	 *      message, updates the item's quantity with the specified value and
	 *      special codes, and confirms that the appropriate alert message is
	 *      displayed.
	 * 
	 *      This step is used to simulate scenarios where an item is added again to
	 *      an order (if it already exists), it triggers a warning message, and the
	 *      item is updated with a new quantity and special codes. The user should
	 *      then confirm that the correct alert message is shown.
	 * 
	 * @param selectOrderName       The name or identifier of the order to which the
	 *                              item is being added.
	 * @param titleItemAlreadyExist The warning message displayed when the item is
	 *                              already in the order.
	 * @param qtyUpdate             The new quantity to be updated for the existing
	 *                              item.
	 * @param expectedAlertMsg      The expected alert message to be displayed after
	 *                              the item is updated.
	 */
	@Then("User should clicks Add With {string}, and when the item is already added, verifies the warning message {string} and updates it with {string} and specialCodes, confirming the alert message {string}")
	public void userShouldClicksAddWithAndWhenTheItemIsAlreadyAddedVerifiesTheWarningMessageAndUpdatesItWithAndSpecialCodesConfirmingTheAlertMessage(
			String selectOrderName, String titleItemAlreadyExist, String qtyUpdate, String expectedAlertMsg) {
		pom.getProductsCatalogPage().addExistingItemAndUpdate(selectOrderName, titleItemAlreadyExist, qtyUpdate,
				expectedAlertMsg);

	}

	/**
	 * @see Used adds an item to an existing order in Compact View. If the item is
	 *      already added, it verifies the warning message, updates the item's
	 *      quantity, special codes, and confirms the displayed alert message.
	 *
	 * @param selectOrderName       The name of the order to which the item is being
	 *                              added.
	 * @param titleItemAlreadyExist The warning message shown when the item already
	 *                              exists in the order.
	 * @param qtyUpdate             The updated quantity of the item.
	 * @param expectedAlertMsg      The expected alert message after updating the
	 *                              item.
	 */
	@Then("User should clicks Add in Compact View, selects {string}, clicks Add To Order, and when the item is already added, verifies the message {string} and updates it with {string} and special codes, confirming the alert message {string}")
	public void userShouldClicksAddInCompactViewSelectsClicksAddToOrderAndWhenTheItemIsAlreadyAddedVerifiesTheMessageAndUpdatesItWithAndSpecialCodesConfirmingTheAlertMessage(
			String selectOrderName, String titleItemAlreadyExist, String qtyUpdate, String expectedAlertMsg)
			throws InterruptedException {
		pom.getProductsCatalogPage().handleItemAlreadyExistAndUpdateCompactView(selectOrderName, titleItemAlreadyExist,
				qtyUpdate, expectedAlertMsg);

	}

	/**
	 * @see Used to product search using globalsearch
	 * @param globalSearch
	 */
	@Then("User performs global search for {string} to create a new regular orders")
	public void userPerformsGlobalSearchForToCreateANewRegularOrders(String globalSearch) {
		pom.getDashboardPage().performGlobalSearch(globalSearch);
	}

	/**
	 * @see Used to create new order in product search webpage
	 * @param orderName
	 * @param autoSubmit
	 * @param string3
	 */
	@When("User selects a product, enters quantity {string}, creates a new order with {string} and {string}, and confirms the success message {string}")
	public void userSelectsAProductEntersQuantityCreatesANewOrderWithAndAndConfirmsTheSuccessMessage(String qty,
			String orderName, String autoSubmit, String string4) {
		pom.getProductsCatalogPage().selectsFullView();
		pom.getProductSearchPage().addQuantity(qty);
		pom.getProductSearchPage().createNewOrder(orderName, autoSubmit);
	}

	/**
	 * @see Used to to click "Add" on an existing item, select an existing order,
	 *      verify the warning message if the item is already added, update the
	 *      item’s quantity and special code, and confirm that the correct success
	 *      message is displayed.
	 *
	 * @param selectOrderName       The name of the existing order to which the item
	 *                              will be added.
	 * @param updateQty             The current quantity of the item before the
	 *                              update.
	 * @param titleItemAlreadyExist The warning message displayed when the item is
	 *                              already in the order.
	 * @param qtyUpdate             The new quantity to update the existing item.
	 * @param specialCode           The special code to be applied to the item.
	 * @param successMessage        The expected success message after updating the
	 *                              item.
	 */
	@Then("User clicks Add on the same item, selects the existing order {string}, {string} verifies the warning message {string}, updates the item with quantity {string} and the provided special code {string} , and confirms the alert message {string}")
	public void userClicksAddOnTheSameItemSelectsTheExistingOrderVerifiesTheWarningMessageUpdatesTheItemWithQuantityAndTheProvidedSpecialCodeAndConfirmsTheAlertMessage(
			String selectOrderName, String updateQty, String titleItemAlreadyExist, String qtyUpdate,
			String specialCode, String successMessage) throws InterruptedException {

		pom.getProductSearchPage().updateAlreadyAddedItemToOrder(selectOrderName, updateQty, titleItemAlreadyExist,
				qtyUpdate, specialCode, successMessage);
	}

	/**
	 * @see Used to click "Add To Order" on an existing item, select an existing
	 *      order, verify the warning message if the item is already added, update
	 *      the item's quantity and special code, and confirm that the correct
	 *      success message is displayed.
	 *
	 * @param updateQty             The current quantity of the item before
	 *                              updating.
	 * @param selectOrderName       The name of the existing order to which the item
	 *                              will be added.
	 * @param titleItemAlreadyExist The warning message displayed when the item is
	 *                              already in the order.
	 * @param qtyUpdate             The new quantity to update the existing item.
	 * @param specialCode           The special code to apply to the item.
	 * @param successMessage        The expected success message after the item is
	 *                              updated.
	 */
	@Then("User clicks Add To Order on the same item, selects the existing order {string}, {string} verifies the warning message {string}, updates the item with quantity {string} and the provided special code {string} , and confirms the alert message {string}")
	public void userClicksAddToOrderOnTheSameItemSelectsTheExistingOrderVerifiesTheWarningMessageUpdatesTheItemWithQuantityAndTheProvidedSpecialCodeAndConfirmsTheAlertMessage(
			String updateQty, String selectOrderName, String titleItemAlreadyExist, String qtyUpdate,
			String specialCode, String successMessage) throws InterruptedException {

		pom.getProductDetailPage().addAlreadyAddedItem(updateQty, selectOrderName);
		pom.getProductsCatalogPage().itemAlreadyAdded(titleItemAlreadyExist, qtyUpdate, specialCode);
		WebElement alertSuccessMessage = pom.getProductDetailPage().getAlertSuccessMessage();
		assertEquals(alertSuccessMessage, successMessage);
	}

	/**
	 * @see Used to creation of a new order using the provided order name and
	 *      auto-submit option. It also verifies that a success message is displayed
	 *      after the order is created.
	 *
	 * @param orderName  The name to assign to the new order.
	 * @param autoSubmit
	 * @param string3    The expected success message after the order is created.
	 */
	@Then("User clicks on Create New Orders with {string} , {string} and verifies the success message {string}")
	public void userClicksOnCreateNewOrdersWithAndVerifiesTheSuccessMessage(String orderName, String autoSubmit,
			String string3) {
		pom.getProductsCatalogPage().selectsCompactView();
		pom.getProductSearchPage().createNewOrder(orderName, autoSubmit);
	}

	/**
	 * @see Used to create new order in suggested products list
	 * @param orderName
	 * @param autoSubmit
	 * @param expectedAlertSuccessmessage
	 * @throws InterruptedException
	 */

	@Then("User should Create New Regular Orders in Suggested Products list with {string} , {string} and verifies the success message {string}")
	public void userShouldCreateNewRegularOrdersInSuggestedProductsListWithAndVerifiesTheSuccessMessage(
			String orderName, String autoSubmit, String expectedAlertSuccessmessage) throws InterruptedException {
		pom.getProductDetailPage().createNewRegularOrder(orderName, autoSubmit);
		WebElement alertSuccessMessageOrderCreation = pom.getProductDetailPage().getAlertSuccessMessageOrderCreation();
		assertEquals(alertSuccessMessageOrderCreation, expectedAlertSuccessmessage);
	}

	/**
	 * @see Used to clicking "Add" on a suggested item, selecting an existing order,
	 *      verifying a warning message if the item already exists, updating its
	 *      quantity and special code, and confirming that the correct success alert
	 *      message is displayed.
	 *
	 * @param selectOrderName       The name of the existing order the item is being
	 *                              added to.
	 * @param updateQty             The current quantity of the item before
	 *                              updating.
	 * @param titleItemAlreadyExist The warning message shown when the item already
	 *                              exists in the order.
	 * @param qtyUpdate             The new quantity to update the item with.
	 * @param specialCode           The special code to apply to the item.
	 * @param successMessage        The expected alert message after the item is
	 *                              updated successfully.
	 */
	@Then("User clicks Add on the same suggested item, selects the existing order {string}, {string} verifies the warning message {string}, updates the item with quantity {string} and the provided special code {string} , and confirms the alert message {string}")
	public void userClicksAddOnTheSameSuggestedItemSelectsTheExistingOrderVerifiesTheWarningMessageUpdatesTheItemWithQuantityAndTheProvidedSpecialCodeAndConfirmsTheAlertMessage(
			String selectOrderName, String updateQty, String titleItemAlreadyExist, String qtyUpdate,
			String specialCode, String successMessage) throws InterruptedException {
		refreshNavigation();
		pom.getProductDetailPage().updateSuggestItem(selectOrderName, updateQty);
		pom.getProductsCatalogPage().itemAlreadyAdded(titleItemAlreadyExist, qtyUpdate, specialCode);
		WebElement alertSuccessMessage = pom.getProductDetailPage().getAlertSuccessMessage();
		assertEquals(alertSuccessMessage, successMessage);
	}

	/**
	 * @see used to create case items order
	 * @param orderName
	 * @param autoSubmit
	 * @param expectedAlertSuccessmessage
	 */
	@When("User clicks on Create New Orders, clicks YES for Case Item orders and enters {string} and {string} and verifies the success message {string}")
	public void userClicksOnCreateNewOrdersClicksYESForCaseItemOrdersAndEntersAndAndVerifiesTheSuccessMessage(
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
	@Then("User Clicks Create New Regular Orders with {string} , {string} and verifies the success message {string}")
	public void userClicksCreateNewRegularOrdersWithAndVerifiesTheSuccessMessage(String orderName, String autoSubmit,
			String alertOrdercreationMessage) {
		pom.getProductDetailPage().createNewOrder(orderName, autoSubmit);
		WebElement alertMessage_Ordercreation = pom.getProductDetailPage().getAlertMessage_Ordercreation();
		assertEquals(alertMessage_Ordercreation, alertOrdercreationMessage);

	}

	/**
	 * @see Used to change the name of an order and verifies that the expected alert
	 *      message is displayed after the update.
	 *
	 * @param orderName                The new name to be set for the order.
	 * @param orderNameUpdateedMessage The expected success or confirmation message
	 *                                 after the order name is updated.
	 */
	@When("User can change Order Name as {string} then  verifying the alert message {string}")
	public void userCanChangeOrderNameAsThenVerifyingTheAlertMessage(String orderName,
			String orderNameUpdateedMessage) {

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
	@Then("User navigates back to Current Orders page Clicks on Create New and Use Template")
	public void userNavigatesBackToCurrentOrdersPageClicksOnCreateNewAndUseTemplate() throws InterruptedException {
		pom.getDashboardPage().navigatesCurrentOrderPage();
	}

	/**
	 * @see Clicks on Create with order name and Choose Template.
	 */
	@Then("User should clicks on Create with orders name and Choose Template")
	public void userShouldClicksOnCreateWithOrdersNameAndChooseTemplate() {
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

	@When("User attempts to create an order with {string} exceeding {int} characters with {string} order type and verifies the error message {string}")
	public void userAttemptsToCreateAnOrderWithExceedingCharactersWithOrderTypeAndVerifiesTheErrorMessage(
			String orderNameValidations, Integer int1, String orderType, String expectedErrorMessage) {

		pom.getCurrentOrderPage().orderNameValidations(orderNameValidations, orderType);
		WebElement errorMessageOrdenNamelength = pom.getCurrentOrderPage().getErrorMessageOrdenNamelength();
		assertEquals(errorMessageOrdenNamelength, expectedErrorMessage);
	}

	@Then("User enters special characters in the Order Name {string} with {string} order type and tries to create an Order then see the error message {string}")
	public void userEntersSpecialCharactersInTheOrderNameWithOrderTypeAndTriesToCreateAnOrderThenSeeTheErrorMessage(
			String orderNameValidations, String orderType, String orderNamewithSpecialCharErrorMessage) {
		pom.getCurrentOrderPage().orderNameValidations(orderNameValidations, orderType);
		WebElement errorMessageOrdernameSpeclChar = pom.getCurrentOrderPage().getErrorMessageOrdernameSpeclChar();
		assertEquals(errorMessageOrdernameSpeclChar, orderNamewithSpecialCharErrorMessage);
	}

	@When("User attempts to create an order reference name {string} exceeding {int} characters with {string} order type and verifies the error message {string}")
	public void userAttemptsToCreateAnOrderReferenceNameExceedingCharactersWithOrderTypeAndVerifiesTheErrorMessage(
			String orderReferance, Integer int1, String orderType, String string3) {
		pom.getCurrentOrderPage().orderReference(orderReferance, orderType);
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

	@Then("User provides spaces in the Order Name field in Templates and tries to create an Order, then verifies the error message {string}")
	public void userProvidesSpacesInTheOrderNameFieldInTemplatesAndTriesToCreateAnOrderThenVerifiesTheErrorMessage(
			String emptyFieldOrderName) {
		pom.getCurrentOrderPage().templateOrderNamewithSpace();
		WebElement errorMessageOrderName = pom.getCurrentOrderPage().getErrorMessageOrderName();
		assertEquals(errorMessageOrderName, emptyFieldOrderName);
	}

	@When("User attempts to create a Template with Order Name {string} exceeding {int} characters and verifies the error message {string}")
	public void userAttemptsToCreateATemplateWithOrderNameExceedingCharactersAndVerifiesTheErrorMessage(
			String orderName, Integer int1, String expectedErrorMessage) {
		pom.getCurrentOrderPage().templateOrderNameValidations(orderName);
		WebElement errorMessageOrdenNamelength = pom.getCurrentOrderPage().getErrorMessageOrdenNamelength();
		assertEquals(errorMessageOrdenNamelength, expectedErrorMessage);
	}

	@Then("User enters special characters in the Templates Order Name {string} and tries to create an Order then see the error message {string}")
	public void userEntersSpecialCharactersInTheTemplatesOrderNameAndTriesToCreateAnOrderThenSeeTheErrorMessage(
			String orderName, String orderNamewithSpecialCharErrorMessage) {
		pom.getCurrentOrderPage().templateOrderNameValidations(orderName);
		WebElement errorMessageOrdernameSpeclChar = pom.getCurrentOrderPage().getErrorMessageOrdernameSpeclChar();
		assertEquals(errorMessageOrdernameSpeclChar, orderNamewithSpecialCharErrorMessage);

	}

	/**
	 * @see Searches for an order by name and verifies that the grid displays the
	 *      correct order name.
	 * @param orderName The name of the order to search for.
	 * @param string2   The expected order name to be displayed in the grid.
	 * @throws InterruptedException If any thread interruption occurs during the
	 *                              process.
	 */
	@When("User searches for a Orders Name {string} and verifies that the grid displays the Order name is {string}")
	public void userSearchesForAOrdersNameAndVerifiesThatTheGridDisplaysTheOrderNameIs(String orderName, String string2)
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
	@Then("User verifies pagination functionality on the Orders Templates Web Page")
	public void userVerifiesPaginationFunctionalityOnTheOrdersTemplatesWebPage() throws InterruptedException {

		pom.getTemplatesPage().pageNavigations();
	}

	@Then("User removes the Order Name and verifies the error message {string}.")
	public void userRemovesTheOrderNameAndVerifiesTheErrorMessage(String emptyFieldOrderNameErrorMessage)
			throws InterruptedException {
		Thread.sleep(3000);
		pom.getOrdersPage().clearOrderName();
		WebElement errorMessageOrderName = pom.getCurrentOrderPage().getErrorMessageOrderName();
		assertEquals(errorMessageOrderName, emptyFieldOrderNameErrorMessage);
	}

	@When("User attempts to Updates an Order Name with {string} exceeding {int} characters  verifies the error message {string}")
	public void userAttemptsToUpdatesAnOrderNameWithExceedingCharactersVerifiesTheErrorMessage(String updatedOrderName,
			Integer int1, String expectedErrorMessage) {
		pom.getOrdersPage().orderNameUpdate(updatedOrderName);
		WebElement errorMessageOrdenNamelength = pom.getCurrentOrderPage().getErrorMessageOrdenNamelength();
		assertEquals(errorMessageOrdenNamelength, expectedErrorMessage);
	}

	@Then("User attempts to updates an order Name with special characters {string} then see the error message {string}")
	public void userAttemptsToUpdatesAnOrderNameWithSpecialCharactersThenSeeTheErrorMessage(String updatedOrderName,
			String orderNamewithSpecialCharErrorMessage) {
		pom.getOrdersPage().orderNameUpdate(updatedOrderName);
		WebElement errorMessageOrdernameSpeclChar = pom.getCurrentOrderPage().getErrorMessageOrdernameSpeclChar();
		assertEquals(errorMessageOrdernameSpeclChar, orderNamewithSpecialCharErrorMessage);
	}

	@When("User attempts to updates an order reference name {string} exceeding {int} characters and verifies the error message {string}")
	public void userAttemptsToUpdatesAnOrderReferenceNameExceedingCharactersAndVerifiesTheErrorMessage(
			String orderReference, Integer int1, String orderReferenceErrorMessage) {

		pom.getOrdersPage().orderReference(orderReference);
		WebElement errorMessageOrderReference = pom.getOrdersPage().getErrorMessageOrderReference();
		assertEquals(errorMessageOrderReference, orderReferenceErrorMessage);
	}

	@Then("User attempts to updates an reference Name with special characters {string} then see the error message {string}")
	public void userAttemptsToUpdatesAnReferenceNameWithSpecialCharactersThenSeeTheErrorMessage(String orderReference,
			String orderNamewithSpecialCharErrorMessage) {
		pom.getOrdersPage().orderReference(orderReference);
		WebElement errorMessageOrdernameSpeclChar = pom.getCurrentOrderPage().getErrorMessageOrdernameSpeclChar();
		assertEquals(errorMessageOrdernameSpeclChar, orderNamewithSpecialCharErrorMessage);
	}

	@Then("User attempts to Auto Submit {string}  and {string} without selecting any items and verifies the warning message {string}")
	public void userAttemptsToAutoSubmitAndWithoutSelectingAnyItemsAndVerifiesTheWarningMessage(String date,
			String time, String errorMessageAutoSubmitWOSelectItem) {
		pom.getOrdersPage().updateAutoSubmit(date, time);
		WebElement errorMessageWithoutSelectItem = pom.getOrdersPage().getErrorMessageWithoutSelectItem();
		assertEquals(errorMessageWithoutSelectItem, errorMessageAutoSubmitWOSelectItem);
	}

	@Then("User enters an invalid date {string} for auto-submit and verifies the error message {string}")
	public void userEntersAnInvalidDateForAutoSubmitAndVerifiesTheErrorMessage(String date, String string2) {
		pom.getOrdersPage().autoSubmitValidation(date);

	}

	@When("User submitting an invalid or null date {string} and verifies the warning message {string}")
	public void userSubmittingAnInvalidOrNullDateAndVerifiesTheWarningMessage(String date, String errormessagedate) {
		pom.getOrdersPage().autoSubmitValidation(date);
		WebElement warningMessageAutoSubmit = pom.getOrdersPage().getWarningMessageAutoSubmit();
		assertEquals(warningMessageAutoSubmit, errormessagedate);

	}

	@Then("User attempts to submit the order without selecting any items and verifies the warning message {string}")
	public void userAttemptsToSubmitTheOrderWithoutSelectingAnyItemsAndVerifiesTheWarningMessage(
			String errorMessageAutoSubmitWOSelectItem) {
		WebElement btnSubmit = pom.getOrdersPage().getBtnSubmit();
		click(btnSubmit);
		WebElement errorMessageWithoutSelectItem = pom.getOrdersPage().getErrorMessageWithoutSelectItem();
		assertEquals(errorMessageWithoutSelectItem, errorMessageAutoSubmitWOSelectItem);
	}

	@Then("User attempts to Sign&Submit the order without selecting any items and verifies the warning message {string}")
	public void userAttemptsToSignSubmitTheOrderWithoutSelectingAnyItemsAndVerifiesTheWarningMessage(
			String errorMessageAutoSubmitWOSelectItem) {
		WebElement btnSignSubmit = pom.getOrdersPage().getBtnSignSubmit();
		click(btnSignSubmit);
		WebElement errorMessageWithoutSelectItem = pom.getOrdersPage().getErrorMessageWithoutSelectItem();
		assertEquals(errorMessageWithoutSelectItem, errorMessageAutoSubmitWOSelectItem);
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

	@Then("User attempts to add discontinued, and inactive items, then see the warning message {string} for each item:")
	public void userAttemptsToAddDiscontinuedAndInactiveItemsThenSeeTheWarningMessageForEachItem(String string,
			io.cucumber.datatable.DataTable dataTable) throws InterruptedException {

		List<Map<String, String>> itemslist = dataTable.asMaps();

		for (Map<String, String> item : itemslist) {
			String products = item.get("items");
			pom.getOrdersPage().RestrictionOrder(products);
			WebElement warningMessageUnavailable = pom.getOrdersPage().getWarningMessageUnavailable();
			assertEquals(warningMessageUnavailable, string);
		}
	}

	@Then("User attempts to add discontinued, and inactive items in Regular Order then see the error message {string} for each item:")
	public void userAttemptsToAddDiscontinuedAndInactiveItemsInRegularOrderThenSeeTheErrorMessageForEachItem(
			String expectedText, io.cucumber.datatable.DataTable dataTable) throws InterruptedException {
		List<Map<String, String>> updateItemslist = dataTable.asMaps();

		for (Map<String, String> items : updateItemslist) {
			String products = items.get("products");
			String errorMessage = items.get("errorMessage");
			pom.getOrdersPage().restrictedItemsUsingAddProducts(products);
			pom.getOrdersPage().verifyDiscontinuedMessage(expectedText);
		}

	}

	@Then("User attempts to add C2 alternative items Using NDC in Regular order and verifies the alert message {string}")
	public void userAttemptsToAddC2AlternativeItemsUsingNDCInRegularOrderAndVerifiesTheAlertMessage(
			String warningMessage, io.cucumber.datatable.DataTable dataTable) throws InterruptedException {
		List<Map<String, String>> updateItemslist = dataTable.asMaps();
		for (Map<String, String> items : updateItemslist) {
			String products = items.get("products");
			pom.getOrdersPage().c2AlternativeItems(products);
			WebElement warningMessageC2addedRegular = pom.getOrdersPage().getWarningMessageC2addedRegular();
			assertEquals(warningMessageC2addedRegular, warningMessage);
		}
	}

	@Then("User attempts to add Non C2 alternative items Using NDC, UPC, GTIN, Product Discriptions and item# in C2 order and verifies the alert message {string}")
	public void userAttemptsToAddNonC2AlternativeItemsUsingNDCUPCGTINProductDiscriptionsAndItemInC2OrderAndVerifiesTheAlertMessage(
			String expectedWarningMessage, io.cucumber.datatable.DataTable dataTable) throws InterruptedException {

		List<Map<String, String>> itemslist = dataTable.asMaps();
		for (Map<String, String> item : itemslist) {
			String products = item.get("products");
			pom.getOrdersPage().regularAlternativeItems(products);
			WebElement warningmessageRegularAddedC2 = pom.getOrdersPage().getWarningmessageRegularAddedC2();
			assertEquals(warningmessageRegularAddedC2, expectedWarningMessage);
		}
	}

	@Then("User attempts to add C2 items Using UPC, GTIN, Product Discriptions, Item#  Regular order and verifies the alert message {string} :")
	public void userAttemptsToAddC2ItemsUsingUPCGTINProductDiscriptionsItemRegularOrderAndVerifiesTheAlertMessage(
			String expectedErrorMessage, io.cucumber.datatable.DataTable dataTable) {
		List<Map<String, String>> updateItemslist = dataTable.asMaps();
		for (Map<String, String> items : updateItemslist) {
			String products = items.get("products");
			pom.getOrdersPage().c2ItemsAddedInRegularOrder(products);
			WebElement errorMessageNOMatchingProducts = pom.getOrdersPage().getErrorMessageNOMatchingProducts();
			assertEquals(errorMessageNOMatchingProducts, expectedErrorMessage);

		}

	}

	@Then("User attempts to add Regular items Using NDC, UPC, GTIN, Product Discriptions and item# in C2 order and verifies the alert message {string}")
	public void userAttemptsToAddRegularItemsUsingNDCUPCGTINProductDiscriptionsAndItemInC2OrderAndVerifiesTheAlertMessage(
			String expectedErrorMessage, io.cucumber.datatable.DataTable dataTable) {
		List<Map<String, String>> updateItemslist = dataTable.asMaps();
		for (Map<String, String> items : updateItemslist) {
			String products = items.get("products");
			pom.getOrdersPage().regularItemsAddedInC2Order(products);
			WebElement errorMessageNOMatchingProducts = pom.getOrdersPage().getErrorMessageNOMatchingProducts();
			assertEquals(errorMessageNOMatchingProducts, expectedErrorMessage);
		}
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

	/**
	 * @see Used to where the system suggests alternative items when the user
	 *      attempts to add discontinued or inactive products to the order. It
	 *      iterates over a list of products and adds alternative items based on the
	 *      provided item numbers and quantities.
	 *
	 * @param dataTable The data table containing product details, including item
	 *                  numbers and order quantities. Each entry in the table
	 *                  corresponds to an item number and its respective order
	 *                  quantity.
	 */
	@When("User add system suggests alternative items when the user attempts to add discontinued or inactive products")
	public void userAddSystemSuggestsAlternativeItemsWhenTheUserAttemptsToAddDiscontinuedOrInactiveProducts(
			io.cucumber.datatable.DataTable dataTable) throws InterruptedException {
		List<Map<String, String>> productsData = dataTable.asMaps();

		for (Map<String, String> product : productsData) {
			String itemNumber = product.get("itemNumber");
			String orderQty = product.get("orderQty");

			pom.getCurrentOrderPage().addAlternativeItem(itemNumber, orderQty);
		}
	}

	@Then("User submits the C2 Order with an invalid password {string} and verifies the error message {string}")
	public void userSubmitsTheC2OrderWithAnInvalidPasswordAndVerifiesTheErrorMessage(String storePassword,
			String expectedAlertMessage) {
		pom.getCurrentOrderPage().clicksSignSubmit();
		pom.getCurrentOrderPage().insertStorePassword(storePassword);
		WebElement alertmessageC2PasswordnotMatch = pom.getOrdersPage().getAlertmessageC2PasswordnotMatch();
		assertEquals(alertmessageC2PasswordnotMatch, expectedAlertMessage);
	}

	@Then("User selects {string} and clicks {string} to initiate creating a new order")
	public void userSelectsAndClicksToInitiateCreatingANewOrder(String string, String string2) {

		pom.getCurrentOrderPage().selectsFullView();
		WebElement btnCreateNewOrder = pom.getProductDetailPage().getBtnCreateNewOrder();
		click(btnCreateNewOrder);
	}

	@Then("User selects Compact view and clicks {string} to initiate creating a new order")
	public void userSelectsCompactViewAndClicksToInitiateCreatingANewOrder(String string) {
		pom.getProductsCatalogPage().selectsCompactView();
		WebElement btnAdd = pom.getProductsCatalogPage().getBtnAdd();
		clickElementUsingJavaScript(driver, btnAdd);

	}

	@When("User verifies the Suggested Products list and clicks {string} to initiate a new order.")
	public void userVerifiesTheSuggestedProductsListAndClicksToInitiateANewOrder(String string)
			throws InterruptedException {
		pom.getProductDetailPage().suggestedProductOrderCreationValidations();
	}

	@Then("User tries to create an order without entering Order Name and verifies the error message {string}")
	public void userTriesToCreateAnOrderWithoutEnteringOrderNameAndVerifiesTheErrorMessage(
			String emptyFieldOrderNameErrorMessage) {
		pom.getProductDetailPage().removeOrderName();
		WebElement errorMessageOrderName = pom.getCurrentOrderPage().getErrorMessageOrderName();
		assertEquals(errorMessageOrderName, emptyFieldOrderNameErrorMessage);
	}

	@Then("User tries to create an order with special characters in the Order Name {string} and verifies the error message {string}")
	public void userTriesToCreateAnOrderWithSpecialCharactersInTheOrderNameAndVerifiesTheErrorMessage(String orderName,
			String orderNamewithSpecialCharErrorMessage) {
		pom.getProductDetailPage().orderNameValidation(orderName);
		WebElement errorMessageOrdernameSpeclChar = pom.getCurrentOrderPage().getErrorMessageOrdernameSpeclChar();
		assertEquals(errorMessageOrdernameSpeclChar, orderNamewithSpecialCharErrorMessage);
	}

	@When("User attempts to create an order with Order Name {string} exceeding {int} characters and verifies the error message {string}")
	public void userAttemptsToCreateAnOrderWithOrderNameExceedingCharactersAndVerifiesTheErrorMessage(String orderName,
			Integer int1, String expectedErrorMessage) {
		pom.getProductDetailPage().orderNameValidation(orderName);
		WebElement errorMessageOrdenNamelength = pom.getCurrentOrderPage().getErrorMessageOrdenNamelength();
		assertEquals(errorMessageOrdenNamelength, expectedErrorMessage);
	}

	@When("User should verify the suggested products quantity field validations")
	public void userShouldVerifyTheSuggestedProductsQuantityFieldValidations(
			io.cucumber.datatable.DataTable dataTable) {
		List<Map<String, String>> updateItemslist = dataTable.asMaps();
		for (Map<String, String> items : updateItemslist) {
			String input = items.get("qtyInputs");
			pom.getProductDetailPage()
					.validateQuantityFieldInput(pom.getProductDetailPage().getTxtQtySuggestionProduct(), input);
		}
	}

	@When("User removes the Order name and navigates back to the Current Order page")
	public void userRemovesTheOrderNameAndNavigatesBackToTheCurrentOrderPage() throws InterruptedException {
		Thread.sleep(3000);
		pom.getOrdersPage().clearOrderName();
		pom.getOrdersPage().clicksbclnk();
	}

	@When("User searches for a Order name {string} and verifies that the grid displays the Order name is {string}")
	public void userSearchesForAOrderNameAndVerifiesThatTheGridDisplaysTheOrderNameIs(String orderName, String string2)
			throws InterruptedException {

		pom.getCurrentOrderPage().searchCurrentOrders(orderName);
	}

	@When("User verifies sorting order in both ascending and descending current orders for all columns Order Name, Status, Created Date, Order Type, Total Lines, Total Pieces and Ext.Inv. Price")
	public void userVerifiesSortingOrderInBothAscendingAndDescendingCurrentOrdersForAllColumnsOrderNameStatusCreatedDateOrderTypeTotalLinesTotalPiecesAndExtInvPrice() {

		pom.getCurrentOrderPage().sortingOrders();
	}

	@Then("User deletes an order from the current order list and verifies the {string} alert message")
	public void userDeletesAnOrderFromTheCurrentOrderListAndVerifiesTheAlertMessage(String string) {

		refreshNavigation();
		pom.getCurrentOrderPage().deleteCurrentOrder();
	}

	@Then("User verifies pagination functionality on the current order page")
	public void userVerifiesPaginationFunctionalityOnTheCurrentOrderPage() throws InterruptedException {
		pom.getCurrentOrderPage().pageNavigations();

	}

	@Then("User should verifies the Order quantity field input validation")
	public void userShouldVerifiesTheOrderQuantityFieldInputValidation() throws InterruptedException {
		pom.getProductDetailPage().validateQtyInputs(pom.getOrdersPage().getTxtQty());

	}

	@Then("User attempts to add the already added item {string} using Add Products")
	public void userAttemptsToAddTheAlreadyAddedItemUsingAddProducts(String product) throws InterruptedException {
		pom.getCurrentOrderPage().alreadyAddedItemUsingAddProducts(product);

	}

	@Then("User verifies Quantity field enforces validation for acceptable inputs")
	public void userVerifiesQuantityFieldEnforcesValidationForAcceptableInputs() throws InterruptedException {
		pom.getProductDetailPage().validateQtyInputs(pom.getCurrentOrderPage().getTxtAddQty());

	}

	@Then("User clicks Add To Order and verifies the message {string}:")
	public void userClicksAddToOrderAndVerifiesTheMessage(String string) {
		WebElement btnAddToOrder = pom.getCurrentOrderPage().getBtnAddToOrder();
		clickElementUsingJavaScript(driver, btnAddToOrder);
		WebElement modaltitle = pom.getProductsCatalogPage().getModaltitle();
		assertEquals(modaltitle, string);
	}

	@Then("User {string} is displayed, the Order Qty field should enforce its input validation rules")
	public void userIsDisplayedTheOrderQtyFieldShouldEnforceItsInputValidationRules(String string) throws InterruptedException {
		pom.getProductDetailPage().validateQtyInputs(pom.getProductsCatalogPage().getTxtOrderQty());

	}

	@Then("User updating the Order Qty field to empty and submitting should display {string}")
	public void userUpdatingTheOrderQtyFieldToEmptyAndSubmittingShouldDisplay(String string) {
		pom.getOrdersPage().emptyFieldOrderQty();
		WebElement errorMessageQty = pom.getOrdersPage().getErrorMessageQty();
		assertEquals(errorMessageQty, string);
		
	}

	@Then("User updating the Order Qty to {string} and submitting should display the error {string}")
	public void userUpdatingTheOrderQtyToAndSubmittingShouldDisplayTheError(String qty, String string2) {
		pom.getOrdersPage().orderQty(qty);
		WebElement errorMessageOrderQty = pom.getOrdersPage().getErrorMessageOrderQty();
		assertEquals(errorMessageOrderQty, string2);
		WebElement btnCancel = pom.getOrdersPage().getBtncance();
		click(btnCancel);
	}
}
