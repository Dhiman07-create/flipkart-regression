package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.Condition.clickable;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class HomePage {
    private final SelenideElement login =
            $x("//span[text()='Login']");

    private final SelenideElement loginPopupCloseButton =
            $x("//span[text()='✕']");

    private final SelenideElement homePage =
            $x("//a[@title='Flipkart']");

    private final SelenideElement searchBar =
            $x("//input[@name='q']");

    private final SelenideElement flipkartMinutes =
            $x("//span[text()='Minutes']");

    private final SelenideElement mobilesAndTablets =
            $x("//span[text()='Mobiles & Tablets']");

    private final SelenideElement fashion =
            $x("//span[text()='Fashion']");

    private final SelenideElement electronics =
            $x("//span[text()='Electronics']");

    private final SelenideElement tvsAndAppliances =
            $x("//span[text()='TVs & Appliances']");

    private final SelenideElement homeAndFurniture =
            $x("//span[text()='Home & Furniture']");

    private final SelenideElement flightBookings =
            $x("//span[text()='Flight Bookings']");

    private final SelenideElement beautyFood =
            $x("//span[text()='Beauty, Food..']");

    private final SelenideElement grocery =
            $x("//span[text()='Grocery']");

    private final SelenideElement flipkartMinutesHeading =
            $x("//h1[text()='Flipkart Minutes']");

    private final SelenideElement mobilesAndTabletsHeading =
            $x("//h1[text()='Mobile Phones']");

    private final SelenideElement electronicsAll =
            $x("//a[text()='All']");

    private final SelenideElement electronicsHeading =
            $x("//h1[text()='Audio & Video']");

    @Step()
    public SearchResultsPage search(String query) {
        searchBar.setValue(query).pressEnter();
        return page(SearchResultsPage.class);
    }

    @Step("Click on login")
    public void clickOnLogin(){
        login.shouldBe(visible, Duration.ofSeconds(30)).click();
    }

    @Step("Click on login")
    public void clickOnLoginHomePage(){
        homePage.shouldBe(visible, Duration.ofSeconds(30)).click();
    }

    @Step("Click on login popup close button")
    public void closeLoginPopup(){
        loginPopupCloseButton.shouldBe(visible, Duration.ofSeconds(30)).click();
    }

    @Step("Verify Flipkart minutes on HomePage")
    public void verifyFlipkartMinutesVisible(){
        flipkartMinutes.shouldBe(visible, Duration.ofSeconds(30));
        flipkartMinutes.shouldBe(clickable);
    }

    @Step("Verify Flipkart minutes Landing")
    public void verifyFlipkartMinutesLanding(){
        flipkartMinutes.shouldBe(visible, Duration.ofSeconds(30)).click();
        flipkartMinutesHeading.shouldBe(visible, Duration.ofSeconds(10));
    }

    @Step("Verify Mobiles & Tablets on HomePage")
    public void verifyMobilesAndTabletsVisible(){
        mobilesAndTablets.shouldBe(visible, Duration.ofSeconds(30));
        mobilesAndTablets.shouldBe(clickable);
    }

    @Step("Hover on Mobiles & Tablets")
    public void hoverOnMobilesAndTablets(){
        mobilesAndTablets.shouldBe(visible, Duration.ofSeconds(30));
        mobilesAndTablets.hover();
    }

    @Step("Verify Mobiles & Tablets Landing")
    public void verifyMobilesAndTabletsLanding(){
        mobilesAndTablets.shouldBe(visible, Duration.ofSeconds(30)).click();
        mobilesAndTabletsHeading.shouldBe(visible, Duration.ofSeconds(10));
    }

    @Step("Verify Fashion on HomePage")
    public void verifyFashionVisible(){
        fashion.shouldBe(visible, Duration.ofSeconds(30));
        fashion.shouldBe(clickable);
    }

    @Step("Verify Electronics on HomePage")
    public void verifyElectronicsVisible(){
        electronics.shouldBe(visible, Duration.ofSeconds(30));
        electronics.shouldBe(clickable);
    }

    @Step("Hover on Electronics")
    public void hoverOnElectronics(){
        electronics.shouldBe(visible, Duration.ofSeconds(30));
        electronics.hover();
    }

    @Step("Verify Electronics Landing")
    public void verifyElectronicsLanding(){
        electronicsAll.shouldBe(visible, Duration.ofSeconds(30)).click();
        electronicsHeading.shouldBe(visible, Duration.ofSeconds(10));
    }

    @Step("Verify TVs & Appliances on HomePage")
    public void verifyTvsAndAppliancesVisible(){
        tvsAndAppliances.shouldBe(visible, Duration.ofSeconds(30));
        tvsAndAppliances.shouldBe(clickable);
    }

    @Step("Verify Home & Furniture on HomePage")
    public void verifyHomeAndFurnitureVisible(){
        homeAndFurniture.shouldBe(visible, Duration.ofSeconds(30));
        homeAndFurniture.shouldBe(clickable);
    }

    @Step("Verify Flight Bookings on HomePage")
    public void verifyFlightBookingsVisible(){
        flightBookings.shouldBe(visible, Duration.ofSeconds(30));
        flightBookings.shouldBe(clickable);
    }

    @Step("Verify Beauty, Food.. on HomePage")
    public void verifyBeautyFoodVisible(){
        beautyFood.shouldBe(visible, Duration.ofSeconds(30));
        beautyFood.shouldBe(clickable);
    }

    @Step("Verify Grocery on HomePage")
    public void verifyGroceryVisible(){
        grocery.shouldBe(visible, Duration.ofSeconds(30));
        grocery.shouldBe(clickable);
    }

    @Step("Open first product from search results")
    public ProductDetailsPage openFirstProduct() {
        $x("(//div[@data-id])[1]").shouldBe(visible).click();
        return new ProductDetailsPage();
    }

    public void clickRandomPoint() {
        executeJavaScript(
                "var x = 500;" +
                        "var y = 500;" +
                        "document.elementFromPoint(x, y)?.click();"
        );
        System.out.println("Clicked Outside");
    }
}