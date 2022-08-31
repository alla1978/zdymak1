package com.zdymak.qatest.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

// page_url = http://qa.zdymak.live/sign-in
public class ZdymakSignInPage {
    public SelenideElement username = $("#username");

    public SelenideElement password = $("#password");

    public SelenideElement button = $x("//button");

}