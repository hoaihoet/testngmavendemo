import org.openqa.selenium.*;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;

import java.util.List;

import static org.junit.Assert.*;

public class Checkout {
    SingletonPatern singletonPatern = SingletonPatern.getObject();
    KeyString keyString = new KeyString();
    String namebook;
    float priceBook;

    public void searchBook() {
        singletonPatern.webDriver.findElement(new By.ByXPath(keyString.KEY_XPATH_SEARCH)).sendKeys("conan" + Keys.ENTER);
    }
    public void addToCart() throws InterruptedException {
        List<WebElement> listBook= singletonPatern.webDriver.findElements(new By.ByXPath(keyString.KEY_XPATH_LIST_BOOK));
        listBook.get(0).click();
        namebook= singletonPatern.webDriver.findElement(new By.ByXPath(keyString.KEY_XPATH_NAMEBOOK_DETAIL)).getText();
        String name= singletonPatern.webDriver.findElement(new By.ByXPath(keyString.KEY_XPATH_PRICEBOOK_DETAIL)).getText();
        priceBook = Float.parseFloat(name.substring(0,6));
        singletonPatern.webDriver.findElement(new By.ByXPath(keyString.KEY_XPATH_BUYNOW_DETAIL)).click();
        Thread.sleep(500);
    }

    @Test(priority = 1)
    public void verifyOrder() throws InterruptedException {
        searchBook();
        addToCart();
        String nb = singletonPatern.webDriver.findElement(new By.ByXPath(keyString.KEY_XPATH_NAMEBOOK_CART)).getText();
        assertTrue(nb.equals(namebook));
        String p= singletonPatern.webDriver.findElement(new By.ByXPath(keyString.KEY_XPATH_PRICEBOOK_CART)).getText();
        Float priceBook1= Float.parseFloat(p.substring(0,6));
        assertTrue(priceBook1==priceBook);
        String n= singletonPatern.webDriver.findElement(new By.ByXPath(keyString.KEY_XPATH_NUMBER_CART)).getAttribute("value");
        int numberBook= Integer.parseInt(n);
        float money = priceBook*numberBook;
        String m= singletonPatern.webDriver.findElement(new By.ByXPath(keyString.KEY_XPATH_MONEY_CART)).getText();
        assertTrue(money== Float.parseFloat(m.substring(0,6)));
    }
    @Test(priority = 2)
    public void confirmCheckout(){
        WebElement checkoutElement= singletonPatern.webDriver.findElement(new By.ByXPath(keyString.KEY_XPATH_CHECKOUT_CART));
        JavascriptExecutor js = (JavascriptExecutor) singletonPatern.webDriver;
        js.executeScript("arguments[0].scrollIntoView();",checkoutElement);
        if(checkoutElement.isDisplayed()){
            checkoutElement.click();
        }
    }

    @AfterSuite
    public void quit() {
        singletonPatern.webDriver.quit();
    }
}
