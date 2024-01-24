import java.util.Arrays;
import java.util.Scanner;

public class TimsortExample {
    public static int counter = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        counter++;

        System.out.print("Enter the elements of the array (space-separated): ");
        counter++;
        String inputLine = scanner.nextLine();
        counter++;
        String[] elements = inputLine.split(" ");
        counter++;

        int[] arr = Arrays.stream(elements)
                .mapToInt(Integer::parseInt)
                .toArray();
        counter++;

        timsort(arr);
        counter++;

        System.out.println("Sorted array: " + Arrays.toString(arr));
        counter++;

        System.out.println("Counter count:" + counter);
        counter++;

        scanner.close();
        counter++;
    }

    public static void timsort(int[] arr) {
        int n = arr.length;
        counter++;
        int minRun = 32;
        counter++;
        counter++;
        for (int i = 0; i < n; i += minRun) {
            counter++;counter++;
            insertionSort(arr, i, Math.min((i + minRun - 1), (n - 1)));
        }
        counter++;
        for (int size = minRun; size < n; size = 2 * size) {
            counter++;counter++;
            for (int left = 0; left < n - 1; left += 2 * size) {
                counter++;counter++;
                int mid = Math.min(left + size - 1, n - 1);
                counter++;
                int right = Math.min((left + 2 * size - 1), (n - 1));
                counter++;

                merge(arr, left, mid, right);
                counter++;
            }
        }
    }

    public static void insertionSort(int[] arr, int left, int right) {
        counter++;
        for (int i = left + 1; i <= right; i++) {
            counter++;counter++;
            int key = arr[i];
            counter++;
            int j = i - 1;
            counter++;
            counter++;
            while (j >= left && arr[j] > key) {
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

    public static void merge(int[] arr, int left, int mid, int right) {
        int len1 = mid - left + 1;
        counter++;
        int len2 = right - mid;
        counter++;

        int[] leftArr = Arrays.copyOfRange(arr, left, left + len1);
        counter++;
        int[] rightArr = Arrays.copyOfRange(arr, mid + 1, mid + 1 + len2);
        counter++;

        int i = 0, j = 0;
        counter++;
        int k = left;
        counter++;
        counter++;
        while (i < len1 && j < len2) {
            counter++;counter++;
            if (leftArr[i] <= rightArr[j]) {
                arr[k++] = leftArr[i++];
                counter++;
            } else {
                arr[k++] = rightArr[j++];
                counter++;
            }
        }
        counter++;
        while (i < len1) {
            counter++;counter++;
            arr[k++] = leftArr[i++];
            counter++;
        }
        counter++;
        while (j < len2) {
            counter++;counter++;
            arr[k++] = rightArr[j++];
            counter++;
        }
    }
}
