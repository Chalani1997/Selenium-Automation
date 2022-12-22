import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class TestClass{
    WebDriver driver;
    String url;

    public TestClass(String url){
        
        this.url=url;
    }

    @BeforeSuite
    public void beforeSuiteMethod(){
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();

        //Navigate to URL amazon.com
        driver.get("https://www.amazon.com/");
        url = driver.getCurrentUrl();
        driver.close();
    }

    @BeforeMethod
    public void beforeMethod(){

        //Launch a Chrome Browser
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        //Navigate to URL amazon.com
        driver.get(url);

    }

    @Test(priority = 0)
    public void testPage01(){

        Page01 pg1 = new Page01(driver);
        pg1.checkURL();
        pg1.selectComputers();
        pg1.typeLaptop();
        pg1.clickSearch();
        driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
        pg1.selectBrandOne();
        driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
        url = driver.getCurrentUrl();
    }

    @Test(priority = 1)
    public void testPage02(){
        Page02 pg2 = new Page02(driver);
        pg2.selectResultOne();
        pg2.printTitle();
        pg2.getLength();
        pg2.addToCart();
        pg2.printPrice();
        pg2.clickCart();
        pg2.verifyName();
        pg2.verifyPrice();
        driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
        pg2.goToCheckout();
        driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
        url = driver.getCurrentUrl();
        driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
    }


    @Test(priority = 2,enabled = false)
    @Parameters({"sName", "sEmail", "sPassword", "sPasswordCheck"})

    public void testPage03(String name, String email, String pwd,String pwdChck){
        Page03 pg3 = new Page03(driver,name,email,pwd,pwdChck);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        pg3.createACC();

        //url = driver.getCurrentUrl();

    }

    @AfterMethod
    public void afterMethod(){
        //Close the Browser
        driver.close();
    }

    @AfterSuite
    public void afterSuiteMethod(){
        //driver.quit();
    }


    }







