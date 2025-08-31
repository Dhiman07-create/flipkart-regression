package pages;

import static com.codeborne.selenide.Selenide.$$;

public class SearchResults {
    public void verifyResultsContain(String keyword) {
        $$(".KzDlHZ").filterBy(com.codeborne.selenide.Condition.text(keyword)).first().shouldBe(com.codeborne.selenide.Condition.visible);
    }
}