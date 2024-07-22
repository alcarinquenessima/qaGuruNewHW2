package pages.components;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Condition.text;
import com.codeborne.selenide.SelenideElement;


public class CheckResultComponent {
    private final SelenideElement resultsTable = $(".table");

    public void checkResults(String key, String value) {
        resultsTable.shouldHave(text(key + " " + value));
    }
}