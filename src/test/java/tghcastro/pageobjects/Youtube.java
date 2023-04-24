package tghcastro.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import tghcastro.pageobjects.support.InstancesRepository;

import java.time.Duration;

public class Youtube {
    private final WebDriver driver;

    public Youtube() {
        this.driver = new ChromeDriver();
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        InstancesRepository.setUIAutomationDriver(driver);
        System.out.println("Starting Youtube");
    }

    public MainPage main() {
        return InstancesRepository.loadInstance(MainPage.class);
    }

    public SearchResultsPage searchResults() {
        return InstancesRepository.loadInstance(SearchResultsPage.class);
    }

    public void close() {
        this.driver.close();
    }
}
