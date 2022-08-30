package com.zdymak.qatest.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

// page_url = http://qa.zdymak.live/sign-up
public class ZdymakSingIn {
    public SelenideElement email = $("#email");

    public SelenideElement nickname = $("#nickname");

    public SelenideElement birthday = $("#birthday");

    public SelenideElement password = $("#password");

    public SelenideElement passwordCheck = $("#passwordCheck");

    public SelenideElement errHeader = $("div[class*=\"font-medium\"]");

    public SelenideElement regButton = $x("//button");

    public SelenideElement element2 = $("div[class*=\"font-medium\"]");


    public SelenideElement element4 = $("div[class*=\"font-medium\"]");

    public SelenideElement errorMass = $("div[class$=\"subtitle\"]");
    public String repeatPassword = "Повторите введенный пароль";

    public String element = "Спасибо за регистрацию";

    public String textMainSubtitle2 = "На ваш электронный адрес %s выслано письмо с подтверждением!";

    public String checkInput = "Проверьте правильность введенных данных";

    public String requiredToFill = "Поле обязательно для заполнения";
    public String checkPassword = "Пароли не совпадают\n" +
            requiredToFill;

    public SelenideElement buttonOk = $("button[class^=\"text-main\"]");


}