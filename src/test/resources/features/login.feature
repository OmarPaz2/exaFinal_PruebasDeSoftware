@login
Feature: Login to Shopping Cart application
  As a registered user
  I want to log in with my credentials
  So I can access my account and make purchases

  Scenario: Successful login with valid credentials
    Given Andrea opens the shopping Cart application
    When she enters her email "user1@test.com" and password "password1"
    And she taps the Login button
    Then she should see the main screen of the application

  Scenario: Login failed with wrong password
    Given Andrea opens the shopping Cart application
    When she enters her email "admin@test.com" and password "wrongpass"
    And she taps the Login button
    Then she should see a login error message

  Scenario: Login failed with unregistered email
    Given Andrea opens the shopping Cart application
    When she enters her email "noexiste@test.com" and password "123456"
    And she taps the Login button
    Then she should see a login error message