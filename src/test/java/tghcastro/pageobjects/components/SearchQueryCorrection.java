package tghcastro.pageobjects.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import tghcastro.pageobjects.support.InstancesRepository;

import java.time.Duration;

public class SearchQueryCorrection {

    private final WebDriver driver;
    private final WebDriverWait wait;

    public SearchQueryCorrection() {
        this.driver = InstancesRepository.getUIAutomationDriver();
        this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(2));
    }

    public String fullCorrectionMessage() {
        String xpathSearchQueryCorrection = "//*[contains(text(),'Showing results for')]/ancestor::yt-search-query-correction";
        WebElement searchQueryCorrection = this.driver.findElement(By.xpath(xpathSearchQueryCorrection));
        wait.until(ExpectedConditions.visibilityOf(searchQueryCorrection));
        return searchQueryCorrection.getText();
    }

    public void confirmSearchInsteadFor(String userName) {
        String xpathSearchingInsteadFor = "//*[contains(text(),'Search instead for')]/parent::*/a[2]";
        WebElement searchingInsteadFor = this.driver.findElement(By.xpath(xpathSearchingInsteadFor));
        wait.until(ExpectedConditions.visibilityOf(searchingInsteadFor));
        wait.until(ExpectedConditions.elementToBeClickable(searchingInsteadFor));
        searchingInsteadFor.click();
        this.didYouMeanMustBeVisible();
    }

    public void didYouMeanMustBeVisible() {
        this.didYouMeanMessage(true);
        System.out.println("Search Query Correction: 'Did you mean' is displayed");
    }

    public void correctionMustBeVisible() {
        this.showingResultsForMessage(true);
        this.searchingInsteadForMessage(true);
        System.out.println("Search Query Correction: Correction is displayed");
    }

    public String didYouMeanMessage(Boolean shouldBeVisible) {
        String xpath = "//*[contains(text(),'Did you mean:')]";
        return messageCorrectionVisibility(shouldBeVisible, xpath);
    }

    public String showingResultsForMessage(Boolean shouldBeVisible) {
        String xpath = "//*[contains(text(),'Showing results for')]";
        return messageCorrectionVisibility(shouldBeVisible, xpath);
    }

    public String searchingInsteadForMessage(Boolean shouldBeVisible) {
        String xpath = "//*[contains(text(),'Search instead for')]";
        return messageCorrectionVisibility(shouldBeVisible, xpath);
    }

    private String messageCorrectionVisibility(Boolean shouldBeVisible, String xpath) {
        By messageLocator = By.xpath(xpath);

        if (shouldBeVisible) {
            this.wait.until(ExpectedConditions.visibilityOfElementLocated(messageLocator));
            WebElement showingResultsForMessage = this.driver.findElement(messageLocator);
            return showingResultsForMessage.getText();
        }

        this.wait.until(ExpectedConditions.invisibilityOfElementLocated(messageLocator));
        return null;
    }
}
