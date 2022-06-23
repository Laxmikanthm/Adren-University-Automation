@create_user @demo
Feature: Create new User,OLAF,Mailinator

  Scenario: Create new user and complete OLAF then navigating to mailinator
    When user clicks on "New User" button
    Then user should see "Create New User" page
    And User enters the following details to create new user
      | Title                 | Miss                |
      | Gender                | Female              |
      | Date of Birth         | 26/Jun/2000         |
      | Surname               | sony                |
      | Email                 | sony@mailinator.com |
      | Confirm Email Address | sony@mailinator.com |
      | Password              | TestPassword$123    |
      | Confirm Password      | TestPassword$123    |
    Then user clicks on "Create User" button
    Then user should see "New Course Search" page
    Then user should enter "BLBABUS101S BA(Hons) Business" into "Keyword" input field
    Then user selects "BA (Hons) Business (BLBEBABUS02D/BLBABUS101S)" course
    Then user should see "Apply on the course:" page
    Then user clicks on "Apply" button
    Then user clicks on "Start Application" button
    And User enters the following data in personal Details menuItem
      | Forename                              | Mary           |
      | Known as                              | sony           |
      | Country of birth                      | United Kingdom |
      | Legal nationality                     | Brazilian      |
      | Country of residence                  | United Kingdom |
      | Do you have any criminal convictions? | No             |
    And User enters the following data in Contact Details menuItem
      | Country                                      | United Kingdom       |
      | Postcode                                     | E126NW               |
      | Address Line 1                               | 1A kensington Avenue |
      | City                                         | London               |
      | Telephone                                    | 9876543210           |
      | Do you want to add a correspondence address? | No                   |
    And User enters the following data in Qualifications menuItem
      | Institution / School / College  | Queen Mary University of London |
      | Type of qualification           | Professional                    |
      | Select qualification            | National Diploma                |
      | Select subject                  | Business                        |
      | Completed?                      | yes                             |
      | Select grade                    | D                               |
      | Completion date                 | 19 Sep 2021                     |
      | Is English your first language? | Yes                             |
    And User enters the following data in Experience menuItem
      | Employer name and address | Mr.Roy, Street valley,NewYork |
      | Job title and main duties | Journalist                    |
      | Full time / Part time     | Part time                     |
    And User enters the following data in Personal Statement menuItem
      | Do you have a personal statement to upload?    | No                                                                                            |
      | Please type your personal statement in the box | Basically I belong to  business family which attracts me in learning strategies & do a course |
    And User enters the following data in Passport and Visa menuItem
      | Do you require a visa to study your course?                      | Yes         |
      | Passport number                                                  | IND23456878 |
      | Country of issue                                                 | India       |
      | Have you previously studied in the UK at degree level or higher? | No          |
    And User enters the following data in Referees menuItem
      | Type of reference          | Academic               |
      | Title                      | Professor              |
      | Forename                   | John                   |
      | Surname                    | Richard                |
      | Position                   | Dean                   |
      | Institution / Company      | King George College    |
      | Professional Email Address | Richard@mailinator.com |
      | Country                    | United Kingdom         |
    And User enters the following data in Funding menuItem
      | What is your likely source of funding? | Self Funding |
      | Percentage from this source            | 100          |
    And User enters the following data in Submission menuItem
      | How did you find out about the course? | Other         |
      | Please specify                         | word of mouth |
    Then user navigates to mailinator to get the reference number









