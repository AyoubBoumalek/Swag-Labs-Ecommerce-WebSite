package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class ProductPage {
    protected WebDriver driver;

    //Locators
    //private By ProductSelected = By.xpath("//div[text()='Sauce Labs Backpack']");


    //Constructor
    public  ProductPage(WebDriver driver){

        this.driver = driver;
    }

    public void selectproduct(){
        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript(
                "arguments[0].click();",
                driver.findElement(By.xpath("//div[text()='Sauce Labs Backpack']"))
        );


    }

    public void MenuBtn(){
        WebElement Menu_Button = driver.findElement(By.id("react-burger-menu-btn"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript(
                "arguments[0].click();", Menu_Button
        );

    }

    public void clickLogOut(){
        WebElement LogOut_Button = driver.findElement(By.id("logout_sidebar_link"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript(
                "arguments[0].click();", LogOut_Button
        );

    }

    //Action
    public void product(){
        selectproduct();
    }

    public void LogOutProductPage(){
        MenuBtn();
        clickLogOut();
    }
}
