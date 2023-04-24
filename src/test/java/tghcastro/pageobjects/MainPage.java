package tghcastro.pageobjects;

import org.openqa.selenium.WebDriver;
import tghcastro.pageobjects.components.CookiesPolicy;
import tghcastro.pageobjects.components.SearchBar;
import tghcastro.pageobjects.support.InstancesRepository;

public class MainPage {
    private final WebDriver driver;

    public MainPage() {
        this.driver = InstancesRepository.getUIAutomationDriver();
    }

    public SearchBar searchBar() {
        return InstancesRepository.loadInstance(SearchBar.class);
    }

    public CookiesPolicy CookiesPolicy() {
        return InstancesRepository.loadInstance(CookiesPolicy.class);
    }

    public void navigateTo() {
        this.driver.get("https://www.youtube.com/");
    }

}
