package org.fundacionjala.core.selenium.browsers.browserClasses;

import static io.github.bonigarcia.wdm.DriverManagerType.EDGE;
import io.github.bonigarcia.wdm.EdgeDriverManager;
import org.fundacionjala.core.constans.BrowserConstants;
import org.fundacionjala.core.selenium.browsers.Browser;
import org.fundacionjala.core.selenium.browsers.BrowserParser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import java.util.HashMap;

/**
 * [MR] Class of Browser that returns a EdgeDriver as WebDriver.
 */
public class EdgeBrowser implements IBrowser {

    /**
     * Initializes Edge driver.
     */
    @Override
    public WebDriver initDriver() {
        Browser browser = BrowserParser.getBrowsersMap().get(BrowserConstants.BROWSER_EDGE);
        EdgeDriverManager.getInstance(EDGE).version(browser.getVersion()).setup();
        HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
        chromePrefs.put("download.default_directory", System.getProperty("user.dir") + "/src/test/resources/tmp/");
        return new EdgeDriver();
    }
}
