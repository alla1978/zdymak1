package com.zdymak.qatest.test;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.zdymak.qatest.pages.Zdymak;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ZdymakTest {
    Zdymak zdymakPage = new Zdymak();

    @BeforeAll
    public static void setUpAll() {
        Configuration.browserSize = "1280x800";
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @BeforeEach
    public void setUp() {
        open("http://qa.zdymak.live/sign-up");
    }

    @Test
    public void reg() {
        $("#email").sendKeys("cheyla_stottkybn@head.msp");
        $("#nickname").sendKeys("over");
        $("#birthday").sendKeys("07-02-2008");
        $("#password").sendKeys("yGuS6QgZEN2biGDvT");
        $("#passwordCheck").sendKeys("yGuS6QgZEN2biGDvT");
        $x("//button").click();
        assertEquals(zdymakPage.element3.getText(), $("div[class*=\"font-medium\"]").getText());
    }

}
