package tests;

import core.*;
import model.TestBot;
import org.junit.Assert;
import org.junit.Test;
import java.io.IOException;
import java.util.List;

/*
    Группа тестов, проверяющая создание групп.
 */
public class CreateGroupTest extends TestBase {

    /*
        Smoke-тест создания групп.
        Тест проходит аутентификацию, переходит в группы, нажимает создание новой группы,
        выбирает тип группы "Публичная страница", заполняет поле названия группы, создаёт группу,
        проверяет, что был произведён переход на страницу новой группы.
        Все assert-ы находятся в проверках элементов страниц.
     */
    @Test
    public void createPublicPage() throws IOException {
        new LoginMainPage(driver)
                .doLogin(new TestBot("config/auth.conf"))
                .clickGroupsOnToolbar()
                .clickCreateGroup()
                .chooseGroup(NewGroupLayer.GroupsTypes.INTEREST_GROUP)
                .typeGroupName("New group 1")
                .create();
    }

    /*
        Тест проходит аутентификацию пользователя, проверяет количество групп пользователя в тулбаре,
         создаёт новую группу, переаутентифицируется, проверяет, что количество групп увеличилось на один.
     */
    @Test
    public void checkCounter() throws IOException {
        TestBot testBot = new TestBot("config/auth.conf");
        UserMainPage mainPage = new LoginMainPage(driver)
                .doLogin(testBot);

        int old_counter = mainPage.checkGroupsCounter();

        mainPage = mainPage
                .clickGroupsOnToolbar()
                .clickCreateGroup()
                .chooseGroup(NewGroupLayer.GroupsTypes.INTEREST_GROUP)
                .typeGroupName("New group 2")
                .create()
                .logout()
                .doLogin(testBot);


        int new_counter = mainPage.checkGroupsCounter();

        Assert.assertTrue("Счётчик групп не уменьшился", new_counter - old_counter == 1);
    }

    /*
        Тест проверки появления ошибки при неверно заданных полях формы создания группы.
        Происходит аутентификация, переход к созданию групп, выбирается тип "Мероприятие",
        поля не заполняются, нажимается кнопка создания, проверяется промис о появлении ошибки пустого поля.
     */
    @Test
    public void invalidParameters() throws IOException {
        GroupFormLayer performance = new LoginMainPage(driver)
                .doLogin(new TestBot("config/auth.conf"))
                .clickGroupsOnToolbar()
                .clickCreateGroup()
                .chooseGroup(NewGroupLayer.GroupsTypes.PERFORMANCE);

        performance.clickCreateButton().andNameErrorPresent();
    }

    /*
    Тест проверяет появление созданной группы в списке групп пользователя.
    */
    @Test
    public void groupsListTest() throws IOException {

        String groupName = "New group 1";

        UserMainPage userMainPage = new LoginMainPage(driver)
                .doLogin(new TestBot("config/auth.conf"))
                .clickGroupsOnToolbar()
                .clickCreateGroup()
                .chooseGroup(NewGroupLayer.GroupsTypes.INTEREST_GROUP)
                .typeGroupName(groupName)
                .create()
                .mainPage();

        List<UserGroupWrapper> groups = userMainPage
                .clickGroupsOnToolbar()
                .clickMyGroups()
                .getGroups();

        boolean present = false;
        for (UserGroupWrapper group : groups) {
            if (group.getName().equals(groupName)) {
                present = true;
                break;
            }
        }
        Assert.assertTrue("Созданная группа не появилась в списке групп пользователей", present);
    }
}
