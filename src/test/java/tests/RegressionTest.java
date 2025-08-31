package tests;

import base.BaseTest;
import io.qameta.allure.Allure;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.testng.AllureTestNg;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.SearchResults;

import static com.codeborne.selenide.Selenide.open;

public class RegressionTest extends BaseTest {

    @Test
    public void testSearchProduct() {
        open("https://www.flipkart.com");
        HomePage homePage = new HomePage();
        SearchResults results = homePage.search("iPhone 14");
        results.verifyResultsContain("iPhone 14");
    }
}