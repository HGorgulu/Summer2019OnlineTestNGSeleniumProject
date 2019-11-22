package tests.day10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserFactory;
import utils.BrowserUtils;

public class FileUploading {

    private WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/");

    }
    @Test(description = "Verify that file was uploaded")
    public void test1(){
        driver.findElement(By.linkText("File Upload")).click();
        //provide path to the file//insert your path to the file into sendKeys() methods
        driver.findElement(By.id("file-upload")).sendKeys("/Users/hatice_gorgulu$/Desktop/batch12.txt");
        //click submit
        driver.findElement(By.id("file-submit")).click();
        BrowserUtils.wait(5);
        //make sure that it s your file name
        String expectedFileName = "batch12.txt";

        String actualFileName = driver.findElement(By.id("upload-files")).getText();

        Assert.assertEquals(actualFileName,expectedFileName);
    }

    @AfterMethod
    public void teardown(){
        driver.quit();

    }
}
/*
Agenda:
    Windows, how to switch in between windows/tabs
    Frames
    File uploading
    Alerts/Pop-ups
     driver.switchTo().window(windowHandle); - in thins way we can switch to another window.
     window handle - it's like window id

     //set can store only unique values
     //getWindowHandles() return collection of window id's that are currently opened by webdriver
     Set<String> windowHandles = driver.getWindowHandles();
     String pageTitle = "Practice"; //title of the page that we want
        for (String windowHandle : windowHandles) {
            //keep jumping from window to window
            driver.switchTo().window(windowHandle);
            //once we found a correct page title
            if(driver.getTitle().equals(pageTitle)){
                //just exit
                //stop jumping
                break;
            }
        }
//to open new blank tab
 driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL +"t");
ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
driver.switchTo().window(tabs.get(0));
to open hyperlink in the new window use command/control + left click
######################
How to upload file in Selenium?
.sendKeys("path/to/the/file.txt")
For Window: hold shift and make a right click on the file
For Mac: right click and click and hold option button --> copy as a path name
"\"C:\\users\\user\\desktop\\file.txt\""
change \ to \\ or, /. also remove extra double quotes \"

 */
