package com.zdymak.qatest.test;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.zdymak.qatest.pages.ZdymakMainPage;
import com.zdymak.qatest.pages.ZdymakPostPage;
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
    private Object zdymakSingInPage;

    @BeforeAll
    public static void setUpAll() {
        Configuration.browserSize = "1280x800";
        Configuration.timeout = 40000;
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @BeforeEach
    public void setUp() {
        open("http://zdymak.live");
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
    public void emailTwoSymbol() { // два @@
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

    @Test
    public void emailWithoutCom() { // без .com
        zdymakMainPage.singUpButton.click();
        String nickname = UUID.randomUUID().toString().substring(0, 26);
        String email = nickname + "@email.";
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
    public void emailTwoDotCom() { // @69.com.ru
        zdymakMainPage.singUpButton.click();
        String nickname = UUID.randomUUID().toString().substring(0, 26);
        String email = nickname + "@email.com.ru";
        zdymakSingUpPage.email.sendKeys(email);
        zdymakSingUpPage.nickname.sendKeys(nickname);
        zdymakSingUpPage.birthday.sendKeys("11-12-1989");
        zdymakSingUpPage.password.sendKeys("gypMBh7nVsLStcMCCYc");
        zdymakSingUpPage.passwordCheck.sendKeys("gypMBh7nVsLStcMCCYc");
        zdymakSingUpPage.regButton.click();
        assertEquals(zdymakSingUpPage.element, $("div[class*=\"font-medium\"]").getText());
        assertEquals(String.format(zdymakSingUpPage.textMainSubtitle2, email), $("div[class$=\"subtitle\"]").getText());
        zdymakSingUpPage.buttonOk.click();
    }
        @Test
        public void emailWithoutDomain() { // breroizoippude-7146@
            zdymakMainPage.singUpButton.click();
            String nickname = UUID.randomUUID().toString().substring(0, 26);
            String email = nickname + "@";
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
    public void differentPass() { //
        zdymakMainPage.singUpButton.click();
        String nickname = UUID.randomUUID().toString().substring(0, 26);
        String email = nickname + "@mail.com";
        zdymakSingUpPage.email.sendKeys(email);
        zdymakSingUpPage.nickname.sendKeys(nickname);
        zdymakSingUpPage.birthday.sendKeys("11-12-1989");
        zdymakSingUpPage.password.sendKeys("LsXztM87QYNkubXLaly");
        zdymakSingUpPage.passwordCheck.sendKeys("gypMBh7nVsLStcMCCYc");
        zdymakSingUpPage.regButton.click();
        assertEquals(zdymakSingUpPage.checkInput, $("div[class*=\"font-medium\"]").getText());
        assertEquals(zdymakSingUpPage.checkPass, $("div[class$=\"subtitle\"]").getText());
    }
    @Test
    public void spaceInPass() { //
        zdymakMainPage.singUpButton.click();
        String nickname = UUID.randomUUID().toString().substring(0, 26);
        String email = nickname + "@mail.com";
        zdymakSingUpPage.email.sendKeys(email);
        zdymakSingUpPage.nickname.sendKeys(nickname);
        zdymakSingUpPage.birthday.sendKeys("11-12-1989");
        zdymakSingUpPage.password.sendKeys(" LsXztM87QYNkubXLaly");
        zdymakSingUpPage.passwordCheck.sendKeys("LsXztM87QYNkubXLaly");
        zdymakSingUpPage.regButton.click();
        assertEquals(zdymakSingUpPage.checkInput, $("div[class*=\"font-medium\"]").getText());
        assertEquals(zdymakSingUpPage.checkPass, $("div[class$=\"subtitle\"]").getText());
    }
    @Test
    public void spaceInPassw() { //
        zdymakMainPage.singUpButton.click();
        String nickname = UUID.randomUUID().toString().substring(0, 26);
        String email = nickname + "@mail.com";
        zdymakSingUpPage.email.sendKeys(email);
        zdymakSingUpPage.nickname.sendKeys(nickname);
        zdymakSingUpPage.birthday.sendKeys("11-12-1989");
        zdymakSingUpPage.password.sendKeys("LsXztM87QYNkubXLaly ");
        zdymakSingUpPage.passwordCheck.sendKeys("LsXztM87QYNkubXLaly");
        zdymakSingUpPage.regButton.click();
        assertEquals(zdymakSingUpPage.checkInput, $("div[class*=\"font-medium\"]").getText());
        assertEquals(zdymakSingUpPage.checkPass, $("div[class$=\"subtitle\"]").getText());
    }
    @Test
    public void spaceInPassCheck() { //
        zdymakMainPage.singUpButton.click();
        String nickname = UUID.randomUUID().toString().substring(0, 26);
        String email = nickname + "@mail.com";
        zdymakSingUpPage.email.sendKeys(email);
        zdymakSingUpPage.nickname.sendKeys(nickname);
        zdymakSingUpPage.birthday.sendKeys("11-12-1989");
        zdymakSingUpPage.password.sendKeys("LsXztM87QYNkubXLaly");
        zdymakSingUpPage.passwordCheck.sendKeys(" LsXztM87QYNkubXLaly");
        zdymakSingUpPage.regButton.click();
        assertEquals(zdymakSingUpPage.checkInput, $("div[class*=\"font-medium\"]").getText());
        assertEquals(zdymakSingUpPage.checkPass, $("div[class$=\"subtitle\"]").getText());
    }
    @Test
    public void spaceInPassCheck2() { //
        zdymakMainPage.singUpButton.click();
        String nickname = UUID.randomUUID().toString().substring(0, 26);
        String email = nickname + "@mail.com";
        zdymakSingUpPage.email.sendKeys(email);
        zdymakSingUpPage.nickname.sendKeys(nickname);
        zdymakSingUpPage.birthday.sendKeys("12-12-2021");
        zdymakSingUpPage.password.sendKeys("LsXztM87QYNkubXLaly");
        zdymakSingUpPage.passwordCheck.sendKeys("LsXztM87QYNkubXLaly ");
        zdymakSingUpPage.regButton.click();
        assertEquals(zdymakSingUpPage.checkInput, $("div[class*=\"font-medium\"]").getText());
        assertEquals(zdymakSingUpPage.checkPass, $("div[class$=\"subtitle\"]").getText());
    }
    @Test
    public void nickname27() { //
        zdymakMainPage.singUpButton.click();
        String nickname = UUID.randomUUID().toString().substring(0, 27);
        String email = nickname + "@mail.com";
        zdymakSingUpPage.email.sendKeys(email);
        zdymakSingUpPage.nickname.sendKeys(nickname);
        zdymakSingUpPage.birthday.sendKeys("02-03-1999");
        zdymakSingUpPage.password.sendKeys("LsXztM87QYNkubXLaly");
        zdymakSingUpPage.passwordCheck.sendKeys("LsXztM87QYNkubXLaly");
        zdymakSingUpPage.regButton.click();
        assertEquals(zdymakSingUpPage.checkInput, $("div[class*=\"font-medium\"]").getText());
        assertEquals(zdymakSingUpPage.nickName, $("div[class$=\"subtitle\"]").getText());
    }
    @Test
    public void nickname5Symbol() { //
        zdymakMainPage.singUpButton.click();
        String nickname = UUID.randomUUID().toString().substring(0, 5);
        String email = nickname + "@mail.com";
        zdymakSingUpPage.email.sendKeys(email);
        zdymakSingUpPage.nickname.sendKeys(nickname);
        zdymakSingUpPage.birthday.sendKeys("02-03-1999");
        zdymakSingUpPage.password.sendKeys("LsXztM87QYNkubXLaly");
        zdymakSingUpPage.passwordCheck.sendKeys("LsXztM87QYNkubXLaly");
        zdymakSingUpPage.regButton.click();
        assertEquals(zdymakSingUpPage.checkInput, $("div[class*=\"font-medium\"]").getText());
        assertEquals(zdymakSingUpPage.nicknameLength, $("div[class$=\"subtitle\"]").getText());
    }


    @Test
   public void singIn() {
    zdymakMainPage.singInButton.click();
    zdymakSignInPage.username.sendKeys("yaugen.kulik@ladyka.by");
    zdymakSignInPage.password.sendKeys("12345q");
    zdymakSignInPage.button.click();
    }
    @Test
    public void singEmailEmpty() {
        zdymakMainPage.singInButton.click();
        zdymakSignInPage.username.sendKeys("");
        zdymakSignInPage.password.sendKeys("12345q");
        zdymakSignInPage.button.click();
        assertEquals(zdymakSingUpPage.checkInput, $("div[class*=\"font-medium\"]").getText());
        assertEquals(zdymakSingUpPage.requiredToFill, $("div[class$=\"subtitle\"]").getText());
    }
    @Test
    public void singPassEmpty() {
        zdymakMainPage.singInButton.click();
        zdymakSignInPage.username.sendKeys("yaugen.kulik@ladyka.by");
        zdymakSignInPage.password.sendKeys("");
        zdymakSignInPage.button.click();
        assertEquals(zdymakSingUpPage.checkInput, $("div[class*=\"font-medium\"]").getText());
        assertEquals(zdymakSingUpPage.requiredToFill, $("div[class$=\"subtitle\"]").getText());
    }
    @Test
    public void emailwithoutSymbol() {
        zdymakMainPage.singInButton.click();
        zdymakSignInPage.username.sendKeys("yaugen.kulikladyka.by");
        zdymakSignInPage.password.sendKeys("12345q");
        zdymakSignInPage.button.click();
        assertEquals(zdymakSingUpPage.emailPasswmail, $("div[class*=\"font-medium\"]").getText());
        assertEquals(zdymakSingUpPage.emailPassw, $("div[class$=\"subtitle\"]").getText());
    }
    @Test
    public void emailwithSpace() {
        zdymakMainPage.singInButton.click();
        zdymakSignInPage.username.sendKeys(" gubroisennawou-1597@yopmail.com");
        zdymakSignInPage.password.sendKeys("gubroisennawou");
        zdymakSignInPage.button.click();

    }
    @Test
    public void emailwithSpace2() {
        zdymakMainPage.singInButton.click();
        zdymakSignInPage.username.sendKeys("gubroisennawou-1597@yopmail.com ");
        zdymakSignInPage.password.sendKeys("gubroisennawou");
        zdymakSignInPage.button.click();

    }
    @Test
    public void singPassWithoutName() {
    zdymakMainPage.singInButton.click();
    zdymakSignInPage.username.sendKeys("@ladyka.by");
    zdymakSignInPage.password.sendKeys("12345q");
    zdymakSignInPage.button.click();
    assertEquals(zdymakSingUpPage.emailPasswmail, $("div[class*=\"font-medium\"]").getText());
    assertEquals(zdymakSingUpPage.emailPassw, $("div[class$=\"subtitle\"]").getText());
   }

    @Test
    public void sing51Symbol() {
        zdymakMainPage.singInButton.click();
        zdymakSignInPage.username.sendKeys("thelongestdomainnameintheworldandthensomeandthensom");
        zdymakSignInPage.password.sendKeys("12345q");
        zdymakSignInPage.button.click();
        assertEquals(zdymakSingUpPage.checkInput, $("div[class*=\"font-medium\"]").getText());
        assertEquals(zdymakSingUpPage.emailLength, $("div[class$=\"subtitle\"]").getText());
    }

    @Test
    public void post () {
        zdymakMainPage.singInButton.click();
        zdymakSignInPage.username.sendKeys("seroiffoyija-7958@yopmail.com");
        zdymakSignInPage.password.sendKeys("test");
        zdymakSignInPage.button.click();
        ZdymakPostPage.elementPost.click();
        ZdymakPostPage.elementPhoto.click();
        ZdymakPostPage.imgInput = $("div[class*=\flex justify-center\"]");

        //ZdymakPostPage.elementFurther.click();
    }
}
