package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class InitPageData {
    protected WebDriver driver;
    protected WebDriverWait wait;

    protected Actions action;

    public InitPageData(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        action = new Actions(driver);
    }
}
