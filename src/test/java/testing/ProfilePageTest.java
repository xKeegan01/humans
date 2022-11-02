package testing;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.ProfilePage;

public class ProfilePageTest extends InitTestData {
    @Test
    public void getProfilePage() {
        HomePage homePage = new HomePage(driver);
        homePage.openDriver(url);
        LoginPage loginPage = homePage.getLoginPage();
        homePage = loginPage.login(username, password);
        ProfilePage profilePage = homePage.getProfilePage();
        Assert.assertTrue(profilePage.isProfilePage());
    }

    @Test
    public void addDeleteProfileStory() {
        HomePage homePage = new HomePage(driver);
        homePage.openDriver(url);
        LoginPage loginPage = homePage.getLoginPage();
        homePage = loginPage.login(username, password);
        ProfilePage profilePage = homePage.getProfilePage();
        profilePage.addPersonalStory("test personal story");
        Assert.assertTrue(profilePage.isProfileStoryCreated());
        Assert.assertTrue(profilePage.isEditVisible());
        profilePage.deletePersonalStory();
        Assert.assertTrue(profilePage.isProfileStoryDeleted());

    }
}
