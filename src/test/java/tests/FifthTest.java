package tests;

import core.TestBase;
import core.page.CurrentGroupMainPage;
import core.page.LoginMainPage;
import model.TestBot;
import org.junit.Test;
import org.testng.Assert;
import java.util.Random;

/**
 * Тест меняет название выбранно группы
 * и проверяет, что название действительно изменилось
 */
public class FifthTest extends TestBase {
    private final String GROUP_URL = "https://www.ok.ru/group/55228108832779";
    private final String botLogin = "technopolisBot2";
    private final String botPassword = "technopolis16";

    @Test
    public void changeGroupName() {
        new LoginMainPage(driver).doLogin(
                new TestBot(botLogin, botPassword));
        String newGroupName = getRandomName(30);

        driver.navigate().to(GROUP_URL);
        CurrentGroupMainPage currGroup = new CurrentGroupMainPage(driver);
        String oldGroupName = currGroup.getGroupName();

        currGroup.clickGroupSettings();
        Assert.assertEquals(true,
                driver.getCurrentUrl().matches("https://www\\.ok\\.ru/group/\\d+/settings"));

        currGroup.changeGroupName(newGroupName);
        currGroup.saveSettings();
        driver.navigate().to(GROUP_URL);

        Assert.assertNotEquals(oldGroupName, currGroup.getGroupName());
        Assert.assertEquals(newGroupName, currGroup.getGroupName());
    }

    String getRandomName(int len) {
        String temp = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder sb = new StringBuilder();
        Random rnd = new Random();

        for (int i = 0; i < len ; i++) {
            sb.append(
                temp.charAt(rnd.nextInt(temp.length()))
            );
        }

        return sb.toString();
    }
}
