
Feature: Validate get feature 

  Scenario: To view all user details
    Given user has access to endpoint "https://reqres.in/api/users"
    When user print responce
    Then user should get the response code 200
    And user validates the response with JSON schema
    And user validates the header
    When I have the firstName and LastName
    | George | Bluth |
    | Janet  | Weaver |
    | Charles | Morris |

 