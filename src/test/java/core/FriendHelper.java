package core;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FriendHelper extends HelperBase {
    public FriendHelper(WebDriver driver) {
        super(driver);
    }

    public void clickAddToFriend() {
        click(By.xpath(".//*[contains(@class, 'dropdown_ac button-pro __wide')]"));
    }

    public void confirmAddFriend() {
        click(By.xpath(".//*[contains(@class, 'toolbar_nav_a toolbar_nav_a__friends')]"));
        click(By.xpath(".//*[contains(@hrefattrs, " +
                "'st.cmd=userFriendRequest&st._aid=UserMain_Friends_FriendRequests')]"));
        click(By.xpath(".//*[contains(@data-l, 't,inviteFromButton')]"));
    }

    public void confirmInviteToGroup() {
        click(By.xpath(".//*[contains(@data-l, 't,notifications')]"));
        click(By.xpath(".//*[contains(@data-l, 't,btn_accept')]"));
    }

    public String validateAddedFriend() {
        click(By.xpath(".//*[@id='hook_Block_LeftColumnTopCardAltGroup']/ul/div[1]/a"));
        return driver.findElement(
                By.xpath(".//*[@id='GroupMembersMenu']/div[1]/div[1]/a[2]/div[1]/span[1]/span[1]"))
                .getAttribute("innerText");
    }

    public void deleteFriend() {
        click(By.xpath(".//*[contains(@data-popup-selector, '#hook_Block_FriendJoinDropdownSecondary')]"));
        click(By.xpath(".//*[contains(@data-l, 't,friendMain')]/a[3]"));
    }

    public void clickInviteFriends() {
        click(By.xpath("//*[@id='hook_Block_LeftColumnTopCardAltGroup']/ul/li[2]/a/span"));
    }

    public void clickInviteFriendsToGroup() {
        click(By.xpath(".//*[@id='listBlockPanelInviteFriendsToGroup2FriendsList']" +
                "/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]"));
        click(By.xpath(".//*[contains(@class, 'button-pro form-actions_yes')]"));
    }
}
