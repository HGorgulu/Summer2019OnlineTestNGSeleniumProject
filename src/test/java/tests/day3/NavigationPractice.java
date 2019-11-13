package tests.day3;

import org.openqa.selenium.WebDriver;
import utils.BrowserFactory;
import utils.BrowserUtils;

public class NavigationPractice {
    public static void main(String[] args) {
        //create a webdriver object, to work with a browser
        WebDriver driver = BrowserFactory.getDriver("chrome");
       driver.manage().window().maximize();

       driver.get("http://google.com");
       //wait for 3 seconds
        //this is out custom method
        //since method is static ,we provide number of seconds(time in seconds)
        BrowserUtils.wait(3);

        //HOW TO PRINT PAGE TITLE??
       driver.navigate().to("http://amazon.com");

       //navigate back to google
        driver.navigate().back();

        driver.navigate().forward();

        driver.navigate().refresh();

        driver.quit();






    }
}
