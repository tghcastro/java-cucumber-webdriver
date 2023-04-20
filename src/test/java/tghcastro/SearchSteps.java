package tghcastro;

import io.cucumber.java.en.*;

import static tghcastro.ScenarioContextConstants.USER_NAME;

public class SearchSteps {

    private ScenarioContext context;

    public SearchSteps(ScenarioContext context) {
        this.context = context;
    }

    @When("I search for this user")
    public void i_search_for_this_user() {
        System.out.println("Searching for " + this.context.getValue(USER_NAME));
    }

    @When("I confirm my original search")
    public void i_confirm_my_original_search() {

    }

}
