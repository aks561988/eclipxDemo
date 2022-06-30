Feature: Google Search Feature

Scenario: Verify google search feature
Given User is on the Google Search page
When User enters "Eclipx" on the text box
And User selects the first link in the results page
Then keyword "Eclipx" should be present on the page



    
      
  
