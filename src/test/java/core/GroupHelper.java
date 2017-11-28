package core;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import java.net.URL;

public class GroupHelper extends HelperBase{

    public GroupHelper(WebDriver driver) {
        super(driver);
    }
    public String getGroupName() {
        return driver.findElement(By.id("field_name")).getAttribute("value");
    }

    public String getGroupDescription() {
        return driver.findElement(By.id("field_description")).getAttribute("value");
    }

    public String getGroupSubcategory() {
        return driver.findElement(By.xpath("//*[@class='mr-2x']"))
                                    .getAttribute("innerText");
    }

    public void clickGroup() {
        click(By.xpath(".//*[@class='ugrid_cnt']/li[1]"));
    }

    public void clickCreateTheme() {
        click(By.xpath(".//*[contains(@class, 'input_placeholder')]"));
    }

    public void typeNewTheme(String themeName) {
        type(themeName, By.id("posting_form_text_field"));
    }

    public void clickQuiz() {
        click(By.xpath(".//*[@id='switchBtns']/a[5]"));
    }

    //---------------------------------------------------
    public void typeVariant1(String name) {
        //click(By.xpath(".//*[@class='posting-form_poll']/div[2]/input[2]"));
        driver.findElement(By.xpath(".//*[@class='posting-form_poll']/div[2]/input[2]"))
                .sendKeys(name);
        /*((JavascriptExecutor) driver).executeScript
                ("document.getElementByXPath('.//*[@class='posting-form_poll']/div[2]/input[2]').setAttribute('value', 'new value for element')");*/
        //type(name, By.xpath(".//*[@class='posting-form_poll']/div[2]/input[2]"));
    }

    public void typeVariant2(String name) {
        type(name, By.xpath(".//*[@class='posting-form_poll']/div[3]/input[2]"));
    }
    //---------------------------------------------------


    public void clickSettings() {
        click(By.xpath("//*[@id='hook_Block_LeftColumnTopCardAltGroup']/ul/li[4]/a/span"));
    }

    public void clickDeleteGroup() {
        click(By.xpath("//*[@id='hook_Block_LeftColumnTopCardAltGroup']/ul/li[5]/span"));
        click(By.xpath("//*[@id='hook_Block_LeftColumnTopCardAltGroup']/ul/li[5]/ul/li/a"));
        click(By.xpath("//*[@id='hook_FormButton_button_delete']"));
    }

    public void clickCreateButton() {
        click(By.id("hook_FormButton_button_create"));
    }

    public void typeGroupName(String groupName) {
        type(groupName, By.id("field_name"));
    }

    public void typeDescription(String desc) {
        type(desc, By.id("field_description"));
    }

    public void clickAge() {
        click(By.xpath(".//*[@id='field_ageRestriction']/option[2]"));
    }

    public void clickSubCategory(String category) {
        click(By.xpath(".//*[contains(@value, '" + category + "')]"));
    }

    public void clickCreateGroup() {
        click(By.xpath(".//*[contains(@href,'st.layer.cmd=PopLayerCreateAltGroup')]"));
    }

    public void clickGroupByType(String type) {
        click(By.xpath(".//*[contains(@class,'" + type + "')]"));
    }

    public void typeWebsite(String website) {
        click(By.id("contactsLink"));
        type(website, By.id("field_website"));
    }

    public String checkInvalidWebsite() {
        return driver.findElement(By.xpath("//*[@id='contactsShow']/div[4]/span[2]"))
                .getAttribute("innerText");

    }

    public boolean check18() {
        return driver.findElement(By.xpath(".//*[contains(@class, 'stub-empty __18plus')]")).isDisplayed();
    }
}
