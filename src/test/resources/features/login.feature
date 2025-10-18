Feature: Google search feature

  Scenario: Verify user can open Google and search
    Given user launches Chrome browser
    When user opens Google homepage
    Then page title should contain "Google"
    And user searches for ""
