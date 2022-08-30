package com.zdymak.qatest.test;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.zdymak.qatest.pages.ZdymakMainPage;
import com.zdymak.qatest.pages.ZdymakSingIn;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ZdymakTest {
    ZdymakSingIn zdymakSingInPage = new ZdymakSingIn();
    ZdymakMainPage zdymakMainPage = new ZdymakMainPage();

    @BeforeAll
    public static void setUpAll() {
        Configuration.browserSize = "1280x800";
        Configuration.timeout = 40000;
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @BeforeEach
    public void setUp() {
        open("http://qa.zdymak.live");
    }

    @Test
    public void reg() {
        zdymakMainPage.singInButton.click();
        $("#email").sendKeys("cheyla_stottkybn@head.msp");
        $("#nickname").sendKeys("over");
        $("#birthday").sendKeys("07-02-2008");
        $("#password").sendKeys("yGuS6QgZEN2biGDvT");
        $("#passwordCheck").sendKeys("yGuS6QgZEN2biGDvT");
        zdymakSingInPage.regButton.click();
        assertEquals(zdymakSingInPage.element3.getText(), $("div[class*=\"font-medium\"]").getText());
    }

    @Test
    public void errorSingIn() {
        zdymakMainPage.singInButton.click();
        zdymakSingInPage.email.sendKeys("mitesh_holderyerp@independence.qz");
        zdymakSingInPage.nickname.sendKeys("satyraku");
        zdymakSingInPage.birthday.sendKeys("07-02-2008");
        zdymakSingInPage.password.sendKeys("DP22Pvn7mqg41");
        zdymakSingInPage.passwordCheck.sendKeys("    ");
        zdymakSingInPage.regButton.click();
        assertEquals(zdymakSingInPage.textMainSubtitle,  $("div[class$=\"subtitle\"]").getText());
    }
}
