package org.fundacionjala.core.selenium;

import org.fundacionjala.core.constans.BrowserConstants;
import org.fundacionjala.core.selenium.browsers.browserClasses.IBrowser;
import org.fundacionjala.core.selenium.browsers.browserClasses.ChromeBrowser;
import org.fundacionjala.core.selenium.browsers.browserClasses.FirefoxBrowser;
import org.fundacionjala.core.selenium.browsers.browserClasses.EdgeBrowser;
import org.fundacionjala.core.selenium.browsers.browserClasses.ChromiumBrowser;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;
import java.util.Map;

/**
 * [MR] Class that returns an specific WebDriver object type defined by application settings
 * from gradle.properties file ("testBrowser" property).
 */
public final class BrowserFactory {

    /**
     * Constructor for the BrowserFactory class.
     */
    private BrowserFactory() {
    }

    private static Map<String, IBrowser> browsersMap = new HashMap<>();
    static {
        browsersMap.put(BrowserConstants.BROWSER_CHROME, new ChromeBrowser());
        browsersMap.put(BrowserConstants.BROWSER_MOZILLA, new FirefoxBrowser());
        browsersMap.put(BrowserConstants.BROWSER_EDGE, new EdgeBrowser());
        browsersMap.put(BrowserConstants.BROWSER_CHROMIUM, new ChromiumBrowser());
    }

    /**
     * Gets a webDriver providing its name.
     * @param browserName name of the browser
     * @return a webDriver
     */
    public static WebDriver getWebDriver(final String browserName) {
            return browsersMap.get(browserName).initDriver();
    }
}
