@AdminMemberUserRoles
Feature: Verifying Admin Roles webpage

  Scenario Outline: Verifying Admin Member Roles Webpage
    Given User is on the Mutual Drug Login
    When User perform admin login with Username, Password
    Then User should verify after successful login success message as "Member Users"
    And User should navigates Member Roles and verifies the title "Member User Roles"
    When User should clicks on Add New to add new roles "<name>" with permissions
    And User searches using Name "<searchMemberUserRoles>" and verifies that the grid displays the search result for "<searchMemberUserRoles>"
      | searchMemberUserRoles |
      | Auto Testing          |
    When User clicks on the Name link to edit roles "Test-Roles" and updates the role details
    And User verifies that the sorting functionality in both ascending and descending Name and Created date
    And User navigates through pages and verifies that pagination works correctly

    Examples: 
      | name         |
      | Auto Testing |

  @memberRolesNegative
  Scenario: Verifying Admin Member Roles Negative Test
    Given User is on the Mutual Drug Login
    When User perform admin login with Username, Password
    Then User should verify after successful login success message as "Member Users"
    And User should navigates Member Roles and verifies the title "Member User Roles"
    Then User should attempt to submit the form without entering a Role Name and verify that an error message "Role Name is required" displayed
    Then User submitting a role without selecting any permissions should display the error "Permissions are required!!"
