package core.videoPages;

import core.HelperBase;
import model.Song;
import model.Video;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Created by germanium on 07.12.17.
 */
public class VideoBasePage extends HelperBase {

    private static final By FIELD_SEARCH = By.xpath(".//*[contains(@class,'search-input_it it')]");//By.className("search-input_it it");//xpath(".//input[contains(@placeholder,'Search for music')]");
    private static final By BUTTON_SEARCH = By.xpath(".//a[contains(.,'Search') and contains(@class,'vl_btn')]");


    public VideoBasePage(WebDriver driver) {
        super(driver);
    }

    protected void check() {
        Assert.assertTrue("Не дождались поискового поля",
                explicitWait(ExpectedConditions.visibilityOfElementLocated(FIELD_SEARCH), 10, 500));

    }

    public void typeSearch(Video video){
        type(video.getName(), FIELD_SEARCH);
    }

//    public void clickSearch(){
//        click(BUTTON_SEARCH);
//    }

    public void clickOnVideo(Video video){
        String nameShortened = video.getName();
        if(nameShortened.length()>62)
            nameShortened=nameShortened.substring(0,62);
        click(By.xpath(".//div[@class='vid-card_n' and contains(.,'"+ nameShortened+"')]"));
    }
}
