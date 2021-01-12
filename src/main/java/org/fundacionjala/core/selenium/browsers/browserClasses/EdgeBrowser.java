package org.fundacionjala.core.selenium.browsers.browserClasses;

import static io.github.bonigarcia.wdm.DriverManagerType.EDGE;
import io.github.bonigarcia.wdm.EdgeDriverManager;
import org.fundacionjala.core.selenium.browsers.BrowserParser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

/**
 * [MR] Class of Browser that returns a EdgeDriver as WebDriver.
 */
public class EdgeBrowser implements IBrowser {

    /**
     * Initializes Edge driver.
     */
    @Override
    public WebDriver initDriver() {
        EdgeDriverManager.getInstance(EDGE).version(
                BrowserParser.getBrowsersMap().get(EDGE.toString()).getVersion()).setup();
        return new EdgeDriver();
    }
}
