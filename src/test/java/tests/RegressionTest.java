package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.SearchResults;

import static com.codeborne.selenide.Selenide.open;

public class RegressionTest extends BaseTest {
    @Test(description = "Verify product search")
    public void testSearchProduct() {
        open("https://www.flipkart.com");
        HomePage homePage = new HomePage();
        SearchResults results = homePage.search("iPhone 14");
        results.verifyResultsContain("iPhone 14");
    }
}