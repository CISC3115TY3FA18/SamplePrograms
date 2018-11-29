
/**
 * This example is from Chapter 21 in
 *   Liang Y Daniel, Introduction to Java Programming, 11st Edition
 */


import java.util.Set;
import java.util.TreeSet;

public class TestTreeSetWithComparator {
  public static void main(String[] args) {
    // Create a tree set for geometric objects using a comparator
    Set<Shape> set =
      new TreeSet<Shape>(new ShapeComparator());
    set.add(new Rectangle("c1", 4, 5));
    set.add(new Circle("c1", 40));
    set.add(new Circle("c2", 40));
    set.add(new Rectangle("r2", 4, 1));

    // Display geometric objects in the tree set
    System.out.println("A sorted set of geometric objects");
    for (Shape element: set) {
      System.out.println("area = " + element.getArea());
    }
  }
}
