package io.github.vikindor.tests;

import io.github.vikindor.pages.MainPage;
import io.github.vikindor.pages.components.CallBackModal;
import io.github.vikindor.pages.components.FooterComponent;
import io.github.vikindor.pages.components.HeaderComponent;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static io.github.vikindor.data.ContactsData.*;
import static io.qameta.allure.Allure.step;

@Epic("Главная страница")
@DisplayName("Главная страница")
public class MainPageTests extends TestBase {

    MainPage mainPage = new MainPage();
    HeaderComponent header = new HeaderComponent();
    FooterComponent footer = new FooterComponent();
    CallBackModal modal = new CallBackModal();

    @Tag("UI") @Tag("Critical") @Tag("Sanity") @Tag("Regression")
    @Test
    @Feature("Контакты")
    @DisplayName("Проверка отображения номеров телефонов и ФОС")
    void shouldCheckContactsTest() {
        step("Открыть главную страницу", () -> {
            mainPage.openPage();
        });
        step("Проверить телефоны в хедере", () -> {
            header.shouldHavePhone(russiaPhone).shouldHavePhone(moscowPhone);
        });

        step("Проверить телефоны в футере", () -> {
            footer.shouldHavePhone(russiaPhone).shouldHavePhone(moscowPhone);
        });
        step("Проверить открытие и закрытие ФОС", () -> {
            footer.clickCallBackButton();
            modal.closeModal();
        });
    }

    @Tag("UI") @Tag("High") @Tag("Regression")
    @Feature("Поиск")
    @DisplayName("Быстрый поиск показывает популярные товары")
    @ParameterizedTest(name = "Итерация {index}: ищет {0} ожидает {1}")
    @CsvSource({
            "айфон,Apple iPhone",
            "интел,Intel Core",
            "видеокарты,NVIDIA GeForce RTX"
    })
    void shouldCheckPopularSuggestionsTest(String query, String suggested) {
        step("Открыть главную страницу", () -> {
            mainPage.openPage();
        });
        step("Ввести поисковой запрос", () -> {
            header.searchFor(query);
        });
        step("Проверить, что предлагаются ожидаемые товары", () -> {
            header.shouldSuggest(suggested);
        });
    }
}
