import java.util.Comparator;

public class ShapeComparator implements Comparator<Shape> {
  public int compare(Shape lhs, Shape rhs) {
    return Double.compare(lhs.getArea(), rhs.getArea());
  }
}
