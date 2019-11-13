package tests.day5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.BrowserFactory;
import utils.BrowserUtils;

public class AmazonLogin {

    public static void main(String[] args) {

        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("https://amazon.com");

        WebElement button = driver.findElement(By.id("nav-link-accountList"));

        button.click();
        WebElement signInButton = driver.findElement(By.className("nav-action-inner"));

        signInButton.click();
        driver.findElement(By.id("ap_email")).sendKeys("email");
        driver.findElement(By.id("continue")).click();
        driver.findElement(By.id("ap_password")).sendKeys("password");
        driver.findElement(By.id("signInSubmit")).click();


        WebElement result = driver.findElement(By.id("result"));

        System.out.println(result.getText());
        BrowserUtils.wait(5);
        driver.quit();
    }
}

