package com.zdymak.qatest.test;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.zdymak.qatest.pages.ZdymakMainPage;
import com.zdymak.qatest.pages.ZdymakSignInPage;
import com.zdymak.qatest.pages.ZdymakSingUp;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;

import java.util.UUID;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ZdymakTest {
    ZdymakSingUp zdymakSingUpPage = new ZdymakSingUp();
    ZdymakMainPage zdymakMainPage = new ZdymakMainPage();
    ZdymakSignInPage zdymakSignInPage = new ZdymakSignInPage();

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
    public void emptyPasswordCheck() {
        zdymakMainPage.singUpButton.click();
        String nickname = UUID.randomUUID().toString().substring(0, 26);
        String email = nickname + "@email.com";
        zdymakSingUpPage.email.sendKeys(email);
        zdymakSingUpPage.nickname.sendKeys(nickname);
        zdymakSingUpPage.birthday.sendKeys("07-02-2008");
        zdymakSingUpPage.password.sendKeys("DP22Pvn7mqg41");
        zdymakSingUpPage.passwordCheck.sendKeys("");
        zdymakSingUpPage.regButton.click();
        assertEquals(zdymakSingUpPage.repeatPassword, $("div[class$=\"subtitle\"]").getText());
    }

    @Test
    public void regOK() {
        zdymakMainPage.singUpButton.click();
        String nickname = UUID.randomUUID().toString().substring(0, 26);
        String email = nickname + "@email.com";
        zdymakSingUpPage.email.sendKeys(email);
        zdymakSingUpPage.nickname.sendKeys(nickname);
        zdymakSingUpPage.birthday.sendKeys("06-03-1976");
        zdymakSingUpPage.password.sendKeys("BHBUY9DEKXNEsCssGqJQ1P");
        zdymakSingUpPage.passwordCheck.sendKeys("BHBUY9DEKXNEsCssGqJQ1P");
        zdymakSingUpPage.regButton.click();
        assertEquals(zdymakSingUpPage.element, $("div[class*=\"font-medium\"]").getText());
        assertEquals(String.format(zdymakSingUpPage.textMainSubtitle2, email), $("div[class$=\"subtitle\"]").getText());
        zdymakSingUpPage.buttonOk.click();
    }

    @Test
    public void emptyEmail() {
        zdymakMainPage.singUpButton.click();
        String email = " ";
        String nickname = UUID.randomUUID().toString().substring(0, 26);
        //zdymakSingInPage.email.sendKeys(email);
        zdymakSingUpPage.nickname.sendKeys(nickname);
        zdymakSingUpPage.birthday.sendKeys("10-12-2006");
        zdymakSingUpPage.password.sendKeys("gypMBh7nVsLStcMCCYc");
        zdymakSingUpPage.passwordCheck.sendKeys("gypMBh7nVsLStcMCCYc");
        zdymakSingUpPage.regButton.click();
        assertEquals(zdymakSingUpPage.checkInput, $("div[class*=\"font-medium\"]").getText());
        assertEquals(zdymakSingUpPage.requiredToFill, $("div[class$=\"subtitle\"]").getText());
    }

    @Test
    public void emptyNickName() {
        zdymakMainPage.singUpButton.click();
        String nickname = UUID.randomUUID().toString().substring(0, 26);
        String email = nickname + "@email.com";
        zdymakSingUpPage.email.sendKeys(email);
        zdymakSingUpPage.nickname.sendKeys("");
        zdymakSingUpPage.birthday.sendKeys("10-12-2006");
        zdymakSingUpPage.password.sendKeys("gypMBh7nVsLStcMCCYc");
        zdymakSingUpPage.passwordCheck.sendKeys("gypMBh7nVsLStcMCCYc");
        zdymakSingUpPage.regButton.click();
        assertEquals(zdymakSingUpPage.checkInput, $("div[class*=\"font-medium\"]").getText());
        assertEquals(zdymakSingUpPage.requiredToFill, $("div[class$=\"subtitle\"]").getText());
    }

    @Test
    public void emptyBirthday() {
        zdymakMainPage.singUpButton.click();
        String nickname = UUID.randomUUID().toString().substring(0, 26);
        String email = nickname + "@email.com";
        zdymakSingUpPage.email.sendKeys(email);
        zdymakSingUpPage.nickname.sendKeys(nickname);
        zdymakSingUpPage.birthday.sendKeys("");
        zdymakSingUpPage.password.sendKeys("gypMBh7nVsLStcMCCYc");
        zdymakSingUpPage.passwordCheck.sendKeys("gypMBh7nVsLStcMCCYc");
        zdymakSingUpPage.regButton.click();
        assertEquals(zdymakSingUpPage.checkInput, $("div[class*=\"font-medium\"]").getText());
        assertEquals(zdymakSingUpPage.requiredToFill, $("div[class$=\"subtitle\"]").getText());
    }

    @Test
    public void emptyPass() {
        zdymakMainPage.singUpButton.click();
        String nickname = UUID.randomUUID().toString().substring(0, 26);
        String email = nickname + "@email.com";
        zdymakSingUpPage.email.sendKeys(email);
        zdymakSingUpPage.nickname.sendKeys(nickname);
        zdymakSingUpPage.birthday.sendKeys("11-12-1989");
        zdymakSingUpPage.password.sendKeys("");
        zdymakSingUpPage.passwordCheck.sendKeys("gypMBh7nVsLStcMCCYc");
        zdymakSingUpPage.regButton.click();
        assertEquals(zdymakSingUpPage.checkPassword, $("div[class$=\"subtitle\"]").getText());
    }

    @Test
    public void emailWithoutAccountName() {
        zdymakMainPage.singUpButton.click();
        String nickname = UUID.randomUUID().toString().substring(0, 26);
        String email = "@email.com";
        zdymakSingUpPage.email.sendKeys(email);
        zdymakSingUpPage.nickname.sendKeys(nickname);
        zdymakSingUpPage.birthday.sendKeys("11-12-1989");
        zdymakSingUpPage.password.sendKeys("gypMBh7nVsLStcMCCYc");
        zdymakSingUpPage.passwordCheck.sendKeys("gypMBh7nVsLStcMCCYc");
        zdymakSingUpPage.regButton.click();
        assertEquals(zdymakSingUpPage.checkInput, $("div[class*=\"font-medium\"]").getText());
        assertEquals(zdymakSingUpPage.emailOK, $("div[class$=\"subtitle\"]").getText());
    }
    @Test
    public void emailTwoSymbol() {
        zdymakMainPage.singUpButton.click();
        String nickname = UUID.randomUUID().toString().substring(0, 26);
        String email = nickname + "@@email.com";
        zdymakSingUpPage.email.sendKeys(email);
        zdymakSingUpPage.nickname.sendKeys(nickname);
        zdymakSingUpPage.birthday.sendKeys("11-12-1989");
        zdymakSingUpPage.password.sendKeys("gypMBh7nVsLStcMCCYc");
        zdymakSingUpPage.passwordCheck.sendKeys("gypMBh7nVsLStcMCCYc");
        zdymakSingUpPage.regButton.click();
        assertEquals(zdymakSingUpPage.checkInput, $("div[class*=\"font-medium\"]").getText());
        assertEquals(zdymakSingUpPage.emailOK, $("div[class$=\"subtitle\"]").getText());
    }
}
    //@Test
   // public void singIn() {
     //   zdymakMainPage.singInButton.click();
      //  zdymakSignInPage.username.sendKeys("yaugen.kulik@ladyka.by");
      //  zdymakSignInPage.password.sendKeys("12345q");
     //   zdymakSignInPage.button.click();
    //}

