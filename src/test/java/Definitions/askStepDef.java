package Definitions;

import Pages.LoginPage;
import Pages.Teachers_homePage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import support.TestContext;
import Pages.LoginPage;
import java.time.Duration;
import static org.assertj.core.api.Assertions.*;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class askStepDef {
    WebDriver driver=null;
    LoginPage loginPage;
    Teachers_homePage teachersHomePage;
    TestContext testContext;
    WebDriverWait wait;

    @Before
    public void lanuch_browser(){
        switch ("chrome") {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
        }
        driver.manage().window().maximize();

    }

    @After
    public void teardown(){
        driver.close();
        driver.quit();
    }

    @And("I quit from the browser window")
    public void iQuitFromTheBrowserWindow() {
        driver.close();
        driver.quit();
    }

    @When("^I type (.*) in the email textbox$")
    public void iTypeEmailInTheEmailTextbox(String email) {
        loginPage=new LoginPage(driver);
        loginPage.enterEmail(email);
    }

    @And("^I type (.*) in the password textbox$")
    public void iTypePasswordInThePasswordTextbox(String password) {
        loginPage.enterPassword(password);
    }

    @And("I click the Sign-In button")
    public void iClickTheSignInButton() {
        loginPage.clickSignIn();
    }

    @And("I wait for {int} seconds")
    public void iWaitForSeconds(int wait_time) throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(wait_time));
       // loginPage.waitUntilLocated(wait_time,loginPage.err_msg_invalidCredentials);
    }

    @Then("I should see the Home link in the side navigation menu")
    public void iShouldSeeTheHomeLinkInTheSideNavigationMenu() {
        teachersHomePage=new Teachers_homePage(driver);
        assertThat(driver.findElement(teachersHomePage.lnk_Home).isDisplayed()).isTrue();
    }

    @And("I click the Logout link from the side navigation menu")
    public void iClickTheLinkLogoutFromTheSideNavigationMenu() {
        teachersHomePage.clickLogout();
    }

    @Then("I should navigate to login page successfully")
    public void iShouldNavigateToLoginPageSuccessfully() {
        assertThat(driver.findElement(loginPage.btn_signIn).isDisplayed()).isTrue();
    }

    @Given("I open the url {string}")
    public void iOpenTheUrl(String url) {
        driver.get(url);
    }

    @Then("I should see an error message")
    public void iShouldSeeAnErrorMessage() {
        assertThat(driver.findElement(loginPage.err_msg_invalidCredentials).isDisplayed()).isTrue();
    }


    @And("I wait for maximum of {int} seconds until the error message is displayed")
    public void iWaitForMaximumOfSecondsUntilTheErrorMessageIsDisplayed(int wait_time) {
        loginPage.waitUntilLocated(wait_time,loginPage.err_msg_invalidCredentials);
        assertThat(driver.findElement(loginPage.err_msg_invalidCredentials).isDisplayed()).isTrue();
    }
}
