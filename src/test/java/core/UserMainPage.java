package core;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class UserMainPage extends HelperBase {
    private static final By GROUPS_TOOLBAR_LINK = By.xpath(".//*[@class='mctc_navMenuSec' and contains(@href,'groups')]");
    private static final By HOME_LINK = By.xpath(".//*[@id='toolbar_logo_id']");
    private static final By BOOKMARKS = By.xpath(".//*[@id='hook_Block_LeftColumnBookmarks']//*[contains(@class, 'ugrid_i')]");

    public UserMainPage(WebDriver driver) {
        super(driver);
    }

    protected void check() {
        //todo
    }

    public void clickGroupsOnToolbar() {
        click(GROUPS_TOOLBAR_LINK);
    }

    /**
     * Нажимаем кнопку перехода на домашнюю страницу
     */
    public void clickHome() {
        click(HOME_LINK);
    }

    /**
     * Получаем обертки закладок
     */
    private List<BookmarkWrapper> getBookmarkWrappers() {
        Assert.assertTrue("Не найдены элементы в списке закладок", isElementPresent(BOOKMARKS));

        final List<WebElement> bookmarkElements = driver.findElements(BOOKMARKS);
        final List<BookmarkWrapper> bookmarkWrappers = new ArrayList<BookmarkWrapper>(bookmarkElements.size());

        for (WebElement bookmarkElement: bookmarkElements) {
            bookmarkWrappers.add(new BookmarkWrapper(bookmarkElement));
        }

        return bookmarkWrappers;
    }

    /**
     * Проверка на наличие закладки для указанной сущности
     * @boolean имеется ли закладка для указанной сущности
     */
    public boolean isBookmarkPresent(String entityName) {
        final List<BookmarkWrapper> bookmarks = getBookmarkWrappers();
        boolean result = false;
        for (BookmarkWrapper bookmark : bookmarks) {
            if (entityName.equals(bookmark.getEntityName())) {
                result = true;
                break;
            }
        }
        return result;
    }
}
