import org.openqa.selenium.*;
import org.testng.annotations.Test;
import static org.junit.Assert.*;

public class Login {
    SingletonPatern singletonPatern = SingletonPatern.getObject();
    KeyString keyString = new KeyString();

    public void login(String username, String password){
        WebElement usernameElement= singletonPatern.webDriver.findElement(new By.ByXPath(keyString.KEY_XPATH_USERNAME));
        usernameElement.clear();
        usernameElement.sendKeys(username+ Keys.ENTER);
        WebElement passwordElement= singletonPatern.webDriver.findElement(new By.ByXPath(keyString.KEY_XPATH_PASSWORD));
        passwordElement.clear();
        passwordElement.sendKeys(password+ Keys.ENTER);
    }
    @Test(priority=1)
    public void inputNoData(){
        login("","");
        String messsage= singletonPatern.webDriver.findElement(new By.ByXPath(keyString.KEY_XPATH_INLINE_MESSAGE_USERNAME)).getText();
        assertTrue(messsage.equals("Thông tin này không thể để trống"));
    }

    @Test(priority=2)
    public void inputInvalid() {
        login("hoai@@gmail.com", "Hoaihoet");
        String messsage= singletonPatern.webDriver.findElement(new By.ByXPath(keyString.KEY_XPATH_INLINE_MESSAGE_USERNAME)).getText();
        assertTrue(messsage.equals("Email không hợp lệ"));
    }

    @Test(priority=3)
    public void inputInforIsNotExist() throws InterruptedException {
        login("hoai1@gmail.com","Hoaihoet");
        String messsage= singletonPatern.webDriver.findElement(new By.ByXPath(keyString.KEY_XPATH_INLINE_MESSAGE_WRONG_INFOR)).getText();
        Thread.sleep(200);
        assertTrue(messsage.equals("Số điện thoại/Email hoặc Mật khẩu sai!"));
    }

    @Test(priority=4)
    public void inputValidInfor() throws InterruptedException {
        login("0979250275","Hoaihoet");
        singletonPatern.webDriver.findElement(new By.ByXPath(keyString.KEY_XPATH_LOGIN_BUTTON));
        Thread.sleep(300);
    }
    @Test(priority=5)
    public void loginSuccess(){
        assertTrue(singletonPatern.webDriver.findElement(new By.ByXPath(keyString.KEY_XPATH_STATUS_LOGGED)).getText().equals("TÀI KHOẢN"));
    }
}
