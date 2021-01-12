package org.fundacionjala.core.selenium;

import static io.github.bonigarcia.wdm.DriverManagerType.CHROME;
import static io.github.bonigarcia.wdm.DriverManagerType.FIREFOX;
import static io.github.bonigarcia.wdm.DriverManagerType.EDGE;
import org.fundacionjala.core.selenium.browsers.browserClasses.ChromeBrowser;
import org.fundacionjala.core.selenium.browsers.browserClasses.EdgeBrowser;
import org.fundacionjala.core.selenium.browsers.browserClasses.FirefoxBrowser;
import org.fundacionjala.core.selenium.browsers.browserClasses.IBrowser;
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
        browsersMap.put(CHROME.toString(), new ChromeBrowser());
        browsersMap.put(FIREFOX.toString(), new FirefoxBrowser());
        browsersMap.put(EDGE.toString(), new EdgeBrowser());
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
