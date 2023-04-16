package org.example;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class EstoTest {

    @BeforeEach
    public void openSite() {
        Configuration.browser = "firefox";
        open("https://profile.esto.ee/login");
    }

    @Test
    public void smartIdLoginOptionIsAvailable() {

        SelenideElement smartIdLoginOptionButton = $(By.xpath("//a[@data-cy='method-smart-id']"));

        smartIdLoginOptionButton.shouldBe(Condition.exist);
        smartIdLoginOptionButton.click();

        $(By.xpath("//*[@id='login-field']/div/input")).shouldBe(Condition.visible);
        $(By.xpath("//button[@data-cy='smart-id-login-button']")).shouldBe(Condition.exist);

    }

    @Test
    public void mobileIdLoginOptionIsAvailable() {
        SelenideElement mobileIdLoginOptionButton = $(By.xpath("//a[@data-cy='method-mobile-id']"));

        mobileIdLoginOptionButton.shouldBe(Condition.exist);
        mobileIdLoginOptionButton.click();

        $(By.xpath("//*[@id='phone-field']/div/input")).shouldBe(Condition.visible);
        $(By.xpath("//*[@id='pin-field']/div/input")).shouldBe(Condition.visible);
        $(By.xpath("//button[@data-cy='mobile-id-login-button']")).shouldBe(Condition.exist);

    }

    @Test
    public void passwordLoginOptionIsAvailable() {

        SelenideElement passwordLoginOptionButton = $(By.xpath("//a[@data-cy='method-password']"));

        passwordLoginOptionButton.shouldBe(Condition.exist);
        passwordLoginOptionButton.click();


        $(By.xpath("//*[@id='login-field']/div/input")).shouldBe(Condition.visible);
        $(By.xpath("//*[@id='password-field']/div/input")).shouldBe(Condition.visible);
        $(By.xpath("//button[@data-cy='password-login-button']")).shouldBe(Condition.exist);

    }

    @Test
    public void smartIdInvalidFormatError() {

        SelenideElement smartIdLoginOptionButton = $(By.xpath("//a[@data-cy='method-smart-id']"));
        SelenideElement smartIdCodeInputField = $(By.xpath("//*[@id='login-field']/div/input"));
        SelenideElement loginButton = $(By.xpath("//button[@data-cy='smart-id-login-button']"));

        smartIdLoginOptionButton.click();
        smartIdCodeInputField.setValue("555");

        loginButton.click();

        $(By.xpath("//*[@data-cy='smart-id-validation-error']")).shouldBe(Condition.visible);

    }

    @Test
    public void passwordLoginWithIncorrectCredentials() {

        SelenideElement passwordLoginOptionButton = $(By.xpath("//a[@data-cy='method-password']"));
        SelenideElement loginButton = $(By.xpath("//button[@data-cy='password-login-button']"));
        SelenideElement usernameInput = $(By.xpath("//*[@id='login-field']/div/input"));
        SelenideElement passwordInput = $(By.xpath("//*[@id='password-field']/div/input"));

        passwordLoginOptionButton.click();
        usernameInput.setValue("wrongValue");
        passwordInput.setValue("wrongValue");

        loginButton.click();

        $(By.xpath("//*[@data-cy='password-login-error']")).shouldBe(Condition.visible);


    }


}