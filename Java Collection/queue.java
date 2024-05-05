import java.util.ArrayDeque;
import java.util.Queue;

public class queue {
    public static void main(String[] args) {

        // Antrean Rumah Sakit
        Queue<String> nama = new ArrayDeque<>(10);
        nama.offer("Risky");
        nama.offer("Pandu");
        nama.offer("Queena");
        nama.offer("Nadira");
        nama.offer("Widianto");

            for (String next = nama.poll(); next != null; next = nama.poll()) {
                System.out.println(nama);
            }
    }
}