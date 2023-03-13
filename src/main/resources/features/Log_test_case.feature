Feature: Test case Log

  Background:Open web successful
    Given Wise Ai access with "admin" "5Netcam!" "10.42.217.90"
    Then Click Setup Wise AI
    And CLick Log Button

    Scenario: TC002004126
      Then Click System log Button
      Then Click to next page

    Scenario: TC002004127
      Then Click System log Button
      Then Click to last page

    Scenario: TC002004128
      Then Click System log Button
      Then Click to first page

    Scenario: TC002004129
      Then Click System log Button
      Then Check "ConfigurationBackup" exist in the system log list

    Scenario: TC002004130
      Then Click System log Button
      Then Check "ConfigurationRestore" exist in the system log list

    Scenario: TC002004131
      Then Click System log Button
      Then Check "ConfigChange" exist in the system log list

    Scenario: TC002004132
      Then Click System log Button
      Then Check "DataBase" exist in the system log list

    Scenario: TC002004133
      Then Click System log Button
      Then Check "AppStart" exist in the system log list

    Scenario:  TC002004134
      Then Click System log Button
      Then Check "AppReset" exist in the system log list

    Scenario: TC002004135
      Then Click Event Log Button
      Then Check "Objectdetection" exist in the event log list
      
    Scenario: TC002004136
      Then Click Event Log Button
      Then Check "IVA Area" exist in the event log list

    Scenario: TC002004137
      Then Click Event Log Button
      Then Check "LineCrossing" exist in the event log list

    Scenario: TC002004138
      Then Click Event Log Button
      Then Check "TrafficJAMDetection" exist in the event log list

    Scenario: TC002004139
      Then Click Event Log Button
      Then Check "Stopped Vehicle Detection" exist in the event log list

    Scenario: TC002004140
      Then Click System log Button
      Then Check data in log table

    Scenario:  TC002004141
      Then Click System log Button
      Then  Log Page is displayed in the form below "No.,Date&Time,Description,Information"