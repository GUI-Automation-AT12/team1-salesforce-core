package org.fundacionjala.core.selenium.browsers;

import java.util.List;

/**
 * [MR] Class that store different types of browsers supported by the framework,
 * with their basic configuration data.
 */
public class Browser {
    private String name;
    private String version;
    private double implicitWaitingSeconds;
    private double explicitWaitingSeconds;
    private double sleepingTimeMills;
    private List<String> flags;

    /**
     * Get browser's name.
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Get browser's version.
     * @return version
     */
    public String getVersion() {
        return version;
    }

    /**
     * Get browser's implicitWaitingSeconds.
     * @return implicitWaitingSeconds
     */
    public double getImplicitWaitingSeconds() {
        return implicitWaitingSeconds;
    }

    /**
     * Get browser's explicitWaitingSeconds.
     * @return explicitWaitingSeconds
     */
    public double getExplicitWaitingSeconds() {
        return explicitWaitingSeconds;
    }

    /**
     * Get browser's sleepingTimeMills.
     * @return sleepingTimeMills
     */
    public double getSleepingTimeMills() {
        return sleepingTimeMills;
    }

    /**
     * Get browser's flags.
     * @return flags list
     */
    public List<String> getFlags() {
        return flags;
    }
}
