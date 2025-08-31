package pages;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class HomePage {
    public SearchResults search(String query) {
        $("input[name='q']").setValue(query).pressEnter();
        return page(SearchResults.class);
    }
}