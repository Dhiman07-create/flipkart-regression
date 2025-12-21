package tests;

import base.BaseTest;
import io.qameta.allure.Allure;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

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
        SearchResultsPage results = homePage.search("iPhone 17");
        results.verifyResultsContain("iPhone 17");
    }

    @Test
    public void tc06_verifySearchBarSmartSuggestions() {
        open("https://www.flipkart.com");
        HomePage homePage = new HomePage();
        SearchResultsPage results = homePage.search("iPhon 17");
        results.verifySmartSuggestionAlt();
        results.verifyResultsContain("iPhone 17");
    }

    @Test
    public void tc07_verifySearchFilters() throws InterruptedException {
        open("https://www.flipkart.com");
        HomePage homePage = new HomePage();
        SearchResultsPage results = homePage.search("Laptop");
        results.applyBrandFilter();
        results.verifyBrandFiltered("HP");
        results.applyPriceFilter("₹50000", "₹75000");
        results.verifyPriceRange(50000, 75000);
    }

    @Test
    public void tc08_verifyProductCardsOnPLP() throws InterruptedException {
        open("https://www.flipkart.com/search?q=iphone");
        ProductListingPage plp = new ProductListingPage();
        plp.verifyProductCards();
    }

    @Test
    public void tc09_verifySortByPriceLowToHigh() throws InterruptedException {
        open("https://www.flipkart.com/search?q=laptop");
        ProductListingPage plp = new ProductListingPage();
        plp.sortByPriceLowToHigh();
        plp.verifyProductsSortedLowToHigh();
    }

    @Test
    public void tc10_verifyPaginationNextPageLoadsCorrectly() throws InterruptedException {
        open("https://www.flipkart.com/search?q=mobile");
        ProductListingPage plp = new ProductListingPage();
        int initialProductCount = plp.getProductCount();
        Thread.sleep(3000);
        plp.scrollToPagination();
        plp.clickNextPage();
        plp.verifyNextPageLoaded(initialProductCount);
    }

    @Test
    public void tc11_verifyOutOfStockItemsOnPLP() {
        open("https://www.flipkart.com");
        HomePage homePage = new HomePage();
        SearchResultsPage results = homePage.search("iphone");
        results.verifyOutOfStockItemsVisible();
    }

    @Test
    public void tc12_verifyProductImagesCarousel() throws InterruptedException {
        open("https://www.flipkart.com");
        HomePage homePage = new HomePage();
        SearchResultsPage results = homePage.search("iphone");
        ProductDetailsPage pdp = results.openFirstProduct();
        pdp.verifyImageCarouselLoaded();
        pdp.scrollThroughImages();
        pdp.verifyImageZoom();
    }

    @Test
    public void tc13_verifyProductSpecs() throws InterruptedException {
        open("https://www.flipkart.com");
        HomePage homePage = new HomePage();
        SearchResultsPage results = homePage.search("iPhone 14");
        results.openFirstProduct();
        ProductDetailsPage pdp = new ProductDetailsPage();
        pdp.scrollToSpecifications();
        pdp.verifyProductSpecificationsVisible();
    }

    @Test(description = "Verify Add to Cart from PDP and checkout flow")
    public void tc14_addToCartFromPDPTest() {
        open("https://www.flipkart.com");
        HomePage homePage = new HomePage();
        SearchResultsPage results = homePage.search("iPhone 17 Pro Max");
        results.openFirstProduct();
        ProductDetailsPage pdp = new ProductDetailsPage();
        String expectedTitle = pdp.getProductTitle();
        String expectedPrice = pdp.getProductPrice();
        pdp.clickAddToCart();
        CartPage cart = new CartPage();
        Assert.assertEquals(
                cart.getCartProductTitle(),
                expectedTitle,
                "Incorrect product added to cart"
        );
        Assert.assertTrue(
                cart.getCartProductPrice().contains(expectedPrice),
                "Price mismatch in cart"
        );
        cart.verifyPlaceOrderButton();
        cart.clickPlaceOrder();
        CheckoutPage checkout = new CheckoutPage();
        checkout.verifyCheckoutPage();
    }

    @Test(description = "Buy Now flow")
    public void tc15_buyNowTest() {
        open("https://www.flipkart.com");
        HomePage homePage = new HomePage();
        SearchResultsPage results = homePage.search("iPhone 17 Pro Max");
        results.openFirstProduct();
        ProductDetailsPage pdp = new ProductDetailsPage();
        pdp.clickBuyNow();
        CheckoutPage checkout = new CheckoutPage();
        checkout.verifyCheckoutPage();
    }
}