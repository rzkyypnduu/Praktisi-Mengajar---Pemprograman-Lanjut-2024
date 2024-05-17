package JavaOperationFile;
import java.io.File;

public class latihan1{
    public static void main(String[] args) {
        File file1 = new File("test.txt");
        System.out.println(file1.getAbsolutePath());
        System.out.println(file1.exists());
    }
}