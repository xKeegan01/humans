package testing;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.LoginPageFactory;

public class LoginPageTest extends InitTestData {

    @Test
    public void loginValidCredentials() {
        HomePage homePage = new HomePage(driver);
        homePage.openDriver(url);
        LoginPage loginPage = homePage.getLoginPage();
        homePage = loginPage.login(username, password);
        Assert.assertTrue(homePage.isDisplayed());
    }

    @Test
    public void loginPageFactory() {
        HomePage homePage = new HomePage(driver);
        homePage.openDriver(url);
        LoginPageFactory loginPage = homePage.getLoginPageFactory();
        homePage = loginPage.login(username, password);
        Assert.assertTrue(homePage.isDisplayed());
    }
}
