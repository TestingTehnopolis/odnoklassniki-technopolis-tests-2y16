package core;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Created by germanium on 06.12.17.
 */
public class MainToolbar extends HelperBase{

    private static final By BUTTON_MUSIC = By.xpath(".//div[contains(.,'Music') and contains(@class,'toolbar_nav_i_tx-w usel-off')]");
    private static final By BUTTON_VIDEO = By.xpath(".//div[contains(.,'Video') and contains(@class,'toolbar_nav_i_tx-w usel-off')]");
    private static final By LOGO = By.className("toolbar_logo_img");


    public MainToolbar(WebDriver driver) {
        super(driver);
    }

    @Override
    protected void check() {
        Assert.assertTrue("Не дождались логотипа",
                explicitWait(ExpectedConditions.visibilityOfElementLocated(LOGO), 10, 500));

    }

    public void clickMusic(){
        click(BUTTON_MUSIC);
    }

    public void clickVideo(){
        click(BUTTON_VIDEO);
    }
}
