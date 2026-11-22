package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class Cart {

    protected WebDriver driver;

    public Cart(WebDriver driver) {
        this.driver = driver;
    }

    public void CheckoutBtn(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript(
                "arguments[0].click();",
                driver.findElement(By.cssSelector("[data-test='checkout']"))
        );
    }

    public void CheckBtn() {
        CheckoutBtn();
    }



}
