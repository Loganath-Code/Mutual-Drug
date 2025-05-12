@BannerMetrics
Feature: Verifing Banner Metrics

  Scenario Outline: Verifies the Banners Metrics
    Given User is on the Mutual Drug Login
    When User perform admin login with Username, Password
    Then User should verify after successful login success message as "Member Users"
    Then User navigating to Administration, Banners, Banner Metrics should display the "Banner Metrics"
    When User enters valid member number "<memberNumber>" in the Member Number field
    When User enters valid banner name "<bennerName>" in the Banner Name field
    When User selects Start Date "<startDate>" and End Date "<endDate>"
    And User clicks the Filter button then Results should be displayed within the selected date range
    And User verifies that the sorting functionality in both ascending and descending Name, Description, Start Date, End Date, Created Date and Status
    And User navigates through pages and verifies that pagination works correctly

    Examples: 
      | memberNumber                       | bennerName | startDate  | endDate    |
      | 104059 - ALLCARE PHARMACY SERVICES | EZC PARK   | 12-11-2024 | 05-05-2025 |
