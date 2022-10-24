package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProfilePage extends InitPageData {

    public ProfilePage(WebDriver driver) {
        super(driver);
    }

    private WebElement getProfilePageName() {
        By locator = By.className("sidebar__username");
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return driver.findElement(locator);
    }


    public boolean isProfilePage() {
        try {
            return getProfilePageName().isDisplayed();
        } catch (TimeoutException ex) {
            System.out.println("Element not found");
            return false;
        }
    }
}
