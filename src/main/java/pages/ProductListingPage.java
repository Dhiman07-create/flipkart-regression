package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$$x;

public class ProductListingPage {

    // Product cards
    private final ElementsCollection productCards =
            $$x("//div[@data-id]");

    // Inside each card
    private final String productNameXpath = ".//div[contains(@class,'RG5Slk')]";
    private final String productPriceXpath = ".//div[contains(@class,'hZ3P6w DeU9vF')]";
    private final String productRatingXpath = ".//div[contains(@class,'MKiFS6')]";
    private final String productImageXpath = ".//img";

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
}