import java.util.Arrays;

public class IntroSort2 {
    public static int counter = 0;

    public static void main(String[] args) {
        int[] arr = {9, 5, 2, 7, 1, 8, 4, 6, 3};

        counter++;
        System.out.println("Original array: " + Arrays.toString(arr));
        counter++;

        introSort(arr);
        counter++;

        System.out.println("Sorted array: " + Arrays.toString(arr) + "\nCounter count: " + counter);
        counter++;
    }

    public static void introSort(int[] arr) {
        int maxDepth = (int) Math.floor(Math.log(arr.length) * 2);
        counter++;

        introSortUtil(arr, 0, arr.length - 1, maxDepth);
        counter++;
    }

    public static void introSortUtil(int[] arr, int low, int high, int maxDepth) {
        counter++;
        if (high - low > 16) {
            if (maxDepth == 0) {
                heapSort(arr, low, high);counter++;counter++;
                return;
            }
            int partitionIndex = partition(arr, low, high);
            counter++;
            introSortUtil(arr, low, partitionIndex - 1, maxDepth - 1);counter++;
            introSortUtil(arr, partitionIndex + 1, high, maxDepth - 1);
            counter++;
        } else {
            insertionSort(arr, low, high);
            counter++;
        }
    }

    public static void heapSort(int[] arr, int low, int high) {
        Arrays.sort(arr, low, high + 1);
        counter++;
    }

    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];counter++;
        int i = low - 1;counter++;counter++;
        for (int j = low; j < high; j++) {
            counter++;counter++;
            if (arr[j] <= pivot) {
                i++;counter++;
                int temp = arr[i];counter++;
                arr[i] = arr[j];counter++;
                arr[j] = temp;
                counter++;
            }
        }
        int temp = arr[i + 1];counter++;
        arr[i + 1] = arr[high];counter++;
        arr[high] = temp;
        counter++;counter++;
        return i + 1;
    }

    public static void insertionSort(int[] arr, int low, int high) {
        counter++;
        for (int i = low + 1; i <= high; i++) {
            counter++;counter++;
            int key = arr[i];
            counter++;
            int j = i - 1;
            counter++;
            while (j >= low && arr[j] > key) {
                counter++;counter++;
                arr[j + 1] = arr[j];
                counter++;
                j--;
                counter++;
            }
            arr[j + 1] = key;
            counter++;
        }
    }
}