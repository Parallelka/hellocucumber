package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * 24-05-2023
 * Class for https://magento.softwaretestingboard.com/
 */
public class StartPage extends BasePage {
    public StartPage(WebDriver driver) {
        super(driver);
    }

    private final String shopNewYogaButton = "//*[@class='action more button']";
    @FindBy(xpath = shopNewYogaButton)
    public WebElement shopNewYogaButtonWebElement;

    private final String searchField = "[name='q']";
    @FindBy(css = searchField)
    public WebElement searchFieldWebElement;

    private final String linkCreateAccount = "//div[@class='panel header']//a[text()='Create an Account']";
    @FindBy(xpath = linkCreateAccount)
    public WebElement linkCreateAccountWebElement;

    private final String womenButton = "//span[text()='Women']";
    @FindBy(xpath = womenButton)
    public WebElement womenButtonWebElement;
}
