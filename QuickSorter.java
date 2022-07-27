public class QuickSorter {
    public static void main(String args[]) {
        int[] testValues = {
         12,9,4,99,120,1,3,10,23,45,75,69,31,88,101,14,29,91,2,0,77
        };
        System.out.print("Input:\t");
        for (int i = 0; i < testValues.length; i++) {
            System.out.print(testValues[i] + " ");
        }
        System.out.println();
        System.out.println();
        QuickSorter sorter = new QuickSorter(5);
        sorter.quicksort(testValues);
        System.out.print("Output:\t");
        for (int i = 0; i < testValues.length; i++) {
            System.out.print(testValues[i] + " ");
        }
    }
    public void quicksort(int[] array) {
        partialQuicksort(array);
        insertionsort(array);
        reportExchanges();
    }
    private void partialQuicksort(int[] array) {
        partialQuicksort(array, 0, array.length - 1);
    }
    private void partialQuicksort(int[] array, int left, int right) {
        int pivot = partition(array, left, right);
        if ((pivot - left) > optimalPartitionSize) partialQuicksort(array, left, pivot - 1);
        if ((right - pivot) > optimalPartitionSize) partialQuicksort(array, pivot + 1,
            right);
    }
    private int partition(int[] array, int left, int right) {
        int pivot = findPivot(array, left, right); // see findPivot
        swap(array, pivot, right);
        pivot = right;
        right--;
        while (left < right) {
            while (array[left] < array[pivot]) left++;
            while ((right != left) && (array[right] > array[pivot])) right--;
            swap(array, left, right);
        }
        swap(array, pivot, right);
        return left;
    }
    private int findPivot(int[] array, int left, int right) {
        int pivot = (left + right) / 2;
        if (array[left] >= array[pivot] && array[left] <= array[right] ||
            array[left] >= array[right] && array[left] <= array[pivot]) {
            pivot = left;
        } else if (array[left] >= array[pivot] && array[left] <= array[right] ||
            array[left] >= array[right] && array[left] <= array[pivot]) {
            pivot = right;
        }
        return pivot;
    }
    private void swap(int[] array, int indexOne, int indexTwo) {
        int temp = array[indexOne];
        array[indexOne] = array[indexTwo];
        array[indexTwo] = temp;
        exchanges++;
    }
    public QuickSorter(int optimalPartionSize) {
        this.optimalPartitionSize = optimalPartionSize;
        this.exchanges = 0;
    }
    private void insertionsort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            for (int j = i;
                (j > 0) && array[j] < array[j - 1]; j--) {
                swap(array, j, j - 1);
            }
        }
    }
    private void reportExchanges() {
        System.out.println("Exchange Number When Sorting is: " + exchanges);
        exchanges = 0;
    }
    public QuickSorter() {
        this(9);
    }
    int optimalPartitionSize;
    int exchanges;
}