package com.zdymak.qatest.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

// page_url = http://qa.zdymak.live/sign-up
public class ZdymakSingUp
{
    public SelenideElement email = $("#email");

    public SelenideElement nickname = $("#nickname");

    public SelenideElement birthday = $("#birthday");

    public SelenideElement password = $("#password");

    public SelenideElement passwordCheck = $("#passwordCheck");

    public SelenideElement regButton = $x("//button");

    public String repeatPassword = "Повторите введенный пароль";

    public String element = "Спасибо за регистрацию";

    public String textMainSubtitle2 = "На ваш электронный адрес %s выслано письмо с подтверждением!";

    public String checkInput = "Проверьте правильность введенных данных";

    public String emailLength = "E-mail не может содержать более 50 символов";

    public String nicknameLength = "Никнейм не может быть короче 6 символов";

    public String nickName = "Никнейм не может быть длиннее 26 символов";

    public String emailPasswmail = "Неверный email или пароль";

    public String emailPassw = "Введен неверный email или пароль.Попробуйте еще раз.";

    public String requiredToFill = "Поле обязательно для заполнения";
    public String checkPassword = "Пароли не совпадают\n" +
            requiredToFill;

    public String checkPass = "Пароли не совпадают";

    public String emailOK = "Введите действительный E-mail";

    public SelenideElement buttonOk = $("button[class^=\"text-main\"]");






}