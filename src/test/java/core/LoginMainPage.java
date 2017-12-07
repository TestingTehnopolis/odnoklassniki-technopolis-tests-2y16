package core;

import model.TestBot;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginMainPage extends HelperBase{

    private static final By FIELD_EMAIL = By.id("field_email");
    private static final By FIELD_PASS = By.id("field_password");
    private static final By BUTTON_LOGIN = By.xpath(".//*[contains(@data-l,'loginButton')]");



    public LoginMainPage(WebDriver driver) {
        super(driver);
    }

    protected void check() {
        Assert.assertTrue("Не дождались поля ввода почты",
                explicitWait(ExpectedConditions.visibilityOfElementLocated(FIELD_EMAIL), 10, 500));

    }

    public void doLogin(TestBot testBot) {
        type(testBot.getLogin(), FIELD_EMAIL);
        type(testBot.getPassword(), FIELD_PASS);
        click(BUTTON_LOGIN);
    }
}
