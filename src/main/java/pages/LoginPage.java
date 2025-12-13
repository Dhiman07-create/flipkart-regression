package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$x;

public class LoginPage {

    private final SelenideElement emailOrMobileInput =
            $x("//input[@type='text' and contains(@class,'r4vIwl')]");

    private final SelenideElement requestOtpButton =
            $x("//button[contains(text(),'Request OTP')]");

    private final SelenideElement otpHeaderText =
            $x("//div[contains(text(),'Please enter the OTP sent to')]");

    private final SelenideElement loginPopupTitle =
            $x("//span[text()='Login']");

    @Step("Verify Login popup is displayed")
    public void verifyLoginPopupVisible() {
        loginPopupTitle.shouldBe(visible);
    }

    @Step("Enter email or mobile number: {value}")
    public void enterEmailOrMobile(String value) {
        emailOrMobileInput.shouldBe(visible).setValue(value);
    }

    @Step("Click Request OTP button")
    public void clickRequestOtp() {
        requestOtpButton.shouldBe(enabled).click();
    }

    @Step("Verify OTP screen is displayed")
    public void verifyOtpScreenDisplayed() {
        otpHeaderText.shouldBe(visible);
    }
}