import java.util.LinkedList;
import java.util.List;

public class list {
    public static void main(String[] args) {

        List<String> nama = new LinkedList<String>();
        nama.add("Pandu");
        nama.add("Widianto");
        nama.add("Yanto");
        
        for(var i : nama){
            System.out.println(i);
        }
    }
}