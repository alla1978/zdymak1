package com.zdymak.qatest.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

// page_url = http://qa.zdymak.live/
public class ZdymakMainPage {
    public SelenideElement singInButton = $("button[class*=\"blue\"]");

}