package core;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GroupPage extends HelperBase {

    private static final By TITLE = By.xpath("//*[contains(@class,'mctc_name_tx')]");


    public GroupPage(WebDriver driver) {
        super(driver);

    }

    @Override
    protected void check() {
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(TITLE));
    }
}
