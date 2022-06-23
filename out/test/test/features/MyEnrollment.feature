Feature: Student Enrolment

  Scenario: Applicant Login and enrolment
    When user enters the login details of the applicant for Enrolment
    Then user clicks on "My Enrolment" menuItem
    Then user clicks on "Start Personal Details" action button
    Then user clicks on "Continue" button
    Then user should select "Special Educational Needs?" as "No" from options in the Dropdown
    Then user clicks on "Continue" button
    Then user clicks on "Start Photo Upload" action button
    Then user uploads the required documents
    Then user clicks on "Upload" Link
    Then user clicks on "Continue" button
    Then user clicks on "Start Other Personal Details" action button
    Then user should select "Is your gender identity the same gender you were originally assigned at birth?*" as "Yes" from options in the Dropdown
    Then user should select "What is your religion/belief?*" as "Hindu" from options in the Dropdown
    Then user should select "What is your sexual orientation?*" as "Heterosexual/straight" from options in the Dropdown
    Then user should select "Have you been in care on or after your 16th birthday?*" as "Care leaver" from options in the Dropdown
    Then user should select "Are you a Carer?*" as "Not a carer" from options in the Dropdown
    Then user should enter "What is your Parental Occupation?*" into "Higher education teaching professionals" enrollment field
    Then user should select "Do any of your parents have any higher education qualifications, such as a degree, diploma or certificate of education?*" as "Yes" from options in the Dropdown
    Then user should select "What is your Ethnic origin?*" as "White - Roma" from options in the Dropdown
    Then user clicks on "Continue" button
    Then user should enter "Name of Last Institution Attended" into "LONDON UNIVERSAL COLLEGE OF EXCELLENCE LTD" enrollment field
    Then user should select "Year Left Last Insitution" as "2018" from options in the Dropdown
    Then user should enter "Last School Attended" into "INTERNATIONAL SCHOOL OF LONDON" enrollment field
    Then user should select "Year Left Last School" as "2012" from options in the Dropdown
    Then user clicks on "Continue" button
    Then user clicks on "Start Contact Details" action button
    Then user should enter "New Valley Street" into "Address Line 2" input field
    Then user clicks on "Save" button
    Then user ticks "Temporary address" check box
    Then user should select "Term time accommodation" as "INSTITUTION MAINTAINED PROPERTY" from options in the Dropdown
    Then user clicks on "Save" button
    Then user clicks on "Start Emergency Contact Details" action button
    Then user should select "Relationship *" as "BROTHER" from options in the Dropdown
    Then user should enter "Johnson" into "Forename" input field
    Then user should enter "Michael" into "Surname *" input field
    Then user should enter "E126NW" into "Home address postcode" input field
    Then user should enter "123 urban street" into "Home address 1" input field
    Then user should enter "London" into "Home address 2" input field
    Then user should enter "1234567890" into "Mobile *" input field
    Then user should enter "Johnson@mailinator.com" into "Email Address" input field
    Then user clicks on "Save" button
    Then user clicks on "Start Academic Qualifications" action button
    Then  user clicks on "Qualifications are correct" button
    Then user clicks on "Start Course Details" action button
    Then user clicks on "Details Correct - Continue" button
    Then user clicks on "Start Fee Details" action button
    Then user clicks on "Continue" button
    Then user should select "Payment options" as "Bank transfer" from options in the Dropdown
    Then user clicks on "Continue" button
    Then user clicks on "Continue" button
    Then user clicks on "Continue" button
    Then user clicks on "Finish" button
    Then user logout of the portal


#    Then user clicks on "Start Visa and Immigration Details" action button
#    Then user uploads the required documents
#    Then user clicks on "Upload" Link
#    Then user clicks on "Continue" button
#    Then user uploads the required documents
#    Then user clicks on "Upload" Link
#    Then user clicks on "Continue" button