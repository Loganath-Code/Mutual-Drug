package com.stepdefinition;

import com.base.BaseClass;
import com.pageManager.PageObjectManager;

import io.cucumber.java.en.*;

public class TC5_OrderStep extends BaseClass {

	PageObjectManager pom = new PageObjectManager();

	@Then("User selects the order name as {string}, enters the desired quantity, clicks the Add, and the system displays a confirmation message: {string}.")
	public void userSelectsTheOrderNameAsEntersTheDesiredQuantityClicksTheAddAndTheSystemDisplaysAConfirmationMessage(
			String ddOrderNames, String string2) {
		refreshNavigation();
		pom.getProductsCatalogPage().toogleOnInStockIems();
		pom.getProductsCatalogPage().multipleOrderCreation(ddOrderNames);

	}

	@Then("User navigates to the Product Catalog and selects the Over-the-Counter \\(OTC) category")
	public void userNavigatesToTheProductCatalogAndSelectsTheOverTheCounterOTCCategory() {

		pom.getProductsCatalogPage().navigatesOTC();
	}

	@Then("User switches to the Compact view and filters the catalog to show only In-Stock items")
	public void userSwitchesToTheCompactViewAndFiltersTheCatalogToShowOnlyInStockItems() {

		pom.getProductsCatalogPage().selectsCompactView();
		pom.getProductsCatalogPage().toogleOnInStockIems();
	}

	@Then("User selects desired products, clicks Add, specifies the order name as {string}, enters the desired quantity, and clicks Add to Order and success message as {string}.")
	public void userSelectsDesiredProductsClicksAddSpecifiesTheOrderNameAsEntersTheDesiredQuantityAndClicksAddToOrderAndSuccessMessageAs(
			String orderName, String string2) {
		pom.getProductsCatalogPage().addProduct(orderName);

	}
}
