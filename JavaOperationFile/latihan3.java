package JavaOperationFile;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class latihan3 {
    public static void main(String[] args) {
        int i;
        try{
            FileInputStream file1 = new FileInputStream("sample.txt");
            FileOutputStream fileOut = new FileOutputStream("sample.txt");
            while((i = file1.read()) != -1){
                fileOut.write(i);
                System.out.println((char)i);
            }
            fileOut.close();
            file1.close();
        } catch (Exception e){
            System.out.println("File Tidak Ada");
        }
    }
}
