package helpers;

import org.openqa.selenium.WebDriver;

import static utils.PropertiesFactory.getProperty;

public class WebFormHelper extends BaseHelper {
    public WebFormHelper(WebDriver driver) {
        super(driver);
    }

    /**
     * This method opens url from web_form_url property
     */
    public void openStartPage() {
        driver.get(getProperty("web_form_url"));
    }
}
