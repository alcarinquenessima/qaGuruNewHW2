package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

public class DemoQARegistrationTest extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();
    @Test
    void fillFormTest() {
        registrationPage.openPage()
                        .removeBanner ()
                        .setName("Ivan")
                        .setSurname("Ivanov")
                        .setEmail("ivanIvanov@gmail.com")
                        .setGender("Other")
                        .setNumber("8999888998")
                        .setDate("30", "August", "2000")
                        .setSubject("Chemistry")
                        .setHobbies("Reading")
                        .uploadPicture("mushroom.jpg")
                        .setAddress("Russia")
                        .setState("Haryana")
                        .setCity("Karnal")
                        .submitInfo()
                        .checkResults("Student Name", "Ivan Ivanov")
                        .checkResults("Student Email", "ivanIvanov@gmail.com")
                        .checkResults("Gender", "Other")
                        .checkResults("Mobile", "8999888998")
                        .checkResults("Date of Birth", "30 August,2000")
                        .checkResults("Subjects", "Chemistry")
                        .checkResults("Hobbies", "Reading")
                        .checkResults("Picture", "mushroom.jpg")
                        .checkResults("Address", "Russia")
                        .checkResults("State and City", "Haryana Karnal");
    }
    @Test
    void onlyNecessaryFormsRegistrationTest() {
        registrationPage.openPage()
                .removeBanner ()
                .setName("Ivan")
                .setSurname("Ivanov")
                .setGender("Other")
                .setNumber("8999888998")
                .setDate("20", "August", "2000")
                .submitInfo()
                .checkResults("Student Name", "Ivan Ivanov")
                .checkResults("Gender", "Other")
                .checkResults("Mobile", "8999888998")
                .checkResults("Date of Birth", "20 August,2000");
    }
    @Test
    void negativeRegistrationTest(){
        registrationPage.openPage()
                .removeBanner ()
                .setName("Ivan")
                .setSurname("Ivanov")
                .setGender("Other")
                .setNumber("Not number")
                .setDate("20", "August", "2000")
                .submitInfo()
                .checkErrors();
    }
}
