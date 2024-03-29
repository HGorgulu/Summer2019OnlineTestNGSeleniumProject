package tests.day8;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserFactory;

import java.util.List;

public class CheckBoxes {

    //command + option + L - organize code

    private WebDriver driver;

    //private because it will be used only in this class
    @BeforeMethod
    public void setup() {
        driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com");
        //<a href="/checkboxes">Checkboxes</a>
        driver.findElement(By.linkText("Checkboxes")).click();
    }

    @Test
    public void test1(){
        List<WebElement> checkboxes = driver.findElements(By.cssSelector("[type='checkbox']"));
        for(WebElement checkbox : checkboxes){
            if(checkbox.isEnabled() && !checkbox.isSelected()){
                checkbox.click();
                System.out.println("Checkbox clicked: "+checkbox.getText());
            }else{
                System.out.println("Checkbox was not clicked: "+checkbox.getText());
            }
        }
    }


    @AfterMethod
    public void teardown() {
        driver.quit();
    }


}
