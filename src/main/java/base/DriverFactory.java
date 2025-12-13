package base;

import com.codeborne.selenide.Configuration;

public class DriverFactory {
    public static void setupDriver() {
        Configuration.browser = "chrome";
        Configuration.headless = false;
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 8000;
    }
}