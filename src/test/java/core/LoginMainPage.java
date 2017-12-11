package core;

import model.TestBot;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginMainPage extends HelperBase{
    private static final By LOGIN_BUTTON = By.xpath(".//*[contains(@data-l,'loginButton')]");

    private static final String LOGIN_EMAIL_ID = "field_email";
    private static final String LOGIN_PASSWORD_ID = "field_password";

    public LoginMainPage(WebDriver driver) {
        super(driver);
    }

    protected void check() {
        Assert.assertTrue("Не дождались кнопки логина",
                explicitWait(ExpectedConditions.visibilityOfElementLocated(LOGIN_BUTTON), 10, 500));
    }

    public UserMainPage doLogin(TestBot testBot) {
        type(testBot.getLogin(), By.id(LOGIN_EMAIL_ID));
        type(testBot.getPassword(), By.id(LOGIN_PASSWORD_ID));
        click(LOGIN_BUTTON);
        return new UserMainPage(driver);
    }
}
