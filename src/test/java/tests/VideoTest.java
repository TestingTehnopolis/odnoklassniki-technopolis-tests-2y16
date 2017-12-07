package tests;

import core.*;
import core.videoPages.VideoBasePage;
import core.videoPages.VideoCertainPage;
import model.Video;
import org.junit.Test;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

/**
 * Created by germanium on 30.11.17.
 */
public class VideoTest extends TestBase{

    Video video = new Video("Дмитрий Махнев. JS in production action. Лекция в рамках курса \"Frontend-разработка\". Ч.2.");

    @Test
    public void testLike() throws Exception{

        doLogin();

        new MainToolbar(driver).clickVideo();

        VideoBasePage videoBasePage = new VideoBasePage(driver);
//        TimeUnit.SECONDS.sleep(1);

        videoBasePage.typeSearch(video);
//        TimeUnit.SECONDS.sleep(1);

        videoBasePage.clickOnVideo(video);
//        TimeUnit.SECONDS.sleep(2);

        VideoCertainPage videoCertainPage = new VideoCertainPage(driver);

        videoCertainPage.clickLike();

        Assert.assertTrue(videoCertainPage.checkLike(testBot));

        videoCertainPage.clickLike();

        Assert.assertFalse(videoCertainPage.checkLike(testBot));





    }

}
