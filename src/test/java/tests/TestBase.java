package tests;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.fail;

public class TestBase {
    private String baseUrl;
    private StringBuffer verificationErrors = new StringBuffer();
    protected WebDriver driver;


    public void init() {
        driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1600,1200));
        baseUrl = "https://ok.ru/";
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get(baseUrl + "");
    }

    public void stop() {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

    @Before
    public void setUp() throws Exception {
        init();
    }

    @After
    public void tearDown() throws Exception {
        stop();
    }

}