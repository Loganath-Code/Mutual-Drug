@Current
Feature: Verifying Mutual Drug - Create New orders

  @CurrentOrderPage
  Scenario Outline: Verifying Mutual Drug Current Order Webpage
    Given User is on the Mutual Drug Login
    When User perform login with Username, Password
    Then User should verify after login "<selectYourCustomerAccount>" and success message as "C2 CERTIFICATE NOTIFICATION !!"
    Then User navigates to Orders, selects Current Orders and verifies that the page is "Current Orders"
    When User clicks on  Create New, Create New Regular Orders with "<orderName>" , "<orderType>" , "<autoSubmit>" , "<orderReferance>"
    And User removes the Order name and navigates back to the Current Order page
    And User searches for a Order name "Test Regular Orders" and verifies that the grid displays the Order name is "Test Regular Orders"
    And User verifies sorting order in both ascending and descending current orders for all columns Order Name, Status, Created Date, Order Type, Total Lines, Total Pieces and Ext.Inv. Price
    Then User deletes an order from the current order list and verifies the "Order details deleted." alert message
    And User verifies pagination functionality on the current order page

    Examples: 
      | selectYourCustomerAccount             | orderName           | orderType     | autoSubmit | orderReferance |
      | WALKERS DRUG STORE (PREMIER) - 124685 | Test Regular Orders | Regular Order | None       | test           |

  Scenario Outline: Verifying Mutual Drug to Create new orders in Current Orders webpage - Regular orders
    Given User is on the Mutual Drug Login
    When User perform login with Username, Password
    Then User should verify after login "<selectYourCustomerAccount>" and success message as "Member Access Portal"
    Then User navigates to Orders, selects Current Orders and verifies that the page is "Current Orders"
    When User clicks on  Create New, Create New Regular Orders with "<orderName>" , "<orderType>" , "<autoSubmit>" , "<orderReferance>"
    And User Adds the items/products using item number
      | itemsNum | specialCode                   | orderQty | successMessage               |
      |   285684 |                               |        1 | Item #285684 added to order. |
      |   485136 | Shelf Label Only              |        1 | Item #485136 added to order. |
      |   407585 | Price Sticker Only            |        1 | Item #407585 added to order. |
      |   492892 | Shelf Label and Price Sticker |        1 | Item #492892 added to order. |
      |   486944 | Override Qty Cut              |        1 | Item #486944 added to order. |
      |   218693 | Do Not Substitute             |        1 | Item #218693 added to order. |
      |   371385 | Do Not Substitute             |        1 | Item #371385 added to order. |
      |   306092 | Do Not Substitute             |        1 | Item #306092 added to order. |
      |   489674 | Do Not Substitute             |        1 | Item #489674 added to order. |
      |   865543 | Do Not Substitute             |        1 | Item #865543 added to order. |
      |   745877 | Do Not Substitute             |        1 | Item #745877 added to order. |
      |   349449 | Do Not Substitute             |        1 | Item #349449 added to order. |
      |   210351 | Do Not Substitute             |        1 | Item #210351 added to order. |
      |   015156 | Do Not Substitute             |        1 | Item #015156 added to order. |
      |   500199 | Do Not Substitute             |        1 | Item #500199 added to order. |
      |   502047 | Do Not Substitute             |        1 | Item #502047 added to order. |
      |   471490 | Do Not Substitute             |        1 | Item #471490 added to order. |
      |   425025 | Do Not Substitute             |        1 | Item #425025 added to order. |
      |   257030 | Do Not Substitute             |        1 | Item #257030 added to order. |
      |   032862 | Do Not Substitute             |        1 | Item #032862 added to order. |
      |   462564 | Do Not Substitute             |        1 | Item #462564 added to order. |
      |   282517 | Do Not Substitute             |        1 | Item #282517 added to order. |
      |   497479 | Do Not Substitute             |        1 | Item #497479 added to order. |
      |   325068 | Do Not Substitute             |        1 | Item #325068 added to order. |
      |   511667 | Do Not Substitute             |        1 | Item #511667 added to order. |
      |   485011 | Do Not Substitute             |        1 | Item #485011 added to order. |
      |   158162 | Do Not Substitute             |        1 | Item #158162 added to order. |
    And User Adds products Using NDC, Product Description then add Quantity to clicks Add To Order
      | NDC_ProductDescription                | addQuantity | successMessage               |
      |                           30536105775 |           1 | Item #181560 added to order. |
      |                           03848591161 |           1 | Item #142505 added to order. |
      |                                182766 |           2 | Item #182766 added to order. |
      | ZINC + VITAMIN C SOFTGEL 50 MG 120 NT |           2 | Item #392993 added to order. |
      | ASPERCREME LIDOCAINE CREAM 4.3 OZ     |           2 | Item #400069 added to order. |
    And User Adds products using UPC then add Quantity to clicks Add To order:
      | UPC         | addQuantity | successMessage               |
      | 74098527531 |           2 | Item #236901 added to order. |
      | 74098522721 |           2 | Item #236893 added to order. |
      | 36570240710 |           2 | Item #881011 added to order. |
    And User Adds products using GTIN then add Quantity to clicks Add To order:
      | GTIN           | addQuantity | successMessage               |
      | 00365702712102 |           2 | Item #310185 added to order. |
      | 00883489000750 |           2 | Item #011262 added to order. |
      | 00604351787155 |           2 | Item #717694 added to order. |
    And User should updates already added item:
      | itemsNum | specialCode      | orderQty | updateMessage                    |
      |   236901 | Override Qty Cut |        5 | Item #236901 updated from order. |
    And User should Updates already added items Using Add Products, verifies the message "ITEM ALREADY EXIST":
      | updateItems                           | warningMessage                       | updateSpecialCode             | updateQty | updateMessage                    |
      |                                407585 | Item #407585 already added to order. | Do Not Substitute             |         5 | Item #407585 updated from order. |
      |                           03848591161 | Item #142505 already added to order. | Shelf Label Only              |         5 | Item #142505 updated from order. |
      | ZINC + VITAMIN C SOFTGEL 50 MG 120 NT | Item #392993 already added to order. | Price Sticker Only            |         5 | Item #392993 updated from order. |
      |                           74098527531 | Item #236901 already added to order. | Shelf Label and Price Sticker |         5 | Item #236901 updated from order. |
      |                        00365702712102 | Item #310185 already added to order. | Override Qty Cut              |         5 | Item #310185 updated from order. |
      |                           36570240710 | Item #881011 already added to order. |                               |         5 | Item #881011 updated from order. |
    When User updates the orders name to "Regular order Automation Test" and verifies the alert message "Order name updated."
    Then User should update the auto submit by selecting date "<date>" and time "<time>", clicks on Auto Submit, and verifies the success message "Order auto submit scheduled."
    Then User should cancel Auto Submit and verify the success message as "Order auto submit canceled."
    And the user clicks on Auto Submit History and successfully views the details
    Then User should update the Order Reference with "Auto Test" and verify the success message "Order Reference updated."
    And User should select Show Invalid Items First option
    And User should verify that selecting the header checkbox selects all row checkboxes
    And User verifies sorting orders in both ascending and descending orders for items, Product Discriptions
    And User verifies sorting order in both ascending and descending order for all columns: items, Product Descriptions, Categories, Whs. Qty, Net Price, Ext. Net Price, Inv. Price, Ext. Inv Price, and Added
    Then User should selects the item in list and clicks Delete Selected then verifies the success message "Items deleted from order."
    Then User should updates the item quantity to "5" and selects the special code "Shelf Label and Price Sticker" in the grid, then verifies the success alert message "Success!"
    Then User deletes an item from the list and confirms the "Success!" alert message appears
    And User verifies pagination functionality on the Orders Web Page
    Then User should save the template and confirm the success alert message "Order template saved."
    And User clicks on "Print Order" to view the order details.
    And User submits the regular orders and clicks OK

    @RegularOrder
    Examples: 
      | selectYourCustomerAccount             | orderName                | orderType     | autoSubmit | orderReferance | date       | time |
      | WALKERS DRUG STORE (PREMIER) - 124685 | Regular Order Test- Prod | Regular Order | None       | test           | 13-05-2025 | 6 PM |

  Scenario Outline: Verifying Mutual Drug to Create new order in Current Orders webpage - C2 orders creation
    Given User is on the Mutual Drug Login
    When User perform login with Username, Password
    Then User should verify after login "<selectYourCustomerAccount>" and success message as "Member Access Portal"
    Then User navigates to Orders, selects Current Orders and verifies that the page is "Current Orders"
    When User clicks Create New, Create New C2 Orders with "<orderName>" , "<orderType>"
    And User Adds the items/products using item number
      | itemsNum | orderQty | successMessage               |
      |   046425 |        1 | Item #046425 added to order. |
      |   118182 |        1 | Item #118182 added to order. |
      |   788596 |        1 | Item #788596 added to order. |
      |   245712 |        1 | Item #245712 added to order. |
      |   017863 |        1 | Item #017863 added to order. |
      |   744367 |        1 | Item #744367 added to order. |
    And User Adds products Using NDC, Product Description then add Quantity to clicks Add To Order
      | NDC_ProductDescription           | addQuantity | successMessage               |
      |                      54092038701 |           2 | Item #272013 added to order. |
      |                      42858080301 |           2 | Item #017897 added to order. |
      |                           373308 |           2 | Item #373308 added to order. |
      | ADDERALL XR CAP 15 MG 100        |           2 | Item #313353 added to order. |
      | OXYCODONE HCL TAB 15 MG 100 MALL |           2 | Item #591438 added to order. |
    And User Adds products using UPC then add Quantity to clicks Add To order:
      | UPC         | addQuantity | successMessage               |
      | 33172295001 |           2 | Item #379339 added to order. |
      | 32451011010 |           2 | Item #226050 added to order. |
      | 34359889701 |           2 | Item #375964 added to order. |
    And User Adds products using GTIN then add Quantity to clicks Add To order:
      | GTIN           | addQuantity | successMessage               |
      | 00370165025300 |           2 | Item #215095 added to order. |
      | 00364850515016 |           2 | Item #466359 added to order. |
      | 00364850511018 |           2 | Item #466235 added to order. |
    And User should updates already added item:
      | itemsNum | orderQty | updateMessage                    |
      |   215095 |        5 | Item #215095 updated from order. |
    And User should Updates already added items Using Add Products, verifies the message "ITEM ALREADY EXIST":
      | updateItems                              | warningMessage                       | updateQty | updateMessage                    |
      |                                   788596 | Item #788596 already added to order. |         5 | Item #788596 updated from order. |
      |                              54092038701 | Item #272013 already added to order. |         5 | Item #272013 updated from order. |
      |                              34285880301 | Item #017897 already added to order. |         5 | Item #017897 updated from order. |
      |                           00324510110104 | Item #226050 already added to order. |         5 | Item #226050 updated from order. |
      | AMPHETAMINE SALTS ER CAP 10 MG 100 ELITE | Item #466235 already added to order. |         5 | Item #466235 updated from order. |
    When User updates the orders name to "C2 order Automation Test" and verifies the alert message "Order name updated."
    And User should select Show Invalid Items First option
    And User should verify that selecting the header checkbox selects all row checkboxes
    And User verifies sorting order in both ascending and descending order for all columns: items, Product Descriptions, Categories, Whs. Qty, Net Price, Ext. Net Price, Inv. Price, Ext. Inv Price, and Added
    Then User should updates the item quantity to "5" in the grid, then verifies the success alert message "Success!"
    Then User should selects the item in list and clicks Delete Selected then verifies the success message "Items deleted from order."
    Then User deletes an item from the list and confirms the "Success!" alert message appears
    And User verifies pagination functionality on the Orders Web Page
    Then User should save the template and confirm the success alert message "Order template saved."
    And User clicks on "Print Order" to view the order details.
    And User clicks "Sign&Submit" to submit the orders
    And User enters store password "<storePassword>" and clicks Sign
    Then User verifies the orders submission with alert message "Thank you, your CSOS order (sample test orderNew) was successfully signed and transmitted."

    @c2order
    Examples: 
      | selectYourCustomerAccount             | orderName     | orderType | storePassword   |
      | WEB POS TEST STORE (PREMIER) - 009498 | C2 order Test | C2 Order  | Datacaliper@123 |

  @ProductCatalog
  Scenario Outline: Verifying Mutual Drug to Create New orders in Full view Products and Add Items And Update Items in Products Catalog webpage
    Given User is on the Mutual Drug Login
    When User perform login with Username, Password
    Then User should verify after login "<selectYourCustomerAccount>" and success message as "Member Access Portal"
    Then User should clicks Products, selects "Over the Counter (OTC)" and verify the page "Product Catalog"
    When User select Full view and clicks Create New for first product, Create New Orders with "<orderName>" , "<orderType>" , "<autoSubmit>"
    Then User should verifies that a success alert with the message "Success!" is displayed, confirming the item has been added to the order
    And User adds another item to the existing order "<selectOrderName>" with quantity "<qty>", clicks Add, and confirms the "Success!" alert is displayed
    Then User should clicks Add With "<selectOrderName>", and when the item is already added, verifies the warning message "ITEM ALREADY EXIST" and updates it with "<qtyUpdate>" and specialCodes, confirming the alert message "Success!"

    Examples: 
      | selectYourCustomerAccount             | orderName              | orderType     | autoSubmit | selectOrderName                  | qty | qtyUpdate |
      | WALKERS DRUG STORE (PREMIER) - 124685 | Test Order - Full view | Regular Order | 6 PM       | Test Order - Full view - Regular |   3 |         4 |

  @ProductCatalog_compactview
  Scenario Outline: Verifying Mutual Drug to Create new orders in Compact view Products Catalog webpage
    Given User is on the Mutual Drug Login
    When User perform login with Username, Password
    Then User should verify after login "<selectYourCustomerAccount>" and success message as "Member Access Portal"
    Then User should clicks Products, selects "Over the Counter (OTC)" and verify the page "Product Catalog"
    When User select Compact view and clicks Create New for first product, Create New Orders with "<orderName>" , "<orderType>" , "<autoSubmit>"
    Then User should verifies that a success alert with the message "Success!" is displayed, confirming the item has been added to the order
    Then User should Add another item to an existing order in Compact View "<selectOrderName>" with quantity "<qty>", clicks Add, and confirms the "Success!" alert is displayed
    Then User should clicks Add in Compact View, selects "<selectOrderName>", clicks Add To Order, and when the item is already added, verifies the message "ITEM ALREADY EXIST" and updates it with "<qtyUpdate>" and special codes, confirming the alert message "Success!"

    Examples: 
      | selectYourCustomerAccount          | orderName                 | orderType     | autoSubmit | selectOrderName                     | qty | qtyUpdate |
      | TAS DRUG MAIDEN (PREMIER) - 009217 | Test Order - Compact view | Regular Order | 6 PM       | Test Order - Compact view - Regular |   2 |         5 |

  @GlobalSearch
  Scenario Outline: Verifying Mutual Drug to Create new orders - product search - Using Global search
    Given User is on the Mutual Drug Login
    When User perform login with Username, Password
    Then User should verify after login "<selectYourCustomerAccount>" and success message as "Member Access Portal"
    Then User navigates to Orders, selects Current Orders and verifies that the page is "Current Orders"
    And User performs global search for "<globalSearch>" to create a new regular orders
    When User selects a product, enters quantity "<qty>", creates a new order with "<orderName>" and "<autoSubmit>", and confirms the success message "Success!"
    Then User clicks Add on the same item, selects the existing order "<selectOrderName>", "<updateQty>" verifies the warning message "ITEM ALREADY EXIST", updates the item with quantity "<qtyUpdate>" and the provided special code "Price Sticker Only" , and confirms the alert message "Success!"

    Examples: 
      | selectYourCustomerAccount             | globalSearch | qty | orderName                | autoSubmit | selectOrderName                    | updateQty | qtyUpdate |
      | WALKERS DRUG STORE (PREMIER) - 124685 | lotion       |   3 | Test Order global Search | 6 PM       | Test Order global Search - Regular |         6 |         5 |

  @productdetail
  Scenario Outline: Verify mutual drug functionality to create a new orders using global search Product detail page Webpage
    Given User is on the Mutual Drug Login
    When User perform login with Username, Password
    Then User should verify after login "<selectYourCustomerAccount>" and success message as "Member Access Portal"
    Then User navigates to Orders, selects Current Orders and verifies that the page is "Current Orders"
    When User performs global search for "<globalSearch>" to create a new regular orders
    When User selects a product, enters quantity "<qty>", creates a new order with "<orderName>" and "<autoSubmit>", and confirms the success message "Success!"
    Then User clicks Add To Order on the same item, selects the existing order "<updateQty>", "<selectOrderName>" verifies the warning message "ITEM ALREADY EXIST", updates the item with quantity "<qtyUpdate>" and the provided special code "Price Sticker Only" , and confirms the alert message "Success!"

    Examples: 
      | selectYourCustomerAccount             | globalSearch | qty | orderName                 | autoSubmit | updateQty | selectOrderName                     | qtyUpdate |
      | WALKERS DRUG STORE (PREMIER) - 124685 |       285684 |   2 | Test Order Product Detail | 6 PM       |         3 | Test Order Product Detail - Regular |         5 |

  @SuggestedProducts
  Scenario Outline: Verifying Mutual Drug to Create new orders in Suggested Products list
    Given User is on the Mutual Drug Login
    When User perform login with Username, Password
    Then User should verify after login "<selectYourCustomerAccount>" and success message as "Member Access Portal"
    Then User navigates to Orders, selects Current Orders and verifies that the page is "Current Orders"
    When User performs global search for "<globalSearch>" to create a new regular orders
    Then User should Create New Regular Orders in Suggested Products list with "<orderName>" , "<autoSubmit>" and verifies the success message "Success!"
    Then User clicks Add on the same suggested item, selects the existing order "<selectOrderName>", "<updateQty>" verifies the warning message "ITEM ALREADY EXIST", updates the item with quantity "<qtyUpdate>" and the provided special code "Do Not Substitute" , and confirms the alert message "Success!"

    Examples: 
      | selectYourCustomerAccount             | globalSearch | orderName                    | autoSubmit | updateQty | selectOrderName                        | qtyUpdate |
      | WALKERS DRUG STORE (PREMIER) - 124685 |       328013 | Test order Suggested Product | 6 PM       |         3 | Test order Suggested Product - Regular |         5 |

  @CaseItemsOrder
  Scenario Outline: Verifying Mutual Drug to Create new orders - Case Items
    Given User is on the Mutual Drug Login
    When User perform login with Username, Password
    Then User should verify after login "<selectYourCustomerAccount>" and success message as "Member Access Portal"
    Then User navigates to Orders, selects Current Orders and verifies that the page is "Current Orders"
    When User performs global search for "<globalSearch>" to create a new regular orders
    And User clicks on Create New Orders, clicks YES for Case Item orders and enters "<orderName>" and "<autoSubmit>" and verifies the success message "Success!"

    Examples: 
      | selectYourCustomerAccount             | globalSearch | orderName               | autoSubmit |
      | WALKERS DRUG STORE (PREMIER) - 124685 |       324376 | Sample Order Case Items | 6 PM       |

  @Notificationlist
  Scenario Outline: Verifying Mutual Drug to Create Notification Group
    Given User is on the Mutual Drug Login
    When User perform login with Username, Password
    Then User should verify after login "<selectYourCustomerAccount>" and success message as "Member Access Portal"
    Then User should navigates to Notification list and verifies that the page is "Notifications"
    And User clicks on Create Notification Group to Create New Notification Group
      | groupName                       | groupType     | successMessage              |
      | Test Notification Group Regular | Regular Order | Notification Group Created. |
      | Test Notification Group  C2     | C2 Order      | Notification Group Created. |
    And User should selects "Test Notification Group Regular" Notification group name, search products using global search "<globalSearch>"
    Then User Clicks Create New Regular Orders with "<orderName>" , "<autoSubmit>" and verifies the success message "Product added to order."

    Examples: 
      | selectYourCustomerAccount             | globalSearch | orderName               | autoSubmit |
      | WALKERS DRUG STORE (PREMIER) - 124685 |       485136 | Test Notification Group | None       |

  @AlternaiveItems
  Scenario Outline: Verifying Mutual Drug to Adds discountinued, inactive items
    Given User is on the Mutual Drug Login
    When User perform login with Username, Password
    Then User should verify after login "<selectYourCustomerAccount>" and success message as "Member Access Portal"
    Then User navigates to Orders, selects Current Orders and verifies that the page is "Current Orders"
    When User clicks on  Create New, Create New Regular Orders with "<orderName>" , "<orderType>" , "<autoSubmit>" , "<orderReferance>"
    When User add system suggests alternative items when the user attempts to add discontinued or inactive products
      | itemNumber | specialCode | orderQty |
      |     129973 |             |        1 |
      |     161703 |             |        1 |
      |     010140 |             |        1 |
      |     355818 |             |        1 |
      |     350967 |             |        1 |
      |     010843 |             |        1 |
    And User verifies pagination functionality on the Orders Web Page
    And User submits the regular orders and clicks OK

    Examples: 
      | selectYourCustomerAccount             | orderName                      | orderType     | autoSubmit | orderReferance |
      | WALKERS DRUG STORE (PREMIER) - 124685 | Regular Order Test Alternative | Regular Order | None       | test           |

  @negative
  Scenario Outline: Verifying Mutual Drug to Create new orders - Negative Scenario
    Given User is on the Mutual Drug Login
    When User perform login with Username, Password
    Then User should verify after login "<selectYourCustomerAccount>" and success message as "Member Access Portal"
    Then User navigates to Orders, selects Current Orders and verifies that the page is "Current Orders"
    When User clicks on Create New without entering any details and clicks Create
    Then User should verifies the error messages: "Order Name is required" and "Order Type is required"
    Then User provides Space in Order Name with "Regular Order" order type and tries to create an Order then see the error message "Order Name is required"
    When User attempts to create an order with "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890" exceeding 60 characters with "Regular Order" order type and verifies the error message "Order Name must be less than 60 characters"
    Then User enters special characters in the Order Name "$pec!@l" with "Regular Order" order type and tries to create an Order then see the error message "Special characters not allowed"
    When User attempts to create an order reference name "AbcdEfghIjklMnop" exceeding 15 characters with "Regular Order" order type and verifies the error message "Order Reference must be Max of 15 characters"
    Then User enter order name with special characters with "Regular Order" order type and tries to create an Order and should see the error message "Special characters not allowed"
    And User should clicks on Use a Template and entering without anut details and clicks Create
    Then User should validate the error message "Order Name is required" , "Template is required"
    Then User provides spaces in the Order Name field in Templates and tries to create an Order, then verifies the error message "Order Name is required"
    When User attempts to create a Template with Order Name "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890" exceeding 60 characters and verifies the error message "Order Name must be less than 60 characters"
    Then User enters special characters in the Templates Order Name "$pec!@l" and tries to create an Order then see the error message "Special characters not allowed"

    Examples: 
      | selectYourCustomerAccount             |
      | WALKERS DRUG STORE (PREMIER) - 124685 |

  @negativeRegular
  Scenario Outline: Verifying Mutual Drug - Regular orders negative Scenarios
    Given User is on the Mutual Drug Login
    When User perform login with Username, Password
    Then User should verify after login "<selectYourCustomerAccount>" and success message as "Member Access Portal"
    Then User navigates to Orders, selects Current Orders and verifies that the page is "Current Orders"
    When User clicks on  Create New, Create New Regular Orders with "<orderName>" , "<orderType>" , "<autoSubmit>" , "<orderReferance>"
    Then User attempts to submit the order without selecting any items and verifies the warning message "Please select one or more item(s)."
    Then User attempts to Auto Submit "05-05-2025"  and "6 PM" without selecting any items and verifies the warning message "Please select one or more item(s)."
    Then User enters an invalid date "99-99-9999" for auto-submit and verifies the error message "Auto-Submit time is passed and your order has already been submitted."
    When User submitting an invalid or null date "01-03-0099" and verifies the warning message "Text 'null' could not be parsed at index 0"
    Then User removes the Order Name and verifies the error message "Order Name is required".
    When User attempts to Updates an Order Name with "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890" exceeding 60 characters  verifies the error message "Order Name must be less than 60 characters"
    Then User attempts to updates an order Name with special characters "$pec!@*" then see the error message "Special characters not allowed"
    When User attempts to updates an order reference name "AbcdEfghIjklMnop" exceeding 15 characters and verifies the error message "Order Reference must be less than 15 characters"
    Then User attempts to updates an reference Name with special characters "$pec!@*" then see the error message "Special characters not allowed"
    Then User attempts to add an item without an item number and verifies the warning message "Item code is required."
    Then User adds an item "285684" with a quantity of "0" and verifies the warning message "Min allowed order qty is 1."
    And User should verifies the Order quantity field input validation
    Then User attempts to add discontinued, and inactive items, then see the warning message "Item is not found or unavailable for purchase." for each item:
      | items  |
      | 368902 |
      | 804385 |
      | 422550 |
      | 011569 |
    Then User attempts to add discontinued, and inactive items in Regular Order then see the error message "Item discontinued. Please see available alternatives below.." for each item:
      | products | errorMessage                                                 |
      |   247585 | Item discontinued. Please see available alternatives below.. |
      |   210849 | Item discontinued. Please see available alternatives below.. |
      |   010140 | Item discontinued. Please see available alternatives below.. |
      |   293076 | Item discontinued. Please see available alternatives below.. |
    Then User attempts to add C2 items "112474" in Regular order and verifies the alert message "Cannot add C2 item to non C2 order."
    Then User attempts to add C2 alternative items Using NDC in Regular order and verifies the alert message "C2 products cannot be added to a regular order."
      | products    |
      | 00406055201 |
      | 10702000850 |
      | 10702000850 |
    Then User attempts to add C2 items Using UPC, GTIN, Product Discriptions, Item#  Regular order and verifies the alert message "No matching product(s) found." :
      | products                                    |
      |                                 31070200801 |
      |                                 33172295001 |
      |                              00370165025300 |
      |                              00364850515016 |
      | AMPHETAMINE SALTS TAB 5 MG 100 MALLINCKRODT |
      | OXYCODONE HCL TAB 15 MG 500 KVK TECH        |
    And User Adds the items/products using item number
      | itemsNum | specialCode | orderQty | successMessage               |
      |   485136 |             |        1 | Item #485136 added to order. |
    Then User attempts to add the same item "485136" again and verifies the warning message "Item already added to order."
    Then User attempts to add the already added item "A & D ORIGINAL OINTMENT 4 OZ" using Add Products
    And User verifies Quantity field enforces validation for acceptable inputs
    And User clicks Add To Order and verifies the message "ITEM ALREADY EXIST":
    Then User "ITEM ALREADY EXIST" is displayed, the Order Qty field should enforce its input validation rules
    Then User updating the Order Qty field to empty and submitting should display "Please enter valid qty"
    Then User updating the Order Qty to "0" and submitting should display the error "Order Qty is not valid"
    Then User should updates the order quantity to "0" and verifies the warning message "Min allowed order qty is 1."

    Examples: 
      | selectYourCustomerAccount             | orderName             | orderType     | autoSubmit | orderReferance |
      | WALKERS DRUG STORE (PREMIER) - 124685 | sample test order New | Regular Order | None       | test           |

  @C2Negative
  Scenario Outline: Verifying Mutual Drug C2 order negative Scenarios
    Given User is on the Mutual Drug Login
    When User perform login with Username, Password
    Then User should verify after login "<selectYourCustomerAccount>" and success message as "Member Access Portal"
    Then User navigates to Orders, selects Current Orders and verifies that the page is "Current Orders"
    When User clicks Create New, Create New C2 Orders with "<orderName>" , "<orderType>"
    Then User attempts to Sign&Submit the order without selecting any items and verifies the warning message "Please select one or more item(s)."
    Then User removes the Order Name and verifies the error message "Order Name is required".
    When User attempts to Updates an Order Name with "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890" exceeding 60 characters  verifies the error message "Order Name must be less than 60 characters"
    Then User attempts to updates an order Name with special characters "$pec!@*" then see the error message "Special characters not allowed"
    Then User attempts to add an item without an item number and verifies the warning message "Item code is required."
    Then User adds an item "112474" with a quantity of "0" and verifies the warning message "Min allowed order qty is 1."
    Then User attempts to add discontinued, and inactive items, then see the warning message "Item is not found or unavailable for purchase." for each item:
      | items  |
      | 326843 |
      | 355818 |
      | 350967 |
      | 017939 |
      | 247585 |
      | 011460 |
      | 247585 |
    Then User attempts to add discontinued, and inactive items in Regular Order then see the error message "Item discontinued. Please see available alternatives below.." for each item:
      | products |
      |   326850 |
      |   381293 |
      |   425926 |
    Then User attempts to add Non C2 alternative items Using NDC, UPC, GTIN, Product Discriptions and item# in C2 order and verifies the alert message "Regular products cannot be added to a C2 order."
      | products    |
      | 40985022721 |
      | 55513092410 |
      | 00005010005 |
    Then User attempts to add Regular items Using NDC, UPC, GTIN, Product Discriptions and item# in C2 order and verifies the alert message "No matching product(s) found."
      | products                                 |
      |                              03848591161 |
      |                              36570240710 |
      |                              35789686406 |
      |                              75475654050 |
      |                              70537206060 |
      |                              02120001030 |
      |                           00851806000776 |
      |                           00078787401501 |
      |                              80882912310 |
      |                           00883489000750 |
      |                           00071815261313 |
      |                              30005010005 |
      |                           00301873050506 |
      | AMPHETAMINE IR TAB 10 MG 100 LANNETT     |
      | TRUMENBA PF SYR 0.5 ML CTN/5             |
      | HYDROCORTISONE LOTION 2.5% 2 OZ PADAGIS  |
      | TRL JOHNSON BABY LOTION 1.7 OZ           |
      | CYCLOBENZAPRINE HCL TAB 5 MG 500 UNICHEM |
      | ANNIE BUTTERFLY CLAMPS SMALL 12 #3180    |
    And User Adds the items/products using item number
      | itemsNum | specialCode | orderQty | successMessage               |
      |   046425 |             |        1 | Item #046425 added to order. |
    Then User attempts to add the same item "046425" again and verifies the warning message "Item already added to order."
    Then User attempts to add Regular items "485136" in c2 order and verifies the alert message "Cannot add non C2 item to C2 order."
    Then User should updates the order quantity to "0" and verifies the warning message "Min allowed order qty is 1."
    And User submits the C2 Order with an invalid password "InV!@#" and verifies the error message "Certificate is not registered or password did not match."

    Examples: 
      | selectYourCustomerAccount             | orderName                | orderType | storePassword   | c2_OrderSuccessMessage                                                                     |
      | WEB POS TEST STORE (PREMIER) - 009498 | sample test C2 order New | C2 Order  | Datacaliper@123 | Thank you, your CSOS order (sample test orderNew) was successfully signed and transmitted. |

  Scenario Outline: Verifying Mutual Drug to Create New orders in Full view Products Catalog webpage Order Creation Negative Test
    Given User is on the Mutual Drug Login
    When User perform login with Username, Password
    Then User should verify after login "<selectYourCustomerAccount>" and success message as "Member Access Portal"
    Then User should clicks Products, selects "Over the Counter (OTC)" and verify the page "Product Catalog"
    And User selects "Full view" and clicks "Create New Order" to initiate creating a new order
    Then User tries to create an order without entering Order Name and verifies the error message "Order Name is required"
    Then User tries to create an order with special characters in the Order Name "$pec!@L" and verifies the error message "Special characters not allowed"
    When User attempts to create an order with Order Name "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890" exceeding 60 characters and verifies the error message "Order Name must be less than 60 characters"

    @FullViewNegativeTest
    Examples: 
      | selectYourCustomerAccount             |
      | WALKERS DRUG STORE (PREMIER) - 124685 |

  Scenario Outline: Verifying Mutual Drug to Create New orders in Compact view Products Catalog webpage Order Creation Negative Test
    Given User is on the Mutual Drug Login
    When User perform login with Username, Password
    Then User should verify after login "<selectYourCustomerAccount>" and success message as "Member Access Portal"
    Then User should clicks Products, selects "Over the Counter (OTC)" and verify the page "Product Catalog"
    And User selects Compact view and clicks "Create New Order" to initiate creating a new order
    Then User tries to create an order without entering Order Name and verifies the error message "Order Name is required"
    Then User tries to create an order with special characters in the Order Name "$pec!@L" and verifies the error message "Special characters not allowed"
    When User attempts to create an order with Order Name "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890" exceeding 60 characters and verifies the error message "Order Name must be less than 60 characters"

    @CompactViewNegative
    Examples: 
      | selectYourCustomerAccount   |
      | TAS DRUG (PREMIER) - 008557 |

  Scenario Outline: Verifying Mutual Drug to Create new orders Negative Test - product search - Using Global search
    Given User is on the Mutual Drug Login
    When User perform login with Username, Password
    Then User should verify after login "<selectYourCustomerAccount>" and success message as "Member Access Portal"
    Then User navigates to Orders, selects Current Orders and verifies that the page is "Current Orders"
    And User performs global search for "<globalSearch>" to create a new regular orders
    And User selects "Full view" and clicks "Create New Order" to initiate creating a new order
    Then User tries to create an order without entering Order Name and verifies the error message "Order Name is required"
    Then User tries to create an order with special characters in the Order Name "$pec!@L" and verifies the error message "Special characters not allowed"
    When User attempts to create an order with Order Name "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890" exceeding 60 characters and verifies the error message "Order Name must be less than 60 characters"

    @GlobalSearchNegative
    Examples: 
      | selectYourCustomerAccount             | globalSearch |
      | WALKERS DRUG STORE (PREMIER) - 124685 | lotion       |

  Scenario Outline: Verifying Mutual Drug - Negative test while creating new order from Suggested Products list
    Given User is on the Mutual Drug Login
    When User perform login with Username, Password
    Then User should verify after login "<selectYourCustomerAccount>" and success message as "Member Access Portal"
    Then User navigates to Orders, selects Current Orders and verifies that the page is "Current Orders"
    When User performs global search for "<globalSearch>" to create a new regular orders
    And User should verify the suggested products quantity field validations
      | qtyInputs |
      |       123 |
      |       999 |
      |      1000 |
      |      1111 |
      |       -11 |
      |      0.01 |
      | 3/4       |
      | 25%       |
      |     -1234 |
      | !@        |
      | abc       |
      | XYZ       |
      |      0010 |
    And User verifies the Suggested Products list and clicks "Create New Order" to initiate a new order.
    Then User tries to create an order without entering Order Name and verifies the error message "Order Name is required"
    Then User tries to create an order with special characters in the Order Name "$pec!@L" and verifies the error message "Special characters not allowed"
    When User attempts to create an order with Order Name "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890" exceeding 60 characters and verifies the error message "Order Name must be less than 60 characters"

    @SuggestedNegative
    Examples: 
      | selectYourCustomerAccount             | globalSearch |
      | WALKERS DRUG STORE (PREMIER) - 124685 |       328013 |
