import java.util.Deque;
import java.util.LinkedList;

public class dequeue {
    public static void main(String[] args) {
        Deque<String> stack = new LinkedList<>();

        stack.offerLast("Queena");
        stack.offerLast("Nadira");
        stack.offerLast("Sam");
        
        for(var i = stack.pollLast(); i != null; i = stack.pollLast()) {
            System.out.println(i);
        }
    }
    
}