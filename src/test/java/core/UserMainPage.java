package core;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by nsuprotivniy on 02.11.17.
 */
public class UserMainPage extends HelperBase {

    private static final By GROUPS_ON_TOOLBAR = By.xpath(".//*[@class='mctc_navMenuSec' and contains(@href,'groups')]");
    private static final By GROUPS_COUNTER = By.xpath("//*[@class='mctc_navMenuSec' and contains(@href,'groups')]//*[contains(@class,'navMenuCount')]");

    public UserMainPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected void check() {
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(GROUPS_ON_TOOLBAR) );
    }

    public GroupMainPage clickGroupsOnToolbar() {
        Assert.assertTrue("Не найдена ссылка на группы в тулбаре", isElementPresent(GROUPS_ON_TOOLBAR));
        click(GROUPS_ON_TOOLBAR);
        return new GroupMainPage(driver);
    }

    public int checkGroupsCounter() {
        Assert.assertTrue("Не найден счётчик групп", isElementPresent(GROUPS_COUNTER));
        WebElement counter = getElement(GROUPS_COUNTER);
        return Integer.parseInt(counter.getText());
    }
}
