
Feature: Validate put post patch methods

  Scenario: To Post all user details
   Given user has access to Post URL "https://reqres.in/api/users"
    When user should Post responce
    Then user should get Post the response code 201
     And user validates the response which get from post
   