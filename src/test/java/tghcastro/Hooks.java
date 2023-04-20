package tghcastro;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {

    private final ScenarioContext scenarioContext;

    public Hooks(ScenarioContext scenarioContext) {
        this.scenarioContext = scenarioContext;
    }

    @Before
    public void beforeScenario(Scenario scenario){
        System.out.println("### Starting Scenario >>> " + scenario.getName());
    }

    @After
    public void afterScenario(Scenario scenario){
        System.out.println("Scenario Context: " + this.scenarioContext.toString());
        System.out.println("### Finished Scenario >>> " + scenario.getName());
    }
}
