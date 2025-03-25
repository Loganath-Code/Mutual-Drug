@Login
Feature: Verifying Mutual Drug Login details

  Scenario Outline: Verifying Mutual Drug Login details with valid credentials
    Given User is on the Mutual Drug Login
    When User perform login with Username, Password
    Then User should verify after login "<selectYourCustomerAccount>" and success message as "C2 CERTIFICATE NOTIFICATION !!"

    @Login_
    Examples: 
      | selectYourCustomerAccount            |
      | YADKIN DENTON LTC (PREMIER) - 040758 |

  Scenario Outline: Verifying Mutual Drug Login using Enter key
    Given User is on the Mutual Drug Login
    When User perform login Username, Password with Enter key
    Then User should verify after login "<selectYourCustomerAccount>" and success message as "Member Access Portal"

    @EnterKey
    Examples: 
      | selectYourCustomerAccount            |
      | YADKIN DENTON LTC (PREMIER) - 040758 |

  @EmptyFieldLogin
  Scenario: Verifying Mutual Drug Login with empty fields error message
    Given User is on the Mutual Drug Login
    When User should perform login with empty fields
    Then User should verify empty fields login error message contains "Email is required" , "Password is required"

  @InvalidUser_And_Password
  Scenario Outline: Verifying Unsuccessful login and validate error messages
    Given User is on the Mutual Drug Login
    When User should perform login "<invalid_Username>", "<Invalid_Password>" with Invalid credentials
    Then User should verify Invalid credentials login error message contains "Username or password is incorrect."

    Examples: 
      | invalid_Username  | Invalid_Password |
      | vinoth@dataer.com | vinoth88778      |

  @invalid_username
  Scenario Outline: Verifying Unsuccessful login with invalid username
    Given User is on the Mutual Drug Login
    When User perform login with "<invalid_Username>" , "<password>"
    Then User should verify after login error message indicating that "Email must be a valid email address"

    Examples: 
      | invalid_Username     | password  |
      | invalid_Usernamedata | Demo@1234 |

  @Login_Logout
  Scenario Outline: Verifying Mutual Drug Login and Logout
    Given User is on the Mutual Drug Login
    When User perform login with Username, Password
    Then User should verify after login "<selectYourCustomerAccount>" and success message as "Member Access Portal"
    And User clicks the logout button and verify successfully redirected to the login page

    @Logout
    Examples: 
      | selectYourCustomerAccount            |
      | YADKIN DENTON LTC (PREMIER) - 040758 |
