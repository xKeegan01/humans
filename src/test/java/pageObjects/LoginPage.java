package pageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends InitPageData {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    private WebElement getErrorMessage() {
        By locator = By.xpath("//*[text()='Incorrect login or password']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return driver.findElement(locator);
    }

    private WebElement getUsernameInput() {
        By locator = By.xpath("//*[@type='text']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
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
        //StaleElementReferenceException
        driver.navigate().refresh();
        getUsernameInput().sendKeys(username);
        getPasswordInput().sendKeys(password);
        getSubmitButton().click();
        return new HomePage(driver);
    }

    public boolean isSubmitDisplayed() {
        try {
            return getSubmitButton().isDisplayed();
        } catch (TimeoutException | NoSuchElementException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public boolean isError() {
        try {
            return getErrorMessage().isDisplayed();
        } catch (TimeoutException | NoSuchElementException ex) {
            ex.printStackTrace();
            return false;
        }
    }
}
