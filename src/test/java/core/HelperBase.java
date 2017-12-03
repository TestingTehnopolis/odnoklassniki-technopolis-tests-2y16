package core;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

import javax.xml.bind.Element;
import java.util.List;

/**
 * Created by nsuprotivniy on 02.11.17.
 */
public abstract class HelperBase {

    private static final By LOGO_LINK = By.xpath("//*[@id = 'toolbar_logo_id']");
    private static final By UCARD = By.xpath("//*[contains(@class, 'ucard-mini') and contains(@class, 'toolbar_ucard')]");
    private static final By LOGOUT_BUTTON = By.xpath("//*[contains(@data-l, 't,logoutCurrentUser')]");
    private static final By LOGOUT_CONFIRM = By.xpath("//*[contains(@data-l, 't,confirm') and contains(@value, 'Выйти')]");

    protected WebDriver driver;

    public HelperBase(WebDriver driver) {
        this.driver = driver;
        check();
    }

    protected abstract void check();

    protected void type(String text, By locator) {
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(text);
    }

    protected void click(By locator) {
        driver.findElement(locator).click();
    }

    protected boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    protected boolean isElementPresent(WebElement el, By by) {
        try {
            el.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    protected WebElement getElement(By path) {
        return driver.findElement(path);
    }

    protected List<WebElement> getElements(By path) {
        return driver.findElements(path);
    }

    protected Actions getActions() {
        return new Actions(driver);
    }

    public UserMainPage mainPage() {
        Assert.assertTrue("Не найдена ссылка логотипа", isElementPresent(LOGO_LINK));
        click(LOGO_LINK);
        return new UserMainPage(driver);
    }

    public LoginMainPage logout() {
        Assert.assertTrue("Не найдена иконка пользователя в тулбаре", isElementPresent(UCARD));
        click(UCARD);
        Assert.assertTrue("Не найдена кнопка выхода", isElementPresent(LOGOUT_BUTTON));
        click(LOGOUT_BUTTON);
        Assert.assertTrue("Не найдена кнопка подтверждения выхода", isElementPresent(LOGOUT_CONFIRM));
        click(LOGOUT_CONFIRM);
        return new LoginMainPage(driver);
    }
}