@Users
Feature: Verifying Admin Members Users webpage

  Scenario Outline: Verifying Admin Members Users Webpage
    Given User is on the Mutual Drug Login
    When User perform admin login with Username, Password
    Then User should verify after successful login success message as "Member Users"
    Then User should navigates Members Users and verifies the title "Members Users"
    When User should perform inivite users "<firstName>", "<lastName>", "<email>", "<memberNumber>", "<userRoles>"
    And User searches using first name, last name and email "<searchTerm>" and verifies that the grid displays the search result for "<searchMembers>"
      | searchTerm             |
      | Rani                   |
      | Test                   |
      | ethanbro4546@gmail.com |
    And User verifies that the sorting functionality in both ascending and descending first Name, last name, email and Joined date
    When User performs Member User edit with "<FirstName>", "<LastName>", "<MemberNumber>", and "<UserRole>"
    Then User should clicks on Resent Invite then verifies the success message "Resent invite sent."
    And User navigates through pages and verifies that pagination works correctly

    Examples: 
      | firstName | lastName | email                  | memberNumbers                                                                 | userRoles    | FirstName | LastName    | MemberNumbers                                                                            | UserRole |
      | Pat       | Cummins  | jolal64322@javbing.com | 120113 - DR PHARMACY INC, 770081 - GILES PHARMACY 340B, 118760 - NC MEDASSIST | Member Admin | Pat Aus   | Cummins Aus | 107094 - DRUGCO HEALTH, 120972 - FAMILY CARE HER 340B, 660029 - SMITHS DRUGS GERIMED LTC | Admin    |

  @AdminUsersNegativeTest
  Scenario: Verifying Admin Members Users Negative Test
    Given User is on the Mutual Drug Login
    When User perform admin login with Username, Password
    Then User should verify after successful login success message as "Member Users"
    Then User should navigates Members Users and verifies the title "Members Users"
    Then User should inviting with all fields empty should display the validation messages "First Name is required", "Last Name is required", "Email is required", "Member Number is required" and "User Role is required"
    Then User attempting to invite a user with an invalid email should display the error message "Email must be a valid email address"
    Then User attempting to invite a user with an already used email should display the error message "Email already exists."
    Then editing a member via the First Name link with empty first and last name fields should display the errors "First Name is required" and "Last Name is required"
    Then editing a member via the Last Name link with empty first and last name fields should display the errors "First Name is required" and "Last Name is required"
