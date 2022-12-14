package testing;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;

public class HomePageTest extends InitTestData {

    @Test
    public void returnLoginObject() {
        HomePage homePage = new HomePage(driver);
        homePage.openDriver(url);
        LoginPage loginPage = homePage.getLoginPage();
        Assert.assertTrue(loginPage.isSubmitDisplayed());
    }
}
