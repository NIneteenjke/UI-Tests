import org.junit.Assert;
import org.junit.Test;

public class MainClassTest extends MainClass{

    @Test
    public void testGetLocalNumber ()
    {
        int LocalNumber = MainClass.getLocalNumber();
        Assert.assertTrue("Local number greater than 14", LocalNumber == 14);
    }

    @Test
    public void testGetClassNumber ()
    {
        int classNumber = MainClass.getClassNumber();
        System.out.println(classNumber);
        Assert.assertTrue("Local class number less than 45",classNumber > 45);//тут будет ошибка
    }

//    @Test
//    public void testGetClassString ()
//    {
//        MainClass.getClassString();
//        string classString = getClassString();
//
//        //Assert.assertTrue("Local class number less than 45",classString > 45);
//    }

}
