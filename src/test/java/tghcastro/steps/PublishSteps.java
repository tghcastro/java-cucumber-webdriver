package tghcastro.steps;

import io.cucumber.java.en.Given;
import tghcastro.pageobjects.Youtube;
import tghcastro.steps.support.ScenarioContext;

import static tghcastro.steps.support.ScenarioContextConstants.USER_NAME;

public final class PublishSteps {

    private final ScenarioContext context;
    private final Youtube youtube;

    public PublishSteps(ScenarioContext context, Youtube youtube) {
        this.context = context;
        this.youtube = youtube;
    }

    @Given("a video published video from the user {string}")
    public void a_video_published_video_from_the_user(String userName) {
        this.context.setValue(USER_NAME, userName);
    }
}
