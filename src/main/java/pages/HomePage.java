package pages;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class HomePage {

    @Step()
    public SearchResults search(String query) {
        $("input[name='q']").setValue(query).pressEnter();
        return page(SearchResults.class);
    }

    @Step("Open first product from search results")
    public ProductPage openFirstProduct() {
        $x("(//div[@data-id])[1]").shouldBe(visible).click();
        return new ProductPage();
    }
}