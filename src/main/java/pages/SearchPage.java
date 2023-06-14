package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
/**
 * 24-05-2023
 * Class for https://magento.softwaretestingboard.com/catalogsearch/result/?q=top
 */
public class SearchPage extends BasePage {
    public SearchPage(WebDriver driver) {
        super(driver);
    }

    private final String searchHeading = "//h1[@class='page-title']/span";
    @FindBy(xpath = searchHeading)
    public WebElement searchHeadingWebElement;

}
