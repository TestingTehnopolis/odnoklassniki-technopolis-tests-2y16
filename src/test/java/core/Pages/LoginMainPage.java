package core.Pages;

import core.HelperBase;
import model.TestBot;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginMainPage extends HelperBase {

    private static final By LOGIN_FIELD = By.id("field_email");
    private static final By PASSWORD_FIELD = By.id("field_password");
    private static final By LOGIN_BUTTON = By.xpath(".//*[contains(@data-l,'loginButton')]");

    public LoginMainPage(WebDriver driver) {
        super(driver);
    }

    protected void check() {
        Assert.assertTrue("Нет поля логина",
                explicitWait(ExpectedConditions.visibilityOfElementLocated(LOGIN_FIELD), timeOutInSeconds, sleepInMilliSeconds));
        Assert.assertTrue("Нет поля пароля",
                explicitWait(ExpectedConditions.visibilityOfElementLocated(PASSWORD_FIELD), timeOutInSeconds, sleepInMilliSeconds));
        Assert.assertTrue("Нет кнопки логина",
                explicitWait(ExpectedConditions.visibilityOfElementLocated(LOGIN_BUTTON), timeOutInSeconds, sleepInMilliSeconds));
    }

    public UserMainPage doLogin(TestBot testBot) { // Думаю нет смысла дробить метод, т.к. эти поля нет смысла использовать по другому
        Assert.assertTrue("Нет поля логина", isElementVisible(LOGIN_FIELD));
        type(testBot.getLogin(), LOGIN_FIELD);
        Assert.assertTrue("Нет поля пароля", isElementVisible(PASSWORD_FIELD));
        type(testBot.getPassword(), PASSWORD_FIELD);
        Assert.assertTrue("Нет кнопки логина", isElementVisible(LOGIN_BUTTON));
        click(LOGIN_BUTTON);
        return new UserMainPage(driver);
    }
}
