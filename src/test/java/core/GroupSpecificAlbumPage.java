package core;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GroupSpecificAlbumPage extends HelperBase {
    private static final By PHOTOS_BLOCK = By.xpath(".//*[@id='hook_Block_GroupAlbumPhotosBlock']");

    public GroupSpecificAlbumPage(WebDriver driver) {
        super(driver);
    }

    protected void check() {
        (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return isElementPresent(PHOTOS_BLOCK);
            }
        });

        (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.visibilityOfElementLocated(PHOTOS_BLOCK));
    }

    /**
     * Проверяем, имеется ли название создаваемого фотоконкурса (альбома) на странице
     * @boolean имеется ли название на странице
     */
    public boolean isAlbumNamePresent(String name) {
        String locator = "//*[contains(text(), '" + name + "')]";
        return isElementPresent(By.xpath(locator));
    }
}
