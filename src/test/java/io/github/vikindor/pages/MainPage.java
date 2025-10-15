package io.github.vikindor.pages;

import static com.codeborne.selenide.Selenide.open;

public class MainPage {

    public MainPage openPage() {
        open("/");
        return this;
    }
}
