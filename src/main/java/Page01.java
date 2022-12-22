import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Page01 {

    WebDriver driver;
    String url;

    public Page01(WebDriver driver){
        this.driver = driver;
    }

    public Page01(String url){
        this.url = url;
    }


    //Get the page URL and verify if it is the correct page that is opened
    public void checkURL(){
        if (driver.getCurrentUrl().equals("https://www.amazon.com/")){
            System.out.println("Correct page loaded");
        }else
        {
            System.out.println("Incorrect page loaded");
        }
    }

        //Select “Computers” from main drop-down box
        public void selectComputers(){
            Select select = new Select(driver.findElement(By.xpath("//*[@name='url']")));
            select.selectByValue("search-alias=computers-intl-ship");
        }

        //Type “Laptop” on search bar
        public void typeLaptop(){
            driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Laptop");
        }

        //Click on Search button icon [ Left hand side]
        public void clickSearch(){
            driver.findElement(By.id("nav-search-submit-button")).click();
        }

        //In the Featured Brands Category select first brand [checkbox]
        public void selectBrandOne(){
            driver.findElement(By.id("a-autoid-0-announce")).click();
            driver.findElement(By.id("s-result-sort-select_1")).click();
        }




}



