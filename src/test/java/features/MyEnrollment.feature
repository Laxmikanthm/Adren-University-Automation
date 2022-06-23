Feature: Student Enrolment

  #@NoBrowser1011
  #Scenario Outline: Test data using Excel file
  #Given user reads data from excel file for given sheet name "MyEnrollment" for given row <RowNumber>
  #And user reads all headers from excel
  #And user reads " What is your Parental Occupation?* " header value from excel
  #Examples:
  #| RowNumber |
  #|         1 |
  @MyEnrollment
  Scenario Outline: Applicant Login and enrolment
    Given user reads data from excel file for given sheet name "MyEnrollment" for given row <RowNumber>
    When user enters the login details of the applicant
    Then user clicks on "My Enrolment" menuItem
    Then user clicks on "Start Personal Details" action button
    Then user clicks on "Continue" button
    Then user should select "Special Educational Needs?" as "value" from options in the Dropdown
    Then user clicks on "Continue" button
    Then user clicks on "Start Photo Upload" action button
    Then user uploads the required documents
    Then user clicks on "Upload" Link
    Then user clicks on "Continue" button
    Then user clicks on "Start Other Personal Details" action button
    Then user should select "Is your gender identity the same gender you were originally assigned at birth?*" as "value" from options in the Dropdown
    Then user should select "What is your religion/belief?*" as "value" from options in the Dropdown
    Then user should select "What is your sexual orientation?*" as "value" from options in the Dropdown
    Then user should select "Have you been in care on or after your 16th birthday?*" as "value" from options in the Dropdown
    Then user should select "Are you a Carer?*" as "value" from options in the Dropdown
    Then user should select "Do any of your parents have any higher education qualifications, such as a degree, diploma or certificate of education?*" as "value" from options in the Dropdown
    Then user should select "What is your Ethnic origin?*" as "value" from options in the Dropdown
    Then user should enter " What is your Parental Occupation?* " into "value" enrollment field
    Then user clicks on "Continue" button
    Then user should enter "Name of Last Institution Attended" into "value" enrollment field
    Then user should select "Year Left Last Insitution" as "value" from options in the Dropdown
    Then user should enter "Last School Attended" into "value" enrollment field
    Then user should select "Year Left Last School" as "value" from options in the Dropdown
    Then user clicks on "Continue" button
    Then user clicks on "Start Contact Details" action button
    Then user should enter "New Valley Street" into "Address Line 2" input field
    Then user clicks on "Save" button
    Then user ticks "Temporary address" check box
    Then user should select "Term time accommodation" as "value" from options in the Dropdown
    Then user clicks on "Save" button
    Then user clicks on "Start Emergency Contact Details" action button
    Then user should select "Relationship *" as "value" from options in the Dropdown
    Then user should enter "value" into "Forename" input field
    Then user should enter "value" into "Surname *" input field
    Then user should enter "value" into "Home address postcode" input field
    Then user should enter "value" into "Home address 1" input field
    Then user should enter "value" into "Home address 2" input field
    Then user should enter "value" into "Mobile *" input field
    Then user should enter "Johnson@mailinator.com" into "Email Address" input field
    Then user clicks on "Save" button
    Then user clicks on "Start Academic Qualifications" action button
    Then user clicks on "Qualifications are correct" button
    Then user clicks on "Start Course Details" action button
    Then user clicks on "Details Correct - Continue" button
    Then user clicks on "Start Fee Details" action button
    Then user clicks on "Continue" button
    Then user should select " Payment options " as "value" from options in the Dropdown
    Then user clicks on "Continue" button
    Then user clicks on "Continue" button
    Then user clicks on "Continue" button
    Then user clicks on "Finish" button
    Then user logout of the portal

    Examples: 
      | RowNumber |
      |         1 |
#    Then user clicks on "Start Visa and Immigration Details" action button
#    Then user uploads the required documents
#    Then user clicks on "Upload" Link
#    Then user clicks on "Continue" button
#    Then user uploads the required documents
#    Then user clicks on "Upload" Link
#    Then user clicks on "Continue" button
