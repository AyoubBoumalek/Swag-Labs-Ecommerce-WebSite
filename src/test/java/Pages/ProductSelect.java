package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductSelect {

    protected WebDriver driver;


    public ProductSelect(WebDriver driver) {
        this.driver = driver;
    }

    public void addProduct(){
        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript(
                "arguments[0].click();",
                driver.findElement(By.xpath("//button[@data-test='add-to-cart']"))
        );
    }

    public void cartIcon(){
        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript(
                "arguments[0].click();",
                driver.findElement(By.cssSelector("[data-test='shopping-cart-link']"))
        );
    }

    public void ProductSelected() {
        addProduct();
        cartIcon();
    }


}
