public class merge {
    static int N = 10;

    public static void main(String[] args) {

        int[] arr = new int[N];
        for(int i = 0; i < N; i++) {
            arr[i] = i;
        }

        // Shuffle the array
        for(int i = 0; i < N; i++) {
            int r = (int) (Math.random() * (i + 1));
            swap(arr, i, r);
        }

        printArray(arr);
        long startTime = System.nanoTime();
        mergeSort(arr, 0, N - 1);
        long endTime = System.nanoTime();

        System.out.println("Time taken in nanoseconds: " + (endTime - startTime));
        printArray(arr);
    }

    static void swap(int[] arr, int i, int j) {
        int aux = arr[j];
        arr[j] = arr[i];
        arr[i] = aux;
    }

    // p es el primer índice del array, q es el índice del medio y r es el último índice
    static void mergeSort(int[] arr, int p, int r) {
        if (p >= r) {
            return;
        }

        int q = Math.floorDiv((p+r), 2);
        mergeSort(arr, p, q); // izquierda
        mergeSort(arr, q + 1, r); // derecha

        mergeArray(arr, p, q, r);
    }

    static void mergeArray(int[] arr, int p, int q, int r) {
        // p es el primer indice del array, q es el indice del medio y r es el último indice
        int nl = q - p + 1;
        int nr = r - q;

        int[] leftArray = new int[nl];
        int[] rightArray = new int[nr];

        // copias
        for (int i = 0; i < nl; i++) {
            leftArray[i] = arr[p + i];
        }

        for (int i = 0; i < nr; i++) {
            rightArray[i] = arr[q + i + 1];
        }

        int i = 0, j = 0;
        int k = p;

        while (i < nl && j < nr) {
            if (leftArray[i] <= rightArray[j]) {
                arr[k] = leftArray[i];
                i++;
            } else {
                arr[k] = rightArray[j];
                j++;
            }
            k++;
        }

        while (i < nl) {
            arr[k] = leftArray[i];
            i++;
            k++;
        }

        while (j < nr) {
            arr[k] = rightArray[j];
            j++;
            k++;
        }
    }

    static public void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

}
