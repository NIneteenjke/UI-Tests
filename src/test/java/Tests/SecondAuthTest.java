package Tests;

import lib.CoreTestCase;
import lib.ui.MainPageObject;
import org.junit.jupiter.api.Test;

public class SecondAuthTest extends CoreTestCase {

    protected static String
            LOGIN_FIELD = "xpath://*[contains(@text, 'Логин')]",
            LOGIN_FIELD_EDIT = "xpath://*[@resource-id='com.riesapp.debug:id/loginTextInput']//*[@resource-id='com.riesapp.debug:id/textFieldEditText']",
            PASSWORD_FIELD = "xpath://*[contains(@text, 'Пароль')]",
            PASSWORD_FIELD_EDIT = "xpath://*[@resource-id='com.riesapp.debug:id/passwordTextInput']//*[@resource-id='com.riesapp.debug:id/textFieldEditText']",
            LOGIN_BUTTON = "xpath://*[contains(@text,'Войти')]",
            TAB_MENU = "xpath://*[contains(@text,'Меню')]",
            NEWS_SECTION = "xpath://*[contains(@text,'Новости')]";
    @Test
    public void secondAuthorizationTest()
    {
        MainPageObject Main = new MainPageObject(driver);

        Main.waitForElementPresent(LOGIN_FIELD, "Cannot see login field", 5);
        Main.waitForElementAndClick(LOGIN_FIELD, "Cannot see and click login field", 3);
        Main.waitForElementAndSendKeys(LOGIN_FIELD_EDIT, "18858", "Cannot see and sand key login field", 3);
        Main.waitForElementAndClick(PASSWORD_FIELD, "Cannot see and click password field", 3);
        Main.waitForElementAndSendKeys(PASSWORD_FIELD_EDIT, "Test20232", "Cannot see and sand key password field", 3);
        Main.waitForElementAndClick(LOGIN_BUTTON, "Cannot click login button", 3);
        Main.waitForElementPresent(TAB_MENU, "Cannot see menu", 5);
        Main.waitForElementAndClick(TAB_MENU, "Cannot see and click on tab Menu", 3);
        Main.waitForElementPresent(NEWS_SECTION, "Cannot see News section", 5);
        Main.waitForElementAndClick(NEWS_SECTION, "Cannot see and click on News section", 3);
    }
}
