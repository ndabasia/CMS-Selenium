@complete @comments
Feature: Testing comment functionality


  Scenario Outline: Add a comment to a BCPH insight as an observer
    Given I have logged in as the correct user
    When I choose Site Type as <Site Type>
    And I choose <Content Hub> as content type
    And I select an insight to add a comment to
    And I add a comment
    Then the comment is saved

    Examples:
      | Site Type    | Content Hub                           |
      | Content Hubs | Beauty Personal Care Household (BPCH) |

@1
  Scenario Outline: Delete a comment to a BCPH insight as an observer
    Given I have logged in as the correct user
    When I choose Site Type as <Site Type>
    And I choose <Content Hub> as content type
    And I select an insight to add a comment to
    And I add a comment
    And I delete a comment
    Then the comment is deleted

    Examples:
      | Site Type    | Content Hub        |
      | Content Hubs | Food & Drink (MFD) |
