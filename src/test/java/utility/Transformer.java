package utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

public class Transformer {

    private By MSG_TEXT = By.xpath(".//div[contains(@class, 'js-messages-list')]//div[contains(@class, 'msg js-msg soh-s')]//span[*]");

    WebDriver driver;

    public Transformer(WebDriver driver) {
        this.driver = driver;
    }

    public List<MsgWrapper> getMsgs() {
        List<WebElement> elements = driver.findElements(MSG_TEXT);
        List<MsgWrapper> res = new ArrayList<MsgWrapper>();

        for (int i = 0; i < elements.size(); i++) {
            res.add(new MsgWrapper(elements.get(i).getText()));
        }

        return res;
    }
}
