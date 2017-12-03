package core;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class GroupMainPage extends HelperBase{

    private static final By CREATE_NEW_GROUP = By.xpath(".//*[contains(@href,'st.layer.cmd=PopLayerCreateAltGroup')]");
    private static final By GROUPS = By.xpath(".//*[contains(@class, 'ugrid __l')]//*[contains(@data-l,'t,visit')]");

    private static final String OK_GROUP_URL = "https://ok.ru/group/";
    public GroupMainPage(WebDriver driver) {
        super(driver);
    }

    protected void check() {
        //пример использования метода из HelperBase
        (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return isElementPresent(CREATE_NEW_GROUP);
            }
        });

        //пример использования класса ExpectedConditions
        (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.visibilityOfElementLocated(CREATE_NEW_GROUP));
    }

    public void clickCreateButton() {
        click(By.id("hook_FormButton_button_create"));
    }

    public void typeGroupName(String groupName) {
        type(groupName, By.id("field_name"));
    }

    public void clickInterestGroup() {
        click(By.xpath(".//*[contains(@class,'create-group-dialog_img __interest')]"));
    }

    public void clickCreateGroup() {
        Assert.assertTrue("Не найден элемент создания группы", isElementPresent(CREATE_NEW_GROUP));
        driver.findElement(CREATE_NEW_GROUP).click();
    }

    /**
     * Перейти по ссылке группы
     *
     * @param groupID id группы
     */
    public void clickGroupByID(final String groupID) {
        final List<GroupWrapper> groups = getGroupWrappers();

        for (GroupWrapper group : groups) {
            if (group.getGroupHref().equals(OK_GROUP_URL + groupID)) {
                group.open();
                break;
            }
        }
        return;
    }

    /**
     * Получаем обертки групп
     */
    private List<GroupWrapper> getGroupWrappers() {
        Assert.assertTrue("Не найден элементы в списке групп", isElementPresent(GROUPS));

        final List<WebElement> groupElements = driver.findElements(GROUPS);
        final List<GroupWrapper> groupWrappers = new ArrayList<GroupWrapper>(groupElements.size());


        for (WebElement groupElement: groupElements) {
            groupWrappers.add(new GroupWrapper(groupElement));
        }

        return groupWrappers;
    }
}
