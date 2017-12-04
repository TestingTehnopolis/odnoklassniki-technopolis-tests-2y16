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

    public List<MsgWrapper> getMsgs(byte nLast) {
        List<WebElement> elements = driver.findElements(MSG_TEXT);
        List<MsgWrapper> res = new ArrayList<MsgWrapper>(nLast);
        for (int i = 0; i < nLast; i++) {
            res.add(new MsgWrapper(elements.get(elements.size()-1-i).getText()));
        }

        return res;
    }
}
