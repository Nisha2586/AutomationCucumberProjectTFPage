@Regression
Feature: TechFios Page Background Color Validation

Background:
Given User should be on TechFios Page
And Verify setskybluebg Button exist
And Verify setWhitebg Button exist

@SkyBlue
Scenario: User should be able to set skyblue background color while clicking the button
When User clicks setskybluebackground Button
Then Background color will change to skyblue

@SkyWhite
Scenario: User should be able to set skyWhite background color while clicking the button
When User clicks setwhitebackground Button
Then Background color will change to skywhite
