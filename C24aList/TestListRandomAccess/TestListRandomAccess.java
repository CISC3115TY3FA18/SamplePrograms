import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

public class TestListRandomAccess {
  public static void main(String[] args) {
    final int max = 5000000;
    final int size = 1000000;
    final int maxTimes = 1000;

    TestListRandomAccess app = new TestListRandomAccess();

    ArrayList<Integer> intArrayList = app.makeRandomIntegerArrayList(size, max);
    app.testRandomAccess(intArrayList, maxTimes);

    System.out.println("----------------------------");

    LinkedList<Integer> intLinkedList = app.makeRandomIntegerLinkedList(size, max);
    app.testRandomAccess(intLinkedList, maxTimes);
  }

  /**
   * the following two testRandomAccess methods are almost identical, except one
   * takes an ArrayList and the other LinkedList as a parameter. Observing the
   * Java Collection Framework type hierarchy, can we write one single generic
   * method instead?
   */
  private <T> void testRandomAccess(ArrayList<T> arrayList, int maxTimes) {
    // access first, middle, and last element many times, measure average access times
    long startTime = System.nanoTime();
    for (int i=0; i<maxTimes; i++) {
      T t = arrayList.get(0);
    }
    long endTime = System.nanoTime();
    System.out.println("Access first in ArrayList: " + ((double)(endTime - startTime)/(double)maxTimes));

    startTime = System.nanoTime();
    int middle = arrayList.size() / 2;
    for (int i=0; i<maxTimes; i++) {
      T t = arrayList.get(middle);
    }
    endTime = System.nanoTime();
    System.out.println("Access middle in ArrayList: " + ((double)(endTime - startTime)/(double)maxTimes));

    startTime = System.nanoTime();
    int last = arrayList.size()-1;
    for (int i=0; i<maxTimes; i++) {
      T t = arrayList.get(last);
    }
    endTime = System.nanoTime();
    System.out.println("Access last in ArrayList: " + ((double)(endTime - startTime)/(double)maxTimes));

    startTime = System.nanoTime();
    Random rng = new Random();
    for (int i=0; i<maxTimes; i++) {
      T t = arrayList.get(rng.nextInt(arrayList.size()));
    }
    endTime = System.nanoTime();
    System.out.println("Random access in ArrayList: " + ((double)(endTime - startTime)/(double)maxTimes));
  }

  private <T> void testRandomAccess(LinkedList<T> linkedList, int maxTimes) {
    // access first, middle, and last element many times, measure average access times
    long startTime = System.nanoTime();
    for (int i=0; i<maxTimes; i++) {
      T t = linkedList.get(0);
    }
    long endTime = System.nanoTime();
    System.out.println("Access first in LinkedList: " + ((double)(endTime - startTime)/(double)maxTimes));

    startTime = System.nanoTime();
    int middle = linkedList.size() / 2;
    for (int i=0; i<maxTimes; i++) {
      T t = linkedList.get(middle);
    }
    endTime = System.nanoTime();
    System.out.println("Access middle in LinkedList: " + ((double)(endTime - startTime)/(double)maxTimes));

    startTime = System.nanoTime();
    int last = linkedList.size()-1;
    for (int i=0; i<maxTimes; i++) {
      T t = linkedList.get(last);
    }
    endTime = System.nanoTime();
    System.out.println("Access last in LinkedList: " + ((double)(endTime - startTime)/(double)maxTimes));

    startTime = System.nanoTime();
    Random rng = new Random();
    for (int i=0; i<maxTimes; i++) {
      T t = linkedList.get(rng.nextInt(linkedList.size()));
    }
    endTime = System.nanoTime();
    System.out.println("Random access in LinkedList: " + ((double)(endTime - startTime)/(double)maxTimes));
  }

  private ArrayList<Integer> makeRandomIntegerArrayList(int size, int max) {
    Random rng = new Random();

    ArrayList<Integer> intList = new ArrayList<Integer>();

    for (int i=0; i<size; i++) {
      intList.add(rng.nextInt(max));
    }

    return intList;
  }

  private LinkedList<Integer> makeRandomIntegerLinkedList(int size, int max) {
    Random rng = new Random();

    LinkedList<Integer> intList = new LinkedList<Integer>();

    for (int i=0; i<size; i++) {
      intList.add(rng.nextInt(max));
    }

    return intList;
  }


  /**
   * One generic method taking advantage of Java Collection Framework type hierarchy
   */
   private <T> void testRandomAccess(List<T> list, int maxTimes) {
     // access first, middle, and last element many times, measure average access times
     long startTime = System.nanoTime();
     for (int i=0; i<maxTimes; i++) {
       T t = list.get(0);
     }
     long endTime = System.nanoTime();
     System.out.println("Access first in " + list.getClass().getName() + ": " + ((double)(endTime - startTime)/(double)maxTimes));

     startTime = System.nanoTime();
     int middle = list.size() / 2;
     for (int i=0; i<maxTimes; i++) {
       T t = list.get(middle);
     }
     endTime = System.nanoTime();
     System.out.println("Access middle in " + list.getClass().getName() + ": " + ((double)(endTime - startTime)/(double)maxTimes));

     startTime = System.nanoTime();
     int last = list.size()-1;
     for (int i=0; i<maxTimes; i++) {
       T t = list.get(last);
     }
     endTime = System.nanoTime();
     System.out.println("Access last in " + list.getClass().getName() + ": " + ((double)(endTime - startTime)/(double)maxTimes));

     startTime = System.nanoTime();
     Random rng = new Random();
     for (int i=0; i<maxTimes; i++) {
       T t = list.get(rng.nextInt(list.size()));
     }
     endTime = System.nanoTime();
     System.out.println("Random access in " + list.getClass().getName() + ": "+ ((double)(endTime - startTime)/(double)maxTimes));
   }
}
