package testcases;

import org.junit.jupiter.api.Test;

public class PageObjectsPracticeForm extends TestBase {


    @Test
    void workPracticeForm() {
        String firstName = "Artur",
                lastName = "Cherepanov",
                userEmail = "art.cherepanov@yandex.ru",
                userNumber = "7912887728",
                currentAddress = "Big Willy Road 155/2",
                subjectItem = "Physics",
                pickState = "Haryana",
                pickCity = "Panipat";

        regPage.openPage()


                //Внести данные в форму
                .setFirstName(firstName)
                .setLastName(lastName)
                .setUserEmail(userEmail)
                .setGender("Male")
                .setUserNumber(userNumber)
                .setCalendarDate("07", "February", "1990")
                .setSubjectsItem(subjectItem)
                .setHobbiesItem("Reading")
                .contributePictures()
                .setCurrentAddress(currentAddress)
                .chooseState(pickState)
                .chooseCity(pickCity)
                .chooseSubmit()


                //Проверка заполненной формы
                .visibleModalResults()
                .checkResult("Student Name", firstName + " " + lastName)
                .checkResult("Student Email", userEmail)
                .checkResult("Gender", "Male")
                .checkResult("Mobile", userNumber)
                .checkResult("Date of Birth", "07 February,1990")
                .checkResult("Subjects", subjectItem)
                .checkResult("Hobbies", "Reading")
                .checkResult("Picture", "фин_юмор2.jpg")
                .checkResult("Address", currentAddress)
                .checkResult("State and City", pickState + " " + pickCity);


    }
}

