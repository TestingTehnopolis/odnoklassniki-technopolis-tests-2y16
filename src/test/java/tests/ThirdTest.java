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
    private final String TOPIC_MESSAGE = "privet strannik ;)";

    @Test
    public void postInGroupCreation() {
        new LoginMainPage(driver).doLogin(
                new TestBot("technopolisBot2", "technopolis16"));
        driver.navigate().to(GROUP_URL);

        CurrentGroupMainPage currGroup = new CurrentGroupMainPage(driver);

        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("window.scrollBy(0,400)", "");

        currGroup.clickCreateNewTopic();
        currGroup.printTextTopic(TOPIC_MESSAGE);
        currGroup.clickShareTopic();

        Assert.assertEquals(TOPIC_MESSAGE, currGroup.getFirstPostTest());
    }

}
