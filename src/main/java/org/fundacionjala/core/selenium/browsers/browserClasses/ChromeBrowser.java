package org.fundacionjala.core.selenium.browsers.browserClasses;

import static io.github.bonigarcia.wdm.DriverManagerType.CHROME;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.fundacionjala.core.constans.BrowserConstants;
import org.fundacionjala.core.selenium.browsers.Browser;
import org.fundacionjala.core.selenium.browsers.BrowserParser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;

/**
 * [MR] Class of Browser that returns a ChromeDriver as WebDriver.
 */
public class ChromeBrowser implements IBrowser {

    /**
     * Initializes Chrome driver.
     */
    @Override
    public WebDriver initDriver() {
        Browser browser = BrowserParser.getBrowsersMap().get(BrowserConstants.BROWSER_CHROME);
        ChromeDriverManager.getInstance(CHROME).version(browser.getVersion()).setup();
        HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
        chromePrefs.put("download.default_directory", System.getProperty("user.dir") + "/src/test/resources/tmp/");
        ChromeOptions options = new ChromeOptions();
        options.addArguments(browser.getFlags());
        options.setExperimentalOption("prefs", chromePrefs);
        return new ChromeDriver(options);
    }
}
