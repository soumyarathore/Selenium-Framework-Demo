package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GoogleHomePage {

    WebDriver driver;

    // Locators
    By searchBox = By.name("q");

    // Constructor
    public GoogleHomePage(WebDriver driver) {
        this.driver = driver;
    }

    // Actions
    public void openGooglePage() {
        driver.get("https://www.google.com");
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    public void searchFor(String keyword) {
        driver.findElement(searchBox).sendKeys(keyword + "\n");
    }
}
