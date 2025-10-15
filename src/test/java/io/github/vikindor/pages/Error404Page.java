package io.github.vikindor.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class Error404Page {

    private final SelenideElement main = $("main");
    private final SelenideElement title = main.$(byText("Увы, страница не найдена"));
    private final SelenideElement goHomeButton = main.$("a[href='/']");

    public Error404Page assertOpened() {
        title.shouldBe(visible);
        goHomeButton.shouldBe(visible).shouldHave(text("Перейти на главную"));
        return this;
    }

    public void goHome() {
        goHomeButton.click();
    }
}
