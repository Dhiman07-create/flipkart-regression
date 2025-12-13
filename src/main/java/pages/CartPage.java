package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.$x;

public class CartPage {

    private final ElementsCollection cartItems =
            $$("div._1AtVbE");

    private final SelenideElement placeOrderButton =
            $x("//span[text()='Place Order']");

    private final SelenideElement cartEmptyText =
            $x("//div[contains(text(),'Your cart is empty')]");

    @Step("Verify product is added to cart")
    public void verifyProductAddedToCart() {
        cartItems.shouldHave(sizeGreaterThan(0));
    }

    @Step("Click Place Order button")
    public void clickPlaceOrder() {
        placeOrderButton.shouldBe(enabled).click();
    }

    @Step("Verify cart empty message is shown")
    public void verifyCartIsEmpty() {
        cartEmptyText.shouldBe(visible);
    }
}
