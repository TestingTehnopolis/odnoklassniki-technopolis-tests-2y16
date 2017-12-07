package core.groupPages;

import core.HelperBase;
import model.Group;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Created by germanium on 07.12.17.
 */
public class GroupCertainPage extends HelperBase {


    private static final By TITLE = By.xpath(".//h1[contains(@class,'mctc_name_tx')]");

    public GroupCertainPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected void check() {
        Assert.assertTrue("Не дождались названия группы",
                explicitWait(ExpectedConditions.visibilityOfElementLocated(TITLE), 10, 500));
    }

    public boolean isGroupCreated(Group group){
        return (isElementPresent(By.xpath(".//h1[contains(.,'"+ group.getName() +"')]"))
                && isElementPresent(By.xpath(".//div[contains(.,'"+ group.getCategory() +"') and contains(@class,'group-info_category')]"))
                && isElementPresent(By.xpath(".//div[contains(.,'"+ group.getDescription() +"') and contains(@class,'group-info_desc')]")));
    }
}
