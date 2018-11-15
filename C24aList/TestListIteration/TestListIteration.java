import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;

public class TestListIteration {
  public static void main(String[] args) {
    TestListIteration app = new TestListIteration();

    final int size = 5;
    final int max = 500;
    ArrayList<Integer> arrayList = (ArrayList<Integer>)app.makeRandomList(new ArrayList<Integer>(), size, max);

    app.useEnhancedForLoopToIterate(arrayList);
    app.useForLoopToIterate(arrayList);
    app.useIteratorToIterate(arrayList);
    app.useListIteratorToIterate(arrayList);


    LinkedList<Integer> linkedList = (LinkedList<Integer>)app.makeRandomList(new LinkedList<Integer>(), size, max);

    app.useEnhancedForLoopToIterate(linkedList);
    app.useForLoopToIterate(linkedList);
    app.useIteratorToIterate(linkedList);
    app.useListIteratorToIterate(linkedList);
  }

  private List<Integer> makeRandomList(List<Integer> list, int size, int max) {
    Random rng = new Random();
    for (int i=0; i<size; i++) {
      list.add(rng.nextInt(max));
    }
    return list;
  }

  private void useEnhancedForLoopToIterate(List<Integer> list) {
    for (Integer i: list) {
      System.out.println(i);
    }
  }

  private void useForLoopToIterate(List<Integer> list) {
    for (int i=0; i<list.size(); i++) {
      System.out.println("list[" + i + "] = " + list.get(i));
    }
  }

  private void useIteratorToIterate(List<Integer> list) {
    Iterator<Integer> iter = list.iterator();
    while (iter.hasNext()) {
      System.out.println(iter.next());
    }
  }

  private void useListIteratorToIterate(List<Integer> list) {
    ListIterator<Integer> iter = list.listIterator(list.size());
    while (iter.hasPrevious()) {
      System.out.println(iter.previousIndex());
      iter.previous();
    }
  }
}
