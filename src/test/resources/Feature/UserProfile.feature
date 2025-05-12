@UserProfile
Feature: Verifying Mutual Drug User Profile web page

  Scenario Outline: Verifying Mutual Drug User Profile with valid inputs
    Given User is on the Mutual Drug Login
    When User perform login with Username and Password
    Then User should verify after login "<selectYourCustomerAccount>" and success message as "Member Access Portal"
    Then User navigates to the User Profile page and verifies the page title is "User Profile"
    When User should updates profiles with "<firstName>", "<lastName>", "<oldPassword>", "<newPassword>", "<confirmPassword>"
    Then User should clicks on Update, then verifes the alert success message "Profile updated."

    Examples: 
      | selectYourCustomerAccount            | firstName | lastName | oldPassword | newPassword | confirmPassword |
      | SHADY SPRING PHARMACY (PRO) - 123703 | Pat       | Cummins  | Test1234    | Test@1234    | Test@1234        |

  @UserProfileNegative
  Scenario Outline: Verifying Mutual Drug User Profile Negative Test
    Given User is on the Mutual Drug Login
    When User perform login with Username and Updating Password
    Then User should verify after login "<selectYourCustomerAccount>" and success message as "Member Access Portal"
    Then User navigates to the User Profile page and verifies the page title is "User Profile"
    Then User attempts to update the profile with empty fields and verifies the error messages "First Name is required" and "Last Name is required"
    Then User enters an Old Password and New Password with fewer than 8 characters "pass12" and verifies that the error messages "Old Password must be at least 8 characters" and "New Password must be at least 8 characters" are displayed
    Then User enters mismatched values in the New Password and Confirm Password fields and verifies the error message "Confirm Password must match with New Password."
    Then User attempts to update the profile without providing the Old Password and verifies that the error message "Old Password is required" is displayed
    Then User attempts to update the profile without entering the Confirm Password and verifies that the error message "Confirm Password must match with New Password." is displayed
    Then User attempts to update the profile with invalid Old Password and verifies that the warning message "Old password is incorrect."

    Examples: 
      | selectYourCustomerAccount            |
      | SHADY SPRING PHARMACY (PRO) - 123703 |
