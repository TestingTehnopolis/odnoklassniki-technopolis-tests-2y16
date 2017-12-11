package tests;

import core.GroupMainPage;
import core.GroupSpecificPage;
import core.GroupSpecificAlbumPage;
import core.LoginMainPage;
import core.TestBase;
import core.UserMainPage;
import model.TestBot;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;
import java.text.SimpleDateFormat;

public class PhotoCompetitionCreationTest extends TestBase {

    /*
     Создание фотоконкурса в группе.
     */
    @Test
    public void testPhotoCompetitionCreation() throws Exception {
        final String login = "technopolisbot5";
        final String password = "technopolis16";
        final String groupID = "55240793718798";
        final String competitionName = "Unexpected photo competition name";
        final String datePattern = "dd.MM.yyyy";

        // логин и переход на страницу пользователя
        UserMainPage userMainPage = new LoginMainPage(driver).doLogin(new TestBot(login, password));

        // переход на страницу групп
        GroupMainPage groupMainPage = userMainPage.clickGroupsOnToolbar();

        // переход на страницу конкретной группы
        GroupSpecificPage groupSpecificPage = groupMainPage.clickGroupByID(groupID);

        // инициируем создание фотоконкурса
        groupSpecificPage.clickCreatePhotoCompetition();

        // вводим название
        groupSpecificPage.typePhotoCompetitionName(competitionName);
        // вводим текущую дату как дату окончания
        groupSpecificPage.typePhotoCompetitionTillDate(new SimpleDateFormat(datePattern).format(new Date()));

        // создаем фотоконкурс, после создания должен состояться переход на страницу с альбомом фотоконкурса
        GroupSpecificAlbumPage groupSpecificAlbumPage = groupSpecificPage.clickSubmitCreatePhotoCompetition();

        // ищем название фотоконкурса (совпадает с названием альбома) на странице
        Assert.assertTrue("Альбом с названием фотоконкурса не найден", groupSpecificAlbumPage.isAlbumNamePresent(competitionName));
    }
}