package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$x;

public class LoginPage {

    private final SelenideElement emailOrMobileInput =
            $x("//input[@type='text' and contains(@class,'c3Bd2c')]");

    private final SelenideElement requestOtpButton =
            $x("//button[contains(text(),'Request OTP')]");

    private final SelenideElement otpHeaderText =
            $x("//div[contains(text(),'Please enter the OTP sent to')]");

    private final SelenideElement loginPopupTitle =
            $x("//span[text()='Login']");

    private final SelenideElement verifyButton =
            $x("//button[contains(text(),'Verify')]");

    private final SelenideElement unregisteredMessage =
            $x("//div[contains(text(),'You are not registered with us. Please sign up.')]");

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

    @Step("Verify verify button is displayed")
    public void verifyVerifyButtonVisible() {
        verifyButton.shouldBe(visible);
    }

    @Step("Verify unregistered message is displayed")
    public void verifyUnregisteredMessageVisible() {
        unregisteredMessage.shouldBe(visible, Duration.ofSeconds(10));
    }

}