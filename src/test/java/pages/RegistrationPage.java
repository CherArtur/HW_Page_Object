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

    public void openPage() {
        //Открыть страницу Practice Form
        open("/automation-practice-form");
        $(".main-header").shouldHave(text(titleText));
        //Убрать рекламу и футер
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
    }

    public void setFirstName(String value) {
        $("#firstName").setValue(value);
    }
    public void setLastName(String value) {
        $("#lastName").setValue(value);
    }
    public void setUserEmail(String value) {
        $("#userEmail").setValue(value);
    }
    public void setGender(String value) {
        $("#genterWrapper").$(byText(value)).click();
    }
    public void setUserNumber(String value) {
        $("#userNumber").setValue(value);
    }
    public void setCurrentAddress(String value) {
        $("#currentAddress").setValue(value);
    }
    public void setCalendarDate(String day, String month, String year) {
        $("#dateOfBirthInput").click();
        calendarComponents.setDate(day, month, year);
    }
    public void visibleModalResults(){
        registrationResultModal.verifyModalVisible();
    }
    public void checkResult(String key, String value){
        registrationResultModal.checkModalResults(key, value);
    }
}
