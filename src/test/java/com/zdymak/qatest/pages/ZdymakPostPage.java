package com.zdymak.qatest.pages;

import com.codeborne.selenide.SelenideElement;
import org.w3c.dom.html.HTMLInputElement;

import static com.codeborne.selenide.Selenide.*;

// page_url = http://zdymak.live/sign-in

public class ZdymakPostPage {

    public static SelenideElement elementPost = $("div[class*=\"justify-between\"]");
    public static SelenideElement elementPhoto = $("div[class*=\"text-white\"]");

    public static SelenideElement file = $("input");



    //public static SelenideElement imgInput = $("C:\\Users\\admin\\IdeaProjects\\selenium_qa\\src\\test\\java\\img\\081d0f17f01653f870e5dc15c4b78482.jpg");


