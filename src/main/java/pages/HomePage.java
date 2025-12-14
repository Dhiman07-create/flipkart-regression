package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class HomePage {
    private final SelenideElement login =
            $x("//span[text()='Login']");

    private final SelenideElement searchBar =
            $x("//input[@name='q']");

    @Step()
    public SearchResults search(String query) {
        searchBar.setValue(query).pressEnter();
        return page(SearchResults.class);
    }

    @Step("Click on login")
    public void clickOnLogin(){
        login.shouldBe(visible, Duration.ofSeconds(30)).click();
    }

    @Step("Open first product from search results")
    public ProductPage openFirstProduct() {
        $x("(//div[@data-id])[1]").shouldBe(visible).click();
        return new ProductPage();
    }
}