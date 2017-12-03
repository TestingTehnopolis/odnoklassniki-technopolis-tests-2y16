package tests;

import core.OKMainPage;
import core.RegistrateMainPage;
import core.TestBase;
import org.junit.Test;

/**
 * Класс предназначен для поверки валидации полей пользовательского ввода на странице регистрации.
 * TestCase #5 в моем документе в папке https://drive.google.com/drive/folders/0B9vP3_6a1ROLeW9xYmFwVEVhYjQ
 */
public class TestCase5 extends TestBase {

    @Test
    public void testUserInputValidationRegistration() {
        new OKMainPage(driver).doRegistrate();
        new RegistrateMainPage(driver)
                .clickNext()
                .checkWarningWrongNumberAppearence()
                .typePartOfPhoneNumber("56764", false)
                .checkWarningNotFullPhoneNumber();
    }
}
