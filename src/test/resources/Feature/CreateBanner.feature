@CreateBanner
Feature: Verifing Banner Management

  Scenario Outline: Verifies Create New Banner Functionality
    Given User is on the Mutual Drug Login
    When User perform admin login with Username, Password
    Then User should verify after successful login success message as "Member Users"
    Then User navigating to Administration, Banners, Create Banner should display the "Banners"
    Then User should verifies to clicks on Add Banner navigates through the "Add Banner" form is displayed
    And User should enters "<name>" into the Name field
    And User sets Start Date to "<startDate>" and End Date to "<endDate>"
    And User should enters "<url>" into the URL field
    And User sets Open New Tab to "<openNewTab>" and Banner Lock to "<bannerLock>"
    And User should enters "<description>" into the Description field and uploads the image File
    Then User clicks "Save" and the banner list should show "Automation Testing" with the updated description
    Then the user searches for banner details using the following queries and verifies the correct banner results are displayed:
      | searchBanners          |
      | Aveeno Active Naturals |
      | Testing Purpose        |
      | 08/27/2024             |
      | 04/30/2025             |
    And User verifies that the sorting functionality in both ascending and descending Name, Description, Start Date, End Date, Created Date and Status
    When User clicks on the Banner Name link, the "Edit Banner" form with prefilled values should be displayed
    And User should enters "<updateName>" into the Name field
    And User sets Start Date to "<updateStartDate>" and End Date to "<updateEndDate>"
    And User should enters "<updateurl>" into the URL field
    And User sets Open New Tab to "<updateopenNewTab>" and Banner Lock to "<updateBannerLock>"
    And User should enters "<updatedescription>" into the Description field and uploads the image File
    And User clicks "Update" and the banner list should show "Automation Testing -1" with the updated Banner description
    When User deletes the Banner and confirms, it should be removed from the list and display "Banner deleted."
    And User navigates through pages and verifies that pagination works correctly

    Examples: 
      | name               | startDate  | endDate    | url                                          | openNewTab | bannerLock | description     | updateName           | updateStartDate | updateEndDate | updateurl                                    | updateopenNewTab | updateBannerLock | updatedescription |
      | Automation Testing | 20-05-2025 | 22-05-2025 | http://www.testingmcafeesites.com/index.html | Yes        | Unlocked   | Testing Purpose | Automation Testing-1 | 22-05-2025      | 30-05-2025    | http://www.testingmcafeesites.com/index.html | No               | Unlocked         | Testing           |

  Scenario Outline: Verifies Create New Banner Negative test
    Given User is on the Mutual Drug Login
    When User perform admin login with Username, Password
    Then User should verify after successful login success message as "Member Users"
    Then User navigating to Administration, Banners, Create Banner should display the "Banners"
    Then User should verifies to clicks on Add Banner navigates through the "Add Banner" form is displayed
    Then User clicks the "Save" button without entering any Benner details
    Then User verifies that the error messages "Name is required" and "Image is required" are displayed
