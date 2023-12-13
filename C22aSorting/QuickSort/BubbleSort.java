public class BubbleSort {
  /** Sort an array of comparable objects using the Bubble sort algorithm */
  public static void sort(int[] list) {
    // select subarray (the range of the array) where we bubble up the greatest in the subarray
    for (int i = 0; i < list.length - 1; i++) {
      // bubble up the greast in the subarray (in the range of the array)
      for (int j=0; j <list.length - i - 1; j++) {
        if (list[j] > list[j+1]) {
          int tmp = list[j];
          list[j] = list[j+1];
          list[j+1] = tmp;
        }
      }
    }
  }
}
