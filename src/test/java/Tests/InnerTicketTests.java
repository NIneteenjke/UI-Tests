package Tests;

import io.qameta.allure.*;
import lib.CoreTestCase;
import lib.ui.AuthPageObject;
import lib.ui.InnerTicketPageObject;
import lib.ui.ObjectPageObject;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Features(value = {@Feature(value = "Create inner ticket Tests")})
public class InnerTicketTests extends CoreTestCase {
    private static final String

            login = "130522",
            password = "99679218Aa";

    @Test
    @DisplayName("Create inner ticket")
    @Description("Create an internal application for refinancing")
    @Step("Creating refinance inner ticket")
    @Severity(value = SeverityLevel.NORMAL)
    public void testCreateRefinanceInnerTicket(){
        AuthPageObject Auth = new AuthPageObject(driver);
        InnerTicketPageObject Inner = new InnerTicketPageObject(driver);
        ObjectPageObject Object = new ObjectPageObject(driver);

        Auth.authStart(login, password);
        Object.clickedToCreateTicketButton();
        Object.fillingValueInTicket("89144325432", "Олег");
        Object.pressContinueButton();
        Object.changeTicketOperationAndRealtyType("Купить", "Квартиры");
        Object.pressCreateButton();

        Inner.clickInnerTicket();
        Inner.clickInnerTClickCreateInnerTicketButtonTicket();
        Inner.chooseInnerTicketByType("Рефинансирование");
        Inner.fillingOwnMoney("2 500 000");
        Inner.fillingEstatePrice("5 500 001");
        Inner.chooseUrgencyReason("Да, другая причина");//Да, другая причина
        Inner.clickCreateInnerTicketButton();
        Inner.assertIfRefinanceInnerTicketCreated();
    }
}
