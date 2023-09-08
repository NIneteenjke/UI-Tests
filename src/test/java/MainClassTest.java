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
        int ClassNumber = MainClass.GetClassNumber();
        System.out.println(ClassNumber);
        Assert.assertTrue("Local class number less than 45",ClassNumber > 45);
    }

}
