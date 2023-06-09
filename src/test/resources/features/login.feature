@Login
Feature:Login
  @valid_credentials
  Scenario Outline: As a user I login to ASK application with valid credentials
    Given I open the url "http://ask-qa.portnov.com/" in "edge"
    When I type <email> in the email textbox
    And I type <password> in the password textbox
    And I click the Sign-In button
    And I wait for 2 seconds
    Then I should see the Home link in the side navigation menu
    And I click the Logout link from the side navigation menu

    Examples:
      |email|password|
      |suteneko@rapidbeos.net|test123|
      |alisher123@antkander.com|test123|

#  @invalid_credentials
#   Scenario Outline: As a user I should not login to ASK application with invalid credentials
#    Given I open the url "http://ask-qa.portnov.com/"
#    When I type <email> in the email textbox
#    And I type <password> in the password textbox
#    And I click the Sign-In button
#    And I wait for maximum of 10 seconds until the error message is displayed
#    Then I should see an error message
#
#     Examples:
#       |email|password|
#       |sutesneko@rapidbeosd.net|test1456|






#    When I type "suteneko@rapidbeos.net" into element with xpath "//input[@formcontrolname='email']"
#    And I type "test123" into element with xpath "//input[@formcontrolname='password']"
#    And I click on element with xpath "//span[text()='Sign In']"
#    And I wait for 1 sec
#    Then element with xpath "//h5[text()='Home']" should be displayed
#    When I click on element with xpath "//h5[text()='Log Out']"
#    And I switch to new window
#    When I click on element with xpath "//span[text()='Log Out']"
#    And I wait for 1 sec
#    Then element with xpath "//h5[text()='Do not have account?']" should contain text "Do not have account?"