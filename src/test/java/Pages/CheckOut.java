package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Random;
import java.util.Random.*;




public class CheckOut  {

    WebDriver driver ;
    WebDriverWait wait;


    public static class FakeDataGenerator {

        // Generate random first name
        public static String generateFirstName() {
            String[] firstNames = {
                    "Ayoub", "John", "Michael", "David", "Emma",
                    "Sophia", "Lina", "Sara", "Adam", "Lucas"
            };

            Random random = new Random();
            return firstNames[random.nextInt(firstNames.length)];
        }

        // Generate random last name
        public static String generateLastName() {
            String[] lastNames = {
                    "Smith", "Johnson", "Brown", "Williams",
                    "Miller", "Wilson", "Taylor", "Anderson"
            };

            Random random = new Random();
            return lastNames[random.nextInt(lastNames.length)];
        }

        // Generate random postal code
        public static String generatePostalCode() {
            Random random = new Random();

            // Example: 5-digit postal code
            int code = 10000 + random.nextInt(90000);

            return String.valueOf(code);
        }
    }

    String firstName = FakeDataGenerator.generateFirstName();
    String lastName = FakeDataGenerator.generateLastName();
    String postalCode = FakeDataGenerator.generatePostalCode();
    String fillInputScript = "arguments[0].scrollIntoView({block: 'center'});" +
            "arguments[0].click();" +
            "arguments[0].focus();" +
            "const nativeInputValueSetter = Object.getOwnPropertyDescriptor(window.HTMLInputElement.prototype, 'value').set;" +
            "nativeInputValueSetter.call(arguments[0], arguments[1]);" +
            "arguments[0].dispatchEvent(new Event('input', { bubbles: true }));" +
            "arguments[0].dispatchEvent(new Event('change', { bubbles: true }));";

    public  CheckOut(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }


    public void entryFirstName(){

        WebElement firstNameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-test='firstName']")));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript(fillInputScript, firstNameField, firstName);



    }


    public void entryLastName(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement lastNameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-test='lastName']")));

        js.executeScript(fillInputScript, lastNameField, lastName);

    }

    public void entryCodePostal(){
        WebElement postalCodeField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-test='postalCode']")));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript(fillInputScript, postalCodeField, postalCode);
    }

    public void clickContinue()  {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript(
                "arguments[0].click();",
                driver.findElement(By.id("continue"))
        );
    }

    public void CheckOutTest() {
        entryFirstName();
        entryLastName();
        entryCodePostal();
        clickContinue();
    }

}
