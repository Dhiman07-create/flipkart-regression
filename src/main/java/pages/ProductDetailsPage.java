package pages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class ProductDetailsPage {

    private final SelenideElement productTitle =
            $x("//span[contains(@class,'VU-ZEz')]");

    private final SelenideElement addToCartButton =
            $x("//button[.//span[text()='Add to cart']]");

    private final SelenideElement addToWishlistButton =
            $x("//span[contains(text(),'Wishlist')]");

    // Main product image
    private final SelenideElement mainImage =
            $x("//img[contains(@class,'UCc1lI xD43kG GgrFN0')]");

    // Thumbnail images carousel
    private final ElementsCollection imageThumbnails =
            $$x("//li[contains(@class,'gEHBBa bJvKyM')]//img");

    // Zoom container (appears on hover)
    private final SelenideElement zoomContainer =
            $x("//div[contains(@class,'b_h3mK pMOtCI') or contains(@class,'pMOtCI')]");

    // "Specifications" section header
    private final SelenideElement specificationsHeader =
            $x("//div[contains(text(),'Specifications')]");

    // All specification rows
    private final ElementsCollection specificationRows =
            $$x("//div[contains(@class,'H0UCo8')]//tr");

    private final SelenideElement readMore =
            $x("//button[contains(text(),'Read More')]");

    @Step("Scroll to product specifications section")
    public void scrollToSpecifications() {
        specificationsHeader.scrollIntoView(true)
                .shouldBe(visible);
    }

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

    @Step("Verify product image carousel is loaded")
    public void verifyImageCarouselLoaded() {
        mainImage.shouldBe(visible);
        imageThumbnails.shouldHave(sizeGreaterThan(0));
    }

    @Step("Verify zoom functionality on product image")
    public void verifyImageZoom() {
        mainImage.hover();
        zoomContainer.shouldBe(visible, Duration.ofSeconds(10));
    }

    @Step("Scroll through product images")
    public void scrollThroughImages() throws InterruptedException {
        Thread.sleep(2000);
        imageThumbnails
                .filter(visible)
                .shouldHave(sizeGreaterThan(0));
        for (SelenideElement thumbnail : imageThumbnails) {
            thumbnail.scrollIntoView(true)
                    .shouldBe(visible);
            executeJavaScript("arguments[0].click();", thumbnail);
            mainImage.shouldBe(visible);
        }
    }

    @Step("Verify all product specifications are visible")
    public void verifyProductSpecificationsVisible() throws InterruptedException {
        readMore.click();
        Thread.sleep(3000);
        specificationRows
                .filter(visible)
                .shouldHave(sizeGreaterThan(0));
        for (SelenideElement spec : specificationRows) {
            spec.shouldBe(visible);
        }
    }
}