package org.fundacionjala.core.selenium.interaction;

import org.fundacionjala.core.selenium.browsers.Browser;
import org.fundacionjala.core.selenium.browsers.BrowserFactory;
import org.fundacionjala.core.selenium.browsers.BrowserParser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;

/**
 * [MR] Class in charge to mage the WebDriver provided by the BrowserFactory.
 */
public final class WebDriverManager {

    private static WebDriverManager webDriverManager;
    private static String browserName;
    private final WebDriver webDriver;
    private final WebDriverWait webDriverWait;


    /**
     * If webDriverManager object was not created before it create a new one,
     * otherwise return the created.
     * @return webDriverManager
     */
    public static WebDriverManager getInstance() {
        if (webDriverManager == null) {
            webDriverManager = new WebDriverManager();
        }
        return webDriverManager;
    }

    private WebDriverManager() {
        webDriver = BrowserFactory.getWebDriver(browserName);
        Browser browser = BrowserParser.getBrowsersMap().get(browserName);
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().
                implicitlyWait((long)browser.getImplicitWaitingSeconds(), TimeUnit.SECONDS);
        webDriverWait = new WebDriverWait(webDriver, (long)browser.getExplicitWaitingSeconds(),
                (long)browser.getSleepingTimeMills());
    }

    /**
     * Sets the browser to run the tests, providing its name.
     * @param browser name of the browser
     */
    public static void setBrowserName(final String browser) {
        WebDriverManager.browserName = browser;
    }

    /**
     * Return the webDriver of the singleInstance.
     * @return webDriver
     */
    public WebDriver getWebDriver() {
        return webDriver;
    }

    /**
     * Return the webDriverWait of the singleInstance.
     * @return webDriverWait
     */
    public WebDriverWait getWebDriverWait() {
        return webDriverWait;
    }

    /**
     * Quits the webDriver and set webDriverManager single instance as null.
     */
    public void quit() {
        this.webDriver.quit();
        webDriverManager = null;
    }
}
