package Test;

import Base.base;
import Pages.*;
import org.testng.annotations.*;



public class E2ETest extends base{


    @Test
    public void test() {
        //Login
        LoginPage loginpage = new LoginPage(driver);
        loginpage.login("standard_user" , "secret_sauce");

        //select Product
        ProductPage productPage = new ProductPage(driver);
        productPage.product();

        //add Product
        ProductSelect productselect = new ProductSelect(driver);
        productselect.ProductSelected();

        //Click CheckOut button

        Cart checkButton = new Cart(driver);
        checkButton.CheckBtn();

        //Fill out CheckOut form and click Continues
        CheckOut checkout = new CheckOut(driver);
        checkout.CheckOutTest();

        //click Finish button
        CheckOutStepTwo checkoutStepTwo = new CheckOutStepTwo(driver);
        checkoutStepTwo.CheckOutStepTwoTest();

        //Click Back Home Button
        CheckOut_Complete checkoutComplete = new CheckOut_Complete(driver);
        checkoutComplete.CompleteOrder();

        //Log Out
        productPage.LogOutProductPage();
        loginpage.LogOut();



    }



}
