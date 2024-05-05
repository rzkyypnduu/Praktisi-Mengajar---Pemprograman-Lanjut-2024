package JavaGeneric;

public class genericApps {
    public static void main(String[] args) {
        
        genericClass <Integer> dataKu = new genericClass<> (10);
        System.out.println(dataKu.getData());
    }
}
