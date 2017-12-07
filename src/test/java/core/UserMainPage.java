package core;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;

public class UserMainPage extends HelperBase {
    private static final By GROUPS_TOOLBAR_LINK = By.xpath(".//*[@class='mctc_navMenuSec' and contains(@href,'groups')]");
    private static final By BOOKMARKS = By.xpath(".//*[@id='hook_Block_LeftColumnBookmarks']//*[contains(@class, 'ugrid_i')]");

    private static final String bookmarkScrollBlockID = "hook_Block_LeftColumnBookmarks";

    public UserMainPage(WebDriver driver) {
        super(driver);
    }

    protected void check() {
        Assert.assertTrue("Не дождались отображения тулбара со ссылкой на группы",
                explicitWait(ExpectedConditions.visibilityOfElementLocated(GROUPS_TOOLBAR_LINK), 10, 500));
    }

    public GroupMainPage clickGroupsOnToolbar() {
        click(GROUPS_TOOLBAR_LINK);
        return new GroupMainPage(driver);
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
        final List<BookmarkWrapper> bookmarks = getBookmarkWrappers();for (BookmarkWrapper bookmark : bookmarks) {
            if (entityName.equals(bookmark.getEntityName())) {
                return true;
            }
        }
        return false;
    }

    /**
     * Скролл до закладок
     */
    public void scrollToBookmarks() {
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("document.getElementById(\"" + bookmarkScrollBlockID + "\").scrollIntoView();", "");
    }
}
