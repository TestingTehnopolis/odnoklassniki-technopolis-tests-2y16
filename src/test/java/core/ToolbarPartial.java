package core;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ToolbarPartial extends HelperBase {
    private static final By HOME_LINK = By.xpath(".//*[@id='toolbar_logo_id']");

    public ToolbarPartial(WebDriver driver) {
        super(driver);
    }

    protected void check() {
        Assert.assertTrue("Не дождались отображения лого",
                explicitWait(ExpectedConditions.visibilityOfElementLocated(HOME_LINK), 10, 500));
    }

    /**
     * Нажимаем кнопку перехода на домашнюю страницу
     */
    public UserMainPage clickHome() {
        click(HOME_LINK);
        return new UserMainPage(driver);
    }
}

