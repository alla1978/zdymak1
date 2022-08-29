package com.zdymak.qatest.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

// page_url = http://qa.zdymak.live/sign-up
public class ZdymakSingIn {
    public SelenideElement email = $("#email");

    public SelenideElement nickname = $("label[for=\"nickname\"]");

    public SelenideElement birthday = $("#birthday");

    public SelenideElement password = $("#password");

    public SelenideElement element = $("label[for=\"passwordCheck\"]");

    public SelenideElement errHeader = $("div[class*=\"font-medium\"]");

    public SelenideElement regButton = $x("//button");

    public SelenideElement element2 = $("div[class*=\"font-medium\"]");

    public SelenideElement element3 = $(byText("Проверьте правильность введенных данных"));

}