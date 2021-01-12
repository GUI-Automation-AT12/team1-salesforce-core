package org.fundacionjala.core.selenium.browsers.browserClasses;

import static io.github.bonigarcia.wdm.DriverManagerType.FIREFOX;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import org.fundacionjala.core.constans.BrowserConstants;
import org.fundacionjala.core.selenium.browsers.BrowserParser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * [MR] Class of Browser that returns a FirefoxDriver as WebDriver.
 */
public class FirefoxBrowser implements IBrowser {

    /**
     * Initializes Firefox driver.
     */
    @Override
    public WebDriver initDriver() {
        FirefoxDriverManager.getInstance(FIREFOX).version(
                BrowserParser.getBrowsersMap().get(BrowserConstants.BROWSER_MOZILLA).getVersion()).setup();
        return new FirefoxDriver();
    }
}
