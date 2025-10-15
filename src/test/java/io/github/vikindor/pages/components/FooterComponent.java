package io.github.vikindor.pages.components;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class FooterComponent {

    private final SelenideElement footer = $("footer[class^=Footer_wrap]");
    private final ElementsCollection phoneLink = footer.$$("[href*='tel']");
    private final SelenideElement callBackButton = footer.$("button[class^=Button]");

    public FooterComponent shouldHavePhone(String phoneNumber) {
        phoneLink.findBy(text(phoneNumber)).shouldBe(visible);
        return this;
    }

    public void clickCallBackButton() {
        callBackButton.shouldBe(visible).click();
    }
}
