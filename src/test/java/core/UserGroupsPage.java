package core;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.List;

public class UserGroupsPage extends HelperBase {

    private static final By GROUPS = By.xpath("//*[contains(@data-l,'groupCard,null')]");

    public UserGroupsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected void check() {

    }

    /**
     * Метод загружает по локатору список всех популярных групп со страницы,
     * оборачивая их в UserGroupWrapper.
     *
     * @return Список всех популярных группы в виде UserGroupWrapper.
     */
    public List<UserGroupWrapper> getGroups() {
        List<WebElement> groupsElements = getElements(GROUPS);
        List<UserGroupWrapper> groups = new ArrayList<>(groupsElements.size());
        for (WebElement groupElement : groupsElements) {
            groups.add(new UserGroupWrapper(driver, groupElement));
        }
        return groups;
    }

}
