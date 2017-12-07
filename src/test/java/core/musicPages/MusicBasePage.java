package core.musicPages;

import core.HelperBase;
import model.Song;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Created by germanium on 06.12.17.
 */
public class MusicBasePage extends HelperBase {

    private static final By FIELD_SEARCH = By.xpath(".//*[contains(@class,'search-input_it it')]");//By.className("search-input_it it");//xpath(".//input[contains(@placeholder,'Search for music')]");
    private static final By BUTTON_SEARCH = By.xpath(".//a[contains(.,'Search') and contains(@class,'vl_btn')]");
    private static final By BUTTON_ADD = By.xpath(".//a[contains(.,'Ария тестировщика')]/../../div[contains(@class,'mus-tr_right-controls foh-s')]/span[contains(@class,'mus-tr_add js-mus-tr_add') and contains(@title,'Add to My music')]");
    private static final By BUTTON_MYMUSIC = By.xpath(".//span[contains(.,'My music') and contains(@class,'mml_cat_n')]");
    private static final By BUTTON_DELETE = By.xpath(".//a[contains(.,'Ария тестировщика')]/../../div[contains(@class,'mus-tr_right-controls foh-s')]/span[contains(@class,'mus-tr_delete js-mus-tr_delete ') and contains(@title,'Remove from My music')]");
    public MusicBasePage(WebDriver driver) {
        super(driver);
    }

    protected void check() {
        Assert.assertTrue("Не дождались поискового поля",
                explicitWait(ExpectedConditions.visibilityOfElementLocated(FIELD_SEARCH), 10, 500));

    }

    public void typeSearch(Song song){
        type(song.getAuthor()+" "+song.getName(), FIELD_SEARCH);
    }

    public void clickSearch(){
        click(BUTTON_SEARCH);
    }

    public void clickAdd(){
        new Actions(driver).moveToElement(driver.findElement(BUTTON_ADD)).perform();
        click(BUTTON_ADD);
    }

    public void clickMyMusic(){
        click(BUTTON_MYMUSIC);
    }

    public boolean isSongPresent(Song song){
        return isElementPresent(By.xpath(".//a[contains(.,'" + song.getName() + "')]"));
    }

    public void clickDelete(){
        new Actions(driver).moveToElement(driver.findElement(BUTTON_DELETE)).perform();
        click(BUTTON_DELETE);
    }

}
