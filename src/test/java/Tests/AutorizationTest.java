package Tests;

import lib.CoreTestCase;
import lib.ui.AuthPageObject;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.remote.RemoteWebDriver;

public class AutorizationTest extends CoreTestCase {

    private static final String
    login = "130522",
    password = "9967918Aa";

    @Test
    public void authTest()
    {
        AuthPageObject Auth = new AuthPageObject(driver);

        Auth.authStart(login,password);

    }
}
