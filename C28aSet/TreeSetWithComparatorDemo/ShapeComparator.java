import java.util.Comparator;

public class ShapeComparator implements Comparator<Shape> {
  public int compare(Shape lhs, Shape rhs) {
    if (lhs.getArea() > rhs.getArea()) {
      return 1;
    } else if (lhs.getArea() < rhs.getArea()) {
      return -1;
    } else {
      return 0;
    }
  }
}
