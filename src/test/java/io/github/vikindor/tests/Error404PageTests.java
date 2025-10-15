package io.github.vikindor.tests;

import io.github.vikindor.pages.Error404Page;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

@DisplayName("Страница 404")
public class Error404PageTests extends TestBase {

    Error404Page error404Page = new Error404Page();

    @Tag("UI") @Tag("Medium") @Tag("Regression")
    @Test
    @DisplayName("Открытие страницы 404 и возврат на главную")
    void shouldDisplayNotFoundPageAndNavigateHome() {
        step("Открыть несуществующую страницу", () -> {
            open("/blablabla");
        });
        step("Убедиться, что открылась страница 404", () -> {
            error404Page.assertOpened();
        });
        step("Проверить возврат на главную страницу", () -> {
            error404Page.goHome();
        });
    }
}
