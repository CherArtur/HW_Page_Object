package pages.components;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class RegistrationResultModal {
    public void verifyModalVisible(){
        $(".modal-content").shouldBe(visible);
        $(".modal-title").shouldHave(text("Thanks for submitting the form"));
    }
    public void checkModalResults(String key, String value){
        $(".table-responsive").$(byText(key)).parent()
                .shouldHave(text(value));
    }
}
