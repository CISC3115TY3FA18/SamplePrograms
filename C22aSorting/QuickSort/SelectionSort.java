public class SelectionSort {
  public static void sort(int[] numbers) {
    // write a helper function/method that can be decomposed recursively into subproblems
    sort(numbers, 0);
  }

  // Subproblem 1
  private static void swapSmallest(int[] numbers, int startIndex) {
    int minimum = numbers[startIndex];
    int minIndex = startIndex;
    // find the minimum
    for (int i=startIndex+1; i<numbers.length; i++) {
      // Question: does it matter if we change "<" to "<="?
      if (numbers[i] < minimum) {
        minimum = numbers[i];
        minIndex = i;
      }
    }

    // swap the minimum and the first
    if (startIndex != minIndex) {
      int tmp = numbers[startIndex];
      numbers[startIndex] = numbers[minIndex];
      numbers[minIndex] = tmp;
    }
  }

  // Subproblem 2
  private static void sort(int[] numbers, int startIndex) {
    /* divide the problem into subproblem
     * 1. find the smallest from the numbers, and exchange it with the very first
     *    number in the array.
     * 2. (recursion) sort the subarray, i.e., the array excluding the first element
     *    base case: the size of the array down to 0 (or 1?)
     */
     if ((numbers.length - 1) - startIndex == 0) return; // base case

     swapSmallest(numbers, startIndex);
     sort(numbers, startIndex + 1);
  }
}
