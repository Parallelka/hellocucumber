package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

import static utils.PropertiesFactory.getProperty;

public class WebDriverFactory {

    public static WebDriver driver;

    public static WebDriver getDriver(final String nameOfBrowser) {
        if (driver == null) {
            switch (nameOfBrowser.toLowerCase()) {
                case "firefox":
                    System.setProperty("webdriver.gecko.driver", getProperty("path_to_firefoxdriver"));
                    driver = new FirefoxDriver();
                    break;
                case "chrome":
                    System.setProperty("webdriver.chrome.driver", getProperty("path_to_chromedriver"));
                    driver = new ChromeDriver();
                    break;
                default:
                    System.out.println("Can`t create this type of browser");
            }
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(25));
            driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(25));
        }
        return driver;
    }
}
