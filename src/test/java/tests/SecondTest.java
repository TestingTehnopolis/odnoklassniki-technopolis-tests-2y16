package tests;

import core.page.CurrentGroupMainPage;
import core.page.GroupMainPage;
import core.page.LoginMainPage;
import core.TestBase;
import core.page.UserMainPage;
import model.TestBot;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

/*
* Тест создает новую "Публичную страницу" с заданным
* именем и описанием.
* После проверяет что наш url изменился и наша новая группа
* имеет имя и описание такое, которое мы задали изначально.
* */
public class SecondTest extends TestBase {

    private final String GROUP_NAME = "HELLO, I'M STAS";
    private final String GROUP_DESCRIPTION = "MY OWN GROUP IN OK";

    @Test
    public void testGroupCreation() throws Exception {
        new LoginMainPage(driver).doLogin(
                new TestBot("technopolisBot2", "technopolis16"));
        new UserMainPage(driver).clickGroupsOnToolbar();

        GroupMainPage groupMainPage = new GroupMainPage(driver);
        groupMainPage.clickCreateGroup();
        groupMainPage.clickInterestGroup();
        groupMainPage.typeGroupName(GROUP_NAME);
        groupMainPage.typeGroupDescription(GROUP_DESCRIPTION);
        // groupMainPage.setSubCategory("Игры"); почему не получается - спроси
        groupMainPage.clickCreateButton();

        // проверяем на верность введенную ранее информацию
        CurrentGroupMainPage currGrPage = new CurrentGroupMainPage(driver);
        Assert.assertEquals(GROUP_NAME, currGrPage.getGroupName());
        Assert.assertEquals(GROUP_DESCRIPTION, currGrPage.getGroupDescription());
    }
}