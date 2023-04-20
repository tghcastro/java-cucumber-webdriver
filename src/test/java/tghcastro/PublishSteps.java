package tghcastro;

import io.cucumber.java.en.Given;

import static tghcastro.ScenarioContextConstants.USER_NAME;

public final class PublishSteps {

    private final ScenarioContext context;

    public PublishSteps(ScenarioContext context) {
        this.context = context;
    }

    @Given("a video published video from the user {string}")
    public void a_video_published_video_from_the_user(String userName) {
        this.context.setValue(USER_NAME, userName);
    }
}
