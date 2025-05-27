@Support
Feature: Verifing Mutual Drug Support

  Scenario Outline: Validate Help Menu Document Access and Downloads Using - Icon
    Given User is on the Mutual Drug Login
    When User perform login with Username, Password
    Then User should verify after login "<selectYourCustomerAccount>" and success message as "Member Access Portal"
    And User should Read and Accept the Returns Policy Update
    When User clicks the Help menu icon and selects "Mobile Order User Guide"
    Then the "Mobile Order User Guide" document should open in a modal
    When User clicks the "Download" button in the modal and the document should be downloaded successfully
    When User clicks the Help menu icon and selects "Mobile Return User Guide"
    Then the "Mobile Return User Guide" document should open in a modal
    When User clicks the "Download" button in the modal and the document should be downloaded successfully
    When User clicks the Help menu icon and selects "Return Policy"
    Then the "Return Policy" document should open in a modal
    When User clicks the "Download" button in the modal and the document should be downloaded successfully
    When User clicks the Help menu icon and selects "Recalls"
    Then the "Recalls and Safety Information" page should be displayed
    And User should clicks the "Click here to access FDA Alerts" navigates to the "Recalls, Market Withdrawals, & Safety Alerts" webpage

    Examples: 
      | selectYourCustomerAccount             |
      | WALKERS DRUG STORE (PREMIER) - 124685 |

  Scenario Outline: Validate Help Menu Document Access and Downloads using Menu Bar
    Given User is on the Mutual Drug Login
    When User perform login with Username, Password
    Then User should verify after login "<selectYourCustomerAccount>" and success message as "Member Access Portal"
    And User should Read and Accept the Returns Policy Update
    When User clicks the Support menu and selects "Mobile Order User Guide"
    Then the "Mobile Order User Guide" document should open in a modal
    When User clicks the "Download" button in the modal and the document should be downloaded successfully
    When User clicks the Support menu and selects "Mobile Return User Guide"
    Then the "Mobile Return User Guide" document should open in a modal
    When User clicks the "Download" button in the modal and the document should be downloaded successfully
    When User clicks the Support menu and selects "Return Policy"
    Then the "Return Policy" document should open in a modal
    When User clicks the "Download" button in the modal and the document should be downloaded successfully
    When User clicks the Support menu and selects "Recalls"
    Then the "Recalls and Safety Information" page should be displayed
    And User should clicks the "Click here to access FDA Alerts" navigates to the "Recalls, Market Withdrawals, & Safety Alerts" webpage

    @SupportMenu
    Examples: 
      | selectYourCustomerAccount             |
      | WALKERS DRUG STORE (PREMIER) - 124685 |
