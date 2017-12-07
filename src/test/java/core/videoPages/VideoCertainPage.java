package core.videoPages;

import core.HelperBase;
import model.TestBot;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.concurrent.TimeUnit;

/**
 * Created by germanium on 07.12.17.
 */
public class VideoCertainPage extends HelperBase {


    private static By BUTTON_LIKE = By.xpath(".//div[contains(@class,'vp-layer-info')]//button[contains(@class,'h-mod widget_cnt controls-list_lk')]");

    public VideoCertainPage(WebDriver driver) {
        super(driver);
    }

    protected void check() {
        Assert.assertTrue("Не дождались кнопки \"Лайк\"",
                explicitWait(ExpectedConditions.visibilityOfElementLocated(BUTTON_LIKE), 10, 500));

    }

    public void clickLike(){
        click(BUTTON_LIKE);
    }

    public boolean checkLike(TestBot testBot) throws InterruptedException {
        new Actions(driver).moveToElement(driver.findElement(BUTTON_LIKE)).perform();
        TimeUnit.SECONDS.sleep(2);
        return isElementPresent(By.xpath(".//div[contains(@class,'ucard-mini_cnt_i ellip') and contains(.,'"+ testBot.getName() +"')]"));
    }

}
