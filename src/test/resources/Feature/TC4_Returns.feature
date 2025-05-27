@Returns
Feature: Verifying Mutual Drug Create Returns

  @ReturnsName
  Scenario Outline: Verifying Mutual Drug Returns Name
    Given User is on the Mutual Drug Login
    When User perform login with Username, Password
    Then User should verify after login "<selectYourCustomerAccount>" and success message as "Member Access Portal"
    And User should Read and Accept the Returns Policy Update
    When User navigates to Returns and clicks on "Unsubmitted"
    Then User should verify the breadcrumb title "Unsubmitted Returns" is displayed on the page
    And User clicks on Create New to create a new returns
      | returnName | returnType |
      |          1 | Regular    |
    And User removes the Returns name and navigates back to the Returns page
    And User searches for a returns name " 1" and verifies that the grid displays the returns name is "1"
    And User verifies sorting order in both ascending and descending order for all columns Return Name, Status, Submitted Date, Submitted By, Type, Total Lines, and Total Pieces
    Then User deletes a return order from the returns list and verifies the "Return details deleted." alert message
    And User verifies pagination functionality on the Returns page

    Examples: 
      | selectYourCustomerAccount             |
      | WEB POS TEST STORE (PREMIER) - 009498 |

  @RegularReturns
  Scenario Outline: Verifying Mutual Drug to Create Returns - Regular Returns
    Given User is on the Mutual Drug Login
    When User perform login with Username, Password
    Then User should verify after login "<selectYourCustomerAccount>" and success message as "Member Access Portal"
    And User should Read and Accept the Returns Policy Update
    When User navigates to Returns and clicks on "Unsubmitted"
    Then User should verify the breadcrumb title "Unsubmitted Returns" is displayed on the page
    And User clicks on Create New to create a new returns
      | returnName                  | returnType |
      | sample test -Regular Return | Regular    |
    And User adds returns items by searching products:
      | products | expirationDate | lotNumber | qty | returnReason                                                            | successMessage     |
      |   025767 | 12-02-2025     |     00000 |   1 | Dated OTC/DME - Within 6 months of Purchase                             | Return item added. |
      |   420745 | 13-02-2025     |     11111 |   1 | Non-Dated OTC/DME - Within 24 Months of Purchase                        | Return item added. |
      |   164814 | 13-02-2025     |     11111 |   1 | NR – Customer Service Authorized                                        | Return item added. |
      |   482208 | 14-02-2025     |      0123 |   2 | OTC – Meets Salable Criteria                                            | Return item added. |
      |   728717 | 14-02-2025     |      0123 |   1 | Recall                                                                  | Return item added. |
      |   268573 | 14-02-2025     |      0123 |   1 | Received Damaged - (Customer Service Notified)                          | Return item added. |
      |   881094 | 15-02-2025     |      0123 |   1 | Received Defective - (Customer Service Notified)                        | Return item added. |
      |   852350 | 15-02-2025     |      0123 |   1 | Received Short Dated - (Customer Service Notified)                      | Return item added. |
      |   323667 | 15-02-2025     |      0123 |   1 | Rx – Expired (1 month prior to and up to 2 months past expiration date) | Return item added. |
      |   555888 | 15-02-2025     |      0123 |   1 | Rx - Meets Salable Criteria                                             | Return item added. |
      |   555888 | 15-02-2025     |      0123 |   1 | Store Did not Order - (Customer Service Notified)                       | Return item added. |
      |   288936 | 15-02-2025     |      0123 |   1 | NR – Customer Service Authorized                                        | Return item added. |
      |   482208 | 15-02-2025     |      0123 |   1 | Rx – Expired (1 month prior to and up to 2 months past expiration date) | Return item added. |
      |   407551 | 15-02-2025     |      0123 |   1 | Recall                                                                  | Return item added. |
      |   359091 | 15-02-2025     |      0123 |   1 | Received Damaged - (Customer Service Notified)                          | Return item added. |
      |   486944 | 15-02-2025     |      0123 |   1 | Received Short Dated - (Customer Service Notified)                      | Return item added. |
      |   476705 | 15-02-2025     |      0123 |   1 | Received Short Dated - (Customer Service Notified)                      | Return item added. |
      |   323667 | 15-02-2025     |      0123 |   1 | NR – Customer Service Authorized                                        | Return item added. |
      |   255695 | 15-02-2025     |      0123 |   1 | OTC – Meets Salable Criteria                                            | Return item added. |
      |   025767 | 15-02-2025     |      0123 |   1 | Received Damaged - (Customer Service Notified)                          | Return item added. |
    And User should Add Returns items Using NDC, Product Description then add Quantity with Return Reason to clicks Add To Return
      | products                             | expirationDate | lotNumber | qty | returnReason                                   | successMessage     |
      |                          51672130005 | 21-05-2025     |      0123 |   1 | Received Damaged - (Customer Service Notified) | Return item added. |
      |                          00135052904 | 21-05-2025     |      0123 |   1 | Recall                                         | Return item added. |
      | BIOTENE TOOTHPASTE FRESH MINT 4.3 OZ | 21-05-2025     |      0123 |   1 | OTC – Meets Salable Criteria                   | Return item added. |
    And User Adds Returns items using UPC then add Quantity with Return Reason to clicks Add To Return:
      | products    | expirationDate | lotNumber | qty | returnReason                                                            | successMessage     |
      | 84009314006 | 21-05-2025     |      1234 |   1 | NR – Customer Service Authorized                                        | Return item added. |
      | 84009310231 | 21-05-2025     |      1234 |   1 | Rx – Expired (1 month prior to and up to 2 months past expiration date) | Return item added. |
    And User Adds Add Returns items using GTIN then add Quantity with Return Reason to clicks Add To Return:
      | products       | expirationDate | lotNumber | qty | returnReason                 | successMessage     |
      | 00075486087432 | 21-05-2025     |     01234 |   1 | Recall                       | Return item added. |
      | 00075486087548 | 21-05-2025     |     01234 |   1 | OTC – Meets Salable Criteria | Return item added. |
    And User adds "Regular" returns items using refined search criteria, sorting by sort By in sort Order order:
      | addSearchProducts | refineSearch | category               | sortBy      | sortOrder | expirationDate | lotNumber | qty | returnReasons | successMessage     |
      | advil             | wing         | Over the Counter (OTC) | Description | A to Z    | 12-02-2025     |     11111 |   3 | Recall        | Return item added. |
    And User updates the "Regular" Returns product list:
      | expirationDateGrid | lotNumberGrid | qtyGrid | returnReasonGrid | updateAlertMessage   |
      | 12-02-2025         |          1234 |       2 | Recall           | Return item updated. |
    And User can change Returns name as "Regular Return Automation Test" then  verifying the alert message  "Return name updated."
    Then User should sort by Items and Product Description and delete an item from the return list, verifying the alert message  "Return item deleted."
    And User should navigate through pages using pagination controls on the Returns items page
    And User clicks on Sign & Submit and submits with "<authorisedSignature>", "<title>", and "<signatureFont>" and verifying alert success message as "Your Regular Form has been submitted"

    @RegularItems
    Examples: 
      | selectYourCustomerAccount             | authorisedSignature | title  | signatureFont        |
      | WEB POS TEST STORE (PREMIER) - 009498 | test                | sample | Edwardian Script ITC |

  Scenario Outline: Verifying Mutual Drug to Create Returns - C2 Returns
    Given User is on the Mutual Drug Login
    When User perform login with Username, Password
    Then User should verify after login "<selectYourCustomerAccount>" and success message as "Member Access Portal"
    And User should Read and Accept the Returns Policy Update
    When User navigates to Returns and clicks on "Unsubmitted"
    Then User should verify the breadcrumb title "Unsubmitted Returns" is displayed on the page
    And User clicks on Create New to create a new returns
      | returnName                  | returnType |
      | sample test - C2 Return - 4 | C2         |
    And User adds "C2" returns items by searching products:
      | products | expirationDate | lotNumber | qty | returnReason                            | successMessage     |
      |   272005 | 12-02-2025     |     00000 |   1 | CII – 6 Months or Greater dating remain | Return item added. |
      |   313353 | 12-02-2025     |     11111 |   1 | CII – 6 Months or Greater dating remain | Return item added. |
      |   313361 | 12-02-2025     |     11111 |   1 | CII – 6 Months or Greater dating remain | Return item added. |
      |   116186 | 12-02-2025     |     11111 |   1 | CII – 6 Months or Greater dating remain | Return item added. |
    And User should Add Returns items Using NDC, Product Description then add Quantity with Return Reason to clicks Add To Return
      | products                                 | expirationDate | lotNumber | qty | returnReason                            | successMessage     |
      |                              70165001030 | 21-02-2025     |    012345 |   1 | CII – 6 Months or Greater dating remain | Return item added. |
      |                              43598089701 | 21-02-2025     |    012345 |   1 | CII – 6 Months or Greater dating remain | Return item added. |
      |                              24510011010 | 21-02-2025     |    012345 |   1 | CII – 6 Months or Greater dating remain | Return item added. |
      |                              31722093001 | 21-02-2025     |    012345 |   1 | CII – 6 Months or Greater dating remain | Return item added. |
      | METHADONE HCL TAB 10 MG 100 ASCEND       | 21-02-2025     |    012345 |   1 | CII – 6 Months or Greater dating remain | Return item added. |
      | MORPHINE SULFATE ER TAB 60 MG 100 RHODES | 21-02-2025     |    012345 |   1 | CII – 6 Months or Greater dating remain | Return item added. |
    And User Adds Returns items using UPC then add Quantity with Return Reason to clicks Add To Return:
      | products    | expirationDate | lotNumber | qty | returnReason                            | successMessage     |
      | 34285840745 | 12-02-2025     |    012345 |   1 | CII – 6 Months or Greater dating remain | Return item added. |
      | 30591390219 | 12-02-2025     |    012345 |   1 | CII – 6 Months or Greater dating remain | Return item added. |
      | 34778117801 | 12-02-2025     |    012345 |   1 | CII – 6 Months or Greater dating remain | Return item added. |
    And User Adds Add Returns items using GTIN then add Quantity with Return Reason to clicks Add To Return:
      | products       | expirationDate | lotNumber | qty | returnReason                            | successMessage     |
      | 00324510291605 | 12-02-2025     |    012345 |   1 | CII – 6 Months or Greater dating remain | Return item added. |
      | 00359011460106 | 12-02-2025     |    012345 |   1 | CII – 6 Months or Greater dating remain | Return item added. |
      | 00310702018013 | 12-02-2025     |    012345 |   1 | CII – 6 Months or Greater dating remain | Return item added. |
      | 00342858804011 | 12-02-2025     |    012345 |   1 | CII – 6 Months or Greater dating remain | Return item added. |
    And User adds "C2" returns items using refined search criteria, sorting by sort By in sort Order order:
      | addSearchProducts | refineSearch | category   | sortBy      | sortOrder | expirationDate | lotNumber | qty | returnReason                            | successMessage     |
      | HCL               | CAP          | Rx Generic | Description | A to Z    | 12-02-2025     |     11111 |   3 | CII – 6 Months or Greater dating remain | Return item added. |
    And User updates the "C2" Returns product list:
      | expirationDateGrid | lotNumberGrid | qtyGrid | returnReasonGrid                        | updateAlertMessage   |
      | 12-02-2025         |         12345 |       2 | CII – 6 Months or Greater dating remain | Return item updated. |
    And User can change Returns name as "C2 Return Automation Test" then  verifying the alert message  "Return name updated."
    Then User should sort by Items and Product Description and delete an item from the return list, verifying the alert message  "Return item deleted."
    And User should navigate through pages using pagination controls on the Returns items page
    And User clicks on Sign & Submit and submits with "<authorisedSignature>", "<title>", and "<signatureFont>" and verifying alert success message as "Your C2 Return document has successfully been emailed to Mutual Drug. Please contact customer service if you have additional questions."
    And User should Cliks Print Returns then view the PDF document

    @C2Returns
    Examples: 
      | selectYourCustomerAccount             | authorisedSignature | title  | signatureFont        |
      | WALKERS DRUG STORE (PREMIER) - 124685 | test                | sample | Edwardian Script ITC |

  @RefrigratedItems
  Scenario Outline: Verifying Mutual Drug to Create Returns - Refrigerated Returns
    Given User is on the Mutual Drug Login
    When User perform login with Username, Password
    Then User should verify after login "<selectYourCustomerAccount>" and success message as "Member Access Portal"
    And User should Read and Accept the Returns Policy Update
    When User navigates to Returns and clicks on "Unsubmitted"
    Then User should verify the breadcrumb title "Unsubmitted Returns" is displayed on the page
    And User clicks on Create New to create a new returns
      | returnName                          | returnType   |
      | sample test - Refrigerated Return 1 | Refrigerated |
    And User adds "Refrigerated" returns items by searching products:
      | products | expirationDate | lotNumber | qty | returnReason                                                                      | successMessage     |
      |   103507 | 12-02-2025     |     12345 |   1 | Refrigerated – (Customer Service Authorized)                                      | Return item added. |
      |   107045 | 12-02-2025     |     12345 |   1 | Refrigerated – (Customer Service Authorized)                                      | Return item added. |
      |   060574 | 12-02-2025     |     12345 |   1 | Refrigerated – Expired (1 month prior to and up to 2 months past expiration date) | Return item added. |
      |   124990 | 12-02-2025     |     12345 |   1 | Refrigerated – Expired (1 month prior to and up to 2 months past expiration date) | Return item added. |
    And User should Add Returns items Using NDC, Product Description then add Quantity with Return Reason to clicks Add To Return
      | products                                   | expirationDate | lotNumber | qty | returnReason                                                                      | successMessage     |
      |                                45802073684 | 12-02-2025     |     12345 |   1 | Refrigerated – (Customer Service Authorized)                                      | Return item added. |
      |                                00169770421 | 12-02-2025     |     12345 |   1 | Refrigerated – (Customer Service Authorized)                                      | Return item added. |
      |                                67457023901 | 12-02-2025     |     12345 |   1 | Refrigerated – Expired (1 month prior to and up to 2 months past expiration date) | Return item added. |
      |                                00002751101 | 12-02-2025     |     12345 |   1 | Refrigerated – Expired (1 month prior to and up to 2 months past expiration date) | Return item added. |
      | INSULIN HUMULIN KWIKPEN N 3 ML 5           | 12-02-2025     |     12345 |   1 | Refrigerated – (Customer Service Authorized)                                      | Return item added. |
      | INSULIN HUMULIN KWIKPEN R U-500 3 ML CTN/2 | 12-02-2025     |     12345 |   1 | Refrigerated – Expired (1 month prior to and up to 2 months past expiration date) | Return item added. |
    And User Adds Returns items using UPC then add Quantity with Return Reason to clicks Add To Return:
      | products    | expirationDate | lotNumber | qty | returnReason                                                                      | successMessage     |
      | 30002871501 | 12-02-2025     |     12345 |   1 | Refrigerated – (Customer Service Authorized)                                      | Return item added. |
      | 73993027566 | 12-02-2025     |     12345 |   1 | Refrigerated – Expired (1 month prior to and up to 2 months past expiration date) | Return item added. |
      | 30781323434 | 12-02-2025     |     12345 |   1 | Refrigerated – (Customer Service Authorized)                                      | Return item added. |
      | 35551392410 | 12-02-2025     |     12345 |   1 | Refrigerated – Expired (1 month prior to and up to 2 months past expiration date) | Return item added. |
    And User Adds Add Returns items using GTIN then add Quantity with Return Reason to clicks Add To Return:
      | products       | expirationDate | lotNumber | qty | returnReason                                                                      | successMessage     |
      | 00300027712277 | 12-02-2025     |     12345 |   1 | Refrigerated – (Customer Service Authorized)                                      | Return item added. |
      | 00300064121025 | 12-02-2025     |     12345 |   1 | Refrigerated – (Customer Service Authorized)                                      | Return item added. |
      | 00301692800153 | 12-02-2025     |     12345 |   1 | Refrigerated – Expired (1 month prior to and up to 2 months past expiration date) | Return item added. |
    And User adds "Refrigrated" returns items using refined search criteria, sorting by sort By in sort Order order:
      | addSearchProducts | refineSearch | category   | sortBy      | sortOrder | expirationDate | lotNumber | qty | returnReason                                 |
      | HCL               | TAB          | Rx Generic | Description | A to Z    | 12-02-2025     |     12345 |   1 | Refrigerated – (Customer Service Authorized) |
    And User updates the "Refrigrated" Returns product list:
      | expirationDateGrid | lotNumberGrid | qtyGrid | returnReasonGrid                                                                  | updateAlertMessage   |
      | 12-02-2025         |         00000 |       1 | Refrigerated – Expired (1 month prior to and up to 2 months past expiration date) | Return item updated. |
    And User can change Returns name as "Refrigrated Return Automation Test" then  verifying the alert message  "Return name updated."
    Then User should sort by Items and Product Description and delete an item from the return list, verifying the alert message  "Return item deleted."
    And User should navigate through pages using pagination controls on the Returns items page
    Then User clicks on Sign & Submit and submits with "<authorisedSignature>", "<title>", and "<signatureFont>" and verifying alert success message as "Your Refrigerated Form has been submitted"

    Examples: 
      | selectYourCustomerAccount             | authorisedSignature | title  | signatureFont        |
      | WALKERS DRUG STORE (PREMIER) - 124685 | test                | sample | Edwardian Script ITC |

  @ReturnsError
  Scenario Outline: Verifying Mutual Drug Returns - With out insert Return Name, Return Type and Return Name with Special Characters
    Given User is on the Mutual Drug Login
    When User perform login with Username, Password
    Then User should verify after login "<selectYourCustomerAccount>" and success message as "Member Access Portal"
    And User should Read and Accept the Returns Policy Update
    When User navigates to Returns and clicks on "Unsubmitted"
    Then User should verify the breadcrumb title "Unsubmitted Returns" is displayed on the page
    And User clicks on Create New without entering a Return Name, Return Type and clicks the Create
    Then User should see error messages "Return Name is required" and "Return Type is required"
    Then User should insert Return Name with Special Characters "Sample@!2#&*" and Choose Return Type "Regular" and verifies the error message as "Special characters not allowed"
    And User provides double space in the Return Name with "Regular" Return type and tries to create a Return then see the error message "Return Name is required"
    And User provides Single space in Return Name with "Regular" Return type and tries to create a Return then see the error message "Return Name is required"
    And User enters  more than 60  characters as the Return Name is "abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnop" with "Regular" Return type and tries to create a Return and User should see the Return Name in the breadcrumb as "abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefgh"

    Examples: 
      | selectYourCustomerAccount             |
      | WEB POS TEST STORE (PREMIER) - 009498 |

  @NegativeRegular
  Scenario Outline: Verifying Mutual Drug Returns - Regular Returns - Negative Test
    Given User is on the Mutual Drug Login
    When User perform login with Username, Password
    Then User should verify after login "<selectYourCustomerAccount>" and success message as "Member Access Portal"
    And User should Read and Accept the Returns Policy Update
    When User navigates to Returns and clicks on "Unsubmitted"
    Then User should verify the breadcrumb title "Unsubmitted Returns" is displayed on the page
    And User clicks on Create New to create a new returns
      | returnName                    | returnType |
      | Negative Test Regular Returns | Regular    |
    Then User clicks on Sign & Submit without adding any Items and verifies the warning message "Please add at least one item to submit."
    And User searches for item "025767" and verifies input validation on the Returns quantity field
    Then User validated return reason with "Closed out item" with "498030" and see the error message "Close out items cannot be returned."
    Then User validated return reason with "Short Dated item" with "515536" and see the error message "Short dated items cannot be returned."
    Then User attempts to add "C2, refrigerated" and discontinued items in "Regular returns" then see the warning message "No matching product(s) found" for each item:
      | products |
      |   118182 |
      |   272005 |
      |   313353 |
      |   103507 |
      |   032839 |
      |   060574 |
    Then User attempts to add "C2, refrigerated" and discontinued items using NDC and Product Discriptions in "Regular returns" then see the warning message "No matching product(s) found" for each item:
      | products                                      |
      |                                   42858080401 |
      |                                   00781325089 |
      |                                        107045 |
      | AMPHETAMINE SALTS ER CAP 20 MG 100 ELITE      |
      | AMPHETAMINE SALTS ER CAP 20 MG 100 RHODES     |
      | ORENCIA INJ SUBQ 125 MG/ML CTN/4 U/S SYRINGES |
    Then User attempts to add "C2, refrigerated" and discontinued items using UPC in "Regular returns" then see the warning message "No matching product(s) found" for each item:
      | products    |
      | 30781325089 |
      | 34928179051 |
    Then User attempts to add "C2, refrigerated" and discontinued items using GTIN in "Regular returns" then see the warning message "No matching product(s) found" for each item:
      | products       |
      | 00354092383016 |
    Then User adds a returns by item number "025767", does not select a return reason, clicks on Add to Return and verifies the warning message "Return reason is required."
    Then User insert invalid date with "dd-mm-0010" and clicks Add To Order then verifies the warning messages "Please select valid expiration date."
    Then User adds item "881011" with Reaturn Reason as "NR – Customer Service Authorized" and Clicks Add To Order without enter RA Number then verifies the warning messages "RA Number is required."
    And User adds return items by searching products insert nill qty verifies warning message
      | products | expirationDate | lotNumber | qty | returnReason                                | warningmessage               |
      |   025767 | 12-02-2025     |     00000 |   0 | Dated OTC/DME - Within 6 months of Purchase | Min allowed return qty is 1. |
      |   881011 | 15-02-2025     |      0123 |   0 | NR – Customer Service Authorized            | Min allowed return qty is 1. |
    And User adds returns items by searching products:
      | products | expirationDate | lotNumber | qty | returnReason                                | successMessage     |
      |   025767 | 12-02-2025     |     00000 |   1 | Dated OTC/DME - Within 6 months of Purchase | Return item added. |
    Then User insert invalid date with "dd-mm-0010" in the Grid then verifies the warning messages "Please select valid expiration date."
    And User enters a returns quantity of "0" in the grid and sees the warning message "Min allowed return qty is 1."
    And User clicks on Sign & Submit and submits
    And User should clicks on Sign & Submit and Without entering Authorized Signature (Type First & Last Name), title then see the error message as "Authorized Signature is required" , "Title is required"

    Examples: 
      | selectYourCustomerAccount             |
      | WALKERS DRUG STORE (PREMIER) - 124685 |

  @NegativeTestC2Returns
  Scenario Outline: Verifying Mutual Drug Returns - C2 Returns - Negative Test
    Given User is on the Mutual Drug Login
    When User perform login with Username, Password
    Then User should verify after login "<selectYourCustomerAccount>" and success message as "Member Access Portal"
    And User should Read and Accept the Returns Policy Update
    When User navigates to Returns and clicks on "Unsubmitted"
    Then User should verify the breadcrumb title "Unsubmitted Returns" is displayed on the page
    And User clicks on Create New to create a new returns
      | returnName               | returnType |
      | Negative Test C2 Returns | C2         |
    Then User clicks on Sign & Submit without adding any Items and verifies the warning message "Please add at least one item to submit."
    And User searches for item "30591390219" and verifies input validation on the Returns quantity field
    Then User attempts to add "Regular, refrigerated" and discontinued items in "C2 returns" then see the warning message "No matching product(s) found" for each item:
      | products |
      |   368902 |
      |   851576 |
      |   380568 |
      |   218669 |
      |   247585 |
      |   031427 |
      |   011544 |
      |   804385 |
      |   486480 |
    Then User attempts to add "Regular, refrigerated" and discontinued items using NDC and Product Discriptions in "C2 returns" then see the warning message "No matching product(s) found" for each item:
      | products                                    |
      |                                 59385002260 |
      |                                 00536120610 |
      |                                 49281079051 |
      |                                 65628007010 |
      |                                      215491 |
      |                                 42385096230 |
      | SACCHAROMYCES BOULARDII 30 VINCO            |
      | FIRST OMEPRAZOLE 2 MG/ML SUSP COMP KIT 3 OZ |
      | INSULIN HUMULIN KWIKPEN R U-500 3 ML CTN/2  |
    Then User attempts to add "Regular, refrigerated" and discontinued items using UPC in "C2 returns" then see the warning message "No matching product(s) found" for each item:
      | products    |
      | 36908723712 |
      | 36787745747 |
      | 05884795096 |
      | 05884795096 |
      |      293076 |
      | 85708400008 |
      | 09698601326 |
      | 34238596230 |
      | 73993027566 |
    Then User attempts to add "Regular, refrigerated" and discontinued items using GTIN in "C2 returns" then see the warning message "No matching product(s) found" for each item:
      | products       |
      | 00342385962307 |
      | 00058847950965 |
      | 00300939293673 |
      | 00058847950965 |
      | 00300032188111 |
      | 00857084000088 |
      | 00096986013264 |
      | 00739930275669 |
    Then User adds a C2 returns by item number "378729" with various missing fields (Expiration date, Lot Number, Qty, Return Reason) and verifies the corresponding warning messages: "Please select expiration date." , "Lot number is required." , "Min allowed return qty is 1." and "Return reason is required."
    Then User insert invalid date with "dd-mm-0010" and clicks Add To Order then verifies the warning messages "Please select valid expiration date."
    And User adds return items by searching products insert nill qty verifies warning message
      | products    | expirationDate | lotNumber | qty | returnReason                            | warningmessage               |
      | 34285840745 | 12-02-2025     |    012345 |   0 | CII – 6 Months or Greater dating remain | Min allowed return qty is 1. |
    And User adds returns items by searching products:
      | products | expirationDate | lotNumber | qty | returnReason                            | successMessage     |
      |   729129 | 12-02-2025     |     00123 |   1 | CII – 6 Months or Greater dating remain | Return item added. |
    And User enters a returns quantity of "0" in the grid and sees the warning message "Min allowed return qty is 1."
    Then User insert invalid date with "dd-mm-0010" in the Grid then verifies the warning messages "Please select valid expiration date."
    And User clicks on Sign & Submit and submits
    And User should clicks on Sign & Submit and Without entering Authorized Signature (Type First & Last Name), title then see the error message as "Authorized Signature is required" , "Title is required"

    Examples: 
      | selectYourCustomerAccount             |
      | WALKERS DRUG STORE (PREMIER) - 124685 |

  @NegativeTestRefrigeratedReturns
  Scenario Outline: Verifying Mutual Drug Returns - Refrigerated  Returns - Negative Test
    Given User is on the Mutual Drug Login
    When User perform login with Username, Password
    Then User should verify after login "<selectYourCustomerAccount>" and success message as "Member Access Portal"
    And User should Read and Accept the Returns Policy Update
    When User navigates to Returns and clicks on "Unsubmitted"
    Then User should verify the breadcrumb title "Unsubmitted Returns" is displayed on the page
    And User clicks on Create New to create a new returns
      | returnName                          | returnType   |
      | Negative Test Refrigerated  Returns | Refrigerated |
    Then User clicks on Sign & Submit without adding any Items and verifies the warning message "Please add at least one item to submit."
    Then User selects Don't want back all  without adding any Items and verifies the warning message "Please select one or more item(s)."
    Then User attempts to add "Regular, C2" and discontinued items in "Refrigerated returns" then see the warning message "No matching product(s) found" for each item:
      | products |
      |   368902 |
      |   851576 |
      |   380568 |
      |   218669 |
      |   247585 |
      |   280941 |
      |   407585 |
      |   804385 |
    Then User attempts to add "Regular, C2" and discontinued items using NDC and Product Discriptions in "Refrigerated returns" then see the warning message "No matching product(s) found" for each item:
      | products                                     |
      |                                  50474087015 |
      |                                  59385002360 |
      |                                  54092038501 |
      |                                  31722095005 |
      |                                  42385096230 |
      | BIOTENE TOOTHPASTE FRESH MINT 4.3 OZ         |
      | MORPHINE SULFATE ER TAB 60 MG 100 RHODES     |
      | ADVANTAGE RUBBER BANDS NATURAL ASST 2 OZ     |
      | AIR FRESHENER ADJ LAVENDAR & CHAM 6 OZ CS/12 |
      | ABACAVIR SULFATE TAB 300 MG 60 CIPLA         |
    Then User attempts to add "Regular, C2" and discontinued items using UPC in "Refrigerated returns" then see the warning message "No matching product(s) found" for each item:
      | products    |
      | 84009314006 |
      | 84009310231 |
      | 07181526131 |
      | 05884795096 |
    Then User attempts to add "Regular, C2" and discontinued items using GTIN in "Refrigerated returns" then see the warning message "No matching product(s) found" for each item:
      | products       |
      | 00300032188111 |
      | 00857084000088 |
      | 00096986013264 |
      | 00739930275669 |
    Then User adds a returns by item number "103507", does not select a return reason, clicks on Add to Return and verifies the warning message "Return reason is required."
    And User adds return items by searching products insert nill qty verifies warning message
      | products | expirationDate | lotNumber | qty | returnReason                                                                      | warningmessage               |
      |   124990 | 12-02-2025     |     12345 |   1 | Refrigerated – Expired (1 month prior to and up to 2 months past expiration date) | Min allowed return qty is 1. |
    Then User adds item "107045" with Reaturn Reason as "Refrigerated – (Customer Service Authorized)" and Clicks Add To Order without enter RA Number then verifies the warning messages "RA Number is required."
    Then User insert invalid date with "dd-mm-0010" and clicks Add To Order then verifies the warning messages "Please select valid expiration date."
    And User adds returns items by searching products:
      | products | expirationDate | lotNumber | qty | returnReason                                 | successMessage     |
      |   103507 | 12-02-2025     |     12345 |   1 | Refrigerated – (Customer Service Authorized) | Return item added. |
    Then User insert invalid date with "dd-mm-0010" in the Grid then verifies the warning messages "Please select valid expiration date."
    And User enters a returns quantity of "0" in the grid and sees the warning message "Min allowed return qty is 1."
    And User clicks on Sign & Submit and submits
    And User should clicks on Sign & Submit and Without entering Authorized Signature (Type First & Last Name), title then see the error message as "Authorized Signature is required" , "Title is required"

    Examples: 
      | selectYourCustomerAccount             |
      | WALKERS DRUG STORE (PREMIER) - 124685 |

  @SubmittedReturns
  Scenario Outline: Verifying Mutual Drug Returns - Submitted Returns
    Given User is on the Mutual Drug Login
    When User perform login with Username, Password
    Then User should verify after login "<selectYourCustomerAccount>" and success message as "Member Access Portal"
    And User should Read and Accept the Returns Policy Update
    When User navigates to Returns and clicks on "Submitted"
    Then User should verify the breadcrumb title "Submitted Returns" is displayed on the page
    When User searches for "Return 1" using the search box and clicks the Search
    Then the results should include rows containing "Return 1" in Return Name
    When User selects "Regular" from the "Type" dropdown and clicks the "Search" button
    Then User verifies submitted returns of type "Regular" should be displayed
    When User selects the Submitted From Date as "06/01/2021", the Submitted To Date as "06/30/2021", and clicks the "Search" button.
    Then User verifies submitted returns within the date range "06/01/2021" to "06/30/2021" should be displayed

    Examples: 
      | selectYourCustomerAccount             |
      | WALKERS DRUG STORE (PREMIER) - 124685 |

  @Acknowledgement
  Scenario Outline: Verifying Mutual Drug Returns - Submitted Returns
    Given User is on the Mutual Drug Login
    When User perform login with Username, Password
    Then User should verify after login "<selectYourCustomerAccount>" and success message as "Member Access Portal"
    And User should Read and Accept the Returns Policy Update
    When User navigates to Returns and clicks on "Acknowledgements"
    Then User should verify the breadcrumb title "Return Acknowledgements" is displayed on the page
