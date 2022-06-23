@demo
Feature: Staff Login,OAO,Application Review

  Scenario: OAO FLOW
    When user enters the login details
    Then user clicks on "Online Admissions Office" menuItem
    Then user clicks on "Online Admissions Office - Admissions View" tab
    Then user selects "PCG_BLUK" radio button
#    Then user chooses Blended UK Campuses Portal Course Group
    Then user selects "Applicant Search" tab
    Then user should enter "21100913" into Student Number input field
    Then user selects the student record displayed in Results section
#    ===============summary details===============
    Then user clicks on the "Summary" panel titles
    Then user clicks on "Update Acceptance Status" Button
    Then user should select "Applicant Acceptance Status*" as "ATR Sucessfully Processed (Dummy Data)" from options in the Dropdown
    Then user clicks on "Submit" button
    Then user clicks on "Back" button
    Then user closes the "Summary" Panel titles
#    ============personal details==========
    Then user clicks on the "Personal Details" panel titles
    Then user updates the "Update Personal Details" button in Personal Details section
    Then user should select "Title" as "Lord" from options in the Dropdown
    Then user clicks on "Store" button
    Then user clicks on "Back" Button
    Then user updates the "Update Contact Address" button in Personal Details section
    Then user should enter "7890123456" into "Telephone number 2" input field
    Then user clicks on "Save" button
    Then user clicks on "Exit" button
    Then user updates the "Update Home Address" button in Personal Details section
    Then user should enter "United Kingdom" into "Address Line 4" input field
    Then user clicks on "Save" button
    Then user clicks on "Exit" button

#    =========== Qualification=====================
    Then user clicks on the "Qualifications" panel titles
    Then user selects "Details" button
    Then user should select "Grade (previous)" as "Distinction" from options in the Dropdown
    Then user "Store" the details
    Then user closes the "Qualifications" Panel titles

#    =========student module=================
    Then user clicks on the "Student Module Application" panel titles
    Then user selects "Add" button
    Then user should enter "BUS3003" into "Module Code" input field
    Then user should enter "Business Etiquettes" into "Name" input
    Then user should enter "2021/22" into "Academic Year" input field
    Then user should select "Source" as "Manual" from Dropdown
    Then user "Store" the details
    Then user selects "Generate" button
    Then user "Close" the details

#  =============Actions===================
    Then user clicks on the "Actions" panel titles
    Then user should select "Select Action" as "Ready for Decision" from Dropdown
    Then user selects "Ok" button
    Then user waits till loading completes
    Then user closes the "Actions" Panel titles
    Then user clicks on refresh
#  ======Clearance Checks====
    Then user clicks on the "Clearance Checks" panel titles
    Then user should select "SCC records to display" as "B" from options in the Dropdown
    Then user selects "Add" button
    Then user should enter "FSQ" into "CCL Code" input field
    Then user "Store" the details
#    Then user waits for saving
    Then user selects "Generate" button
    Then user "close" the details
#  ===========Review============
    Then user clicks on the "Review" panel titles
    Then user clicks on "Send to Reviewers"
    Then user selects "prolifics" from combo box
    Then user should enter "testing" into "Comments for Reviewer" textarea field
    Then user should enter "31/May/2022" into "Deadline Date" input field
    Then user should click on Send to Reviewers button
    Then user clicks on "Back" button
#  =================Decision================
#    Then user clicks on the "Decision" panel titles
#    Then user should enter "QV" into "Qual Status" input field
#    Then user should enter "U" into "Initial Decision" input field
#    Then user Selects "Save" button
#    Then user "Close" the details
#    Then user Selects "Save" button
#    Then user "Close" the details
##   ===========Fees/Visa==============
    Then user clicks on the "Fees/Visa" panel titles
#    ==========Funding Informatiom==========
    Then user clicks on the "Funding Information" panel titles
    Then user selects Edit button
    Then user should select "Referral Type*" as "PG Course" from options in the Dropdown
    Then user clicks on "Submit" button
    Then user clicks on "Back" button
#  =====Agents========
    Then user clicks on the "Agents" panel titles
#    Then user clicks on refresh
#    Then user clicks on the "Agents" panel titles
    Then user Selects "Add" button
    Then user should enter "Auto1" into "Agent code" input field
    Then user "Store" the details
    Then user clicks on refresh
#    =======Communications=====
    Then user clicks on the "Communications" panel titles
    Then user clicks on the "New Communication" panel titles
    Then user selects "E" radio button
    Then user should select "Contact Method" as "E-mail" from options in the Dropdown
    Then user should select "Action" as "Email" from options in the Dropdown
    Then user should select "Category" as "TRIBAL TEST CATEGORY" from options in the Dropdown
    Then user should enter "Test data" into "Notes" textarea field
    Then user selects "Create" button
# =================== Emails and letters sent to Applicant===========
    Then user clicks on the "Emails and Letters Sent to Applicant" panel titles
    Then user clicks on Send email to applicant link
    Then user should select "Letter Generation" as "Offer Email" from options in the Dropdown
    Then user clicks on "Send email" button
#    Then user switches to default window
#    ============Folder Audit============
#    Then user clicks on the "Folder Audit" panel titles
#    Then user clicks on "Online Admissions Office" menuItem
#    Then user clicks on "Online Admissions Office - Admissions View" tab
#    Then user chooses Blended UK Campuses Portal Course Group
#    Then user clicks on "Load applications" button
#    Then user clicks on "Logout" Link
