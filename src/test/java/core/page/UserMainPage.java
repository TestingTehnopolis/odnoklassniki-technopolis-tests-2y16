package core.page;

import core.HelperBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class UserMainPage extends HelperBase {

    public UserMainPage(WebDriver driver) {
        super(driver);
    }

    protected void check() {
        //todo
    }

    public void clickGroupsOnToolbar() {
        click(By.xpath(".//*[@class='mctc_navMenuSec' and contains(@href,'groups')]"));
    }

    public void openPostAlert() {
        click(By.xpath(
                "//*[contains(@id, 'gpf_') and contains(@id, '-pfhead')]//div[contains(@class, 'input_placeholder')]"));
    }

    public void typePostText(String text) {
        type(text,
                By.xpath("//*[@id='posting_form_text_field']"));
    }

    public void createPost() {
        clickOnElementInList(By.xpath(
                "//*[contains(@id, 'gpf_') and contains(@id, '.submit')]"),
                1);
    }

    public int getOccurenceOfStringInPosts(String post) {
        int count = 0;

        List<WebElement> elements = driver.findElements(
                By.xpath("//*[contains(@class, 'feed') and contains(@class, 'h-mod')]"));
        for (WebElement e : elements) {
            if (post.equalsIgnoreCase(e.getText())) {
                count++;
            }
        }

        return count;
    }

    public boolean tryClickToButton() {
        WebElement element = driver.findElements(
                By.xpath("//*[contains(@id, 'gpf_') and contains(@id, '.submit')]"))
                .get(1);

        String attr = element.getAttribute("class");
        return attr.contains("__disabled");
    }
}
