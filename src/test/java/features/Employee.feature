Feature: Employee
  Responsible for verifying Benefits, Create Employee,
  Delete employee and check if the functionality works

  Scenario: Create Employee with all details
    And I ensure application opened
    Then I click login link
    When I enter UserName and Password
      | UserName | Password |
      | admin    | password |
    Then I click login button
    And I click employeeList link
    Then I click create new btn
    And I enter following details
      | Name     | Salary | DurationWorked | Grade | Email           |
      | AutoUser | 4000   | 30             | 1     | autouser@ea.com |
      | AutoUser1 | 5000   | 40             | 2     | autouser1@ea.com |
    And I click create button