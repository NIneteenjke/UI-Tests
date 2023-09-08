import org.junit.Test;

public class MainClass {
    private int classNumber = 20;
//    private string classString = "Hello, world";
    public static int getLocalNumber() {
        return 14;
    }

    public static int getClassNumber() {
        MainClass mainClass = new MainClass();
        return mainClass.classNumber;
    }

//    public static string getClassString() {
//        MainClass mainClass = new MainClass();
//        return mainClass.classString;
//    }
}
