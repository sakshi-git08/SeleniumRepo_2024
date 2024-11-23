package com.MyStore.testcases;

import com.MyStore.utilities.ReadConfig;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class BaseTest {
    ReadConfig readConfig = new ReadConfig();
    String url = readConfig.getBaseUrl();
    String browser = readConfig.getBrowser();

    public static WebDriver driver;
    public static Logger logger;

    @BeforeClass
    public void setUp() {
        String browser = "chrome";
        switch (browser.toLowerCase()) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            default:
                driver = null;
                break;
        }
        //implicit wait
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //for logging
        logger = LogManager.getLogger("MyStore");

        driver.get(url);
        logger.info("url opened");

    }

    public void captureScreenshot(WebDriver driver, String testName) throws IOException {
        TakesScreenshot screenshot = ((TakesScreenshot) driver);
        File src = screenshot.getScreenshotAs(OutputType.FILE);
        File dest = new File("D:\\Sakshi\\CareerLearnings\\SeleniumAutomation\\Screenshots\\" + testName + ".png");
        FileUtils.copyFile(src, dest);
    }

    @AfterClass
    public void tearDown() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.close();
        driver.quit();
    }
}
