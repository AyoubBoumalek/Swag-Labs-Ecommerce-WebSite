package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckOutStepTwo {

    WebDriver driver;
    WebDriverWait wait;

    private final By finishButton = By.id("finish");

    public CheckOutStepTwo(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void CheckSummary() {
        if (wait.until(ExpectedConditions.visibilityOfElementLocated(finishButton)).isDisplayed()) {
            System.out.println("Page checkout available");
        } else {
            System.out.println("Page checkout not available");
        }
    }

    public void FinishOrder() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript(
                "arguments[0].click();",
                wait.until(ExpectedConditions.elementToBeClickable(finishButton))
        );
    }

    public void CheckOutStepTwoTest() {
        //CheckSummary();
        FinishOrder();
    }
}
