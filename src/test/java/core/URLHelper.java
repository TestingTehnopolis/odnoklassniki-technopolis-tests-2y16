package core;

import org.openqa.selenium.WebDriver;

import java.net.URL;

public class URLHelper extends HelperBase {
    public URLHelper(WebDriver driver) {
        super(driver);
    }

    public String getCurrentURL() {
        return driver.getCurrentUrl();
    }

    public void goToUrl(URL url) {
        driver.navigate().to(url);
    }
}
