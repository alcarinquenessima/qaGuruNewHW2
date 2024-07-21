package pages.components;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Condition.text;
import com.codeborne.selenide.SelenideElement;


public class CheckResultComponent {
    private static SelenideElement tableContent = $(".table-hover");

    public void checkResults (String fullNameCheck, String  emailCheck,
                              String genderCheck, String numberCheck,
                              String birthDateCheck, String subjectCheck,
                              String hobbyCheck, String addressCheck,
                              String stateCityCheck)
    {
        tableContent.shouldHave(
            text(fullNameCheck),
            text(emailCheck),
            text(genderCheck),
            text(numberCheck),
            text(birthDateCheck),
            text(subjectCheck),
            text(hobbyCheck),
            text("mushroom.jpg"),
            text(addressCheck),
            text(stateCityCheck)
    );
    }
}
