package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * 24-05-2023
 * Class for https://magento.softwaretestingboard.com/customer/account/create/
 */
public class CreateAccountPage extends BasePage {
    public CreateAccountPage(WebDriver driver) {
        super(driver);
    }

    private final String createAccountHeading = "//span[text()='Create New Customer Account']";
    @FindBy(xpath = createAccountHeading)
    public WebElement createAccountHeadingWebElement;

    private final String requiredField = "//div[text()='This is a required field.']";

    public List<WebElement> getRequiredFields() {
        return driver.findElements(By.xpath(requiredField));
    }

    private final String createButton = "//button[@title='Create an Account']";

    @FindBy(xpath = createButton)
    public WebElement createButtonWebElement;

    private final String firstnameField = "//input[@id='firstname']";
    @FindBy(xpath = firstnameField)
    public WebElement firstnameFieldWebElement;

    private final String lastnameField = "//input[@id='lastname']";
    @FindBy(xpath = lastnameField)
    public WebElement lastnameFieldWebElement;

    private final String emailAddressField = "//input[@id='email_address']";
    @FindBy(xpath = emailAddressField)
    public WebElement emailAddressFieldWebElement;

    private final String passwordField = "//input[@id='password']";
    @FindBy(xpath = passwordField)
    public WebElement passwordFieldWebElement;

    private final String passwordConfirmationField = "//input[@id='password-confirmation']";
    @FindBy(xpath = passwordConfirmationField)
    public WebElement passwordConfirmationWebElement;

    private final String userExistingHeading = "//div[contains(text(),'There is already an account with this email address.')]";
    @FindBy(xpath = userExistingHeading)
    public WebElement userExistingHeadingWebElement;
}
