package io.github.vikindor.tests;

import io.github.vikindor.pages.CategoryPage;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.github.vikindor.pages.CategoryPage.BADGE_HIT;
import static io.qameta.allure.Allure.step;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Epic("Категория товаров")
@DisplayName("Категория товаров")
public class CategoryPageTests extends TestBase {

    CategoryPage categoryPage = new CategoryPage();
    String category = "/1001/processory";

    @Test
    @Feature("Сортировка")
    @DisplayName("Сортировка товаров по цене по возрастанию")
    @Tag("UI") @Tag("Critical") @Tag("Smoke") @Tag("Sanity") @Tag("Regression")
    void shouldCheckSortByPriceAscendingTest() {

        step("Открыть страницу категории товаров", () -> {
            categoryPage.openPage(category);
        });
        step("Отсортировать по популярности", () -> {
            categoryPage.sortByPriceAsc();
        });
        step("Проверить, что цена меньше указанного значения", () -> {
            int price = categoryPage.getCard(0).getPrice();
            assertTrue(price <= 5000);
        });
    }

    @Test
    @Feature("Сортировка")
    @DisplayName("Сортировка товаров по цене по убыванию")
    @Tag("UI") @Tag("Critical") @Tag("Smoke") @Tag("Sanity") @Tag("Regression")
    void shouldCheckSortByPriceDescendingTest() {

        step("Открыть страницу категории товаров", () -> {
            categoryPage.openPage(category);
        });
        step("Отсортировать по популярности", () -> {
            categoryPage.sortByPriceDesc();
        });
        step("Проверить, что цена больше указанного значения", () -> {
            int price = categoryPage.getCard(0).getPrice();
            assertTrue(price >= 50000);
        });
    }

    @Test
    @Feature("Сортировка")
    @DisplayName("Сортировка товаров по популярности")
    @Tag("UI") @Tag("High") @Tag("Smoke") @Tag("Sanity") @Tag("Regression")
    void shouldCheckSortByPopularTest() {

        step("Открыть страницу категории товаров", () -> {
            categoryPage.openPage(category);
        });
        step("Отсортировать по популярности", () -> {
            categoryPage.sortByPopular();
        });
        step("Проверить наличие лейбла 'Хит продаж'", () -> {
            categoryPage.getCard(0).shouldHaveBadge(BADGE_HIT);
        });
    }
}
