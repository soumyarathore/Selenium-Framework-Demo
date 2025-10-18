package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class Hooks {

    public static WebDriver driver;

    @Before
    public void setUp() {
        System.out.println("🚀 Launching browser with user-like settings...");

        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--disable-blink-features=AutomationControlled"); // hides automation
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        options.setExperimentalOption("useAutomationExtension", false);
        options.addArguments("--headless"); // no UI in Docker
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-gpu");
        options.addArguments("--window-size=1920,1080");

        // Optional: use a real Chrome user profile
        // Replace with your own local user profile path
        // options.addArguments("user-data-dir=/Users/yourname/Library/Application Support/Google/Chrome/Default");

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @After
    public void tearDown() {
        System.out.println("🧹 Closing browser...");
        if (driver != null) {
           // driver.quit();
        }
    }

    public static WebDriver getDriver() {
        return driver;
    }
}
