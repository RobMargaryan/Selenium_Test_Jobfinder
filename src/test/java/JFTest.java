import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class JFTest {
    public static WebDriver driver;
    public static String url = "https://www.jobfinder.am/";

    @BeforeSuite
    public static void initDriver(){
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @BeforeMethod
    public void openSUT(){
        driver.get(url);
    }

    @Test
    public void lawyerTest(){
        driver.findElement(By.name("position")).sendKeys("իրավաբան");
        driver.findElement(By.className("filter-country")).click();
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[3]/form/div/div/div[3]/select/option[89]")).click();
        driver.findElement(By.className("btn-style")).click();

    }

    @AfterSuite
    public static void tearDown(){
        driver.quit();
    }
}