package tghcastro.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import tghcastro.pageobjects.support.InstancesRepository;

public class Youtube {
    public Youtube() {
        WebDriver driver = new ChromeDriver();
        InstancesRepository.setUIAutomationDriver(driver);
        System.out.println("Starting Youtube");
    }

    public MainPage main() {
        return InstancesRepository.loadInstance(MainPage.class);
    }

    public SearchResultsPage searchResults() {
        return InstancesRepository.loadInstance(SearchResultsPage.class);
    }
}
