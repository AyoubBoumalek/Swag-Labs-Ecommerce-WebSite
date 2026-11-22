package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class LoginPage {

    WebDriver driver ;
    WebDriverWait wait ;

    //Locators
    private final By username = By.id("user-name");
    private final By password = By.id("password");
    private final By loginBtn = By.id("login-button");

    public LoginPage(WebDriver driver){
        this.driver =  driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void entryusername(String standard_user){

        driver.findElement(username).sendKeys(standard_user);
    }

    public void entrypassword(String secret_sauce){

        driver.findElement(password).sendKeys(secret_sauce);
    }

    public void clickBtnLog() {

        driver.findElement(loginBtn).click();
    }

    public void Validation_logOut(){
        if (wait.until(ExpectedConditions.urlToBe("https://www.saucedemo.com/"))){
            System.out.println("Log out...");
        }else {
            System.out.println("Log out failed , try again ...");
        }

    }

    public void login(String standard_user,String secret_sauce) {
        entryusername(standard_user);
        entrypassword(secret_sauce);
        clickBtnLog();

    }
    public void LogOut(){
        Validation_logOut();
    }

}
