class Punto {

    static int N = 100;

    public static void main(String[] args) {

        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = i;
        }

        // Shuffle the array
        for (int i = 0; i < N; i++) {
            int r = (int) (Math.random() * (i + 1));
            swap(arr, i, r);
        }

        printArray(arr);

        long startTime = System.nanoTime();
        quickSort(arr, 0, N - 1);
        long endTime = System.nanoTime();
        long timeElapsedInMilliSec = (endTime - startTime) / 1000000;

        System.out.println("Time taken in nanoseconds: " + timeElapsedInMilliSec);

        printArray(arr);
    }

    static void swap(int[] arr, int i, int j) {
        int aux = arr[j];
        arr[j] = arr[i];
        arr[i] = aux;
    }

    static int[] quickSort(int[] A, int p, int r) {
        if (p < r) {
            int q = partition(A, p, r);
            quickSort(A, p, q - 1);
            quickSort(A, q + 1, r);
        }

        return A;
    }

    static int partition(int[] A, int p, int r) {
        int x = A[r]; // pivot
        int i = p - 1; // index of smaller element

        for (int j = p; j < r; j++) {
            if (A[j] <= x) {
                i++;
                int aux = A[i];
                A[i] = A[j];
                A[j] = aux;
            }
        }

        int aux = A[i + 1];
        A[i + 1] = A[r];
        A[r] = aux;

        return i + 1;
    }

    static void printArray(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }

        System.out.println();
    }
}