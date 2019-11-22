package tests.day8;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserFactory;
import utils.BrowserUtils;

import java.util.List;

public class RadioButtons {
    private WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/");
        //to go to Radio Buttons page
        //link text only in between >Text<
        //link text only work only with<a> elements
        //this step is common for all test cases
        driver.findElement(By.linkText("Radio Buttons")).click();
    }
    @Test(description = "Verify that blue button is selected")
    public void test1(){

        //find the blue button
        WebElement blueButton =driver.findElement(By.id("blue"));
        //lets verify that radio button is selected
        //assert true button is selected
        //if button is selected it will return true,otherwise false
        Assert.assertTrue(blueButton.isSelected()); //will expect that isSelected is true
    }

    @Test(description = "Verify that red button is not selected")
    public void test2(){
        WebElement redButton = driver.findElement(By.id("red"));

        Assert.assertFalse(redButton.isSelected());//assertFalse will expect that condition is false

    }

    @Test(description = "Verify that green button is not clickable")
    public void test3(){
        WebElement greenButton = driver.findElement(By.id("green"));
        Assert.assertFalse(greenButton.isEnabled());


    }

    @Test(description = "Click on all radio buttons")
    public void test4(){
        //how to find all radio buttons
        //find all radio buttons
        //any radio button will have type='radio'and input as a element type
        List<WebElement> radioButtons = driver.findElements(By.cssSelector("input[type='radio']"));
        //lets click only if button is not clicked and is available for clicking
        for(WebElement button: radioButtons){
            //if button is available for clicking and not clicked yet
            if(button.isEnabled() && !button.isSelected()){
                button.click();
                //in this case, id attribute represents a name of the color
                //also,there is no text in this element
                //that's ahy i print attribute value
                //attribute: type,id, name, disabled

                System.out.println("Button clicked: "+button.getAttribute("id"));
            }else{
                System.out.println("Button was not clicked: "+button.getAttribute("id"));
            }
            BrowserUtils.wait(1);//just for demo
        }
    }


    @AfterMethod
    public void teardown(){
        driver.quit();
    }
}
