Feature: Youtube Search for weird user name

  Scenario: Search for a video using an weird user name
    Given a video published video from the user "tghcastro"
    When I search for this user
    Then Youtube displays results for "tgh castro" instead of "tghcastro"
    When I confirm my original search
    Then Youtube displays videos from "Thiago de Castro"
