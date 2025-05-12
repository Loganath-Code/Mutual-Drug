@Templates
Feature: Verifying Mutual Drug Order Templates

@Template
  Scenario Outline: Verifying Mutual Drug to Create new Template
    Given User is on the Mutual Drug Login
    When User perform login with Username, Password
    Then User should verify after login "<selectYourCustomerAccount>" and success message as "C2 CERTIFICATE NOTIFICATION !!"
    Then User navigates to Orders, selects Current Orders and verifies that the page is "Current Orders"
    When User clicks on  Create New, Create New Regular Orders with "<orderName>" , "<orderType>" , "<autoSubmit>" , "<orderReferance>"
    And User Adds the items/products using item number
      | itemsNum | specialCode | orderQty | successMessage               |
      |   285684 |             |        1 | Item #285684 added to order. |
    Then User clicks on Save As Template and see the alert message as "Order template saved."
    And User navigates back to Current Orders page Clicks on Create New and Use Template
    And User should clicks on Create with orders name and Choose Template

    Examples: 
      | selectYourCustomerAccount          | orderName             | orderType           | autoSubmit | orderReferance |
      | ALMANDS OAKWOOD (PREMIER) - 113407 | Test Regular Orders | Regular Order | None       | test           |

  @Order
  Scenario Outline: Verifying Mutual Drug to Create new Template
    Given User is on the Mutual Drug Login
    When User perform login with Username, Password
    Then User should verify after login "<selectYourCustomerAccount>" and success message as "C2 CERTIFICATE NOTIFICATION !!"
    Then User navigates to Orders, selects Current Orders and verifies that the page is "Current Orders"
    When User clicks on  Create New, Create New Regular Orders with "<orderName>" , "<orderType>" , "<autoSubmit>" , "<orderReferance>"
    And User searches for a Orders Name "Test Regular Orders" and verifies that the grid displays the Order name is "Test Regular Orders"
    And User verifies sorting order in both ascending and descending order for all columns OrderName, Status, Created Date, Order Type, Total lines, Total pieces and Ext.Inv.Price
    And User verifies pagination functionality on the Orders
    Then User deletes the Order name and verifies the success alert message "Order details deleted."
    And User should clicks View Order Templates and verifies that the page is "Order Templates"
    And User search for Template name "sample test order New" verifies that the grid displays the Template name is "sample test order New"
    And User verifies sorting Templates in both ascending and descending order for all columns Templates, Created date, Order Type and Total lines
    Then User deletes the template name and verifies the success alert message "Template deleted successfully!"
    And User verifies pagination functionality on the Orders Templates Web Page

    Examples: 
      | selectYourCustomerAccount             | orderName             | orderType     | autoSubmit | orderReferance |
      | WALKERS DRUG STORE (PREMIER) - 124685 | Test Regular Orders | Regular Order | None       | test           |
