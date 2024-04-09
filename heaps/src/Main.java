/**
 *
 * @author htrefftz
 */
// import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[] A = { 4, 10, 3, 5, 1, 8, 2, 6, 7, 9 };

        System.out.println("Original array: ");
        for (int i = 0; i < A.length; i++) {
            System.out.print(A[i] + " ");
        }
        buildMaxHeap(A);

        System.out.println();
        System.out.println("Max Heap array: ");

        for (int i = 0; i < A.length; i++) {
            System.out.print(A[i] + " ");
        }
        System.out.println();

        System.out.println("Max heap extract min: " + MaxHeapExtractMin(A));

        System.out.println("Max Heap array: ");

        for (int i = 0; i < A.length; i++) {
            System.out.print(A[i] + " ");
        }
        System.out.println();

        System.out.println("Max heap insert 11: " + MaxHeapInsert(A, 13));

        System.out.println("Max Heap array: ");

        for (int i = 0; i < A.length; i++) {
            System.out.print(A[i] + " ");
        }

    }

    public static void buildMaxHeap(int[] A) {
        int n = A.length;
        for (int i = n / 2 - 1; i >= 0; i--) {
            maxHeapify(A, i, n);
        }
    }

    public static void maxHeapify(int[] A, int i, int n) {
        int left = left(i);
        int right = right(i);
        int largest = i;
        int heapSize = n;

        if (left < heapSize && A[left] > A[largest]) {
            largest = left;
        } else {
            largest = i;
        }

        if (right < heapSize && A[right] > A[largest]) {
            largest = right;
        }

        if (largest != i) {
            int temp = A[i];
            A[i] = A[largest];
            A[largest] = temp;
            maxHeapify(A, largest, n);
        }
    }

    public static int left(int i) {
        return 2 * i + 1;
    }

    public static int right(int i) {
        return 2 * i + 2;
    }

    public static int parent(int i) {
        return (i - 1) / 2;
    }

    public static int MaxHeapMaximum(int[] A) {
        if (A.length < 1) {
            System.out.println("Heap underflow");
            return -1;
        }
        return A[0];
    }

    public static int MaxHeapExtractMax(int[] A) {
        int max = MaxHeapMaximum(A);

        A[0] = A[A.length - 1];
        maxHeapify(A, 0, A.length - 1);
        return max;
    }

    public static int MaxHeapExtractMin(int[] A) {
        int min = A[A.length - 1];
        A[A.length - 1] = A[0];
        maxHeapify(A, 0, A.length - 1);
        return min;
    }

    public static int MaxHeapInsert(int[] A, int key) {
        int n = A.length;
        n++;
        int[] B = new int[n];
        for (int i = 0; i < A.length; i++) {
            B[i] = A[i];
        }
        B[n - 1] = Integer.MIN_VALUE;
        increaseKey(B, n - 1, key);
        return key;
    }

    // Given a string, compute recursively (no loops) the number of lowercase 'x'
    // chars in the string.
    public int countX(String str) {
        if (str.length() == 0) {
            return 0;
        }

        if (str.charAt(0) == 'x') {
            return 1 + countX(str.substring(1));
        } else {
            return countX(str.substring(1));
        }

    }

    public int countHi(String str) {
        if (str.length() == 0) {
            return 0;
        }

        if (str.length() > 1 && str.substring(0, 2).equals("hi")) {
            return 1 + countHi(str.substring(2));
        } else {
            return countHi(str.substring(1));
        }
    }

}
