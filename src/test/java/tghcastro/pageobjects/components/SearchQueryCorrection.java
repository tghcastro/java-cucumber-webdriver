package tghcastro.pageobjects.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import tghcastro.pageobjects.SearchResultsPage;
import tghcastro.pageobjects.support.InstancesRepository;

import java.time.Duration;

public class SearchQueryCorrection {

    private final WebDriver driver;
    private final WebDriverWait wait;

    public SearchQueryCorrection() {
        this.driver = InstancesRepository.getUIAutomationDriver();
        this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(5));
    }

    public String fullMessage() {
        String xpathSearchQueryCorrection = "//*[contains(text(),'Showing results for')]/ancestor::yt-search-query-correction";
        WebElement searchQueryCorrection = this.driver.findElement(By.xpath(xpathSearchQueryCorrection));
        wait.until(ExpectedConditions.visibilityOf(searchQueryCorrection));
        return searchQueryCorrection.getText();
    }

    public SearchResultsPage searchInsteadFor(String userName) {
        System.out.println("Searching instead for " + userName);
        return new SearchResultsPage();
    }

    public String showingResultsForMessage() {
        String xpathShowingResultsForMessage = "//*[contains(text(),'Showing results for')]";
        WebElement showingResultsForMessage = this.driver.findElement(By.xpath(xpathShowingResultsForMessage));
        wait.until(ExpectedConditions.visibilityOf(showingResultsForMessage));
        return showingResultsForMessage.getText();
    }

    public String searchingInsteadForMessage() {
        String xpathSearchingInsteadFor = "//*[contains(text(),'Search instead for')]";
        WebElement searchingInsteadFor = this.driver.findElement(By.xpath(xpathSearchingInsteadFor));
        wait.until(ExpectedConditions.visibilityOf(searchingInsteadFor));
        return searchingInsteadFor.getText();
    }

    public void mustBeVisible() {
        this.showingResultsForMessage();
        this.searchingInsteadForMessage();
        System.out.println("Search Query Correction message is displayed");
    }
}
