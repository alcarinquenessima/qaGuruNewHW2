package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.CheckResultComponent;


import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {
    private final SelenideElement nameInput = $("#firstName");
    private final SelenideElement surnameInput = $("#lastName");
    private final SelenideElement emailInput = $("#userEmail");
    private final SelenideElement genderChoosing = $("#genterWrapper");
    private final SelenideElement numberInput =  $("#userNumber");
    private final SelenideElement pictureUpload = $("#uploadPicture");
    private final SelenideElement hobbyChoosing = $("#hobbiesWrapper");
    private final SelenideElement subjectInput =  $("#subjectsInput");
    private final SelenideElement address = $("#currentAddress");
    private final SelenideElement stateInput = $("#state");
    private final SelenideElement cityInput = $("#city");
    private final SelenideElement submitButton = $("#submit");
    private final SelenideElement resultsTable = $(".table");


    CalendarComponent calendarComponent = new CalendarComponent();
    CheckResultComponent checkResultComponent = new CheckResultComponent();
    public static SelenideElement dateInput = $("#dateOfBirthInput");

    private String fullNameCheck;
    private String emailCheck;
    private String genderCheck;
    private String numberCheck;
    private String birthDateCheck;
    private String subjectCheck;
    private String hobbyCheck;
    private String addressCheck;
    private String stateCityCheck;
    private String pictureCheck;


    public RegistrationPage removeBanner() {
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }
    public RegistrationPage openPage (){
        open("/automation-practice-form");
        return this;
    }
    public RegistrationPage setName (String value) {
        nameInput.setValue(value);
        fullNameCheck = value;
        return this;
    }
    public RegistrationPage setSurname (String value) {
        surnameInput.setValue(value);
        fullNameCheck = fullNameCheck + " " + value;
        return this;
    }
    public RegistrationPage setEmail (String value) {
        emailInput.setValue(value);
        emailCheck = value;
        return this;
    }
    public RegistrationPage setGender (String value){
        genderChoosing.$(byText(value)).click();
        genderCheck = value;
        return this;
    }
    public RegistrationPage setNumber (String value){
        numberInput.setValue(value);
        numberCheck = value;
        return this;
    }
    public RegistrationPage setDate (String day, String month, String year){
        dateInput.click();
        calendarComponent.setDate(day, month, year);
        birthDateCheck = day + " " + month + "," + year;
        return this;
    }
    public RegistrationPage uploadPicture (String value) {
        pictureUpload.uploadFromClasspath(value);
        pictureCheck = value;
        return this;
    }
    public RegistrationPage setSubject (String value){
        subjectInput.setValue(value).pressEnter();
        subjectCheck = value;
        return this;
    }
    public RegistrationPage setHobbies (String value){
        hobbyChoosing.$(byText(value)).click();
        hobbyCheck = value;
        return this;
    }
    public RegistrationPage setAddress (String value) {
        address.setValue(value);
        addressCheck = value;
        return this;
    }
    public RegistrationPage setState (String value) {
        stateInput.click();
        stateInput.$(byText(value)).click();
        stateCityCheck = value;
        return this;
    }
    public RegistrationPage setCity (String value) {
        cityInput.click();
        cityInput.$(byText(value)).click();
        stateCityCheck = stateCityCheck + " " + value;
        return this;
    }
    public RegistrationPage submitInfo() {
        submitButton.click();
        return this;
    }

    public RegistrationPage checkResults (String key, String value) {
        checkResultComponent.checkResults(key, value);
        return this;
    }

    public void checkErrors () {
        resultsTable.shouldNotBe(visible);
    }

}
