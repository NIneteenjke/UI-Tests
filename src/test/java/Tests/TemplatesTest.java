package Tests;

import lib.CoreTestCase;
import lib.ui.AuthPageObject;
import lib.ui.ObjectPageObject;
import org.junit.jupiter.api.Test;

public class TemplatesTest extends CoreTestCase {

    private static final String
            login = "130522",
            password = "99679218Aa";

    @Test
    public void authTest()
    {
        AuthPageObject Auth = new AuthPageObject(driver);
        ObjectPageObject Object = new ObjectPageObject(driver);

        String firstObjectStatus = "Активный";
        String secondObjectStatus = "Удален";


        Auth.authStart(login,password);
        Object.clickObjectStatusFilter();
        Object.clickActiveStatus(firstObjectStatus);
        Object.clickDeletedStatus(secondObjectStatus);
        Object.clickDone();
        Object.assertIfStatusChanged(secondObjectStatus);
    }

    @Test
    public void wallMaterialTest()
    {
        AuthPageObject Auth = new AuthPageObject(driver);
        ObjectPageObject Object = new ObjectPageObject(driver);

        String firstWallMaterial = "Блочные";
        String secondWallMaterial = "Брус";


        Auth.authStart(login,password);
        Object.clickObjectWallMaterial();
        Object.clickBlockMaterial(firstWallMaterial);
        Object.clickDone();
        Object.clickObjectWallMaterial();
        Object.clickBlockMaterial(firstWallMaterial);
        Object.clickTimberMaterial(secondWallMaterial);
        Object.clickDone();
        Object.assertIfMaterialChanged();
    }
}
