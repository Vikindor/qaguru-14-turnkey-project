package io.github.vikindor.pages.components;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.matchText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$$;

public class CategoryCard {

    private final SelenideElement root;
    private final ElementsCollection badges = $$("[class^=Badges_badges]");

    public CategoryCard(SelenideElement root) {
        this.root = root;
    }

    private SelenideElement price() {
        return root.$("[class^=Price_price]");
    }

    public int getPrice() {
        String priceText = price().getText().replaceAll("[^0-9]", "");
        return Integer.parseInt(priceText);
    }

    public CategoryCard shouldHavePrice() {
        price().shouldBe(visible).shouldHave(matchText("\\d+"));
        return this;
    }

    public CategoryCard shouldHaveBadge(String badgeName) {
        badges.filterBy(visible).shouldHave(CollectionCondition.itemWithText(badgeName));
        return this;
    }
}
