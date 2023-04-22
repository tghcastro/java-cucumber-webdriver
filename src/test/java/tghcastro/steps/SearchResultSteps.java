package tghcastro.steps;

import io.cucumber.java.en.Then;
import tghcastro.pageobjects.Youtube;
import tghcastro.steps.support.ScenarioContext;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static tghcastro.steps.support.ScenarioContextConstants.NAME;

public class SearchResultSteps {
    private final ScenarioContext context;
    private final Youtube youtube;

    public SearchResultSteps(ScenarioContext context, Youtube youtube) {
        this.context = context;
        this.youtube = youtube;
    }

    @Then("Youtube displays videos from {string}")
    public void youtube_displays_videos_from(String name) {
        this.context.setValue(NAME, name);
        String displayedUser = this.youtube.searchResults().displayedUser();
        assertEquals(name, displayedUser);
    }

    @Then("Youtube displays results for {string} instead of {string}")
    public void youtube_displays_results_for_instead_of(String wrongSearch, String userName) {
        String expectedMessage = String.format("Showing results for %s Search instead for %s", wrongSearch, userName);
        String displayedMessage = this.youtube.searchResults().searchQueryCorrection().message();
        assertEquals(expectedMessage, displayedMessage);
    }

}
