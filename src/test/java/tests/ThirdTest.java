package tests;

import core.TestBase;
import core.page.CurrentGroupMainPage;
import core.page.LoginMainPage;
import model.TestBot;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;

/**
 * Тест создает новый топик(пост) в группе с заданным текстом
 * и проверяет что он появился на стене сообщества
 */
public class ThirdTest extends TestBase {
    private final String GROUP_URL = "https://www.ok.ru/group/55228108832779";
    private final String TOPIC_MESSAGE = "privet strannik ;)12345345";
    private final String botLogin = "technopolisBot2";
    private final String botPassword = "technopolis16";

    @Test
    public void postInGroupCreation() {
        new LoginMainPage(driver).doLogin(
                new TestBot(botLogin, botPassword));
        driver.navigate().to(GROUP_URL);

        CurrentGroupMainPage currGroup = new CurrentGroupMainPage(driver);
        currGroup.clickCreateNewTopic();
        currGroup.printTextTopic(TOPIC_MESSAGE);
        currGroup.clickShareTopic();

        Assert.assertEquals(TOPIC_MESSAGE, currGroup.getFirstPostTest());
    }
}
