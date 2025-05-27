@404Foun
Feature: Validate 404 Page Not Found

  Scenario Outline: User navigates to a broken URL -Member
    Given User is on the Mutual Drug Login
    When User perform login with Username, Password
    Then User should verify after login "<selectYourCustomerAccount>" and success message as "Member Access Portal"
    And User should Read and Accept the Returns Policy Update
    Then User navigates to Orders, selects Current Orders and verifies that the page is "Current Orders"
    When User should navigates to non-existent page  "https://stage-orders.mutualdrug.com/orders/current-orders"
    Then User should see a "404" error page with the message "Please Contact Mutual Drug Administrator"
    When User clicks on Go Back redirected back to the "Current Orders" page

    Examples: 
      | selectYourCustomerAccount             |
      | WALKERS DRUG STORE (PREMIER) - 124685 |

  @Admin404
  Scenario Outline: User navigates to a broken URL - Admin
    Given User is on the Mutual Drug Login
    When User perform admin login with Username, Password
    Then User should verify after successful login success message as "Member Users"
    And User should navigates Member Details and verifies the title "Members"
    When User should navigates to non-existent page  "https://stage-orders.mutualdrug.com/members/details"
    Then User should see a "404" error page with the message "Please Contact Mutual Drug Administrator"
    When User clicks on Go Back redirected back to the admin "Member Users"  page
