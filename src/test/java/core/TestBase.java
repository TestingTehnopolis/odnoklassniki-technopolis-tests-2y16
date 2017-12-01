package core;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.fail;

/**
 * Класс отвечает за правильную инициализацию и корректное завершение работы
 * драйвера для всех тетов.
 */
public class TestBase {
    private String baseUrl;
    private StringBuffer verificationErrors = new StringBuffer();

    protected WebDriver driver;
    private OKMainPage oKMainPage;

    @Before
    public void setUp() throws Exception {
        init();
        oKMainPage = new OKMainPage(driver);
        //нужно перейти на русский язвк интерфейса.
        oKMainPage.clickSelectLanguageBtn()
            .checkLayerAppearance()
            .selectLanguage();
    }

    @After
    public void tearDown() throws Exception {
        stop();
    }

    public void init() {
        driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1600,1200));
        baseUrl = "https://ok.ru/";
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(baseUrl + "/");
    }

    public void stop() {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }
}
