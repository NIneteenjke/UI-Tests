import org.junit.Test;

public class MainClass {
    private int classNumber = 20;
    public static int getLocalNumber() {
        return 14;
    }

    public static int GetClassNumber() {
        MainClass mainClass = new MainClass();
        return mainClass.classNumber;
    }
}
