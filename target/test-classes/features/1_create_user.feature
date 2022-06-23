@create_user
Feature: Create new User and complete the OLAF,then navigating to Mailinator to get the Referenec Number

  #@NoBrowserforCreateUser
  #Scenario Outline: Test data using Excel file
    #Given user reads data from excel file for given sheet name "OLAF" for given row <RowNumber>
    #And user reads all headers from excel
    #And user reads "Title" header value from excel

    #Examples: 
      #| RowNumber |
      #|         1 |

  @create_user @demo1
  Scenario Outline: Create new user and complete OLAF then navigating to mailinator for UK APPLICANT
    Given user reads data from excel file for given sheet name "OLAF" for given row <RowNumber>
    When user clicks on "New User" button
    Then user should see "Create New User" page
    And User enters the following details to create new user
      | Title                 |
      | Gender                |
      | Date of Birth         |
      | Surname               |
      | Email Address         |
      | Confirm Email Address |
      | Password              |
      | Confirm Password      |
    Then user clicks on "Create User" button
    Then user should see "New Course Search" page
    Then user should enter "Keyword value" into "Keyword" input field
    Then user selects "specific course" course
    Then user should see "Apply on the course:" page
    Then user clicks on "Apply" button
    Then user clicks on "Start Application" button
    And User enters the following data in personal Details menuItem
      | Forename                              |
      | Known as                              |
      | Country of birth                      |
      | Legal nationality                     |
      | Country of residence                  |
      | Do you have any criminal convictions? |
    And User enters the following data in Contact Details menuItem
      | Country                                      |
      | Postcode                                     |
      | Address Line 1                               |
      | City                                         |
      | Telephone                                    |
      | Do you want to add a correspondence address? |
    And User enters the following data in Qualifications menuItem
      | Institution / School / College  |
      | Type of qualification           |
      | Select qualification            |
      | Select subject                  |
      | Completed?                      |
      | Select grade                    |
      | Completion date                 |
      | Is English your first language? |
    And User enters the following data in Experience menuItem
      | Employer name and address |
      | Job title and main duties |
      | Full time / Part time     |
    And User enters the following data in Personal Statement menuItem
      | Do you have a personal statement to upload?    |
      | Please type your personal statement in the box |
    And User enters the following data in Passport and Visa menuItem
      | Do you require a visa to study your course?                      |
      | Passport number                                                  |
      | Date of issue                                                    |
      | Date of expiry                                                   |
      | Country of issue                                                 |
      | Have you previously studied in the UK at degree level or higher? |
    And User enters the following data in Referees menuItem
      | Type of reference          |
      | Title                      |
      | Forename                   |
      | Surname                    |
      | Position                   |
      | Institution / Company      |
      | Professional Email Address |
      | Country                    |
    And User enters the following data in Funding menuItem
      | What is your likely source of funding? |
      | Percentage from this source            |
    And User enters the following data in Submission menuItem
      | How did you find out about the course? |
    Then user navigates to mailinator to get the reference number

    Examples: 
      | RowNumber |
      |         1 |
      #|        28 |
      #|        29 |
      #|        30 |
      #|        31 |
