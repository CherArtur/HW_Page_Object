package pages;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class RegistrationPage {
    public void openPage(){
        //Открыть страницу Practice Form
        open("/automation-practice-form");
        $(".main-header").shouldHave(text("Practice Form"));
        //Убрать рекламу и футер
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
    }
}
