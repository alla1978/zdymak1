package com.zdymak.qatest.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
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

    public SelenideElement element3 = $(byText("Проверьте правильность введенных данных"));

    public SelenideElement element4 = $("div[class*=\"font-medium\"]");

    public SelenideElement errorMass = $("div[class$=\"subtitle\"]");
    public SelenideElement textMainSubtitle = $("div[class$=\"subtitle\"]");

    public String element = "Спасибо за регистрацию";

    public String textMainSubtitle2 = "На ваш электронный адрес %s выслано письмо с подтверждением!";

    public String element5 = "Проверьте правильность введенных данных";

    public String textMainSubtitle3 = "Поле обязательно для заполнения";

   





}