package tghcastro.steps;

import io.cucumber.java.en.Given;
import tghcastro.pageobjects.Youtube;
import tghcastro.steps.support.ScenarioContext;

public class CookiesPolicySteps {
    private final ScenarioContext context;
    private final Youtube youtube;

    public CookiesPolicySteps(ScenarioContext context, Youtube youtube) {
        this.context = context;
        this.youtube = youtube;
    }

    @Given("I accepted the Cookies policies")
    public void i_accepted_the_cookies_policies() {
        this.youtube.main().CookiesPolicy().acceptAll();
    }
}
