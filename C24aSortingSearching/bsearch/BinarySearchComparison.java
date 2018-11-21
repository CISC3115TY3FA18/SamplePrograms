import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.LinkedList;
import java.util.Random;


/**
 * Java API documentation states,
 * " This [binarySearch] method runs in log(n) time for a "random access" list
 *   (which provides near-constant-time positional access). If the specified list
 *   does not implement the RandomAccess interface and is large, this method will
 *   do an iterator-based binary search that performs O(n) link traversals and
 *   O(log n) element comparisons."
 */
public class BinarySearchComparison {
  public static void main(String[] args) {
    final int numElements = 1000000;
    final int maxInteger = 5000000;
    final int numTimes = 1000;

    List<Integer> intArrayList = new ArrayList<Integer>();
    makeRandomIntegerList(intArrayList, numElements, maxInteger);
    doManyBinarySearches(intArrayList, maxInteger, numTimes);

    List<Integer> intLinkedList = new LinkedList<Integer>();
    makeRandomIntegerList(intLinkedList, numElements, maxInteger);
    doManyBinarySearches(intLinkedList, maxInteger, numTimes);

  }


  private static void doManyBinarySearches(List<Integer> list, int max, int numTimes) {
    Collections.sort(list);
    Random rng = new Random();

    long beginTime = System.nanoTime();
    for (int i=0; i<numTimes; i++) {
      int key = rng.nextInt(max);
      Collections.binarySearch(list, key);
    }

    long endTime = System.nanoTime();

    System.out.println("Binary search on a " +
      list.getClass().getName() + " takes " + (endTime - beginTime));
  }

  private static List<Integer> makeRandomIntegerList(List<Integer> list, int numElements, int max) {
    if (list == null) {
      throw new IllegalArgumentException("List list is null");
    }
    Random rng = new Random();
    for (int i=0; i<numElements; i++) {
      list.add(rng.nextInt(max));
    }
    return list;
  }
}
