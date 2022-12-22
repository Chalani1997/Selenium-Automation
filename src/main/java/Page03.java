import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Page03{

    WebDriver driver;
    String sName,sEmail,sPassword,sPasswordCheck;

    public Page03(WebDriver driver,String sName, String sEmail, String sPassword,String sPasswordCheck){
        this.driver = driver;
        this.sName = sName;
        this.sEmail = sEmail;
        this.sPassword = sPassword;
        this.sPasswordCheck = sPasswordCheck;
    }

    public void createACC(){

        // Click on ‘Create your Amazon Account’ button
        driver.findElement(By.id("createAccountSubmit")).click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        // Type sample username, email, password and re-enter password
        driver.findElement(By.id("ap_customer_name")).sendKeys(this.sName);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        driver.findElement(By.id("ap_email")).sendKeys(this.sEmail);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        driver.findElement(By.id("ap_password")).sendKeys(this.sPassword);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        driver.findElement(By.id("ap_password_check")).sendKeys(this.sPasswordCheck);
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    }

}
