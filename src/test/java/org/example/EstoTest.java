package org.example;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class EstoTest {

    @Test
    public void firstTest() {
        Configuration.browser = "firefox";
        open("https://profile.esto.ee/login");
        SelenideElement usernameInput = $(By.xpath(""));
        SelenideElement passwordInput = $(By.xpath(""));
    }

}


//    Создайте новый проект на базе junit5 + selenide
//        1 Составьте чек-лист функциональных проверок UI веб-приложения
//        https://profile.esto.ee/login в контексте различных способов логина и добавьте его в readme


//        2. Реализуйте проверки сначала позитивные по проверке опций входа без
//        непосредственно авторизации (3 теста - smartid, login/password, mobilid), потом
//        негативные в части проверки ошибок авторизации для некорректных данных (2 теста -
//        smartid, login/password)