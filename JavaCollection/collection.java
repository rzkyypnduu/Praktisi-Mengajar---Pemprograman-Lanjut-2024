import java.util.ArrayList;
import java.util.Collection;

public class collection {
    public static void main(String[] args) {

        Collection<String> nama = new ArrayList<String>();
        nama.add("Risky");
        nama.add("Pandu");
        nama.add("WIdianto");
        
        nama.remove("Pandu");

        for(var i : nama){
            System.out.println(i);
        }

        System.out.println(nama.contains("Risky"));
    }
    
}