package stepdefinitions;

import hooks.Hooks;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import pages.GoogleHomePage;

public class LoginSteps {
    GoogleHomePage googlePage;

    @Given("user launches Chrome browser")
    public void user_launches_chrome_browser() {
        googlePage = new GoogleHomePage(Hooks.getDriver());
    }

    @When("user opens Google homepage")
    public void user_opens_google_homepage() {
        googlePage.openGooglePage();
    }

    @Then("page title should contain {string}")
    public void page_title_should_contain(String title) {
        Assert.assertTrue(googlePage.getPageTitle().contains(title));
    }

    @Then("user searches for {string}")
    public void user_searches_for(String keyword) {
        googlePage.searchFor(keyword);
    }
}
