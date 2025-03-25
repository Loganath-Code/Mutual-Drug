package com.stepdefinition;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebElement;

import com.base.BaseClass;
import com.pageManager.PageObjectManager;

import io.cucumber.java.en.*;

public class TC3_ProductOrderNotificationStep extends BaseClass {
	PageObjectManager pom = new PageObjectManager();

	/**
	 * @see Used to navigates Notification webpage
	 * @param expectedtitle
	 */
	@Then("User should navigates to Notification list and verifies that the page is {string}")
	public void userShouldNavigatesToNotificationListAndVerifiesThatThePageIs(String expectedtitle) {
		pom.getDashboardPage().navigatesNotifications();
		WebElement textNotifications = pom.getNotificationPage().getTextNotifications();
		assertEquals(textNotifications, expectedtitle);

	}

	/**
	 * @see Used to create new Notification group
	 * @param dataTable
	 */
	@Then("User clicks on Create Notification Group to Create New Notification Group")
	public void userClicksOnCreateNotificationGroupToCreateNewNotificationGroup(
			io.cucumber.datatable.DataTable dataTable) {

		List<Map<String, String>> itemsData = dataTable.asMaps();

		for (Map<String, String> item : itemsData) {
			String groupName = item.get("groupName");
			String groupType = item.get("groupType");
			String successMessage = item.get("successMessage");
			pom.getNotificationPage().createNotificationGroup(groupName, groupType, successMessage);

		}
	}

	@Then("User performs a search {string} and verifies the correct search results")
	public void userPerformsASearchAndVerifiesTheCorrectSearchResults(String notificationGroupName)
			throws InterruptedException {

		pom.getNotificationPage().searchNotificationGroup(notificationGroupName);
		WebElement tdFirstCell = pom.getNotificationPage().getTdFirstCell();
		String text = getText(tdFirstCell);
		System.out.println(text);clickElementUsingJavaScript(driver, tdFirstCell);

	}

	@Then("User performs sorts by group name and group type in both ascending and descending order")
	public void userPerformsSortsByGroupNameAndGroupTypeInBothAscendingAndDescendingOrder() {
		pom.getNotificationPage().sorting();
	}

	@Then("User deletes the Notification Group and see the message {string}")
	public void userDeletesTheNotificationGroupAndSeeTheMessage(String deleteMessage) {

		pom.getNotificationPage().deleteNotificationGroup();
		WebElement alertMsgDeleteNotificationGroup = pom.getNotificationPage().getAlertMsgDeleteNotificationGroup();
		assertEquals(alertMsgDeleteNotificationGroup, deleteMessage);
	}

	@Then("User performs pagination to navigate between pages and verifies the results on each page")
	public void userPerformsPaginationToNavigateBetweenPagesAndVerifiesTheResultsOnEachPage()
			throws InterruptedException {
		pom.getNotificationPage().pagination();
	}

	/**
	 * @see Used to select Notification name and perform global search in
	 *      Notification group webpage
	 * @param groupName
	 * @param globalSearch
	 */
	@Then("User should selects {string} Notification group name, search products using global search {string}")
	public void userShouldSelectsNotificationGroupNameSearchProductsUsingGlobalSearch(String groupName,
			String globalSearch) {

		pom.getNotificationPage().notificationlistNameClick(groupName);
		pom.getNotificationPage().globalSearch(globalSearch);

	}

	@Then("User searches for products with zero warehouse quantity and clicks on Notify Me, inserting details via the Notify Me form:")
	public void userSearchesForProductsWithZeroWarehouseQuantityAndClicksOnNotifyMeInsertingDetailsViaTheNotifyMeForm(
			io.cucumber.datatable.DataTable dataTable) {

		List<Map<String, String>> itemsData = dataTable.asMaps();

		for (Map<String, String> item : itemsData) {
			String globalSearchitem = item.get("globalSearchitem");
			String chooseNotificationGroup = item.get("chooseNotificationGroup");
			String email = item.get("email");
			String phoneNo = item.get("phoneNo");
			String alertMessage = item.get("alertMessage");
			pom.getProductDetailPage().notifyMe(globalSearchitem, chooseNotificationGroup, email, phoneNo,
					alertMessage);
		}
	}

	@When("User should navigates to Notification list and search by notification group name {string}")
	public void userShouldNavigatesToNotificationListAndSearchByNotificationGroupName(String notificationGroupName)
			throws InterruptedException {
		pom.getDashboardPage().navigatesNotifications();
		pom.getNotificationPage().searchNotificationGroup(notificationGroupName);

	}

	@Then("User Update the Notification Group Name {string} and verify the alert message {string}")
	public void userUpdateTheNotificationGroupNameAndVerifyTheAlertMessage(String updateName, String expectedMessage) {
		pom.getNotificationPage().updatenotificationGroupName(updateName);
		WebElement alertMsgUpdateGrpName = pom.getNotificationPage().getAlertMsgUpdateGrpName();
		assertEquals(alertMsgUpdateGrpName, expectedMessage);

	}

	@Then("User should update the email and phone number, click on Update All, and verify the alert message {string}")
	public void userShouldUpdateTheEmailAndPhoneNumberClickOnUpdateAllAndVerifyTheAlertMessage(String expectedMessage) {
		pom.getNotificationPage().updateEmailPh();
		WebElement alertMessageUpdateEmailPhNo = pom.getNotificationPage().getAlertMessageUpdateEmailPhNo();
		assertEquals(alertMessageUpdateEmailPhNo, expectedMessage);
	}

	@Then("User deletes the notification item and see the message {string}")
	public void userDeletesTheNotificationItemAndSeeTheMessage(String deleteMessage) {
		pom.getNotificationPage().deleteNotificationItem();
		WebElement alertMessageDeleteItem = pom.getNotificationPage().getAlertMessageDeleteItem();
		assertEquals(alertMessageDeleteItem, deleteMessage);

	}

	@When("User clicks on the Create Notification Group button without entering any information and then clicks on Create")
	public void userClicksOnTheCreateNotificationGroupButtonWithoutEnteringAnyInformationAndThenClicksOnCreate() {

		pom.getNotificationPage().emptyFieldsCreateNotificationGroupCreations();
	}

	@Then("User should verify the error message {string} , {string}.")
	public void userShouldVerifyTheErrorMessage(String groupNameErrorMessage, String groupTypeErrorMessage) {

		WebElement errorMessageGroupName = pom.getNotificationPage().getErrorMessageGroupName();
		assertEquals(errorMessageGroupName, groupNameErrorMessage);
		WebElement errorMessageGroupType = pom.getNotificationPage().getErrorMessageGroupType();
		assertEquals(errorMessageGroupType, groupTypeErrorMessage);
	}

	@Then("User searches {string} products with zero warehouse quantity and clicks on Notify Me")
	public void userSearchesProductsWithZeroWarehouseQuantityAndClicksOnNotifyMe(String globalSearch) {

		pom.getNotificationPage().globalSearch(globalSearch);

	}

	@Then("User without enting any fields clicks NotifyMe and verify the error message {string} , {string}")
	public void userWithoutEntingAnyFieldsClicksNotifyMeAndVerifyTheErrorMessage(
			String expectedErrorMessageDdNotificationGroup, String expectedErrorMessageEmail)
			throws InterruptedException {
		pom.getProductDetailPage().emptyFieldsitemsAddinNotificationGroup();
		WebElement errorMessageDdNotificationGroup = pom.getNotificationPage().getErrorMessageDdNotificationGroup();
		assertEquals(errorMessageDdNotificationGroup, expectedErrorMessageDdNotificationGroup);
		WebElement errorMessageEmail = pom.getNotificationPage().getErrorMessageEmail();
		assertEquals(errorMessageEmail, expectedErrorMessageEmail);
	}

	@Then("User Entring invalid email verify the error message {string}")
	public void userEntringInvalidEmailVerifyTheErrorMessage(String expectedErrorMessageInvalidEmail) {
		pom.getProductDetailPage().insertInvalidMail();
		WebElement errorMessageInvalidEmail = pom.getNotificationPage().getErrorMessageInvalidEmail();
		assertEquals(errorMessageInvalidEmail, expectedErrorMessageInvalidEmail);
	}

	@Then("User Entring invalid Phone number verify the error message {string}")
	public void userEntringInvalidPhoneNumberVerifyTheErrorMessage(String string) {
		pom.getProductDetailPage().insertInvalidPhNo();
		WebElement errorMessageInvalidPhoneNo = pom.getNotificationPage().getErrorMessageInvalidPhoneNo();
		assertEquals(errorMessageInvalidPhoneNo, string);
	}

	@Then("User tries to create a notification group with a special character in the group name, {string} group type  then verify the error message {string}")
	public void userTriesToCreateANotificationGroupWithASpecialCharacterInTheGroupNameGroupTypeThenVerifyTheErrorMessage(
			String groupType, String expectedErrorMessage) {
		pom.getNotificationPage().notificationGroupNameWithSpecialChar(groupType);
		WebElement errorMessageGroupNameSpecialChar = pom.getNotificationPage().getErrorMessageGroupNameSpecialChar();
		assertEquals(errorMessageGroupNameSpecialChar, expectedErrorMessage);

	}

	@Then("User provides Single space in Group Name with {string} group type and tries to create a Notification Group then  verify the error message {string}")
	public void userProvidesSingleSpaceInGroupNameWithGroupTypeAndTriesToCreateANotificationGroupThenVerifyTheErrorMessage(
			String groupType, String expectedErrorMessage) {
		pom.getNotificationPage().notificationGroupNameWithSpace(groupType);
		WebElement errorMessageGroupName = pom.getNotificationPage().getErrorMessageGroupName();
		assertEquals(errorMessageGroupName, expectedErrorMessage);
	}
}
