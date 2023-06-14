package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * 24-05-2023
 * Class for https://magento.softwaretestingboard.com/collections/yoga-new.html
 */
public class PromoPage extends BasePage {
    public PromoPage(WebDriver driver) {
        super(driver);
    }

    private final String newYogaHeading = "//*[@id='page-title-heading']/span";
    @FindBy(xpath = newYogaHeading)
    public WebElement newYogaHeadingWebElement;

}
