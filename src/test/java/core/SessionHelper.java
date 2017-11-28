package core;

import model.TestBot;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SessionHelper extends HelperBase{

    public SessionHelper(WebDriver driver) {
        super(driver);
    }

    public void doLogin(TestBot testBot) {
        type(testBot.getLogin(), By.id("field_email"));
        type(testBot.getPassword(), By.id("field_password"));
        click(By.xpath(".//*[contains(@data-l,'loginButton')]"));
    }

    public void clickAccountAndLogout() {
        click(By.xpath(".//*[contains(@class, 'toolbar_dropdown_w h-mod')]"));
        click(By.xpath(".//*[contains(@data-l, 't,logoutCurrentUser')]"));
        click(By.id("hook_FormButton_logoff.confirm_not_decorate"));

    }
}
