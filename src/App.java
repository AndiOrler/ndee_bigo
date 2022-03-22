import java.util.Arrays;
import java.util.LinkedList;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class App {
    public static void main(String[] args) {

        // O(1)
        // not always exactly the same but spread over all iterations
        //constComplexity();

        //O(n)
        //steadily increasing
        //linearComplexity();

        //O(n²)
        //steadily increasing times four
        //quadraticComplexity();

        //O(log n)
        //almost constant increase after a while
        //logarithmicComplexity();


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

    static void quadraticComplexity() {
        for (int n = 32; n <= 65536; n *= 2){
            int[] ar = createUnsortedArray(n);
            long time = System.nanoTime();
            insertionSort(ar);
            time = System.nanoTime() - time;

            System.out.printf("n = %d -> time = %d ns%n", n, time);
        }
    }

    static void logarithmicComplexity() {
        for (int n = 32; n <= 65536; n *= 2){
            int[] ar = createUnsortedArray(n);
            long time = System.nanoTime();
            Arrays.binarySearch(ar, 0);
            time = System.nanoTime() - time;

            System.out.printf("n = %d -> time = %d ns%n", n, time);
        }
    }

    static void insertionSort(int[] numbers){
        for (int i = 0; i < numbers.length; i++) {
            int elm = numbers[i];
            int j = i;
            while (j > 0 && elm < numbers[j - 1]) {
                numbers[j] = numbers[j - 1];
                j--;
            }
            numbers[j] = elm;
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

    static int[] createUnsortedArray(int n) {
        int[] ar = new int[n];
        ThreadLocalRandom random = ThreadLocalRandom.current();
        for (int i = 0; i < n; i++) {
            ar[i] = random.nextInt();
        }
        return ar;
    }
}
