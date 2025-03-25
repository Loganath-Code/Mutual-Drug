@BulkOrders
Feature: Verifying Mutual Drug Create Bulk orders

  Scenario Outline: Verifying Mutual Drug to Create new order - Products Catalog webpage
    Given User is on the Mutual Drug Login
    When User perform login with Username, Password
    Then User should verify after login "<selectYourCustomerAccount>" and success message as "C2 CERTIFICATE NOTIFICATION !!"
    Then User navigates Products, selects Durable Medical Equipment (DME) and verify the page "Product Catalog"
    When User select Full view and clicks Create New, Create New Order with "<orderName>" , "<orderType>" , "<autoSubmit>"
    Then User User verify the order added alert success message "Success!"
    Then User selects the order name as "12AB Sample test auto", enters the desired quantity, clicks the Add, and the system displays a confirmation message: "Success".
    And User navigates to the Product Catalog and selects the Over-the-Counter (OTC) category
    And User switches to the Compact view and filters the catalog to show only In-Stock items
    And User selects desired products, clicks Add, specifies the order name as "12AB Sample Test Auto", enters the desired quantity, and clicks Add to Order and success message as "Success".

    Examples: 
      | selectYourCustomerAccount             | orderName             | orderType     | autoSubmit |
      | WEB POS TEST STORE (PREMIER) - 009498 | 12AB Sample test auto | Regular Order | None       |
