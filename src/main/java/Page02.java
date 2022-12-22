
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Page02{

        WebDriver driver;
        String productTitle,price;

        public Page02(WebDriver driver){
            this.driver = driver;
         }


        //Select the first search item
        public void selectResultOne(){
            driver.findElement(By.cssSelector(".a-size-medium.a-color-base.a-text-normal")).click();
        }

        //Print the Item Title (Name) in console
        public void printTitle(){
            productTitle = driver.findElement(By.id("productTitle")).getText();
            System.out.println(productTitle);
        }

        //Get the Title Length and print in console
        public void getLength(){
            int length = productTitle.length();
            System.out.println("Page title length is : "+length);
        }

        //Select “Add To Cart”
        public void addToCart(){
            driver.findElement(By.id("add-to-cart-button-ubb")).click();
        }

        //Print Item Price in console
        public void printPrice(){
            price = driver.findElement(By.xpath("//body/div[@id='a-page']/div[@id='dp']/div[@id='dp-container']/div[@id='ppd']/div[@id='rightCol']/div[@id='desktop_buybox']/div[@id='buybox']/div[@id='usedBuyBox_feature_div']//span[2]")).getText();
            //price = driver.findElement(By.cssSelector(".a-size-base.a-color-price.offer-price.a-text-normal")).getAttribute("innerHTML");
            System.out.println("Item Price is " + price);
        }

        //Click on Cart
        public void clickCart(){
            //driver.findElement(By.id("nav-cart")).click();
            driver.findElement(By.id("sw-gtc")).click();

        }

        //Get item name and verify whether it is the correct
        public void verifyName(){
            String cartTitle = driver.findElement(By.cssSelector(".a-truncate-cut")).getAttribute("innerHTML");
            System.out.println(cartTitle);

            if (cartTitle.equals(productTitle)){
                System.out.println("Correct Item Selected");
            }else
            {
                System.out.println("Incorrect Item Selected");
            }
        }



        //Get item price and verify wheter it is the correct
        public void verifyPrice(){
            //String cartPrice = driver.findElement(By.xpath("//body/div[@id='a-page']/div[4]/div[1]/div[3]/div[1]/div[1]/div[2]/div[1]/form[1]/div[1]/div[1]/div[1]/span[2]/span[1]")).getAttribute("innerHTML");
            String cartPrice = driver.findElement(By.xpath("//body/div[@id='a-page']/div[4]/div[1]/div[3]/div[1]/div[2]/div[4]/div[1]/form[1]/div[2]/div[3]/div[4]/div[1]/div[2]/p[1]/span[1]")).getAttribute("innerHTML");

            System.out.println(cartPrice);
            if(price.equals(cartPrice)){
                System.out.println("Price is correct");
            }else
            {
                System.out.println("Price is incorrect");

            //Assert the ‘quantity of the Item (should not be empty) and print in console
                Assert.assertNotNull(driver.findElement(By.id("a-autoid-1-announce")));

                // Assert the Shopping Cart Subtotal (should be equal) with Proceed to checkout Subtotal
                Assert.assertEquals(driver.findElement(By.xpath("//body/div[@id='a-page']/div[4]/div[1]/div[3]/div[1]/div[1]/div[2]/div[1]/form[1]/div[1]/div[1]/div[1]/span[2]/span[1]")),driver.findElement(By.cssSelector("body.a-m-us.a-aui_149818-c.a-aui_152852-c.a-aui_157141-c.a-aui_160684-c.a-aui_57326-c.a-aui_72554-c.a-aui_accessibility_49860-c.a-aui_attr_validations_1_51371-c.a-aui_bolt_62845-c.a-aui_pci_risk_banner_210084-c.a-aui_perf_130093-c.a-aui_tnr_v2_180836-c.a-aui_ux_113788-c.a-aui_ux_114039-c.a-aui_ux_138741-c.a-aui_ux_145937-c.a-aui_ux_60000-c.a-meter-animate:nth-child(2) div.a-container.sc-background-dark:nth-child(5) div.a-section.a-spacing-none div.a-fixed-right-flipped-grid:nth-child(3) div.a-fixed-right-grid-inner div.a-fixed-right-grid-col.a-col-right:nth-child(1) div.a-cardui.sc-card-style.sc-java-remote-feature.celwidget.sc-card-spacing-top-none:nth-child(2) div.a-cardui-body.a-scroller-none div.a-box-group.sc-buy-box-group div.a-section.sc-buy-box-inner-box div.a-row.a-spacing-mini.sc-subtotal.sc-subtotal-buybox.sc-java-remote-feature:nth-child(1) span.a-color-price.sc-price-container.a-text-bold > span.a-size-medium.a-color-base.sc-price.sc-white-space-nowrap")));
            }
        }

        //Click on ‘Proceed to Checkout’ button
        public void goToCheckout(){
            driver.findElement(By.xpath("//*[@name='proceedToRetailCheckout']")).click();

        }

}
