package io.github.vikindor.pages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.github.vikindor.pages.components.CategoryCard;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class CategoryPage {

    private final SelenideElement sortSelector = $("[class^=SelectableList_wrap]");
    private final ElementsCollection sortDropdown = $$("[class^=SelectableList_li_]");
    private final ElementsCollection cards = $$("[class^=Card_wrap]");
    private final String sortingCheap = "Сначала с низкой ценой";
    private final String sortingExpensive = "Сначала дорогие";
    private final String sortingPopular = "Сначала популярные";

    public static final String BADGE_HIT = "Хит продаж";

    public CategoryPage openPage(String category) {
        open("/catalog" + category);
        return this;
    }

    public CategoryCard getCard(int cardNumber) {
        return new CategoryCard(cards.get(cardNumber));
    }

    public CategoryPage sortByPriceAsc() {
        sortSelector.click();
        sortDropdown.findBy(text(sortingCheap)).click();
        cards.shouldHave(CollectionCondition.sizeGreaterThan(0));
        getCard(0).shouldHavePrice();
        return this;
    }

    public CategoryPage sortByPriceDesc() {
        sortSelector.click();
        sortDropdown.findBy(text(sortingExpensive)).click();
        cards.shouldHave(CollectionCondition.sizeGreaterThan(0));
        getCard(0).shouldHavePrice();
        return this;
    }

    public CategoryPage sortByPopular() {
        if (!sortSelector.has(text(sortingPopular))) {
            sortSelector.click();
            sortDropdown.findBy(text(sortingPopular)).click();
            getCard(0).shouldHavePrice();
        }
        return this;
    }
}
