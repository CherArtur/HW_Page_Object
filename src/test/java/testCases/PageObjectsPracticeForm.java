package testCases;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PageObjectsPracticeForm  extends TestBase {


    @Test
    void workPracticeForm() {
        String firstName = "Artur",
                lastName = "Cherepanov",
                userEmail = "art.cherepanov@yandex.ru",
                userNumber = "7912887728",
                currentAddress = "Big Willy Road 155/2";

        regPage.openPage();


        //Внести данные в форму
        regPage.setFirstName(firstName);
        regPage.setLastName(lastName);
        regPage.setUserEmail(userEmail);
        regPage.setGender("Male");
        regPage.setUserNumber(userNumber);
        regPage.setCalendarDate("07","February","1990");

        $("#subjectsInput").setValue("Physic").pressEnter();
        $("#hobbiesWrapper").$(byText("Reading")).click();
        $("#uploadPicture").uploadFromClasspath("Pictures/фин_юмор2.jpg");
        regPage.setCurrentAddress(currentAddress);
        $("#state").click();
        $("#state").$(byText("Haryana")).click();
        $("#city").click();
        $("#city").$(byText("Panipat")).click();
        $("#submit").click();

        //Проверка заполненной формы
        regPage.visibleModalResults();
        regPage.checkResult("Student Name", firstName + lastName);
        regPage.checkResult("Student Email", userEmail);
        regPage.checkResult("Gender", "Male");
        regPage.checkResult("Mobile", userNumber);
        regPage.checkResult("Date of Birth", "07 February,1990");
        regPage.checkResult("Subjects", "Physics");
        regPage.checkResult("Hobbies", "Reading");
        regPage.checkResult("Picture", "фин_юмор2.jpg");
        regPage.checkResult("Address", currentAddress);
        regPage.checkResult("State and City", "Haryana Panipat");


    }
}

