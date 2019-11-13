package tests.day5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.BrowserFactory;
import utils.BrowserUtils;
import org.openqa.selenium.WebElement;
public class TestsForTagNameLocator {

    public static void main(String[] args) {
        WebDriver driver = BrowserFactory.getDriver(("chrome"));

        driver.manage().window().maximize();
        driver.get("https://practice.cybertekschool.com/sign_up");
        //if you want to do in one line,without creating webelement reference variable
        driver.findElement(By.name("full_name")).sendKeys("Test User");
        driver.findElement(By.name("email")).sendKeys("test+email@email.com");
        driver.findElement(By.name("wooden_spoon")).click();
        BrowserUtils.wait(3);





        driver.quit();
    }
}
