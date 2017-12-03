package core;

import model.TestBot;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Класс предоставляет методы для действий(переход на страницу регистрации, вход для зарегистрированного пользователя)
 * на главной странице - ok.ru/.
 */
public class OKMainPage extends PageBase {

    //базовые эемпенты страницы
    private static final By PIC_LOGO = By.xpath(".//a[contains(@class, 'anonym_logo') and @href='/']");
    //tbd ".//label[contains(@for, 'field_email') and contains(text(), 'Логин, адрес почты или телефон')]"
    private static final By LBL_LOGIN = By.xpath(
            ".//label[contains(@for, 'field_email')]");
    //tbd ".//label[contains(@for, 'field_password') and contains(text(), 'Пароль')]"
    private static final By LBL_PSWD = By.xpath(
            ".//label[contains(@for, 'field_password')]");


    private static final By BTN_REGISTRATE = By.xpath(".//a[contains(@class, 'registration')]");
    private static final By LAYER_CHOOSE_LANGUAGE = By.xpath(".//div[contains(@class, 'modal-new_cnt')]");
    private static final By BTN_SELECT_LANGUAGE = By.xpath(
            ".//a[contains(@class, 'h-mod')]//span[contains(@class, 'tico')]");
    private static final By HREF_RUS_LANGUAGE = By.xpath(
            ".//a[contains(@class, 'sel-lang_i o') and text()='Русский']");


    public OKMainPage(WebDriver driver) {
        super(driver);
    }

    public void doRegistrate() {
        Assert.assertTrue("Не дождались появления кнопки регистрация",
                explicitWait(ExpectedConditions.visibilityOfElementLocated(BTN_REGISTRATE), 10, 500));
        click(BTN_REGISTRATE);
    }

    public void doLogin(TestBot testBot) {
        type(testBot.getLogin(), By.id("field_email"));
        type(testBot.getPassword(), By.id("field_password"));
        click(By.xpath(".//*[contains(@data-l,'loginButton')]"));
    }

    @Override
    protected void check() {
        Assert.assertTrue("Не дождались появления логотипа",
                explicitWait(ExpectedConditions.visibilityOfElementLocated(PIC_LOGO), 10, 500));
        Assert.assertTrue("Не дождались появления лейбла приглашающего ввести логин/...",
                explicitWait(ExpectedConditions.visibilityOfElementLocated(LBL_LOGIN), 10, 500));
        Assert.assertTrue("Не дождались появления лейбла приглашающего ввести пароль",
                explicitWait(ExpectedConditions.visibilityOfElementLocated(LBL_PSWD), 10, 500));

    }

    public OKMainPage checkLayerAppearance() {
        Assert.assertTrue("Не дождались появления лейера со списком языков",
                explicitWait(ExpectedConditions.visibilityOfElementLocated(LAYER_CHOOSE_LANGUAGE), 10, 500));
        return this;
    }

    public OKMainPage clickSelectLanguageBtn() {
        Assert.assertTrue("Не дождались появления кнопки открытия лейера с возможными языками интерфейса",
                explicitWait(ExpectedConditions.visibilityOfElementLocated(BTN_SELECT_LANGUAGE), 10, 500));
        click(BTN_SELECT_LANGUAGE);
        return this;
    }

    public OKMainPage selectLanguage() {
        Assert.assertTrue("Не дождались появления ссылки для выбора русского языка",
                explicitWait(ExpectedConditions.visibilityOfElementLocated(HREF_RUS_LANGUAGE), 10, 500));
        click(HREF_RUS_LANGUAGE);
        return this;
    }
}
