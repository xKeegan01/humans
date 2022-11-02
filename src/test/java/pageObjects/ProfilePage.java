package pageObjects;

import org.openqa.selenium.*;
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

    //add personal story test elements
    private WebElement getAddProfileStory() {
        By locator = By.xpath("//span[contains(text(),'personal story')]");
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return driver.findElement(locator);
    }

    private WebElement getProfileStoryInput() {
        By locator = By.xpath("//*[@class='form-textarea__area editzone__editext']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return driver.findElement(locator);
    }

    private WebElement getSaveStoryBtn() {
        By locator = By.xpath("//span[text()='Save']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return driver.findElement(locator);
    }

    //edit/delete personal story
    private WebElement getProfileDescription() {
        By locator = By.xpath("//p[@class='user-description__text']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return driver.findElement(locator);
    }
    private WebElement getEditBtn() {
        action.moveToElement(getProfileDescription()).perform();
        By locator = By.xpath("//*[@class='editkey on']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return driver.findElement(locator);
    }

    public void addPersonalStory(String personalStory) {
        getAddProfileStory().click();
        getProfileStoryInput().sendKeys(personalStory);
        getSaveStoryBtn().click();
    }

    public void deletePersonalStory() {
        getEditBtn().click();
        getProfileStoryInput().sendKeys(Keys.chord(Keys.COMMAND, "a"));
        getProfileStoryInput().sendKeys(Keys.DELETE);
        getSaveStoryBtn().click();
    }


    public boolean isEditVisible() {
        action.moveToElement(getProfileDescription()).perform();
        return getEditBtn().isDisplayed();
    }

    public boolean isProfileStoryDeleted() {
        return getAddProfileStory().isDisplayed();
    }
    public boolean isProfileStoryCreated() {
        return getProfileDescription().isDisplayed();
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
