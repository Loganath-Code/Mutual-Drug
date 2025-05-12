@Notification
Feature: Verifying Mutual Drug Create Notification list

  Scenario Outline: Verifying creation of a notification list for Regular and C2 Orders
    Given User is on the Mutual Drug Login
    When User perform login with Username, Password
    Then User should verify after login "<selectYourCustomerAccount>" and success message as "C2 CERTIFICATE NOTIFICATION !!"
    Then User should navigates to Notification list and verifies that the page is "Notifications"
    And User clicks on Create Notification Group to Create New Notification Group
      | groupName                     | groupType     | successMessage              |
      | Sample Test Regular Notify me | Regular Order | Notification Group Created. |
      | Sample test c2- Notify Me     | C2 Order      | Notification Group Created. |
    And User searches for products with zero warehouse quantity and clicks on Notify Me, inserting details via the Notify Me form:
      | globalSearchitem | chooseNotificationGroup       | email                        | phoneNo    | alertMessage                                  |
      |           527580 | Sample Test Regular Notify me | loga.nagaraj@datacaliper.com | 9500232691 | Item #527580 added in the Notification group! |
      |           512285 | Sample Test Regular Notify me | loga.nagaraj@datacaliper.com | 9500232691 | Item #512285 added in the Notification group! |
      |           466334 | Sample test c2- Notify Me     | loga.nagaraj@datacaliper.com | 9500232691 | Item #466334 added in the Notification group! |
      |           466433 | Sample test c2- Notify Me     | loga.nagaraj@datacaliper.com | 9500232691 | Item #466433 added in the Notification group! |
    When User should navigates to Notification list and search by notification group name "Sample Test Regular Notify me"
    Then User Update the Notification Group Name "Sample Test Regular" and verify the alert message "Notification Group name updated."
    Then User should update the email and phone number, click on Update All, and verify the alert message "Successfully updated email and phonenumber for overall items"
    Then User deletes the notification item and see the message "Delete NotificationItem Successfully"

    @NotificationOrder
    Examples: 
      | selectYourCustomerAccount             |
      | WALKERS DRUG STORE (PREMIER) - 124685 |

  Scenario Outline: Verifying creation of a notification list for Regular and C2 Orders
    Given User is on the Mutual Drug Login
    When User perform login with Username, Password
    Then User should verify after login "<selectYourCustomerAccount>" and success message as "C2 CERTIFICATE NOTIFICATION !!"
    Then User should navigates to Notification list and verifies that the page is "Notifications"
    And User clicks on Create Notification Group to Create New Notification Group
      | groupName   | groupType     | successMessage              |
      | Sample Test | Regular Order | Notification Group Created. |
    And User performs a search "Sample Test" and verifies the correct search results
    And User performs sorts by group name and group type in both ascending and descending order
    Then User deletes the Notification Group and see the message "Notification Group Deleted Successfully"
    And User performs pagination to navigate between pages and verifies the results on each page

    @NotificationPage
    Examples: 
      | selectYourCustomerAccount             |
      | WALKERS DRUG STORE (PREMIER) - 124685 |

  @Notification_Negative
  Scenario Outline: Verifying creation of a notification list - Negative
    Given User is on the Mutual Drug Login
    When User perform login with Username, Password
    Then User should verify after login "<selectYourCustomerAccount>" and success message as "C2 CERTIFICATE NOTIFICATION !!"
    Then User should navigates to Notification list and verifies that the page is "Notifications"
    When User clicks on the Create Notification Group button without entering any information and then clicks on Create
    Then User should verify the error message "Group Name is required" , "Group is required".
    And User tries to create a notification group with a special character in the group name, "Regular" group type  then verify the error message "Special characters not allowed"
    Then User provides Single space in Group Name with "Regular" group type and tries to create a Notification Group then  verify the error message "Group Name is required"

    Examples: 
      | selectYourCustomerAccount             |
      | WEB POS TEST STORE (PREMIER) - 009498 |

  @Notification_NegativeGroup
  Scenario Outline: Verifying creation of a notification list Negative
    Given User is on the Mutual Drug Login
    When User perform login with Username, Password
    Then User should verify after login "<selectYourCustomerAccount>" and success message as "C2 CERTIFICATE NOTIFICATION !!"
    Then User should navigates to Notification list and verifies that the page is "Notifications"
    And User clicks on Create Notification Group to Create New Notification Group
      | groupName                     | groupType     | successMessage              |
      | Sample Test Regular Notify me | Regular Order | Notification Group Created. |
    And User searches "526087" products with zero warehouse quantity and clicks on Notify Me
    Then User without enting any fields clicks NotifyMe and verify the error message "Notification Group is required" , "Email is required"
    Then User Entring invalid email verify the error message "Email must be a valid email address"
    Then User Entring invalid Phone number verify the error message "Phone number must have at least 10 digits"

    Examples: 
      | selectYourCustomerAccount             |
      | WEB POS TEST STORE (PREMIER) - 009498 |
