package tests.VyTrackApp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.BrowserFactory;

public class Practice {
    public static void main(String[] args) {
        WebDriver driver = BrowserFactory.getDriver(("chrome"));
        driver.get("https://qa2.vytrack.com/user/login");

        driver.findElement(By.id("prependedInput")).sendKeys("User25");
        driver.findElement(By.className("span2")).sendKeys("User25");



    }
}
