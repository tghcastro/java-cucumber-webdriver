package tghcastro.steps;

import io.cucumber.java.en.*;
import tghcastro.pageobjects.Youtube;
import tghcastro.steps.support.ScenarioContext;

import static tghcastro.steps.support.ScenarioContextConstants.USER_NAME;

public class SearchSteps {

    private final ScenarioContext context;
    private final Youtube youtube;

    public SearchSteps(ScenarioContext context, Youtube youtube) {
        this.context = context;
        this.youtube = youtube;
    }

    @When("I search for this user")
    public void i_search_for_this_user() {
        String userName = this.context.getValue(USER_NAME).toString();
        this.youtube.main().searchBar().searchFor(userName);
    }

    @When("I confirm my original search")
    public void i_confirm_my_original_search() {
        String userName = this.context.getValue(USER_NAME).toString();
        this.youtube.searchResults().searchQueryCorrection().searchInsteadFor(userName);
    }

}
