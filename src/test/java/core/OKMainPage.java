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

    private static final By BTN_REGISTRATE = By.xpath(".//a[contains(@class, 'registration')]");
    private static final By LAYER_CHOOSE_LANGUAGE = By.xpath(".//div[contains(@class, 'modal-new_cnt')]");
    private static final By BTN_SELECT_LANGUAGE = By.xpath(
            ".//a[contains(@class, 'h-mod')]//span[contains(@class, 'tico')]");
    private static final By HREF_RUS_LANGUAGE = By.xpath(
            ".//a[contains(@class, 'sel-lang_i o') and text()='Русский']");
    private static final By BTN_CONFIRM_EXIT = By.xpath(".//input[@id='hook_FormButton_logoff.confirm_not_decorate']");


    public OKMainPage(WebDriver driver) {
        super(driver);
    }

    public OKMainPage doRegistrate() {
        Assert.assertTrue("Не появилась кнопка \"Регистрация\"",
                isElementVisible(BTN_REGISTRATE));
        click(BTN_REGISTRATE);

        return this;
    }

    public OKMainPage doLogin(TestBot testBot) {
        Assert.assertTrue("Не появилось поле для ввода имени/электронной почты/... пользователя",
                isElementVisible(By.id("field_email")));
        type(testBot.getLogin(), By.id("field_email"));

        Assert.assertTrue("Не появилось поле для ввода пароля",
                isElementVisible(By.id("field_password")));
        type(testBot.getPassword(), By.id("field_password"));

        Assert.assertTrue("Не появилось кнопка для входа в аккаунт",
                isElementVisible(By.xpath(".//*[contains(@data-l,'loginButton')]")));
        click(By.xpath(".//*[contains(@data-l,'loginButton')]"));

        return this;
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

    @Override
    protected void check() {
        Assert.assertTrue("Не дождались появления логотипа",
                explicitWait(ExpectedConditions.visibilityOfElementLocated(PIC_LOGO), 10, 500));
    }
}
