package lib.ui;

import io.qameta.allure.Step;
import org.openqa.selenium.remote.RemoteWebDriver;

public class ObjectPageObject extends MainPageObject{

    public ObjectPageObject(RemoteWebDriver driver) {super(driver);}

    protected static String
            OBJECT_STATUS_FILTER ="xpath://*[contains(@text, 'Активный')]",
            DONE_BUTTON="xpath://*[contains(@text, 'Готово')]",
            STATUS_TYPE_TPL="xpath://*[contains(@text, '{firstObjectStatus}')]",
            WALL_MATERIAl_TPL="xpath://*[contains(@text, '{firstObjectWallMaterial}')]",
            OBJECT_CLASS_TYPE_TPL="xpath://*[contains(@text, '{ObjectClass}')]",
            OBJECT_TYPE_TPL="xpath://*[contains(@text, '{objectType}')]",
            REALTY_TYPE ="xpath://*[@text, 'Тип недвижимости *']",
            TICKET_TAB_FILTER ="xpath://*[contains(@text, 'Заявки')]",
            CREATE_TICKET="xpath://*[contains(@text, 'Создать заявку')]",
            NUMBER_FIELD="xpath://*[contains(@text, 'Номер телефона *')]",
            NUMBER_FIELD_EDIT="xpath://*[contains(@text,'Номер телефона')]/preceding-sibling::*",
            NAME_FIELD_EDIT="xpath://*[contains(@text,'Имя')]/preceding-sibling::*",
            NAME_FIELD="xpath://*[contains(@text, 'Имя *')]",
            OPERATION_TYPE_FIELD="xpath://*[contains(@text, 'Тип операции')]",
            REALTY_TYPE_SALE_AND_TO_RENT="xpath://*[contains(@text, 'Тип недвижимости *')]",
            REALTY_TYPE_BUY_AND_RENT="xpath://*[contains(@text, 'Класс недвижимости *')]",
            OPERATION_TYPE_TPL="xpath://*[contains(@text, '{operationType}')]",
            CONTINUE_BUTTON="xpath://*[contains(@text, 'Продолжить')]",
            REALTY_TYPE_TPL="xpath://*[contains(@text, '{realtyType}')]",
            TICKET_TOP_BAR_TITLE ="id:com.riesapp.debug:id/topBarTitle",
            LOADER = "id:com.riesapp.debug:id/ticketsListLoader",
            CREATE_BUTTON="id:com.riesapp.debug:id/saveButton",
            OBJECT_WALL_MATERIAL="xpath://*[contains(@text, 'Материал стен')]",
            SELECT_METERIAL="xpath://*[contains(@text, 'Выбрано')]";



    public void clickObjectStatusFilter(){
        this.waitForElementAndClick(OBJECT_STATUS_FILTER, "Cannot see Status field",5);
    }

    public void clickActiveStatus(String firstObjectStatus){
        String objectFirstStatusXpath = getXpathByObjectStatus(firstObjectStatus);

        this.waitForElementPresent(objectFirstStatusXpath,"Cannot see first Status", 5);
        this.waitForElementAndClick(objectFirstStatusXpath,"Cannot see and click first Status",5);
    }

    public void clickDeletedStatus(String secondObjectStatus){
        String objectSecondStatusXpath = getXpathByObjectStatus(secondObjectStatus);

        this.waitForElementPresent(objectSecondStatusXpath,"Cannot see second Status", 5);
        this.waitForElementAndClick(objectSecondStatusXpath,"Cannot see and click second Status",5);
    }


    public void clickDone(){
        this.waitForElementAndClick(DONE_BUTTON,"Cannot see and click Done button",5);
    }

    public void assertIfStatusChanged(String secondObjectStatus){
        String objectSecondStatusXpath = getXpathByObjectStatus(secondObjectStatus);
        this.waitForElementPresent(objectSecondStatusXpath,"Cannot see second status on field",5);
        this.assertElementIsPresent(objectSecondStatusXpath,"Cannot see second status on field");
    }

    private static String getXpathByObjectStatus(String firstObjectStatus){
        return STATUS_TYPE_TPL.replace("{firstObjectStatus}", firstObjectStatus);
    }



    public void clickObjectWallMaterial(){
        this.swipeUpToFindElement(OBJECT_WALL_MATERIAL,"Cannot see Wall material field",10);
        this.waitForElementAndClick(OBJECT_WALL_MATERIAL, "Cannot see and click Wall material field",5);
    }

    public void clickBlockMaterial(String firstWallMaterial){
        String objectFirstMaterialXpath = getXpathByWallMaterial(firstWallMaterial);

        this.waitForElementPresent(objectFirstMaterialXpath,"Cannot see first Wall material", 5);
        this.waitForElementAndClick(objectFirstMaterialXpath,"Cannot see and click first Wall material",5);
    }

    public void clickTimberMaterial(String secondWallMaterial){
        String objectSecondMaterialXpath = getXpathByWallMaterial(secondWallMaterial);

        this.waitForElementPresent(objectSecondMaterialXpath,"Cannot see second Wall material", 5);
        this.waitForElementAndClick(objectSecondMaterialXpath,"Cannot see and click second Wall material",5);
    }


    public void assertIfMaterialChanged(){
        this.waitForElementPresent(SELECT_METERIAL,"Cannot see selected material",5);
        this.assertElementIsPresent(SELECT_METERIAL,"Cannot see selected material");
    }

    private static String getXpathByWallMaterial(String firstObjectWallMaterial){
        return WALL_MATERIAl_TPL.replace("{firstObjectWallMaterial}", firstObjectWallMaterial);
    }


    public void changeObjectClass(String objectClass){
        String objectClassXpath = getXpathByObjectClass(objectClass);

        this.waitForElementPresent(objectClassXpath,"Cannot see object class", 10 );
        this.waitForElementAndClick(objectClassXpath,"Cannot see and click object class", 5);
    }

    private static String getXpathByObjectClass(String ObjectClass){
        return OBJECT_CLASS_TYPE_TPL.replace("{ObjectClass}", ObjectClass);
    }

    public void changeObjectType(String objectType){
        String objectTypeXpath = getXpathByObjectType(objectType);

        this.waitForElementPresent(REALTY_TYPE,"Cannot see object type", 10);
        this.waitForElementAndClick(REALTY_TYPE,"Cannot see and click object type", 5);
        this.waitForElementPresent(objectTypeXpath,"Cannot see element object type", 5);
        this.waitForElementAndClick(objectTypeXpath,"Cannot see and click element object type", 5);
        this.waitForElementAndClick(DONE_BUTTON,"Cannot see and click done button", 5);
    }

    private static String getXpathByObjectType(String objectType){
        return OBJECT_TYPE_TPL.replace("{objectType}", objectType);
    }

    @Step("clicked on the create ticket button")
    public void clickedToCreateTicketButton(){

        this.waitForElementPresent(TICKET_TAB_FILTER,"Cannot see tab ticket", 10);
        this.waitForElementAndClick(TICKET_TAB_FILTER,"Cannot see and click tab ticket", 5);
        this.waitForElementPresent(CREATE_TICKET,"Cannot see create ticket button", 5);
        this.waitForElementAndClick(CREATE_TICKET,"Cannot see and click create ticket button", 5);

    }
    @Step("filling Phone number and Client Name in ticket")
    public void fillingValueInTicket(String ticketClientNumber, String ticketClientName) {

        this.waitForElementPresent(NUMBER_FIELD, "Cannot see client number field", 10);
        this.waitForElementAndClick(NUMBER_FIELD, "Cannot see and click client number field", 5);
        this.waitForElementAndSendKeys(NUMBER_FIELD_EDIT, ticketClientNumber, "Cannot see and sand client number field", 10);
        this.waitForElementAndClick(NAME_FIELD, "Cannot see and click client name field", 5);
        this.waitForElementAndSendKeys(NAME_FIELD_EDIT, ticketClientName, "Cannot see and sand client name field", 10);
    }
    @Step("Clicked on continue button")
    public void pressContinueButton(){
        this.waitForElementPresent(CONTINUE_BUTTON, "Cannot see continue button", 10);
        this.waitForElementAndClick(CONTINUE_BUTTON, "Cannot see and click continue button", 5);
    }
    @Step("Change operation and realty ticket type")
    public void changeTicketOperationAndRealtyType(String operationType, String realtyType)  {
        String operationTypeXpath = getXpathByOperationType(operationType);
        String realtyTypeXpath = getXpathByRealtyType(realtyType);

        this.waitForElementPresent(OPERATION_TYPE_FIELD, "Cannot see operation type field", 10);
        this.waitForElementAndClick(OPERATION_TYPE_FIELD, "Cannot see and click  operation type field", 5);
        this.waitForElementPresent(operationTypeXpath, "Cannot see operation type", 5);
        this.waitForElementAndClick(operationTypeXpath, "Cannot see and click operation type", 5);
        //       Thread.sleep(1000);
//        switch(operationType)
//        {
//            case realtyType
//        }
        if("Продать".equals(operationType) || "Сдать".equals(operationType)) {
            this.waitForElementPresent(REALTY_TYPE_SALE_AND_TO_RENT, "Cannot see realty type sale and to rent"+ operationTypeXpath, 10);
            this.waitForElementAndClick(REALTY_TYPE_SALE_AND_TO_RENT, "Cannot see and click realty type sale and to rent"+ operationTypeXpath, 5);
        }else if ("Купить".equals(operationType) || "Снять".equals(operationType)){
            this.waitForElementPresent(REALTY_TYPE_BUY_AND_RENT, "Cannot see realty type buy and rent" + operationTypeXpath, 10);
            this.waitForElementAndClick(REALTY_TYPE_BUY_AND_RENT, "Cannot see and click realty type buy and rent" + operationTypeXpath, 5);
        }
        this.waitForElementPresent(realtyTypeXpath, "Cannot see realty type", 10);
        this.waitForElementAndClick(realtyTypeXpath, "Cannot see and click realty type", 5);
    }

    private static String getXpathByOperationType(String operationType){
        return OPERATION_TYPE_TPL.replace("{operationType}", operationType);
    }

    private static String getXpathByRealtyType(String realtyType){
        return REALTY_TYPE_TPL.replace("{realtyType}", realtyType);
    }
    @Step("Clicked on create button")
    public void pressCreateButton(){
        this.waitForElementPresent(CREATE_BUTTON, "Cannot see create button", 10);
        this.waitForElementAndClick(CREATE_BUTTON, "Cannot see and click create button", 5);
    }

    public void assertIfTickedCreated(){
        this.waitForElementNotPresent(LOADER," Still can see loader",5);
        this.waitForElementPresent(TICKET_TOP_BAR_TITLE,"Top bar title do not appear",5);
        this.assertElementIsPresent(TICKET_TOP_BAR_TITLE,"Cannot see the top bar title");
    }

}
