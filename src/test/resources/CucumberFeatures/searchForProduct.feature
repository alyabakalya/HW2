Feature: Search for a Guest User
  As a customer
  I want to be able to search for an item

  @Regression
  Scenario: Search for a product from Home Page
    When I open the Initial home page
    And I search for Thinking in Java
    And Search results are not empty
