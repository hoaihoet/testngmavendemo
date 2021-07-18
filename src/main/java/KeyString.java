public class KeyString {
    //String mo trinh duyet va mo form login
    String KEY_CHROME_DRIVER="webdriver.chrome.driver";
    String KEY_PATH_INSTALL_CHROME="/Users/leadqc/Downloads/HoaiLeu/Mentor Automation/chromedriver";
    String KEY_LINK_WEB="https://www.fahasa.com/";
    String KEY_XPATH_STATUS_NOT_LOGIN_YET="//*[@id='header']/div[1]/div[2]/div/div[3]/div[3]/div";

    //String Xpath login
    String KEY_XPATH_USERNAME="//*[@id='login_username']";
    String KEY_XPATH_PASSWORD="//*[@id='login_password']";
    String KEY_XPATH_LOGIN_BUTTON="//*[@id='wrapper']/div[2]/div[1]/div/div[2]/div/div/div[3]/div[2]/form/div[4]/div/button[1]";
    String KEY_XPATH_INLINE_MESSAGE_USERNAME ="//*[@id='wrapper']/div[2]/div[1]/div/div[2]/div/div/div[3]/div[2]/form/div[1]/div[2]";
    String KEY_XPATH_INLINE_MESSAGE_WRONG_INFOR ="//*[@id='wrapper']/div[2]/div[1]/div/div[2]/div/div/div[3]/div[2]/form/div[5]";
    String KEY_XPATH_STATUS_LOGGED= "//*[@id='header']/div[1]/div[2]/div/div[3]/div[3]/div[1]/div[2]";

    //String xpath list book
    String KEY_XPATH_SEARCH= "//*[@id='search_desktop']";
    String KEY_XPATH_LIST_BOOK= "//*[@class='product images-container']/a";

    //String xpath detail book
    String KEY_XPATH_NAMEBOOK_DETAIL = "//*[@id='product_addtocart_form']/div/div[1]/div[2]/h1";
    String KEY_XPATH_PRICEBOOK_DETAIL = "//*[@id='product-price-235794']";
    String KEY_XPATH_BUYNOW_DETAIL="//*[@id='product_addtocart_form']/div/div[1]/div[1]/div[2]/button[2]";

    //String xpath cart
    String KEY_XPATH_NAMEBOOK_CART="//*[@id='form-cart']/div/div[1]/div/div[1]/div[3]/div[1]/h2";
    String KEY_XPATH_PRICEBOOK_CART="//*[@id='form-cart']/div/div[1]/div/div[1]/div[3]/div[1]/div/span/div/div[1]/span";
    String KEY_XPATH_NUMBER_CART="//*[@type='text' and @title='Số lượng']";
    String KEY_XPATH_MONEY_CART="//*[@id='form-cart']/div/div[1]/div/div[1]/div[3]/div[2]/div[2]/span[2]/span";

    String KEY_XPATH_CHECKOUT_CART= "//*[@type='button' and @title='Thanh toán']";
}
