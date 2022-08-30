package com.zdymak.qatest.test;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.zdymak.qatest.pages.ZdymakMainPage;
import com.zdymak.qatest.pages.ZdymakSingIn;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.UUID;

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
        String nickname = UUID.randomUUID().toString().substring(0, 26);
        String email = nickname + "@email.com";
        zdymakSingInPage.email.sendKeys(email);
        zdymakSingInPage.nickname.sendKeys(nickname);
        $("#birthday").sendKeys("07-02-2008");
        $("#password").sendKeys("yGuS6QgZEN2biGDvT");
        $("#passwordCheck").sendKeys("yGuS6QgZEN2biGDvT");
        zdymakSingInPage.regButton.click();
        assertEquals(zdymakSingInPage.element3.getText(), $("div[class*=\"font-medium\"]").getText());
    }


    @Test
    public void errorSingIn() {
        zdymakMainPage.singInButton.click();
        String nickname = UUID.randomUUID().toString().substring(0, 26);
        String email = nickname + "@email.com";
        zdymakSingInPage.email.sendKeys(email);
        zdymakSingInPage.nickname.sendKeys(nickname);
        zdymakSingInPage.birthday.sendKeys("07-02-2008");
        zdymakSingInPage.password.sendKeys("DP22Pvn7mqg41");
        zdymakSingInPage.passwordCheck.sendKeys("    ");
        zdymakSingInPage.regButton.click();
        assertEquals(zdymakSingInPage.textMainSubtitle, $("div[class$=\"subtitle\"]").getText());
    }

    @Test
    public void regOK() {
        zdymakMainPage.singInButton.click();
        String nickname = UUID.randomUUID().toString().substring(0, 26);
        String email = nickname + "@email.com";
        zdymakSingInPage.email.sendKeys(email);
        zdymakSingInPage.nickname.sendKeys(nickname);
        zdymakSingInPage.birthday.sendKeys("06-03-1976");
        zdymakSingInPage.password.sendKeys("BHBUY9DEKXNEsCssGqJQ1P");
        zdymakSingInPage.passwordCheck.sendKeys("BHBUY9DEKXNEsCssGqJQ1P");
        zdymakSingInPage.regButton.click();
        assertEquals(zdymakSingInPage.element, $("div[class*=\"font-medium\"]").getText());
        assertEquals(String.format(zdymakSingInPage.textMainSubtitle2, email), $("div[class$=\"subtitle\"]").getText());
    }
    @Test
    public void emptyEmail() {
        zdymakMainPage.singInButton.click();
        String email = " ";
        String nickname = UUID.randomUUID().toString().substring(0, 26);
        //zdymakSingInPage.email.sendKeys(email);
        zdymakSingInPage.nickname.sendKeys(nickname);
        zdymakSingInPage.birthday.sendKeys("10-12-2006");
        zdymakSingInPage.password.sendKeys("gypMBh7nVsLStcMCCYc");
        zdymakSingInPage.passwordCheck.sendKeys("gypMBh7nVsLStcMCCYc");
        zdymakSingInPage.regButton.click();
        assertEquals(zdymakSingInPage.element5, $("div[class*=\"font-medium\"]").getText());
        assertEquals(String.format(zdymakSingInPage.textMainSubtitle3, email), $("div[class$=\"subtitle\"]").getText());
    }
    @Test
    public void emptyNickName() {
        zdymakMainPage.singInButton.click();
        String nickname = UUID.randomUUID().toString().substring(0, 26);
        String email =nickname+ "@email.com";
        zdymakSingInPage.email.sendKeys(email);
        zdymakSingInPage.nickname.sendKeys("");
        zdymakSingInPage.birthday.sendKeys("10-12-2006");
        zdymakSingInPage.password.sendKeys("gypMBh7nVsLStcMCCYc");
        zdymakSingInPage.passwordCheck.sendKeys("gypMBh7nVsLStcMCCYc");
        zdymakSingInPage.regButton.click();
        assertEquals(zdymakSingInPage.element5, $("div[class*=\"font-medium\"]").getText());
        assertEquals(String.format(zdymakSingInPage.textMainSubtitle3, email), $("div[class$=\"subtitle\"]").getText());
    }
    @Test
    public void emptyBirthday() {
        zdymakMainPage.singInButton.click();
        String nickname = UUID.randomUUID().toString().substring(0, 26);
        String email =nickname+ "@email.com";
        zdymakSingInPage.email.sendKeys(email);
        zdymakSingInPage.nickname.sendKeys(nickname);
        zdymakSingInPage.birthday.sendKeys("");
        zdymakSingInPage.password.sendKeys("gypMBh7nVsLStcMCCYc");
        zdymakSingInPage.passwordCheck.sendKeys("gypMBh7nVsLStcMCCYc");
        zdymakSingInPage.regButton.click();
        assertEquals(zdymakSingInPage.element5, $("div[class*=\"font-medium\"]").getText());
        assertEquals(String.format(zdymakSingInPage.textMainSubtitle3, email), $("div[class$=\"subtitle\"]").getText());
    }
}
