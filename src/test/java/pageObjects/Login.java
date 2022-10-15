package pageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Login extends InitPageData {
    public Login(WebDriver driver) {
        super(driver);
    }

    private WebElement getSubmitButton() {
        By locator = By.xpath("//*[@type='submit']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return driver.findElement(locator);
    }

    public boolean isSubmitDisplayed() {
        try {
            return getSubmitButton().isDisplayed();
        } catch (NoSuchElementException ex) {
            ex.printStackTrace();
            return false;
        }
    }
}
