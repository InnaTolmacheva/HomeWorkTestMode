package ru.netology;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
        var regUser = getUser("active");
        var regOtherUser = getUser("active");
        setUppAll(regUser);
        $("[data-test-id =\"login\"] input").setValue(regOtherUser.login);
        $("[data-test-id =\"password\"] input").setValue(regUser.password);
        $x("//*[text()=\"Продолжить\"]").click();
        $(byText("Неверно указан логин или пароль")).should(Condition.visible);
    }

    @Test
    void testActiveUserWhenIncorrectPassword() {
        var regUser = getUser("active");
        var regOtherUser = getUser("active");
        setUppAll(regUser);
        $("[data-test-id =\"login\"] input").setValue(regUser.login);
        $("[data-test-id =\"password\"] input").setValue(regOtherUser.password);
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
        var regUser = getUser("blocked");
        var regOtherUser = getUser("blocked");
        setUppAll(regUser);
        $("[data-test-id =\"login\"] input").setValue(regOtherUser.login);
        $("[data-test-id =\"password\"] input").setValue(regUser.password);
        $x("//*[text()=\"Продолжить\"]").click();
        $(byText("Неверно указан логин или пароль")).should(Condition.visible);
    }

    @Test
    void testBlockedUserWhenIncorrectPassword() {
        var regUser = getUser("blocked");
        var regOtherUser = getUser("blocked");
        setUppAll(regUser);
        $("[data-test-id =\"login\"] input").setValue(regUser.login);
        $("[data-test-id =\"password\"] input").setValue(regOtherUser.password);
        $x("//*[text()=\"Продолжить\"]").click();
        $(byText("Неверно указан логин или пароль")).should(Condition.visible);
    }
}

