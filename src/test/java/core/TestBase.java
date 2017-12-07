package core;

import model.TestBot;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.fail;

public class TestBase {
    protected final TestBot testBot = new TestBot("89315406954", "ATOMICgERMAN1", "German Abramov");
    private String baseUrl;
    private StringBuffer verificationErrors = new StringBuffer();
    protected WebDriver driver;

    @Before
    public void setUp() throws Exception {
        init();
    }

    @After
    public void tearDown() throws Exception {
        stop();
    }

    public void init() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("--lang=en-US");
        driver = new ChromeDriver(options);
        baseUrl = "https://ok.ru/";
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(baseUrl + "/");
    }

    public void doLogin(){
        new LoginMainPage(driver).doLogin(testBot);
    }

    public void stop() {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }
}
