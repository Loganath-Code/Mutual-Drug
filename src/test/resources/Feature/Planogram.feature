@Planogram
Feature: Verifying Mutual Drug Admin Planogram Webpage

  Scenario Outline: Verifying Mutual Drug Planogram Webpage
    Given User is on the Mutual Drug Login
    When User perform admin login with Username, Password
    Then User should verify after successful login success message as "Member Users"
    Then User navigates to Administration selects Planograms, verifies the page title should be "Planograms"
    Then User should verifies to clicks on Add Planogram navigates through the "Add Planogram"
    When User should submit the details with "<name>", "<description>" and to upload file
    Then User clicks on "Save" the new planogram should be listed on the Planograms page with the correct "Created Date"
    When User searches for "<searchPlanogram>" using the search bar then matching results should be displayed:
      | searchPlanogram    |
      | Test Planogram Dec |
      | Planogram Demo     |
      | 09/07/2023         |
    And User verifies that the sorting functionality in both ascending and descending Name, Description and Created date
    When User clicks on the Planogram Name link, the "Edit Planogram" form with prefilled values should be displayed
    When User updates the Name to "<updateName>", the Description to "<updateDescription>", and optionally uploads a new file
    And clicks "Update" the updated details should reflect in the listing
    When User clicks the PDF icon in the Action column, the planogram document should open in a new tab
    When User deletes the planogram and confirms, it should be removed from the list and display "Planogram deleted."
    And User navigates through pages and verifies that pagination works correctly

    Examples: 
      | name               | description                      | updateName | updateDescription                                |
      | Automation Testing | Created for Testing Purpose Only | Auto Test  | Planogram Created for Automation Testing Purpose |

  @PlanogramNegativeTest
  Scenario Outline: Verifying Mutual Drug Planogram Negative Test
    Given User is on the Mutual Drug Login
    When User perform admin login with Username, Password
    Then User should verify after successful login success message as "Member Users"
    Then User navigates to Administration selects Planograms, verifies the page title should be "Planograms"
    Then User should verifies to clicks on Add Planogram navigates through the "Add Planogram"
    Then User clicks the "Save" button without entering any planogram details
    Then User verifies that the error messages "Name is required ", "File is required " and "Description is required " is displayed
