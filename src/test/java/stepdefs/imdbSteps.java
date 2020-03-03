package stepdefs;

import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.junit.Cucumber;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class imdbSteps {
    static WebDriver driver = new ChromeDriver();

    @When("I open the IMDB webpage")
    public void i_open_the_IMDB_webpage()
    {
        driver.get("https://www.imdb.com");
    }

    @Then("I click on the Login button")
    public void i_click_on_the_Login_button()
    {
        WebElement bLogin = driver.findElement(By.xpath("//div[@class='ipc-button__text'][contains(.,'Sign In')]"));
        bLogin.click();
    }

    @Then("I enter my credentials")
    public void i_enter_my_credentials()
    {
        WebElement bImdbLogin = driver.findElement(By.xpath("//span[contains(.,'Sign in with IMDb')]"));
        bImdbLogin.click();
        WebElement emailField = driver.findElement(By.xpath("//input[@id='ap_email']"));
        emailField.sendKeys("rob.moreno@hotmail.com");
        WebElement passwordField = driver.findElement(By.xpath("//input[@id='ap_password']"));
        passwordField.sendKeys("NgTheRefact");
        WebElement bSignIn = driver.findElement(By.xpath("//input[@id='signInSubmit']"));
        bSignIn.click();
        System.out.println("Logged In");
    }

    @Then("I search for a movie")
    public void i_search_for_a_movie()
    {
        WebElement searchBar = driver.findElement(By.xpath("//input[@id='suggestion-search']"));
        searchBar.sendKeys("American Sniper");
    }

    @Then("I log out")
    public void i_log_out()
    {
        WebElement userLogged = driver.findElement(By.xpath("//label[contains(.,'Roberto')]"));
        userLogged.click();
        WebElement signOut = driver.findElement(By.xpath("//a[@href='/registration/logout?ref=nv_usr_lgout_6']"));
        signOut.click();
        System.out.println("Signed Out");
        driver.close();
        driver.quit();
    }

}
