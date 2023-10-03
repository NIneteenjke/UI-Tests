package Tests;

import lib.CoreTestCase;
import lib.ui.AuthPageObject;
import lib.ui.ObjectPageObject;
import org.junit.jupiter.api.Test;

public class ObjectListTests extends CoreTestCase {

    private static final String
            login = "130522",
            password = "99679218Aa";

    @Test
    public void testObjectListByClassAndType(){
        ObjectPageObject Object = new ObjectPageObject(driver);
        AuthPageObject Auth = new AuthPageObject(driver);

        Auth.authStart(login, password);

        String objectClass = "Вторичная";
        String cityName = "Севастополь";

        Object.changeObjectClass(objectClass);
        if ("Дача, участки".equals(objectClass)){
        Object.changeObjectType("Дача");}
        else if("Севастополь".equals(cityName)){
            Object.changeObjectType("Гостинка");
        }else {
            Object.changeObjectType("Квартира");
        }
    }


}
