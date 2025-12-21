package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class CheckoutPage {
    private final SelenideElement loginHeader =
            $x("//span[contains(text(),'Login or Signup')]");

    private final SelenideElement deliveryAddressHeader =
            $x("//span[contains(text(),'Delivery Address')]");

    private final SelenideElement orderSummaryHeader =
            $x("//span[contains(text(),'Order Summary')]");

    private final SelenideElement paymentOptionsHeader =
            $x("//span[contains(text(),'Payment Options')]");

    @Step("Verify Checkout page headers like login, oder summary etc..")
    public void verifyCheckoutPage() {
        loginHeader.shouldBe(visible)
                .shouldHave(text("Login"));

        deliveryAddressHeader
                .shouldHave(text("Delivery Address"));

        orderSummaryHeader
                .shouldHave(text("Order Summary"));

        paymentOptionsHeader
                .shouldHave(text("Payment Options"));
    }
}
