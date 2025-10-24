
public class SelectionSorter {
    public static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }
    
    public static void main(String[] args) {
        int[] testArray = {23, 56, 21, 41, 12};
        System.out.print("Исходный массив: ");
        printArray(testArray);
        selectionSort(testArray);
        System.out.print("Отсортированный массив: ");
        printArray(testArray);
    }
    
    public static void printArray(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}

// Вывод программы:
// Исходный массив: [23, 56, 21, 41, 12]
// Отсортированный массив: [12, 21, 23, 41, 56]
public class BubbleSorter {
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] testArray = {64, 34, 25, 12, 22, 11, 90};
        System.out.print("Исходный массив: ");
        printArray(testArray);
        bubbleSort(testArray);
        System.out.print("Отсортированный массив: ");
        printArray(testArray);
    }

    public static void printArray(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) System.out.print(", ");
        }
        System.out.println("]");
    }
}

// Вывод программы:
// Исходный массив: [64, 34, 25, 12, 22, 11, 90]
// Отсортированный массив: [11, 12, 22, 25, 34, 64, 90]
public class InsertionSorter {
    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        int[] testArray = {9, 5, 1, 4, 3};
        System.out.print("Исходный массив: ");
        printArray(testArray);
        insertionSort(testArray);
        System.out.print("Отсортированный массив: ");
        printArray(testArray);
    }

    public static void printArray(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) System.out.print(", ");
        }
        System.out.println("]");
    }
}

// Вывод программы:
// Исходный массив: [9, 5, 1, 4, 3]
// Отсортированный массив: [1, 3, 4, 5, 9]
public class MergeSorter {
    public static void mergeSort(int[] arr) {
        if (arr.length < 2) return;

        int mid = arr.length / 2;
        int[] left = new int[mid];
        int[] right = new int[arr.length - mid];

        System.arraycopy(arr, 0, left, 0, mid);
        System.arraycopy(arr, mid, right, 0, arr.length - mid);

        mergeSort(left);
        mergeSort(right);
        merge(arr, left, right);
    }

    private static void merge(int[] arr, int[] left, int[] right) {
        int i = 0, j = 0, k = 0;

        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
            }
        }

        while (i < left.length) arr[k++] = left[i++];
        while (j < right.length) arr[k++] = right[j++];
    }

    public static void main(String[] args) {
        int[] testArray = {38, 27, 43, 3, 9, 82, 10};
        System.out.print("Исходный массив: ");
        printArray(testArray);
        mergeSort(testArray);
        System.out.print("Отсортированный массив: ");
        printArray(testArray);
    }

    public static void printArray(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) System.out.print(", ");
        }
        System.out.println("]");
    }
}

// Вывод программы:
// Исходный массив: [38, 27, 43, 3, 9, 82, 10]
// Отсортированный массив: [3, 9, 10, 27, 38, 43, 82]
public class ShellSorter {
    public static void shellSort(int[] arr) {
        int n = arr.length;

        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i++) {
                int temp = arr[i];
                int j;
                for (j = i; j >= gap && arr[j - gap] > temp; j -= gap) {
                    arr[j] = arr[j - gap];
                }
                arr[j] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] testArray = {23, 12, 1, 8, 34, 54, 2, 3};
        System.out.print("Исходный массив: ");
        printArray(testArray);
        shellSort(testArray);
        System.out.print("Отсортированный массив: ");
        printArray(testArray);
    }

    public static void printArray(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) System.out.print(", ");
        }
        System.out.println("]");
    }
}

// Вывод программы:
// Исходный массив: [23, 12, 1, 8, 34, 54, 2, 3]
// Отсортированный массив: [1, 2, 3, 8, 12, 23, 34, 54]
public class HeapSorter {
    public static void heapSort(int[] arr) {
        int n = arr.length;

        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);

        for (int i = n - 1; i > 0; i--) {
            swap(arr, 0, i);
            heapify(arr, i, 0);
        }
    }

    private static void heapify(int[] arr, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && arr[left] > arr[largest])
            largest = left;

        if (right < n && arr[right] > arr[largest])
            largest = right;

        if (largest != i) {
            swap(arr, i, largest);
            heapify(arr, n, largest);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] testArray = {4, 10, 3, 5, 1};
        System.out.print("Исходный массив: ");
        printArray(testArray);
        heapSort(testArray);
        System.out.print("Отсортированный массив: ");
        printArray(testArray);
    }

    public static void printArray(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) System.out.print(", ");
        }
        System.out.println("]");
    }
}

// Вывод программы:
// Исходный массив: [4, 10, 3, 5, 1]
// Отсортированный массив: [1, 3, 4, 5, 10]
public class LinearSearch {
    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] testArray = {2, 5, 8, 12, 16, 23, 38, 45};
        int target = 16;
        System.out.print("Массив: ");
        printArray(testArray);
        int result = linearSearch(testArray, target);
        System.out.println("Элемент " + target + " найден на позиции: " + result);
        
        // Дополнительный тест
        target = 100;
        result = linearSearch(testArray, target);
        System.out.println("Элемент " + target + " найден на позиции: " + result);
    }

    public static void printArray(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) System.out.print(", ");
        }
        System.out.println("]");
    }
}

// Вывод программы:
// Массив: [2, 5, 8, 12, 16, 23, 38, 45]
// Элемент 16 найден на позиции: 4
// Элемент 100 найден на позиции: -1
public class BinarySearch {
    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) return mid;
            if (arr[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] testArray = {2, 5, 8, 12, 16, 23, 38, 45, 67, 89};
        int target = 23;
        System.out.print("Массив: ");
        printArray(testArray);
        int result = binarySearch(testArray, target);
        System.out.println("Элемент " + target + " найден на позиции: " + result);
    }

    public static void printArray(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) System.out.print(", ");
        }
        System.out.println("]");
    }
}

// Вывод программы:
// Массив: [2, 5, 8, 12, 16, 23, 38, 45, 67, 89]
// Элемент 23 найден на позиции: 5
public class InterpolationSearch {
    public static int interpolationSearch(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high && target >= arr[low] && target <= arr[high]) {
            if (low == high) {
                if (arr[low] == target) return low;
                return -1;
            }

            int pos = low + ((target - arr[low]) * (high - low)) / (arr[high] - arr[low]);

            if (arr[pos] == target) return pos;
            if (arr[pos] < target) low = pos + 1;
            else high = pos - 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] testArray = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100};
        int target = 60;
        System.out.print("Массив: ");
        printArray(testArray);
        int result = interpolationSearch(testArray, target);
        System.out.println("Элемент " + target + " найден на позиции: " + result);
        
        // Тест с отсутствующим элементом
        target = 55;
        result = interpolationSearch(testArray, target);
        System.out.println("Элемент " + target + " найден на позиции: " + result);
    }

    public static void printArray(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) System.out.print(", ");
        }
        System.out.println("]");
    }
}

// Вывод программы:
// Массив: [10, 20, 30, 40, 50, 60, 70, 80, 90, 100]
// Элемент 60 найден на позиции: 5
// Элемент 55 найден на позиции: -1
public class FibonacciSearch {
    public static int fibonacciSearch(int[] arr, int target) {
        int fibMMm2 = 0;
        int fibMMm1 = 1;
        int fibM = fibMMm2 + fibMMm1;

        while (fibM < arr.length) {
            fibMMm2 = fibMMm1;
            fibMMm1 = fibM;
            fibM = fibMMm2 + fibMMm1;
        }

        int offset = -1;

        while (fibM > 1) {
            int i = Math.min(offset + fibMMm2, arr.length - 1);

            if (arr[i] < target) {
                fibM = fibMMm1;
                fibMMm1 = fibMMm2;
                fibMMm2 = fibM - fibMMm1;
                offset = i;
            } else if (arr[i] > target) {
                fibM = fibMMm2;
                fibMMm1 = fibMMm1 - fibMMm2;
                fibMMm2 = fibM - fibMMm1;
            } else {
                return i;
            }
        }

        if (fibMMm1 == 1 && arr[offset + 1] == target)
            return offset + 1;

        return -1;
    }

    public static void main(String[] args) {
        int[] testArray = {10, 22, 35, 40, 45, 50, 80, 82, 85, 90, 100};
        int target = 85;
        System.out.print("Массив: ");
        printArray(testArray);
        int result = fibonacciSearch(testArray, target);
        System.out.println("Элемент " + target + " найден на позиции: " + result);
        
        // Тест с другим элементом
        target = 35;
        result = fibonacciSearch(testArray, target);
        System.out.println("Элемент " + target + " найден на позиции: " + result);
    }

    public static void printArray(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) System.out.print(", ");
        }
        System.out.println("]");
    }
}

// Вывод программы:
// Массив: [10, 22, 35, 40, 45, 50, 80, 82, 85, 90, 100]
// Элемент 85 найден на позиции: 8
// Элемент 35 найден на позиции: 2
