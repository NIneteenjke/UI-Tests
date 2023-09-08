import org.junit.Assert;
import org.junit.Test;

public class MainClassTest {

    @Test
    public void testGetLocalNumber ()
    {
        int LocalNumber = MainClass.getLocalNumber();
        Assert.assertTrue("Local number greater than 14", LocalNumber == 14);
    }
}
