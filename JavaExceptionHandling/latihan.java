package JavaExceptionHandling;

public class latihan {
    public static void main(String[] args) {
        
        // int angka = 10/0;
        // System.out.println(angka);
        
        try {
            int angka = 10/0;
            System.out.println(angka);
        } catch (ArithmeticException a) {
         
            System.out.println("Terjadi Kesalahan :" + a);

        }
    }
    
}
