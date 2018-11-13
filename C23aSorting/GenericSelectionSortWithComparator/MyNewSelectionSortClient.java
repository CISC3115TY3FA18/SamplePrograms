public class MyNewSelectionSortClient {
  public static void main(String[] args) {
    SelectionSort sorter = new SelectionSort<Integer>();
    Integer[] intObjs = {Integer.valueOf(1), Integer.valueOf(9)};
    sorter.sort(intObjs, new GenericComparator<Integer>());
  }
}
