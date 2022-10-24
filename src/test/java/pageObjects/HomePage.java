package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends InitPageData {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void openDriver(String url) {
        driver.get(url);
    }

    private WebElement getProfileIcon() {
        By locator = By.xpath("//*[@class='D-0L']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return driver.findElement(locator);
    }

    private WebElement getLoginButton() {
        By locator = By.xpath("//*[text()='Log in']");
        wait.until(ExpectedConditions.elementToBeClickable(locator));
        return driver.findElement(locator);
    }

    public boolean isDisplayed() {
        try {
            return getProfileIcon().isDisplayed();
        } catch (NoSuchElementException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public LoginPage getLoginPage() {
        getLoginButton().click();
        return new LoginPage(driver);
    }

    public LoginPageFactory getLoginPageFactory() {
        getLoginButton().click();
        return new LoginPageFactory(driver);
    }

    public ProfilePage getProfilePage() {
        getProfileIcon().click();
        return new ProfilePage(driver);
    }
}
