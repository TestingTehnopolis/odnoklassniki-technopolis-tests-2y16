package core.groupPages;

import core.HelperBase;
import model.Group;
import org.junit.Assert;
import org.omg.CORBA.PRIVATE_MEMBER;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Created by germanium on 04.12.17.
 */
public class GroupCreatedPage extends HelperBase {


    private static final By MAIN_CONTENT_ROW = By.id("mainTopContentRow");
    public GroupCreatedPage(WebDriver driver) {
        super(driver);
    }


    @Override
    protected void check() {
        Assert.assertTrue("Не дождались верхней панели",
                explicitWait(ExpectedConditions.visibilityOfElementLocated(MAIN_CONTENT_ROW), 10, 500));

    }

    public void clickGroupName(Group group){
        click(By.xpath(".//a[contains(.,'" + group.getName() + "')]"));
    }
}
