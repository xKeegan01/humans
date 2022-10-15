package testing;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class InitTestData extends InitBrowser {
    protected WebDriver driver;
    protected String url;
    protected String username;
    protected String password;

    @Parameters({"url", "username", "password"})
    @BeforeMethod
    public void initialData(String url, String username, String password) {
        driver = getChromeDriver();
        this.url = url;
        this.username = username;
        this.password = password;
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(1000);
        driver.quit();
    }
}
