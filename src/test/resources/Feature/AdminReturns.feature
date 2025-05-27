@C2ReturnsAdmin
Feature: Mutual Drug Admin Returns Functionality

  Scenario Outline: Verifying Open C2 Returns Page Functionality
    Given User is on the Mutual Drug Login
    When User perform admin login with Username, Password
    Then User should verify after successful login success message as "Member Users"
    When User navigates to Administration Selects Returns, clicks C2 Returns and selects Open C2 Returns verifies the "Open C2 Returns"
    When User should filters the C2 returns by "<memberNumber>", "<assignee>", "<status>", "<startDate>", "<endDate>"
    Then The list should display C2 Returns with "<memberNumberFilter>"
    And User resets the filters by clicking the "Clear Filter" button
    When User filters the C2 Returns with Assignee "Purchasing" and Status "Submitted"
    Then User verifies list should display only C2 Returns with Assignee "Purchasing" and Status "Submitted"
    And User verifies Search for a Return by Return Name, DEA Number, Member
      | search             |
      | Testing Returns    |
      | RAFICHECK          |
      | AKERS PHARMACY INC |
    And User verifies that the sorting functionality in both ascending and descending Return Name, DEA Number, Member, Submitted Date, DEA Form#, Department, Assignee and Status
    When User Updates the C2 Returns "<updatesassignee>", "<updatesStatus>" with comments "Testing for Comments"
    And User should view the C2 Returns status history
    And User clicks upload icon to upload "<DEA Form #>" and upload file
    When User clicks Reutrn Name link navigates "Returns" page
    And User should view the returns status history
    And User Upload the DEA Form with "<DEAForm#>" with upload file
    And User verifies that the sorting functionality in both ascending and descending item#, Production Description, Expiration Date, Lot Number, Return Qty, Return Reason and RA#
    And User navigates through pages and verifies that pagination works correctly

    Examples: 
      | memberNumber | assignee   | status    | startDate  | endDate    | memberNumberFilter | updatesassignee | updatesStatus             | DEA Form # | DEAForm#  |
      |       121517 | Purchasing | Submitted | 25-04-2024 | 13-05-2025 |             124685 | Ryan Deese      | Closed - Product Received |  123345789 | 456788789 |
