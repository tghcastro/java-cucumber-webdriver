package tghcastro.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import tghcastro.pageobjects.components.SearchQueryCorrection;
import tghcastro.pageobjects.support.InstancesRepository;

import java.time.Duration;

public class SearchResultsPage {
    private final WebDriver driver;

    public SearchResultsPage() {
        this.driver = InstancesRepository.getUIAutomationDriver();
    }

    public SearchQueryCorrection searchQueryCorrection() {
        return InstancesRepository.loadInstance(SearchQueryCorrection.class);
    }

    public String displayedUser() {
        return "Thiago de Castro";
    }

    public void shouldBeOpen(String queryValue) {
        WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofSeconds(5));

        wait.until(ExpectedConditions.titleIs(queryValue + " - YouTube"));
        wait.until(ExpectedConditions.urlContains("search_query=" + queryValue));

        String aboutResultsXpath = "//span[contains(text(),'About these results')]";
        WebElement aboutResults = this.driver.findElement(By.xpath(aboutResultsXpath));
        wait.until(ExpectedConditions.visibilityOf(aboutResults));
    }
}
