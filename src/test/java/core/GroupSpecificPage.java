package core;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GroupSpecificPage extends HelperBase {
    private static final By CREATE_PHOTO_COMPETITION = By.xpath(".//*[contains(@hrefattrs,'st.layer.cmd=PopLayerCreatePhotoCompetition')]");

    public GroupSpecificPage(WebDriver driver) {
        super(driver);
    }

    protected void check() {
        (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return isElementPresent(CREATE_PHOTO_COMPETITION);
            }
        });

        (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.visibilityOfElementLocated(CREATE_PHOTO_COMPETITION));
    }

    /**
     * Нажимаем создать фотоконкурс
     */
    public void clickCreatePhotoCompetition() {
        Assert.assertTrue("Не найден элемент создания фотоконкурса", isElementPresent(CREATE_PHOTO_COMPETITION));
        driver.findElement(CREATE_PHOTO_COMPETITION).click();
    }

    /**
     * Вводим название фотоконкурса
     */
    public void typePhotoCompetitionName(String photoCompetitionName) {
        type(photoCompetitionName, By.id("field_name"));
    }

    /**
     * Вводим дату окончания фотоконкурса
     */
    public void typePhotoCompetitionTillDate(String photoCompetitionTillDate) {
        type(photoCompetitionTillDate, By.id("field_till"));
        sendEnterKey(By.id("field_till"));
    }

    /**
     * Нажимаем создать фотоконкурс
     */
    public void clickCreatePhotoCompetitionButton() {
        click(By.id("hook_FormButton_button_create_comp"));
    }
}
