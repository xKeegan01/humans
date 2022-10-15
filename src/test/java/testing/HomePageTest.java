package testing;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.Home;
import pageObjects.Login;

public class HomePageTest extends InitTestData {

    @Test
    public void returnLoginObject() {
        Home homePage = new Home(driver);
        homePage.openDriver(url);
        Login loginPage = homePage.getLoginPage();
        Assert.assertTrue(loginPage.isSubmitDisplayed());
    }
}
