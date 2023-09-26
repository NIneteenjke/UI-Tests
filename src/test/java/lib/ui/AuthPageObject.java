package lib.ui;

import org.openqa.selenium.remote.RemoteWebDriver;

public class AuthPageObject extends MainPageObject{

    public AuthPageObject(RemoteWebDriver driver){super(driver);}

    protected static String
            LOGIN_FIELD = "xpath://*[contains(@text, 'Логин')]",
            LOGIN_FIELD_EDIT = "xpath://*[@resource-id='com.riesapp.debug:id/loginTextInput']//*[@resource-id='com.riesapp.debug:id/textFieldEditText']",
            PASSWORD_FIELD = "xpath://*[contains(@text, 'Пароль')]",
            PASSWORD_FIELD_EDIT = "xpath://*[@resource-id='com.riesapp.debug:id/passwordTextInput']//*[@resource-id='com.riesapp.debug:id/textFieldEditText']",
            LOGIN_BUTTON = "xpath://*[contains(@text,'Войти')]",
            OBJECT_STATUS_FILTER = "xpath://*[contains(@text,'Активный')]",
            TAB_MENU = "xpath://*[contains(@text,'Меню')]",
            NEWS_SECTION = "xpath://*[contains(@text,'Новости')]";


    public void waitForLoginField() {
        this.waitForElementPresent(LOGIN_FIELD, "Cannot see login field", 5);
    }
    public void fillinLogin(String login) {
        this.waitForElementAndClick(LOGIN_FIELD, "Cannot see and click login field", 3);
        this.waitForElementAndSendKeys(LOGIN_FIELD_EDIT, login, "Cannot see and sand key login field", 3);
    }
    public void fillinPassword(String password) {
        this.waitForElementAndClick(PASSWORD_FIELD, "Cannot see and click password field", 3);
        this.waitForElementAndSendKeys(PASSWORD_FIELD_EDIT, password, "Cannot see and sand key password field", 3);
    }
    public void pressLoginButton(){
        this.waitForElementPresent(LOGIN_BUTTON, "Cannot see login button", 5);
        this.waitForElementAndClick(LOGIN_BUTTON, "Cannot click login button", 3);
    }

    public  void assertIfObjectTab(){
        this.waitForElementPresent(OBJECT_STATUS_FILTER, "Cannot see tab Object", 5);
        this.assertElementIsPresent(OBJECT_STATUS_FILTER, "Cannot see tab Object status filter");
    }

}
