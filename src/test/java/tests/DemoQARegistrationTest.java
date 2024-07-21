package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

public class DemoQARegistrationTest extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();
    @Test
    void fillFormTest() {
        registrationPage.openPage()
                        .setName("Ivan")
                        .setSurname("Ivanov")
                        .setEmail("ivanIvanov@gmail.com")
                        .setGender("Other")
                        .setNumber("8999888998")
                        .setDate("2", "August", "2000")
                        .setSubject("Chemistry")
                        .setHobbies("Reading")
                        .uploadPicture("mushroom.jpg")
                        .setAddress("Russia")
                        .setState("Haryana")
                        .setCity("Karnal")
                        .submitInfo()
                        .checkResults ();
    }
    @Test
    void onlyNecessaryFormsRegistrationTest() {
        registrationPage.openPage()
                .setName("Ivan")
                .setSurname("Ivanov")
                .setGender("Other")
                .setNumber("8999888998")
                .setDate("2", "August", "2000")
                .submitInfo()
                .checkResultsOnlyNecessaryForms ();
    }
    @Test
    void NegativeRegistrationTest (){
        registrationPage.openPage()
                .setName("Ivan")
                .setSurname("Ivanov")
                .setGender("Other")
                .setNumber("Not number")
                .setDate("2", "August", "2000")
                .submitInfo()
                .checkErrors();
    }
}
