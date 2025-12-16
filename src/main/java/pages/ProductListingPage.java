package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.CollectionCondition.sizeGreaterThanOrEqual;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class ProductListingPage {

    // Product cards
    private final ElementsCollection productCards =
            $$x("//div[@data-id]");

    // Inside each card
    private final String productNameXpath = ".//div[contains(@class,'RG5Slk')]";
    private final String productPriceXpath = ".//div[contains(@class,'hZ3P6w DeU9vF')]";
    private final String productRatingXpath = ".//div[contains(@class,'MKiFS6')]";
    private final String productImageXpath = ".//img";

    private final SelenideElement sortLowToHigh =
            $x("//div[text()='Price -- Low to High']");
    private final ElementsCollection productPrices =
            $$x("//div[@data-id]//div[contains(@class,'hZ3P6w DeU9vF')]");

    private final SelenideElement nextPageButton =
            $x("//span[text()='Next']");

    @Step("Verify product cards contain name, price, rating and image")
    public void verifyProductCards() throws InterruptedException {
        Thread.sleep(3000);
        // Ensure PLP loaded
        productCards.filter(visible).shouldHave(sizeGreaterThan(0));
        for (SelenideElement card : productCards) {
            card.scrollIntoView(true);
            card.$x(productNameXpath)
                    .shouldBe(visible)
                    .shouldNotBe(empty);
            card.$x(productPriceXpath)
                    .shouldBe(visible)
                    .shouldNotBe(empty);
            // Rating may not be present for all products → soft check
            card.$x(productRatingXpath)
                    .should(exist);
            card.$x(productImageXpath)
                    .shouldBe(visible)
                    .shouldHave(attributeMatching("src", ".+"));
        }
    }

    @Step("Select sort option: Price Low to High")
    public void sortByPriceLowToHigh() throws InterruptedException {
        sortLowToHigh
                .shouldBe(visible)
                .click();

        // Wait for sorting to apply
        Thread.sleep(2000);
        productPrices.filter(visible).shouldHave(sizeGreaterThan(0));
        productPrices.shouldHave(sizeGreaterThan(0));
    }

    @Step("Verify products are sorted by price from low to high")
    public void verifyProductsSortedLowToHigh() {

        // Always re-fetch to avoid stale elements
        List<Integer> actualPrices = new ArrayList<>();

        for (SelenideElement price : productPrices.filter(visible)) {

            String amount = price.getText()
                    .replace("₹", "")
                    .replace(",", "")
                    .trim();

            actualPrices.add(Integer.parseInt(amount));
        }

        // Copy & sort
        List<Integer> sortedPrices = new ArrayList<>(actualPrices);
        Collections.sort(sortedPrices);

        // Assertion
        assert actualPrices.equals(sortedPrices)
                : "Products are NOT sorted Low → High\nActual: "
                + actualPrices + "\nExpected: " + sortedPrices;
    }

    @Step("Scroll to pagination section")
    public void scrollToPagination() {
        nextPageButton
                .shouldBe(visible);
    }

    @Step("Click on Next page button")
    public void clickNextPage() {
        nextPageButton.shouldBe(visible, enabled)
                .shouldBe(visible)
                .scrollIntoView(true);
    }

    @Step("Verify next page products are loaded")
    public void verifyNextPageLoaded(int previousCount) {
        productCards
                .shouldHave(sizeGreaterThanOrEqual(previousCount));
        productCards.first().shouldBe(visible);
    }

    @Step("Get current product count")
    public int getProductCount() {
        productCards.shouldHave(sizeGreaterThan(0));
        return productCards.size();
    }
}