package tests;

import core.TestBase;
import core.page.CurrentGroupMainPage;
import core.page.LoginMainPage;
import model.TestBot;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;

/**
 * Тест меняет название выбранно группы
 * и проверяет, что название действительно изменилось
 */
public class FifthTest extends TestBase {

    private final String GROUP_URL = "https://www.ok.ru/group/55228108832779";
    private final String NEW_NAME = "hello new name";

    @Test
    public void changeGroupName() {
        new LoginMainPage(driver).doLogin(
                new TestBot("technopolisBot2", "technopolis16"));
        driver.navigate().to(GROUP_URL);

        CurrentGroupMainPage currGroup = new CurrentGroupMainPage(driver);

        String oldGroupName = currGroup.getGroupName();

        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("window.scrollBy(0,200)", "");

        currGroup.clickGroupSettings();
        Assert.assertEquals(true,
                driver.getCurrentUrl().matches("https://www\\.ok\\.ru/group/\\d+/settings"));

        currGroup.changeGroupName(NEW_NAME);
        jse.executeScript("window.scrollBy(0,100)", "");

        currGroup.saveSettings();
        driver.navigate().to(GROUP_URL);

        Assert.assertNotEquals(oldGroupName, currGroup.getGroupName());
        Assert.assertEquals(NEW_NAME, currGroup.getGroupName());
    }

}
