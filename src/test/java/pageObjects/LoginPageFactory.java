package pageObjects;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class LoginPageFactory {
    private WebDriver driver;

    public LoginPageFactory(WebDriver driver) {
        this.driver = driver;
        AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 5);
        PageFactory.initElements(factory, this);
    }

    @FindBy(xpath = "//*[@type='text']")
    private WebElement emailField;

    @FindBy(xpath = "//*[@type='password']")
    private WebElement passwordField;

    @FindBy(xpath = "//*[@type='submit']")
    private WebElement submitButton;

    public HomePage login(String username, String password) {
        //StaleElementReferenceException - refresh page before locating elements
        driver.navigate().refresh();
        emailField.sendKeys(username);
        passwordField.sendKeys(password);
        submitButton.click();
        return new HomePage(driver);
    }

    public boolean isSubmitDisplayed() {
        try {
            return submitButton.isDisplayed();
        } catch (NoSuchElementException ex) {
            ex.printStackTrace();
            return false;
        }
    }
}
