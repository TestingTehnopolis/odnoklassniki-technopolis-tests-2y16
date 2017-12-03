package core;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashMap;
import java.util.Map;

public class NewGroupLayer extends HelperBase {

    private static By HEADER = By.xpath("//*[contains(@class,'portlet_h portlet_h__sa')]");

    public enum GroupsTypes {
        INTEREST_GROUP,
        PUBLIC_PAGE,
        PERFORMANCE
    };

    Map<GroupsTypes, By> groups;

    public NewGroupLayer(WebDriver driver) {
        super(driver);
        groups = new HashMap<>(3);
        groups.put(GroupsTypes.INTEREST_GROUP, By.xpath("//*[contains(@class,'create-group-dialog_img') and contains(@class, '__interest')]"));
        groups.put(GroupsTypes.PUBLIC_PAGE, By.xpath("//*[contains(@class,'create-group-dialog_img') and contains(@class, '__page')]"));
        groups.put(GroupsTypes.PERFORMANCE, By.xpath("//*[contains(@class,'create-group-dialog_img') and contains(@class, '__event')]"));
    }

    @Override
    protected void check() {
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(HEADER) );
    }

    public GroupFormLayer chooseGroup(GroupsTypes type) {
        Assert.assertTrue("Не найден элемент списка типов групп", isElementPresent(groups.get(type)));
        Assert.assertTrue("Не найден элемент списка типов групп", isElementPresent(groups.get(type)));
        click(groups.get(type));
        return new GroupFormLayer(driver);
    }
}