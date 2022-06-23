Feature: Application Decision to accept/decline the offer

  #@NoBrowser10
  #Scenario Outline: Test data using Excel file
    #Given user reads data from excel file for given sheet name "ApplicantLogin" for given row <RowNumber>
    #And user reads all headers from excel
    #And user reads " Your spouse's nationality* " header value from excel
#
    #Examples: 
      #| RowNumber |
      #|         1 |

  @ApplicantPortalDemo
  Scenario Outline: Applicant Login and Decision
    Given user reads data from excel file for given sheet name "ApplicantLogin" for given row <RowNumber>
    When user enters the login details of the applicant
    Then user changes the "New Password" as "value"
    Then user changes the "Confirm Password" as "value"
    Then user clicks on "Go" button
    Then user clicks on "my Application" menuItem
    Then user clicks on "Documents" tile
    Then user clicks on "Upload" Link
    Then user uploads the required documents
    Then user clicks on "Upload" Link
    Then user clicks on "Next" button
    Then user clicks on "Back" Link
    Then user clicks on "Respond to Offer" tile
    Then user should select " Do you wish to accept or decline this offer?* " as "value" from Dropdown
    Then user clicks on "Confirm" button
    Then user clicks on "Exit" button
    Then user clicks on "Contact Us" tile
    Then user should enter "value" into "Subject*" input field
    Then user should enter "value" into " Message text* " textarea field
    Then user clicks on "Send" button
    Then user clicks on "Exit" button
    Then user logout of the portal

    Examples: 
      | RowNumber |
      |         1 |
      
      
          #Then user clicks on "Fee Status Questionnaire" tile    
    #Then user should select "Country of birth" as "value" in Dropdown
    #Then user should select "Nationality" as "value" in Dropdown
    #Then user should select "Your spouse" as "value" in Dropdown
    #Then user should select "Your father" as "value" in Dropdown
    #Then user should select "Your mother" as "value" in Dropdown
    #Then user clicks on "Next" button
    #Then user enters "value" into  Date you moved to this address*  field
    #Then user should select " Date you moved to this address* " as "value" in Dropdown
    #Then user enters "value" into  Residence start date field
    #Then user should select "Reason for residence" as "value" from options in the Dropdown
    #Then user clicks on "Next" button
    #Then user ticks "British Citizen or Commonwealth National with Right to Abode" check box
    #Then user ticks "Time limit on stay" check box
    #Then user clicks on "Next" button
    #Then user should enter "value" into "Additional information" textarea field
    #Then user clicks on "Next" button
    #Then user ticks "I declare" check box
    #Then user clicks on "Submit" button
    #Then user clicks on "Exit" button
