package testing;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;



public class InitBrowser {
        public static WebDriver getChromeDriver() {
        WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless", "--window-size=1440,710");
        return new ChromeDriver(options);
    }
}
