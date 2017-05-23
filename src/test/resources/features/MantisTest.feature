Feature: Bug report cycle

  Scenario: tester reports an issue
    Given User logs in as "tester1"
      And reports an issue
     When user fills the form with "tester1_issue"
      And submits issue
     Then user opens the bug table
      And user finds the "assigned (dev1)" issue
      And logouts
    Given User logs in as "dev1"
      And user opens the bug table
     When user opens the "assigned (dev1)" issue
      And checks fields in the issue
      And user makes the issue resolved
     Then user opens the bug table
      And user finds the "resolved (dev1)" issue
      And logouts
    Given User logs in as "lead1"
      And user opens the bug table
     When user opens the "resolved (dev1)" issue
      And user makes the issue closed
     Then user opens the bug table
      And user turns off the filters
      And user finds the "closed (lead1)" issue





