package hellocucumber;

import helpers.WebFormHelper;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.*;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static utils.PropertiesFactory.getProperty;
import static utils.WebDriverFactory.getDriver;

public class StepDefinitions {

    WebDriver driver = getDriver(getProperty("browser"));
    StartPage startPage = new StartPage(driver);
    WebFormHelper webFormHelper = new WebFormHelper(driver);
    PromoPage promoPage = new PromoPage(driver);
    CreateAccountPage createAccountPage = new CreateAccountPage(driver);
    ProductPage productPage = new ProductPage(driver);
    SearchPage searchPage = new SearchPage(driver);
    String price;
    String title;
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));


    @Given("user opens start page")
    public void userOpensStartPage() {
        webFormHelper.openStartPage();

    }

    @When("user clicks on button Promo")
    public void userClickOnButtonPromo() {
        wait.until(ExpectedConditions.visibilityOf(startPage.shopNewYogaButtonWebElement));
        startPage.shopNewYogaButtonWebElement.click();
    }

    @Then("expected web element is present")
    public void expectedElementIsPresent() {
        assertEquals("New Luma Yoga Collection", driver.getTitle());
        assertEquals("New Luma Yoga Collection", promoPage.newYogaHeadingWebElement.getText());
    }

    @After
    public void tearDown() {
        driver.manage().deleteAllCookies();
    }

    @When("user clicks on button Create account")
    public void userClicksOnButtonCreateAccount() {
        wait.until(ExpectedConditions.visibilityOf(startPage.linkCreateAccountWebElement));
        startPage.linkCreateAccountWebElement.click();

    }

    @Then("expected title and web element are present")
    public void expectedTitleAndWebElementArePresent() {
        assertEquals("Create New Customer Account", driver.getTitle());
        assertEquals("Create New Customer Account", createAccountPage.createAccountHeadingWebElement.getText());
        assertEquals(0, createAccountPage.getRequiredFields().size());
    }

    @When("user fill fields")
    public void userFillFields() {
        createAccountPage.firstnameFieldWebElement.sendKeys("test");
        createAccountPage.lastnameFieldWebElement.sendKeys("test");
        createAccountPage.emailAddressFieldWebElement.sendKeys("roni_cost@example.com");
        createAccountPage.passwordFieldWebElement.sendKeys("roni_cost3@example.com");
        createAccountPage.passwordConfirmationWebElement.sendKeys("roni_cost3@example.com");
    }

    @And("user clicks on button Create")
    public void userClicksOnButtonCreate() {
        createAccountPage.createButtonWebElement.click();
        wait.until(ExpectedConditions.visibilityOf(createAccountPage.userExistingHeadingWebElement));
    }

    @Then("expected error message creating account existing")
    public void expectedErrorMessageCreatingAccountExisting() {
        assertEquals("There is already an account with this email address. " +
                        "If you are sure that it is your email address, click here to get your password and access your account.",
                createAccountPage.userExistingHeadingWebElement.getText());
    }

    @When("user clicks on button Create New Customer Account")
    public void userClicksOnButtonCreateNewCustomerAccount() {
        createAccountPage.createButtonWebElement.click();
    }

    @Then("expected error message creating account with empty fields")
    public void expectedErrorMessageCreatingAccountWithEmptyFields() {
        assertEquals(5, createAccountPage.getRequiredFields().size());
    }

    @When("user adds some {}")
    public void userAddsSome(String text) {
        startPage.searchFieldWebElement.sendKeys(text);
    }

    @When("user clicks button Search")
    public void userClicksButtonSearch() {
        startPage.searchFieldWebElement.submit();
        title = driver.getTitle();
    }

    @Then("expected search result")
    public void expectedSearchResult() {
        assertEquals(driver.getTitle(), "Search results for: 'top'");
        assertEquals("Search results for: 'top'", searchPage.searchHeadingWebElement.getText());
    }


    @When("user goes to Jackets")
    public void userGoesToJackets() {
        wait.until(ExpectedConditions.visibilityOf(startPage.womenButtonWebElement));
        startPage.womenButtonWebElement.click();
        productPage.jacketsButtonWebElement.click();
    }

    @Then("expected web element Jackets on the page")
    public void expectedWebElementJacketsOnThePage() {
        assertEquals("Jackets", productPage.jacketsHeadingWebElement.getText());
    }

    @When("user selects Jackets")
    public void userSelectsJackets() {
        productPage.nadiaElementsShellButtonWebElement.click();
        productPage.sizeButtonWebElement.click();
        productPage.colorButtonWebElement.click();
        price = productPage.productPriceWebElement.getText();
    }

    @And("user adds to the cart")
    public void userAddsToTheCart() {
        productPage.addToTheCartButtonWebElement.click();

    }

    @Then("expected message adding product is present")
    public void expectedMessageAddingProductIsPresent() {
        assertEquals("You added Nadia Elements Shell to your shopping cart.", productPage.addedToTheCartWebElement.getText());
    }

    @When("user clicks on buttons Cart")
    public void userClicksOnButtonsCart() {
        productPage.showCartButtonWebElement.click();
        wait.until(ExpectedConditions.visibilityOf(productPage.productPricePopUpWebElement));
    }

    @Then("expected price matches")
    public void expectedPriceMatches() {
        assertEquals(price, productPage.productPricePopUpWebElement.getText());
    }
}
