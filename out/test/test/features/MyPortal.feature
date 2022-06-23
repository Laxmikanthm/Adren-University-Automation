Feature: Student Portal

  Scenario: Applicant Login and student journey
    When user enters the login details of the applicant for My Portal
    Then user clicks on "My Portal" menuItem
    Then user clicks on " Maintain my Address Details " link
    Then user clicks on "Edit" Link
    Then user should enter "7895640231" into "Telephone number 2" input field
    Then user should enter "1234567890" into "Mobile Telephone" input field
    Then user should enter "9140-27990295" into "Fax number" input field
    Then user should enter "sony@mailinator.com" into "Alternate Email" input field
    Then user ticks "Temporary address" check box
    Then user should enter "45.231" into "Longitude" input field
    Then user should enter "50.67" into "Latitude" input field
    Then user clicks on "Store" button
    Then user clicks on "My Portal" menuItem
    Then user clicks on " Update my Emergency Contact " link
    Then user updates following details in 1 st "Emergency Contact" Details
      | Initials | R |
    Then user clicks on "Store" button
    Then user ticks "Delete Record" check box
    Then user clicks on "Delete Selected" button
    Then user clicks on "Add Contact" button
    Then user updates following details in 2 nd "Emergency Contact" Details
      | Relationship  | FATHER                |
      | Surname       | Henry                 |
      | Forename 1    | Joseph Henry          |
      | Initials      | M                     |
      | Email Address | Joseph@mailinator.com |
      | Telephone 1   | 7890123456            |
    Then user should enter "Henry" into "Surname" input field
    Then user should enter "Joseph Henry" into "Forename 1" input field
    Then user should enter "M" into "Initials" input field
    Then user should enter "Joseph@mailinator.com" into "Email Address" input field
    Then user should enter "7890123456" into "Telephone 1" input field
    Then user clicks on "Store" button
    Then user ticks "Delete Record" check box
    Then user clicks on "Delete Selected" button
    Then user clicks on "My Portal" menuItem
    Then user clicks on " Maintain my Personal Details " link
    Then user should select "Preferred Gender" as "Female" from options in the Dropdown
    Then user should enter "jenny" into "Middle Name" input field
    Then user ticks "Change of Name Deed Poll" check box
    Then user clicks on "Upload Evidence" Button
    Then user uploads the required documents
    Then user clicks on "Upload" Link
    Then user "Close" the details
    Then user clicks on "Next" button
    Then user clicks on "My Portal" menuItem
    Then user clicks on " My Course Details " link
    Then user clicks on "Exit" Link
    Then user clicks on "Request a Letter" link
    Then user should select " Choose Letter Type* " as "Reference Letter" from options in the Dropdown
    Then user selects "ENG" radio button
    Then user clicks on "Next" button
    Then user clicks on "Finish" button
    Then user clicks on " View my 2021/22 Modules " link
    Then user clicks on "My Portal" menuItem
    Then user clicks on following links to verify and closes the tabs
      | Student Code of Conduct                     |
      | Extension Policy                            |
      | Exceptional Mitigating Circumstances policy |
      | Leave of Absence Policy                     |
      | Data Protection Policy                      |
      | Student Handbook                            |
      | Live Chat                                   |
      | Student Route Information                   |
      Then user logout of the portal
#    Then user navigates to mailinator to check for the mail
