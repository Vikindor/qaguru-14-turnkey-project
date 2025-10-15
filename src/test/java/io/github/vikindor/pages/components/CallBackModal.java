package io.github.vikindor.pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class CallBackModal {

    private final SelenideElement closeButton = $("[class^=Icons_close]");

    public void closeModal() {
        closeButton.shouldBe(visible).click();
    }
}
