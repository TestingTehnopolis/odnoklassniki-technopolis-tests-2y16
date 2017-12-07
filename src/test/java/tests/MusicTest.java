package tests;

import core.MainToolbar;
import core.musicPages.MusicBasePage;
import core.TestBase;
import model.Song;
import org.junit.Test;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

/**
 * Created by germanium on 30.11.17.
 */
public class MusicTest extends TestBase{

    private static Song song = new Song("Научно-технический рэп", "Ария тестировщика");

    @Test
    public void testAddSong() throws  Exception{
        doLogin();

        new MainToolbar(driver).clickMusic();

        MusicBasePage musicBasePage = new MusicBasePage(driver);

        TimeUnit.SECONDS.sleep(1);
        musicBasePage.typeSearch(song);

        musicBasePage.clickSearch();

        musicBasePage.clickAdd();

        musicBasePage.clickMyMusic();

        Assert.assertTrue(musicBasePage.isSongPresent(song));

        musicBasePage.clickDelete();
    }

}
