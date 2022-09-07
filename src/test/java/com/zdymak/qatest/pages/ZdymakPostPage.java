package com.zdymak.qatest.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.WebElement;
import org.w3c.dom.html.HTMLInputElement;

import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.*;

// page_url = http://zdymak.live/sign-in

public class ZdymakPostPage {
    public SelenideElement elementPlus = $x("//span");
    public SelenideElement elementSelectPhoto = $x("//div[contains(@class, \"px-[40px]\")]");
      public SelenideElement file2 = $(byName("file"));
    public SelenideElement further = $x("//button");

    public SelenideElement share = $x("//button");

   //public SelenideElement comment  = $("#comment");

    public SelenideElement element = $x("//textarea");

    public SelenideElement comment = $("textarea[class$=\"resize-none\"]");
















    






}



