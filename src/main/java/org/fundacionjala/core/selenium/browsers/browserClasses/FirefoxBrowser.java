package org.fundacionjala.core.selenium.browsers.browserClasses;

import static io.github.bonigarcia.wdm.DriverManagerType.FIREFOX;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import org.fundacionjala.core.constans.BrowserConstants;
import org.fundacionjala.core.selenium.browsers.Browser;
import org.fundacionjala.core.selenium.browsers.BrowserParser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

/**
 * [MR] Class of Browser that returns a FirefoxDriver as WebDriver.
 */
public class FirefoxBrowser implements IBrowser {

    /**
     * Initializes Firefox driver.
     */
    @Override
    public WebDriver initDriver() {
        Browser browser = BrowserParser.getBrowsersMap().get(BrowserConstants.BROWSER_MOZILLA);
        FirefoxDriverManager.getInstance(FIREFOX).version(browser.getVersion()).setup();
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments(browser.getFlags());
        return new FirefoxDriver(options);
    }
}
