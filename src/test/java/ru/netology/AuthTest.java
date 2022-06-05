package ru.netology;

import com.codeborne.selenide.Condition;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Locale;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static ru.netology.DataGenerator.getUser;
import static ru.netology.DataGenerator.setUppAll;

class AuthTest {

    @BeforeEach
    void setUp2() {
        open("http://localhost:9999");
    }


    @Test
    void testActiveUser() {
        var regUser = getUser("active");
        setUppAll(regUser);
        $("[data-test-id =\"login\"] input").setValue(regUser.login);
        $("[data-test-id =\"password\"] input").setValue(regUser.password);
        $x("//*[text()=\"Продолжить\"]").click();
        $(byText("Личный кабинет")).should(Condition.visible);
    }

    @Test
    void testActiveUserWhenIncorrectLogin() {
        Faker faker = new Faker(new Locale("en"));
        var regUser = getUser("active");
        setUppAll(regUser);
        $("[data-test-id =\"login\"] input").setValue(faker.name().name());
        $("[data-test-id =\"password\"] input").setValue(regUser.password);
        $x("//*[text()=\"Продолжить\"]").click();
        $(byText("Неверно указан логин или пароль")).should(Condition.visible);
    }

    @Test
    void testActiveUserWhenIncorrectPassword() {
        Faker faker = new Faker(new Locale("en"));
        var regUser = getUser("active");
        setUppAll(regUser);
        $("[data-test-id =\"login\"] input").setValue(regUser.login);
        $("[data-test-id =\"password\"] input").setValue(faker.internet().password());
        $x("//*[text()=\"Продолжить\"]").click();
        $(byText("Неверно указан логин или пароль")).should(Condition.visible);
    }

    @Test
    void testBlockedUser() {
        var regUser = getUser("blocked");
        setUppAll(regUser);
        $("[data-test-id =\"login\"] input").setValue(regUser.login);
        $("[data-test-id =\"password\"] input").setValue(regUser.password);
        $x("//*[text()=\"Продолжить\"]").click();
        $(byText("Пользователь заблокирован")).should(Condition.visible);
    }

    @Test
    void testBlockedUserWhenIncorrectLogin() {
        Faker faker = new Faker(new Locale("en"));
        var regUser = getUser("blocked");
        setUppAll(regUser);
        $("[data-test-id =\"login\"] input").setValue(faker.name().name());
        $("[data-test-id =\"password\"] input").setValue(regUser.password);
        $x("//*[text()=\"Продолжить\"]").click();
        $(byText("Неверно указан логин или пароль")).should(Condition.visible);
    }

    @Test
    void testBlockedUserWhenIncorrectPassword() {
        Faker faker = new Faker(new Locale("en"));
        var regUser = getUser("blocked");
        setUppAll(regUser);
        $("[data-test-id =\"login\"] input").setValue(regUser.login);
        $("[data-test-id =\"password\"] input").setValue(faker.internet().password());
        $x("//*[text()=\"Продолжить\"]").click();
        $(byText("Неверно указан логин или пароль")).should(Condition.visible);
    }
}

