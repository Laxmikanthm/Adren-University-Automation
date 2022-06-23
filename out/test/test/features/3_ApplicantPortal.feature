@demo
Feature: Application Decision

  Scenario: Applicant Login and Decision 
    When user enters the login details of the applicant
    Then user changes the "New Password" as "testing@12345"
    Then user changes the "Confirm Password" as "testing@12345"
    Then user clicks on "Go" button
    Then user clicks on "my Application" menuItem
    Then user clicks on "Documents" tile
    Then user clicks on "Upload" Link
    Then user uploads the required documents
    Then user clicks on "Upload" Link
    Then user clicks on "Next" button
#    Then user clicks on "Upload" Link
#    Then user uploads the required documents
#    Then user clicks on "Upload" Link
#    Then user clicks on "Next" button
    Then user clicks on "Back" Link
    Then user clicks on "Respond to Offer" tile
    Then user should select "Do you wish to accept or decline this offer?*" as "Accept offer" from options in the Dropdown
    Then user clicks on "Confirm" button
    Then user clicks on "Exit" button
    Then user clicks on "Fee Status Questionnaire" tile
    Then user should select "Your father" as "British" in Dropdown
    Then user should select "Your mother" as "British" in Dropdown
    Then user should select "Country of birth*" as "United Kingdom, not otherwise specified" in Dropdown
    Then user should select "Your spouse" as "British Virgin Islander" in Dropdown
    Then user clicks on "Next" button
    Then user enters "10 06 2000" into Date you moved to this address* field
    Then user enters "15 06 2002" into Residence start date1* field
    Then user should select "Reason for residence" as "Living with family" from options in the Dropdown
    Then user clicks on "Next" button
    Then user ticks "British Citizen or Commonwealth National with Right to Abode" check box
    Then user ticks "Time limit on stay" check box
    Then user clicks on "Next" button
    Then user should enter "e-vision" into "Additional information" textarea field
    Then user clicks on "Next" button
    Then user ticks "I declare" check box
    Then user clicks on "Submit" button
    Then user clicks on "Exit" button
    Then user clicks on "Contact Us" tile
    Then user should enter "Testing" into "Subject*" input field
    Then user should enter "e-vision test data" into "Message text*" textarea field
    Then user clicks on "Send" button
    Then user clicks on "Exit" button
    Then user logout of the portal
