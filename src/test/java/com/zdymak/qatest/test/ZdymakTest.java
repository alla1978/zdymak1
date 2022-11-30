package com.zdymak.qatest.test;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.zdymak.qatest.pages.ZdymakMainPage;
import com.zdymak.qatest.pages.ZdymakPostPage;
import com.zdymak.qatest.pages.ZdymakSignInPage;
import com.zdymak.qatest.pages.ZdymakSingUp;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.util.UUID;

import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ZdymakTest {
    ZdymakSingUp zdymakSingUpPage = new ZdymakSingUp();
    ZdymakMainPage zdymakMainPage = new ZdymakMainPage();
    ZdymakSignInPage zdymakSignInPage = new ZdymakSignInPage();
    ZdymakPostPage zdymakPostPage = new ZdymakPostPage();


    @BeforeAll
    public static void setUpAll() {
        Configuration.browser = "chrome";
        Configuration.browserSize = "1280x800";
        Configuration.timeout = 40000;
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @BeforeEach
    public void setUp() {
        open("https://qa.zdymak.live");
    }

    @Test
    public void emptyPasswordCheck() { //+
        zdymakMainPage.singUpButton.click();
        String nickname = UUID.randomUUID().toString().substring(0, 26);
        String email = nickname + "@email.com";
        zdymakSingUpPage.email.sendKeys(email);
        zdymakSingUpPage.nickname.sendKeys(nickname);
        zdymakSingUpPage.birthday.sendKeys("07-02-2008");
        zdymakSingUpPage.password.sendKeys("DP22Pvn7mqg41");
        zdymakSingUpPage.passwordCheck.sendKeys("");
        zdymakSingUpPage.regButton.click();
        assertEquals(zdymakSingUpPage.checkInput, $("div[class*=\"font-medium\"]").getText());
        assertEquals(zdymakSingUpPage.repeatPassword, $("div[class$=\"subtitle\"]").getText());
        zdymakSingUpPage.buttonOk.click();
    }

    @Test
    public void regOK() throws InterruptedException {
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
    public void singIn() {//-
        zdymakMainPage.singInButton.click();
        zdymakSignInPage.username.sendKeys("zdymakqa@ladyka.by");
        zdymakSignInPage.password.sendKeys("qa@ladyka.by!1Q");
        zdymakSignInPage.button.click();
    }

    @Test
    public void singPassWithoutName() {//-
        zdymakMainPage.singInButton.click();
        zdymakSignInPage.username.sendKeys("@ladyka.by");
        zdymakSignInPage.password.sendKeys("qa@ladyka.by!1Q");
        zdymakSignInPage.button.click();
        assertEquals(zdymakSingUpPage.emailPasswmail, $("div[class*=\"font-medium\"]").getText());
        assertEquals(zdymakSingUpPage.emailPassw, $("div[class$=\"subtitle\"]").getText());
    }

    @Test
    public void emailwithoutSymbol() { //---
        zdymakMainPage.singInButton.click();
        zdymakSignInPage.username.sendKeys("yaugen.kulikladyka.by");
        zdymakSignInPage.password.sendKeys("qa@ladyka.by!1Q");
        zdymakSignInPage.button.click();
        assertEquals(zdymakSingUpPage.checkInput, $("div[class*=\"font-medium\"]").getText());
        assertEquals(zdymakSingUpPage.emailPassw, $("div[class$=\"subtitle\"]").getText());
    }

    @Test
    public void emailwithSpace() {//-
        zdymakMainPage.singInButton.click();
        zdymakSignInPage.username.sendKeys(" zdymakqa@ladyka.by");
        zdymakSignInPage.password.sendKeys("qa@ladyka.by!1Q");
        zdymakSignInPage.button.click();

    }
    @Test
    public void emailwithSpace2() {//-
        zdymakMainPage.singInButton.click();
        zdymakSignInPage.username.sendKeys("zdymakqa@ladyka.by ");
        zdymakSignInPage.password.sendKeys("qa@ladyka.by!1Q");
        zdymakSignInPage.button.click();

    }

    @Test
    public void emptyEmail() { //+
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
    public void emptyNickName() {//+
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
    public void emptyBirthday() {//+
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
    public void emptyPass() {//+
        zdymakMainPage.singUpButton.click();
        String nickname = UUID.randomUUID().toString().substring(0, 26);
        String email = nickname + "@email.com";
        zdymakSingUpPage.email.sendKeys(email);
        zdymakSingUpPage.nickname.sendKeys(nickname);
        zdymakSingUpPage.birthday.sendKeys("11-12-1989");
        zdymakSingUpPage.password.sendKeys("");
        zdymakSingUpPage.passwordCheck.sendKeys("gypMBh7nVsLStcMCCYc");
        zdymakSingUpPage.regButton.click();
        assertEquals(zdymakSingUpPage.checkInput, $("div[class*=\"font-medium\"]").getText());
        assertEquals(zdymakSingUpPage.checkPassword, $("div[class$=\"subtitle\"]").getText());
    }

    @Test
    public void emailWithoutAccountName() {//+
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
    public void emailTwoSymbol() { //+      два @@
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
    public void emailWithoutCom() { //+    без .com
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
    public void emailTwoDotCom() { //+ @69.com.ru
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
    public void emailWithoutDomain() { //+ breroizoippude-7146@
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
    public void differentPass() { //+
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
    public void spaceInPass() { //+
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
    public void spaceInPassw() { //+
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
    public void spaceInPassCheck() { //+
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
    public void spaceInPassCheck2() { //+
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
    public void nickname27() { //+
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
    public void nickname5Symbol() { //+
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
    public void singEmailEmpty() {//+
        zdymakMainPage.singInButton.click();
        zdymakSignInPage.username.sendKeys("");
        zdymakSignInPage.password.sendKeys("qa@ladyka.by!1Q");
        zdymakSignInPage.button.click();
        assertEquals(zdymakSingUpPage.checkInput, $("div[class*=\"font-medium\"]").getText());
        assertEquals(zdymakSingUpPage.requiredToFill, $("div[class$=\"subtitle\"]").getText());
    }

    @Test
    public void singPassEmpty() {//+
        zdymakMainPage.singInButton.click();
        zdymakSignInPage.username.sendKeys("zdymakqa@ladyka.by");
        zdymakSignInPage.password.sendKeys("");
        zdymakSignInPage.button.click();
        assertEquals(zdymakSingUpPage.checkInput, $("div[class*=\"font-medium\"]").getText());
        assertEquals(zdymakSingUpPage.requiredToFill, $("div[class$=\"subtitle\"]").getText());
    }



    @Test
    public void sing51Symbol() {//+
        zdymakMainPage.singInButton.click();
        zdymakSignInPage.username.sendKeys("zdymakqa121212122222222222222222222222111@ladyka.by");
        zdymakSignInPage.password.sendKeys("qa@ladyka.by!1Q");
        zdymakSignInPage.button.click();
        assertEquals(zdymakSingUpPage.checkInput, $("div[class*=\"font-medium\"]").getText());
        assertEquals(zdymakSingUpPage.emailLength, $("div[class$=\"subtitle\"]").getText());
    }



    @Test
    public void editPostComment() { //+
        zdymakMainPage.singInButton.click();
        zdymakSignInPage.username.sendKeys("zdymakqa@ladyka.by");
        zdymakSignInPage.password.sendKeys("qa@ladyka.by!1Q");
        zdymakSignInPage.button.click();
        zdymakPostPage.pageProfile.click();
        zdymakPostPage.ClickPhoto.click();
        zdymakPostPage.elementPencil.click();
        zdymakPostPage.elementAddComment.sendKeys(" privet");
        zdymakPostPage.elementSave.click();
    }

    @Test
    public void addComment() { //+
        zdymakMainPage.singInButton.click();
        zdymakSignInPage.username.sendKeys("zdymakqa@ladyka.by");
        zdymakSignInPage.password.sendKeys("qa@ladyka.by!1Q");
        zdymakSignInPage.button.click();
        zdymakPostPage.ClickPhotoHome.click();
        zdymakPostPage.elementAddComment3.sendKeys("test comment");
        zdymakPostPage.elementSend.click();
        }
    @Test
    public void Like() { //+
        zdymakMainPage.singInButton.click();
        zdymakSignInPage.username.sendKeys("zdymakqa@ladyka.by");
        zdymakSignInPage.password.sendKeys("qa@ladyka.by!1Q");
        zdymakSignInPage.button.click();
        zdymakPostPage.ClickLike.click();
        zdymakPostPage.like.click();
    }
    @Test
    public void DisLike() { //+
        zdymakMainPage.singInButton.click();
        zdymakSignInPage.username.sendKeys("zdymakqa@ladyka.by");
        zdymakSignInPage.password.sendKeys("qa@ladyka.by!1Q");
        zdymakSignInPage.button.click();
        zdymakPostPage.ClickLike.click();
        zdymakPostPage.dislike.click();
    }
    @Test
    public void subscription() { //+
        zdymakMainPage.singInButton.click();
        zdymakSignInPage.username.sendKeys("zdymakqa@ladyka.by");
        zdymakSignInPage.password.sendKeys("qa@ladyka.by!1Q");
        zdymakSignInPage.button.click();
        zdymakPostPage.pageProfile.click();
        zdymakPostPage.subscription.click();

    }
    @Test
    public void subscriber() { //+
        zdymakMainPage.singInButton.click();
        zdymakSignInPage.username.sendKeys("zdymakqa@ladyka.by");
        zdymakSignInPage.password.sendKeys("qa@ladyka.by!1Q");
        zdymakSignInPage.button.click();
        zdymakPostPage.pageProfile.click();
        zdymakPostPage.subscriber.click();

    }
    @Test
    public void setting() { //+
        zdymakMainPage.singInButton.click();
        zdymakSignInPage.username.sendKeys("zdymakqa@ladyka.by");
        zdymakSignInPage.password.sendKeys("qa@ladyka.by!1Q");
        zdymakSignInPage.button.click();
        zdymakPostPage.pageProfile.click();
        zdymakPostPage.setting.click();
        String name = UUID.randomUUID().toString().substring(0, 10);
        zdymakPostPage.name.clear();
        zdymakPostPage.name.sendKeys(name);
        String surname = UUID.randomUUID().toString().substring(0, 10);
        zdymakPostPage.surname.clear();
        zdymakPostPage.surname.sendKeys(surname);
        zdymakPostPage.birthday.clear();
        zdymakPostPage.birthday.sendKeys("10-12-1981");
        zdymakPostPage.phone.clear();
        zdymakPostPage.phone.sendKeys("+375296666612");
        String description = UUID.randomUUID().toString().substring(0, 35);
        zdymakPostPage.description.clear();
        zdymakPostPage.description.sendKeys(description);
        zdymakPostPage.elementSave.click();
}

   // @Test
    //public void passwSetting() {
     //   zdymakMainPage.singInButton.click();
      //  zdymakSignInPage.username.sendKeys("zdymakqa@ladyka.by");
      //  zdymakSignInPage.password.sendKeys("qa@ladyka.by!1Q");
       // zdymakSignInPage.button.click();
      //  zdymakPostPage.pageProfile.click();
     //   zdymakPostPage.setting.click();
    //    zdymakPostPage.passwSetting.click();
     //   zdymakPostPage.oldPassword.sendKeys("qa@ladyka.by!1Q");
     //   zdymakPostPage.newPassword.sendKeys("qa@ladyka.by!1Q1");
     //   zdymakPostPage.newPasswordAgain.sendKeys("qa@ladyka.by!1Q1");
    //    zdymakPostPage.elementSave.click();
    //    open("https://qa.zdymak.live/logout");
     //   zdymakMainPage.singInButton.click();
     //   zdymakSignInPage.username.sendKeys("szdymakqa@ladyka.by");
     //   zdymakSignInPage.password.sendKeys("qa@ladyka.by!1Q1");
}

    //@Test
    //public void addPhotoAndPost() {//-
        //zdymakMainPage.singInButton.click();
        //zdymakSignInPage.username.sendKeys("zdymakqa@ladyka.by");
        //zdymakSignInPage.password.sendKeys("qa@ladyka.by!1Q");
        //zdymakSignInPage.button.click();
        //zdymakPostPage.elementPlus.click();
        //zdymakPostPage.ClickPost.click();
       // zdymakPostPage.file2.sendKeys("/home/ubuntu/IdeaProjects/selenium_qa/src/test/java/img/2a61a60a838b136de6d56796e0365baa.png");
        //zdymakPostPage.further.click();
        //zdymakPostPage.comment.sendKeys("привет мир");
       // zdymakPostPage.share.click();


