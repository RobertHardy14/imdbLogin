package stepdefs;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class imdbSteps {
    WebDriver driver = new ChromeDriver();
    WebDriverWait wait = new WebDriverWait(driver,5);
    //driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
    @When("I open the IMDB webpage")
    public void i_open_the_IMDB_webpage()
    {
        String expectedTitle = driver.getTitle();
        String actualTitle = "IMDb: Ratings, Reviews, and Where to Watch the Best Movies & TV Shows";
        driver.get("https://www.imdb.com");
        if(expectedTitle.equals(actualTitle))
            System.out.println("Correct webpage");
        else
        {
            System.out.println("Incorrect webpage");
        }
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
        WebElement emailField = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='ap_email']")));
        emailField.sendKeys("rob.moreno@hotmail.com");
        WebElement passwordField = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='ap_password']")));
        passwordField.sendKeys("NgTheRefact");
        WebElement bSignIn = driver.findElement(By.xpath("//input[@id='signInSubmit']"));
        bSignIn.click();
        System.out.println("Logged In");
    }

    //@Then("I search for a movie")
    public void i_search_for_a_movie()
    {
        WebElement searchBar = driver.findElement(By.xpath("//input[@id='suggestion-search']"));
        searchBar.sendKeys("American Sniper");
        //WebElement movieDropdown = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(("//div[contains(.,'American Sniper')])"))));
        //movieDropdown.click();
        WebElement bSearch = driver.findElement(By.xpath("//button[@id = 'suggestion-search-button']"));
        bSearch.click();
        WebElement movieTitleSearch = driver.findElement(By.xpath("//td[contains(., '2014')]/a[text() ='American Sniper']"));
        movieTitleSearch.click();
        WebElement bAddToWatchList = driver.findElement(By.xpath("//button[contains(.,'Add to Watchlist')]"));
        bAddToWatchList.click();
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

    @Then("I search for {string} movie from {int} year")
    public void iSearchForAmericanSniperMovie(String movieName, int movieYear)
    {
        WebElement searchBar = driver.findElement(By.xpath("//input[@id='suggestion-search']"));
        searchBar.sendKeys(movieName);
        //WebElement movieDropdown = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(("//div[contains(.,'American Sniper')])"))));
        //movieDropdown.click();
        WebElement bSearch = driver.findElement(By.xpath("//button[@id = 'suggestion-search-button']"));
        bSearch.click();
        WebElement movieTitleSearch = driver.findElement(By.xpath("//td[contains(., '"+movieYear+"')]/a[text() ='"+movieName+"']"));
        movieTitleSearch.click();
        //WebElement bAddToWatchList = driver.findElement(By.xpath("//button[contains(.,'Add to Watchlist')]"));
        //bAddToWatchList.click();
    }
}
