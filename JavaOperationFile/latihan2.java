package JavaOperationFile;
import java.io.File;
public class latihan2 {
    public static void main(String[] args) {
        File folder1 = new File("folder1");
        System.out.println(folder1.mkdir());
        
        File file1 = new File(folder1,"testFile.txt");
        
        System.out.println(file1.getPath());
        System.out.println(folder1.isDirectory());



    }
    
}