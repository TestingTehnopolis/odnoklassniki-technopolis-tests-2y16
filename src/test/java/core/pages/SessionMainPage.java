package core.pages;

import model.TestBot;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class SessionMainPage extends HelperBase {

    private static final By ANONYM_LOGO = By.xpath(".//*[@class='anonym_logo']");
    private static final By EMAIL_INPUT = By.id("field_email");
    private static final By PASSWORD_INPUT = By.id("field_password");
    private static final By LOGIN_BTN = By.xpath(".//*[contains(@data-l, 'loginButton')]");

    public SessionMainPage(WebDriver driver) {
        super(driver);
    }

    @Override
    void check() {
        Assert.assertTrue(new WebDriverWait(driver, 10).until(d -> isElementPresent(ANONYM_LOGO)));
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(ANONYM_LOGO));
    }

    public UserMainPage doLogin(TestBot testBot) {
        type(testBot.getLogin(), EMAIL_INPUT);
        type(testBot.getPassword(), PASSWORD_INPUT);
        click(LOGIN_BTN);
        return new UserMainPage(driver);
    }
}
