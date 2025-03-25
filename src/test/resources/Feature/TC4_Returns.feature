@Returns
Feature: Verifying Mutual Drug Create Returns orders

  @ReturnName
  Scenario Outline: Verifying Mutual Drug Returns Name
    Given User is on the Mutual Drug Login
    When User perform login with Username, Password
    Then User should verify after login "<selectYourCustomerAccount>" and success message as "C2 CERTIFICATE NOTIFICATION !!"
    Then User navigates to the "Returns" page and verifies the page is displayed
    And User clicks on Create New to create a new return order
      | returnName | returnType |
      |          1 | Regular    |
    And User removes the Returns name and navigates back to the Returns page
    And User searches for a return name " 1" and verifies that the grid displays the return name is "1"
    And User verifies sorting order in both ascending and descending order for all columns Return Name, Status, Submitted Date, Submitted By, Type, Total Lines, and Total Pieces
    Then User deletes a return order from the returns list and verifies the "Return details deleted." alert message
    And User verifies pagination functionality on the Returns page

    Examples: 
      | selectYourCustomerAccount             |
      | WEB POS TEST STORE (PREMIER) - 009498 |

  @RegularReturns
  Scenario Outline: Verifying Mutual Drug to Create Returns orders - Regular order
    Given User is on the Mutual Drug Login
    When User perform login with Username, Password
    Then User should verify after login "<selectYourCustomerAccount>" and success message as "C2 CERTIFICATE NOTIFICATION !!"
    Then User navigates to the "Returns" page and verifies the page is displayed
    And User clicks on Create New to create a new return order
      | returnName                  | returnType |
      | sample test -Regular Return | Regular    |
    And User adds return items by searching products:
      | searchProducts | expirationDate | lotNumber | qty | returnReason                                                            | successMessage     |
      |         025767 | 12-02-2025     |     00000 |   1 | Dated OTC/DME - Within 6 months of Purchase                             | Return item added. |
      | advil          | 13-02-2025     |     11111 |   1 | Non-Dated OTC/DME - Within 24 Months of Purchase                        | Return item added. |
      | advil          | 13-02-2025     |     11111 |   1 | NR – Customer Service Authorized                                        | Return item added. |
      |         482208 | 14-02-2025     |      0123 |   2 | OTC – Meets Salable Criteria                                            | Return item added. |
      |         728717 | 14-02-2025     |      0123 |   1 | Recall                                                                  | Return item added. |
      |         268573 | 14-02-2025     |      0123 |   1 | Received Damaged - (Customer Service Notified)                          | Return item added. |
      |         881094 | 15-02-2025     |      0123 |   1 | Received Defective - (Customer Service Notified)                        | Return item added. |
      |         852350 | 15-02-2025     |      0123 |   1 | Received Short Dated - (Customer Service Notified)                      | Return item added. |
      |         323667 | 15-02-2025     |      0123 |   1 | Rx – Expired (1 month prior to and up to 2 months past expiration date) | Return item added. |
      |         555888 | 15-02-2025     |      0123 |   1 | Rx - Meets Salable Criteria                                             | Return item added. |
      |         555888 | 15-02-2025     |      0123 |   1 | Store Did not Order - (Customer Service Notified)                       | Return item added. |
      |         881011 | 15-02-2025     |      0123 |   1 | NR – Customer Service Authorized                                        | Return item added. |
      |         323667 | 15-02-2025     |      0123 |   1 | NR – Customer Service Authorized                                        | Return item added. |
      |         288936 | 15-02-2025     |      0123 |   1 | NR – Customer Service Authorized                                        | Return item added. |
      |         482208 | 15-02-2025     |      0123 |   1 | Rx – Expired (1 month prior to and up to 2 months past expiration date) | Return item added. |
      |         407551 | 15-02-2025     |      0123 |   1 | Recall                                                                  | Return item added. |
      |         359091 | 15-02-2025     |      0123 |   1 | Received Damaged - (Customer Service Notified)                          | Return item added. |
      |         486944 | 15-02-2025     |      0123 |   1 | Received Short Dated - (Customer Service Notified)                      | Return item added. |
      |         476705 | 15-02-2025     |      0123 |   1 | Received Short Dated - (Customer Service Notified)                      | Return item added. |
      |         308122 | 15-02-2025     |      0123 |   1 | NR – Customer Service Authorized                                        | Return item added. |
      |         309872 | 15-02-2025     |      0123 |   1 | NR – Customer Service Authorized                                        | Return item added. |
      |         881011 | 15-02-2025     |      0123 |   1 | NR – Customer Service Authorized                                        | Return item added. |
      |         716886 | 15-02-2025     |      0123 |   1 | NR – Customer Service Authorized                                        | Return item added. |
      |         323667 | 15-02-2025     |      0123 |   1 | NR – Customer Service Authorized                                        | Return item added. |
      |         255695 | 15-02-2025     |      0123 |   1 | OTC – Meets Salable Criteria                                            | Return item added. |
      |         025767 | 15-02-2025     |      0123 |   1 | Received Damaged - (Customer Service Notified)                          | Return item added. |
    And User adds Regular return items using refined search criteria, sorting by sort By in sort Order order:
      | addSearchProducts | refineSearch | category               | sortBy      | sortOrder | returnReasons | successMessage     |
      | advil             | wing         | Over the Counter (OTC) | Description | A to Z    | Recall        | Return item added. |
    And User updates the Regular Returns product list:
      | expirationDateGrid | lotNumberGrid | qtyGrid | returnReasonGrid | updateAlertMessage   |
      | 12-02-2025         |          1234 |       2 | Recall           | Return item updated. |
    And User can change Return name as "Regular Return Automation Test" then  verifying the alert message  "Return name updated."
    Then User should sort by Items and Product Description and delete an item from the return list, verifying the alert message  "Return item deleted."
    And User should navigate through pages using pagination controls on the Returns items page
    And User clicks on Sign & Submit and submits with "<authorisedSignature>", "<title>", and "<signatureFont>" and verifying alert success message as " Your Regular Form has been submitted "

    @RegularItems
    Examples: 
      | selectYourCustomerAccount             | authorisedSignature | title  | signatureFont        |
      | WEB POS TEST STORE (PREMIER) - 009498 | test                | sample | Edwardian Script ITC |

  @C2Returns
  Scenario Outline: Verifying Mutual Drug to Create Returns orders - C2 Returns
    Given User is on the Mutual Drug Login
    When User perform login with Username, Password
    Then User should verify after login "<selectYourCustomerAccount>" and success message as "C2 CERTIFICATE NOTIFICATION !!"
    Then User navigates to the "Returns" page and verifies the page is displayed
    And User clicks on Create New to create a new return order
      | returnName                 | returnType |
      | sample test -C2 Return - 4 | C2         |
    And User adds C2 return  items by searching products:
      | searchProducts | expirationDate | lotNumber | qty | returnReason                            | successMessage     |
      |         272005 | 12-02-2025     |     00000 |   1 | CII – 6 Months or Greater dating remain | Return item added. |
      |         313353 | 12-02-2025     |     11111 |   1 | CII – 6 Months or Greater dating remain | Return item added. |
      |         313361 | 12-02-2025     |     11111 |   1 | CII – 6 Months or Greater dating remain | Return item added. |
    And User adds C2 return items using refined search criteria, sorting by sort By in sort Order order:
      | addSearchProducts | refineSearch | category   | sortBy      | sortOrder | expirationDate | lotNumber | qty | returnReason                            | successMessage     |
      | HCL               | CAP          | Rx Generic | Description | A to Z    | 12-02-2025     |     11111 |   3 | CII – 6 Months or Greater dating remain | Return item added. |
    And User updates the return products list:
      | expirationDateGrid | lotNumberGrid | qtyGrid | returnReasonGrid                        | updateAlertMessage   |
      | 12-02-2025         |         12345 |       2 | CII – 6 Months or Greater dating remain | Return item updated. |
    Then User should sort by Items and Product Description and delete an item from the return list, verifying the alert message  "Return item deleted."
    And User clicks on Sign & Submit and submits with "<authorisedSignature>", "<title>", and "<signatureFont>" and verifying alert success message as "Your C2 Return document has successfully been emailed to Mutual Drug.  Please contact customer service if you have additional questions."

    @C2Returns
    Examples: 
      | selectYourCustomerAccount             | authorisedSignature | title  | signatureFont        |
      | WALKERS DRUG STORE (PREMIER) - 124685 | test                | sample | Edwardian Script ITC |

  @RefrigratedItems
  Scenario Outline: Verifying Mutual Drug to Create Returns orders - Refrigerated Returns
    Given User is on the Mutual Drug Login
    When User perform login with Username, Password
    Then User should verify after login "<selectYourCustomerAccount>" and success message as "C2 CERTIFICATE NOTIFICATION !!"
    Then User navigates to the "Returns" page and verifies the page is displayed
    And User clicks on Create New to create a new return order
      | returnName                         | returnType   |
      | sample test -Refrigerated Return 1 | Refrigerated |
    And User adds Refrigerated  return  items by searching products:
      | searchRefrigeratedProducts | expirationDate | lotNumber | qty | returnReason                                                                      | successMessage     |
      |                     103507 | 12-02-2025     |     12345 |   1 | Refrigerated – (Customer Service Authorized)                                      | Return item added. |
      |                     107045 | 12-02-2025     |     12345 |   1 | Refrigerated – (Customer Service Authorized)                                      | Return item added. |
      |                     060574 | 12-02-2025     |     12345 |   1 | Refrigerated – Expired (1 month prior to and up to 2 months past expiration date) | Return item added. |
      |                     124990 | 12-02-2025     |     12345 |   1 | Refrigerated – Expired (1 month prior to and up to 2 months past expiration date) | Return item added. |
    And User adds return items using refined search criteria, sorting by sort By in sort Order order:
      | addSearchProducts | refineSearch | category   | sortBy      | sortOrder | expirationDate | lotNumber | qty | returnReason                                 |
      | HCL               | TAB          | Rx Generic | Description | A to Z    | 12-02-2025     |     12345 |   1 | Refrigerated – (Customer Service Authorized) |
    And User updates the return products list:
      | expirationDateGrid | lotNumberGrid | qtyGrid | returnReasonGrid                                                                  | updateAlertMessage |
      | 12-02-2025         |         00000 |       1 | Refrigerated – Expired (1 month prior to and up to 2 months past expiration date) | Return item added. |
    Then User should sort by Items and Product Description and delete an item from the return list, verifying the alert message  "Return item deleted."
    And User clicks on Sign & Submit and submits with "<authorisedSignature>", "<title>", and "<signatureFont>" and verifying alert success message as "Your Refrigerated Form has been submitted"

    Examples: 
      | selectYourCustomerAccount             | authorisedSignature | title  | signatureFont        |
      | WEB POS TEST STORE (PREMIER) - 009498 | test                | sample | Edwardian Script ITC |

  @ReturnsError
  Scenario Outline: Verifying Mutual Drug Returns - With out insert Return Name, Return Type and Return Name with Special Characters
    Given User is on the Mutual Drug Login
    When User perform login with Username, Password
    Then User should verify after login "<selectYourCustomerAccount>" and success message as "C2 CERTIFICATE NOTIFICATION !!"
    Then User navigates to the "Returns" page and verifies the page is displayed
    And User clicks on Create New without entering a Return Name, Return Type and clicks the Create
    Then User should see error messages "Return Name is required" and "Return Type is required"
    Then User should insert Return Name with Special Characters "Sample@!2#&*" and Choose Return Type "Regular" and verifies the error message as "Special characters not allowed"
    And User provides double space in the Return Name with "Regular" Return type and tries to create a Return then see the error message "Return Name is required"
    And User provides Single space in Return Name with "Regular" Return type and tries to create a Return then see the error message "Return Name is required"
    And User enters  more than 60  characters as the Return Name is " abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnop "with "Regular" Return type and tries to create a Return and User should see the Return Name in the breadcrumb as "abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefgh"

    Examples: 
      | selectYourCustomerAccount             |
      | WEB POS TEST STORE (PREMIER) - 009498 |

  @NegativeRegular
  Scenario Outline: Verifying Mutual Drug Returns -Regular Returns - Negative Test
    Given User is on the Mutual Drug Login
    When User perform login with Username, Password
    Then User should verify after login "<selectYourCustomerAccount>" and success message as "C2 CERTIFICATE NOTIFICATION !!"
    Then User navigates to the "Returns" page and verifies the page is displayed
    And User clicks on Create New to create a new return order
      | returnName                    | returnType |
      | Negative Test Regular Returns | Regular    |
    Then User clicks on Sign & Submit without adding any Items and verifies the warning message "Please add at least one item to submit."
    Then User attempts to add C2, refrigerated, discontinued, and inactive items in Regular returns then see the warning message "No matching product(s) found" for each item:
      | items  | warningMessage               |
      | 118182 | No matching product(s) found |
      | 272005 | No matching product(s) found |
      | 313353 | No matching product(s) found |
      | 103507 | No matching product(s) found |
      | 032839 | No matching product(s) found |
      | 060574 | No matching product(s) found |
    Then User adds a return by item number "025767" , does not select a return reason, clicks on Add to Return and verifies the warning message "Return reason is required."
    Then User insert invalid date with "dd-mm-0010" and clicks Add To Order then verifies the warning messages "Please select valid expiration date."
    Then User adds item "881011" with Reaturn Reason as "NR – Customer Service Authorized" and Clicks Add To Order without enter RA Number then verifies the warning messages "RA Number is required."
    And User adds return items by searching products insert nill qty verifies warning message
      | searchProducts | expirationDate | lotNumber | qty | returnReason                                | warningmessage               |
      |         025767 | 12-02-2025     |     00000 |   0 | Dated OTC/DME - Within 6 months of Purchase | Min allowed return qty is 1. |
      |         881011 | 15-02-2025     |      0123 |   0 | NR – Customer Service Authorized            | Min allowed return qty is 1. |
    And User adds return items by searching products:
      | searchProducts | expirationDate | lotNumber | qty | returnReason                                | successMessage     |
      |         025767 | 12-02-2025     |     00000 |   1 | Dated OTC/DME - Within 6 months of Purchase | Return item added. |
    And User enters a return quantity of "0" in the grid and sees the warning message "Min allowed return qty is 1."
    And User clicks on Sign & Submit and submits
    And User should clicks on Sign & Submit and Without entering Authorized Signature (Type First & Last Name), title then see the error message as "Authorized Signature is required" , "Title is required"

    Examples: 
      | selectYourCustomerAccount             |
      | WALKERS DRUG STORE (PREMIER) - 124685 |

  @NegativeTestC2Returns
  Scenario Outline: Verifying Mutual Drug Returns - C2 Returns - Negative Test
    Given User is on the Mutual Drug Login
    When User perform login with Username, Password
    Then User should verify after login "<selectYourCustomerAccount>" and success message as "C2 CERTIFICATE NOTIFICATION !!"
    Then User navigates to the "Returns" page and verifies the page is displayed
    And User clicks on Create New to create a new return order
      | returnName               | returnType |
      | Negative Test C2 Returns | C2         |
    Then User clicks on Sign & Submit without adding any Items and verifies the warning message "Please add at least one item to submit."
    Then User attempts to add Regular, refrigerated, discontinued, and inactive items in Regular returns then see the warning message "No matching product(s) found" for each item:
      | items  | warningMessage               |
      | 368902 | No matching product(s) found |
      | 851576 | No matching product(s) found |
      | 380568 | No matching product(s) found |
      | 218669 | No matching product(s) found |
      | 247585 | No matching product(s) found |
      | 031427 | No matching product(s) found |
      | 011544 | No matching product(s) found |
      | 804385 | No matching product(s) found |
    Then User adds a C2 return by item number "378729" with various missing fields (Expiration date, Lot Number, Qty, Return Reason) and verifies the corresponding warning messages: "Please select expiration date." , "Lot number is required." , "Min allowed return qty is 1." and "Return reason is required."
    Then User insert invalid date with "dd-mm-0010" and clicks Add To Order then verifies the warning messages "Please select valid expiration date."
    And User adds return items by searching products:
      | searchProducts | expirationDate | lotNumber | qty | returnReason                            | successMessage     |
      |         729129 | 12-02-2025     |     00123 |   1 | CII – 6 Months or Greater dating remain | Return item added. |
    And User enters a return quantity of "0" in the grid and sees the warning message "Min allowed return qty is 1."
    And User clicks on Sign & Submit and submits
    And User should clicks on Sign & Submit and Without entering Authorized Signature (Type First & Last Name), title then see the error message as "Authorized Signature is required" , "Title is required"

    Examples: 
      | selectYourCustomerAccount             |
      | WALKERS DRUG STORE (PREMIER) - 124685 |

  @NegativeTestRefrigeratedReturns
  Scenario Outline: Verifying Mutual Drug Returns - Refrigerated  Returns - Negative Test
    Given User is on the Mutual Drug Login
    When User perform login with Username, Password
    Then User should verify after login "<selectYourCustomerAccount>" and success message as "C2 CERTIFICATE NOTIFICATION !!"
    Then User navigates to the "Returns" page and verifies the page is displayed
    And User clicks on Create New to create a new return order
      | returnName                          | returnType   |
      | Negative Test Refrigerated  Returns | Refrigerated |
    Then User clicks on Sign & Submit without adding any Items and verifies the warning message "Please add at least one item to submit."
    Then User selects Don't want back all  without adding any Items and verifies the warning message "Please select one or more item(s)."
    Then User attempts to add Regular, C2, discontinued, and inactive items in refrigerated returns then see the warning message "No matching product(s) found" for each item:
      | items  | warningMessage               |
      | 368902 | No matching product(s) found |
      | 851576 | No matching product(s) found |
      | 380568 | No matching product(s) found |
      | 218669 | No matching product(s) found |
      | 247585 | No matching product(s) found |
      | 280941 | No matching product(s) found |
      | 407585 | No matching product(s) found |
      | 804385 | No matching product(s) found |
    Then User adds a return by item number "103507" , does not select a return reason, clicks on Add to Return and verifies the warning message "Return reason is required."
    Then User enters a return quantity of "0" and sees the warning message "Min allowed return qty is 1."
    Then User adds item "107045" with Reaturn Reason as "Refrigerated – (Customer Service Authorized)" and Clicks Add To Order without enter RA Number then verifies the warning messages "RA Number is required."
    Then User insert invalid date with "dd-mm-0010" and clicks Add To Order then verifies the warning messages "Please select valid expiration date."
    And User adds Refrigerated  return  items by searching products:
      | searchRefrigeratedProducts | expirationDate | lotNumber | qty | returnReason                                 | successMessage     |
      |                     103507 | 12-02-2025     |     12345 |   1 | Refrigerated – (Customer Service Authorized) | Return item added. |
    Then User insert invalid date with "dd-mm-0010" in the Grid then verifies the warning messages "Please select valid expiration date."
    And User enters a return quantity of "0" in the grid and sees the warning message "Min allowed return qty is 1."
    And User clicks on Sign & Submit and submits
    And User should clicks on Sign & Submit and Without entering Authorized Signature (Type First & Last Name), title then see the error message as "Authorized Signature is required" , "Title is required"

    Examples: 
      | selectYourCustomerAccount             |
      | WALKERS DRUG STORE (PREMIER) - 124685 |
