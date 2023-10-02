package lib.ui;

import org.openqa.selenium.remote.RemoteWebDriver;

public class ObjectPageObject extends MainPageObject{

    public ObjectPageObject(RemoteWebDriver driver) {super(driver);}

    protected static String
            OBJECT_STATUS_FILTER ="xpath://*[contains(@text, 'Активный')]",
            DONE_BUTTON="xpath://*[contains(@text, 'Готово')]",
            STATUS_TYPE_TPL="xpath://*[contains(@text, '{firstObjectStatus}')]",
            WALL_MATERIAl_TPL="xpath://*[contains(@text, '{firstObjectWallMaterial}')]",
            OBJECT_CLASS_TYPE_TPL="xpath://*[contains(@text, '{ObjectClass}')]",
            OBJECT_TYPE_TPL="xpath://*[contains(@text, '{ObjectType}')]",
            OBJECT_TYPE_FILTER="xpath://*[contains(@text, 'Тип недвижимости')]",
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

        this.waitForElementPresent(objectClassXpath,"", 10 );
        this.waitForElementAndClick(objectClassXpath,"", 10);
    }

    private static String getXpathByObjectClass(String ObjectClass){
        return OBJECT_CLASS_TYPE_TPL.replace("{ObjectClass}", ObjectClass);
    }

    public void changeObjectType(String objectType){
        String objectTypeXpath = getXpathByObjectType(objectType);

        this.waitForElementPresent(OBJECT_TYPE_FILTER,"Cannot see object type", 20);
        this.waitForElementAndClick(OBJECT_TYPE_FILTER,"Cannot see and click object type", 10);
        this.waitForElementPresent(objectTypeXpath,"Cannot see element object type", 20);
        this.waitForElementAndClick(objectTypeXpath,"Cannot see and click element object type", 20);
        this.waitForElementAndClick(DONE_BUTTON,"Cannot see and click done button", 20);
    }

    private static String getXpathByObjectType(String objectType){
        return OBJECT_TYPE_TPL.replace("{objectType}", objectType);
    }


}
