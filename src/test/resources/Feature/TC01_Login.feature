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

  @SignUpandLogin
  Scenario Outline: Verifying Mutual Drug Sign Up and Login
    Given User is on the Mutual Drug Login
    And User should clicks on SignUp
    When User should perform SignUp with "<memberNumber>", "<firstName>", "<lastName>", "<userName>", "<password>", "<confirmPassword>"
    And User should clicks on SignIn redirects to login page

    Examples: 
      | memberNumber | firstName | lastName | userName               | password | confirmPassword |
      |       035071 | Auto      | Test     | cimih90753@lushosa.com | Test1234 | Test1234        |

  @SignUpNegative
  Scenario Outline: Verifying Mutual Drug Sign Up and Login
    Given User is on the Mutual Drug Login
    And User should clicks on SignUp
    Then User should SignUp with empty fields verifies displaying error messages "Member Number is required", "First Name is required", "Last Name is required", "Email is required", "Password is required", "Confirm Password is required"
    Then User should  sign-up with userName "<userName>", password "<password>", confirmPassword "<confirmPassword>" verifies the displaying error messages "Member Number is required", "First Name is required", "Last Name is required"
    Then User enters an invalid email format "user@.com" and verifies the error message "Email must be a valid email address"
    Then User enters a password with fewer than 8 characters "pass12" and verifies the error message "Password must be at least 8 characters" is displayed
    Then User enters a Confirm Password that does not match the original password, then verifies the error message "Confirm Password must match with password."
    Then User attempts to Sign Up with an already used Member Number "001016", then verifies the alert message "Member number already exists."
    Then User attempts to Sign Up with an invalid Member Number "001016234", then verifies the alert message "Invalid member number."
    Then User attempts to Sign Up with an already used email "cowoc38407@lushosa.com", then verifies the alert message "Email already exists."

    Examples: 
      | userName               | password | confirmPassword |
      | cimih90753@lushosa.com | Test1234 | Test1234        |

  @forgotPassword
  Scenario: Verifying Mutual Drug Forgot Password
    Given User is on the Mutual Drug Login
    And User should clicks on Forgot Password link
    When User enters a valid email address "cowoc38407@lushosa.com" and submits the password reset request
    Then User should successfully redirected to the login page "https://stage-orders.mutualdrug.com/sign-in"

  @ForgotPasswordNegative
  Scenario: Verifying Mutual Drug Forgot Password - Negative
    Given User is on the Mutual Drug Login
    And User should clicks on Forgot Password link
    Then User should Attempt to reset password with empty email field, then verifies the error message "Email is required"
    Then User attempts to reset the password using an invalid email formats and verifies the error message "Email must be a valid email address"
      | invalidEmail              |
      | abcd123.com               |
      | cowoc38407 @lushosa.com   |
      | vinoth @datacaliper.com   |
      | vinoth@@datacaliper.com   |
      | vinoth @datacaliper,com   |
      | cowoc38407@lushosa        |
      | cowoc@38407@lushosa.com   |
      | vinoth@#$%datacaliper.com |
      | vinoth @datacaliper.com   |
    Then User enters only spaces in the email field " " and clicks "Send Reset Link", then verifies the error message "Email is required"
    Then User enters special characters in the email field "!@#$@gmail.com" and attempts to reset the password, verifying the error message "Email must be a valid email address"
