package Tests;

import lib.CoreTestCase;
import lib.ui.AuthPageObject;
import lib.ui.ObjectPageObject;
import org.junit.jupiter.api.Test;

public class TemplatesTest extends CoreTestCase {

    private static final String
            login = "130522",
            ticketClientNumber = "89121231323",
            ticketClientName = "TestОлег",
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
    public void changeObjectStatusFilter()
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

    @Test
    public void testCreateTicketByStatusAndType() throws InterruptedException {
        ObjectPageObject Object = new ObjectPageObject(driver);
        AuthPageObject Auth = new AuthPageObject(driver);


        Auth.authStart(login, password);
        Object.clickedToCreateTicketButton();
        Object.fillingValueInTicket(ticketClientNumber, ticketClientName);
        Object.pressContinueButton();
        Object.changeTicketOperationAndRealtyType("Купить", "Гараж");
        Object.pressCreateButton();
        Object.assertIfTickedCreated();
    }

    @Test
    public void testCreateTicketSaleHouse() throws InterruptedException {
        ObjectPageObject Object = new ObjectPageObject(driver);
        AuthPageObject Auth = new AuthPageObject(driver);


        Auth.authStart(login, password);
        Object.clickedToCreateTicketButton();
        Object.fillingValueInTicket(ticketClientNumber, ticketClientName);
        Object.pressContinueButton();
        Object.changeTicketOperationAndRealtyType("Продать", "Дом");
        Object.pressCreateButton();
        Object.assertIfTickedCreated();
    }
}
