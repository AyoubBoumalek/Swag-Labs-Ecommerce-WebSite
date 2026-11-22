package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckOut_Complete {

    WebDriver driver;
    WebDriverWait wait;

    private final By completeMessage = By.xpath("//h2[@data-test='complete-header']");

    public CheckOut_Complete(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void CheckMessage(){

        if (wait.until(ExpectedConditions.visibilityOfElementLocated(completeMessage)).isDisplayed()){
            System.out.println("Order completed with success .");
        } else {
            System.out.println("Order not completed .");
        }


    }

    public void BackHome(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript(
                "arguments[0].click()",
                driver.findElement(By.id("back-to-products"))
        );
    }

    public void CompleteOrder(){
        CheckMessage();
        BackHome();
    }

}
