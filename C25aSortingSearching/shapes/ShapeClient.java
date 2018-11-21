import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.LinkedList;

public class ShapeClient {
  public static void main(String[] args) {
    Shape c1 = new Circle("c1", 5.0);
    Shape c2 = new Circle("c2", 10.0);
    Shape r1 = new Rectangle("r1", 1.0, 2.0);
    Shape c3 = new  Circle("c3", 2.0);

    List<Shape> listUncomparable = new LinkedList<Shape>();
    listUncomparable.add(c1);
    listUncomparable.add(c2);
    listUncomparable.add(r1);
    listUncomparable.add(c3);

    // demonstrating Collections::sort using a Comparator
    sortAndSearchWithComparator(listUncomparable);

    ComparableShape r2 = new ComparableRectangle("r2", 4.0, 3.0);
    ComparableShape r3 = new ComparableRectangle("r3", 2.0, 4.0);
    ComparableShape r4 = new ComparableRectangle("r4", 1.0, 2.0);
    ComparableShape r5 = new ComparableRectangle("r5", 1.0, 1.0);
    ComparableShape c4 = new ComparableCircle("c4", 6.0);

    List<ComparableShape> listComparable = new LinkedList<ComparableShape>();
    listComparable.add(r2);
    listComparable.add(r3);
    listComparable.add(r4);
    listComparable.add(r5);
    listComparable.add(c4);
    sortAndSearchWithComparable(listComparable);

  }

  public static void sortAndSearchWithComparator(List<Shape> list) {
    System.out.println("In sortAndSearchWithComparator: ");
    Collections.sort(list, new ShapeComparator());

    Shape keyObject = new Rectangle("r3", 1.0, 2.0);
    int i = Collections.binarySearch(list, keyObject, new ShapeComparator());
    System.out.println("Found the object at index " + i);
  }

  public static void sortAndSearchWithComparable(List<ComparableShape> list) {
    System.out.println("In sortAndSearchWithComparable: ");
    Collections.sort(list);

    ComparableShape keyObject = new ComparableRectangle("r3", 1.0, 2.0);
    int i = Collections.binarySearch(list, keyObject);
    System.out.println("Found the object at index " + i);
  }
}
