import java.util.Comparator;

public class ShapeComparator implements Comparator<Object> {
  public int compare(Object lhs, Object rhs) {
    return Double.compare(((Shape)lhs).getArea(), ((Shape)rhs).getArea());
  }
}
