package tghcastro.pageobjects.components;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import tghcastro.pageobjects.SearchResultsPage;
import tghcastro.pageobjects.support.InstancesRepository;

import java.time.Duration;

public class SearchBar {
    private final WebDriver driver;
    private WebElement searchField;
    private WebElement searchInput;

    public SearchBar() {
        this.driver = InstancesRepository.getUIAutomationDriver();
    }

    public void searchFor(String userName) {
        System.out.println("Searching for " + userName);

        WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofSeconds(5));

        String xpath = "//*[@id=\"search-input\"]";
        this.searchField = this.driver.findElement(By.xpath(xpath));
        wait.until(ExpectedConditions.visibilityOf(this.searchField));
        this.searchField.click();

        System.out.println("Search field is available");

        this.searchInput = this.driver.findElement(By.name("search_query"));
        this.searchInput.sendKeys(userName);
        this.searchInput.sendKeys(Keys.RETURN);

        SearchResultsPage results = InstancesRepository.loadInstance(SearchResultsPage.class);
        results.mustBeOpen(userName);
        results.searchQueryCorrection().mustBeVisible();
    }

}
