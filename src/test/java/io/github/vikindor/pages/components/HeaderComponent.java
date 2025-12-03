package io.github.vikindor.pages.components;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class HeaderComponent {

    private final SelenideElement header = $("header[class^=Header_wrap]");
    private final ElementsCollection phones = header.$$("a[href^='tel:']");
    private final SelenideElement searchInput = $("#searchInput");
    private final SelenideElement searchSuggestions = $("[class^=Search_bottom]");
    private final SelenideElement popularItems = searchSuggestions.$("[class^=Search_popularCards]");

    public HeaderComponent shouldHavePhone(String phoneNumber) {
        phones.findBy(attribute("href", "tel:" + phoneNumber)).shouldBe(visible);
        return this;
    }

    public HeaderComponent searchFor(String query) {
        searchInput.val(query);
        return this;
    }

    public HeaderComponent shouldSuggest(String suggested) {
        popularItems.shouldHave(text(suggested));
        return this;
    }
}
