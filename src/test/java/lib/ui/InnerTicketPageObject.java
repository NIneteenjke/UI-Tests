package lib.ui;

import org.openqa.selenium.remote.RemoteWebDriver;
public class InnerTicketPageObject extends MainPageObject{
    public InnerTicketPageObject(RemoteWebDriver driver) { super(driver); }

    protected static String
            INNER_TICKET_TYPE_TPL = "xpath://*[contains(@text,'{innerTicketType}')]",
            INNER_TICKET = "xpath://*[contains(@text,'Внутренние заявки')]",
            CREATE_INNER_TICKET_BUTTON = "xpath://*[contains(@text,'Создать заявку')]",
            OWN_MONEY_FIELD = "xpath://*[contains(@text,'Собственные средства')]",
            OWN_MONEY_FIELD_EDIT = "xpath://*[contains(@text,'Собственные средства')]/preceding-sibling::*",
            ESTATE_PRICE_FIELD = "xpath://*[contains(@text,'Стоимость недвижимости')]",
            ESTATE_PRICE_FIELD_EDIT = "xpath://*[contains(@text,'Стоимость недвижимости')]/preceding-sibling::*",
            URGENCY_REASON_FILTER = "xpath://*[contains(@text,'Срочная заявка')]",
            CREATE_TICKET_BUTTON = "xpath://*[contains(@text,'Создать заявку')]",
            REFINANCE_TICKET_CARD = "xpath://*[contains(@text,'Рефинансирование')]",
            URGENCY_REASON_TYPE_TPL = "xpath://*[contains(@text,'{urgencyReason}')]";

    public void clickInnerTicket(){
        this.waitForElementPresent(INNER_TICKET,"",10);
        this.waitForElementAndClick(INNER_TICKET,"",5);
    }

    public void clickInnerTClickCreateInnerTicketButtonTicket(){
        this.waitForElementPresent(CREATE_INNER_TICKET_BUTTON,"",10);
        this.waitForElementAndClick(CREATE_INNER_TICKET_BUTTON,"",5);
    }

    public void chooseInnerTicketByType(String innerTicketType){
        String innerTicketTypeXpath = getXpathByInnerTicketType(innerTicketType);

        this.waitForElementPresent(innerTicketTypeXpath,"",10);
        this.waitForElementAndClick(innerTicketTypeXpath,"",5);
    }

    private static String getXpathByInnerTicketType(String innerTicketType) {
        return INNER_TICKET_TYPE_TPL.replace("{innerTicketType}", innerTicketType);
    }

    public void fillingOwnMoney(String money){
        this.waitForElementPresent(OWN_MONEY_FIELD,"",10);
        this.waitForElementAndClick(OWN_MONEY_FIELD,"",5);
        this.waitForElementAndSendKeys(OWN_MONEY_FIELD_EDIT, money, "",5);
    }

    public void fillingEstatePrice(String estatePrice){
        this.waitForElementAndClick(ESTATE_PRICE_FIELD,"",5);
        this.waitForElementAndSendKeys(ESTATE_PRICE_FIELD_EDIT, estatePrice, "",5);
    }

    public void chooseUrgencyReason(String urgencyReason){
        String urgencyReasonTypeXpath = getXpathByUrgencyReasonType(urgencyReason);

        this.waitForElementAndClick(URGENCY_REASON_FILTER,"",5);
        this.waitForElementAndClick(urgencyReasonTypeXpath, urgencyReason, 5);
    }

    public void clickCreateInnerTicketButton(){
        this.waitForElementAndClick(CREATE_TICKET_BUTTON,"",5);
    }

    public void assertIfRefinanceInnerTicketCreated(){
        this.waitForElementPresent(REFINANCE_TICKET_CARD,"",10);
        this.assertElementIsPresent(REFINANCE_TICKET_CARD,"");
    }

    private static String getXpathByUrgencyReasonType(String urgencyReason) {
        return URGENCY_REASON_TYPE_TPL.replace("{urgencyReason}", urgencyReason);
    }
}
