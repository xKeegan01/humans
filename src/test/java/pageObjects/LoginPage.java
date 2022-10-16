package pageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends InitPageData {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    private WebElement getUsernameInput() {
        By locator = By.xpath("//*[@type='text']");
        wait.until(ExpectedConditions.elementToBeClickable(locator));
        return driver.findElement(locator);
    }

    private WebElement getPasswordInput() {
        By locator = By.xpath("//*[@type='password']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return driver.findElement(locator);
    }
    private WebElement getSubmitButton() {
        By locator = By.xpath("//*[@type='submit']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return driver.findElement(locator);
    }

    public HomePage login(String username, String password) {
        getPasswordInput().sendKeys(password);
        getUsernameInput().sendKeys(username);
        getSubmitButton().click();
        return new HomePage(driver);
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
