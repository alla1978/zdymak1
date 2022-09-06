package com.zdymak.qatest.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.WebElement;
import org.w3c.dom.html.HTMLInputElement;

import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.*;

// page_url = http://zdymak.live/sign-in

public class ZdymakPostPage {

    public SelenideElement elementPost = $("div[class*=\"justify-between\"]");


    public SelenideElement file2 = $(byName("file"));
    public SelenideElement further = $x("//button");

    public SelenideElement comment1 = $x("//textarea");


    public SelenideElement share = $x("//button");













}



