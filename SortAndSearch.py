# Сортировка вставками (Insertion Sort)
class InsertionSort:
    @staticmethod
    def sort(arr):
        """
        Сортировка вставками
        Сложность: O(n²) в худшем случае, O(n) в лучшем случае
        """
        for i in range(1, len(arr)):
            key = arr[i]
            j = i - 1
            
            # Сдвигаем элементы больше key вправо
            while j >= 0 and arr[j] > key:
                arr[j + 1] = arr[j]
                j -= 1
            arr[j + 1] = key
    
    @staticmethod
    def main():
        test_array = [15, 8, 42, 4, 23, 16]
        print("Исходный массив:", InsertionSort._print_array(test_array))
        InsertionSort.sort(test_array)
        print("Отсортированный массив:", InsertionSort._print_array(test_array))
    
    @staticmethod
    def _print_array(arr):
        return "[" + ", ".join(map(str, arr)) + "]"

if __name__ == "__main__":
    InsertionSort.main()


#=========================================
# Быстрая сортировка (Quick Sort)
class QuickSort:
    @staticmethod
    def sort(arr):
        """
        Быстрая сортировка
        Сложность: O(n log n) в среднем, O(n²) в худшем случае
        """
        QuickSort._quick_sort(arr, 0, len(arr) - 1)
    
    @staticmethod
    def _quick_sort(arr, low, high):
        if low < high:
            # Индекс разделения
            pi = QuickSort._partition(arr, low, high)
            # Рекурсивно сортируем элементы до и после разделения
            QuickSort._quick_sort(arr, low, pi - 1)
            QuickSort._quick_sort(arr, pi + 1, high)
    
    @staticmethod
    def _partition(arr, low, high):
        # Опорный элемент (pivot)
        pivot = arr[high]
        i = low - 1  # Индекс меньшего элемента
        
        for j in range(low, high):
            if arr[j] < pivot:
                i += 1
                QuickSort._swap(arr, i, j)
        
        QuickSort._swap(arr, i + 1, high)
        return i + 1
    
    @staticmethod
    def _swap(arr, i, j):
        arr[i], arr[j] = arr[j], arr[i]
    
    @staticmethod
    def main():
        test_array = [24, 15, 38, 2, 19, 41, 8]
        print("Исходный массив:", QuickSort._print_array(test_array))
        QuickSort.sort(test_array)
        print("Отсортированный массив:", QuickSort._print_array(test_array))
    
    @staticmethod
    def _print_array(arr):
        return "[" + ", ".join(map(str, arr)) + "]"

if __name__ == "__main__":
    QuickSort.main()


#=========================================
# Бинарный поиск (Binary Search)
class BinarySearch:
    @staticmethod
    def search(arr, target):
        """
        Бинарный поиск
        Сложность: O(log n)
        Требует отсортированный массив
        """
        left = 0
        right = len(arr) - 1
        
        while left <= right:
            mid = left + (right - left) // 2
            
            if arr[mid] == target:
                return mid
            elif arr[mid] < target:
                left = mid + 1
            else:
                right = mid - 1
        return -1
    
    @staticmethod
    def main():
        test_array = [3, 7, 14, 21, 29, 33, 42, 55, 67, 78]
        targets = [29, 7, 100, 42]
        
        print("Отсортированный массив:", BinarySearch._print_array(test_array))
        print()
        
        for target in targets:
            result = BinarySearch.search(test_array, target)
            if result != -1:
                print(f"Элемент {target} найден на позиции: {result}")
            else:
                print(f"Элемент {target} не найден в массиве")
    
    @staticmethod
    def _print_array(arr):
        return "[" + ", ".join(map(str, arr)) + "]"

if __name__ == "__main__":
    BinarySearch.main()


#=========================================
# Демонстрация всех алгоритмов
class AlgorithmDemo:
    @staticmethod
    def demo_all():
        print("=" * 50)
        print("ДЕМОНСТРАЦИЯ АЛГОРИТМОВ СОРТИРОВКИ И ПОИСКА")
        print("=" * 50)
        
        # Демонстрация сортировки вставками
        print("\n1. СОРТИРОВКА ВСТАВКАМИ")
        arr1 = [15, 8, 42, 4, 23, 16]
        print(f"До сортировки: {arr1}")
        InsertionSort.sort(arr1)
        print(f"После сортировки: {arr1}")
        
        # Демонстрация быстрой сортировки
        print("\n2. БЫСТРАЯ СОРТИРОВКА")
        arr2 = [24, 15, 38, 2, 19, 41, 8]
        print(f"До сортировки: {arr2}")
        QuickSort.sort(arr2)
        print(f"После сортировки: {arr2}")
        
        # Демонстрация бинарного поиска
        print("\n3. БИНАРНЫЙ ПОИСК")
        sorted_array = [3, 7, 14, 21, 29, 33, 42, 55, 67, 78]
        print(f"Отсортированный массив: {sorted_array}")
        
        search_values = [29, 55, 100]
        for value in search_values:
            index = BinarySearch.search(sorted_array, value)
            if index != -1:
                print(f"Элемент {value} найден на позиции {index}")
            else:
                print(f"Элемент {value} не найден")

if __name__ == "__main__":
    AlgorithmDemo.demo_all()
