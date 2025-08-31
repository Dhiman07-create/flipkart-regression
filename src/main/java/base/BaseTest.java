package base;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class BaseTest {
    @BeforeMethod
    public void setUp() {
        DriverFactory.setupDriver();
    }

    @AfterMethod
    public void tearDown() {
        // Selenide auto handles closing browser
    }
}