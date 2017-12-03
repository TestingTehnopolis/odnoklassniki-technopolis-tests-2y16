package tests;

import core.*;
import model.TestBot;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

/**
 * Это группа тестов, которая проверяет главную страницу групп пользователя.
 */
public class MainGroupPageTest extends TestBase {

    private GroupMainPage groupMainPage;

    /**
     * Метод аутентифицирует пользователя, переходит к главной странице пользователя и загружает главную страницу групп.
     */
    @Before
    public void gotoGroupMainPage() throws IOException {
        new LoginMainPage(driver).doLogin(new TestBot("config/auth.conf"));
        UserMainPage userMainPage = new UserMainPage(driver);
        userMainPage.clickGroupsOnToolbar();
        groupMainPage = new GroupMainPage(driver);
    }

    /**
     * Тест проверяет список популярных групп на главной странице.
     * Во время итерации по странице проверяется
     * наличие имени популярной группы и количества подписчиков.
     */
    @Test
    public void testGroupsList() {
        List<GroupWrapper> groups = groupMainPage.getGroups();
        for (GroupWrapper group : groups) {
            Assert.assertTrue("Group contains name", !group.getName().isEmpty());
            Assert.assertTrue("Group contains subscribers count", !group.getSubscribersCnt().isEmpty());
        }
    }

    /**
     * Тест проверяет список популярных групп на главной странице.
     * Происходит проверка, что количество популярных групп ненулевое.
     */
    @Test
    public void testGroupsAmount() {
        List<GroupWrapper> groups = groupMainPage.getGroups();
        int size = groups.size();
        Assert.assertTrue("It should contain at least one group", size > 0);
    }

    /**
     * Тест проверяет список популярных групп на главной странице.
     * Сохраняется текущее количество групп.
     * Затем происходит переход к последнему элементу вниз,
     * что должно приводить к загрузки новых популярных групп.
     * Проверяется, что количество групп увеличилось.
     *
     * @throws InterruptedException
     */
    @Test
    public void testGroupsAmountIncrease() throws InterruptedException {
        List<GroupWrapper> groups = groupMainPage.getGroups();
        int old_size = groups.size();
        groupMainPage.moveToGroup(groups.get(groups.size() - 1));
        Thread.sleep(1000);
        groups = groupMainPage.getGroups();
        Assert.assertTrue("Groups amount should have increased", groups.size() > old_size);
    }
}
