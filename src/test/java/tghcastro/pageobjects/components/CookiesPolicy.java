package tghcastro.pageobjects.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import tghcastro.pageobjects.support.InstancesRepository;

import java.time.Duration;

public class CookiesPolicy {

    private final WebDriver driver;

    public CookiesPolicy() {
        this.driver = InstancesRepository.getUIAutomationDriver();
    }

    public void acceptAll() {
        System.out.println("Accepting cookies policies");
        WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofSeconds(5));

        WebElement policyWindowTitle = this.driver.findElement(By.id("content"));
        wait.until(ExpectedConditions.visibilityOf(policyWindowTitle));

        System.out.println("Cookies policy is visible");

        String acceptAllXpath = "//span[contains(text(),'Accept all')]/ancestor::button";
        WebElement acceptAll = this.driver.findElement(By.xpath (acceptAllXpath));
        wait.until(ExpectedConditions.elementToBeClickable(acceptAll));
        acceptAll.click();

        wait.until(ExpectedConditions.invisibilityOf(policyWindowTitle));

        System.out.println("Cookies policy is not visible anymore");
    }
}
