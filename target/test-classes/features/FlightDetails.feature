Feature: Search Hotel

Scenario: Search hotel deals on priceline
Given User is on priceline homepage
When Enter hotel information
Then Search the relevant information
And Validate Results are displayed

