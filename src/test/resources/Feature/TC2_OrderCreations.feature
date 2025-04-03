@Current
Feature: Verifying Mutual Drug current orders- Create New order

  Scenario Outline: Verifying Mutual Drug to Create new order in Current Order webpage - Regular order
    Given User is on the Mutual Drug Login
    When User perform login with Username, Password
    Then User should verify after login "<selectYourCustomerAccount>" and success message as "C2 CERTIFICATE NOTIFICATION !!"
    Then User navigates to Orders, selects Current Orders and verifies that the page is "Current Orders"
    When User clicks on  Create New, Create New Regular Order with "<orderName>" , "<orderType>" , "<autoSubmit>" , "<orderReferance>"
    And User Adds the items/products using item number
      | itemsNum | specialCode | orderQty | successMessage               |
      |   285684 |             |        1 | Item #285684 added to order. |
      |   485136 |             |        1 | Item #485136 added to order. |
    And User Adds products Using NDC/UPC/GTIN and clicks Add To Order
      | NDC         | addQuantity | successMessage               |
      | 30536105775 |           1 | Item #181560 added to order. |
      | 03848591161 |           1 | Item #142505 added to order. |
    And User can change Order Name as "Regular order Automation Test" then  verifying the alert message "Order name updated."
    And User verifies sorting order in both ascending and descending order for items, Product Discriptions
    And User updates item quantities and special codes in the grid verifies the "Success!" alert message
    Then User deletes an order from the Grid verifies the "Success!" alert message
    And User verifies pagination functionality on the Orders Web Page
    And User submits the regular order and clicks OK

    @RegularOrder
    Examples: 
      | selectYourCustomerAccount          | orderName             | orderType     | autoSubmit | orderReferance |
      | ALMANDS OAKWOOD (PREMIER) - 113407 | sample test order New | Regular Order | None       | test           |

  Scenario Outline: Verifying Mutual Drug to Create new order in Current Order webpage - C2 order creation
    Given User is on the Mutual Drug Login
    When User perform login with Username, Password
    Then User should verify after login "<selectYourCustomerAccount>" and success message as "C2 CERTIFICATE NOTIFICATION !!"
    Then User navigates to Orders, selects Current Orders and verifies that the page is "Current Orders"
    When User clicks Create New, Create New C2 Order with "<orderName>" , "<orderType>"
    And User Adds the items/products using item number
      | itemsNum | specialCode | orderQty | successMessage               |
      |   046425 |             |        1 | Item #046425 added to order. |
      |   112474 |             |        1 | Item #112474 added to order. |
    And User Adds products Using NDC/UPC/GTIN and clicks Add To Order
      | NDC         | addQuantity | successMessage               |
      | 00527076537 |           1 | Item #475277 added to order. |
    And User can change Order Name as "C2 order Automation Test" then  verifying the alert message "Order name updated."
    And User verifies sorting order in both ascending and descending order for items, Product Discriptions
    And User updates item quantities and special codes in the grid verifies the "Success!" alert message
    Then User deletes an order from the Grid verifies the "Success!" alert message
    And User verifies pagination functionality on the Orders Web Page
    And User clicks "Sign&Submit" to submit the order
    And User enters store password "<storePassword>" and clicks Sign
    Then User verifies the order submission with alert message "<c2_OrderSuccessMessage>"

    @c2order
    Examples: 
      | selectYourCustomerAccount             | orderName                | orderType | storePassword   | c2_OrderSuccessMessage                                                                     |
      | WEB POS TEST STORE (PREMIER) - 009498 | sample test C2 order New | C2 Order  | Datacaliper@123 | Thank you, your CSOS order (sample test orderNew) was successfully signed and transmitted. |

  @ProductCatalog
  Scenario Outline: Verifying Mutual Drug to Create new order - Products Catalog webpage
    Given User is on the Mutual Drug Login
    When User perform login with Username, Password
    Then User should verify after login "<selectYourCustomerAccount>" and success message as "C2 CERTIFICATE NOTIFICATION !!"
    Then User navigates Products, selects Durable Medical Equipment (DME) and verify the page "Product Catalog"
    When User select Full view and clicks Create New, Create New Order with "<orderName>" , "<orderType>" , "<autoSubmit>"
    Then User User verify the order added alert success message "Success!"

    Examples: 
      | selectYourCustomerAccount          | orderName             | orderType     | autoSubmit |
      | ALMANDS OAKWOOD (PREMIER) - 113407 | sample test order New | Regular Order | 6 PM       |

  @ProductCatalog_compactview
  Scenario Outline: Verifying Mutual Drug to Create new order - Products Catalog webpage
    Given User is on the Mutual Drug Login
    When User perform login with Username, Password
    Then User should verify after login "<selectYourCustomerAccount>" and success message as "C2 CERTIFICATE NOTIFICATION !!"
    Then User navigates Products, selects Durable Medical Equipment (DME) and verify the page "Product Catalog"
    When User select Compact view and clicks Create New, Create New Order with "<orderName>" , "<orderType>" , "<autoSubmit>"
    Then User User verify the order added alert success message "Success!"

    Examples: 
      | selectYourCustomerAccount               | orderName            | orderType     | autoSubmit |
      | THOMAS DRUG STORE-WILSON (PRO) - 005827 | sample test orderNew | Regular Order | 6 PM       |

  @GlobalSearch
  Scenario Outline: Verifying Mutual Drug to Create new order - product search Webpage
    Given User is on the Mutual Drug Login
    When User perform login with Username, Password
    Then User should verify after login "<selectYourCustomerAccount>" and success message as "C2 CERTIFICATE NOTIFICATION !!"
    Then User navigates to Orders, selects Current Orders and verifies that the page is "Current Orders"
    And User performs global search for "<globalSearch>" to create a new regular order
    And User clicks on Create New Order with "<orderName>" , "<autoSubmit>" and verifies the success message "Success!"

    Examples: 
      | selectYourCustomerAccount             | globalSearch | orderName            | autoSubmit |
      | WEB POS TEST STORE (PREMIER) - 009498 | lotion       | sample test orderNew | 6 PM       |

  @productdetail
  Scenario Outline: Verifying Mutual Drug to Create new order - product detail page Webpage
    Given User is on the Mutual Drug Login
    When User perform login with Username, Password
    Then User should verify after login "<selectYourCustomerAccount>" and success message as "C2 CERTIFICATE NOTIFICATION !!"
    Then User navigates to Orders, selects Current Orders and verifies that the page is "Current Orders"
    And User performs global search for "<globalSearch>" to create a new regular order
    And User clicks on Create New Order with "<orderName>" , "<autoSubmit>" and verifies the success message "Success!"

    Examples: 
      | selectYourCustomerAccount             | globalSearch | orderName            | autoSubmit |
      | WEB POS TEST STORE (PREMIER) - 009498 |       285684 | sample test orderNew | 6 PM       |

  @SuggestedProducts
  Scenario Outline: Verifying Mutual Drug to Create new order - Suggested Products list
    Given User is on the Mutual Drug Login
    When User perform login with Username, Password
    Then User should verify after login "<selectYourCustomerAccount>" and success message as "C2 CERTIFICATE NOTIFICATION !!"
    Then User navigates to Orders, selects Current Orders and verifies that the page is "Current Orders"
    And User performs global search for "<globalSearch>" to create a new regular order
    Then User should Create New Regular Order in Suggested Products list with "<orderName>" , "<autoSubmit>" and verifies the success message "Success!"

    Examples: 
      | selectYourCustomerAccount             | globalSearch | orderName               | autoSubmit |
      | WEB POS TEST STORE (PREMIER) - 009498 |       143487 | sample testing orderNew | 6 PM       |

  @CaseItemsOrder
  Scenario Outline: Verifying Mutual Drug to Create new order - Case Items Order
    Given User is on the Mutual Drug Login
    When User perform login with Username, Password
    Then User should verify after login "<selectYourCustomerAccount>" and success message as "C2 CERTIFICATE NOTIFICATION !!"
    Then User navigates to Orders, selects Current Orders and verifies that the page is "Current Orders"
    And User performs global search for "<globalSearch>" to create a new regular order
    And User clicks on Create New Order, clicks YES for Case Item order and enters "<orderName>" and "<autoSubmit>" and verifies the success message "Success!"

    Examples: 
      | selectYourCustomerAccount             | globalSearch | orderName               | autoSubmit |
      | WEB POS TEST STORE (PREMIER) - 009498 |       324376 | sample testing orderNew | 6 PM       |

  @Notificationlist
  Scenario Outline: Verifying Mutual Drug to Create new order - Suggested Products list
    Given User is on the Mutual Drug Login
    When User perform login with Username, Password
    Then User should verify after login "<selectYourCustomerAccount>" and success message as "C2 CERTIFICATE NOTIFICATION !!"
    Then User should navigates to Notification list and verifies that the page is "Notifications"
    And User clicks on Create Notification Group to Create New Notification Group
      | groupName                     | groupType     | successMessage              |
      | Sample Test Regular Notify me | Regular Order | Notification Group Created. |
      | Sample test c2- Notify Me     | C2 Order      | Notification Group Created. |
    And User should selects "Sample Test Regular Notify me" Notification group name, search products using global search "<globalSearch>"
    Then User Clicks Create New Regular Order with "<orderName>" , "<autoSubmit>" and verifies the success message "Product added to order."

    Examples: 
      | selectYourCustomerAccount             | globalSearch | orderName               | autoSubmit |
      | WEB POS TEST STORE (PREMIER) - 009498 |       485136 | sample testing orderNew | None       |

  @Template
  Scenario Outline: Verifying Mutual Drug to Create new Template
    Given User is on the Mutual Drug Login
    When User perform login with Username, Password
    Then User should verify after login "<selectYourCustomerAccount>" and success message as "C2 CERTIFICATE NOTIFICATION !!"
    Then User navigates to Orders, selects Current Orders and verifies that the page is "Current Orders"
    When User clicks on  Create New, Create New Regular Order with "<orderName>" , "<orderType>" , "<autoSubmit>" , "<orderReferance>"
    And User Adds the items/products using item number
      | itemsNum | specialCode | orderQty | successMessage               |
      |   285684 |             |        1 | Item #285684 added to order. |
    Then User clicks on Save As Template and see the alert message as "Order template saved."
    And User navigates back to Current Order page Clicks on Create New and Use Template
    And User should clicks on Create with order name and Choose Template

    Examples: 
      | selectYourCustomerAccount          | orderName             | orderType     | autoSubmit | orderReferance |
      | ALMANDS OAKWOOD (PREMIER) - 113407 | sample test order New | Regular Order | None       | test           |

  @Order
  Scenario Outline: Verifying Mutual Drug to Create new Template
    Given User is on the Mutual Drug Login
    When User perform login with Username, Password
    Then User should verify after login "<selectYourCustomerAccount>" and success message as "C2 CERTIFICATE NOTIFICATION !!"
    Then User navigates to Orders, selects Current Orders and verifies that the page is "Current Orders"
    When User clicks on  Create New, Create New Regular Order with "<orderName>" , "<orderType>" , "<autoSubmit>" , "<orderReferance>"
    And User searches for a Order Name "sample test order New" and verifies that the grid displays the Order name is "sample test order New"
    And User verifies sorting order in both ascending and descending order for all columns OrderName, Status, Created Date, Order Type, Total lines, Total pieces and Ext.Inv.Price
    And User verifies pagination functionality on the Orders
    Then User deletes the Order name and verifies the success alert message "Order details deleted."
    And User should clicks View Order Templates and verifies that the page is "Order Templates"
    And User search for Template name "sample test order New" verifies that the grid displays the Template name is "sample test order New"
    And User verifies sorting Templates in both ascending and descending order for all columns Templates, Created date, Order Type and Total lines
    Then User deletes the template name and verifies the success alert message "Template deleted successfully!"
    And User verifies pagination functionality on the Order Templates Web Page

    Examples: 
      | selectYourCustomerAccount             | orderName             | orderType     | autoSubmit | orderReferance |
      | WALKERS DRUG STORE (PREMIER) - 124685 | sample test order New | Regular Order | None       | test           |

  @negative
  Scenario Outline: Verifying Mutual Drug to Create new order - Negative Scenario
    Given User is on the Mutual Drug Login
    When User perform login with Username, Password
    Then User should verify after login "<selectYourCustomerAccount>" and success message as "C2 CERTIFICATE NOTIFICATION !!"
    Then User navigates to Orders, selects Current Orders and verifies that the page is "Current Orders"
    When User clicks on Create New without entering any details and clicks Create
    Then User should verifies the error messages: "Order Name is required" and "Order Type is required"
    Then User provides Space in Order Name with "Regular Order" order type and tries to create an Order then see the error message "Order Name is required"
    Then User enter order name with special characters with "Regular Order" order type and tries to create an Order and should see the error message "Special characters not allowed"
    And User should clicks on Use a Template and entering without anut details and clicks Create
    Then User should validate the error message "Order Name is required" , "Template is required"

    Examples: 
      | selectYourCustomerAccount             |
      | WALKERS DRUG STORE (PREMIER) - 124685 |

  @negativeRegular
  Scenario Outline: Verifying Mutual Drug to Create new order in Current Order webpage - Regular order negative Scenarios
    Given User is on the Mutual Drug Login
    When User perform login with Username, Password
    Then User should verify after login "<selectYourCustomerAccount>" and success message as "C2 CERTIFICATE NOTIFICATION !!"
    Then User navigates to Orders, selects Current Orders and verifies that the page is "Current Orders"
    When User clicks on  Create New, Create New Regular Order with "<orderName>" , "<orderType>" , "<autoSubmit>" , "<orderReferance>"
    Then User attempts to add an item without an item number and verifies the warning message "Item code is required."
    Then User adds an item "285684" with a quantity of "0" and verifies the warning message "Min allowed order qty is 1."
    And User Adds the items/products using item number
      | itemsNum | specialCode | orderQty | successMessage               |
      |   485136 |             |        1 | Item #485136 added to order. |
    Then User attempts to add the same item "485136" again and verifies the warning message "Item already added to order."
    Then User attempts to add C2 items "112474" in Regular order and verifies the alert message "Cannot add C2 item to non C2 order."
    Then User should updates the order quantity to "0" and verifies the warning message "Min allowed order qty is 1."

    Examples: 
      | selectYourCustomerAccount             | orderName             | orderType     | autoSubmit | orderReferance |
      | WALKERS DRUG STORE (PREMIER) - 124685 | sample test order New | Regular Order | None       | test           |

  @C2Negative
  Scenario Outline: Verifying Mutual Drug to Create new order in Current Order webpage - Regular order negative Scenarios
    Given User is on the Mutual Drug Login
    When User perform login with Username, Password
    Then User should verify after login "<selectYourCustomerAccount>" and success message as "C2 CERTIFICATE NOTIFICATION !!"
    Then User navigates to Orders, selects Current Orders and verifies that the page is "Current Orders"
    When User clicks Create New, Create New C2 Order with "<orderName>" , "<orderType>"
    Then User attempts to add an item without an item number and verifies the warning message "Item code is required."
    Then User adds an item "112474" with a quantity of "0" and verifies the warning message "Min allowed order qty is 1."
    And User Adds the items/products using item number
      | itemsNum | specialCode | orderQty | successMessage               |
      |   046425 |             |        1 | Item #046425 added to order. |
    Then User attempts to add the same item "046425" again and verifies the warning message "Item already added to order."
    Then User attempts to add Regular items "485136" in c2 order and verifies the alert message "Cannot add non C2 item to C2 order."
    Then User should updates the order quantity to "0" and verifies the warning message "Min allowed order qty is 1."

    Examples: 
      | selectYourCustomerAccount             | orderName                | orderType | storePassword   | c2_OrderSuccessMessage                                                                     |
      | WEB POS TEST STORE (PREMIER) - 009498 | sample test C2 order New | C2 Order  | Datacaliper@123 | Thank you, your CSOS order (sample test orderNew) was successfully signed and transmitted. |
