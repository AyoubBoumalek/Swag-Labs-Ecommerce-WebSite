package Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;


public class base {


    protected WebDriver driver ;
    ChromeOptions options = new ChromeOptions();

    @BeforeClass
    public void setup() {


        options.addArguments("--headless=new");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-gpu");

        //WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);

        driver.get("https://www.saucedemo.com");
        driver.manage().window().maximize();

    }

    @AfterClass
    public void Teardown() {
        driver.quit();
    }

}
