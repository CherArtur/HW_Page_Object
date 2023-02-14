package pages;

import pages.components.CalendarComponents;
import pages.components.RegistrationResultModal;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class RegistrationPage {
    CalendarComponents calendarComponents = new CalendarComponents();
    RegistrationResultModal registrationResultModal = new RegistrationResultModal();
    private final String titleText = "Practice Form";

    public RegistrationPage openPage() {
        //Открыть страницу Practice Form
        open("/automation-practice-form");
        $(".main-header").shouldHave(text(titleText));
        //Убрать рекламу и футер
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    public RegistrationPage setFirstName(String value) {
        $("#firstName").setValue(value);
        return this;
    }
    public RegistrationPage setLastName(String value) {
        $("#lastName").setValue(value);
        return this;
    }
    public RegistrationPage setUserEmail(String value) {
        $("#userEmail").setValue(value);
        return this;
    }
    public RegistrationPage setGender(String value) {
        $("#genterWrapper").$(byText(value)).click();
        return this;
    }
    public RegistrationPage setUserNumber(String value) {
        $("#userNumber").setValue(value);
        return this;
    }


    public RegistrationPage setSubjectsItem(String value) {
        $("#subjectsInput").setValue(value).pressEnter();
        return this;
    }

    public RegistrationPage setHobbiesItem(String value) {
        $("#hobbiesWrapper").$(byText(value)).click();
        return this;
    }

    public RegistrationPage contributePictures() {
        $("#uploadPicture").uploadFromClasspath("pictures/фин_юмор2.jpg");
        return this;
    }

    public RegistrationPage setCurrentAddress(String value) {
        $("#currentAddress").setValue(value);
        return this;
    }

    public RegistrationPage chooseState(String value) {
        $("#state").click();
        $("#state").$(byText(value)).click();
        return this;
    }

    public RegistrationPage chooseCity(String value) {
        $("#city").click();
        $("#city").$(byText(value)).click();
        return this;
    }

    public RegistrationPage chooseSubmit() {
        $("#submit").click();
        return this;
    }
    public RegistrationPage setCalendarDate(String day, String month, String year) {
        $("#dateOfBirthInput").click();
        calendarComponents.setDate(day, month, year);
        return this;
    }
    public RegistrationPage visibleModalResults(){
        registrationResultModal.verifyModalVisible();
        return this;
    }
    public RegistrationPage checkResult(String key, String value){
        registrationResultModal.checkModalResults(key, value);
        return this;
    }
}
