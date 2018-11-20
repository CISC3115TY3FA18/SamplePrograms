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

    List<Shape> list = new LinkedList<Shape>();
    list.add(c1);
    list.add(c2);
    list.add(r1);
    list.add(c3);
    sortDemo(list);



    ComparableRectangle r1b = new ComparableRectangle("r1", 1.0, 2.0);
    ComparableRectangle r2b = new ComparableRectangle("r1", 1.0, 1.0);

    List<ComparableRectangle> listb = new LinkedList<ComparableRectangle>();
    listb.add(r1b);
    listb.add(r2b);
    sortDemoToo(listb);

  }

  public static void sortDemo(List<Shape> list) {
    Collections.sort(list, new ShapeComparator());
    Shape keyObject = new Rectangle("r3", 1.0, 2.0);
    int i = Collections.binarySearch(list, keyObject, new ShapeComparator());
    System.out.println(i);
  }

  public static void sortDemoToo(List<ComparableRectangle> list) {
    Collections.sort(list);
  }

}
