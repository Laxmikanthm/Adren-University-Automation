Feature: Staff Login,OAO,Application Review

  #@NoBrowser
  #Scenario Outline: Test data using Excel file
  #Given user reads data from excel file for given sheet name "OAO" for given row <RowNumber>
  #And user reads all headers from excel
  #And user reads "Applicant ID" header value from excel
  #Examples:
  #| RowNumber |
  #| 1        |
  @OAODemo
  Scenario Outline: OAO FLOW
    Given user reads data from excel file for given sheet name "OAO" for given row <RowNumber>
    When user enters the login details
    Then user clicks on "Online Admissions Office" menuItem
    Then user clicks on "Online Admissions Office - Admissions View" tab
    Then user selects "PCG_BLUK" radio button
    Then user selects "Applicant Search" tab
    Then user should enter "value" into Student Number input field
    Then user selects the student record displayed in Results section
    #    ===============summary details===============
    Then user clicks on the "Summary" panel titles
    Then user clicks on "Update Acceptance Status" Button
    Then user should select " Applicant Acceptance Status* " as "value" from options in the Dropdown
    Then user clicks on "Submit" button
    Then user clicks on "Back" button
    #Then user closes the "Summary" Panel titles
    #    ============personal details==========
    Then user clicks on the "Personal Details" panel titles
    Then user updates the "Update Personal Details" button in Personal Details section
    Then user should select "Title" as "value" from options in the Dropdown
    Then user should enter "value" into "Previous Surname" input field
    Then user should enter "value" into "Second Name" input field
    Then user should enter "value" into "Third Name" input field
    Then user clicks on "Store" button
    Then user clicks on "Back" Button
    Then user updates the "Update Contact Address" button in Personal Details section
    Then user should enter "value" into "Telephone number 2" input field
    Then user should enter "value" into "Address Line 2" input field
    Then user clicks on "Save" button
    Then user clicks on "Exit" button
    Then user updates the "Update Home Address" button in Personal Details section
    Then user should enter "value" into "Telephone number 2" input field
    Then user should enter "value" into "Address Line 2" input field
    Then user should enter "value" into "Address Line 4" input field
    Then user clicks on "Save" button
    Then user clicks on "Exit" button
    #    #    =========student module=================
    Then user clicks on the "Student Module Application" panel titles
    Then user Selects "Add" button
    Then user should enter "value" into "Module Code" input field
    Then user should enter "value" into "Name" input
    Then user should enter "value" into "Academic Year" input field
    Then user should select "Source" as "value" from Dropdown
    Then user should enter "value" into "Period Slot" input field
    Then user should enter "value" into "Module Type" input field
    Then user should enter "value" into "Mark Scheme" input field
    Then user should enter "value" into "Scheme Code" input field
    Then user "Store" the details
    Then user clicks on refresh
    #Then user selects "Generate" button
    Then user "Close" the details
    #    #  ======Clearance Checks====
    Then user clicks on the "Clearance Checks" panel titles
    Then user Selects "Add" button
    Then user should enter "value" into "CCL Code"
    Then user "Store" the details
    Then user selects "Generate" button
    Then user "close" the details
    #    #  =================Decision================
    Then user clicks on the "Decision" panel titles
    Then user should enter "value" into "Qual Status" input field
    Then user should enter "value" into "Decision" input field
    Then user Selects "Save" button
    Then user clicks on "Logout" Link

    #    =========Applicant Login and Accepting the offer============
    #Then user clicks on "Click here to re-login" Link
    #When user enters the login details of the applicant
    #Then user changes the "New Password" as "value"
    #Then user changes the "Confirm Password" as "value"
    #Then user clicks on "Go" button
    #Then user clicks on "my Application" menuItem
    #Then user clicks on "Documents" tile
    #Then user clicks on "Upload" Link
    #Then user uploads the required documents
    #Then user clicks on "Upload" Link
    #Then user clicks on "Next" button
    #Then user clicks on "Back" Link
    #Then user clicks on "Respond to Offer" tile
    #Then user should select " Do you wish to accept or decline this offer?* " as "value" from Dropdown
    #Then user clicks on "Confirm" button
    #Then user clicks on "Exit" button
    #Then user clicks on "Logout" Link
    Examples: 
      | RowNumber |
      |         1 |
