package core.page;

import core.HelperBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by iters on 11/26/17.
 */
public class CurrentGroupMainPage extends HelperBase {

    public CurrentGroupMainPage(WebDriver driver) {
        super(driver);
    }

    protected void check() {
        (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return driver.getCurrentUrl().matches("https://ok\\.ru/group/\\d+")
            || driver.getCurrentUrl().matches("https://www\\.ok\\.ru/group/\\d+");
            }
        });
    }

    public String getGroupName() {
        return driver.findElement(
                By.xpath("//span[contains(@class, 'mctc_name_holder')]")).getText();
    }

    public String getGroupDescription() {
        return driver.findElement(
                By.xpath("//div[contains(@class, 'group-info_desc')]")).getText();
    }

    public void clickCreateNewTopic() {
        click(By.xpath("//*[contains(@id, 'gpf_') and contains(@id, '-pfhead')]/a/div[2]/div/div"));
    }

    public void printTextTopic(String msg) {
        type(msg, By.id("posting_form_text_field"));
    }

    public void clickShareTopic() {
        click(By.xpath("//input[contains(@id, 'gpf_') and contains(@id, '.submit')]"));
    }

    public String getFirstPostTest() {
        return driver.findElements(
                By.xpath("//*[@id='listBlockPanelAltGroupForumNewRB']/div/div/div[1]/div/div[2]/div[2]/div[1]/div/div"))
                .get(0).getText();
    }

    public void clickGroupSettings() {
        click(By.xpath("//*[@id='hook_Block_LeftColumnTopCardAltGroup']/ul/li[4]/a/span"));
    }

    public void changeGroupName(String name) {
        WebElement element = driver.findElement(By.id("field_name"));
        element.clear();
        element.sendKeys(name);
    }

    public void saveSettings() {
        click(By.id("hook_FormButton_button_save_settings"));
    }

}
