package core;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GroupSpecificAlbumPage extends HelperBase {
    private static final By PHOTOS_BLOCK = By.xpath(".//*[@id='hook_Block_GroupAlbumPhotosBlock']");
    private static final By ALBUM_HEADER = By.xpath(".//*[contains(@class, 'photo-h') and not(contains(@class, 'photo-h_cnt')) and not(contains(@class, 'photo-h_cnt_t'))]");

    public GroupSpecificAlbumPage(WebDriver driver) {
        super(driver);
    }

    protected void check() {
        Assert.assertTrue("Не дождались отображения блока фотографий",
                explicitWait(ExpectedConditions.visibilityOfElementLocated(PHOTOS_BLOCK), 10, 500));
    }

    /**
     * Проверяем, совпадает ли название альбома с заданным
     * @boolean совпадает ли название альбома с заданным
     */
    public boolean isAlbumNamePresent(String name) {
        return (name.equals(driver.findElement(ALBUM_HEADER).getAttribute("title")));
    }
}
