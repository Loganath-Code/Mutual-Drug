@OrderTemplatesAdmin
Feature: Verifying Admin User Order Templates webpage

  Scenario Outline: Verifying Admin user Order Templates Creation - Regular
    Given User is on the Mutual Drug Login
    When User perform admin login with Username, Password
    Then User should verify after successful login success message as "Member Users"
    And User navigates to Order Templates by selecting Administration, then Orders, and clicks on Order Templates to verify that the page title displays 'Order Templates'
    When User creates a new template, click on Create and enter "<templateName>" and "<templateType>" as the template details
    And User Adds the items/products using item number in Order Templates:
      | itemsNum | orderQty | successMessage       |
      |   285684 |        4 | Item # 285684 added. |
      |   485136 |        4 | Item # 485136 added. |
      |   379990 |        4 | Item # 379990 added. |
      |   643106 |        4 | Item # 643106 added. |
      |   349357 |        4 | Item # 349357 added. |
      |   309419 |        4 | Item # 309419 added. |
    Then User should update the Order Templates name "Test Order Template" and verifies success message as "Template name updated."
    And User verifies that the sorting functionality in both ascending and descending orders for items, Product Discriptions, Categories, Whs.qty and Added
    Then User updates item quantities in the grid and verifies that the "Success!" alert message is displayed.
    Then User deletes an item from the grid and verifies that the "Template item deleted." alert message is displayed.
    And User verifies the pagination functionality within the Order Templates grid
    And User navigates back to "Order Templates" using the breadcrumb link.
    When User clicks Create Customer Order with "<memberNumber>" and "<templates>" then clicks Create to submit
    Then User verifies the Success message as "Customer order created successfully!"
    And User clicks the logout button and verify successfully redirected to the login page
    When User perform login with Username, Password
    Then User should verify after login "<selectYourCustomerAccount>" and success message as "C2 CERTIFICATE NOTIFICATION !!"
    Then User navigates to Orders, selects Current Orders and verifies that the page is "Current Orders"
    Then User should search "Test Order Template" template name and verifies to displaying grid.

    Examples: 
      | templateName    | templateType | memberNumber       | templates           | selectYourCustomerAccount   |
      | Test Template 6 | Regular      | WALKERS DRUG STORE | Test Order Template | 124685 - WALKERS DRUG STORE |

  @c2OrderTemplates
  Scenario Outline: Verifying Admin User Order Templates Creation - C2
    Given User is on the Mutual Drug Login
    When User perform admin login with Username, Password
    Then User should verify after successful login success message as "Member Users"
    And User navigates to Order Templates by selecting Administration, then Orders, and clicks on Order Templates to verify that the page title displays 'Order Templates'
    When User creates a new template, click on Create and enter "<templateName>" and "<templateType>" as the template details
    And User Adds the items/products using item number in Order Templates:
      | itemsNum | orderQty | successMessage       |
      |   868586 |        2 | Item # 868586 added. |
      |   249532 |        2 | Item # 249532 added. |
      |   591438 |        2 | Item # 591438 added. |
      |   788596 |        2 | Item # 788596 added. |
      |   324673 |        2 | Item # 324673 added. |
      |   350876 |        2 | Item # 350876 added. |
      |   350884 |        1 | Item # 350884 added. |
    Then User should update the Order Templates name "Test Order Template" and verifies success message as "Template name updated."
    And User verifies that the sorting functionality in both ascending and descending orders for items, Product Discriptions, Categories, Whs.qty and Added
    Then User updates item quantities in the grid and verifies that the "Success!" alert message is displayed.
    Then User deletes an item from the grid and verifies that the "Template item deleted." alert message is displayed.
    And User verifies the pagination functionality within the Order Templates grid
    And User navigates back to "Order Templates" using the breadcrumb link.
    When User clicks Create Customer Order with "<memberNumber>" and "<templates>" then clicks Create to submit
    Then User verifies the Success message as "Customer order created successfully!"
    And User clicks the logout button and verify successfully redirected to the login page
    When User perform login with Username, Password
    Then User should verify after login "<selectYourCustomerAccount>" and success message as "C2 CERTIFICATE NOTIFICATION !!"
    Then User navigates to Orders, selects Current Orders and verifies that the page is "Current Orders"
    Then User should search "Test Order Template" template name and verifies to displaying grid.

    Examples: 
      | templateName    | templateType | memberNumber       | templates           | selectYourCustomerAccount   |
      | Test Template 6 | C2           | WALKERS DRUG STORE | Test Order Template | 124685 - WALKERS DRUG STORE |

  @OrderTemplates
  Scenario: Verifying Admin User Order Templates Webpage
    Given User is on the Mutual Drug Login
    When User perform admin login with Username, Password
    Then User should verify after successful login success message as "Member Users"
    And User navigates to Order Templates by selecting Administration, then Orders, and clicks on Order Templates to verify that the page title displays 'Order Templates'
    And User performs a search with the template name "Test Order Template" and confirms that the template appears in the displayed grid
    And User verifies that sorting works in both ascending and descending order for the columns: Template Name, Created Date, Template Type, and Total Lines
    Then User deletes a Order Template from the list and verifies the "Template deleted successfully." alert message
    And User verifies pagination functionality on the Order Templates

  @NegativeTemplate
  Scenario: Verifying Order Template Creation Validation - Negative
    Given User is on the Mutual Drug Login
    When User perform admin login with Username, Password
    Then User should verify after successful login success message as "Member Users"
    And User navigates to Order Templates by selecting Administration, then Orders, and clicks on Order Templates to verify that the page title displays 'Order Templates'
    When User Create New Order Template without entering any details and clicks Create
    Then User should verifies the error messages "Template Name is required" and "Template Type is required"
    Then User provides Space in Template Name with "Regular" Template type and tries to create an Template Order then see the error message "Template Name is required"
    Then User enter Template Name with special characters with "Regular@#$$$$" Template type and tries to create an Template Order and should see the error message "Special characters not allowed"
    Then User enters  more than 60  characters as the Order Templates Name is " abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnop "with "Regular" Templates type and tries to create a Order Templates and User should see the error message as "Template Name must be less than 60 characters"
    And User clicks Create Customer Order and without entering any details then clicks Create to submit
    Then User should verifies the displaying error message "Member Number is required" and "Template Name is required"
    Then User should insert invalid details tries to create Customer order
      | memberNumber       | templatesName        |
      | 1235555-WALKER     | Sample Test Template |
      | Walker!@#          | Sample Test Template |
      | WALKERS DRUG STORE | Sample Test Template |

  @negativeOrder
  Scenario Outline: Verifying Order Templates Validation
    Given User is on the Mutual Drug Login
    When User perform admin login with Username, Password
    Then User should verify after successful login success message as "Member Users"
    Then User navigates to Order Templates by selecting Administration, then Orders, and clicks on Order Templates to verify that the page title displays 'Order Templates'
    When User creates a new template, click on Create and enter "<templateName>" and "<templateType>" as the template details
    Then User clicks on Add without adding any Items and verifies the warning message "Item code is required."
    Then User adds a item number "379990" with an empty Order Qty field, clicks Add, and verifies the warning message "Enter valid Order Qty."
    Then User adds a item number "788596" , insert order qty as "0" clicks on Add and verifies the warning message "Enter valid Order Qty."
    Then User adds a item number "350876" , inputs an Order Qty greater than three digits "99999"  clicks on Add and verifies the warning message "Max allowed order qty is 999."
    Then User attempts to add C2 items "313353" in Regular order Templates and verifies the alert message "Cannot add C2 item to non C2 order."
    Then User attempts to add a discontinued and inactive item "010140" to a Regular Order Template and verifies the alert message "Item is not found or unavailable for purchase."
    And User Adds the items/products using item number in Order Templates:
      | itemsNum | orderQty | successMessage       |
      |   285684 |        4 | Item # 285684 added. |
    Then User attempts to add the same item "285684" again to the Order Template and verifies the warning message "Item already added to order."
    Then User attempts an item with an empty field Order Qty in list and verifies that the warning message "Enter valid Order Qty." is displayed.

    Examples: 
      | templateName    | templateType |
      | Test Template 6 | Regular      |
