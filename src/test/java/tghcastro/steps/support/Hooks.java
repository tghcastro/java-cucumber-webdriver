package tghcastro.steps.support;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import tghcastro.pageobjects.Youtube;

public class Hooks {

    private final ScenarioContext scenarioContext;
    private final Youtube youtube;

    public Hooks(ScenarioContext scenarioContext, Youtube youtube) {
        this.scenarioContext = scenarioContext;
        this.youtube = youtube;
    }

    @Before
    public void beforeScenario(Scenario scenario){
        System.out.println("### Starting Scenario >>> " + scenario.getName());
        this.youtube.main().navigateTo();
    }

    @After
    public void afterScenario(Scenario scenario){
        System.out.println("Scenario Context: " + this.scenarioContext.toString());
        System.out.println("### Finished Scenario >>> " + scenario.getName());
    }
}
