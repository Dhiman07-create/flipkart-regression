package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class SearchResults {

    private final SelenideElement smartSuggestion =
            $x("//span[contains(text(),'Show results for')]//a");

    private final SelenideElement brandDropdown =
            $x("//div[text()='Brand']");

    private final SelenideElement brandResultExpand =
            $x("(//div[@class='GN2Hca rQQNAD'])[1]");

    private final SelenideElement brandFilterHP =
            $x("//div[text()='HP']/preceding-sibling::div");

    private final SelenideElement minPriceDropdown =
            $x("//select[@class='hbnjE2']");

    private final SelenideElement maxPriceDropdown =
            $x("(//select[@class='hbnjE2'])[2]");

    private final ElementsCollection productTitles =
            $$x("//div[@class='RG5Slk']");

    private final ElementsCollection productPrices =
            $$x("//div[@class='hZ3P6w DeU9vF']");

    @Step()
    public void verifyResultsContain(String keyword) {
        $$(".RG5Slk").filterBy(text(keyword)).first().shouldBe(visible);
    }

    @Step()
    public void verifySmartSuggestionAlt() {
        smartSuggestion.shouldBe(visible);
    }

    @Step("Apply brand filter: HP")
    public void applyBrandFilter() {
        brandDropdown.shouldBe(visible).click();
        brandResultExpand.shouldBe(visible).click();
        brandFilterHP.shouldBe(visible).click();
        sleep(3000); // wait for filter to apply
    }

    @Step("Apply price filter from {min} to {max}")
    public void applyPriceFilter(String min, String max) {
        minPriceDropdown.selectOption(min);
        sleep(2000);
        maxPriceDropdown.selectOption(max);
    }

    @Step("Verify products belong to selected brand")
    public void verifyBrandFiltered(String brand) {
        productTitles.shouldBe(sizeGreaterThan(0));
        for (SelenideElement title : productTitles) {
            title.shouldHave(text(brand));
        }
    }

    @Step("Verify products are within selected price range")
    public void verifyPriceRange(int min, int max) {
        for (SelenideElement price : productPrices) {
            String amount = price.getText()
                    .replace("₹", "")
                    .replace(",", "")
                    .trim();

            int value = Integer.parseInt(amount);
            assert value >= min && value <= max :
                    "Price out of range: " + value;
        }
    }
}