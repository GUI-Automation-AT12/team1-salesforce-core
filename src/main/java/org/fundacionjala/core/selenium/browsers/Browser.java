package org.fundacionjala.core.selenium.browsers;

/**
 * [MR] Class that store different types of browsers supported by the framework,
 * with their basic configuration data.
 */
public class Browser {
    private String name;
    private String version;
    private String implicitWaitingSeconds;
    private String explicitWaitingSeconds;
    private String sleepingTimeMills;

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
    public String getImplicitWaitingSeconds() {
        return implicitWaitingSeconds;
    }

    /**
     * Get browser's explicitWaitingSeconds.
     * @return explicitWaitingSeconds
     */
    public String getExplicitWaitingSeconds() {
        return explicitWaitingSeconds;
    }

    /**
     * Get browser's sleepingTimeMills.
     * @return sleepingTimeMills
     */
    public String getSleepingTimeMills() {
        return sleepingTimeMills;
    }
}
