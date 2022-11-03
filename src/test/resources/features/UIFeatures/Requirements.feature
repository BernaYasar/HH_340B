Feature: Developer Requirements

  Background:
    Given user navigates to application page
    And user asserts Developer Requirements is visible

  Scenario:user uploads one file
    When user uploads files
      |Doc1.docx|
    Then user verifies total count of files is 2
    And user verifies total size is 11920
    And names and extensions of files are displayed
      |Doc1.docx|
    Then user closes the page

  Scenario:user uploads two files
    When user uploads files
      |Doc1.docx|
      |Doc2.pdf|
    Then user verifies total count of files is 3
    And user verifies total size is 37419
    And names and extensions of files are displayed
      |Doc1.docx|
      |Doc2.pdf|
    Then user closes the page

  Scenario:no files uploaded
    When user does not upload doc
    Then user verifies total count of files is 1
    And user verifies total size is 100
    And no file names appear
    Then user closes the page


