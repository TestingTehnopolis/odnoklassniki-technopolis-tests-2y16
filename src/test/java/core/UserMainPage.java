package core;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class UserMainPage extends HelperBase{

    private static final By BUTTON_GROUPS = By.xpath(".//*[@class='mctc_navMenuSec' and contains(@href,'groups')]");



    public UserMainPage(WebDriver driver) {
        super(driver);
    }

    protected void check() {
        Assert.assertTrue("Не дождались кнопки вкладки Группы",
                explicitWait(ExpectedConditions.visibilityOfElementLocated(BUTTON_GROUPS), 10, 500));

    }

    public void clickGroupsOnToolbar() {
        click(BUTTON_GROUPS);
    }
}
