package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class CartPage {

    private final ElementsCollection cartItems =
            $$("div._1AtVbE");

    private final SelenideElement placeOrderButton =
            $x("//span[text()='Place Order']");

    private final SelenideElement cartEmptyText =
            $x("//div[contains(text(),'Your cart is empty')]");

    private final SelenideElement cartProductTitle =
            $x("//div[contains(@class,'PKPqJk')]");

    private final SelenideElement cartProductPrice =
            $x("//span[contains(@class,'qCly9Z')]");

    private final SelenideElement placeOrderBtn =
            $x("//span[contains(text(),'Place Order')]");

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

    public String getCartProductTitle() {
        return cartProductTitle.shouldBe(visible).getText();
    }

    public String getCartProductPrice() {
        return cartProductPrice.shouldBe(visible).getText();
    }

    public void verifyPlaceOrderButton() {
        placeOrderBtn.shouldBe(visible, enabled);
    }
}
