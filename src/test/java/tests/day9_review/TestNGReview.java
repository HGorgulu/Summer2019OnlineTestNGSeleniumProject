package tests.day9_review;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.BrowserFactory;

public class TestNGReview {
    //it helps to reduce the duplication

    private WebDriver driver;

    @BeforeMethod
    public void setup() {
        System.out.println("Before method!");
        driver = BrowserFactory.getDriver("chrome");

    }

    @AfterMethod
    public void teardown() {
        System.out.println("After method!");
        driver.quit();
    }

    @Test(description = "Verify title of google.com")
    public void test1() {
        System.out.println("Test 1");
        driver.get("http://google.com");
        String expectedTitle = "Google";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle, "Title is not correct!");

    }

    //tests will run in alphabetical order if you don't prioritize them
    //priority will change the order of test execution
    @Test(description = "Verify title of apple.com", priority = 1)
    public void verifyApplePageTitle() {
        System.out.println("Test 2");
        driver.get("https://www.apple.com/");
        String expectedTitle = "Apple";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle, "Title is not correct!");
        //message will be printed only if assertion failed
        System.out.println("Test passed!");
        //if assertion passed, you will see "passed" message

    }

    //   data provider can supply test with a test data. Also, it allows to do Data Driven Testing.
//   What is this? It's when same test runs multiple times with different test data set
    @DataProvider(name = "testData")
    public static Object[][] testData(){
        return new Object[][]{{"https://www.apple.com/", "Apple"}, //1st set of data
                {"http://google.com", "Google"}     //2nd set of data
        };
    }
    //data provider must return 2d array of Object
    //1st parameter  = 1 object in the inner array, 2nd parameter = 2 object in the inner array
    // url = https://www.apple.com/, title = Apple
    // url = http://google.com, title = Google
    //we can have as many sets of data as we want
    @Test(dataProvider = "testData") // this test will run twice, because we have 2 sets of data
    public void testWithDataProvider(String url, String title){
        driver.get(url);
        Assert.assertEquals(driver.getTitle(), title);
    }



}

