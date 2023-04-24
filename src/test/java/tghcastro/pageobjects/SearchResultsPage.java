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
    private final WebDriverWait wait;

    public SearchResultsPage() {
        this.driver = InstancesRepository.getUIAutomationDriver();
        this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(5));
    }

    public SearchQueryCorrection searchQueryCorrection() {
        return InstancesRepository.loadInstance(SearchQueryCorrection.class);
    }

    public String displayedUser() {
        String xpathChannelDisplayed = "//*[contains(text(),'@')]/ancestor::ytd-channel-renderer";
        WebElement channel = this.driver.findElement(By.xpath(xpathChannelDisplayed));
        this.wait.until(ExpectedConditions.visibilityOf(channel));

        WebElement name = channel.findElement(By.id("text"));
        return name.getText();
    }

    public void mustBeOpen(String queryValue) {
        this.wait.until(ExpectedConditions.titleIs(queryValue + " - YouTube"));
        this.wait.until(ExpectedConditions.urlContains("search_query=" + queryValue));

        String aboutResultsXpath = "//span[contains(text(),'About these results')]";
        WebElement aboutResults = this.driver.findElement(By.xpath(aboutResultsXpath));
        this.wait.until(ExpectedConditions.visibilityOf(aboutResults));

        System.out.println("Results page is displayed");
    }
}
