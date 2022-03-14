import java.util.LinkedList;

public class App {
    public static void main(String[] args) {

        // O(1)
        constComplexity();


    }

    static LinkedList<Integer> createList(int n) {
        LinkedList<Integer> li = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            li.add(i);
        }
        return li;
    }

    static void constComplexity() {
        for (int n = 32; n <= 8388608; n *= 2) {
            LinkedList<Integer> list = createList(n);

            long time = System.nanoTime();
            list.add(0, 1);
            time = System.nanoTime() - time;

            System.out.printf("n = %d -> time = %d ns%n", n, time);
        }
    }
}
