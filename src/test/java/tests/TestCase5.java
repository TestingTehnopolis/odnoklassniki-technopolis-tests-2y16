package tests;

import core.OKMainPage;
import core.RegistrateMainPage;
import core.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Класс предназначен для поверки валидации полей пользовательского ввода на странице регистрации.
 * TestCase #5 в моем документе в папке https://drive.google.com/drive/folders/0B9vP3_6a1ROLeW9xYmFwVEVhYjQ
 */
public class TestCase5 extends TestBase {

    @Test
    public void testUserInputValidationRegistration() {
        new OKMainPage(driver)
                .doRegistrate();

        RegistrateMainPage mainPage = new RegistrateMainPage(driver)
            .clickNext();
        Assert.assertTrue("Не дождались появления предупреждения о неправильном номере телефона",
                mainPage.isWarningVisible());

        mainPage.typePartOfPhoneNumber("56764", false);
        Assert.assertTrue("Не дождались появления предупреждения о некорректом номере телефона",
                mainPage.isWarningNotFullPhoneVisible());
    }
}
