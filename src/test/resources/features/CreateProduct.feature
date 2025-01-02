
Feature: creates a product


  Background:
    Given base url "https://backend.cashwise.us/api/myaccount"



  Scenario: user successfully creates a product
    And I have access
    And I have the endpoint "/products"
    And I  have "product_title" with "pizza" in request body
    And I  have "product_price" with "2.99" in request body
    And I  have "service_type_id" with "2" in request body
    And I  have "category_id" with "2" in request body
    And I  have "product_description" with "slavic pizza" in request body
    And I  have "date_of_payment" with "2024-12-05" in request body
    And I  have "remind_before_day" with "2" in request body
    And I  have "do_remind_every_month" with "REPEAT_EVERY_MONTH" in request body
    When I sent POST request
    Then verify status code s 201
    And verify I have "product_title" with "pizza" in response body
    Then I delete the product

