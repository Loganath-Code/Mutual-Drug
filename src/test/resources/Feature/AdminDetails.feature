@MembersDetails
Feature: Verifying Admin Members Details webpage

  Scenario Outline: Verifying Admin Members Details Webpage
    Given User is on the Mutual Drug Login
    When User perform admin login with Username, Password
    Then User should verify after successful login success message as "Member Users"
    And User should navigates Member Details and verifies the title "Members"
    And User searches using Member Number or Name "<searchMembers>" and verifies that the grid displays the search result for "<searchMembers>"
      | searchMembers                 |
      | AVANT PHCY AND WELL CCHC 340B |
      |                        123885 |
    And User verifies that the sorting functionality in both ascending and descending orders for Name and Member Number
    And User clicks on the Member Number to view member details
    And User navigates through pages and verifies that pagination works correctly
    Then User selects the Rx Purchase chart checkbox for visible member accounts and verifies the success message as "Invoice Chart status has been updated."
    And User clicks the logout button and verify successfully redirected to the login page
    When User perform login with Username, Password
    Then User should verify after login "<selectYourCustomerAccount>" and success message as "C2 CERTIFICATE NOTIFICATION !!"
    And User should clicks to Rx Does Chart navigates "Rx Chart - Daily Status"
    And User verifies whether the Rx Purchase chart is displayed

    Examples: 
      | selectYourCustomerAccount                       |
      | ABERDEEN PRESCRIPTION SHOPPE (PREMIER) - 106237 |
