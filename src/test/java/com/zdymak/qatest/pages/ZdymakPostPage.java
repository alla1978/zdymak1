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

       public SelenideElement comment = $("textarea[class$=\"resize-none\"]");

    public SelenideElement pageHome = $x("//a[@href=\"/seroiffoyija-7958\"]");

    public SelenideElement elementClickPhoto = $x("//img[@src=\"https://storage.yandexcloud.net/zdymak-media/2022/9/7/13322f0e-4159-4877-2482-b8504123c361.jpeg\"]");


    public SelenideElement elementSave = $x("//button");



    public SelenideElement elementAddComment  = $("textarea[class$=\"resize-none\"]");


    public SelenideElement elementPencil = $("svg[width=\"16\"]");

    public SelenideElement elementAddComment2 = $("input[class*=\"rounded-none\"]");

    public SelenideElement elementSend = $x("//button");

    public SelenideElement like = $("svg[class=\"cursor-pointer\"]");

    public SelenideElement dislike = $("svg[class=\"mt-[4px] cursor-pointer\"]");

    public SelenideElement subscription = $("span[class^=\"flex\"] div[class*=\"subtitle\"]");

    public SelenideElement subscriber = $("span[class=\"mr-[20px] flex flex-col items-center\"] div[class*=\"subtitle\"]");

    public SelenideElement setting = $("div[class=\"text-left font-normal text-10 \"]");

    public SelenideElement name = $("#name");

    public SelenideElement surname = $("#surname");

    public SelenideElement birthday = $("#birthday");

    public SelenideElement phone = $("#phone");

    public SelenideElement description = $("#description");


    public SelenideElement oldPassword = $("#oldPassword");

    public SelenideElement newPassword = $("#newPassword");

    public SelenideElement newPasswordAgain = $("#newPasswordAgain");

   public SelenideElement lenta = $x("/html/body/div[1]/div/div/div[2]/div/a[1]/svg");

    public SelenideElement passwSetting = $x("//div[contains(@class, \"text-left\")]");





























    






}



