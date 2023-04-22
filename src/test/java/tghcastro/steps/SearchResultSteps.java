package tghcastro.steps;

import io.cucumber.java.en.Then;
import tghcastro.steps.support.ScenarioContext;

import static tghcastro.steps.support.ScenarioContextConstants.NAME;

public class SearchResultSteps {
    private ScenarioContext context;

    public SearchResultSteps(ScenarioContext context) {
        this.context = context;
    }

    @Then("Youtube displays videos from {string}")
    public void youtube_displays_videos_from(String name) {
        this.context.setValue(NAME, name);
    }

    @Then("Youtube displays results for {string} instead of {string}")
    public void youtube_displays_results_for_instead_of(String string, String string2) {

    }

}
