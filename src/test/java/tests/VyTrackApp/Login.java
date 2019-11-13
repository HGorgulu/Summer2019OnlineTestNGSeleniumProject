package tests.VyTrackApp;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.BrowserFactory;
import utils.BrowserUtils;

public class Login {
    public static void main(String[] args) {
        WebDriver driver = BrowserFactory.getDriver("chrome");

        driver.get("http://Qa2.vytrack.com/user/login");
        WebElement userName =driver.findElement(By.name("_username"));
        userName.sendKeys("user25");

        WebElement password = driver.findElement(By.name("_password"));
        password.sendKeys("UserUser123");

        WebElement submitButton = driver.findElement(By.id("_submit"));
        submitButton.click();


        String expectedResultTitle = "Dashboard";
        String actualResultTitle = driver.getTitle();
        String expectedResultURL = "https://qa2.vytrack.com/";
        String actualResultURL = driver.getCurrentUrl();
        if(expectedResultURL.equals(actualResultURL)&&expectedResultTitle.equals(actualResultTitle)){
            System.out.println("Test Passed");
        }else{
            System.out.println("Test Failed");
        }
        BrowserUtils.wait(3);
        driver.close();

    }
}
