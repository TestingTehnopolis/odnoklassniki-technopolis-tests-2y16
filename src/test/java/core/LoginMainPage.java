package core;

import model.TestBot;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(LOGIN_FIELD));
        Assert.assertTrue("Не найден элемент создания группы", isElementVisible(LOGIN_FIELD));
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(PASSWORD_FIELD));
        Assert.assertTrue("Не найден элемент создания группы", isElementVisible(PASSWORD_FIELD));
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(LOGIN_BUTTON));
        Assert.assertTrue("Не найден элемент создания группы", isElementVisible(LOGIN_BUTTON));
    }

    public UserMainPage doLogin(TestBot testBot) {
        Assert.assertTrue("Не найдено поле ввода логина", isElementVisible(LOGIN_FIELD));
        Assert.assertTrue("Не найдено поле ввода пароля", isElementVisible(PASSWORD_FIELD));
        Assert.assertTrue("Не найдена кнопка аутентификации", isElementVisible(LOGIN_BUTTON));
        type(testBot.getLogin(), LOGIN_FIELD);
        type(testBot.getPassword(), PASSWORD_FIELD);
        click(LOGIN_BUTTON);
        return new UserMainPage(driver);
    }
}
