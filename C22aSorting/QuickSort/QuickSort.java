public class QuickSort {
  public static void sort(int[] numbers) {
    sort(numbers, 0, numbers.length - 1);
  }

  public static void sort(int[] numbers, int beginIndex, int endIndex) {
    // base case: if the array is of length 0 or 1
    if (endIndex - beginIndex <= 0) return;

    int pivotIndex = beginIndex; // pick a pivot, does it matter how we pick a pivot

    // subproblem 1: divide the array/list into two partitions, one is less than or equal to
    // pivot, the other is greater than the pivot, after which, we have a new index for
    // pivot
    pivotIndex = partition(numbers, beginIndex, endIndex, pivotIndex);

    // subproblem 2: sort the two halves.
    sort(numbers, beginIndex, pivotIndex - 1);
    sort(numbers, pivotIndex + 1, endIndex);
  }


  private static int partition(int[] numbers, int beginIndex, int endIndex, int pivotIndex) {
    // make sure pivot is moved to the very end
    swap(numbers, endIndex, pivotIndex);
    pivotIndex = endIndex;

    int lastIndexOfLowerHalf = beginIndex - 1;
    for (int i=beginIndex; i<endIndex; i++) {
      if (numbers[i] <= numbers[pivotIndex]) {
        lastIndexOfLowerHalf ++;
        swap(numbers, lastIndexOfLowerHalf, i);
      }
    }

    // move the pivot to the middle of the two partitions
    lastIndexOfLowerHalf ++;
    swap(numbers, lastIndexOfLowerHalf, pivotIndex);
    pivotIndex = lastIndexOfLowerHalf;
    return pivotIndex;
  }


  private static void swap(int[] numbers, int i, int j) {
    int tmp = numbers[i];
    numbers[i] = numbers[j];
    numbers[j] = tmp;
  }
}
