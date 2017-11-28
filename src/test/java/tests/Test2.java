package tests;

import core.GroupHelper;
import core.SessionHelper;
import core.UserMainPageHelper;
import model.TestBot;
import org.junit.Before;
import org.junit.Test;


/*
 * Второй кейс: описание в README.md: "3. Создание темы в ранее созданной группе с опросом""
 */
public class Test2 extends TestBase {
    private SessionHelper sessionHelper;
    private UserMainPageHelper userMainPageHelper;
    private GroupHelper groupHelper;

    private String login;
    private String password;

    private String themeName;
    private String questionName;
    private String variantOne;
    private String variantTwo;


    @Before
    public void before() throws Exception {
        sessionHelper = new SessionHelper(driver);
        userMainPageHelper = new UserMainPageHelper(driver);
        groupHelper = new GroupHelper(driver);

        login = "technopolisBot18";
        password = "technopolis16";

        themeName = "Тема 01";
        questionName = "Вопрос 01";
        variantOne = "Вариант 01";
        variantTwo = "Вариант 02";
    }

    @Test
    public void createPublicPage() throws Exception {
        sessionHelper.doLogin(new TestBot(login, password));

        userMainPageHelper.clickGroupsOnToolbar();

        groupHelper.clickGroup();
        groupHelper.clickCreateTheme();
        groupHelper.typeNewTheme(questionName);
        groupHelper.clickQuiz();
        groupHelper.typeNewTheme(themeName);
        groupHelper.typeVariant1(variantOne);

        // не работает че-то
        //groupHelper.typeVariant2(variantTwo);
        //groupHelper.clickCreateTheme();

        Thread.sleep(10000);
    }
}
