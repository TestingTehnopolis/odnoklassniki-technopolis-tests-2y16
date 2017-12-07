package core;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nsuprotivniy on 02.11.17.
 */
public class GroupMainPage extends HelperBase {

    private static final By CREATE_NEW_GROUP = By.xpath(".//*[contains(@href,'st.layer.cmd=PopLayerCreateAltGroup')]");
    private static final By GROUPS = By.xpath("//*[contains(@data-l,'groupCard,POPULAR_GROUPS')]");
    private static final By MY_GROUPS = By.xpath("//*[contains(@hrefattrs, 'st.cmd=userGroups&st._aid=GroupsSubMenu_User_MyGroupsNav_Header')]");

    public GroupMainPage(WebDriver driver) {
        super(driver);
    }

    protected void check() {
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(CREATE_NEW_GROUP));
        Assert.assertTrue("Не найден элемент создания группы", isElementVisible(CREATE_NEW_GROUP));
    }

    public NewGroupLayer clickCreateGroup() {
        Assert.assertTrue("Не найден элемент создания группы", isElementVisible(CREATE_NEW_GROUP));
        click(CREATE_NEW_GROUP);
        return new NewGroupLayer(driver);
    }

    public UserGroupsPage clickMyGroups() {
        Assert.assertTrue("Не найдена ссылка на группы пользователя", isElementVisible(MY_GROUPS));
        click(MY_GROUPS);
        return new UserGroupsPage(driver);
    }

    /**
     * Метод загружает по локатору список всех популярных групп со страницы,
     * оборачивая их в PopularGroupWrapper.
     *
     * @return Список всех популярных группы в виде PopularGroupWrapper.
     */
    public List<PopularGroupWrapper> getGroups() {
        List<WebElement> groupsElements = getElements(GROUPS);
        List<PopularGroupWrapper> groups = new ArrayList<>(groupsElements.size());
        for (WebElement groupElement : groupsElements) {
            groups.add(new PopularGroupWrapper(driver, groupElement));
        }
        return groups;
    }

    /**
     * Метод переходит к указанной группе, опускаясь по странице вниз.
     *
     * @param wrapper группа, к которой необходимо перейти.
     */
    public void moveToGroup(PopularGroupWrapper wrapper) {
        Actions actions = getActions();
        actions.sendKeys(wrapper.getElement(), Keys.PAGE_DOWN).build().perform();
    }

}
