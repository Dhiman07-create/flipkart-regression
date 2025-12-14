package tests;

import base.BaseTest;
import io.qameta.allure.Allure;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.SearchResults;

import java.util.NoSuchElementException;

import static com.codeborne.selenide.Selenide.*;

public class RegressionTest extends BaseTest {

    @Test
    public void tc01_validLogin()
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
    public void tc02_inValidLogin()
    {
        open("https://www.flipkart.com");
        HomePage homePage = new HomePage();
        homePage.clickOnLogin();
        LoginPage loginPage = new LoginPage();
        loginPage.enterEmailOrMobile("dokago7765@naqulu.com");
        loginPage.clickRequestOtp();
        loginPage.verifyUnregisteredMessageVisible();
    }

    @Test
    public void tc03_verifyTopNavigationMenus() {
        open("https://www.flipkart.com");
        HomePage homePage = new HomePage();
        homePage.verifyFlipkartMinutesVisible();
        homePage.verifyMobilesAndTabletsVisible();
        homePage.verifyFashionVisible();
        homePage.verifyElectronicsVisible();
        homePage.verifyTvsAndAppliancesVisible();
        homePage.verifyHomeAndFurnitureVisible();
        homePage.verifyFlightBookingsVisible();
        homePage.verifyBeautyFoodVisible();
        homePage.verifyGroceryVisible();
    }

    @Test
    public void tc04_verifyProductCategoryNavigation() {
        open("https://www.flipkart.com");
        HomePage homePage = new HomePage();
        homePage.verifyFlipkartMinutesVisible();
        homePage.verifyFlipkartMinutesLanding();
        back();
        try {
            homePage.closeLoginPopup();
            homePage.hoverOnMobilesAndTablets();
        }
        catch (NoSuchElementException | org.openqa.selenium.WebDriverException | com.codeborne.selenide.ex.ElementNotFound e)
        {
            Allure.step("Login popup not present, continuing test execution");
        }
        homePage.verifyMobilesAndTabletsVisible();
        homePage.verifyMobilesAndTabletsLanding();
        back();
        homePage.verifyElectronicsVisible();
        homePage.hoverOnElectronics();
        homePage.verifyElectronicsLanding();
        back();
    }

    @Test
    public void tc05_verifySearchBarValid() {
        open("https://www.flipkart.com");
        HomePage homePage = new HomePage();
        SearchResults results = homePage.search("iPhone 17");
        results.verifyResultsContain("iPhone 17");
    }

    @Test
    public void tc06_verifySearchBarSmartSuggestions() {
        open("https://www.flipkart.com");
        HomePage homePage = new HomePage();
        SearchResults results = homePage.search("iPhon 17");
        results.verifySmartSuggestionAlt();
        results.verifyResultsContain("iPhone 17");
    }

    @Test
    public void tc07_verifySearchFilters() {
        open("https://www.flipkart.com");
        HomePage homePage = new HomePage();
        SearchResults results = homePage.search("Laptop");
        results.applyBrandFilter();
        results.verifyBrandFiltered("HP");
        results.applyPriceFilter("₹50000", "₹75000");
        results.verifyPriceRange(50000, 75000);
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