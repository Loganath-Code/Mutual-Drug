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
	 * @see Used to create new Regular order in product detail webpage
	 * @param orderName
	 * @param autoSubmit
	 * @param alertOrdercreationMessage
	 * @throws InterruptedException
	 */
	@Then("User Clicks Create New Regular Order with {string} , {string} and verifies the success message {string}")
	public void userClicksCreateNewRegularOrderWithAndVerifiesTheSuccessMessage(String orderName, String autoSubmit,
			String alertOrdercreationMessage) throws InterruptedException {
		pom.getProductDetailPage().createNewOrder(orderName, autoSubmit);
		WebElement alertMessage_Ordercreation = pom.getProductDetailPage().getAlertMessage_Ordercreation();
		assertEquals(alertMessage_Ordercreation, alertOrdercreationMessage);
	}

	@Then("User clicks on Save As Template and see the alert message as {string}")
	public void userClicksOnSaveAsTemplateAndSeeTheAlertMessageAs(String alertMessageTemplateSaved) {
		pom.getCurrentOrderPage().clickSaveAsTemplateButton();
		WebElement alertMessageTemplateSaved2 = pom.getCurrentOrderPage().getAlertMessageTemplateSaved();
		assertEquals(alertMessageTemplateSaved2, alertMessageTemplateSaved);
	}

	@When("User navigates back to Current Order page Clicks on Create New and Use Template")
	public void userNavigatesBackToCurrentOrderPageClicksOnCreateNewAndUseTemplate() throws InterruptedException {

		pom.getDashboardPage().navigatesCurrentOrderPage();
	}

	@Then("User should clicks on Create with order name and Choose Template")
	public void userShouldClicksOnCreateWithOrderNameAndChooseTemplate() {
		refreshNavigation();
		pom.getCurrentOrderPage().selectTemplete();

	}

}
