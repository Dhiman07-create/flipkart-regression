package pages;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$$;

public class SearchResults {

    @Step()
    public void verifyResultsContain(String keyword) {
        $$(".RG5Slk").filterBy(com.codeborne.selenide.Condition.text(keyword)).first().shouldBe(com.codeborne.selenide.Condition.visible);
    }
}