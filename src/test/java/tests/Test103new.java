package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Test103new {

    public WebDriver driver;

    @BeforeMethod

    public void beforeMethod() {

        System.setProperty("webdriver.chrome.driver", "D:\\SELENIUM\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }
    @Test
    public void TestName() {
        driver.get("https://www.103.by/");
        driver.findElement(By.cssSelector(".DropDown.Header__dropDown.DropDown--tick.DropDown--huge")).click();
        driver.findElement(By.className("Input__control")).sendKeys("Брест");
        driver.findElement(By.className("Radio__text")).click();
        Assert.assertEquals("Брест", driver.findElement(By.cssSelector(".DropDown__text.u-ellipsis")).getText());
    }
    @Test
    public void TestTourism() {
        driver.get("https://www.103.by/");
       driver.findElement(By.linkText("Журнал")).click();
        Assert.assertEquals("Журнал 103.by", driver.getTitle());
    }
    @Test
    public void TestSearch() {
        driver.get("https://www.103.by/");
        driver.findElement(By.id("search_open")).click();
        driver.findElement(By.className("iSearch Search--inModal")).sendKeys("qqq");
    }

    @AfterMethod

    public void afterMethod() {

       // driver.quit();
    }
}