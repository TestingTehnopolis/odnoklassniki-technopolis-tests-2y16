package core;

import model.TestBot;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by nsuprotivniy on 02.11.17.
 */
public class LoginMainPage extends HelperBase {

    static final By LOGIN_FIELD =  By.id("field_email");
    static final By PASSWORD_FIELD =  By.id("field_password");
    static final By LOGIN_BUTTON = By.cssSelector("div.form-actions > div > .button-pro");

    public LoginMainPage(WebDriver driver) { super(driver); }

    @Override
    protected void check() {

    }

    public UserMainPage doLogin(TestBot testBot) {
        Assert.assertTrue("Не найдено поле ввода логина", isElementPresent(LOGIN_FIELD));
        Assert.assertTrue("Не найдено поле ввода пароля", isElementPresent(PASSWORD_FIELD));
        Assert.assertTrue("Не найдена кнопка аутентификации", isElementPresent(LOGIN_BUTTON));
        type(testBot.getLogin(), LOGIN_FIELD);
        type(testBot.getPassword(), PASSWORD_FIELD);
        click(LOGIN_BUTTON);
        return new UserMainPage(driver);
    }
}
