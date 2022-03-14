import java.util.LinkedList;

public class App {
    public static void main(String[] args) {

        // O(1)
        // not always exactly the same but spread over all iterations
        constComplexity();

        //O(n)
        //steadily increasing
        linearComplexity();

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

    static void linearComplexity() {
        for (int n = 32; n <= 8388608; n *= 2){
            int[] ar = createArray(n);

            long sum = 0;
            long time = System.nanoTime();
            for (int i = 0; i < n; i++) {
                sum += ar[i];
            }
            time = System.nanoTime() - time;

            System.out.printf("n = %d -> time = %d ns%n", n, time);
        }
    }

    static LinkedList<Integer> createList(int n) {
        LinkedList<Integer> li = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            li.add(i);
        }
        return li;
    }

    static int[] createArray(int n) {
        int[] ar = new int[n];
        for (int i = 0; i < n; i++) {
            ar[i] = i;
        }
        return ar;
    }
}
