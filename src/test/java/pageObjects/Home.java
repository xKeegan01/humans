package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Home extends InitPageData {
    public Home(WebDriver driver) {
        super(driver);
    }

    public void openDriver(String url) {
        driver.get(url);
    }

    private WebElement getLoginButton() {
        By locator = By.xpath("//*[text()='Log in']");
        wait.until(ExpectedConditions.elementToBeClickable(locator));
        return driver.findElement(locator);
    }

    public Login getLoginPage() {
        getLoginButton().click();
        return new Login(driver);
    }
}
