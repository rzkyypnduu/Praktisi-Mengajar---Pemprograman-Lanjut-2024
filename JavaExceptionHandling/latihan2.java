package JavaExceptionHandling;

public class latihan2 {
    public static void main(String arg[]){
        try{
        int x = arg.length;
        int y = 100/x;
        int []arr = {91,92};
        y = arr[x];
        System.out.println("Tidak terjadi eksepsi");
        }catch(ArithmeticException e){
        System.out.println("Terjadi eksepsi karena pembagian dengan nol");
        }catch(ArrayIndexOutOfBoundsException e){
        System.out.println("Terjadi eksepsi karena index melebihi kapasitas");
        }
        System.out.println("Setelah blok try-catch");
        }
}
