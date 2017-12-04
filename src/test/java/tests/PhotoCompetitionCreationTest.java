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
        final String login = "technopolisbot3";
        final String password = "technopolis16";
        final String groupID = "55238522503180";
        final String competitionName = "Unexpected photo competition name";
        final String datePattern = "dd.MM.yyyy";

        // логин
        new LoginMainPage(driver).doLogin(new TestBot(login, password));

        // переход на страницу групп
        new UserMainPage(driver).clickGroupsOnToolbar();
        GroupMainPage groupMainPage = new GroupMainPage(driver);

        // переход на страницу конкретной группы
        groupMainPage.clickGroupByID(groupID);

        GroupSpecificPage groupSpecificPage = new GroupSpecificPage(driver);

        // инициируем создание фотоконкурса
        groupSpecificPage.clickCreatePhotoCompetition();
        // вводим название
        groupSpecificPage.typePhotoCompetitionName(competitionName);
        // вводим текущую дату как дату окончания
        groupSpecificPage.typePhotoCompetitionTillDate(new SimpleDateFormat(datePattern).format(new Date()));

        Thread.sleep(1000);
        // создаем фотоконкурс
        groupSpecificPage.clickCreatePhotoCompetitionButton();

        // после создания фотоконкурса должен состояться переход на страницу с альбомом фотоконкурса
        GroupSpecificAlbumPage groupSpecificAlbumPage = new GroupSpecificAlbumPage(driver);
        Thread.sleep(1000);

        // ищем название фотоконкурса (совпадает с названием альбома) на странице
        Assert.assertTrue("Альбом с названием фотоконкурса не найден", groupSpecificAlbumPage.isAlbumNamePresent(competitionName));
    }
}