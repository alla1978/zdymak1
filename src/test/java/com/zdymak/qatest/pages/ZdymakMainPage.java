package com.zdymak.qatest.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

// page_url = http://zdymak.live/
public class ZdymakMainPage {
    public SelenideElement singUpButton = $("button[class*=\"blue\"]");

    public SelenideElement singInButton = $("button[class*=\"black\"]");

}