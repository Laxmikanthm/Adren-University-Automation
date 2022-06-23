@siw_lgn
Feature: creating agent


  Scenario: Agent Creation
    When user enters the login details
    And User enters the following data in Agent creation portal
      | 98765                                                         | Agency code*                                       |
      | Raphel                                                        | Full name*                                         |
      | Raphel@mailinator.com                                         | Email address*                                     |
      | Auto12345                                                     | Agent contact code                                 |
      | agencyCode                                                    | Agency code                                        |
      | Auto12345@mailinator.com                                      | Email address (this will be the username)          |
      | Manager Level                                                 | Access Level                                       |
      | Mr                                                            | Title                                              |
      | Henry                                                         | Surname                                            |
      | Joseph                                                        | Forename 1                                         |
      | Education Agent                                               | Job title                                          |
      | Agency*                                                       | AUTOMATION                                         |
      | Agent*                                                        | Joseph Henry (Manager)                             |
      | BLEABABUS02D                                                  | Course                                             |
      | Mode of Attendance                                            | Full time according to Funding Council definitions |
      | Location                                                      | Ealing Study Centre                                |
      | Has the applicant previously applied to us with your agency?* | No                                                 |

#    Then user clicks on "Admissions Staff Template Page" menuItem
#      Then user should see the title
#    Then user clicks on "Edit Agency Details" tab
#    Then user should see the title
#    When user clicks on "Add New Agency" Button
#    Then user should enter "98765" into "Agency code*" field
#    Then user should enter "Raphel" into "Full name*" input field
#    Then user should enter "Raphel@mailinator.com" into "Email address*" input field
#    Then user clicks on "Next" button
#    Then user clicks on "Exit" button
#    Then user clicks on "Edit Agent Contact Details" tab
#    Then user should see the title
#    Then user clicks on "Add" button
#    Then user should enter "Auto12345" into "Agent contact code" input
#    Then user should select "Agency code" as "AUTOMATION" from options in the Dropdown
#    Then user should enter "Auto12345@mailinator.com" into "Email address (this will be the username)" input field
#    Then user should enter Agent DOB as "26 10 1986"
#    Then user should select "Access Level" as "Manager Level" from Dropdown
#    Then user should select "Title" as "Mr" from Dropdown
#    Then user should enter "Henry" into "Surname" input field
#    Then user should enter "Joseph" into "Forename 1" input field
#    Then user should enter "Education Agent" into "Job title" input field
#    Then user clicks on "Store" button
#    Then user clicks on "Admissions Staff Template Page" menuItem
#    Then user clicks on "Log in as an Agent" tab
#    Then user should see the title
#    Then user should select "Agency*" as "AUTOMATION" from Dropdown
#    Then user clicks on "Next" button
#    Then user should select "Agent*" as "Joseph Henry (Manager)" from Dropdown
#    Then user clicks on "Next" button
#    Then user clicks on "Log into Agent Portal as agent" Button
#    Then user clicks on "Submit a New Application" tile
#    Then user should enter "BLEABABUS02D" into "Course " input field
#    Then user should select "Mode of Attendance" as "Full time according to Funding Council definitions" from Dropdown
#    Then user should select "Location" as "Ealing Study Centre" from Dropdown
#    Then user clicks on "Continue" button
#    When user clicks on select button
#    Then user should select "Has the applicant previously applied to us with your agency?*" as "No" from Dropdown
#    Then user clicks on "Continue" button
    Then user clicks on "Continue" Button
    And User enters the following details to create new user
      | Title                 | Miss                |
      | Gender                | Female              |
      | Date of Birth         | 26/Jun/2000         |
      | Surname               | John                |
      | Email                 | John@mailinator.com |
      | Confirm Email Address | John@mailinator.com |
      | Password              | TestPassword$123    |
      | Confirm Password      | TestPassword$123    |
    Then user clicks on "Create User" button
    Then user clicks on "Start Application" button
    And User enters the following data in personal Details menuItem
      | Forename                              | Mary           |
      | Known as                              | Mary John      |
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
    Then user clicks on "Save and continue" button
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
      | Forename                   | Joe                    |
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



