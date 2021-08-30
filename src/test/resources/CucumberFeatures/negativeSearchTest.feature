Feature: Search for a Guest User
  As a customer
  I want to be redirected to Advanced search page after clicking on Search button without entering any search term

  @Regression
  Scenario: Advanced search page is shown after clicking on Search button without entering any search term
    Given User opens Home Page
    And User clicks on Search button without entering any search term
    Then User is redirected to Advanced Search page with the following URL https://www.bookdepository.com/search?searchTerm=&search=Find+book