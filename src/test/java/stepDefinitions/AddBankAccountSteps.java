package stepDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class AddBankAccountSteps {
    WebDriver driver;

   //Before execution change the path to the chromedriver.exe
    @Given("^user is already on Login Page$")
    public void user_already_on_login_page() {
        System.setProperty("webdriver.chrome.driver", "/Users/Andon/Downloads/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://login.xero.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @When("^user enters \"(.*)\" and \"(.*)\"$")
    public void user_enters_username_and_password(String username, String password) {
        driver.findElement(By.name("userName")).sendKeys(username);
        driver.findElement(By.name("password")).sendKeys(password);
    }

    @And("^user clicks on login button$")
    public void user_clicks_on_login_button() {
        WebElement loginBtn = driver.findElement(By.id("submitButton"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", loginBtn);
    }

    @Given("^user choose to add new bank account$")
    public void user_choose_to_add_new_bank_account() {
        WebElement accountTab = driver.findElement(By.xpath("//a[@id='Accounts']"));
        WebElement bankAccount = driver.findElement(By.xpath("//li/a[contains(text(),'Bank Accounts')]"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", accountTab);
        js.executeScript("arguments[0].click();", bankAccount);


    }

    @When("^user select the correct bank$")
    public void user_select_the_correct_bank() {
        WebElement addBtn = driver.findElement(By.xpath("//a[contains(@href,'/Banking/Account/#find')]"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", addBtn);
        driver.findElement(By.xpath("//input[contains(@id,'searchfield')]")).sendKeys("anz");
        driver.findElement(By.xpath("//a[contains(text(),'Show')]")).click();
        driver.findElement(By.xpath("//li[contains(text(),'ANZ (NZ)')]")).click();


    }

    @And("^user enters bank account details \"(.*)\" \"(.*)\"$")
    public void user_enters_bank_account_details_accountname_accountnumber(String accountname, String accountnumber) {
        driver.findElement(By.xpath("//input[contains(@id,'accountname')]")).sendKeys(accountname);
        driver.findElement(By.xpath("//div[contains(@id,'accounttype')]")).click();
        driver.findElement(By.xpath("//ul[contains(@id,'boundlist')]/li[4]")).click();

        driver.findElement(By.xpath("//div[contains(@id,'accountDetailCreditCard')]//input[contains(@id,'accountnumber')]")).sendKeys(accountnumber);

        driver.findElement(By.xpath("//span[contains(text(), 'Continue')]")).click();
    }

    @Then("^the new bank account is created$")
    public void the_new_bank_account_is_created() {
        driver.findElement(By.xpath("//a[contains(text(), 'Test')]")).isDisplayed();

        driver.quit();

    }

}
