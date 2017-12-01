package core;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Класс предоставляет методы для ввода данных на странице регистрации.
 */
public class RegistrateMainPage extends PageBase {

    //базовый элементы страницы
    private static final By PIC_LOGO = By.xpath(".//a[contains(@class, 'anonym_logo') and @href='/']");

    /**
     * tbd add locale
     * ".//span[contains(@class, 'input-d') and contains(text(), 'Далее') and contains(text(), 'соглашаетесь')]")
     */
    //базовый элементы страницы
    private static final By LBL_ACCEPT_REGLAMENT  = By.xpath(".//span[contains(@class, 'input-d')]");
    //базовый элементы страницы
    private static final By  LBL_PHONE_NUMBER= By.xpath(".//label[contains(@for, 'field_phone')]");


    private static final By  BTN_NEXT = By.xpath(
            ".//input[contains(@class, 'js-proceed-registration') and contains(@value, 'Далее')]");
    private static final By  LBL_WRONG_NUMBER = By.xpath(
            ".//span[contains(@class, 'input-e') and contains(text(), 'Неправильный номер телефона')]");
    private static final By  AREA_INPUT_PHONE_NUMBER = By.xpath(
            ".//input[contains(@id, 'field_phone') and @value='+7']");
    private static final By  LBL_NOT_FULL_PHONE_NUMBER = By.xpath(
            ".//span[contains(@class, 'input-e') and text()='Осталось ввести 5 цифр.']");


    public RegistrateMainPage(WebDriver driver) {
        super(driver);
        check();
    }


    @Override
    protected void check() {
        Assert.assertTrue("Не дождались появления логотипа",
                explicitWait(ExpectedConditions.visibilityOfElementLocated(PIC_LOGO), 10, 500));
        Assert.assertTrue("Не дождались появления сообщения о согласии с регламентом",
                explicitWait(ExpectedConditions.visibilityOfElementLocated(LBL_ACCEPT_REGLAMENT), 10, 500));
        Assert.assertTrue("Не дождались появления лейбла номер телефона",
                explicitWait(ExpectedConditions.visibilityOfElementLocated(LBL_PHONE_NUMBER), 10, 500));

    }

    public RegistrateMainPage clickNext() {
        Assert.assertTrue("Не дождались появления кнопки далее",
                explicitWait(ExpectedConditions.visibilityOfElementLocated(BTN_NEXT), 10, 500));
        click(BTN_NEXT);
        return this;
    }

    public RegistrateMainPage checkWarningWrongNumberAppearence() {
        Assert.assertTrue("Не дождались появления предупреждения о неправильном номере телефона",
                explicitWait(ExpectedConditions.visibilityOfElementLocated(LBL_WRONG_NUMBER), 10, 500));
        return this;
    }

    public RegistrateMainPage typePartOfPhoneNumber(String phoneNumber, boolean clearAreaFirstly) {
        Assert.assertTrue("Не дождались появления поля для ввода телефона",
                explicitWait(ExpectedConditions.visibilityOfElementLocated(AREA_INPUT_PHONE_NUMBER), 10, 500));
        type(phoneNumber, AREA_INPUT_PHONE_NUMBER, clearAreaFirstly);
        return this;
    }

    public RegistrateMainPage checkWarningNotFullPhoneNumber() {
        Assert.assertTrue("Не дождались появления предупреждения о некорректом номере телефона",
                explicitWait(ExpectedConditions.visibilityOfElementLocated(LBL_NOT_FULL_PHONE_NUMBER), 10, 500));
        return this;
    }
}

