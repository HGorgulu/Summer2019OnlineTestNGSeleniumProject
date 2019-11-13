package tests.day5.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.BrowserFactory;
import org.openqa.selenium.WebElement;



public class TestsForClassNameLocator {
    public static void main(String[] args) {
        WebDriver driver = BrowserFactory.getDriver(("chrome"));
        driver.get("https://practice-cybertekschool.herokuapp.com/");

        driver.findElement(By.xpath("//*[@id=\"content\"]/ul/li[43]/a")).click();
        driver.findElement(By.name("full_name")).sendKeys("Hello");
        driver.findElement(By.name("email")).sendKeys("email@email.com");
        driver.findElement(By.name("wooden_spoon")).click();
        String expectedSignupMessage = "Thank you for signing up. Click the button below to return to the home page. ";
        String actualSignUpMessage = driver.findElement(By.name("signup_message")).getText();
        boolean homeButtonVisible = driver.findElement(By.id("wooden_spoon")).isDisplayed();





        }

    }

