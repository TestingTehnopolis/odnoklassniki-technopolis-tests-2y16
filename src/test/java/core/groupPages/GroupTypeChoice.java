package core.groupPages;

import core.HelperBase;
import model.Group;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by germanium on 03.12.17.
 */
public class GroupTypeChoice extends HelperBase {

    private static final By BUTTON_SHOPGROUP = By.xpath(".//*[contains(@class,'create-group-dialog_img __shop')]");

    public GroupTypeChoice(WebDriver driver) {
        super(driver);
    }

    protected void check() {
        Assert.assertTrue("Не дождались кнопки созданиия группы типа \"Магазин\"",
                explicitWait(ExpectedConditions.visibilityOfElementLocated(BUTTON_SHOPGROUP), 10, 500));
    }


    public void clickStoreType(){
        click(BUTTON_SHOPGROUP);
    }


}
