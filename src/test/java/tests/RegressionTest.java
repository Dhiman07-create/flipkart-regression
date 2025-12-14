package tests;

import base.BaseTest;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import io.qameta.allure.testng.AllureTestNg;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.SearchResults;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

public class RegressionTest extends BaseTest {

    @Test
    public void tc01_testSearchProduct() {
        open("https://www.flipkart.com");
        HomePage homePage = new HomePage();
        SearchResults results = homePage.search("iPhone 14");
        results.verifyResultsContain("iPhone 14");
    }

    @Test
    public void tc02_validLogin()
    {
        open("https://www.flipkart.com");
        HomePage homePage = new HomePage();
        homePage.clickOnLogin();
        LoginPage loginPage = new LoginPage();
        loginPage.enterEmailOrMobile("dasguptadhiman9@gmail.com");
        loginPage.clickRequestOtp();
        loginPage.verifyOtpScreenDisplayed();
        loginPage.verifyVerifyButtonVisible();
    }

    @Test
    public void tc03inValidLogin()
    {
        open("https://www.flipkart.com");
        HomePage homePage = new HomePage();
        homePage.clickOnLogin();
        LoginPage loginPage = new LoginPage();
        loginPage.enterEmailOrMobile("dokago7765@naqulu.com");
        loginPage.clickRequestOtp();
        loginPage.verifyUnregisteredMessageVisible();
    }

//    @Test
//    public void testSortByPriceLowToHigh() {
//        open("https://www.flipkart.com");
//        HomePage homePage = new HomePage();
//        SearchResults results = homePage.search("laptop");
//
//        // Click on Sort by "Price -- Low to High"
//        $x("//div[contains(text(),'Price -- Low to High')]").click();
//
//        // Verify sorting indicator is visible
//        $x("//div[contains(@class,'_10UF8M') and contains(text(),'Price -- Low to High')]")
//                .shouldBe(visible);
//    }

}