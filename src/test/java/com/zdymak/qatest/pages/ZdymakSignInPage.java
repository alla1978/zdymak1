package com.zdymak.qatest.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

// page_url = http://zdymak.live/sign-in
public class ZdymakSignInPage {
    public SelenideElement username = $("#username");

    public SelenideElement password = $("#password");

    public SelenideElement button = $x("//button");
    public String checkInput = "Проверьте правильность введенных данных";
    public String passwCyrill = "Пароль должен сожержать латинскую букву";











   

    
}