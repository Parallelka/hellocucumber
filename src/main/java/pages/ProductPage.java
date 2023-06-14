package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
/**
 * 24-05-2023
 * Class for https://magento.softwaretestingboard.com/women/tops-women/jackets-women.html
 */
public class ProductPage extends BasePage{
    public ProductPage(WebDriver driver) {
        super(driver);
    }

    private final String jacketsButton = "//a[text()='Jackets']";
    @FindBy(xpath = jacketsButton)
    public WebElement jacketsButtonWebElement;

    private final String jacketsHeading = "//span[@class='base']";
    @FindBy(xpath = jacketsHeading)
    public WebElement jacketsHeadingWebElement;

    private final String nadiaElementsShellButton = "(//a[contains(text(), 'Nadia Elements Shell')])[1]";
    @FindBy(xpath = nadiaElementsShellButton)
    public WebElement nadiaElementsShellButtonWebElement;

    private final String sizeButton = "//div[@option-label='XS']";
    @FindBy(xpath = sizeButton)
    public WebElement sizeButtonWebElement;

    private final String colorButton = "//div[@option-label='Black']";
    @FindBy(xpath = colorButton)
    public WebElement colorButtonWebElement;

    private final String addToTheCartButton = "//button[@title='Add to Cart']";
    @FindBy(xpath = addToTheCartButton)
    public WebElement addToTheCartButtonWebElement;

    private final String productPrice = "//*[@id='product-price-1348']/span";
    @FindBy(xpath = productPrice)
    public WebElement productPriceWebElement;

    private final String addedToTheCartHeading = "//div[contains(text(), 'You added')]";
    @FindBy(xpath = addedToTheCartHeading)
    public WebElement addedToTheCartWebElement;

    private final String showCartButton = "//a[@class='action showcart']";
    @FindBy(xpath = showCartButton)
    public WebElement showCartButtonWebElement;

    private final String productPricePopUp = "//div[@class='amount price-container']//span[@class='price']";
    @FindBy(xpath = productPricePopUp)
    public WebElement productPricePopUpWebElement;

}

