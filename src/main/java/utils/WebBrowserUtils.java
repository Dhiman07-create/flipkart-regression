package utils;

import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.Dimension;

import static com.codeborne.selenide.Selenide.switchTo;
import static com.codeborne.selenide.Selenide.webdriver;

public class WebBrowserUtils {

    public static void switchToLastTab() {
        switchToLastTabDoNotResize();
        webdriver().driver().getWebDriver().manage().window().setSize(new Dimension(1920, 1888));
    }

    public static void switchToLastTabDoNotResize() {
        var windowHandles = WebDriverRunner.getWebDriver().getWindowHandles();
        var lastWindow = windowHandles.toArray()[windowHandles.size() - 1].toString();
        WebDriverRunner.getWebDriver().switchTo().window(lastWindow);
    }

    public static void switchToFirstTab() {
        switchTo().window( 0);
    }

}
