package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$x;

public class ProductPage {

    private final SelenideElement productTitle =
            $x("//span[contains(@class,'VU-ZEz')]");

    private final SelenideElement addToCartButton =
            $x("//button[.//span[text()='Add to cart']]");

    private final SelenideElement addToWishlistButton =
            $x("//span[contains(text(),'Wishlist')]");

    @Step("Verify product title is displayed")
    public void verifyProductTitleVisible() {
        productTitle.shouldBe(visible);
    }

    @Step("Get product title")
    public String getProductTitle() {
        return productTitle.shouldBe(visible).getText();
    }

    @Step("Add product to cart")
    public void addToCart() {
        addToCartButton.shouldBe(enabled).click();
    }

    @Step("Click Add to Wishlist")
    public void addToWishlist() {
        addToWishlistButton.shouldBe(visible).click();
    }
}