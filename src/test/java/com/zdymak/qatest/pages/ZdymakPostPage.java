package com.zdymak.qatest.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.WebElement;
import org.w3c.dom.html.HTMLInputElement;

import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.*;

// page_url = http://zdymak.live/sign-in

public class ZdymakPostPage {

    public SelenideElement elementPost = $("div[class*=\"justify-between\"]");
    public SelenideElement elementPhoto = $("div[class*=\"text-white\"]");

    public SelenideElement file2 = $(byName("file"));

    public SelenideElement further = $("div[class*=\"grid-cols-3\"]");

    public SelenideElement comment = $("div[class*=\"grid-cols-3\"]");







}



